package com.jxm.health.service;

import com.jxm.health.dto.*;

import java.util.List;
import java.util.Map;

public interface UserHistoryService {

    List<BloodKetoneDto> getBK(String userId);

    List<BloodOxygenDto> getBO(String userId);

    List<BloodPressureDto> getBP(String userId);

    List<BloodSugarDto> getBS(String userId);

    List<CholesterolDto> getCHO(String userId);

    List<GlycerolDto> getTRI(String userId);

    List<UricAcidDto> getURI(String userId);

}
