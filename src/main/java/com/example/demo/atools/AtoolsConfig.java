package com.example.demo.atools;

import java.util.Arrays;
import java.util.List;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: atools工具包的配置说明类
 */
public class AtoolsConfig {

    /**
     * 介绍：
     * config：bean、swagger
     * log-aspect：切面实现接口方法参数信息的输出 （接口方法上添加 @Log）
     * log-filter：过滤器实现请求地址、请求类型、响应地址、响应内容的日志输出
     * log-interceptor：拦截器对请求选择性的拦截并做出对应的处理
     * log-listener：监听器对项目调用session数做监控
     * resp：异常实体类、封装异常返回、规范响应内容
     * 使用：
     * 当作工具类使用并在下面代码进行配置；
     * 接口层样例，其它类比或自行读码：
     *     @GetMapping("/api/demo")
     *     @Log
     *     public ServiceResp demo() {
     *         ServiceResp resp = new ServiceResp();
     *         resp.success(" 样例");
     *         return resp;
     *     }
     *
     *     @GetMapping("/api/demo2")
     *     @Log
     *     public ServiceResp demo2(@RequestParam String param) {
     *         ServiceResp resp = new ServiceResp();
     *         resp.success(" 样例2");
     *         int i=1/0;
     *         return resp;
     *     }
     *
     *     @GetMapping("/api/demo3")
     *     @Log
     *     public ServiceResp demo3(@RequestParam String param) {
     *         ServiceResp resp = new ServiceResp();
     *         resp.success(" 样例3");
     *         try {
     *             int i=1/0;
     *         } catch (Exception e) {
     *             return MyHandlerExceptionResolver.formatException(e);
     *         }
     *         return resp;
     *     }
     *
     */

    //配置Swagger
    public static String packageName = "com.example.demo.controller";
    public static String titleName = "demo";
    public static String descriptionName = "demo接口服务";

    //配置LogFilter
    public static String atoolsName = "com.example.demo.atools";
    //这里设置不被过滤的请求路径，采用当且仅当此字符串包含指定的char值序列方法
    public static List<String> unFilterUrlList = Arrays.asList(
            "/api/error/exthrow",
            "/webctdfs/file",
            "/v2",
            "/webjars",
            "/doc",
            "/favicon",
            "/example",
            "/null",
            "/swagger");

    //其它配置项，如：设置拦截路径


}
