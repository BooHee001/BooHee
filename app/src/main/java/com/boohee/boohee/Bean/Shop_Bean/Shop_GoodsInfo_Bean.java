package com.boohee.boohee.Bean.shop_Bean;

import java.util.List;

/**
 * Created by as on 2016/11/23.
 */

public class Shop_GoodsInfo_Bean {

    /**
     * goods : {"id":1128,"type":"PackageGoods","slug":"p_tm25_cdysj_qm_180_161111","title":"唤醒肠道活力｜超模25 肠道益生菌 6g×30","base_price":99,"market_price":99,"big_photo_url":"http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg","thumb_photo_url":"http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg","a_photo_url":null,"b_photo_url":null,"c_photo_url":null,"all_thumb_photo_urls":[],"all_big_photo_urls":[],"square_photo_urls":["http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s1.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s2.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s3.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s4.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s5.jpg?imageView/2/w/640/h/640"],"weight":"0.3","need_carriage":true,"category_id":1,"category_name":"食品","state":"on_sale","state_text":"已上架","description":"便便不定时还费力，脸色不好还长痘，这些可能都是肠道菌群失衡的表现，每天喝1袋超模25肠道益生菌，益生菌与益生元黄金搭配，唤醒肠道活力，肠健康畅通畅。","detail_url":"","month_quantity":0,"unit_name":"盒","carriage_desc":"满99包邮","share":{"share_title":"唤醒肠道活力｜超模25 肠道益生菌 6g×30","share_link":"http://wap.koudaitong.com/v2/home/rky71018","share_image":"http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg","share_description":"我在薄荷商店发现了这货：唤醒肠道活力｜超模25 肠道益生菌 6g×30 推荐你也来看看哦~"}}
     */

    private GoodsBean goods;

    public GoodsBean getGoods() {
        return goods;
    }

    public void setGoods(GoodsBean goods) {
        this.goods = goods;
    }

    public static class GoodsBean {
        /**
         * id : 1128
         * type : PackageGoods
         * slug : p_tm25_cdysj_qm_180_161111
         * title : 唤醒肠道活力｜超模25 肠道益生菌 6g×30
         * base_price : 99
         * market_price : 99
         * big_photo_url : http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg
         * thumb_photo_url : http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg
         * a_photo_url : null
         * b_photo_url : null
         * c_photo_url : null
         * all_thumb_photo_urls : []
         * all_big_photo_urls : []
         * square_photo_urls : ["http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s1.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s2.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s3.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s4.jpg?imageView/2/w/640/h/640","http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/slider/s5.jpg?imageView/2/w/640/h/640"]
         * weight : 0.3
         * need_carriage : true
         * category_id : 1
         * category_name : 食品
         * state : on_sale
         * state_text : 已上架
         * description : 便便不定时还费力，脸色不好还长痘，这些可能都是肠道菌群失衡的表现，每天喝1袋超模25肠道益生菌，益生菌与益生元黄金搭配，唤醒肠道活力，肠健康畅通畅。
         * detail_url :
         * month_quantity : 0
         * unit_name : 盒
         * carriage_desc : 满99包邮
         * share : {"share_title":"唤醒肠道活力｜超模25 肠道益生菌 6g×30","share_link":"http://wap.koudaitong.com/v2/home/rky71018","share_image":"http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg","share_description":"我在薄荷商店发现了这货：唤醒肠道活力｜超模25 肠道益生菌 6g×30 推荐你也来看看哦~"}
         */

        private int id;
        private String type;
        private String slug;
        private String title;
        private int base_price;
        private int market_price;
        private String big_photo_url;
        private String thumb_photo_url;
        private Object a_photo_url;
        private Object b_photo_url;
        private Object c_photo_url;
        private String weight;
        private boolean need_carriage;
        private int category_id;
        private String category_name;
        private String state;
        private String state_text;
        private String description;
        private String detail_url;
        private int month_quantity;
        private String unit_name;
        private String carriage_desc;
        private ShareBean share;
        private List<?> all_thumb_photo_urls;
        private List<?> all_big_photo_urls;
        private List<String> square_photo_urls;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getBase_price() {
            return base_price;
        }

