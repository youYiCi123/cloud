package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.BloodKetoneTipDto;
import com.jxm.health.dto.BloodSugarDto;
import com.jxm.health.dto.BloodSugarTipDto;
import com.jxm.health.mapper.BloodSugarMapper;
import com.jxm.health.service.BloodSugarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodSugarServiceImpl implements BloodSugarService {

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Override
    public BloodSugarTipDto getLastedData(int userId) {
        BloodSugarDto bloodSugarDto = bloodSugarMapper.getLastedData(userId);
        BloodSugarTipDto bloodSugarTipDto = new BloodSugarTipDto();
        if(bloodSugarDto==null){
            return bloodSugarTipDto;
        }
        //血糖打分
//        检测值范围		空腹	    ||	餐后2小时
//        正常值	       3.90-6.10	||  3.90-7.80
//        血糖偏低	    ≤3.89		||  ≤3.89
//        低血糖		    ＜2.80		||  ＜2.80
//        血糖边缘高值	6.11-7.00   ||  7.81-11.10
//        血糖高值		＞7.00		||  ＞11.10
        if ((bloodSugarDto.getEAT() == 0 && 3.90 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 6.10) ||
                (bloodSugarDto.getEAT() == 1 && 3.90 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 7.80)) { //正常值
            bloodSugarTipDto.setTip("正常值");
        } else if (2.80 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 3.89) {//血糖偏低
            bloodSugarTipDto.setTip("血糖偏低");
        } else if (bloodSugarDto.getGLU() <= 2.80) {//低血糖
            bloodSugarTipDto.setTip("低血糖");
        } else if ((bloodSugarDto.getEAT() == 0 && 6.11 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 7.00) ||
                (bloodSugarDto.getEAT() == 1 && 7.81 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 11.10)) {//血糖边缘高值
            bloodSugarTipDto.setTip("血糖边缘高值");
        } else {
            bloodSugarTipDto.setTip("血糖高值");
        }
        BeanUtils.copyProperties(bloodSugarDto,bloodSugarTipDto);
        return bloodSugarTipDto;
    }
}
