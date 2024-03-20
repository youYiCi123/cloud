package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.BloodPressureDto;
import com.jxm.health.dto.BloodPressureTipDto;
import com.jxm.health.mapper.BloodPressureMapper;
import com.jxm.health.service.BloodPressureService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodPressureServiceImpl implements BloodPressureService {

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Override
    public BloodPressureTipDto getLastedData(int userId) {
        BloodPressureDto bloodPressureDto = bloodPressureMapper.getLastedData(userId);
        BloodPressureTipDto bloodPressureTipDto = new BloodPressureTipDto();
        if(bloodPressureDto==null){
            return bloodPressureTipDto;
        }
        //血压标准
//        检测值范围	 	       高压			        低压
//        低血压		        ＜90和（或）			   ＜60
//        正常血压		    ＜120和			       ＜80
//        正常高值		    120-139和（或）		   80-89
//        1级高血压-轻度		140-159和（或）		   90-99
//        2级高血压-中度		160-179和（或）		   100-109
//        3级高血压-重度		≥180和（或）			   ≥110
        if (bloodPressureDto.getSYS() <= 90 || bloodPressureDto.getDIA() < 60) { //低血压
            bloodPressureTipDto.setTip("低血压");
        } else if (90 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 120 &&
                60 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 80) {//正常血压
            bloodPressureTipDto.setTip("正常血压");
        } else if ((120 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 139) ||
                (80 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 89)) {//正常高值
            bloodPressureTipDto.setTip("正常高值");
        } else if ((140 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 159) ||
                (90 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 99)) {//1级高血压-轻度
            bloodPressureTipDto.setTip("1级高血压-轻度");
        } else if ((160 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 179) ||
                (100 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 109)) {//2级高血压-中度
            bloodPressureTipDto.setTip("2级高血压-中度");
        } else {//3级高血压-重度
            bloodPressureTipDto.setTip("3级高血压-重度");
        }
        BeanUtils.copyProperties(bloodPressureDto,bloodPressureTipDto);
        return bloodPressureTipDto;
    }

}
