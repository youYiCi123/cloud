package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodKetoneTipDto {
    @JsonProperty("BK")
    @ApiModelProperty("血酮")
    private Float BK;
    @ApiModelProperty("提示标签")
    private String tip;
    private Date testTime;
}
