package com.jxm.health.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserEquipModel {
    private String imei;
    private Integer userId;
}
