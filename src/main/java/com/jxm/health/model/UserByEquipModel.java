package com.jxm.health.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserByEquipModel {
    @JsonProperty("USERID")
    private String USERID;
    private String nickName;
    private String avatarUrl;
    private Integer gender;
}
