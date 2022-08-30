package com.example.demo.controller;
import com.example.demo.domain.Person;
import com.example.demo.service.impl.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* (public.person)表控制层
*
* @author xxxxx
*/
@RestController
@RequestMapping("/public.person")
public class PersonController {
/**
* 服务对象
*/
@Resource
private PersonServiceImpl personServiceImpl;

/**
* 通过主键查询单条数据
*
* @param id 主键
* @return 单条数据
*/
@GetMapping("selectOne")
public Person selectOne(Integer id) {
    System.out.println(personServiceImpl.selectt());
    return personServiceImpl.selectByPrimaryKey(id);
}

}
