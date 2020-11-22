package com.frame.springcloud.controller;

import com.frame.springcloud.pojo.Dept;
import com.frame.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;


    @GetMapping("/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }
}
