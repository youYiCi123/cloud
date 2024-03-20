package com.jxm.health.service;

import com.jxm.health.dto.BloodPressureDto;
import com.jxm.health.dto.BloodPressureTipDto;

public interface BloodPressureService {

    BloodPressureTipDto getLastedData(int userId);
}
