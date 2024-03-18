package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.BloodOxygenModel;

import java.util.List;

public interface BloodOxygenMapper {

    int insert(BloodOxygenModel bloodOxygenModel);

    BloodOxygenDto getLastedData(int userId);

    List<BloodOxygenDto> getItemHistory(int userId);

    List<BOHalfYearData> getHalfYearTrend(int userId);

    List<BOLastTestTimeDto> getLastSevenTime(int userId);
}
