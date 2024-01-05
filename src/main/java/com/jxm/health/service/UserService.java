package com.jxm.health.service;

import com.jxm.health.dto.UserDto;
import com.jxm.health.model.UserByEquipModel;

import java.util.List;

public interface UserService {

    int bindEquip(UserDto userDto);

    List<UserByEquipModel> getAllUserByEquip(String devId);
}
