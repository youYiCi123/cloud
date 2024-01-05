package com.jxm.health.service;

import com.jxm.health.dto.UserHealthDto;

import java.text.ParseException;

public interface UserDataService {

    int uploadReal(UserHealthDto userHealthDto) throws ParseException;
}
