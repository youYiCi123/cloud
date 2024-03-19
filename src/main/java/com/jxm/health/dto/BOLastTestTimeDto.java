package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BOLastTestTimeDto {
    @ApiModelProperty("血氧值")
    @JsonProperty("XY")
    private Integer XY; //血氧
    @ApiModelProperty("心率(血氧测得)值")
    @JsonProperty("HR")
    private Integer HR; //心率(血氧测得)
    @ApiModelProperty("检测时间")
    private String testTime;
    @ApiModelProperty("检测日期")
    private String testDay;
}
