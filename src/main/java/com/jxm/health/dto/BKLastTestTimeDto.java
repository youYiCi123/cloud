package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BKLastTestTimeDto {
    @ApiModelProperty("血酮值")
    @JsonProperty("BK")
    private Float BK;
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
