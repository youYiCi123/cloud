package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class DeviceModel {
    private Integer id;
    private String imei;
    private Date createTime;
    private Integer delFlag;
}
