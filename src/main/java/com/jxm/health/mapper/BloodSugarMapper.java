package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.BloodSugarModel;

import java.util.List;

public interface BloodSugarMapper {

    int insert(BloodSugarModel bloodSugarModel);

    BloodSugarDto getLastedData(int userId);

    List<BloodSugarDto> getItemHistory(int userId);

    List<BSHalfYearData> getHalfYearTrend(int userId,int eat);

    List<BSLastTestTimeDto> getLastSevenTime(int userId,int eat);
}
