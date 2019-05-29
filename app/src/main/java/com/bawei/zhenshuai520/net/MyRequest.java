package com.bawei.zhenshuai520.net;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class MyRequest extends Application {

    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
    public static RequestQueue getQueue(){
        return requestQueue;
    }

}
