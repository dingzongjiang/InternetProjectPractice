package com.example.internetprojectpractice.pojo;

public class CodeData {
    private String province;
    private String city;
    private String area;

    public CodeData() {
    }

    public CodeData(String province, String city, String area) {
        this.province = province;
        this.city = city;
        this.area = area;
    }

    /**
     * 获取
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    public String toString() {
        return "CodeData{province = " + province + ", city = " + city + ", area = " + area + "}";
    }
}
