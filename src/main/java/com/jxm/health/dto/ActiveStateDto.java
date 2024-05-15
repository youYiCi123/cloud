package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActiveStateDto {
    @ApiModelProperty("激活状态 0 绑定失败、1 绑定成功、2 已绑定")
    @JsonProperty("STATE")
    private Integer STATE;
    @ApiModelProperty("产品序列号")
    @JsonProperty("DEVID")
    private String DEVID;
}
