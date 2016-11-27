package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import org.xutils.x;

import java.util.List;


/**
 * Created by Huochai on 2016/11/23.
 */

public class Partnrt_sift_GridView_Adapter extends BaseAdapter{

    private Context context;
    private List<Partner_sift.PostsBean.PhotosBean> partner_photo_list;

    public Partnrt_sift_GridView_Adapter(Context context, List<Partner_sift.PostsBean.PhotosBean> partner_photo_list) {
        this.context = context;
        this.partner_photo_list = partner_photo_list;
    }

    @Override
    public int getCount() {
        return partner_photo_list.size();
    }

    @Override
    public Object getItem(int position) {
        return partner_photo_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Partner_GridView_Holder partner_gridView_holder;
        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.partner_sift_gridview_item,parent,false);
            partner_gridView_holder = new Partner_GridView_Holder();
            partner_gridView_holder.partner_sift_GridviewPic = (ImageView) convertView.findViewById(R.id.partner_sift_GridviewPic);



            convertView.setTag(partner_gridView_holder);
        }else{
            partner_gridView_holder = (Partner_GridView_Holder) convertView.getTag();
        }

        Partner_sift.PostsBean.PhotosBean photosBean = partner_photo_list.get(position);
        String getSmallpic = photosBean.getSmall_url();

        if (getSmallpic!=null){
            Glide.with(context)
                    .load(getSmallpic)
                    .into(partner_gridView_holder.partner_sift_GridviewPic);



        }

        return convertView;
    }

    class Partner_GridView_Holder{

        ImageView partner_sift_GridviewPic;
    }
}
