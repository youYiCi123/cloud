package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodOxygenDto {
    @JsonProperty("XY")
    @ApiModelProperty("血氧")
    private Integer XY; //血氧
    @JsonProperty("HR")
    @ApiModelProperty("心率(血氧测得)平均值")
    private Integer HR; //心率(血氧测得)
    private Date testTime;
}
