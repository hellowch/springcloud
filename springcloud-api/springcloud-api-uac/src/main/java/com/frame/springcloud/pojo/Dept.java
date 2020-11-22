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

    @Column(name = "db_source")
    private String dbSource;

    public Dept(String dname){
        this.dname=dname;
    }
}