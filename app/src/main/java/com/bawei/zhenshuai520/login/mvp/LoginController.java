package com.bawei.zhenshuai520.login.mvp;

import com.bawei.zhenshuai520.net.HttpUtils;
import com.bawei.zhenshuai520.reguest.mvp.ReguestController;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public interface LoginController {
     public interface LoginModel{
          void showModel(String url, String phone, String pwd, HttpUtils.CallBack callBack);
     }
     public interface LoginView{
          void showLogin(String url);
     }
     public interface LoginPresenter{
          void Attch(LoginView view);
          void pttch();
          void showModel(String url,String phone,String pwd);
     }
}
