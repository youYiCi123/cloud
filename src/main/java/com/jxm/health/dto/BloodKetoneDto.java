package com.jxm.health.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BloodKetoneDto {
    private Float BK; //血酮
    private Date testTime;
}
