package com.bawei.zhenshuai520.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:甄帅
 *@Date: 时间
 *@Description:功能
 * */public class HttpUtils {
     //单例
     private static HttpUtils httpUtils=new HttpUtils();
     public static HttpUtils getHttpUtils(){
         return httpUtils;
     }
     private HttpUtils(){

     }
     //判断网络
    public boolean isNet(Context context){
         ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null){
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }
    //get请求数据  volley
    public void doHttpget(String  url, final CallBack back){
        StringRequest request=new StringRequest(com.android.volley.Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                back.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                back.onFail(error.getMessage());
            }
        });
        //响应
        MyRequest.getQueue().add(request);
    }
    //post请求
    public void doHttpPost(String url, String phone, String pwd, final CallBack back){
        final Map<String,String> param=new HashMap<>();
        param.put("phone",phone);
        param.put("pwd",pwd);
        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                back.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                back.onFail(error.getMessage());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };

        MyRequest.getQueue().add(request);
    }
    //接口
    public interface CallBack{
        void onSuccess(String result);
        void onFail(String msg);
    }
}
