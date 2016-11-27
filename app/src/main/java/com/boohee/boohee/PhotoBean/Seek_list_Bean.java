package com.boohee.boohee.PhotoBean;

import java.util.List;

/**
 * Created by Huochai on 2016/11/28.
 */

public class Seek_list_Bean {

    private List<FoodsBean> foods;

    public List<FoodsBean> getFoods() {
        return foods;
    }

    public void setFoods(List<FoodsBean> foods) {
        this.foods = foods;
    }

    public static class FoodsBean {
        /**
         * id : 49
         * code : xiangdami
         * name : 香大米
         * thumb_image_url : http://s.boohee.cn/house/food_mid/mid_photo_201022549.jpg
         * is_liquid : false
         * health_light : 1
         * weight : 100
         * calory : 347
         */

        private int id;
        private String code;
        private String name;
        private String thumb_image_url;
        private boolean is_liquid;
        private int health_light;
        private String weight;
        private String calory;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getThumb_image_url() {
            return thumb_image_url;
        }

        public void setThumb_image_url(String thumb_image_url) {
            this.thumb_image_url = thumb_image_url;
        }

        public boolean isIs_liquid() {
            return is_liquid;
        }

        public void setIs_liquid(boolean is_liquid) {
            this.is_liquid = is_liquid;
        }

        public int getHealth_light() {
            return health_light;
        }

        public void setHealth_light(int health_light) {
            this.health_light = health_light;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getCalory() {
            return calory;
        }

        public void setCalory(String calory) {
            this.calory = calory;
        }
    }
}
