package com.jxm.health.service.Impl;

import com.jxm.health.dto.UserHealthDto;
import com.jxm.health.mapper.*;
import com.jxm.health.model.*;
import com.jxm.health.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        //血压
        if(userHealthDto.getSYS()!=null&&userHealthDto.getDIA()!=null){
            BloodPressureModel bloodPressureModel = new BloodPressureModel();
            bloodPressureModel.setUserId(userHealthDto.getUSERID());
            bloodPressureModel.setSYS(userHealthDto.getSYS());
            bloodPressureModel.setDIA(userHealthDto.getDIA());
            bloodPressureModel.setPUL(userHealthDto.getPUL());
            bloodPressureModel.setTestTime(testTime);
            count=bloodPressureMapper.insert(bloodPressureModel);
        }
        //血氧
        if(userHealthDto.getXY()!=null){
            BloodOxygenModel bloodOxygenModel = new BloodOxygenModel();
            bloodOxygenModel.setUserId(userHealthDto.getUSERID());
            bloodOxygenModel.setXY(userHealthDto.getXY());
            bloodOxygenModel.setHR(userHealthDto.getHR());
            bloodOxygenModel.setTestTime(testTime);
            count=bloodOxygenMapper.insert(bloodOxygenModel);
        }
        //血糖
        if(userHealthDto.getGLU()!=null){
            BloodSugarModel bloodSugarModel = new BloodSugarModel();
            bloodSugarModel.setUserId(userHealthDto.getUSERID());
            bloodSugarModel.setEAT(userHealthDto.getEAT());
            bloodSugarModel.setGLU(userHealthDto.getGLU());
            bloodSugarModel.setTestTime(testTime);
            count=bloodSugarMapper.insert(bloodSugarModel);
        }
        //胆固醇
        if(userHealthDto.getCHO()!=null){
            CholesterolModel cholesterolModel = new CholesterolModel();
            cholesterolModel.setUserId(userHealthDto.getUSERID());
            cholesterolModel.setCHO(userHealthDto.getCHO());
            cholesterolModel.setTestTime(testTime);
            count=cholesterolMapper.insert(cholesterolModel);
        }
        //甘油
        if(userHealthDto.getTRI()!=null){
            GlycerolModel glycerolModel = new GlycerolModel();
            glycerolModel.setUserId(userHealthDto.getUSERID());
            glycerolModel.setTRI(userHealthDto.getTRI());
            glycerolModel.setTestTime(testTime);
            count=glycerolMapper.insert(glycerolModel);
        }
        //血酮
        if(userHealthDto.getBK()!=null){
            BloodKetoneModel bloodKetoneModel = new BloodKetoneModel();
            bloodKetoneModel.setUserId(userHealthDto.getUSERID());
            bloodKetoneModel.setBK(userHealthDto.getBK());
            bloodKetoneModel.setTestTime(testTime);
            count=bloodKetoneMapper.insert(bloodKetoneModel);
        }
        //尿酸
        if(userHealthDto.getURI()!=null){
            UricAcidModel uricAcidModel = new UricAcidModel();
            uricAcidModel.setUserId(userHealthDto.getUSERID());
            uricAcidModel.setURI(userHealthDto.getURI());
            uricAcidModel.setTestTime(testTime);
            count=uricAcidMapper.insert(uricAcidModel);
        }
            return count;
    }

}
