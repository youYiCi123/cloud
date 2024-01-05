package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class BloodOxygenModel {
    private String userId;
    private Integer XY; //血氧
    private Integer HR; //心率(血氧测得)
    private Date testTime;
}
