package com.example.demo.atools.log.filter;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.util.List;

import static com.example.demo.atools.AtoolsConfig.atoolsName;
import static com.example.demo.atools.AtoolsConfig.unFilterUrlList;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 借助过滤器操作日志 Operation log with filter
 */
@Order(1)
@Component
public class LogFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(LogFilter.class);

    /**
     * 判断请求路径是否为不过滤的请求路径
     */
    private boolean isFilter(String url, List<String> unFilterUrlList) {
        for (String s : unFilterUrlList) {
            if (url.contains(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletResponse httpServletResponse = null;
        HttpServletRequest httpServletRequest = null;
        ResponseWrapper wrapperResponse = null;
        RequestWrapper requestWrapper = null;
        ServletOutputStream out = null;
        long before = System.currentTimeMillis();
        try {
            httpServletResponse = (HttpServletResponse) servletResponse;
            httpServletRequest = (HttpServletRequest) servletRequest;

            if (isFilter(httpServletRequest.getRequestURL().toString(), unFilterUrlList)) {
                logger.info(httpServletRequest.getRequestURL().toString() + " : 该请求不过滤 ");
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            //转换成代理类
            wrapperResponse = new ResponseWrapper(httpServletResponse);
            requestWrapper = new RequestWrapper(httpServletRequest);

            // 打印请求相关参数
            logger.info("========================================== Start ==========================================");
            logger.info("URL            : {}", httpServletRequest.getRequestURL().toString());
            logger.info("HTTP Method    : {}", httpServletRequest.getMethod());
            String visitIp = httpServletRequest.getRemoteAddr();
            visitIp = "0:0:0:0:0:0:0:1".equals(visitIp) ? "127.0.0.1" : visitIp;
            logger.info("IP             : {}", visitIp);

            filterChain.doFilter(requestWrapper, wrapperResponse);
            //每个请求之间空一行
            logger.info("=========================================== Response ======================================");
            //获取返回值
            byte[] content = wrapperResponse.getContent();
            String contentType = wrapperResponse.getContentType();
            String respDate = null;

            // 打印出参
            if (contentType != null && !contentType.contains("octet-stream")) {
                respDate = JSON.toJSON(new String(content)).toString();
                logger.info("Response Args  : {}", respDate);
            }
            logger.info("URL            : {}", httpServletRequest.getRequestURL().toString());
            logger.info("Time-Consuming : {} ms", System.currentTimeMillis() - before);
            logger.info("=========================================== End ===========================================");
            //把返回值输出到客户端
            out = httpServletResponse.getOutputStream();
            out.write(content);
            out.flush();
        } catch (Exception e) {
            servletRequest.setAttribute("filter.error", e);
            try {
                servletRequest.getRequestDispatcher("/api/error/filter").forward(servletRequest, servletResponse);
            } catch (Exception ex) {
                logger.info(atoolsName + ".log.LogFilter执行.forward出错：" + ex);
                ex.printStackTrace();
            }
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    logger.info(atoolsName + ".log.LogFilter执行out.close()出错：" + e);
                    e.printStackTrace();
                }
            }
        }
    }
}

class ResponseWrapper extends HttpServletResponseWrapper {

    private final ByteArrayOutputStream buffer;

    private final ServletOutputStream out;

    public ResponseWrapper(HttpServletResponse httpServletResponse) {
        super(httpServletResponse);
        buffer = new ByteArrayOutputStream();
        out = new WrapperOutputStream(buffer);
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return out;
    }

    @Override
    public void flushBuffer() throws IOException {
        if (out != null) {
            out.flush();
        }
    }

    public byte[] getContent() throws IOException {
        flushBuffer();
        return buffer.toByteArray();
    }

    static class WrapperOutputStream extends ServletOutputStream {
        private final ByteArrayOutputStream bos;

        public WrapperOutputStream(ByteArrayOutputStream bos) {
            this.bos = bos;
        }

        @Override
        public void write(int b) throws IOException {
            bos.write(b);
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener arg0) {
        }
    }

}

class RequestWrapper extends HttpServletRequestWrapper{

    //用于将流保存下来
    private byte[] requestBody=null;

    public RequestWrapper(HttpServletRequest request) {
        super(request);
        try {
            requestBody= StreamUtils.copyToByteArray(request.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException{
        if(requestBody==null) {
            requestBody=new byte[0];
        }
        final ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }

            @Override
            public void setReadListener(ReadListener listener) {
                // do nothing
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public boolean isFinished() {
                return false;
            }
        };
    }

    @Override
    public BufferedReader getReader() throws IOException{
        //对外提供读取流的方法
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

}


/**
 * 过滤器和swagger同时使用的时候报错：
 * No qualifying bean of type ‘XX‘ available: expected single matching bean but found 2: XX,XX
 * 第一种办法：项目中用其中一方，注释掉swagger或过滤器即可以正常使用，不适用项目，舍弃。
 * 第二种办法：参考 https://blog.csdn.net/weixin_44251773/article/details/119671918?spm=1001.2101.3001.6650.1&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-119671918-blog-92637119.pc_relevant_multi_platform_featuressortv2dupreplace&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7ERate-1-119671918-blog-92637119.pc_relevant_multi_platform_featuressortv2dupreplace&utm_relevant_index=2
 * 发现问题：一个父类被工厂使用，但实际上不应该使用该父类而是使用父类的具体子类。
 * 解决方案：新建一个空类继承该父类，由工厂使用该空类。
 * MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping
 * 工厂调用
 * AutoBean.getBean(MyRequestMappingHandlerMapping.class)
 */
@Component
@Lazy(true)
class MyRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
}