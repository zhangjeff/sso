package com.jeff.api;

/**
 * Created by zhangying on 2018/9/3.
 */
public interface AuthenticationRpcService {
    /**
     * 验证是否已经登录
     *
     * @param token
     *            授权码
     * @return
     */
    public boolean validate(String token);
}
