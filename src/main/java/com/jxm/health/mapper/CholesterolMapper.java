package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.CholesterolModel;

import java.util.List;

public interface CholesterolMapper {

    int insert(CholesterolModel cholesterolModel);

    CholesterolDto getLastedData(int userId);

    List<CholesterolDto> getItemHistory(int userId);

    List<ChoHalfYearData> getHalfYearTrend(int userId);

    List<ChoLastTestTimeDto> getLastSevenTime(int userId);

}
