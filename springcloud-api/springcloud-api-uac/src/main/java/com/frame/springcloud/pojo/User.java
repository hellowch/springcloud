package com.frame.springcloud.pojo;

import lombok.Data;

/**
 * 用户信息
 */
@Data
public class User {

    /**
     * 用户id
     */
    private String id;
    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 姓名
     */
    private String fullname;




}
