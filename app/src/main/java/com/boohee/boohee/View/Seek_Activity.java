package com.boohee.boohee.View;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.PhotoBean.Seek_Bean;
import com.boohee.boohee.PhotoBean.Seek_list_Bean;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Partner_View.V_Seek;
import com.boohee.boohee.View.Partner_View.V_Seek_list_item;
import com.boohee.boohee.adapter.Seek_GridView_Adapter;
import com.boohee.boohee.adapter.Seek_list_item_Adapter;
import com.boohee.boohee.presenter.P_Seek;
import com.boohee.boohee.presenter.P_Seek_Impl;
import com.boohee.boohee.presenter.P_Seek_list_item;
import com.boohee.boohee.presenter.P_Seek_list_item_Impl;
import com.google.gson.Gson;

import org.w3c.dom.Text;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class Seek_Activity extends AppCompatActivity {

    private GridView seek_gridview = null;
    private EditText load_txt = null;
    private Seek_list_Bean seek_list_Bean;
    String Search_food;
//    Seek_Bean seek_bean;

    private ProgressBar Seek_Loading = null;
    private ListView Seek_list = null;
    private TextView seek_istext = null;
    private RelativeLayout seek_bigmain = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek);

        initView();

        initData();
    }

    private void initData() {


        P_Seek_Impl p_Seek_Impl = new P_Seek_Impl(new V_Seek() {
            @Override
            public void setSeek_Beans(final Seek_Bean seek_bean) {

                Seek_Loading.setVisibility(View.VISIBLE);

                if (seek_bean!=null){

                    seek_gridview.setAdapter(new Seek_GridView_Adapter(Seek_Activity.this,seek_bean));
                    seek_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String abc = seek_bean.getKeywords().get(position);
                            load_txt.setText(abc);
                        }
                    });


                }else{
                    Toast.makeText(Seek_Activity.this, "与服务器断开连接啦……", Toast.LENGTH_SHORT).show();
                }
                Seek_Loading.setVisibility(View.GONE);


            }
        });
        p_Seek_Impl.initSeek();

    }

    private void initView() {
        seek_gridview = (GridView) findViewById(R.id.seek_gridview);
        load_txt = (EditText) findViewById(R.id.load_txt);
        Seek_list = (ListView) findViewById(R.id.Seek_list);
        seek_istext = (TextView) findViewById(R.id.seek_istext);
        Seek_Loading = (ProgressBar) findViewById(R.id.Seek_Loading);
        seek_bigmain = (RelativeLayout) findViewById(R.id.seek_bigmain);

        final P_Seek_list_item_Impl p_seek_list_item_impl = new P_Seek_list_item_Impl(new V_Seek_list_item() {
            @Override
            public void getSeacher(String result) {
//                Toast.makeText(Seek_Activity.this, result.toString(), Toast.LENGTH_SHORT).show();
                Gson gson = new Gson();
                Seek_list_Bean seek_list_beanis = gson.fromJson(result, Seek_list_Bean.class);
//                Toast.makeText(Seek_Activity.this, seek_list_beanis.toString(), Toast.LENGTH_SHORT).show();
                seek_bigmain.setVisibility(View.GONE);
                Seek_Loading.setVisibility(View.VISIBLE);
                seek_istext.setVisibility(View.GONE);
                seek_gridview.setVisibility(View.GONE);
                Seek_list.setVisibility(View.VISIBLE);

                Seek_list.setAdapter(new Seek_list_item_Adapter(Seek_Activity.this,seek_list_beanis));


                Seek_Loading.setVisibility(View.GONE);
            }
        });
        load_txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                p_seek_list_item_impl.seek_list_item(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void onclick(View view){
        switch (view.getId()){
            case R.id.loseweight_webview_back:
                finish();
                break;
        }
    }


}
