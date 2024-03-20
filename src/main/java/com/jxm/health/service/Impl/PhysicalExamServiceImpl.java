package com.jxm.health.service.Impl;

import com.jxm.health.common.HealthScoreStandard;
import com.jxm.health.dto.PhysicalExamDto;
import com.jxm.health.mapper.PhysicalExamMapper;
import com.jxm.health.model.PhysicalExamModel;
import com.jxm.health.service.PhysicalExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<PhysicalExamDto> getPhysicalExams(int userId) {
        return physicalExamMapper.getPhysicalExams(userId);
    }

    @Override
    public PhysicalExamModel getPhysicalExamInfoById(int id) {
        return physicalExamMapper.getPhysicalExamInfoById(id);
    }

    @Override
    public int deletePhysicalExamInfoById(int id) {
        return physicalExamMapper.deletePhysicalExamInfoById(id);
    }

    @Override
    public int getPhysicalExamScore(int id) {
         int totalScore = 0;
        PhysicalExamModel physicalExamModel = physicalExamMapper.getPhysicalExamInfoById(id);
        //血糖打分
//        检测值范围		空腹	    ||	餐后2小时
//        正常值	       3.90-6.10	||  3.90-7.80
//        血糖偏低	    ≤3.89		||  ≤3.89
//        低血糖		    ＜2.80		||  ＜2.80
//        血糖边缘高值	6.11-7.00   ||  7.81-11.10
//        血糖高值		＞7.00		||  ＞11.10
        if((physicalExamModel.getBsEat() == 0 && 3.90 <= physicalExamModel.getBsGlu() && physicalExamModel.getBsGlu() <= 6.10) ||
                (physicalExamModel.getBsEat() == 1 && 3.90 <= physicalExamModel.getBsGlu() && physicalExamModel.getBsGlu() <= 7.80)) { //正常值
            totalScore += HealthScoreStandard.bloodSugarScore * HealthScoreStandard.bsNormalWeight;
        } else if (2.80 <= physicalExamModel.getBsGlu() && physicalExamModel.getBsGlu() <= 3.89) {//血糖偏低
            totalScore += HealthScoreStandard.bloodSugarScore * HealthScoreStandard.bsLowWeight;
        } else if (physicalExamModel.getBsGlu() <= 2.80) {//低血糖
            totalScore += HealthScoreStandard.bloodSugarScore * HealthScoreStandard.bsLowerWeight;
        } else if ((physicalExamModel.getBsEat() == 0 && 6.11 <= physicalExamModel.getBsGlu() && physicalExamModel.getBsGlu() <= 7.00) ||
                (physicalExamModel.getBsEat() == 1 && 7.81 <= physicalExamModel.getBsGlu() && physicalExamModel.getBsGlu() <= 11.10)) {//血糖边缘高值
            totalScore += HealthScoreStandard.bloodSugarScore * HealthScoreStandard.bsEdgeHeightWeight;
        } else {
            totalScore += HealthScoreStandard.bloodSugarScore * HealthScoreStandard.bsHeightWeight;
        }
//尿酸打分
//        检测值范围		男性（μmol/L）	女性（μmol/L）
//        正常值		     150-416		   89-357
//        高值		      ＞420			   ＞360
//        60岁以上人群	 250-476		   190-434
        if ((physicalExamModel.getGender() == 1 && 150 <= physicalExamModel.getUriValue() && physicalExamModel.getUriValue() < 416) ||
                (physicalExamModel.getGender() == 2 && 89 <= physicalExamModel.getUriValue() && physicalExamModel.getUriValue() < 357)) {//正常值
            totalScore += HealthScoreStandard.uricAcidScore*HealthScoreStandard.uricNormalWeight;
        } else if ((physicalExamModel.getGender() == 1 && physicalExamModel.getUriValue() > 420) ||
                (physicalExamModel.getGender() == 2 && physicalExamModel.getUriValue() > 360)) {//高值
            totalScore += HealthScoreStandard.uricAcidScore * HealthScoreStandard.uricHeightWeight;
        } else {
            totalScore += HealthScoreStandard.uricAcidScore * HealthScoreStandard.uricHeightOrderWeight;
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
        GKI = physicalExamModel.getBsGlu() / physicalExamModel.getBkValue();
        if (1 < GKI && GKI <= 3) {//治疗性高酮症状态
            totalScore += HealthScoreStandard.bloodKetoneScore * HealthScoreStandard.bkThreeLevelWeight;
        } else if (3 < GKI && GKI <= 6) {//治疗性高酮症状态
            totalScore += HealthScoreStandard.bloodKetoneScore * HealthScoreStandard.bkTwoLevelWeight;
        } else if (6 < GKI && GKI <= 9) {//初级酮症状态
            totalScore += HealthScoreStandard.bloodKetoneScore * HealthScoreStandard.bkOneLevelWeight;
        } else {//非酮症状态
            totalScore += HealthScoreStandard.bloodKetoneScore *HealthScoreStandard.bkNormalWeight;
        }
        //胆固醇
//        检测值范围		检测值（mmol/L）
//        正常值		    ＜5.18
//        边缘升高		5.18-6.19
//        升高		    ≥6.22 
        if (physicalExamModel.getChoValue() < 5.18) {//正常值
            totalScore += HealthScoreStandard.cholesterolScore * HealthScoreStandard.choNormalWeight;
        } else if (5.18 <= physicalExamModel.getChoValue() && physicalExamModel.getChoValue() < 6.19) {//边缘升高
            totalScore += HealthScoreStandard.cholesterolScore * HealthScoreStandard.choEdgeHeightWeight;
        } else {//升高
            totalScore += HealthScoreStandard.cholesterolScore * HealthScoreStandard.choHeightWeight;
        }
        //甘油三酯
//        检测值范围		检测值（mmol/L）
//        正常值		    ＜1.70
//        边缘升高		1.70-2.25
//        升高		    ≥2.26
//        高风险		    ≥5.60     
        if (physicalExamModel.getGlyValue() < 1.70) {//正常值
            totalScore += HealthScoreStandard.glycerolScore *HealthScoreStandard.glyNormalWeight;
        } else if (1.70 < physicalExamModel.getGlyValue() && physicalExamModel.getGlyValue() < 2.25) {//边缘升高
            totalScore += HealthScoreStandard.glycerolScore *HealthScoreStandard.glyOneLevelWeight;
        } else if (2.26 < physicalExamModel.getGlyValue() && physicalExamModel.getGlyValue() < 5.60) {//升高
            totalScore += HealthScoreStandard.glycerolScore * HealthScoreStandard.glyTwoLevelWeight;
        } else {//高风险
            totalScore += HealthScoreStandard.glycerolScore * HealthScoreStandard.glyThreeLevelWeight;
        }
        //血压打分
//        检测值范围	 	       高压			        低压
//        低血压		        ＜90和（或）			   ＜60
//        正常血压		    ＜120和			       ＜80
//        正常高值		    120-139和（或）		   80-89
//        1级高血压-轻度		140-159和（或）		   90-99
//        2级高血压-中度		160-179和（或）		   100-109
//        3级高血压-重度		≥180和（或）			   ≥110
        if (physicalExamModel.getBpSys() <= 90 || physicalExamModel.getBpDia() < 60) { //低血压
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpLowWeight;
        } else if (90 < physicalExamModel.getBpSys() && physicalExamModel.getBpSys() < 120 &&
                60 < physicalExamModel.getBpDia() && physicalExamModel.getBpDia() < 80) {//正常血压
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpNormalWeight;
        } else if ((120 < physicalExamModel.getBpSys() && physicalExamModel.getBpSys() < 139) ||
                (80 < physicalExamModel.getBpDia() && physicalExamModel.getBpDia() < 89)) {//正常高值
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpNormalHeightWeight;
        } else if ((140 < physicalExamModel.getBpSys() && physicalExamModel.getBpSys() < 159) ||
                (90 < physicalExamModel.getBpDia() && physicalExamModel.getBpDia() < 99)) {//1级高血压-轻度
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpOneLevelWeight;
        } else if ((160 < physicalExamModel.getBpSys() && physicalExamModel.getBpSys() < 179) ||
                (100 < physicalExamModel.getBpDia() && physicalExamModel.getBpDia() < 109)) {//2级高血压-中度
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpTwoLevelWeight;
        } else {//3级高血压-重度
            totalScore += HealthScoreStandard.bloodPressureScore * HealthScoreStandard.bpThreeLevelWeight;
        }
        
        return totalScore;
    }
}
