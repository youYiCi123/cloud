package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BPHalfYearData {
    @ApiModelProperty("高压平均值")
    @JsonProperty("SYSAverageValue")
    private Integer SYSAverageValue; //高压
    @ApiModelProperty("低压平均值")
    @JsonProperty("DIAAverageValue")
    private Integer DIAAverageValue; //低压
    @ApiModelProperty("心率(血压测得)平均值")
    @JsonProperty("PULAverageValue")
    private Integer PULAverageValue; //心率(血压测得)
    private Integer year;
    private Integer month;
}
