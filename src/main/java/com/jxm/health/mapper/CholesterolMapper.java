package com.jxm.health.mapper;

import com.jxm.health.dto.CholesterolDto;
import com.jxm.health.model.CholesterolModel;

import java.util.List;

public interface CholesterolMapper {

    int insert(CholesterolModel cholesterolModel);

    CholesterolDto getLastedData(String userId);

    List<CholesterolDto> getItemHistory(String userId);
}
