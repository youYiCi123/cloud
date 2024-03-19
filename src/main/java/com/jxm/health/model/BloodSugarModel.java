package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class BloodSugarModel {
    private Integer userId;
    private Integer EAT;//是否吃饭 1 吃饭 0 没有吃饭
    private Float GLU;//血糖
    private Date testTime;
}
