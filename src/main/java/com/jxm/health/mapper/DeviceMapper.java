package com.jxm.health.mapper;

import com.jxm.health.model.DeviceModel;

public interface DeviceMapper {

    int judgeIfExist(String imei);

    int insert(DeviceModel devModel);

}
