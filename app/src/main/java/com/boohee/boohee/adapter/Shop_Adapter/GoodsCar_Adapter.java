package com.boohee.boohee.adapter.Shop_Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.boohee.boohee.Bean.Shop_Bean.GoodsCarBean;
import com.boohee.boohee.Bean.shop_Bean.GoodsCarBean;
import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.SideslipListView;
import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.View.Shop_View.GoodsCar_Activity;
import com.boohee.boohee.View.Shop_View.V_RemoveGoodsCar;
import com.boohee.boohee.View.Shop_View.V_ShowGoodsCar;
import com.boohee.boohee.presenter.Shop_Presenter.P_RemoveGoodsCar_Impl;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCar;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCar_Impl;
import com.bumptech.glide.Glide;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

import static com.alipay.sdk.app.statistic.c.v;
import static com.boohee.boohee.R.id.GoodCar_ListView;

/**
 * Created by as on 2016/11/24.
 */

public class GoodsCar_Adapter extends BaseAdapter {
    private List<GoodsCarBean> goodsCarBeanList;
    private Context context;
    private ListView GoodCar_ListView;
    private TextView GoodsAll_Pic;
    // private SideslipListView mListView;

    public GoodsCar_Adapter(List<GoodsCarBean> goodsCarBeanList, Context context, ListView GoodCar_ListView, TextView GoodsAll_Pic) {
        this.goodsCarBeanList = goodsCarBeanList;
        this.context = context;
        this.GoodCar_ListView = GoodCar_ListView;
        this.GoodsAll_Pic = GoodsAll_Pic;
    }

    @Override
    public int getCount() {
        return goodsCarBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return goodsCarBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GoodsCarHolder holer = null;
        if (goodsCarBeanList != null) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.goodscar_item, parent, false);
                holer = new GoodsCarHolder();
                holer.GoodCar_Img = (ImageView) convertView.findViewById(R.id.GoodCar_Img);
                holer.GoodCar_Num = (EditText) convertView.findViewById(R.id.GoodCar_Num);
                holer.GoodsCar_Add = (ImageView) convertView.findViewById(R.id.GoodsCar_Add);
                holer.GoodsCar_jian = (ImageView) convertView.findViewById(R.id.GoodsCar_jian);
                holer.GoodsCar_Pic = (TextView) convertView.findViewById(R.id.GoodsCar_Pic);
                holer.GoodsCar_Title = (TextView) convertView.findViewById(R.id.GoodsCar_Title);
                holer.swipeLayout = (SwipeLayout) convertView.findViewById(R.id.swipe_refresh_layout);
                holer.tv_delete = (TextView) convertView.findViewById(R.id.tv_delete);

                convertView.setTag(holer);

            } else {
                holer = (GoodsCarHolder) convertView.getTag();
            }
            GoodsCarBean goodsCarBean = goodsCarBeanList.get(position);
            if (goodsCarBean.getGoodsimg() != null)
                Glide.with(context).load(goodsCarBean.getGoodsimg()).into(holer.GoodCar_Img);
            if ((goodsCarBean.getGoodsnum() + "") != null)
                holer.GoodCar_Num.setText(goodsCarBean.getGoodsnum() + "");
            if ((goodsCarBean.getGoodspic() + "") != null)
                holer.GoodsCar_Pic.setText(goodsCarBean.getGoodspic() + "");
            if (goodsCarBean.getGoodsname() != null)
                holer.GoodsCar_Title.setText(goodsCarBean.getGoodsname());
//            if(holer.swipeLayout !=null) {
////
//            }
            final GoodsCarHolder finalHoler = holer;
            holer.tv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            P_RemoveGoodsCar_Impl p_removeGoodsCar_ = new P_RemoveGoodsCar_Impl(new V_RemoveGoodsCar() {
                                @Override
                                public void getResult(String result) {
                                    goodsCarBeanList.remove(position);
                                    P_ShowGoodsCar_Impl p_showGoodsCar_ = new P_ShowGoodsCar_Impl(new V_ShowGoodsCar() {
                                        @Override
                                        public void getData(List<GoodsCarBean> goodsCarBeanLists) {
//                                        关闭已经打开的侧滑区域
                                            GoodCar_ListView.setAdapter(new GoodsCar_Adapter(goodsCarBeanLists, context, GoodCar_ListView, GoodsAll_Pic));
                                            int all_pic = 0;
                                            for (int i = 0; i < goodsCarBeanList.size(); i++) {
                                                all_pic += (goodsCarBeanList.get(i).getGoodsnum()) * (goodsCarBeanList.get(i).getGoodspic());
                                            }
                                            GoodsAll_Pic.setText(all_pic + "");

                                        }
                                    });
                                    p_showGoodsCar_.getData(goodsCarBeanList);
                                    Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
                                }
                            });
                            p_removeGoodsCar_.removeData(MyApplication.userno, goodsCarBeanList.get(position).getGoodsimg());

                        }
                    });

                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            });
        }
        return convertView;
    }

    class GoodsCarHolder {
        ImageView GoodCar_Img;
        TextView GoodsCar_Title;
        TextView GoodsCar_Pic;
        ImageView GoodsCar_Add;
        ImageView GoodsCar_jian;
        EditText GoodCar_Num;
        TextView tv_delete;
        SwipeLayout swipeLayout;


    }
}
