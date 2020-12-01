package com.frame.springcloud.controller;

import com.frame.springcloud.feign.DeptClientService;
import com.frame.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/list")
    @PreAuthorize("hasAuthority('p1')")//拥有p1权限方可访问此url
    public List<Dept> list(){
        return this.deptClientService.queryAll();
    }

    @RequestMapping("/get/{id}")
    @PreAuthorize("hasAuthority('p2')")//拥有p1权限方可访问此url
    public Dept get(@PathVariable("id") Long id){
        return this.deptClientService.queryById(id);
    }

    @RequestMapping("/r1")
    public String r1(HttpServletRequest request) {
        return this.deptClientService.r1(request);
    }
}
