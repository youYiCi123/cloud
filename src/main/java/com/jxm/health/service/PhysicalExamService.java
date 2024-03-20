package com.jxm.health.service;

import com.jxm.health.dto.PhysicalExamDto;
import com.jxm.health.model.PhysicalExamModel;

import java.util.List;

public interface PhysicalExamService {

    int updateData(PhysicalExamModel physicalExamModel);

    List<PhysicalExamDto> getPhysicalExams(int userId);

    PhysicalExamModel getPhysicalExamInfoById(int id);

    int deletePhysicalExamInfoById(int id);

    int getPhysicalExamScore(int id);
}
