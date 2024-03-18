package com.jxm.health.service.Impl;

import com.jxm.health.dto.UserDto;
import com.jxm.health.dto.UserParam;
import com.jxm.health.mapper.UserEquipMapper;
import com.jxm.health.mapper.UserMapper;
import com.jxm.health.model.UserByEquipModel;
import com.jxm.health.model.UserEquipModel;
import com.jxm.health.model.UserModel;
import com.jxm.health.service.UserService;
import com.jxm.health.utils.UniqueIdGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserEquipMapper userEquipMapper;

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
            userEquipModel.setDevId(userDto.getDevId());
            userEquipMapper.insertUserEquip(userEquipModel);
            return userModel.getId();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public List<UserByEquipModel> getAllUserByEquip(String devId) {
        List<UserByEquipModel> allUserByEquip = userEquipMapper.getAllUserByEquip(devId);
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
