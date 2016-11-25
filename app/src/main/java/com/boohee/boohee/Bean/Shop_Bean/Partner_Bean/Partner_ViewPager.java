package com.boohee.boohee.Bean.Shop_Bean.Partner_Bean;

import java.util.List;

/**
 * Created by Huochai on 2016/11/24.
 */

public class Partner_ViewPager {
    /**
     * sliders : [{"title":"NICE 服务","url":"boohee://nice_service/","pic_url":"http://up.boohee.cn/house/u/shop/ad_page/20161101/01_v4.jpg"},{"title":"好身材日常必备好物","url":"http://one.boohee.com/store/pages/bbhw","pic_url":"http://up.boohee.cn/house/u/shop/ad_page/20161118/banner.jpg"}]
     * labels : [{"title":"减肥知识","url":"http://bingo.boohee.com/api/v1/knowledges/","pic_url":"http://up.boohee.cn/house/u/one/label/1/ic_knowledge.png"},{"title":"成功故事","url":"boohee://story_list/all","pic_url":"http://up.boohee.cn/house/u/one/label/1/ic_story.png"},{"title":"减重服务","url":"boohee://nice_service/","pic_url":"http://up.boohee.cn/house/u/one/label/1/ic_nice.png"},{"title":"热门话题","url":"boohee://more_topic/","pic_url":"http://up.boohee.cn/house/u/one/label/1/ic_topic.png"}]
     * friend_posts_count :
     * hot_posts_count :
     */

    private String friend_posts_count;
    private String hot_posts_count;
    private List<SlidersBean> sliders;
    private List<LabelsBean> labels;

    public String getFriend_posts_count() {
        return friend_posts_count;
    }

    public void setFriend_posts_count(String friend_posts_count) {
        this.friend_posts_count = friend_posts_count;
    }

    public String getHot_posts_count() {
        return hot_posts_count;
    }

    public void setHot_posts_count(String hot_posts_count) {
        this.hot_posts_count = hot_posts_count;
    }

    public List<SlidersBean> getSliders() {
        return sliders;
    }

    public void setSliders(List<SlidersBean> sliders) {
        this.sliders = sliders;
    }

    public List<LabelsBean> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelsBean> labels) {
        this.labels = labels;
    }

    public static class SlidersBean {
        /**
         * title : NICE 服务
         * url : boohee://nice_service/
         * pic_url : http://up.boohee.cn/house/u/shop/ad_page/20161101/01_v4.jpg
         */

        private String title;
        private String url;
        private String pic_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }

    public static class LabelsBean {
        /**
         * title : 减肥知识
         * url : http://bingo.boohee.com/api/v1/knowledges/
         * pic_url : http://up.boohee.cn/house/u/one/label/1/ic_knowledge.png
         */

        private String title;
        private String url;
        private String pic_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }
}
