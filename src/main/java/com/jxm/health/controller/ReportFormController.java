package com.jxm.health.controller;

import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.*;
import com.jxm.health.mapper.*;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/report")
@Api(tags = "report", description = "报表数据管理")
public class ReportFormController {

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Autowired
    private CholesterolMapper cholesterolMapper;

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @ApiOperation(value = "获取血酮半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BKHalfYearData.class),
    })
    @ApiImplicitParams({
       @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id",required = true,dataType = "int")
    })
    @RequestMapping(value = "/getHalfYear/BK", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BKHalfYearData>> getBK(@RequestParam(value = "userId") int userId) {
        List<BKHalfYearData> bk = bloodKetoneMapper.getHalfYearTrend(userId);
        return CommonResult.success(bk);
    }

    @ApiOperation(value = "获取血氧半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BOHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/BO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BOHalfYearData>> getBO(@RequestParam(value = "userId") int userId) {
        List<BOHalfYearData> bo = bloodOxygenMapper.getHalfYearTrend(userId);
        return CommonResult.success(bo);
    }

    @ApiOperation(value = "获取血压半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BPHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/BP", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BPHalfYearData>> getBP(@RequestParam(value = "userId") int userId) {
        List<BPHalfYearData> bp = bloodPressureMapper.getHalfYearTrend(userId);
        return CommonResult.success(bp);
    }

    @ApiOperation(value = "获取血糖半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BSHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/BS", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BSHalfYearData>> getBS(@RequestParam(value = "userId") int userId,
                                                    @RequestParam(value = "eat") int eat){
        List<BSHalfYearData> bs = bloodSugarMapper.getHalfYearTrend(userId,eat);
        return CommonResult.success(bs);
    }

    @ApiOperation(value = "获取胆固醇半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = ChoHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/CHO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<ChoHalfYearData>> getCHO(@RequestParam(value = "userId") int userId) {
        List<ChoHalfYearData> cho = cholesterolMapper.getHalfYearTrend(userId);
        return CommonResult.success(cho);
    }

    @ApiOperation(value = "获取甘油半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = GlyHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/TRI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<GlyHalfYearData>> getTRI(@RequestParam(value = "userId") int userId) {
        List<GlyHalfYearData> gly = glycerolMapper.getHalfYearTrend(userId);
        return CommonResult.success(gly);
    }

    @ApiOperation(value = "获取尿酸半年趋势")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = UriHalfYearData.class),
    })
    @RequestMapping(value = "/getHalfYear/URI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<UriHalfYearData>> getURI(@RequestParam(value = "userId") int userId) {
        List<UriHalfYearData> uri = uricAcidMapper.getHalfYearTrend(userId);
        return CommonResult.success(uri);
    }


    @ApiOperation(value = "血酮近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BKLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/BK", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BKLastTestTimeDto>> getBKLastSevenTime(@RequestParam(value = "userId") int userId) {
        List<BKLastTestTimeDto> bk = bloodKetoneMapper.getLastSevenTime(userId);
        return CommonResult.success(bk);
    }

    @ApiOperation(value = "血氧近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BOLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/BO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BOLastTestTimeDto>> getBOLastSevenTime(@RequestParam(value = "userId") int userId) {
        List<BOLastTestTimeDto> bo = bloodOxygenMapper.getLastSevenTime(userId);
        return CommonResult.success(bo);
    }

    @ApiOperation(value = "血压近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BPLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/BP", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BPLastTestTimeDto>> getBPLastSevenTime(@RequestParam(value = "userId") int userId) {
        List<BPLastTestTimeDto> bp = bloodPressureMapper.getLastSevenTime(userId);
        return CommonResult.success(bp);
    }

    @ApiOperation(value = "血糖近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = BSLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/BS", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<BSLastTestTimeDto>> getBSLastSevenTime(@RequestParam(value = "userId") int userId,
                                                    @RequestParam(value = "eat") int eat){
        List<BSLastTestTimeDto> bs = bloodSugarMapper.getLastSevenTime(userId,eat);
        return CommonResult.success(bs);
    }

    @ApiOperation(value = "胆固醇近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = ChoLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/CHO", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<ChoLastTestTimeDto>> getCHOLastSevenTime(@RequestParam(value = "userId") int userId) {
        List<ChoLastTestTimeDto> cho = cholesterolMapper.getLastSevenTime(userId);
        return CommonResult.success(cho);
    }

    @ApiOperation(value = "甘油近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = GlyLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/TRI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<GlyLastTestTimeDto>> getTRILastSevenTime(@RequestParam(value = "userId") int userId) {
        List<GlyLastTestTimeDto> gly = glycerolMapper.getLastSevenTime(userId);
        return CommonResult.success(gly);
    }

    @ApiOperation(value = "尿酸近七天(检测周期)检测值", notes="以今天为基准往前推移的7次最近的测量时间且天不一定连续")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = UriLastTestTimeDto.class),
    })
    @RequestMapping(value = "/getLastSevenTime/URI", method = { RequestMethod.GET})
    @ResponseBody
    public CommonResult<List<UriLastTestTimeDto>> getURILastSevenTime(@RequestParam(value = "userId") int userId) {
        List<UriLastTestTimeDto> uri = uricAcidMapper.getLastSevenTime(userId);
        return CommonResult.success(uri);
    }
}
