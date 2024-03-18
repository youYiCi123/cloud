package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.GlycerolModel;

import java.util.List;

public interface GlycerolMapper {

    int insert(GlycerolModel glycerolModel);

    GlycerolDto getLastedData(int userId);

    List<GlycerolDto> getItemHistory(int userId);

    List<GlyHalfYearData> getHalfYearTrend(int userId);

    List<GlyLastTestTimeDto> getLastSevenTime(int userId);
}
