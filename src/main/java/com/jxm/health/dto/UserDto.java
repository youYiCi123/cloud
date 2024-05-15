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
    private String openId;//微信平台下的id
    private String imei;//设备唯一标识符

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "nickName='" + nickName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", openId='" + openId + '\'' +
                ", imei='" + imei + '\'' +
                '}';
    }
}
