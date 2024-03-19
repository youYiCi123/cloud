package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodKetoneDto {
    @JsonProperty("BK")
    @ApiModelProperty("血酮")
    private Float BK;
    private Date testTime;
}
