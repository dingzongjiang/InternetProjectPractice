package com.example.internetprojectpractice.pojo;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class User {
//    用户id
    private Integer uid;
//    用户名
    private String username;
//    密码
    private String password;
//    盐值
    private String salt;
//    电话号码
    private String phone;
//    邮箱
    private String email;
//    性别
    private Integer gender;
//    头像
    private String avatar;
//    是否删除
    private Integer isDelete;
//    日志--创建人
    private String createUser;
//    日志--创建时间
    private Timestamp createTime;
//    日志--最后修改执行人
    private String modifiedUser;
//    日志--最后修改时间
    private Timestamp modifiedTime;


}

