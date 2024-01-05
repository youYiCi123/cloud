package com.jxm.health.service;

import com.jxm.health.dto.BloodOxygenDto;

public interface BloodOxygenService {

    BloodOxygenDto getLastedData(String userId);
}
