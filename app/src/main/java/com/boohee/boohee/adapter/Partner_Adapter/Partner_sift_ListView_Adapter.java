package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Huochai on 2016/11/22.
 */

public class Partner_sift_ListView_Adapter extends BaseAdapter{


    private Partner_sift partner_sift;
    private Context context;

    public Partner_sift_ListView_Adapter(Partner_sift partner_sift, Context context) {
        this.partner_sift = partner_sift;
        this.context = context;
    }

    @Override
    public int getCount() {
        return partner_sift.getPosts().size();
    }

    @Override
    public Object getItem(int position) {
        return partner_sift.getPosts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PartnerHolder partnerHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.partner_sift_item,parent,false);
            partnerHolder = new PartnerHolder();
            partnerHolder.partner_sift_userphoto = (ImageView) convertView.findViewById(R.id.partner_sift_userphoto);
            partnerHolder.partner_sift_username = (TextView) convertView.findViewById(R.id.partner_sift_username);
            partnerHolder.partner_sift_time = (TextView) convertView.findViewById(R.id.partner_sift_time);
            partnerHolder.partner_sift_maintext = (TextView) convertView.findViewById(R.id.partner_sift_maintext);
            partnerHolder.partner_sift_support_size = (TextView) convertView.findViewById(R.id.partner_sift_support_size);
            partnerHolder.partner_sift_comment_size = (TextView) convertView.findViewById(R.id.partner_sift_comment_size);
            partnerHolder.partner_sift_photo = (GridView) convertView.findViewById(R.id.partner_sift_photo);
            convertView.setTag(partnerHolder);
        }else {
            partnerHolder = (PartnerHolder) convertView.getTag();
        }


        List<Partner_sift.PostsBean.PhotosBean> partner_photo_list = partner_sift.getPosts().get(position).getPhotos();

        String avatar_url = partner_sift.getPosts().get(position).getUser().getAvatar_url();
        String nickname = partner_sift.getPosts().get(position).getUser().getNickname();
        String created_at = partner_sift.getPosts().get(position).getCreated_at();
        String body = partner_sift.getPosts().get(position).getBody();
        int envious_count = partner_sift.getPosts().get(position).getEnvious_count();
        int comment_count = partner_sift.getPosts().get(position).getComment_count();
        partnerHolder.partner_sift_photo.setAdapter(new Partnrt_sift_GridView_Adapter(context,partner_photo_list));
        if (avatar_url!=null){
            Glide.with(context)
                    .load(avatar_url)
                    .into(partnerHolder.partner_sift_userphoto);
        }
        if (nickname!=null){
            partnerHolder.partner_sift_username.setText(nickname);
        }
        if (created_at!=null){
            String sbyy = created_at;
            String sbdd = created_at;
            String thistime = sbyy.substring(5, 10) + "  " +sbdd.substring(11, 16);
            partnerHolder.partner_sift_time.setText(thistime);
        }
        if (body!=null){
            partnerHolder.partner_sift_maintext.setText(body);
        }
        if (envious_count!=0){
            String envious_counts = envious_count + "";
            partnerHolder.partner_sift_support_size.setText(envious_counts);
        }
        if (comment_count!=0){
            String comment_counts = comment_count + "";
            partnerHolder.partner_sift_comment_size.setText(comment_counts);
        }


        return convertView;
    }

    class PartnerHolder{
        ImageView partner_sift_userphoto;
        TextView partner_sift_username,
                partner_sift_time,
                partner_sift_maintext,
                partner_sift_support_size,
                partner_sift_comment_size;
        GridView partner_sift_photo;

    }

}
