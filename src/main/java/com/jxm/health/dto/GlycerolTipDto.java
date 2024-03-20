package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GlycerolTipDto {
    @ApiModelProperty("甘油")
    @JsonProperty("TRI")
    private Float TRI; //甘油
    @ApiModelProperty("提示标签")
    private String tip;
    private Date testTime;
}
