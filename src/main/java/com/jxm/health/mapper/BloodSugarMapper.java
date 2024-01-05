package com.jxm.health.mapper;

import com.jxm.health.dto.BloodSugarDto;
import com.jxm.health.model.BloodSugarModel;

import java.util.List;

public interface BloodSugarMapper {

    int insert(BloodSugarModel bloodSugarModel);

    BloodSugarDto getLastedData(String userId);

    List<BloodSugarDto> getItemHistory(String userId);
}
