package com.jxm.health.service;

import com.jxm.health.dto.BloodKetoneDto;

public interface BloodKetoneService {

    BloodKetoneDto getLastedData(String userId);
}
