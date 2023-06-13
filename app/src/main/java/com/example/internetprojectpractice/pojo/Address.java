package com.example.internetprojectpractice.pojo;

import java.time.LocalDateTime;

public class Address {
    private Integer aid; // 收获地址id
    private Integer uid;  // 用户id
    private String name;//收货人姓名
    private String province_name; // 省份
    private String province_code; // 省份编码
    private String city_name; // 城市
    private String city_code; // 城市编码
    private String area_name; // 区县
    private String area_code; // 区县编码
    private String zip; // 邮政编码
    private String address; // 详细地址
    private String phone; // 手机号码
    private String tel; // 固定电话
    private String tag; // 标签
    private Integer is_default; // 是否默认地址
    private String created_user; // 创建人
    private String modified_user; // 更新人
    private LocalDateTime create_time; // 创建时间
    private LocalDateTime modified_time; // 更新时间
    private Integer is_delete; // 是否删除


    public Address() {
    }

    public Address(String name, String province_name, String city_name, String area_name, String address, String phone) {
        this.name = name;
        this.province_name = province_name;
        this.city_name = city_name;
        this.area_name = area_name;
        this.address = address;
        this.phone = phone;
    }

    public Address(Integer aid, Integer uid, String name, String province_name, String province_code, String city_name, String city_code, String area_name, String area_code, String zip, String address, String phone, String tel, String tag, Integer is_default, String created_user, String modified_user, LocalDateTime create_time, LocalDateTime modified_time, Integer is_delete) {
        this.aid = aid;
        this.uid = uid;
        this.name = name;
        this.province_name = province_name;
        this.province_code = province_code;
        this.city_name = city_name;
        this.city_code = city_code;
        this.area_name = area_name;
        this.area_code = area_code;
        this.zip = zip;
        this.address = address;
        this.phone = phone;
        this.tel = tel;
        this.tag = tag;
        this.is_default = is_default;
        this.created_user = created_user;
        this.modified_user = modified_user;
        this.create_time = create_time;
        this.modified_time = modified_time;
        this.is_delete = is_delete;
    }

    /**
     * 获取
     * @return aid
     */
    public Integer getAid() {
        return aid;
    }

    /**
     * 设置
     * @param aid
     */
    public void setAid(Integer aid) {
        this.aid = aid;
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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return province_name
     */
    public String getProvince_name() {
        return province_name;
    }

    /**
     * 设置
     * @param province_name
     */
    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    /**
     * 获取
     * @return province_code
     */
    public String getProvince_code() {
        return province_code;
    }

    /**
     * 设置
     * @param province_code
     */
    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }

    /**
     * 获取
     * @return city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * 设置
     * @param city_name
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    /**
     * 获取
     * @return city_code
     */
    public String getCity_code() {
        return city_code;
    }

    /**
     * 设置
     * @param city_code
     */
    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }

    /**
     * 获取
     * @return area_name
     */
    public String getArea_name() {
        return area_name;
    }

    /**
     * 设置
     * @param area_name
     */
    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    /**
     * 获取
     * @return area_code
     */
    public String getArea_code() {
        return area_code;
    }

    /**
     * 设置
     * @param area_code
     */
    public void setArea_code(String area_code) {
        this.area_code = area_code;
    }

    /**
     * 获取
     * @return zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * 设置
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
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
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取
     * @return is_default
     */
    public Integer getIs_default() {
        return is_default;
    }

    /**
     * 设置
     * @param is_default
     */
    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }

    /**
     * 获取
     * @return created_user
     */
    public String getCreated_user() {
        return created_user;
    }

    /**
     * 设置
     * @param created_user
     */
    public void setCreated_user(String created_user) {
        this.created_user = created_user;
    }

    /**
     * 获取
     * @return modified_user
     */
    public String getModified_user() {
        return modified_user;
    }

    /**
     * 设置
     * @param modified_user
     */
    public void setModified_user(String modified_user) {
        this.modified_user = modified_user;
    }

    /**
     * 获取
     * @return create_time
     */
    public LocalDateTime getCreate_time() {
        return create_time;
    }

    /**
     * 设置
     * @param create_time
     */
    public void setCreate_time(LocalDateTime create_time) {
        this.create_time = create_time;
    }

    /**
     * 获取
     * @return modified_time
     */
    public LocalDateTime getModified_time() {
        return modified_time;
    }

    /**
     * 设置
     * @param modified_time
     */
    public void setModified_time(LocalDateTime modified_time) {
        this.modified_time = modified_time;
    }

    /**
     * 获取
     * @return is_delete
     */
    public Integer getIs_delete() {
        return is_delete;
    }

    /**
     * 设置
     * @param is_delete
     */
    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String toString() {
        return "Address{aid = " + aid + ", uid = " + uid + ", name = " + name + ", province_name = " + province_name + ", province_code = " + province_code + ", city_name = " + city_name + ", city_code = " + city_code + ", area_name = " + area_name + ", area_code = " + area_code + ", zip = " + zip + ", address = " + address + ", phone = " + phone + ", tel = " + tel + ", tag = " + tag + ", is_default = " + is_default + ", created_user = " + created_user + ", modified_user = " + modified_user + ", create_time = " + create_time + ", modified_time = " + modified_time + ", is_delete = " + is_delete + "}";
    }
}
