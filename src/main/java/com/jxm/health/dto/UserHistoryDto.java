package com.jxm.health.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户健康历史类", description = "查找用户某一个健康项的历史信息")
public class UserHistoryDto {
    @ApiModelProperty(value = "1、血压;2、血氧;3、血糖;4、胆固醇;5、甘油;6、血酮;7、尿酸", required = true)
    private Integer itemType;
    @ApiModelProperty(value = "用户ID", required = true)
    private String userId;
}
