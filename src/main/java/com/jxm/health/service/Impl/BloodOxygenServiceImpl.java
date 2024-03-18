package com.jxm.health.service.Impl;

import com.jxm.health.dto.BloodOxygenDto;
import com.jxm.health.mapper.BloodOxygenMapper;
import com.jxm.health.service.BloodOxygenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodOxygenServiceImpl implements BloodOxygenService {

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Override
    public BloodOxygenDto getLastedData(int userId) {
        return bloodOxygenMapper.getLastedData(userId);
    }
}
