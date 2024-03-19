package com.jxm.health.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PhysicalExamModel {
    private Integer id;
    private Integer userId;
    private String testDay;
    @ApiModelProperty("血酮值")
    private Float bkValue;
    @ApiModelProperty("血酮检测时间")
    private Date bkTime;
    @ApiModelProperty("血氧值")
    private Integer boXy;
    @ApiModelProperty("心率(血氧测得)值")
    private Integer boHr;
    @ApiModelProperty("血氧检测时间")
    private Date boTime;
    @ApiModelProperty("高压")
    private Integer bpSys;
    @ApiModelProperty("低压")
    private Integer bpDia;
    @ApiModelProperty("心率(血压测得)")
    private Integer bpPul;
    @ApiModelProperty("血压检测时间")
    private Date bpTime;
    @ApiModelProperty("是否吃饭 1 吃饭 0 没有吃饭")
    private Integer bsEat;
    @ApiModelProperty("血糖值")
    private Float bsGlu;
    @ApiModelProperty("血糖检测时间")
    private Date bsTime;
    @ApiModelProperty("胆固醇值")
    private Float choValue;
    @ApiModelProperty("胆固醇检测时间")
    private Date choTime;
    @ApiModelProperty("甘油值")
    private Float glyValue;
    @ApiModelProperty("甘油检测时间")
    private Date glyTime;
    @ApiModelProperty("尿酸值")
    private Integer uriValue;
    @ApiModelProperty("尿酸检测时间")
    private Date uriTime;
}
