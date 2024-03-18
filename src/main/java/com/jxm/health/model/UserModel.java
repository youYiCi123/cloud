package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserModel{
    private Integer id;
    private String nickName;
    private String avatarUrl;
    private Integer gender;
    private Date birthday;//出生日期
    private String openId;
    private Date createTime;
}
