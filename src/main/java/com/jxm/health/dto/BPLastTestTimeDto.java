package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BPLastTestTimeDto {
    @ApiModelProperty("高压平均值")
    private Integer SYS; //高压
    @ApiModelProperty("低压平均值")
    private Integer DIA; //低压
    @ApiModelProperty("心率(血压测得)平均值")
    private Integer PUL; //心率(血压测得)
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
