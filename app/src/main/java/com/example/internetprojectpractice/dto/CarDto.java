package com.example.internetprojectpractice.dto;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CarDto implements Parcelable {
    private String cid; // 购物车id
    private Integer num; // 购买数量
    private String pid; // 商品id
    private String uid; // 用户id
    private String title; // 商品标题
    private double price; // 商品价格

    public boolean isChecked=false; // 是否选中
    public CarDto() {
    }

    public CarDto(Integer num, String title, double price) {
        this.num = num;
        this.title = title;
        this.price = price;
    }

    public CarDto(String cid, Integer num, String pid, String uid, String title, double price) {
        this.cid = cid;
        this.num = num;
        this.pid = pid;
        this.uid = uid;
        this.title = title;
        this.price = price;
    }

    protected CarDto(Parcel in) {
        cid = in.readString();
        if (in.readByte() == 0) {
            num = null;
        } else {
            num = in.readInt();
        }
        pid = in.readString();
        uid = in.readString();
        title = in.readString();
        price = in.readDouble();
        isChecked = in.readByte() != 0;
    }

    public static final Creator<CarDto> CREATOR = new Creator<CarDto>() {
        @Override
        public CarDto createFromParcel(Parcel in) {
            return new CarDto(in);
        }

        @Override
        public CarDto[] newArray(int size) {
            return new CarDto[size];
        }
    };

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(cid);
        if (num == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(num);
        }
        dest.writeString(pid);
        dest.writeString(uid);
        dest.writeString(title);
        dest.writeDouble(price);
        dest.writeByte((byte) (isChecked ? 1 : 0));
    }
}
