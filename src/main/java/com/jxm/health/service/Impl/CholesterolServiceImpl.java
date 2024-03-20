package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.CholesterolDto;
import com.jxm.health.dto.CholesterolTipDto;
import com.jxm.health.mapper.CholesterolMapper;
import com.jxm.health.service.CholesterolService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CholesterolServiceImpl implements CholesterolService {

    @Autowired
    private CholesterolMapper cholesterolMapper;
    @Override
    public CholesterolTipDto getLastedData(int userId) {
        CholesterolDto cholesterolDto = cholesterolMapper.getLastedData(userId);
        CholesterolTipDto cholesterolTipDto = new CholesterolTipDto();
        if(cholesterolDto==null){
            return cholesterolTipDto;
        }
        if (cholesterolDto.getCHO() < 5.18) {//正常值
            cholesterolTipDto.setTip("正常值");
        } else if (5.18 <= cholesterolDto.getCHO() && cholesterolDto.getCHO() < 6.19) {//边缘升高
            cholesterolTipDto.setTip("边缘升高");
        } else {//升高
            cholesterolTipDto.setTip("升高");
        }
        BeanUtils.copyProperties(cholesterolDto,cholesterolTipDto);
        return cholesterolTipDto;
    }
}
