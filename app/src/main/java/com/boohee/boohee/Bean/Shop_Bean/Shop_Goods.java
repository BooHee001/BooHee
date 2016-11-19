package com.boohee.boohee.Bean.Shop_Bean;

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
        }
    }
}
