package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BKHalfYearData {
    @ApiModelProperty("血酮平均值")
    private Float averageValue;
    private Integer year;
    private Integer month;
}
