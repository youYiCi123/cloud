package com.jxm.health.service.Impl;

import com.jxm.health.dto.UserDto;
import com.jxm.health.dto.UserParam;
import com.jxm.health.mapper.DeviceMapper;
import com.jxm.health.mapper.UserEquipMapper;
import com.jxm.health.mapper.UserMapper;
import com.jxm.health.model.*;
import com.jxm.health.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.regex.Pattern;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserEquipMapper userEquipMapper;

    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    @Transactional
    public int bindEquip(UserDto userDto) {
        try {
            //根据用户微信的openId获取用户id
            Integer userId = userMapper.selectUserByOpenId(userDto.getOpenId());
            if (userId != null && userId > 0) {//已经有该用户了，重复绑定还是添加设备
                Integer userEquip = userEquipMapper.selectUserEquip(userDto.getImei(), userId);
                if (userEquip != null && userEquip > 0) {//已绑定该设备
                    return userId;
                } else {//未绑定该设备
                    UserEquipModel userEquipModel = new UserEquipModel();
                    userEquipModel.setUserId(userId);
                    userEquipModel.setImei(userDto.getImei());
                    userEquipMapper.insertUserEquip(userEquipModel);
                    return userId;
                }
            } else {//用户初次注册
                UserModel userModel = new UserModel();
                List<Integer> genderChecks = Arrays.asList(0, 1, 2);
                if (!genderChecks.contains(userDto.getGender())) {
                    return -1;
                }
                BeanUtils.copyProperties(userDto, userModel);
                userModel.setCreateTime(new Date());
                userMapper.addUser(userModel);
                UserEquipModel userEquipModel = new UserEquipModel();
                userEquipModel.setUserId(userModel.getId());
                userEquipModel.setImei(userDto.getImei());
                userEquipMapper.insertUserEquip(userEquipModel);
                return userModel.getId();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public List<UserByEquipModel> getAllUserByEquip(String imei) {
        log.info("根据IMEI国际移动设备识别码获取绑定人员信息");
        Pattern compile = Pattern.compile("[0-9]+");
        boolean matches = compile.matcher(imei).matches();
        if (!matches || imei.length() < 10 || imei.length() > 20) {
            return new ArrayList<>();
        }
        if (deviceMapper.judgeIfExist(imei) == 0) {//插入
            DeviceModel deviceModel = new DeviceModel();
            deviceModel.setCreateTime(new Date());
            deviceModel.setDelFlag(0);
            deviceModel.setImei(imei);
            deviceMapper.insert(deviceModel);
        }
        List<UserByEquipModel> allUserByEquip = userEquipMapper.getAllUserByEquip(imei);
        if (!CollectionUtils.isEmpty(allUserByEquip)) {
            return allUserByEquip;
        }
        return new ArrayList<>();
    }

    @Override
    public List<UserParam> getMyFamily(int userId) {
        return userMapper.getMyFamily(userId);
    }

    @Override
    public List<EquipModel> getMyDevice(int userId) {
        return userEquipMapper.getMyDevice(userId);
    }
}
