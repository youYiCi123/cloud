package com.jxm.health.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UricAcidDto {
    private Integer gender;//性别
    private Integer URI;//尿酸
    private Date testTime;
}
