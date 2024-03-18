package com.jxm.health.service;

import java.util.concurrent.ExecutionException;

public interface HealthService {

    //获取实时分数
    int getRealTimeScore(int userId) throws ExecutionException, InterruptedException;
}
