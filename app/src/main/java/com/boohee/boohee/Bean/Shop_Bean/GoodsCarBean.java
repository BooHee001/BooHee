package com.boohee.boohee.Bean.shop_Bean;

/**
 * Created by as on 2016/11/25.
 */

public class GoodsCarBean {

    /**
     * goodsimg : http://up.boohee.cn/house/u/shop/p_mn_wholecereal/thumb.jpg?imageView/2/w/608/h/344
     * goodsname : éo|éo|éo|éo|？￥？？¤？éo|？？？？？？？¤§？？？？？？？？？？？¨éo|？？？ 375g
     * goodsnum : 4
     * goodspic : 29
     * userno : 3321
     */

    private String goodsimg;
    private String goodsname;
    private int goodsnum;
    private int goodspic;
    private int userno;

    public String getGoodsimg() {
        return goodsimg;
    }

    public void setGoodsimg(String goodsimg) {
        this.goodsimg = goodsimg;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public int getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(int goodsnum) {
        this.goodsnum = goodsnum;
    }

    public int getGoodspic() {
        return goodspic;
    }

    public void setGoodspic(int goodspic) {
        this.goodspic = goodspic;
    }

    public int getUserno() {
        return userno;
    }

    public void setUserno(int userno) {
        this.userno = userno;
    }

    public GoodsCarBean(String goodsimg, String goodsname, int goodsnum, int goodspic, int userno) {
        this.goodsimg = goodsimg;
        this.goodsname = goodsname;
        this.goodsnum = goodsnum;
        this.goodspic = goodspic;
        this.userno = userno;
    }

    public GoodsCarBean() {
    }
}
