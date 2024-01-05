package com.jxm.health.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BloodOxygenDto {
    private Integer XY; //血氧
    private Integer HR; //心率(血氧测得)
    private Date testTime;
}
