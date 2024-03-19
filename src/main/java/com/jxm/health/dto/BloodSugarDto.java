package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BloodSugarDto {
    @ApiModelProperty("是否吃饭 1 吃饭 0 没有吃饭")
    @JsonProperty("EAT")
    private Integer EAT;
    @ApiModelProperty("血糖")
    @JsonProperty("GLU")
    private Float GLU;
    private Date testTime;
}
