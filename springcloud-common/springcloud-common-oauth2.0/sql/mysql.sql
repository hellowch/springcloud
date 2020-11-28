CREATE TABLE `t_user` (
                          `id` bigint(20) NOT NULL COMMENT '用户id',
                          `username` varchar(64) NOT NULL,
                          `password` varchar(64) NOT NULL,
                          `fullname` varchar(255) NOT NULL COMMENT '用户姓名',
                          `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
                          PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO t_user (id, username, password, fullname, mobile) VALUES (1, 'zhangsan', '$2a$10$aFsOFzujtPCnUCUKcozsHux0rQ/3faAHGFSVb9Y.B1ntpmEhjRtru', '张三', '133455');
INSERT INTO t_user (id, username, password, fullname, mobile) VALUES (2, 'lisi', '$2a$10$CkR3esxdeS3p3euQtC5c5.UEdYaawPqnP01haiPos2ruHG2iWGf/K', '李四', '133455');

CREATE TABLE `t_role` (
                          `id` varchar(32) NOT NULL,
                          `role_name` varchar(255) DEFAULT NULL,
                          `description` varchar(255) DEFAULT NULL,
                          `create_time` datetime DEFAULT NULL,
                          `update_time` datetime DEFAULT NULL,
                          `status` char(1) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `unique_role_name` (`role_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `t_role`(`id`,`role_name`,`description`,`create_time`,`update_time`,`status`) values
('1','管理员',NULL,NULL,NULL,'');

CREATE TABLE `t_user_role` (
                               `user_id` varchar(32) NOT NULL,
                               `role_id` varchar(32) NOT NULL,
                               `create_time` datetime DEFAULT NULL,
                               `creator` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `t_user_role`(`user_id`,`role_id`,`create_time`,`creator`) values
('1','1',NULL,NULL);

CREATE TABLE `t_permission` (
                                `id` varchar(32) NOT NULL,
                                `code` varchar(32) NOT NULL COMMENT '权限标识符',
                                `description` varchar(64) DEFAULT NULL COMMENT '描述',
                                `url` varchar(128) DEFAULT NULL COMMENT '请求地址',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `t_permission`(`id`,`code`,`description`,`url`) values ('1','p1','测试资源
1','/r/r1'),('2','p3','测试资源2','/r/r2');

CREATE TABLE `t_role_permission` (
                                     `role_id` varchar(32) NOT NULL,
                                     `permission_id` varchar(32) NOT NULL,
                                     PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `t_role_permission`(`role_id`,`permission_id`) values ('1','1'),('1','2');

CREATE TABLE `oauth_client_details` (
                                        `client_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '客户端标
识',
                                        `resource_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
                                            COMMENT '接入资源列表',
                                        `client_secret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
                                            COMMENT '客户端秘钥',
                                        `scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                        `authorized_grant_types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT
                                                                                                                        NULL,
                                        `web_server_redirect_uri` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT
                                                                                                                        NULL,
                                        `authorities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                        `access_token_validity` int(11) NULL DEFAULT NULL,
                                        `refresh_token_validity` int(11) NULL DEFAULT NULL,
                                        `additional_information` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                                        `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE
                                            CURRENT_TIMESTAMP(0),
                                        `archived` tinyint(4) NULL DEFAULT NULL,
                                        `trusted` tinyint(4) NULL DEFAULT NULL,
                                        `autoapprove` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                        PRIMARY KEY (`client_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '接入客户端信息'
  ROW_FORMAT = Dynamic;
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, create_time, archived, trusted, autoapprove) VALUES ('c1', 'res1', '$2a$10$H1wKlULSV5J9XsA9AACC9OsNtIYOaFEAH3gi5nYsIkWGkqiYLCwli', 'ROLE_ADMIN,ROLE_USER,ROLE_API', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', null, 7200, 259200, null, '2020-08-01 14:13:18', 0, 0, 'false');
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, create_time, archived, trusted, autoapprove) VALUES ('c2', 'res2', '$2a$10$NlBC84MVb7F95EXYTXwLneXgCca6/GipyWR5NHm8K0203bSQMLpvm', 'ROLE_API', 'client_credentials,password,authorization_code,implicit,refresh_token', 'http://www.baidu.com', null, 31536000, 2592000, null, '2020-08-01 14:13:18', 0, 0, 'false');

CREATE TABLE `oauth_code` (
                              `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                              `authentication` blob NULL,
                              INDEX `code_index`(`code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;
