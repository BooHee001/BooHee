package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.Partner_sift;
import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Huochai on 2016/11/22.
 */

public class Partner_sift_ListView_Adapter extends BaseAdapter{

    int whatif = 1;

    private Partner_sift partner_sift;
    private Context context;

    public Partner_sift_ListView_Adapter(Partner_sift partner_sift, Context context) {
        this.partner_sift = partner_sift;
        this.context = context;
    }
    PartnerHolder partnerHolder;
    int envious_count;
    int comment_count;
    int support_size_no;
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

            partnerHolder.item_goto_personal = (LinearLayout) convertView.findViewById(R.id.item_goto_personal);
            partnerHolder.item_jewel = (RelativeLayout) convertView.findViewById(R.id.item_jewel);
            partnerHolder.partner_sift_support_no = (ImageView) convertView.findViewById(R.id.partner_sift_support_no);
            partnerHolder.partner_sift_support_yes = (ImageView) convertView.findViewById(R.id.partner_sift_support_yes);
            convertView.setTag(partnerHolder);
        }else {
            partnerHolder = (PartnerHolder) convertView.getTag();
        }


        List<Partner_sift.PostsBean.PhotosBean> partner_photo_list = partner_sift.getPosts().get(position).getPhotos();

        String avatar_url = partner_sift.getPosts().get(position).getUser().getAvatar_url();
        String nickname = partner_sift.getPosts().get(position).getUser().getNickname();
        String created_at = partner_sift.getPosts().get(position).getCreated_at();
        String body = partner_sift.getPosts().get(position).getBody();
        envious_count = partner_sift.getPosts().get(position).getEnvious_count();
        comment_count = partner_sift.getPosts().get(position).getComment_count();
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
        partnerHolder.partner_sift_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //position是当前点击条目位置
            }
        });



        partnerHolder.item_goto_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //填写跳转个人中心
            }
        });

        partnerHolder.item_jewel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (whatif == 1){
                    partnerHolder.partner_sift_support_no.setVisibility(View.GONE);
                    partnerHolder.partner_sift_support_yes.setVisibility(View.VISIBLE);
                    support_size_no = envious_count+1;
                    String support_size_txt_no = support_size_no + "";
                    partnerHolder.partner_sift_support_size.setText(support_size_txt_no);
                    whatif = 0;
                }else {
                    partnerHolder.partner_sift_support_no.setVisibility(View.VISIBLE);
                    partnerHolder.partner_sift_support_yes.setVisibility(View.GONE);
                    String support_size_txt_yes = envious_count + "";
                    partnerHolder.partner_sift_support_size.setText(support_size_txt_yes);
                    whatif = 1;
                }
            }
        });



        return convertView;
    }

    class PartnerHolder{
        ImageView partner_sift_userphoto,
                partner_sift_support_no,
                partner_sift_support_yes;
        TextView partner_sift_username,
                partner_sift_time,
                partner_sift_maintext,
                partner_sift_support_size,
                partner_sift_comment_size;
        GridView partner_sift_photo;

        LinearLayout item_goto_personal;

        RelativeLayout item_jewel;
    }

}
