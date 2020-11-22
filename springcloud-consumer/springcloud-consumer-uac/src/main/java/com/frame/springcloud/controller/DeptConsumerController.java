package com.frame.springcloud.controller;

import com.frame.springcloud.feign.DeptClientService;
import com.frame.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/list")
    public List<Dept> list(){
        return this.deptClientService.queryAll();
    }
}
