package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.GlycerolDto;
import com.jxm.health.dto.GlycerolTipDto;
import com.jxm.health.mapper.GlycerolMapper;
import com.jxm.health.service.GlycerolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GlycerolServiceImpl implements GlycerolService {

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Override
    public GlycerolTipDto getLastedData(int userId) {
        GlycerolDto glycerolDto = glycerolMapper.getLastedData(userId);
        GlycerolTipDto glycerolTipDto = new GlycerolTipDto();
        if(glycerolDto==null){
            return glycerolTipDto;
        }
        if (glycerolDto.getTRI() < 1.70) {//正常值
            glycerolTipDto.setTip("正常值");
        } else if (1.70 < glycerolDto.getTRI() && glycerolDto.getTRI() < 2.25) {//边缘升高
            glycerolTipDto.setTip("边缘升高");
        } else if (2.26 < glycerolDto.getTRI() && glycerolDto.getTRI() < 5.60) {//升高
            glycerolTipDto.setTip("升高");
        } else {//高风险
            glycerolTipDto.setTip("高风险");
        }
        BeanUtils.copyProperties(glycerolDto,glycerolTipDto);
        return glycerolTipDto;
    }
}
