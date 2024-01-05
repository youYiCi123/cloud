package com.jxm.health.service;

import com.jxm.health.dto.BloodSugarDto;

public interface BloodSugarService {

    BloodSugarDto getLastedData(String userId);

}
