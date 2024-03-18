package com.jxm.health.service.Impl;

import com.jxm.health.dto.UserHealthDto;
import com.jxm.health.mapper.*;
import com.jxm.health.model.*;
import com.jxm.health.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserDataServiceImpl implements UserDataService {

    @Autowired
    private BloodPressureMapper bloodPressureMapper;

    @Autowired
    private BloodOxygenMapper bloodOxygenMapper;

    @Autowired
    private BloodSugarMapper bloodSugarMapper;

    @Autowired
    private CholesterolMapper cholesterolMapper;

    @Autowired
    private GlycerolMapper glycerolMapper;

    @Autowired
    private BloodKetoneMapper bloodKetoneMapper;

    @Autowired
    private UricAcidMapper uricAcidMapper;

    @Override
    public int uploadReal(UserHealthDto userHealthDto) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(userHealthDto.getUSERID()==null||userHealthDto.getTESTTIME()==null){
            return -1;
        }
        Date testTime = sdf.parse(userHealthDto.getTESTTIME());
        int count =0;
        System.out.println("====================");
        System.out.println(userHealthDto);
        System.out.println("====================");
        //血压
        if(userHealthDto.getSYS()!=null&&userHealthDto.getDIA()!=null&&
                !userHealthDto.getSYS().equals(0)&&!userHealthDto.getDIA().equals(0)){
            BloodPressureModel bloodPressureModel = new BloodPressureModel();
            bloodPressureModel.setUserId(userHealthDto.getUSERID());
            bloodPressureModel.setSYS(userHealthDto.getSYS());
            bloodPressureModel.setDIA(userHealthDto.getDIA());
            bloodPressureModel.setPUL(userHealthDto.getPUL());
            bloodPressureModel.setTestTime(testTime);
            count=bloodPressureMapper.insert(bloodPressureModel);
        }
        //血氧
        if(userHealthDto.getXY()!=null&&!userHealthDto.getXY().equals(0)){
            BloodOxygenModel bloodOxygenModel = new BloodOxygenModel();
            bloodOxygenModel.setUserId(userHealthDto.getUSERID());
            bloodOxygenModel.setXY(userHealthDto.getXY());
            bloodOxygenModel.setHR(userHealthDto.getHR());
            bloodOxygenModel.setTestTime(testTime);
            count=bloodOxygenMapper.insert(bloodOxygenModel);
        }
        //血糖
        if(userHealthDto.getGLU()!=null&&!userHealthDto.getGLU().equals((float) 0)){
            BloodSugarModel bloodSugarModel = new BloodSugarModel();
            bloodSugarModel.setUserId(userHealthDto.getUSERID());
            bloodSugarModel.setEAT(userHealthDto.getEAT());
            bloodSugarModel.setGLU(userHealthDto.getGLU());
            bloodSugarModel.setTestTime(testTime);
            count=bloodSugarMapper.insert(bloodSugarModel);
        }
        //胆固醇
        if(userHealthDto.getCHO()!=null&&!userHealthDto.getCHO().equals((float) 0)){
            CholesterolModel cholesterolModel = new CholesterolModel();
            cholesterolModel.setUserId(userHealthDto.getUSERID());
            cholesterolModel.setCHO(userHealthDto.getCHO());
            cholesterolModel.setTestTime(testTime);
            count=cholesterolMapper.insert(cholesterolModel);
        }
        //甘油
        if(userHealthDto.getTRI()!=null&&!userHealthDto.getTRI().equals((float) 0)){
            GlycerolModel glycerolModel = new GlycerolModel();
            glycerolModel.setUserId(userHealthDto.getUSERID());
            glycerolModel.setTRI(userHealthDto.getTRI());
            glycerolModel.setTestTime(testTime);
            count=glycerolMapper.insert(glycerolModel);
        }
        //血酮
        if(userHealthDto.getBK()!=null&&!userHealthDto.getBK().equals((float) 0)){
            BloodKetoneModel bloodKetoneModel = new BloodKetoneModel();
            bloodKetoneModel.setUserId(userHealthDto.getUSERID());
            bloodKetoneModel.setBK(userHealthDto.getBK());
            bloodKetoneModel.setTestTime(testTime);
            count=bloodKetoneMapper.insert(bloodKetoneModel);
        }
        //尿酸
        if(userHealthDto.getURI()!=null&&!userHealthDto.getURI().equals(0)){
            UricAcidModel uricAcidModel = new UricAcidModel();
            uricAcidModel.setUserId(userHealthDto.getUSERID());
            uricAcidModel.setURI(userHealthDto.getURI());
            uricAcidModel.setTestTime(testTime);
            count=uricAcidMapper.insert(uricAcidModel);
        }
            return count;
    }

}
