package com.example.internetprojectpractice.pojo;

import java.sql.Timestamp;

import lombok.Data;
import okhttp3.RequestBody;

@Data
public class User{
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


    public User() {
    }

    public User(Integer uid, String username, String password, String salt, String phone, String email, Integer gender, String avatar, Integer isDelete, String createUser, Timestamp createTime, String modifiedUser, Timestamp modifiedTime) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.isDelete = isDelete;
        this.createUser = createUser;
        this.createTime = createTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    public User(String username, String password) {
    }

    /**
     * 获取
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return gender
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取
     * @return isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 设置
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取
     * @return createUser
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置
     * @param createUser
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取
     * @return createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return modifiedUser
     */
    public String getModifiedUser() {
        return modifiedUser;
    }

    /**
     * 设置
     * @param modifiedUser
     */
    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    /**
     * 获取
     * @return modifiedTime
     */
    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    /**
     * 设置
     * @param modifiedTime
     */
    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String toString() {
        return "User{uid = " + uid + ", username = " + username + ", password = " + password + ", salt = " + salt + ", phone = " + phone + ", email = " + email + ", gender = " + gender + ", avatar = " + avatar + ", isDelete = " + isDelete + ", createUser = " + createUser + ", createTime = " + createTime + ", modifiedUser = " + modifiedUser + ", modifiedTime = " + modifiedTime + "}";
    }
}

