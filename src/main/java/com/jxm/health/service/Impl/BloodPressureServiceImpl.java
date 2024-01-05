package com.jxm.health.service.Impl;

import com.jxm.health.dto.BloodPressureDto;
import com.jxm.health.mapper.BloodPressureMapper;
import com.jxm.health.service.BloodPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodPressureServiceImpl implements BloodPressureService {

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Override
    public BloodPressureDto getLastedData(String userId) {
        return bloodPressureMapper.getLastedData(userId);
    }

}
