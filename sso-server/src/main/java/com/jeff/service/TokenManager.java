package com.jeff.service;

import com.jeff.entity.User;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhangying on 2018/9/3.
 */
public abstract class TokenManager {

    private final Timer timer = new Timer(true);


    // 每分钟执行一次
    public TokenManager() {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                verifyExpired();
            }
        }, 60 * 1000, 60 * 1000);
    }

    /**
     * 验证失效token
     */
    public abstract void verifyExpired();

    /**
     * 验证令牌有效性,有效则延长session生命周期
     *
     * @param token
     * @return
     */
    public abstract User validate(String token);

}
