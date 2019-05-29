package com.bawei.zhenshuai520.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.zhenshuai520.R;
import com.bawei.zhenshuai520.api.Api;
import com.bawei.zhenshuai520.login.mvp.LoginController;
import com.bawei.zhenshuai520.login.mvp.LoginPresenterImpl;
import com.bawei.zhenshuai520.net.HttpUtils;

public class LoginActivity extends AppCompatActivity implements LoginController.LoginView {

    private LoginController.LoginModel mpdel;
    private LoginController.LoginPresenter presenter;
    private EditText edit_login_phone;
    private EditText edit_login_pwd;
    private CheckBox check;
    private TextView text_register;
    private Button login;
    private String phone;
    private String pwd;
    private SharedPreferences loginShape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HttpUtils httpUtils=HttpUtils.getHttpUtils();
        boolean net = httpUtils.isNet(LoginActivity.this);
        if (net){
            Toast.makeText(LoginActivity.this,"有网",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(LoginActivity.this,"没网",Toast.LENGTH_LONG).show();
            return;
        }

        //控件
        loginShape = getSharedPreferences("loginsp", MODE_PRIVATE);
        edit_login_phone = findViewById(R.id.edit_login_phone);
        edit_login_pwd = findViewById(R.id.edit_login_pwd);
        check = findViewById(R.id.check);
        text_register = findViewById(R.id.text_register);
        login = findViewById(R.id.login);


        //实例化
        presenter=new LoginPresenterImpl();
        //绑定数据
        presenter.Attch(this);

        if (loginShape.getBoolean("login",false)){
            edit_login_phone.setText(loginShape.getString("phone",phone));
            check.setChecked(true);
        }

        //注册
        text_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(LoginActivity.this,ReguestActivity.class));
            }
        });
        //登录
        this.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = edit_login_phone.getText().toString().trim();
                pwd = edit_login_pwd.getText().toString().trim();
                presenter.showModel(Api.login, phone, pwd);
                if (check.isChecked()){
                    loginShape.edit().putString("phone",phone).commit();
                    loginShape.edit().putString("pwd",pwd).commit();
                    loginShape.edit().putBoolean("login",true).commit();
                }else {
                    loginShape.edit().clear().commit();
                }
            }
        });
    }

    @Override
    public void showLogin(String url) {
       Toast.makeText(LoginActivity.this,url,Toast.LENGTH_LONG).show();
    }
    //解绑
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.pttch();
    }
}
