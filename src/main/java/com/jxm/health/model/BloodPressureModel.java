package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class BloodPressureModel {
    private Integer userId;
    private Integer SYS; //高压
    private Integer DIA; //低压
    private Integer PUL; //心率(血压测得)
    private Date testTime;
}
