package com.example.internetprojectpractice.pojo;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class Cart {
    private Integer cid; // 购物车编号
    private Integer gid; // 商品编号
    private Integer pid; // 商品编号
    private Integer price; // 商品价格
    private Integer num; // 商品数量
    private String created_user; // 创建人
    private LocalDateTime created_time; // 创建时间
    private String modified_user; // 修改人
    private LocalDateTime modified_time; // 修改时间

    private boolean isChecked=false; // 是否选中

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Cart() {
    }

    public Cart(Integer cid, Integer gid, Integer pid, Integer price, Integer num, String created_user, LocalDateTime created_time, String modified_user, LocalDateTime modified_time) {
        this.cid = cid;
        this.gid = gid;
        this.pid = pid;
        this.price = price;
        this.num = num;
        this.created_user = created_user;
        this.created_time = created_time;
        this.modified_user = modified_user;
        this.modified_time = modified_time;
    }

    /**
     * 获取
     * @return cid
     */
    public Integer getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(Integer cid) {
        this.cid = cid;
    }

    /**
     * 获取
     * @return gid
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * 设置
     * @param gid
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * 获取
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 设置
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 获取
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
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
        return "Cart{cid = " + cid + ", gid = " + gid + ", pid = " + pid + ", price = " + price + ", num = " + num + ", created_user = " + created_user + ", created_time = " + created_time + ", modified_user = " + modified_user + ", modified_time = " + modified_time + "}";
    }
}
