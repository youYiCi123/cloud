package com.jxm.health.service;

import com.jxm.health.dto.CholesterolDto;
import com.jxm.health.dto.CholesterolTipDto;

public interface CholesterolService {

    CholesterolTipDto getLastedData(int userId);

}
