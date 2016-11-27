package com.boohee.boohee.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.boohee.boohee.PhotoBean.Seek_list_Bean;
import com.boohee.boohee.R;

import java.util.List;

/**
 * Created by Huochai on 2016/11/28.
 */

public class Seek_list_item_Adapter extends BaseAdapter{
    private Context context;
    private Seek_list_Bean seek_list_Bean;

    Seek_list_itemHolder seek_list_itemHolder;

    public Seek_list_item_Adapter(Context context, Seek_list_Bean seek_list_Bean) {
        this.context = context;
        this.seek_list_Bean = seek_list_Bean;
    }

    @Override
    public int getCount() {
        return seek_list_Bean==null?0:seek_list_Bean.getFoods().size();
    }

    @Override
    public Object getItem(int position) {
        return seek_list_Bean.getFoods().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.seek_list_item,parent,false);
            seek_list_itemHolder = new Seek_list_itemHolder();
            seek_list_itemHolder.seekitem_txt = (TextView) convertView.findViewById(R.id.seekitem_txt);
            seek_list_itemHolder.seekitem_kg = (TextView) convertView.findViewById(R.id.seekitem_kg);
            convertView.setTag(seek_list_itemHolder);
        }else {
            seek_list_itemHolder = (Seek_list_itemHolder) convertView.getTag();
        }

        String seekitem_txt = seek_list_Bean.getFoods().get(position).getName();
        String seekitem_k = seek_list_Bean.getFoods().get(position).getCalory();
        String seekitem_g = seek_list_Bean.getFoods().get(position).getWeight();

        if (seekitem_txt!=null){
            seek_list_itemHolder.seekitem_txt.setText(seekitem_txt);
        }
        if (seekitem_k!=null&seekitem_g!=null){
            seek_list_itemHolder.seekitem_kg.setText(seekitem_k+"千卡/"+seekitem_g+"克");
        }


        return convertView;
    }

    class Seek_list_itemHolder{
        TextView seekitem_txt,seekitem_kg;
    }
}
