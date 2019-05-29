package com.bawei.zhenshuai520.login.mvp;

import com.bawei.zhenshuai520.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class LoginPresenterImpl implements LoginController.LoginPresenter{
     private LoginController.LoginModel model;
     private LoginController.LoginView views;


    @Override
    public void Attch(LoginController.LoginView view) {
        this.views=view;
        model= (LoginController.LoginModel) new LoginModelImpl();
    }

    @Override
    public void pttch() {
        if (views!=null){
            views=null;
        }
        if (model!=null){
            model=null;
        }
    }

    @Override
    public void showModel(String url, String phone, String pwd) {
        model.showModel(url, phone, pwd, new HttpUtils.CallBack() {
            @Override
            public void onSuccess(String result) {
                views.showLogin(result);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
