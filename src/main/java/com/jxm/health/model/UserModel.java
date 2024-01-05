package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel{

    private String id;
    private String nickName;
    private String avatarUrl;
    private Integer gender;
    private Date birthday;//出生日期
    private String unionId;
    private Date createTime;
}
