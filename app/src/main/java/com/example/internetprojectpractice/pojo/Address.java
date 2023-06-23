package com.example.internetprojectpractice.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

public class Address implements Parcelable {
    private Integer aid; // 收获地址id
    private Integer uid;  // 用户id
    private String name;//收货人姓名
    private String provinceName;
    private  String provinceCode;
    private  String cityName;
    private  String cityCode;
    private  String areaName;
    private  String areaCode;
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

    public Address(Integer aid, Integer uid, String name, String provinceName, String provinceCode, String cityName, String cityCode, String areaName, String areaCode, String address, String phone, String tel, String tag, Integer is_default, String created_user, String modified_user, LocalDateTime create_time, LocalDateTime modified_time, Integer is_delete) {
        this.aid = aid;
        this.uid = uid;
        this.name = name;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.areaName = areaName;
        this.areaCode = areaCode;
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

    public Address(String name, String provinceName, String cityName, String areaName, String address, String phone) {
        this.name = name;
        this.provinceName = provinceName;
        this.cityName = cityName;
        this.areaName = areaName;
        this.address = address;
        this.phone = phone;
    }

    protected Address(Parcel in) {
        if (in.readByte() == 0) {
            aid = null;
        } else {
            aid = in.readInt();
        }
        if (in.readByte() == 0) {
            uid = null;
        } else {
            uid = in.readInt();
        }
        name = in.readString();
        provinceName = in.readString();
        provinceCode = in.readString();
        cityName = in.readString();
        cityCode = in.readString();
        areaName = in.readString();
        areaCode = in.readString();
        address = in.readString();
        phone = in.readString();
        tel = in.readString();
        tag = in.readString();
        if (in.readByte() == 0) {
            is_default = null;
        } else {
            is_default = in.readInt();
        }
        created_user = in.readString();
        modified_user = in.readString();
        if (in.readByte() == 0) {
            is_delete = null;
        } else {
            is_delete = in.readInt();
        }
    }

    public static final Creator<Address> CREATOR = new Creator<Address>() {
        @Override
        public Address createFromParcel(Parcel in) {
            return new Address(in);
        }

        @Override
        public Address[] newArray(int size) {
            return new Address[size];
        }
    };

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
     * @return provinceName
     */
    public String getProvinceName() {
        return provinceName;
    }

    /**
     * 设置
     * @param provinceName
     */
    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    /**
     * 获取
     * @return provinceCode
     */
    public String getProvinceCode() {
        return provinceCode;
    }

    /**
     * 设置
     * @param provinceCode
     */
    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    /**
     * 获取
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * 获取
     * @return cityCode
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * 设置
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * 获取
     * @return areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 设置
     * @param areaName
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 获取
     * @return areaCode
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置
     * @param areaCode
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
        return "Address{aid = " + aid + ", uid = " + uid + ", name = " + name + ", provinceName = " + provinceName + ", provinceCode = " + provinceCode + ", cityName = " + cityName + ", cityCode = " + cityCode + ", areaName = " + areaName + ", areaCode = " + areaCode + ", address = " + address + ", phone = " + phone + ", tel = " + tel + ", tag = " + tag + ", is_default = " + is_default + ", created_user = " + created_user + ", modified_user = " + modified_user + ", create_time = " + create_time + ", modified_time = " + modified_time + ", is_delete = " + is_delete + "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (aid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(aid);
        }
        if (uid == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(uid);
        }
        dest.writeString(name);
        dest.writeString(provinceName);
        dest.writeString(provinceCode);
        dest.writeString(cityName);
        dest.writeString(cityCode);
        dest.writeString(areaName);
        dest.writeString(areaCode);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(tel);
        dest.writeString(tag);
        if (is_default == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(is_default);
        }
        dest.writeString(created_user);
        dest.writeString(modified_user);
        if (is_delete == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(is_delete);
        }
    }
}
