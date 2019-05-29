package com.bawei.zhenshuai520.reguest.mvp;

import com.bawei.zhenshuai520.net.HttpUtils;

import java.net.URLEncoder;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class ReguestModelImpl implements ReguestController.ReguestMpdel{

    private final HttpUtils utils;

    public ReguestModelImpl() {
        utils = HttpUtils.getHttpUtils();
    }

    @Override
    public void showModel(String url, String phone, String pwd, HttpUtils.CallBack callBack) {
        utils.doHttpPost(url,phone,pwd,callBack);
    }
}
