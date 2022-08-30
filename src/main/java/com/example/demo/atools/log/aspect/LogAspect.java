package com.example.demo.atools.log.aspect;

import com.alibaba.fastjson.JSON;
import com.example.demo.atools.log.filter.LogFilter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 打印接口入参信息
 */
@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * pom文件引入：
     *         <dependency>
     *             <groupId>org.springframework.boot</groupId>
     *             <artifactId>spring-boot-starter-aop</artifactId>
     *         </dependency>
     * 使用方式：
     * 在所需打印的接口方法上添加 @Log
     */

    /**
     *  层切点
     */
    @Pointcut("@annotation(log)")
    public void controllerAspect(Log log) {
    }

    @After("controllerAspect(log)")
    public void after(JoinPoint pjp, Log log)  {
        //获取所有参数包括body和Parameter TODO
        logger.info("Request Args   : {}", JSON.toJSONString(pjp.getArgs()));
    }
}
