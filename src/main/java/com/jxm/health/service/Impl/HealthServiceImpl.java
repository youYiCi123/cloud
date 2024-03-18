package com.jxm.health.service.Impl;

import com.jxm.health.service.HealthService;
import com.jxm.health.thread.HealthCall;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Service
public class HealthServiceImpl implements HealthService {

    @Override
    public int getRealTimeScore(int userId) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft1 = new FutureTask<>(new HealthCall(userId,1));
        FutureTask<Integer> ft2 = new FutureTask<>(new HealthCall(userId,2));
        FutureTask<Integer> ft3 = new FutureTask<>(new HealthCall(userId,3));
        new Thread(ft1).start();
        new Thread(ft2).start();
        new Thread(ft3).start();
        return ft1.get() + ft2.get() + ft3.get();
    }
}
