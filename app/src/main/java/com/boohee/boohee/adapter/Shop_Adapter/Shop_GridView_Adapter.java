package com.boohee.boohee.adapter.Shop_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods_Item;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by as on 2016/11/22.
 */

public class Shop_GridView_Adapter extends BaseAdapter{
    private Context context;
    private Shop_Goods_Item shop_goods_item;

    public Shop_GridView_Adapter(Context context, Shop_Goods_Item shop_goods_item) {
        this.context = context;
        this.shop_goods_item = shop_goods_item;
    }

    @Override
    public int getCount() {
        return shop_goods_item.getGoods().size();
    }

    @Override
    public Object getItem(int position) {
        return shop_goods_item.getGoods().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyGridViewHolder holder;
        if(convertView ==null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.shop_gridview_item, parent, false);
            holder = new MyGridViewHolder();
            holder.shop_Grid_Img = (ImageView) convertView.findViewById(R.id.shop_Grid_Img);
            holder.shop_Grid_Title = (TextView) convertView.findViewById(R.id.shop_Grid_Title);
            holder.Base_Price = (TextView) convertView.findViewById(R.id.Base_Price);
            convertView.setTag(holder);
        }else {
            holder = (MyGridViewHolder) convertView.getTag();
        }
        Shop_Goods_Item.GoodsBean goodsBean = shop_goods_item.getGoods().get(position);
        String big_photo_url = goodsBean.getBig_photo_url();
        String Base_Price =goodsBean.getBase_price();
        String title = goodsBean.getTitle();

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
    class MyGridViewHolder{
        ImageView shop_Grid_Img;
        TextView shop_Grid_Title;
        TextView Base_Price;
    }
}
