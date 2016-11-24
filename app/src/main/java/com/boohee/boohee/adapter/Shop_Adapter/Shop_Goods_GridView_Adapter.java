package com.boohee.boohee.adapter.Shop_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by as on 2016/11/20.
 */

public class Shop_Goods_GridView_Adapter extends BaseAdapter {
    private Context context;
    private List<Shop_Goods.DatasBean.ListBean> list;

    public Shop_Goods_GridView_Adapter(Context context, List<Shop_Goods.DatasBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyHolder holder;
        if(convertView ==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_gridview_item, parent, false);
            holder = new MyHolder();
            holder.shop_Grid_Img = (ImageView) convertView.findViewById(R.id.shop_Grid_Img);
            holder.shop_Grid_Title = (TextView) convertView.findViewById(R.id.shop_Grid_Title);
            holder.Base_Price = (TextView) convertView.findViewById(R.id.Base_Price);
            convertView.setTag(holder);
        }else {
            holder = (MyHolder) convertView.getTag();
        }
        Shop_Goods.DatasBean.ListBean listBean = list.get(position);
        String big_photo_url = listBean.getBig_photo_url();
        String Base_Price =listBean.getMarket_price();
        String title = listBean.getTitle();

        if(big_photo_url !=null){
            Glide.with(context)
                    .load(big_photo_url)
                    .into(holder.shop_Grid_Img);
        }
        if(title !=null){
            holder.shop_Grid_Title.setText(title);
        }
        if(Base_Price !=null){
            holder.Base_Price.setText(Base_Price);
        }
        return convertView;
    }
    class MyHolder{
        ImageView shop_Grid_Img;
        TextView shop_Grid_Title;
        TextView Base_Price;
    }
}
