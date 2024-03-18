package com.jxm.health.mapper;

import com.jxm.health.dto.BKHalfYearData;
import com.jxm.health.dto.BKLastTestTimeDto;
import com.jxm.health.dto.BloodKetoneDto;
import com.jxm.health.model.BloodKetoneModel;

import java.util.List;

public interface BloodKetoneMapper {

    int insert(BloodKetoneModel bloodKetoneModel);

    BloodKetoneDto getLastedData(int userId);

    List<BloodKetoneDto> getItemHistory(int userId);

    List<BKHalfYearData> getHalfYearTrend(int userId);

    List<BKLastTestTimeDto> getLastSevenTime(int userId);
}
