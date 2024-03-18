package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BOLastTestTimeDto {
    @ApiModelProperty("血氧值")
    private Integer XY; //血氧
    @ApiModelProperty("心率(血氧测得)值")
    private Integer HR; //心率(血氧测得)
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
