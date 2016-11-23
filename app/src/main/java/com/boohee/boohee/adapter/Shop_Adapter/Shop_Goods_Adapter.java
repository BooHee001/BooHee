package com.boohee.boohee.adapter.Shop_Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Shop_Goods;
import com.boohee.boohee.R;
import com.boohee.boohee.View.Shop_View.Shop_Details_Activity;
import com.boohee.boohee.View.Shop_View.Shop_GridView_Activity;
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
    private Intent intent = new Intent();

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
    public View getView(final int position, View convertView, final ViewGroup parent) {

        final ImageView iv = (ImageView) LayoutInflater.from(context).inflate(R.layout.shop_listview_itemimageview, parent, false);
            if (position ==0) {
            if (shop_goods.getDatas().get(position).getList().size() > 0) {
                Shop_Goods.DatasBean.ListBean listBean = shop_goods.getDatas().get(position).getList().get(0);
                String default_photo_url = listBean.getDefault_photo_url();
                if (default_photo_url != null) {
                    Glide.with(context)
                            .load(default_photo_url)
                            .into(iv);

                    //条目点击事件
                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (position == 0) {
                                Shop_Goods.DatasBean.ListBean listBean = shop_goods.getDatas().get(position).getList().get(0);
                                intent.setClass(context, Shop_GridView_Activity.class);
                                intent.putExtra("exhibit", listBean.getExhibit());
                                intent.putExtra("exhibit_type", listBean.getExhibit_type());
                                context.startActivity(intent);
                            }
                            if (position == 2) {
                                Shop_Goods.DatasBean.ListBean listBean = shop_goods.getDatas().get(position).getList().get(0);
                                intent.setClass(context, Shop_GridView_Activity.class);
                                intent.putExtra("exhibit", listBean.getExhibit());
                                intent.putExtra("exhibit_type", listBean.getExhibit_type());
                                context.startActivity(intent);
                            }
                        }
                    });
                }
                }else {
                ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                layoutParams.height = 0;
                iv.setLayoutParams(layoutParams);

            }
            return iv;
        }else if (position < 11) {
            if (shop_goods.getDatas().get(position).getList().size() > 0) {
                if (getItemViewType(position) == 1) {
                    String default_photo_url = shop_goods.getDatas().get(position).getList().get(0).getDefault_photo_url();
                    if (default_photo_url != null) {
                        Glide.with(context)
                                .load(default_photo_url)
                                .into(iv);
                    }
                    //条目点击事件
                    iv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Shop_Goods.DatasBean.ListBean listBean = shop_goods.getDatas().get(position).getList().get(0);
                            intent.setClass(context, Shop_GridView_Activity.class);
                            intent.putExtra("exhibit", listBean.getExhibit());
                            intent.putExtra("exhibit_type", listBean.getExhibit_type());
                            context.startActivity(intent);
                        }
                    });
                    return iv;

                } else {
                    GridView inflate = (GridView) LayoutInflater.from(context).inflate(R.layout.shop_listview_gridviewitem, null);
                    final List<Shop_Goods.DatasBean.ListBean> list = shop_goods.getDatas().get(position).getList();
                    inflate.setAdapter(new Shop_Goods_GridView_Adapter(context, list));
                    //GridView条目点击事件
                    inflate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int positions, long id) {
                            intent.setClass(context, Shop_Details_Activity.class);
                            intent.putExtra("id",list.get(positions).getId());
                            intent.putExtra("title",list.get(positions).getTitle());
                            context.startActivity(intent);
                        }
                    });
                    return inflate;
                }
            } else {
                ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                layoutParams.height = 0;
                iv.setLayoutParams(layoutParams);
                return iv;
            }

        } else {
            if (shop_goods.getDatas().get(position).getList().size() > 0) {
                String default_photo_url = shop_goods.getDatas().get(position).getList().get(0).getDefault_photo_url();
                if (default_photo_url != null) {
                    Glide.with(context)
                            .load(default_photo_url)
                            .into(iv);
                    //条目点击事件
                    iv.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Shop_Goods.DatasBean.ListBean listBean = shop_goods.getDatas().get(position).getList().get(0);
                            if ((position == (shop_goods.getDatas().size() - 3)) || (position == shop_goods.getDatas().size() - 1)) {
                                intent.setClass(context, Shop_GridView_Activity.class);
                                intent.putExtra("exhibit", listBean.getExhibit());
                                intent.putExtra("exhibit_type", listBean.getExhibit_type());
                                context.startActivity(intent);
                            }
                        }
                    });
                }
            } else {
                ViewGroup.LayoutParams layoutParams = iv.getLayoutParams();
                layoutParams.height = 0;
                iv.setLayoutParams(layoutParams);
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
        return 3;
    }

}