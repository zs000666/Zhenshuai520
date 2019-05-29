package com.bawei.zhenshuai520.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bawei.zhenshuai520.R;
import com.bawei.zhenshuai520.api.Api;
import com.bawei.zhenshuai520.reguest.mvp.ReguestController;
import com.bawei.zhenshuai520.reguest.mvp.ReguestPresenterImpl;

public class ReguestActivity extends AppCompatActivity implements ReguestController.ReguestView {
    private ReguestController.ReguestPresenter presenter;
    private ReguestController.ReguestMpdel mpdel;
    private ImageView image_phone;
    private Button request;
    private EditText edit_reguest_phone;
    private ImageView image_yzm;
    private EditText edit_request_ym;
    private ImageView image_lock;
    private EditText edit_request_pwd;
    private ImageView image_eye;
    private String reguest_phone;
    private String request_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reguest);
        //控件
        request = findViewById(R.id.request);
        edit_reguest_phone = findViewById(R.id.edit_reguest_phone);
        edit_request_pwd = findViewById(R.id.edit_request_pwd);

        presenter=new ReguestPresenterImpl();
        presenter.Attch(this);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reguest_phone = edit_reguest_phone.getText().toString().trim();
                request_pwd = edit_request_pwd.getText().toString().trim();
                startActivity(new Intent(ReguestActivity.this,LoginActivity.class));
            }
        });
    }

    @Override
    public void showReguest(String url) {
        presenter.showModel(Api.reguest,reguest_phone,request_pwd);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.pttch();
    }
}
