## Spring Cloud 实战项目
（基础完成）搭建自用springcloud脚手架，完成部见详情，作者这两天去看看别人的脚手架学习一下，再继续修改。

### 项目介绍
    核心框架：springcloud Hoxton.SR8全家桶
    安全框架：Spring Security Oauth2
    持久层框架：MyBatis plus
    数据库连接池：Alibaba Druid

### 平台目录结构说明
```
├─springcloud----------------------------父项目，公共依赖
│  │
│  ├─springcloud-eureka-------------------------微服务注册中心
│  │
│  │─springcloud-zuul2.x------------------------微服务网关中心
│  │
│  │─springcloud-admin+dashboard----------------微服务监控中心
│  │
│  ├─springcloud-provider
│  │  │
│  │  │
│  │  └─springcloud-provider-uac-----------------用户服务中心提供者
│  │
│  ├─springcloud-api
│  │  │
│  │  │
│  │  └─springcloud-api-uac----------------------用户服务中心api
│  │
│  ├─springcloud-common
│  │  │
|  |  ├─springcloud-common-oauth2.0--------------公共安全认证
│  │  │
│  │  └─springcloud-common-config----------------公共配置包
│  │
│  ├─springcloud-consumer
│  │  │
│  │  │
│  │  └─springcloud-consumer-uac--------- ------用户服务中心消费者
│  │
│  ├─paascloud-generator
│  │  │
│  │  │
│  │  └─paascloud-generator-uac------------------数据服务中心Mybatis Generator

```


### 使用说明

```
common-Config(配置中心) -> Eureka(注册中心) -> Admin(监控中心) -> oauth(安全中心)
-> provider(服务提供者)-> consumer(消费者) -> Zuul(网关) 
```

### 作者介绍

```
作者正在学习中，该项目也是打算在开发中学习，有志同道合的小伙伴可以联系我哦！
```

### 传送门
    https://github.com/hollewch/springcloud
    
### 架构图
```
![Image text](https://github.com/hellowch/springcloud-config/blob/main/images/%E6%88%91%E7%9A%84%E6%9E%B6%E6%9E%84%E5%9B%BE.png)
```

### 接口

```
通过consumer访问provider的uac
http://localhost:9527/uac/consumer/dept/list

springcloud-common-oauth
客户端模式:  http://localhost:53020/uaa/oauth/token   client_id:c1  client_secret"secret   grant_type:client_credentials
密码模式:  http://localhost:53020/uaa/oauth/token  client_id:c1  client_secret"secret   grant_type:password username:zhangsan password:123
通过网关:  http://localhost:9527/oauth/uaa/oauth/token
校验令牌:  http://localhost:53020/uaa/oauth/check_token?token=....

通过网关带token访问资源: http://localhost:9527/uac/consumer/dept/list   头部加入Authorization 格式Bearer eyJhb......

```
