package com.boohee.boohee.View.Shop_View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.R;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_Goods_Adapter;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_GridView_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Item_Impl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shop_GridView_Activity extends AppCompatActivity {

    @BindView(R.id.GridView_Back)
    View gridView_Back;
    @BindView(R.id.GridView_Title)
    TextView gridView_Title;
    @BindView(R.id.G_GridView)
    GridView g_GridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__grid_view_);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String exhibit = intent.getStringExtra("exhibit");
        String exhibit_type = intent.getStringExtra("exhibit_type");
        try {
            P_Shop_Item_Impl p_shop_item_Impl = new P_Shop_Item_Impl(new V_Shop_Item() {
                @Override
                public void setData(Shop_Goods_Item shop_goods_item) {
                    gridView_Title.setText(shop_goods_item.getName());
                    g_GridView.setAdapter(new Shop_GridView_Adapter(Shop_GridView_Activity.this,shop_goods_item));
                    g_GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent();
                            intent.setClass(Shop_GridView_Activity.this, Shop_Details_Activity.class);
                            startActivity(intent);
                        }
                    });
                }
            });
            p_shop_item_Impl.getData(exhibit, exhibit_type);
        }catch (Exception e){
        }
    }
    @OnClick(R.id.GridView_Back)
    public void back(View v){
        finish();
    }
}
