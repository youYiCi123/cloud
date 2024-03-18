package com.jxm.health.controller;

import com.github.pagehelper.PageHelper;
import com.jxm.health.common.CommonPage;
import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.*;
import com.jxm.health.service.UserHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/history")
@Api(tags = "history", description = "历史数据管理")
public class UserHistoryController {

    @Autowired
    private UserHistoryService userHistoryService;

    @ApiOperation(value = "查找血酮历史详情")
    @RequestMapping(value = "/getBK", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<BloodKetoneDto>> getBK(@RequestParam(value = "userId") int userId,
                                                          @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<BloodKetoneDto> bk = userHistoryService.getBK(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找血氧历史详情")
    @RequestMapping(value = "/getBO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<BloodOxygenDto>> getBO(@RequestParam(value = "userId") int userId,
                                                          @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<BloodOxygenDto> bk = userHistoryService.getBO(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找血压历史详情")
    @RequestMapping(value = "/getBP", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<BloodPressureDto>> getBP(@RequestParam(value = "userId") int userId,
                                                          @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<BloodPressureDto> bk = userHistoryService.getBP(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找血糖历史详情")
    @RequestMapping(value = "/getBS", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<BloodSugarDto>> getBS(@RequestParam(value = "userId") int userId,
                                                         @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<BloodSugarDto> bk = userHistoryService.getBS(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找胆固醇历史详情")
    @RequestMapping(value = "/getCHO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<CholesterolDto>> getCHO(@RequestParam(value = "userId") int userId,
                                                            @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<CholesterolDto> bk = userHistoryService.getCHO(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找甘油历史详情")
    @RequestMapping(value = "/getTRI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<GlycerolDto>> getTRI(@RequestParam(value = "userId") int userId,
                                                           @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<GlycerolDto> bk = userHistoryService.getTRI(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

    @ApiOperation(value = "查找尿酸历史详情")
    @RequestMapping(value = "/getURI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<CommonPage<UricAcidDto>> getURI(@RequestParam(value = "userId") int userId,
                                                        @RequestParam(value = "pageSize", defaultValue = "7") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<UricAcidDto> bk = userHistoryService.getURI(userId);
        return CommonResult.success(CommonPage.restPage(bk));
    }

}
