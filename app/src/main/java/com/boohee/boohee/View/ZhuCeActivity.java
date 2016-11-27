package com.boohee.boohee.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.boohee.boohee.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuCeActivity extends AppCompatActivity {

    @BindView(R.id.zhuce_userpwd2)
    EditText zhuce_userpwd2;
    @BindView(R.id.zhuce_userpwd)
    EditText zhuce_userpwd;
    @BindView(R.id.zhuce_userName)
    EditText zhuce_userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        ButterKnife.bind(this);
    }

    public void back(View v) {
        finish();
    }

    public void next(View v) {
        String pwd = zhuce_userpwd.getText().toString().trim();
        String pwd2 = zhuce_userpwd2.getText().toString().trim();
        int userno = 0;
        try {
            if (TextUtils.isEmpty(zhuce_userName.getText().toString().trim())) {
                Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            } else {
                userno = Integer.parseInt(zhuce_userName.getText().toString().trim());
            }
            if(!TextUtils.isEmpty(pwd)) {
                if(!TextUtils.isEmpty(pwd2))
                    if ( pwd2.toString().equals(pwd.toString())) {
                        Intent intent = new Intent(this, ZhuCe2Activity.class);
                        intent.putExtra("zhuce_pwd", pwd);
                        intent.putExtra("zhuce_userno", userno);
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, "两次密码不同", Toast.LENGTH_SHORT).show();

                    }else {
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            }

        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
