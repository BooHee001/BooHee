package com.boohee.boohee.View;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.boohee.boohee.R;
import com.boohee.boohee.presenter.P_Login_Impl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.Loig_Loading)
    View Loig_Loading;
    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.userpwd)
    EditText userpwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Loig_Loading.setVisibility(View.GONE);
    }

    public void back(View view){
        finish();
    }
    public void ZhuCe(View v){
        Intent intent = new Intent(LoginActivity.this,ZhuCeActivity.class);
        startActivity(intent);
    }
    public void Login(View v){
        Loig_Loading.setVisibility(View.VISIBLE);
        int userno =0;
        if(userName.getText().toString() !=null) {
            userno = Integer.parseInt(userName.getText().toString());
        }else {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
        }
        final String pwd = userpwd.getText().toString();
        final int finalUserno = userno;
        P_Login_Impl p_login_ = new P_Login_Impl(new V_Login() {
            @Override
            public void getResult(String result) {

                Loig_Loading.setVisibility(View.GONE);
                if("success".equals(result)){
                    SharedPreferences login = getSharedPreferences("Login", MODE_WORLD_READABLE + MODE_WORLD_WRITEABLE);
                    SharedPreferences.Editor edit = login.edit();
                    edit.putBoolean("islogin",true);
                    edit.putInt("userno", finalUserno);
                    edit.putString("pwd", pwd);
                    edit.commit();
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("userno", finalUserno);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
        p_login_.getResult(userno,pwd);

    }
}
