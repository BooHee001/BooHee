package com.boohee.boohee.View.Shop_View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.R;
import com.boohee.boohee.adapter.Shop_Adapter.Shop_GridView_Adapter;
import com.boohee.boohee.presenter.Shop_Presenter.P_Shop_Item_Impl;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Shop_GridView_Activity extends AppCompatActivity {

    @BindView(R.id.Shop_GridView_Loading)
    ProgressBar Shop_GridView_Loading;
    @BindView(R.id.GridView_Back)
    View gridView_Back;
    @BindView(R.id.GridView_Title)
    TextView gridView_Title;
    @BindView(R.id.G_GridView)
    PullToRefreshGridView g_GridView;
    private int page = 1;
    private List<Shop_Goods_Item.GoodsBean> goodsBean = new ArrayList<>();
    private Shop_GridView_Adapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop__grid_view_);
        ButterKnife.bind(this);
        Shop_GridView_Loading.setVisibility(View.VISIBLE);
        setData();
        adapter = new Shop_GridView_Adapter(Shop_GridView_Activity.this, goodsBean);
        g_GridView.setAdapter(adapter);
        g_GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("id", goodsBean.get(1).getId());
                intent.putExtra("title", goodsBean.get(position).getTitle());
                intent.setClass(Shop_GridView_Activity.this, Shop_Details_Activity.class);
                startActivity(intent);


            }
        });
        g_GridView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<GridView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<GridView> refreshView) {
                goodsBean = new ArrayList<>();
                setData();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<GridView> refreshView) {
                Intent intent = getIntent();
                String exhibit = intent.getStringExtra("exhibit");
                String exhibit_type = intent.getStringExtra("exhibit_type");
                P_Shop_Item_Impl p_shop_item_Impl = new P_Shop_Item_Impl(new V_Shop_Item() {
                    @Override
                    public void setData(final Shop_Goods_Item shop_goods_item) {
                        if (shop_goods_item != null) {
                            gridView_Title.setText(shop_goods_item.getName());
                            goodsBean.addAll(shop_goods_item.getGoods());
                            adapter.notifyDataSetChanged();
                        }
                        g_GridView.onRefreshComplete();
                        Shop_GridView_Loading.setVisibility(View.GONE);
                    }
                });
                p_shop_item_Impl.getData(exhibit, exhibit_type, ++page);
            }
        });

    }

    private void setData() {
        Intent intent = getIntent();
        String exhibit = intent.getStringExtra("exhibit");
        String exhibit_type = intent.getStringExtra("exhibit_type");
        P_Shop_Item_Impl p_shop_item_Impl = new P_Shop_Item_Impl(new V_Shop_Item() {
            @Override
            public void setData(final Shop_Goods_Item shop_goods_item) {
                gridView_Title.setText(shop_goods_item.getName());
                goodsBean.addAll(shop_goods_item.getGoods());
                adapter.notifyDataSetChanged();
                g_GridView.onRefreshComplete();
                Shop_GridView_Loading.setVisibility(View.GONE);
            }
        });
        p_shop_item_Impl.getData(exhibit, exhibit_type, 1);
    }

    @OnClick(R.id.GridView_Back)
    public void back(View v) {
        finish();
    }
}
