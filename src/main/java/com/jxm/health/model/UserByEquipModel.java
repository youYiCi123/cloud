package com.jxm.health.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserByEquipModel {
    @ApiModelProperty("用户标识符")
    @JsonProperty("USERID")
    private Integer USERID;
    @ApiModelProperty("昵称")
    @JsonProperty("NICKNAME")
    private String NICKNAME;
    @ApiModelProperty("头像")
    @JsonProperty("AVATARURL")
    private String AVATARURL;
    @ApiModelProperty("性别")
    @JsonProperty("GENDER")
    private Integer GENDER;
}
