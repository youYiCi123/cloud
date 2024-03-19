package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BOHalfYearData {
    @ApiModelProperty("血氧平均值")
    @JsonProperty("XYAverageValue")
    private Integer XYAverageValue; //血氧
    @ApiModelProperty("心率(血氧测得)平均值")
    @JsonProperty("HRAverageValue")
    private Integer HRAverageValue; //心率(血氧测得)
    private Integer year;
    private Integer month;
}
