package com.jxm.health.dto;

import java.io.Serializable;
import java.util.Date;

//上传用户信息实体类
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickName;//昵称
    private String avatarUrl;//头像
    private Integer gender;//性别
    private Date birthday;//出生日期
    private String unionId;//微信平台下的id
    private String devId;//设备序列号

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", unionId='" + unionId + '\'' +
                ", devId='" + devId + '\'' +
                '}';
    }
}
