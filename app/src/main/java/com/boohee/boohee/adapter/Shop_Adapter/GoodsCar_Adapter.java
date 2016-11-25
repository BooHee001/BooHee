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
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.R;
import com.boohee.boohee.Utils.Shop_Utils.SideslipListView;

import java.util.List;

import static com.alipay.sdk.app.statistic.c.v;

/**
 * Created by as on 2016/11/24.
 */

public class GoodsCar_Adapter extends BaseAdapter {
    private List<Integer> numList;
    private Context context;
    private SideslipListView mListView;

    public GoodsCar_Adapter(List<Integer> numList, Context context,SideslipListView mListView) {
        this.numList = numList;
        this.context = context;
        this.mListView= mListView;
    }

    @Override
    public int getCount() {
        return numList.size();
    }

    @Override
    public Object getItem(int position) {
        return numList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        GoodsCarHolder holer =null;
        if(numList !=null) {
            if(convertView ==null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.goodscar_item, parent, false);
                holer = new GoodsCarHolder();
                holer.GoodCar_Img = (ImageView) convertView.findViewById(R.id.GoodCar_Img);
                holer.GoodCar_Num = (EditText) convertView.findViewById(R.id.GoodCar_Num);
                holer.GoodsCar_Add = (ImageView) convertView.findViewById(R.id.GoodsCar_Add);
                holer.GoodsCar_jian = (ImageView) convertView.findViewById(R.id.GoodsCar_jian);
                holer.GoodsCar_Pic = (TextView) convertView.findViewById(R.id.GoodsCar_Pic);
                holer.GoodsCar_Title = (TextView) convertView.findViewById(R.id.GoodsCar_Title);

                convertView.setTag(holer);

            }else {
                holer = (GoodsCarHolder) convertView.getTag();
            }
            final View delete = convertView.findViewById(R.id.delete);

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("确定要删除吗？");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            numList.remove(position);
                            notifyDataSetChanged();
                            mListView.turnToNormal();
                            Toast.makeText(context, "删除成功", Toast.LENGTH_SHORT).show();
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
    class GoodsCarHolder{
        ImageView GoodCar_Img;
        TextView GoodsCar_Title;
        TextView GoodsCar_Pic;
        ImageView GoodsCar_Add;
        ImageView GoodsCar_jian;
        EditText GoodCar_Num;


    }
}
