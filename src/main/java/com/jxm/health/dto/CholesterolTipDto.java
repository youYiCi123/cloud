package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CholesterolTipDto {
    @ApiModelProperty("胆固醇值")
    @JsonProperty("CHO")
    private Float CHO;//胆固醇
    @ApiModelProperty("提示标签")
    private String tip;
    private Date testTime;
}
