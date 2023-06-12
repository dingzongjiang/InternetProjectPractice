package com.example.internetprojectpractice.pojo;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class Goods {
    private Integer id; // 商品编号
    private Integer category_id; // 商品分类编号
    private String item_type; // 商品类型
    private String title; // 商品标题
    private String sell_point; // 商品卖点
    private double price; // 商品价格
    private Integer num; // 商品数量
    private String image; // 商品图片路径
    private Integer status; // 商品状态
    private Integer priority; // 商品优先级
    private LocalDateTime created_time; // 创建时间
    private LocalDateTime modified_time; // 最后修改时间
    private String created_user; // 创建人
    private String modified_user; // 最后修改人

    public Goods() {
    }

    public Goods(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public Goods(Integer id, Integer category_id, String item_type, String title, String sell_point, double price, Integer num, String image, Integer status, Integer priority, LocalDateTime created_time, LocalDateTime modified_time, String created_user, String modified_user) {
        this.id = id;
        this.category_id = category_id;
        this.item_type = item_type;
        this.title = title;
        this.sell_point = sell_point;
        this.price = price;
        this.num = num;
        this.image = image;
        this.status = status;
        this.priority = priority;
        this.created_time = created_time;
        this.modified_time = modified_time;
        this.created_user = created_user;
        this.modified_user = modified_user;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return category_id
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * 设置
     * @param category_id
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * 获取
     * @return item_type
     */
    public String getItem_type() {
        return item_type;
    }

    /**
     * 设置
     * @param item_type
     */
    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return sell_point
     */
    public String getSell_point() {
        return sell_point;
    }

    /**
     * 设置
     * @param sell_point
     */
    public void setSell_point(String sell_point) {
        this.sell_point = sell_point;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
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
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
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
     * @return priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置
     * @param priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String toString() {
        return "Goods{id = " + id + ", category_id = " + category_id + ", item_type = " + item_type + ", title = " + title + ", sell_point = " + sell_point + ", price = " + price + ", num = " + num + ", image = " + image + ", status = " + status + ", priority = " + priority + ", created_time = " + created_time + ", modified_time = " + modified_time + ", created_user = " + created_user + ", modified_user = " + modified_user + "}";
    }
}
