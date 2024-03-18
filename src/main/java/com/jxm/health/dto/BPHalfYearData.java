package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BPHalfYearData {
    @ApiModelProperty("高压平均值")
    private Integer SYSAverageValue; //高压
    @ApiModelProperty("低压平均值")
    private Integer DIAAverageValue; //低压
    @ApiModelProperty("心率(血压测得)平均值")
    private Integer PULAverageValue; //心率(血压测得)
    private Integer year;
    private Integer month;
}
