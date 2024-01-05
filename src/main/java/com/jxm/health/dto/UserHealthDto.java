package com.jxm.health.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

//上传用户检测数据实体类
@Data
public class UserHealthDto implements Serializable {

    private static final long serialVersionUID = 1L;
    @JsonProperty("USERID")
    private String USERID;//用户ID
    @JsonProperty("TESTTIME")
    private String TESTTIME;//测量时间
    @JsonProperty("SYS")
    private Integer SYS;//高压
    @JsonProperty("DIA")
    private Integer DIA;//低压
    @JsonProperty("PUL")
    private Integer PUL;//心率(血压测得)
    @JsonProperty("EAT")
    private Integer EAT;//是否吃饭 1 吃饭 0 没有吃饭
    @JsonProperty("GLU")
    private Float GLU;//血糖
    @JsonProperty("CHO")
    private Float CHO;//胆固醇
    @JsonProperty("TRI")
    private Float TRI; //甘油
    @JsonProperty("BK")
    private Float BK; //血酮
    @JsonProperty("URI")
    private Integer URI;//尿酸
    @JsonProperty("XY")
    private Integer XY;//血氧
    @JsonProperty("HR")
    private Integer HR;//心率(血氧测得)
}
