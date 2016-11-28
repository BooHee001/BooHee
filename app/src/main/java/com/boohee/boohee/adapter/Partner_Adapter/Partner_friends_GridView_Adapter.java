package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_friends;
import com.boohee.boohee.R;
import com.boohee.boohee.adapter.Partner_Adapter.partner_listener.OnClickGoPhoto;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huochai on 2016/11/24.
 */

public class Partner_friends_GridView_Adapter extends BaseAdapter{

    private Context context;
    private List<Partner_friends.PostsBean.PhotosBean> partner_priends_photo_list;

    public Partner_friends_GridView_Adapter(Context context, List<Partner_friends.PostsBean.PhotosBean> partner_priends_photo_list) {
        this.context = context;
        this.partner_priends_photo_list = partner_priends_photo_list;
    }

    @Override
    public int getCount() {
        return partner_priends_photo_list.size();
    }

    @Override
    public Object getItem(int position) {
        return partner_priends_photo_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Partner_friends.PostsBean.PhotosBean photosBeanx = partner_priends_photo_list.get(position);
        List<String> beanuels = new ArrayList<>();
        for (int i = 0; i < partner_priends_photo_list.size(); i++) {
            beanuels.add(partner_priends_photo_list.get(i).getBig_url());
        }

        Partner_GridView_Holder partner_gridView_holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.partner_friends_gridview_item,parent,false);
            partner_gridView_holder = new Partner_GridView_Holder();
            partner_gridView_holder.partner_priends_GridviewPic = (ImageView) convertView.findViewById(R.id.partner_priends_GridviewPic);


            convertView.setTag(partner_gridView_holder);
        }else{
            partner_gridView_holder = (Partner_GridView_Holder) convertView.getTag();
        }
        Partner_friends.PostsBean.PhotosBean friendsphotosBean = partner_priends_photo_list.get(position);
        String small_url = friendsphotosBean.getSmall_url();
        String hahaurl = "http://imgsrc.baidu.com/forum/w%3D580/sign=fec60054e4dde711e7d243fe97eecef4/93566690f603738d82d3bc73b21bb051f919ec99.jpg";

        if (small_url!=null){
            Glide.with(context)
                    .load(small_url)
                    .error(R.drawable.a3d)
                    .into(partner_gridView_holder.partner_priends_GridviewPic);
//            x.image().bind(partner_gridView_holder.partner_priends_GridviewPic,small_url);
        }

        for (int j = 0; j < beanuels.size(); j++) {
            partner_gridView_holder.partner_priends_GridviewPic.setOnClickListener(new OnClickGoPhoto(context,(ArrayList<String>)beanuels,position ));
        }
        return convertView;
    }

    class Partner_GridView_Holder{
        ImageView partner_priends_GridviewPic;
    }
}
