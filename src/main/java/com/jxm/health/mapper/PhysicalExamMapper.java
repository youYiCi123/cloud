package com.jxm.health.mapper;

import com.jxm.health.dto.PhysicalExamDto;
import com.jxm.health.model.PhysicalExamModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhysicalExamMapper {

    List<PhysicalExamDto> getPhysicalExams(int userId);

    Integer judgeIfExists(@Param("userId") int userId,@Param("testDay") String testDay);

    int updateById(PhysicalExamModel physicalExamModel);

    int insert(PhysicalExamModel physicalExamModel);

    int deleteById(int id);
}
