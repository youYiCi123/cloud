package com.jxm.health.controller;

import com.github.pagehelper.PageHelper;
import com.jxm.health.common.CommonPage;
import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.*;
import com.jxm.health.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/data")
@Api(tags = "data", description = "数据管理")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @Autowired
    private BloodKetoneService bloodKetoneService;

    @Autowired
    private BloodOxygenService bloodOxygenService;

    @Autowired
    private BloodPressureService bloodPressureService;

    @Autowired
    private BloodSugarService bloodSugarService;

    @Autowired
    private CholesterolService cholesterolService;

    @Autowired
    private GlycerolService glycerolService;

    @Autowired
    private UricAcidService uricAcidService;

    @ApiOperation("设备仪器上传数据")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(UserHealthDto userHealthDto) throws ParseException {
        int count = userDataService.uploadReal(userHealthDto);
        if (count < 0) {
            return CommonResult.failed();
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return CommonResult.success(sdf.format(date));
    }

    @ApiOperation("小程序获取用户所有最新的监测数据")
    @RequestMapping(value = "/getUserLastedHealths", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getUserLastedHealths(@RequestParam(value = "userId") String userId){
        Map<String, Object> map = new HashMap<>(16);
        //血压
        map.put("bloodPressure", bloodPressureService.getLastedData(userId));
        //血氧
        map.put("bloodOxygen", bloodOxygenService.getLastedData(userId));
        //血糖
        map.put("bloodSugar", bloodSugarService.getLastedData(userId));
        //胆固醇
        map.put("cholesterol", cholesterolService.getLastedData(userId));
        //甘油
        map.put("glycerol", glycerolService.getLastedData(userId));
        //血酮
        map.put("bloodKetone", bloodKetoneService.getLastedData(userId));
        //尿酸
        map.put("uricAcid", uricAcidService.getLastedData(userId));
        return CommonResult.success(map, "获取成功");
    }

}
