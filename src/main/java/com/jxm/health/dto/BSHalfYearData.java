package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BSHalfYearData {
    @ApiModelProperty("血糖平均值")
    private Float averageValue; //血糖
    private Integer year;
    private Integer month;
}
