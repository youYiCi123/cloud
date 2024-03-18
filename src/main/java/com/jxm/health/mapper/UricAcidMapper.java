package com.jxm.health.mapper;

import com.jxm.health.dto.*;
import com.jxm.health.model.UricAcidModel;

import java.util.List;

public interface UricAcidMapper {

    int insert(UricAcidModel uricAcidModel);

    UricAcidDto getLastedData(int userId);

    List<UricAcidDto> getItemHistory(int userId);

    List<UriHalfYearData> getHalfYearTrend(int userId);

    List<UriLastTestTimeDto> getLastSevenTime(int userId);
}
