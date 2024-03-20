package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.BloodKetoneDto;
import com.jxm.health.dto.BloodKetoneTipDto;
import com.jxm.health.mapper.BloodKetoneMapper;
import com.jxm.health.service.BloodKetoneService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloodKetoneServiceImpl implements BloodKetoneService {

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Override
    public BloodKetoneTipDto getLastedData(int userId, Float GLU) {
        BloodKetoneDto bloodKetoneDto = bloodKetoneMapper.getLastedData(userId);
        BloodKetoneTipDto bloodKetoneTipDto = new BloodKetoneTipDto();
        if(bloodKetoneDto==null){
            return bloodKetoneTipDto;
        }
        //血酮
//        葡萄糖酮指数GKI=血糖值（mmol/L）/血酮值（mmol/L）
//        GKI	    状态		应用
//        ≤1	治疗性最高酮症状态	 需在医生指导下进行
//        1-3	治疗性高酮症状态		 可用于治疗癌，癫痫，老年痴呆，帕金森，脑损伤和长期性发炎
//        3-6	中级酮症状态		     可以改善二型糖尿病，肥胖，胰岛素抵抗，代谢病或内分泌失调
//        6-9	初级酮症状态		     减脂和保持健康的状态
//        ≥9	非酮症状态		     N/A
        float GKI = 0;
        GKI = GLU / bloodKetoneDto.getBK();
        if (GKI <= 1) {//治疗性最高酮症状态
            bloodKetoneTipDto.setTip("治疗性最高酮症状态");
        } else if (1 < GKI && GKI <= 3) {//治疗性高酮症状态
            bloodKetoneTipDto.setTip("治疗性高酮症状态");
        } else if (3 < GKI && GKI <= 6) {//中级酮症状态
            bloodKetoneTipDto.setTip("中级酮症状态");
        } else if (6 < GKI && GKI <= 9) {//初级酮症状态
            bloodKetoneTipDto.setTip("初级酮症状态");
        } else {//非酮症状态
            bloodKetoneTipDto.setTip("非酮症状态");
        }
        BeanUtils.copyProperties(bloodKetoneDto,bloodKetoneTipDto);
        return bloodKetoneTipDto;
    }

}
