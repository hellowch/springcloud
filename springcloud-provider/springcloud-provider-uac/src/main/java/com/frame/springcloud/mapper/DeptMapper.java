package com.frame.springcloud.mapper;

import com.frame.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptMapper {
    /*
查询所有部门
 */
    public List<Dept> queryAll();
}