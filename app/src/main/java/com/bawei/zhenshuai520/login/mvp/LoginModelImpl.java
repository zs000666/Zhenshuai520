package com.bawei.zhenshuai520.login.mvp;

import android.util.Log;

import com.bawei.zhenshuai520.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class LoginModelImpl implements LoginController.LoginModel{

    private final HttpUtils httpUtils;

    public LoginModelImpl() {
        httpUtils = HttpUtils.getHttpUtils();
    }

    @Override
    public void showModel(String url, String phone, String pwd, HttpUtils.CallBack callBack) {

        httpUtils.doHttpPost(url,phone,pwd,callBack);
}
}
