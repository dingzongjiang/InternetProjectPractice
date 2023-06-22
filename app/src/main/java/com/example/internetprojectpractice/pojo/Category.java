package com.example.internetprojectpractice.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

public class Category implements Parcelable {
    private Integer id; // 商品分类编号
    private Integer parent_id; // 父级分类编号
    private String name; // 商品分类名称
    private Integer status; // 商品分类状态
    private Integer sort_order; // 商品分类排序
    private Integer is_parent; // 是否为父级分类
    private LocalDateTime created_time; // 创建时间
    private LocalDateTime modified_time; // 最后修改时间
    private String created_user; // 创建人
    private String modified_user; // 最后修改人


    public Category() {
    }

    public Category(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(Integer id, Integer parent_id, String name, Integer status, Integer sort_order, Integer is_parent, LocalDateTime created_time, LocalDateTime modified_time, String created_user, String modified_user) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.status = status;
        this.sort_order = sort_order;
        this.is_parent = is_parent;
        this.created_time = created_time;
        this.modified_time = modified_time;
        this.created_user = created_user;
        this.modified_user = modified_user;
    }

    protected Category(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        if (in.readByte() == 0) {
            parent_id = null;
        } else {
            parent_id = in.readInt();
        }
        name = in.readString();
        if (in.readByte() == 0) {
            status = null;
        } else {
            status = in.readInt();
        }
        if (in.readByte() == 0) {
            sort_order = null;
        } else {
            sort_order = in.readInt();
        }
        if (in.readByte() == 0) {
            is_parent = null;
        } else {
            is_parent = in.readInt();
        }
        created_user = in.readString();
        modified_user = in.readString();
    }

    public static final Creator<Category> CREATOR = new Creator<Category>() {
        @Override
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        @Override
        public Category[] newArray(int size) {
            return new Category[size];
        }
    };

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
     * @return parent_id
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置
     * @param parent_id
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
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
     * @return sort_order
     */
    public Integer getSort_order() {
        return sort_order;
    }

    /**
     * 设置
     * @param sort_order
     */
    public void setSort_order(Integer sort_order) {
        this.sort_order = sort_order;
    }

    /**
     * 获取
     * @return is_parent
     */
    public Integer getIs_parent() {
        return is_parent;
    }

    /**
     * 设置
     * @param is_parent
     */
    public void setIs_parent(Integer is_parent) {
        this.is_parent = is_parent;
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
        return "Category{id = " + id + ", parent_id = " + parent_id + ", name = " + name + ", status = " + status + ", sort_order = " + sort_order + ", is_parent = " + is_parent + ", created_time = " + created_time + ", modified_time = " + modified_time + ", created_user = " + created_user + ", modified_user = " + modified_user + "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        if (parent_id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(parent_id);
        }
        dest.writeString(name);
        if (status == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(status);
        }
        if (sort_order == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(sort_order);
        }
        if (is_parent == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(is_parent);
        }
        dest.writeString(created_user);
        dest.writeString(modified_user);
    }
}
