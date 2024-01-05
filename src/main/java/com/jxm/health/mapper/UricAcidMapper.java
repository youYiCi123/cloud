package com.jxm.health.mapper;

import com.jxm.health.dto.UricAcidDto;
import com.jxm.health.model.UricAcidModel;

import java.util.List;

public interface UricAcidMapper {

    int insert(UricAcidModel uricAcidModel);

    UricAcidDto getLastedData(String userId);

    List<UricAcidDto> getItemHistory(String userId);
}
