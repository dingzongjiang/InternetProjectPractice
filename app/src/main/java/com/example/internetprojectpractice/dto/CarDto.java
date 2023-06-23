package com.example.internetprojectpractice.dto;

public class CarDto {
    private String cid;
    private Integer num;
    private String pid;
    private String uid;
    private String title;
    private double price;

    public CarDto() {
    }

    public CarDto(String cid, Integer num, String pid, String uid, String title, double price) {
        this.cid = cid;
        this.num = num;
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.price = price;
    }

    /**
     * 获取
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * 设置
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
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
     * @return pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * 设置
     * @param pid
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * 获取
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
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

    public String toString() {
        return "CarDto{cid = " + cid + ", num = " + num + ", pid = " + pid + ", uid = " + uid + ", title = " + title + ", price = " + price + "}";
    }
}
