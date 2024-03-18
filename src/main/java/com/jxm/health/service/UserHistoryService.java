package com.jxm.health.service;

import com.jxm.health.dto.*;

import java.util.List;
import java.util.Map;

public interface UserHistoryService {

    List<BloodKetoneDto> getBK(int userId);

    List<BloodOxygenDto> getBO(int userId);

    List<BloodPressureDto> getBP(int userId);

    List<BloodSugarDto> getBS(int userId);

    List<CholesterolDto> getCHO(int userId);

    List<GlycerolDto> getTRI(int userId);

    List<UricAcidDto> getURI(int userId);

}
