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

}
