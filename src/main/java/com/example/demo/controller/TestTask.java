package com.example.demo.controller;

import com.example.demo.atools.config.AutoBean;
import com.example.demo.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author xu fei
 * @date 2021年09月06日 17:47
 */

@Component
public class TestTask {

    private Logger logger = LoggerFactory.getLogger(TestTask.class);

    private final PersonService personService= AutoBean.getBean(PersonService.class);

//    @Scheduled(cron = "0/5 * * * * ? " )
    public void getPointData(){

        System.out.println(personService.selectByPrimaryKey(2));

    }

}
