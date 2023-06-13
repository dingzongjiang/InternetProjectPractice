package com.example.internetprojectpractice.pojo;

import java.time.LocalDateTime;

public class Order {
    private Integer oid; // 订单id
    private Integer uid; // 用户id
    private Integer aid; // 收货地址id
    private String recv_name; // 收货人姓名
    private String recv_phone; // 收货人电话
    private String recv_province; // 收货人省份
    private String recv_city; // 收货人城市
    private String recv_district; // 收货人区县
    private String recv_address; // 收货人详细地址
    private Integer total_price; // 订单总价
    private Integer status; // 订单状态
    private LocalDateTime order_time; // 下单时间
    private LocalDateTime pay_time; // 支付时间
    private String created_user; // 创建人
    private LocalDateTime created_time; // 创建时间
    private String modified_user; // 更新人
    private LocalDateTime modified_time; // 更新时间

    public Order() {
    }


    public Order(Integer oid, Integer uid, Integer aid, String recv_name, String recv_phone, String recv_province, String recv_city, String recv_district, String recv_address, Integer total_price, Integer status, LocalDateTime order_time, LocalDateTime pay_time, String created_user, LocalDateTime created_time, String modified_user, LocalDateTime modified_time) {
        this.oid = oid;
        this.uid = uid;
        this.aid = aid;
        this.recv_name = recv_name;
        this.recv_phone = recv_phone;
        this.recv_province = recv_province;
        this.recv_city = recv_city;
        this.recv_district = recv_district;
        this.recv_address = recv_address;
        this.total_price = total_price;
        this.status = status;
        this.order_time = order_time;
        this.pay_time = pay_time;
        this.created_user = created_user;
        this.created_time = created_time;
        this.modified_user = modified_user;
        this.modified_time = modified_time;
    }

    /**
     * 获取
     * @return oid
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * 设置
     * @param oid
     */
    public void setOid(Integer oid) {
        this.oid = oid;
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
     * @return recv_name
     */
    public String getRecv_name() {
        return recv_name;
    }

    /**
     * 设置
     * @param recv_name
     */
    public void setRecv_name(String recv_name) {
        this.recv_name = recv_name;
    }

    /**
     * 获取
     * @return recv_phone
     */
    public String getRecv_phone() {
        return recv_phone;
    }

    /**
     * 设置
     * @param recv_phone
     */
    public void setRecv_phone(String recv_phone) {
        this.recv_phone = recv_phone;
    }

    /**
     * 获取
     * @return recv_province
     */
    public String getRecv_province() {
        return recv_province;
    }

    /**
     * 设置
     * @param recv_province
     */
    public void setRecv_province(String recv_province) {
        this.recv_province = recv_province;
    }

    /**
     * 获取
     * @return recv_city
     */
    public String getRecv_city() {
        return recv_city;
    }

    /**
     * 设置
     * @param recv_city
     */
    public void setRecv_city(String recv_city) {
        this.recv_city = recv_city;
    }

    /**
     * 获取
     * @return recv_district
     */
    public String getRecv_district() {
        return recv_district;
    }

    /**
     * 设置
     * @param recv_district
     */
    public void setRecv_district(String recv_district) {
        this.recv_district = recv_district;
    }

    /**
     * 获取
     * @return recv_address
     */
    public String getRecv_address() {
        return recv_address;
    }

    /**
     * 设置
     * @param recv_address
     */
    public void setRecv_address(String recv_address) {
        this.recv_address = recv_address;
    }

    /**
     * 获取
     * @return total_price
     */
    public Integer getTotal_price() {
        return total_price;
    }

    /**
     * 设置
     * @param total_price
     */
    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取
     * @return order_time
     */
    public LocalDateTime getOrder_time() {
        return order_time;
    }

    /**
     * 设置
     * @param order_time
     */
    public void setOrder_time(LocalDateTime order_time) {
        this.order_time = order_time;
    }

    /**
     * 获取
     * @return pay_time
     */
    public LocalDateTime getPay_time() {
        return pay_time;
    }

    /**
     * 设置
     * @param pay_time
     */
    public void setPay_time(LocalDateTime pay_time) {
        this.pay_time = pay_time;
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
     * @return created_time
     */
    public LocalDateTime getCreated_time() {
        return created_time;
    }

    /**
     * 设置
     * @param created_time
     */
    public void setCreated_time(LocalDateTime created_time) {
        this.created_time = created_time;
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

    public String toString() {
        return "Order{oid = " + oid + ", uid = " + uid + ", aid = " + aid + ", recv_name = " + recv_name + ", recv_phone = " + recv_phone + ", recv_province = " + recv_province + ", recv_city = " + recv_city + ", recv_district = " + recv_district + ", recv_address = " + recv_address + ", total_price = " + total_price + ", status = " + status + ", order_time = " + order_time + ", pay_time = " + pay_time + ", created_user = " + created_user + ", created_time = " + created_time + ", modified_user = " + modified_user + ", modified_time = " + modified_time + "}";
    }
}
