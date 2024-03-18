package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.BloodPressureModel;

import java.util.List;

public interface BloodPressureMapper {

    int insert(BloodPressureModel bloodPressureModel);

    BloodPressureDto getLastedData(int userId);

    List<BloodPressureDto> getItemHistory(int userId);

    List<BPHalfYearData> getHalfYearTrend(int userId);

    List<BPLastTestTimeDto> getLastSevenTime(int userId);
}
