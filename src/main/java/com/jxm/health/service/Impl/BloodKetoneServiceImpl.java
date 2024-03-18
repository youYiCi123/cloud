package com.jxm.health.service.Impl;

import com.jxm.health.dto.BloodKetoneDto;
import com.jxm.health.mapper.BloodKetoneMapper;
import com.jxm.health.service.BloodKetoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodKetoneServiceImpl implements BloodKetoneService {

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Override
    public BloodKetoneDto getLastedData(int userId) {
        return bloodKetoneMapper.getLastedData(userId);
    }

}
