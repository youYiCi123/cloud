package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodPressureTipDto {
    @JsonProperty("SYS")
    @ApiModelProperty("高压")
    private Integer SYS;
    @JsonProperty("DIA")
    @ApiModelProperty("低压")
    private Integer DIA;
    @JsonProperty("PUL")
    @ApiModelProperty("心率(血压测得)")
    private Integer PUL;
    @ApiModelProperty("提示标签")
    private String tip;
    private Date testTime;
}
