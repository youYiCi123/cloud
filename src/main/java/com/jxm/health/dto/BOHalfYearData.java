package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BOHalfYearData {
    @ApiModelProperty("血氧平均值")
    private Integer XYAverageValue; //血氧
    @ApiModelProperty("心率(血氧测得)平均值")
    private Integer HRAverageValue; //心率(血氧测得)
    private Integer year;
    private Integer month;
}
