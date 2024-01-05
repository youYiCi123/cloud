package com.jxm.health.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CholesterolDto {
    private Float CHO;//胆固醇
    private Date testTime;
}
