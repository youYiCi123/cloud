package com.jxm.health.service.Impl;

import com.jxm.health.dto.PhysicalExamUpdateDto;
import com.jxm.health.mapper.PhysicalExamMapper;
import com.jxm.health.model.PhysicalExamModel;
import com.jxm.health.service.PhysicalExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhysicalExamServiceImpl implements PhysicalExamService {

    @Autowired
    private PhysicalExamMapper physicalExamMapper;

    @Override
    public int updateData(PhysicalExamModel physicalExamModel) {
        Integer id = physicalExamMapper.judgeIfExists(physicalExamModel.getUserId(), physicalExamModel.getTestDay());
        if(id!=null){
            physicalExamModel.setId(id);
           return physicalExamMapper.updateById(physicalExamModel);
        }else{
            return physicalExamMapper.insert(physicalExamModel);
        }
    }
}
