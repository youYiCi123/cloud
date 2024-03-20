package com.jxm.health.common;

public class HealthScoreStandard {

    public static int bloodSugarScore = 25;//血糖分数
    public static int bloodPressureScore = 35;//血压分数
    public static int uricAcidScore = 10;//尿酸分数
    public static int cholesterolScore = 10;//胆固醇分数
    public static int bloodKetoneScore = 10;//血酮分数
    public static int glycerolScore = 10;//甘油分数

//血糖打分
//        检测值范围		空腹	    ||	餐后2小时         ||    比重
//        正常值	       3.90-6.10	||  3.90-7.80        ||    1
//        血糖偏低	    ≤3.89		||  ≤3.89            ||    0.55
//        低血糖		    ＜2.80		||  ＜2.80           ||    0.45
//        血糖边缘高值	6.11-7.00   ||  7.81-11.10       ||    0.55
//        血糖高值		＞7.00		||  ＞11.10          ||    0.45
    public static double bsNormalWeight = 1;
    public static double bsLowWeight = 0.55;
    public static double bsLowerWeight = 0.45;
    public static double bsEdgeHeightWeight = 0.55;
    public static double bsHeightWeight = 0.45;


//尿酸打分
//        检测值范围		男性（μmol/L）	女性（μmol/L）      ||    比重
//        正常值		     150-416		   89-357          ||    1
//        高值		      ＞420			   ＞360           ||    0.55
//        60岁以上人群	 250-476		   190-434         ||    0.45
    public static double uricNormalWeight = 1;
    public static double uricHeightWeight = 0.55;
    public static double uricHeightOrderWeight = 0.45;

//血酮
//        葡萄糖酮指数GKI=血糖值（mmol/L）/血酮值（mmol/L）
//        GKI	    状态		应用
//        ≤1	治疗性最高酮症状态	 需在医生指导下进行
//        1-3	治疗性高酮症状态		 可用于治疗癌，癫痫，老年痴呆，帕金森，脑损伤和长期性发炎
//        3-6	中级酮症状态		     可以改善二型糖尿病，肥胖，胰岛素抵抗，代谢病或内分泌失调
//        6-9	初级酮症状态		     减脂和保持健康的状态
//        ≥9	非酮症状态		     N/A
    public static double bkNormalWeight = 1;
    public static double bkOneLevelWeight = 0.55;
    public static double bkTwoLevelWeight = 0.45;
    public static double bkThreeLevelWeight = 0.35;
    public static double bkFourLevelWeight = 0.25;

    //胆固醇
//        检测值范围		检测值（mmol/L）     ||   比重
//        正常值		    ＜5.18              ||   1
//        边缘升高		5.18-6.19           ||   0.55
//        升高		    ≥6.22               ||   0.45
    public static double choNormalWeight = 1;
    public static double choEdgeHeightWeight = 0.55;
    public static double choHeightWeight = 0.45;

    //甘油三酯
//        检测值范围		检测值（mmol/L）     ||   比重
//        正常值		    ＜1.70              ||   1
//        边缘升高		1.70-2.25           ||  0.55
//        升高		    ≥2.26               ||  0.45
//        高风险		    ≥5.60               ||  0.35
    public static double glyNormalWeight = 1;
    public static double glyOneLevelWeight = 0.55;
    public static double glyTwoLevelWeight = 0.45;
    public static double glyThreeLevelWeight = 0.35;

    //血压打分
//        检测值范围	 	       高压			        低压       ||   比重
//        低血压		        ＜90和（或）			   ＜60        ||   0.45
//        正常血压		    ＜120和			       ＜80        ||   1
//        正常高值		    120-139和（或）		   80-89       ||   0.55
//        1级高血压-轻度		140-159和（或）		   90-99       ||   0.45
//        2级高血压-中度		160-179和（或）		   100-109     ||   0.35
//        3级高血压-重度		≥180和（或）			   ≥110        ||   0.30
    public static double bpLowWeight = 0.45;
    public static double bpNormalWeight = 1;
    public static double bpNormalHeightWeight = 0.55;
    public static double bpOneLevelWeight = 0.45;
    public static double bpTwoLevelWeight = 0.35;
    public static double bpThreeLevelWeight = 0.30;


}
