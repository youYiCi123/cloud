package com.jxm.health.service;

import com.jxm.health.dto.GlycerolDto;
import com.jxm.health.dto.GlycerolTipDto;

public interface GlycerolService {

    GlycerolTipDto getLastedData(int userId);

}
