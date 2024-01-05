package com.jxm.health.service;

import com.jxm.health.dto.BloodPressureDto;

public interface BloodPressureService {

    BloodPressureDto getLastedData(String userId);
}
