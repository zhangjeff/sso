package com.jeff.service;

import com.jeff.api.AuthenticationRpcService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zhangying on 2018/9/4.
 */

public class AuthenticationRpcServiceImpl implements AuthenticationRpcService {

    @Resource
    private TokenManager tokenManager;

    @Override
    public boolean validate(String token) {
        return tokenManager.validate(token) != null;
    }
}
