package com.jxm.health.controller;

import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.UserDto;
import com.jxm.health.model.UserByEquipModel;
import com.jxm.health.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "user", description = "设备用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("用户扫码后与设备绑定相关信息")
    @RequestMapping(value = "/bindEquip", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult bindEquip(@RequestBody UserDto userDto) {
        int count = userService.bindEquip(userDto);
        if (count < 0) {
            return CommonResult.failed();
        }
        return CommonResult.success();
    }

    @ApiOperation("根据设备序列号获取关联人员信息")
    @RequestMapping(value = "/getAllUserByEquip", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAllUserByEquip(@RequestParam("DEVID") String devId) {
        List<UserByEquipModel> userByEquips = userService.getAllUserByEquip(devId);
        return CommonResult.success(userByEquips);
    }



}
