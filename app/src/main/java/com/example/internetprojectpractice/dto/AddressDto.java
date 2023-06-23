package com.example.internetprojectpractice.dto;

import com.example.internetprojectpractice.pojo.CodeData;
import com.example.internetprojectpractice.pojo.FromData;
import com.example.internetprojectpractice.pojo.NameData;

public class AddressDto {
    private CodeData codedata;
    private FromData formdata;
    private NameData namedata;
    private String usertoken;

    public AddressDto() {
    }

    public AddressDto(CodeData codedata, FromData formdata, NameData namedata, String usertoken) {
        this.codedata = codedata;
        this.formdata = formdata;
        this.namedata = namedata;
        this.usertoken = usertoken;
    }

    /**
     * 获取
     * @return codedata
     */
    public CodeData getCodedata() {
        return codedata;
    }

    /**
     * 设置
     * @param codedata
     */
    public void setCodedata(CodeData codedata) {
        this.codedata = codedata;
    }

    /**
     * 获取
     * @return formdata
     */
    public FromData getFormdata() {
        return formdata;
    }

    /**
     * 设置
     * @param formdata
     */
    public void setFormdata(FromData formdata) {
        this.formdata = formdata;
    }

    /**
     * 获取
     * @return namedata
     */
    public NameData getNamedata() {
        return namedata;
    }

    /**
     * 设置
     * @param namedata
     */
    public void setNamedata(NameData namedata) {
        this.namedata = namedata;
    }

    /**
     * 获取
     * @return usertoken
     */
    public String getUsertoken() {
        return usertoken;
    }

    /**
     * 设置
     * @param usertoken
     */
    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }

    public String toString() {
        return "AddressDto{codedata = " + codedata + ", formdata = " + formdata + ", namedata = " + namedata + ", usertoken = " + usertoken + "}";
    }
}



