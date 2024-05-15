package com.jxm.health.service.Impl;

import com.jxm.health.dto.UserDto;
import com.jxm.health.dto.UserParam;
import com.jxm.health.mapper.DeviceMapper;
import com.jxm.health.mapper.UserEquipMapper;
import com.jxm.health.mapper.UserMapper;
import com.jxm.health.model.DeviceModel;
import com.jxm.health.model.UserByEquipModel;
import com.jxm.health.model.UserEquipModel;
import com.jxm.health.model.UserModel;
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
        UserModel userModel = new UserModel();
        UserEquipModel userEquipModel = new UserEquipModel();
        try {
            List<Integer> genderChecks = Arrays.asList(0, 1, 2);
            if(!genderChecks.contains(userDto.getGender())){
             return -1;
            }
            BeanUtils.copyProperties(userDto,userModel);
            userModel.setCreateTime(new Date());
            userMapper.addUser(userModel);
            userEquipModel.setUserId(userModel.getId());
            userEquipModel.setImei(userDto.getImei());
            userEquipMapper.insertUserEquip(userEquipModel);
            return userModel.getId();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public List<UserByEquipModel> getAllUserByEquip(String imei) {
        log.info("根据IMEI国际移动设备识别码获取绑定人员信息");
        Pattern compile = Pattern.compile("[0-9]+");
        boolean matches = compile.matcher(imei).matches();
        if(!matches||imei.length()<10||imei.length()>20){
            return new ArrayList<>();
        }
        if(deviceMapper.judgeIfExist(imei)==0){//插入
            DeviceModel deviceModel = new DeviceModel();
            deviceModel.setCreateTime(new Date());
            deviceModel.setDelFlag(0);
            deviceModel.setImei(imei);
            deviceMapper.insert(deviceModel);
        }
        List<UserByEquipModel> allUserByEquip = userEquipMapper.getAllUserByEquip(imei);
        if(!CollectionUtils.isEmpty(allUserByEquip)){
            return allUserByEquip;
        }
        return new ArrayList<>();
    }

    @Override
    public List<UserParam> getMyFamily(int userId) {

        return userMapper.getMyFamily(userId);
    }
}
