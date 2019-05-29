package com.bawei.zhenshuai520.reguest.mvp;

import android.support.v7.widget.RecyclerView;

import com.bawei.zhenshuai520.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public interface ReguestController {
    public interface ReguestMpdel{
        void showModel(String url, String phone, String pwd,HttpUtils.CallBack callBack);
    }
    public interface ReguestView{
         void showReguest(String url);
    }
    public interface ReguestPresenter{
         void Attch(ReguestView view);
         void pttch();
         void showModel(String url,String phone,String pwd);
    }
}
