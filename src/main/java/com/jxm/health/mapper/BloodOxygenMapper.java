package com.jxm.health.mapper;

import com.jxm.health.dto.BloodOxygenDto;
import com.jxm.health.model.BloodOxygenModel;

import java.util.List;

public interface BloodOxygenMapper {

    int insert(BloodOxygenModel bloodOxygenModel);

    BloodOxygenDto getLastedData(String userId);

    List<BloodOxygenDto> getItemHistory(String userId);

}
