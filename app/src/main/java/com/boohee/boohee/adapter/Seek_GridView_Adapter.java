package com.boohee.boohee.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.PhotoBean.Seek_Bean;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Seek_Activity;


/**
 * Created by Huochai on 2016/11/28.
 */

public class Seek_GridView_Adapter extends BaseAdapter{

    private Context context;
    private Seek_Bean seek_item_list;

    public Seek_GridView_Adapter(Context context, Seek_Bean seek_item_list) {
        this.context = context;
        this.seek_item_list = seek_item_list;
    }

    @Override
    public int getCount() {
        return seek_item_list.getKeywords().size();
    }

    @Override
    public Object getItem(int position) {
        return seek_item_list.getKeywords().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Seek_GridView_Holder seek_gridView_holder;

        if (convertView==null){

            convertView = LayoutInflater.from(context).inflate(R.layout.seek_item,parent,false);
            seek_gridView_holder = new Seek_GridView_Holder();
            seek_gridView_holder.seek_item_txt = (TextView) convertView.findViewById(R.id.seek_item_txt);

            convertView.setTag(seek_gridView_holder);
        }else {
            seek_gridView_holder = (Seek_GridView_Holder) convertView.getTag();

        }


            String getSeekText = seek_item_list.getKeywords().get(position);



            if (getSeekText!=null){
                seek_gridView_holder.seek_item_txt.setText(getSeekText);
            }




        return convertView;
    }

    class Seek_GridView_Holder{
        TextView seek_item_txt;
    }
}
