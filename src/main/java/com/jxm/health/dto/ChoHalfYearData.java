package com.jxm.health.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChoHalfYearData {
    @ApiModelProperty("胆固醇平均值")
    private Float CHOAverageValue; //胆固醇
    private Integer year;
    private Integer month;
}
