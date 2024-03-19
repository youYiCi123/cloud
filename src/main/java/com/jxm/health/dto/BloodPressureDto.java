package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodPressureDto {
    @JsonProperty("SYS")
    @ApiModelProperty("高压")
    private Integer SYS;
    @JsonProperty("DIA")
    @ApiModelProperty("低压")
    private Integer DIA;
    @JsonProperty("PUL")
    @ApiModelProperty("心率(血压测得)")
    private Integer PUL;
    private Date testTime;
}
