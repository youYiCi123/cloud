package com.jxm.health.model;

import lombok.Data;

import java.util.Date;

@Data
public class GlycerolModel {
    private Integer userId;
    private Float TRI; //甘油
    private Date testTime;
}
