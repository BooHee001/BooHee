package com.boohee.boohee.adapter.Shop_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by as on 2016/11/20.
 */

public class Shop_Goods_Adapter extends BaseAdapter {
    private Shop_Goods shop_goods;
    private Context context;

    public Shop_Goods_Adapter(Shop_Goods shop_goods, Context context) {
        this.shop_goods = shop_goods;
        this.context = context;
    }

    @Override
    public int getCount() {
       return shop_goods.getDatas().size();
//        return 6;
    }

    @Override
    public Object getItem(int position) {
        return shop_goods.getDatas().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView iv = (ImageView) LayoutInflater.from(context).inflate(R.layout.shop_listview_itemimageview, parent, false);
        if (position < 2) {
            if(shop_goods.getDatas().get(position).getList().size() >0) {
                String default_photo_url = shop_goods.getDatas().get(position).getList().get(0).getDefault_photo_url();
                if (default_photo_url != null) {
                    Glide.with(context)
                            .load(default_photo_url)
                            .into(iv);
                }else{
                    iv.setVisibility(View.INVISIBLE);
                }
            }
            return iv;
        }else if (position < 10) {
            if (getItemViewType(position) == 0) {
                String default_photo_url = shop_goods.getDatas().get(position).getList().get(0).getDefault_photo_url();
                if (default_photo_url != null) {
                    Glide.with(context)
                            .load(default_photo_url)
                            .into(iv);
                }
                return iv;

            } else {
                GridView inflate = (GridView) LayoutInflater.from(context).inflate(R.layout.shop_listview_gridviewitem, null);
                List<Shop_Goods.DatasBean.ListBean> list = shop_goods.getDatas().get(position).getList();
                inflate.setAdapter(new Shop_Goods_GridView_Adapter(context, list));
                return inflate;
            }

        } else {
            if(shop_goods.getDatas().get(position).getList().size() >0) {
                String default_photo_url = shop_goods.getDatas().get(position).getList().get(0).getDefault_photo_url();
                if (default_photo_url != null) {
                    Glide.with(context)
                            .load(default_photo_url)
                            .into(iv);
                }
            }else{
                iv.setVisibility(View.INVISIBLE);
            }
            return iv;

        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getViewTypeCount() {
        return shop_goods.getDatas().size();
    }

}