package com.frame.springcloud.service;

import com.frame.springcloud.mapper.DeptMapper;
import com.frame.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {

    @Autowired
    DeptMapper deptMapper;

    /*
    查询所有部门
    */
    public List<Dept> queryAll() {
        return deptMapper.selectList(null);
    }

    /*
    查询部门
    */
    public Dept queryById(Long id) {
        return deptMapper.selectById(id);
    }

}