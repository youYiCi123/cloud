package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class BloodKetoneModel {
    private String userId;
    private Float BK; //血酮
    private Date testTime;
}
