package com.jxm.health.controller;

import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.ChoLastTestTimeDto;
import com.jxm.health.dto.GlyLastTestTimeDto;
import com.jxm.health.dto.UserDto;
import com.jxm.health.dto.UserParam;
import com.jxm.health.model.UserByEquipModel;
import com.jxm.health.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@Api(tags = "user", description = "设备用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户扫码后与设备绑定相关信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "返回用户id"),
    })
    @RequestMapping(value = "/bindEquip", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult bindEquip(@RequestBody UserDto userDto) {
        HashMap<String, Object> result = new HashMap<>();
        int userId = userService.bindEquip(userDto);
        if (userId < 0) {
            return CommonResult.failed();
        }else{
            result.put("userId",userId);
            return CommonResult.success(result);
        }
    }

    @ApiOperation("根据IMEI国际移动设备识别码获取绑定人员信息")
    @ApiResponses({
            @ApiResponse(code = 200,message = "OK",response = UserByEquipModel.class),
    })
    @RequestMapping(value = "/getAllUserByEquip", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserByEquipModel>> getAllUserByEquip(@RequestParam("IMEI") String IMEI) {
        List<UserByEquipModel> userByEquips = userService.getAllUserByEquip(IMEI);
        return CommonResult.success(userByEquips);
    }

    @ApiOperation("小程序获取家庭组成员")
    @RequestMapping(value = "/getMyFamily", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getMyFamily(@RequestParam("userId") int userId) {
        List<UserParam> familyUsers = userService.getMyFamily(userId);
        return CommonResult.success(familyUsers);
    }

}