        public void setBase_price(int base_price) {
            this.base_price = base_price;
        }

        public int getMarket_price() {
            return market_price;
        }

        public void setMarket_price(int market_price) {
            this.market_price = market_price;
        }

        public String getBig_photo_url() {
            return big_photo_url;
        }

        public void setBig_photo_url(String big_photo_url) {
            this.big_photo_url = big_photo_url;
        }

        public String getThumb_photo_url() {
            return thumb_photo_url;
        }

        public void setThumb_photo_url(String thumb_photo_url) {
            this.thumb_photo_url = thumb_photo_url;
        }

        public Object getA_photo_url() {
            return a_photo_url;
        }

        public void setA_photo_url(Object a_photo_url) {
            this.a_photo_url = a_photo_url;
        }

        public Object getB_photo_url() {
            return b_photo_url;
        }

        public void setB_photo_url(Object b_photo_url) {
            this.b_photo_url = b_photo_url;
        }

        public Object getC_photo_url() {
            return c_photo_url;
        }

        public void setC_photo_url(Object c_photo_url) {
            this.c_photo_url = c_photo_url;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public boolean isNeed_carriage() {
            return need_carriage;
        }

        public void setNeed_carriage(boolean need_carriage) {
            this.need_carriage = need_carriage;
        }

        public int getCategory_id() {
            return category_id;
        }

        public void setCategory_id(int category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getState_text() {
            return state_text;
        }

        public void setState_text(String state_text) {
            this.state_text = state_text;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDetail_url() {
            return detail_url;
        }

        public void setDetail_url(String detail_url) {
            this.detail_url = detail_url;
        }

        public int getMonth_quantity() {
            return month_quantity;
        }

        public void setMonth_quantity(int month_quantity) {
            this.month_quantity = month_quantity;
        }

        public String getUnit_name() {
            return unit_name;
        }

        public void setUnit_name(String unit_name) {
            this.unit_name = unit_name;
        }

        public String getCarriage_desc() {
            return carriage_desc;
        }

        public void setCarriage_desc(String carriage_desc) {
            this.carriage_desc = carriage_desc;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public List<?> getAll_thumb_photo_urls() {
            return all_thumb_photo_urls;
        }

        public void setAll_thumb_photo_urls(List<?> all_thumb_photo_urls) {
            this.all_thumb_photo_urls = all_thumb_photo_urls;
        }

        public List<?> getAll_big_photo_urls() {
            return all_big_photo_urls;
        }

        public void setAll_big_photo_urls(List<?> all_big_photo_urls) {
            this.all_big_photo_urls = all_big_photo_urls;
        }

        public List<String> getSquare_photo_urls() {
            return square_photo_urls;
        }

        public void setSquare_photo_urls(List<String> square_photo_urls) {
            this.square_photo_urls = square_photo_urls;
        }

        public static class ShareBean {
            /**
             * share_title : 唤醒肠道活力｜超模25 肠道益生菌 6g×30
             * share_link : http://wap.koudaitong.com/v2/home/rky71018
             * share_image : http://up.boohee.cn/house/u/shop/p_tm25_cdysj_qm/thumb_v1.jpg
             * share_description : 我在薄荷商店发现了这货：唤醒肠道活力｜超模25 肠道益生菌 6g×30 推荐你也来看看哦~
             */

            private String share_title;
            private String share_link;
            private String share_image;
            private String share_description;

            public String getShare_title() {
                return share_title;
            }

            public void setShare_title(String share_title) {
                this.share_title = share_title;
            }

            public String getShare_link() {
                return share_link;
            }

            public void setShare_link(String share_link) {
                this.share_link = share_link;
            }

            public String getShare_image() {
                return share_image;
            }

            public void setShare_image(String share_image) {
                this.share_image = share_image;
            }

            public String getShare_description() {
                return share_description;
            }

            public void setShare_description(String share_description) {
                this.share_description = share_description;
            }
        }
    }
}
