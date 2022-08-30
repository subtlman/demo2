package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (public."user")表控制层
 *
 * @author xxxxx
 */
@RestController
@RequestMapping("/public")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserServiceImpl userServiceImpl;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne/{value}")
    public User selectOne(@Param("id") Integer id) {
        System.out.println(userServiceImpl.selectByPrimaryKey(id).toString());
        return userServiceImpl.selectByPrimaryKey(id);
    }


}
