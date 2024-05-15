package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UriHalfYearData {
    @ApiModelProperty("尿酸平均值")
    private Integer averageValue;//尿酸
    private Integer year;
    private Integer month;
}
