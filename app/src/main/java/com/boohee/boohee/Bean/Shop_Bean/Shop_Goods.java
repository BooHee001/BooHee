package com.boohee.boohee.Bean.shop_Bean;

import java.util.List;

/**
 * Created by as on 2016/11/19.
 */

public class Shop_Goods {


    private List<?> banner_showcases;
    private List<?> categories;
    private List<DatasBean> datas;

    public List<?> getBanner_showcases() {
        return banner_showcases;
    }

    public void setBanner_showcases(List<?> banner_showcases) {
        this.banner_showcases = banner_showcases;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public List<DatasBean> getDatas() {
        return datas;
    }

    public void setDatas(List<DatasBean> datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * title : 首页广告-活动
         * type : homepage_showcase
         * list : [{"id":1094,"exhibit":"1128","page_title":"","default_photo_url":"http://up.boohee.cn/house/u/shop/ad_page/20161112/banner_1v2.jpg","default_photo_height":200,"default_photo_width":620,"exhibit_type":"goods"}]
         */

        private String title;
        private String type;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 1094
             * exhibit : 1128
             * page_title :
             * default_photo_url : http://up.boohee.cn/house/u/shop/ad_page/20161112/banner_1v2.jpg
             * default_photo_height : 200
             * default_photo_width : 620
             * exhibit_type : goods
             */


            private int id;
            private String exhibit;
            private String page_title;
            private String default_photo_url;
            private int default_photo_height;
            private int default_photo_width;
            private String exhibit_type;
            private String title;
            private String base_price;
            private String market_price;
            private String category_name;
            private String thumb_photo_url;
            private String big_photo_url;
            private String state;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getExhibit() {
                return exhibit;
            }

            public void setExhibit(String exhibit) {
                this.exhibit = exhibit;
            }

            public String getPage_title() {
                return page_title;
            }

            public void setPage_title(String page_title) {
                this.page_title = page_title;
            }

            public String getDefault_photo_url() {
                return default_photo_url;
            }

            public void setDefault_photo_url(String default_photo_url) {
                this.default_photo_url = default_photo_url;
            }

            public int getDefault_photo_height() {
                return default_photo_height;
            }

            public void setDefault_photo_height(int default_photo_height) {
                this.default_photo_height = default_photo_height;
            }

            public int getDefault_photo_width() {
                return default_photo_width;
            }

            public void setDefault_photo_width(int default_photo_width) {
                this.default_photo_width = default_photo_width;
            }

            public String getExhibit_type() {
                return exhibit_type;
            }

            public void setExhibit_type(String exhibit_type) {
                this.exhibit_type = exhibit_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBase_price() {
                return base_price;
            }

            public void setBase_price(String base_price) {
                this.base_price = base_price;
            }

            public String getMarket_price() {
                return market_price;
            }

            public void setMarket_price(String market_price) {
                this.market_price = market_price;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getThumb_photo_url() {
                return thumb_photo_url;
            }

            public void setThumb_photo_url(String thumb_photo_url) {
                this.thumb_photo_url = thumb_photo_url;
            }

            public String getBig_photo_url() {
                return big_photo_url;
            }

            public void setBig_photo_url(String big_photo_url) {
                this.big_photo_url = big_photo_url;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public ListBean() {
            }

            public ListBean(int id, String exhibit, String page_title, String default_photo_url, int default_photo_height, int default_photo_width, String exhibit_type, String title, String base_price, String market_price, String category_name, String thumb_photo_url, String big_photo_url, String state) {
                this.id = id;
                this.exhibit = exhibit;
                this.page_title = page_title;
                this.default_photo_url = default_photo_url;
                this.default_photo_height = default_photo_height;
                this.default_photo_width = default_photo_width;
                this.exhibit_type = exhibit_type;
                this.title = title;
                this.base_price = base_price;
                this.market_price = market_price;
                this.category_name = category_name;
                this.thumb_photo_url = thumb_photo_url;
                this.big_photo_url = big_photo_url;
                this.state = state;
            }
        }
    }
}
