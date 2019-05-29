package com.bawei.zhenshuai520.reguest.mvp;

import android.support.v7.widget.RecyclerView;

import com.bawei.zhenshuai520.net.HttpUtils;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class ReguestPresenterImpl implements ReguestController.ReguestPresenter{
     private ReguestController.ReguestMpdel mpdel;
     private ReguestController.ReguestView views;

    @Override
    public void Attch(ReguestController.ReguestView view) {
          this.views=view;
          mpdel=new ReguestModelImpl();
    }

    @Override
    public void pttch() {
           if (views!=null){
               views=null;
           }
           if (mpdel!=null){
               mpdel=null;
           }
    }

    @Override
    public void showModel(String url, String phone, String pwd) {
           mpdel.showModel(url, phone, pwd, new HttpUtils.CallBack() {
               @Override
               public void onSuccess(String result) {
                   views.showReguest(result);
               }

               @Override
               public void onFail(String msg) {

               }
           });
    }
}
