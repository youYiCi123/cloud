package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ChoHalfYearData {
    @ApiModelProperty("胆固醇平均值")
    @JsonProperty("CHOAverageValue")
    private Float CHOAverageValue; //胆固醇
    private Integer year;
    private Integer month;
}
