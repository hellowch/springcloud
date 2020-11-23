package com.frame.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Dept {
    @Id
    private Long deptno;

    private String dname;

    //这个数据是在哪个数据库的字段，微服务一个服务对应一个数据库,同一个信息可能存在不同数据库
    private String db_source;

    public Dept(String dname){
        this.dname=dname;
    }
}