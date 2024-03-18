package com.jxm.health.mapper;

import com.jxm.health.dto.UserParam;
import com.jxm.health.model.UserModel;

import java.util.List;

public interface UserMapper {

    int addUser(UserModel userModel);

    List<UserParam> getMyFamily(int userId);
}
