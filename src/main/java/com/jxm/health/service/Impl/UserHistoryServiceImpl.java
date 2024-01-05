package com.jxm.health.service.Impl;

import com.github.pagehelper.PageHelper;
import com.jxm.health.common.CommonResult;
import com.jxm.health.dto.*;
import com.jxm.health.mapper.*;
import com.jxm.health.service.UserHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Autowired
    private CholesterolMapper cholesterolMapper;

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @Override
    public List<BloodKetoneDto> getBK(String userId) {
        return bloodKetoneMapper.getItemHistory(userId);
    }

    @Override
    public List<BloodOxygenDto> getBO(String userId) {
        return bloodOxygenMapper.getItemHistory(userId);
    }

    @Override
    public List<BloodPressureDto> getBP(String userId) {
        return bloodPressureMapper.getItemHistory(userId);
    }

    @Override
    public List<BloodSugarDto> getBS(String userId) {
        return bloodSugarMapper.getItemHistory(userId);
    }

    @Override
    public List<CholesterolDto> getCHO(String userId) {
        List<CholesterolDto> itemHistory = cholesterolMapper.getItemHistory(userId);
        return itemHistory;
    }

    @Override
    public List<GlycerolDto> getTRI(String userId) {
        return glycerolMapper.getItemHistory(userId);
    }

    @Override
    public List<UricAcidDto> getURI(String userId) {
        return uricAcidMapper.getItemHistory(userId);
    }
}
