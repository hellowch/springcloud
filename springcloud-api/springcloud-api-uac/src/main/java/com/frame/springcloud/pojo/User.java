package com.frame.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
@Table(name = "tb_user")
public class User {
    @Id
    private Integer id;

    private String username;

    private String password;

    private String avatar;

}