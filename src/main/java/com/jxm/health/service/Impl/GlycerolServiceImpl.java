package com.jxm.health.service.Impl;

import com.jxm.health.dto.GlycerolDto;
import com.jxm.health.mapper.GlycerolMapper;
import com.jxm.health.service.GlycerolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlycerolServiceImpl implements GlycerolService {

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Override
    public GlycerolDto getLastedData(String userId) {
        return glycerolMapper.getLastedData(userId);
    }
}
