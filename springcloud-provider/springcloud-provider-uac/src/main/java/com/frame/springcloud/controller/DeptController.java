package com.frame.springcloud.controller;

import com.frame.springcloud.pojo.Dept;
import com.frame.springcloud.pojo.User;
import com.frame.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Autowired
    public DeptService deptService;


    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("id=>"+id+",不存在该用户，或信息无法找到");
        }
        return dept;
    }

    //备选方案
    public Dept hystrixGet(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+"没有对应的信息,null--@hystrix")
                .setDbSource("no this database in mysql");
    }

    @GetMapping(value = "/r1")
    public String r1(HttpServletRequest request){
        //获取用户身份信息
        //Spring框架借助ThreadLocal来保存和传递用户登录信息。我们通常是使用下面这段代码，来获取保存在ThreadLocal中的用户信息
        String token = request.getHeader("Authorization"); //从头部信息中获取token
        System.out.println(token);
        return "访问资源1";
    }

    @GetMapping(value = "/r2")
    public String r2(){
        //获取用户身份信息
        //Spring框架借助ThreadLocal来保存和传递用户登录信息。我们通常是使用下面这段代码，来获取保存在ThreadLocal中的用户信息
        return "访问资源1";
    }
}
