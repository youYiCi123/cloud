package com.jxm.health.service;

import com.jxm.health.dto.UricAcidDto;
import com.jxm.health.dto.UricAcidTipDto;

public interface UricAcidService {

    UricAcidTipDto getLastedData(int userId);

}
