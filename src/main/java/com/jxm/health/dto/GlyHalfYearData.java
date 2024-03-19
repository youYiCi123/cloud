package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GlyHalfYearData {
    @ApiModelProperty("甘油平均值")
    private Float averageValue;
    private Integer year;
    private Integer month;
}
