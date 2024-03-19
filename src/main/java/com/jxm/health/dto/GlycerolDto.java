package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class GlycerolDto {
    @ApiModelProperty("甘油")
    @JsonProperty("TRI")
    private Float TRI; //甘油
    private Date testTime;
}
