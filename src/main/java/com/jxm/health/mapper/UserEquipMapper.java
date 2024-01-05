package com.jxm.health.mapper;

import com.jxm.health.model.UserByEquipModel;
import com.jxm.health.model.UserEquipModel;

import java.util.List;

public interface UserEquipMapper {

    List<UserByEquipModel> getAllUserByEquip(String devId);

    int insertUserEquip(UserEquipModel userEquipModel);
}
