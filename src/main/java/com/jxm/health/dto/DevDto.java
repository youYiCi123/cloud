package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class DevDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("国际移动设备识别码")
    @JsonProperty("IMEI")
    private String IMEI;
    @ApiModelProperty("SIM卡号")
    @JsonProperty("SIM")
    private String SIM;
}
