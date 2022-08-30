package com.example.demo.atools.log.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2020/09/09/9:22
 * @Description: 监听器
 */
@WebListener
@Component
public class OnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    Logger logger = LoggerFactory.getLogger(OnlineListener.class);

    public static int online = 0;

    public OnlineListener() {}

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("监听器初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("监听器销毁");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("session被创建");
        online++;
        logger.info("调用该服务在线人数："+online);
        //5s不刷新之后，sessionDestroyed就会被自动调用了
        se.getSession().setMaxInactiveInterval(5);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("session被销毁");
        online--;
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {}

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {}

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {}
}

