package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class UricAcidModel {
    private Integer userId;
    private Integer URI;//尿酸
    private Date testTime;
}
