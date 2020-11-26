package com.frame.springcloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyController {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public Object test(){
        return "test";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_USER')")  //注解验证时默认加上前缀ROLE_，原因后面文章再讲
    public Object user(){
        return "user";
    }

    @RequestMapping(value = "/user/a",method = RequestMethod.GET)
    public Object user2(){
        return "user";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public Object admin(){
        return "admin";
    }

    @RequestMapping(value = "/admin/b",method = RequestMethod.GET)
    public Object admin2(){
        return "admin";
    }
}
