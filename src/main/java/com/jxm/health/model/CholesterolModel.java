package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class CholesterolModel {
    private Integer userId;
    private Float CHO;//胆固醇
    private Date testTime;
}
