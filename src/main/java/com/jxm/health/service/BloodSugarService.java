package com.jxm.health.service;

import com.jxm.health.dto.BloodSugarDto;
import com.jxm.health.dto.BloodSugarTipDto;

public interface BloodSugarService {

    BloodSugarTipDto getLastedData(int userId);

}
