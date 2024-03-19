package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GlyLastTestTimeDto {
    @ApiModelProperty("甘油平均值")
    @JsonProperty("TRI")
    private Float TRI; //甘油
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
