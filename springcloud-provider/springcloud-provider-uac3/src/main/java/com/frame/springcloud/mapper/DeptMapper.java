package com.frame.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.frame.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept> {

}