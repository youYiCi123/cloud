package com.jxm.health.service.Impl;

import com.jxm.health.dto.BloodSugarDto;
import com.jxm.health.mapper.BloodSugarMapper;
import com.jxm.health.service.BloodSugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodSugarServiceImpl implements BloodSugarService {

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Override
    public BloodSugarDto getLastedData(String userId) {
        return bloodSugarMapper.getLastedData(userId);
    }
}
