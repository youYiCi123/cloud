package com.jxm.health.service.Impl;

import com.jxm.health.dto.CholesterolDto;
import com.jxm.health.mapper.CholesterolMapper;
import com.jxm.health.service.CholesterolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CholesterolServiceImpl implements CholesterolService {

    @Autowired
    private CholesterolMapper cholesterolMapper;
    @Override
    public CholesterolDto getLastedData(int userId) {
        return cholesterolMapper.getLastedData(userId);
    }
}
