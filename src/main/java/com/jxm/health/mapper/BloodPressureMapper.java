package com.jxm.health.mapper;

import com.jxm.health.dto.BloodPressureDto;
import com.jxm.health.model.BloodPressureModel;

import java.util.List;

public interface BloodPressureMapper {

    int insert(BloodPressureModel bloodPressureModel);

    BloodPressureDto getLastedData(String userId);

    List<BloodPressureDto> getItemHistory(String userId);
}
