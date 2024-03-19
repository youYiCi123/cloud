package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BPLastTestTimeDto {
    @ApiModelProperty("高压平均值")
    @JsonProperty("SYS")
    private Integer SYS; //高压
    @ApiModelProperty("低压平均值")
    @JsonProperty("DIA")
    private Integer DIA; //低压
    @ApiModelProperty("心率(血压测得)平均值")
    @JsonProperty("PUL")
    private Integer PUL; //心率(血压测得)
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
