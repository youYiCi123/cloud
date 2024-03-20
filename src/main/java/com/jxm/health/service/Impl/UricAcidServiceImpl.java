package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.UricAcidDto;
import com.jxm.health.dto.UricAcidTipDto;
import com.jxm.health.mapper.UricAcidMapper;
import com.jxm.health.service.UricAcidService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UricAcidServiceImpl implements UricAcidService {

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @Override
    public UricAcidTipDto getLastedData(int userId) {
        UricAcidDto uricAcidDto = uricAcidMapper.getLastedData(userId);
        UricAcidTipDto uricAcidTipDto = new UricAcidTipDto();
        if(uricAcidDto==null){
            return uricAcidTipDto;
        }
        //尿酸打分
//        检测值范围		男性（μmol/L）	女性（μmol/L）
//        正常值		     150-416		   89-357
//        高值		      ＞420			   ＞360
//        60岁以上人群	 250-476		   190-434
        if ((uricAcidDto.getGender() == 1 && 150 <= uricAcidDto.getURI() && uricAcidDto.getURI() < 416) ||
                (uricAcidDto.getGender() == 2 && 89 <= uricAcidDto.getURI() && uricAcidDto.getURI() < 357)) {//正常值
            uricAcidTipDto.setTip("正常值");
        } else if ((uricAcidDto.getGender() == 1 && uricAcidDto.getURI() > 420) ||
                (uricAcidDto.getGender() == 2 && uricAcidDto.getURI() > 360)) {//高值
            uricAcidTipDto.setTip("高值");
        } else {
            uricAcidTipDto.setTip("");
        }
        BeanUtils.copyProperties(uricAcidDto,uricAcidTipDto);
        return uricAcidTipDto;
    }
}
