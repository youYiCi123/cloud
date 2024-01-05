package com.jxm.health.service.Impl;

import com.jxm.health.dto.*;
import com.jxm.health.mapper.*;
import com.jxm.health.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    int bloodSugarScore=25;//血糖分数
    int bloodPressureScore=35;//血压分数
    int uricAcidScore=10;//尿酸分数
    int cholesterolScore=10;//胆固醇分数
    int bloodKetoneScore=10;//血酮分数
    int glycerolScore=10;//甘油分数

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @Autowired
    private CholesterolMapper cholesterolMapper;

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Override
    public int getRealTimeScore(String userId) {

        int totalScore = 0;
//血糖打分
//        检测值范围		空腹	    ||	餐后2小时
//        正常值	       3.90-6.10	||  3.90-7.80
//        血糖偏低	    ≤3.89		||  ≤3.89
//        低血糖		    ＜2.80		||  ＜2.80
//        血糖边缘高值	6.11-7.00   ||  7.81-11.10
//        血糖高值		＞7.00		||  ＞11.10
        BloodSugarDto bloodSugarDto = bloodSugarMapper.getLastedData(userId);
        if (bloodSugarDto == null) {
            return 0;
        } else if ((bloodSugarDto.getEAT() == 0 && 3.90 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 6.10) ||
                (bloodSugarDto.getEAT() == 1 && 3.90 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 7.80)) { //正常值
            totalScore+=bloodSugarScore;
        } else if (2.80 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 3.89) {//血糖偏低
            totalScore+=bloodSugarScore*0.55;
        } else if (bloodSugarDto.getGLU() <= 2.80) {//低血糖
            totalScore+=bloodSugarScore*0.45;
        } else if ((bloodSugarDto.getEAT() == 0 && 6.11 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 7.00) ||
                (bloodSugarDto.getEAT() == 1 && 7.81 <= bloodSugarDto.getGLU() && bloodSugarDto.getGLU() <= 11.10)) {//血糖边缘高值
            totalScore+=bloodSugarScore*0.55;
        } else {
            totalScore+=bloodSugarScore*0.45;
        }
//尿酸打分
//        检测值范围		男性（μmol/L）	女性（μmol/L）
//        正常值		     150-416		   89-357
//        高值		      ＞420			   ＞360
//        60岁以上人群	 250-476		   190-434

        UricAcidDto uricAcidDto = uricAcidMapper.getLastedData(userId);
        if (uricAcidDto == null) {
            return 0;
        } else if ((uricAcidDto.getGender() == 1 && 150 <= uricAcidDto.getURI() && uricAcidDto.getURI() < 416) ||
                (uricAcidDto.getGender() == 2 && 89 <= uricAcidDto.getURI() && uricAcidDto.getURI() < 357)) {//正常值
            totalScore+=uricAcidScore;
        } else if ((uricAcidDto.getGender() == 1 && uricAcidDto.getURI() > 420) ||
                (uricAcidDto.getGender() == 2 && uricAcidDto.getURI() > 360)) {//高值
            totalScore+=uricAcidScore*0.55;
        } else {
            totalScore+=uricAcidScore*0.45;
        }

//血压打分
//        检测值范围	 	       高压			        低压
//        低血压		        ＜90和（或）			   ＜60
//        正常血压		    ＜120和			       ＜80
//        正常高值		    120-139和（或）		   80-89
//        1级高血压-轻度		140-159和（或）		   90-99
//        2级高血压-中度		160-179和（或）		   100-109
//        3级高血压-重度		≥180和（或）			   ≥110

        BloodPressureDto bloodPressureDto = bloodPressureMapper.getLastedData(userId);
        if (bloodPressureDto == null) {
            return 0;
        } else if (bloodPressureDto.getSYS() <= 90 || bloodPressureDto.getDIA() < 60) { //低血压
            totalScore+=bloodPressureScore*0.45;
        } else if (90 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 120 &&
                60 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 80) {//正常血压
            totalScore+=bloodPressureScore;
        } else if ((120 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 139) ||
                (80 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 89)) {//正常高值
            totalScore+=bloodPressureScore*0.55;
        } else if ((140 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 159) ||
                (90 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 99)) {//1级高血压-轻度
            totalScore+=bloodPressureScore*0.45;
        } else if ((160 < bloodPressureDto.getSYS() && bloodPressureDto.getSYS() < 179) ||
                (100 < bloodPressureDto.getDIA() && bloodPressureDto.getDIA() < 109)) {//2级高血压-中度
            totalScore+=bloodPressureScore*0.35;
        } else {//3级高血压-重度
            totalScore+=bloodPressureScore*0.30;
        }
//胆固醇
//        检测值范围		检测值（mmol/L）
//        正常值		    ＜5.18
//        边缘升高		5.18-6.19
//        升高		    ≥6.22

        CholesterolDto cholesterolDto = cholesterolMapper.getLastedData(userId);
        if (cholesterolDto == null) {
            return 0;
        } else if (cholesterolDto.getCHO() < 5.18) {//正常值
            totalScore+=cholesterolScore;
        } else if (5.18 <= cholesterolDto.getCHO() && cholesterolDto.getCHO() < 6.19) {//边缘升高
            totalScore+=cholesterolScore*0.55;
        } else {//升高
            totalScore+=cholesterolScore*0.45;
        }
//甘油三酯
//        检测值范围		检测值（mmol/L）
//        正常值		    ＜1.70
//        边缘升高		1.70-2.25
//        升高		    ≥2.26
//        高风险		    ≥5.60
        GlycerolDto glycerolDto = glycerolMapper.getLastedData(userId);
        if (glycerolDto == null) {
            return 0;
        } else if (glycerolDto.getTRI() < 1.70) {//正常值
            totalScore+=glycerolScore;
        } else if (1.70 < glycerolDto.getTRI() && glycerolDto.getTRI() < 2.25) {//边缘升高
            totalScore+=glycerolScore*0.55;
        } else if (2.26 < glycerolDto.getTRI() && glycerolDto.getTRI() < 5.60) {//升高
            totalScore+=glycerolScore*0.45;
        } else {//高风险
            totalScore+=glycerolScore*0.35;
        }
//血酮
//        葡萄糖酮指数GKI=血糖值（mmol/L）/血酮值（mmol/L）
//        GKI	    状态		应用
//        ≤1	治疗性最高酮症状态	 需在医生指导下进行
//        1-3	治疗性高酮症状态		 可用于治疗癌，癫痫，老年痴呆，帕金森，脑损伤和长期性发炎
//        3-6	中级酮症状态		     可以改善二型糖尿病，肥胖，胰岛素抵抗，代谢病或内分泌失调
//        6-9	初级酮症状态		     减脂和保持健康的状态
//        ≥9	非酮症状态		     N/A
        BloodKetoneDto bloodKetoneDto = bloodKetoneMapper.getLastedData(userId);
        float GKI = 0;
        if (bloodKetoneDto == null)
            return 0;
        GKI = bloodSugarDto.getGLU() / bloodKetoneDto.getBK();
        if (GKI <= 1) {//治疗性最高酮症状态
            totalScore+=bloodKetoneScore*0.25;
        } else if (1 < GKI && GKI <= 3) {//治疗性高酮症状态
            totalScore+=bloodKetoneScore*0.35;
        } else if (3 < GKI && GKI <= 6) {//治疗性高酮症状态
            totalScore+=bloodKetoneScore*0.45;
        } else if (6 < GKI && GKI <= 9) {//初级酮症状态
            totalScore+=bloodKetoneScore*0.55;
        } else {//非酮症状态
            totalScore+=bloodKetoneScore;
        }
        return totalScore;
    }
}
