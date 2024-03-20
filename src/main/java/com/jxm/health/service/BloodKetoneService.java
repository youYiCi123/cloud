package com.jxm.health.service;

import com.jxm.health.dto.BloodKetoneDto;
import com.jxm.health.dto.BloodKetoneTipDto;

public interface BloodKetoneService {

    BloodKetoneTipDto getLastedData(int userId, Float GLU);
}
