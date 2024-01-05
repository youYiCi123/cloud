package com.jxm.health.service.Impl;

import com.jxm.health.dto.UricAcidDto;
import com.jxm.health.mapper.UricAcidMapper;
import com.jxm.health.service.UricAcidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UricAcidServiceImpl implements UricAcidService {

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @Override
    public UricAcidDto getLastedData(String userId) {
        return uricAcidMapper.getLastedData(userId);
    }
}
