package com.jxm.health.mapper;

import com.jxm.health.dto.BloodKetoneDto;
import com.jxm.health.model.BloodKetoneModel;

import java.util.List;

public interface BloodKetoneMapper {

    int insert(BloodKetoneModel bloodKetoneModel);

    BloodKetoneDto getLastedData(String userId);

    List<BloodKetoneDto> getItemHistory(String userId);
}
