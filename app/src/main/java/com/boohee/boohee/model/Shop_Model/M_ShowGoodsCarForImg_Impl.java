package com.boohee.boohee.model.Shop_Model;

import android.content.Context;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.GoodsCarBean;
import com.boohee.boohee.View.MyApplication;
import com.boohee.boohee.presenter.Shop_Presenter.P_ShowGoodsCarForImg;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by as on 2016/11/26.
 */

public class M_ShowGoodsCarForImg_Impl implements M_ShowGoodsCarForImg {
    private P_ShowGoodsCarForImg p_showGoodsCarForImg;

    public M_ShowGoodsCarForImg_Impl(P_ShowGoodsCarForImg p_showGoodsCarForImg) {
        this.p_showGoodsCarForImg = p_showGoodsCarForImg;
    }

    @Override
    public void getData(int userno, String goodsimg, final Context context) {
        RequestParams entiey = new RequestParams("http://"+ MyApplication.MyIp+":8080/MyAndroidDemo/MySerVlet?type=5&userno=" + userno + "&goodsimg=" + goodsimg);
        entiey.setConnectTimeout(60000);
        x.http().get(entiey, new Callback.CacheCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    String goodsimg = jsonObject.optString("goodsimg");
                    String goodsname = jsonObject.optString("goodsname");
                    int goodsnum = jsonObject.optInt("goodsnum");
                    int goodspic = jsonObject.optInt("goodspic");
                    int userno = jsonObject.optInt("userno");
                    GoodsCarBean goodsCarBean = new GoodsCarBean(goodsimg, goodsname, goodsnum, goodspic, userno);
                    p_showGoodsCarForImg.setData(goodsCarBean);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(context, "连接超时", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {
                Toast.makeText(context, "连接超时", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinished() {

            }

            @Override
            public boolean onCache(String result) {
                return false;
            }
        });
    }
}
