package com.jxm.health.controller;

import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.healthEvaluate;
import com.jxm.health.service.HealthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/health")
@Api(tags = "health", description = "健康管理")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @ApiOperation("获取实时健康分数")
    @RequestMapping(value = "/getRealTimeScore", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getRealTimeScore(@RequestParam("userId") String userId) {
        int realTimeScore = healthService.getRealTimeScore(userId);
        String evaluate="";
        healthEvaluate healthEvaluate = new healthEvaluate();
        healthEvaluate.setHealthScore(realTimeScore);
        if(80<=realTimeScore&&realTimeScore<100){
            evaluate="身体状况极佳，各项生理指标在正常范围内，充满活力";
        }else if(60<=realTimeScore&&realTimeScore<80){
            evaluate="身体状况良好，偶有轻微不适，但不影响正常生活";
        }else if(45<=realTimeScore&&realTimeScore<60){
            evaluate="身体出现一些不适症状，可能需要关注和改善";
        }else{
            evaluate="身体健康状况较差，可能存在严重的健康问题";
        }
        healthEvaluate.setEvaluate(evaluate);
        return CommonResult.success(healthEvaluate);
    }

    
}
