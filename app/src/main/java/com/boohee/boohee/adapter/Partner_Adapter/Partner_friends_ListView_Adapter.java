package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.boohee.boohee.Bean.shop_Bean.partner_Bean.Partner_friends;

import com.boohee.boohee.R;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Huochai on 2016/11/24.
 */

public class Partner_friends_ListView_Adapter extends BaseAdapter{

    private Context context;
    private Partner_friends partner_friends;

    public Partner_friends_ListView_Adapter(Partner_friends partner_friends ,Context context) {
        this.context = context;
        this.partner_friends = partner_friends;
    }

    @Override
    public int getCount() {
        return partner_friends.getPosts().size();
    }

    @Override
    public Object getItem(int position) {
        return partner_friends.getPosts().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FriendsPartnerHolder friendsPartnerHolder;

        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.partner_friends_item,parent,false);
            friendsPartnerHolder = new FriendsPartnerHolder();
            friendsPartnerHolder.partner_friends_userphoto = (ImageView) convertView.findViewById(R.id.partner_friends_userphoto);
            friendsPartnerHolder.partner_friends_username = (TextView) convertView.findViewById(R.id.partner_friends_username);
            friendsPartnerHolder.partner_friends_time = (TextView) convertView.findViewById(R.id.partner_friends_time);
            friendsPartnerHolder.partner_friends_maintext = (TextView) convertView.findViewById(R.id.partner_friends_maintext);
            friendsPartnerHolder.partner_friends_support_size = (TextView) convertView.findViewById(R.id.partner_friends_support_size);
            friendsPartnerHolder.partner_friends_comment_size = (TextView) convertView.findViewById(R.id.partner_friends_comment_size);
            friendsPartnerHolder.partner_friends_photo = (GridView) convertView.findViewById(R.id.partner_friends_photo);
//            friendsPartnerHolder.partner_friends_photo = (GridLayout) convertView.findViewById(R.id.partner_friends_photo);

            convertView.setTag(friendsPartnerHolder);
        }else {
            friendsPartnerHolder = (FriendsPartnerHolder) convertView.getTag();
        }

        List<Partner_friends.PostsBean.PhotosBean> partner_priends_photo_list = partner_friends.getPosts().get(position).getPhotos();

        String avatar_url = partner_friends.getPosts().get(position).getUser().getAvatar_url();
        String nickname = partner_friends.getPosts().get(position).getUser().getNickname();
        String created_at = partner_friends.getPosts().get(position).getCreated_at();
        String body = partner_friends.getPosts().get(position).getBody();
        int envious_count = partner_friends.getPosts().get(position).getEnvious_count();
        int comment_count = partner_friends.getPosts().get(position).getComment_count();

        if (partner_priends_photo_list !=null)
        friendsPartnerHolder.partner_friends_photo.setAdapter(new Partner_friends_GridView_Adapter(context,partner_priends_photo_list));



        if (avatar_url!=null){
            Glide.with(context)
                    .load(avatar_url)
                    .into(friendsPartnerHolder.partner_friends_userphoto);
        }
        if (nickname!=null){
            friendsPartnerHolder.partner_friends_username.setText(nickname);
        }
        if (created_at!=null){
            String sbyy = created_at;
            String sbdd = created_at;
            String thistime = sbyy.substring(5, 10) + "  " +sbdd.substring(11, 16);
            friendsPartnerHolder.partner_friends_time.setText(thistime);
        }
        if (body!=null){
            friendsPartnerHolder.partner_friends_maintext.setText(body);
        }
        if (envious_count!=0){
            String envious_counts = envious_count + "";
            friendsPartnerHolder.partner_friends_support_size.setText(envious_counts);
        }
        if (comment_count!=0){
            String comment_counts = comment_count + "";
            friendsPartnerHolder.partner_friends_comment_size.setText(comment_counts);
        }




        return convertView;
    }

    class FriendsPartnerHolder{
        ImageView partner_friends_userphoto;
        TextView partner_friends_username,
                partner_friends_time,
                partner_friends_maintext,
                partner_friends_support_size,
                partner_friends_comment_size;
        GridView partner_friends_photo;

//        GridLayout partner_friends_photo;


    }
}
