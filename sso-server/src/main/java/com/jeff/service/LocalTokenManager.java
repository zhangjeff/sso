package com.jeff.service;

import com.jeff.entity.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangying on 2018/9/3.
 */
public class LocalTokenManager extends  TokenManager{

    private final ConcurrentHashMap<String, DummyUser> tokenMap = new ConcurrentHashMap<String, DummyUser>();

    @Override
    public void verifyExpired(){
        Date now = new Date();
        for (Map.Entry<String, DummyUser> entry : tokenMap.entrySet()) {
            String token = entry.getKey();
            DummyUser dummyUser = entry.getValue();
            // 当前时间大于过期时间
            if (now.compareTo(dummyUser.expired) > 0) {
                // 已过期，清除对应token
                if (now.compareTo(dummyUser.expired) > 0) {
                    tokenMap.remove(token);
                    System.out.println("token : " + token + "已失效");
                }
            }
        }
    }

    @Override
    public User validate(String token) {
        DummyUser dummyUser = tokenMap.get(token);
        if (dummyUser == null) {
            return null;
        }
        extendExpiredTime(dummyUser);
        return dummyUser.user;
    }

    private void extendExpiredTime(DummyUser dummyUser) {
        dummyUser.expired = new Date(new Date().getTime() + 3000);
    }

    private class DummyUser {
        private User user;
        private Date expired; // 过期时间
    }

    @Override
    public void addToken(String token, User user) {
        DummyUser dummyUser = new DummyUser();
        dummyUser.user=user;
        dummyUser.expired = new Date(new Date().getTime() + 3000);
        tokenMap.put(token, dummyUser);
    }
}
