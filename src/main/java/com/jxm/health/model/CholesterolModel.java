package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class CholesterolModel {
    private String userId;
    private Float CHO;//胆固醇
    private Date testTime;
}
