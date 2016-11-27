package com.boohee.boohee.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.boohee.boohee.R;

public class Message_Classifcamation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_classification);
    }

    public void onclick(View view){
        switch (view.getId()){
            case R.id.message_classification_back:
                finish();
                break;
            case R.id.message_classification_Allread:
                Toast.makeText(Message_Classifcamation.this, "当前没有消息哦~", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_mentions:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_comment:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_incurredjewel:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_newfans:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_recommend:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_broadcast:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_contactservices:
                Toast.makeText(Message_Classifcamation.this, "连接不上服务器哦~待会再试吧？", Toast.LENGTH_SHORT).show();
                break;


        }
    }

}
