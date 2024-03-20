package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class UricAcidTipDto {
    private Integer gender;//性别
    @ApiModelProperty("尿酸")
    @JsonProperty("URI")
    private Integer URI;//尿酸
    @ApiModelProperty("提示标签")
    private String tip;
    private Date testTime;

}
