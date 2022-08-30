package com.example.demo.atools.resp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 返回过滤器抛出的异常给到调用方 Returns the exception thrown by the filter to the caller
 */
@RestController
@RequestMapping("/api/error")
public class CustomizeExceptionController {

    /**
     * 处理过滤器抛出的异常
     * Handling exceptions thrown by filters
     */
    @RequestMapping("/filter")
    public ServiceResp rethrow(HttpServletRequest request) {
        try {
            throw ((Exception) request.getAttribute("filter.error"));
        } catch (Exception e) {
            return MyHandlerExceptionResolver.formatException(e);
        }
    }

}
