package com.jxm.health.mapper;

import com.jxm.health.dto.GlycerolDto;
import com.jxm.health.model.GlycerolModel;

import java.util.List;

public interface GlycerolMapper {

    int insert(GlycerolModel glycerolModel);

    GlycerolDto getLastedData(String userId);

    List<GlycerolDto> getItemHistory(String userId);
}
