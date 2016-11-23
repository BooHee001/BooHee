package com.boohee.boohee.PhotoBean;

import java.util.List;

/**
 * Created by Dizner on 2016/11/22.
 */

public class PhotoBean {

    /**
     * welcome_img : {"hello_text":"小雪","back_img":"http://up.boohee.cn/house/u/one/wallpaper/104_big_v2.jpg","back_img_small":"http://up.boohee.cn/house/u/one/wallpaper/104_small_v2.jpg","date":"2016-11-22","week_images":[{"date":"2016-11-16","back_img":"http://up.boohee.cn/house/u/one/wallpaper/547_big.jpg"},{"date":"2016-11-17","back_img":"http://up.boohee.cn/house/u/one/wallpaper/207_big.jpg"},{"date":"2016-11-18","back_img":"http://up.boohee.cn/house/u/one/wallpaper/546_big.jpg"},{"date":"2016-11-19","back_img":"http://up.boohee.cn/house/u/one/wallpaper/548_big.jpg"},{"date":"2016-11-20","back_img":"http://up.boohee.cn/house/u/one/wallpaper/550_big.jpg"},{"date":"2016-11-21","back_img":"http://up.boohee.cn/house/u/one/wallpaper/549_big.jpg"},{"date":"2016-11-22","back_img":"http://up.boohee.cn/house/u/one/wallpaper/104_big_v2.jpg"}]}
     * diet_plan : {"user_link":"http://bingo.boohee.com/api/v1/user_diets.html","super_model_link":"http://bingo.boohee.com/api/v1/user_diets/supermodel.html","data":[{"name":"breakfast","time_span":"00:00-10:00","content":"早餐建议：谷薯类270大卡、奶类135大卡、肉蛋豆类90大卡、坚果类90大卡","detail":[{"name":"玉米(鲜)","amount":1,"unit":"根(大)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201512613192563.jpg","code":"yumi_xian","calory":0,"unit_id":19},{"name":"牛奶","amount":1,"unit":"盒","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131143228872.jpg","code":"niuru_junzhi","calory":0,"unit_id":213},{"name":"鸡蛋","amount":1,"unit":"只(中)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131131916910.jpg","code":"jidan_junzhi","calory":0,"unit_id":34},{"name":"杏仁","amount":16,"unit":"颗","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201524163015644.jpg","code":"xingren","calory":0,"unit_id":84}],"calory":585},{"name":"lunch","time_span":"10:00-14:00","content":"午餐建议：谷薯类270大卡、蔬菜类45大卡、肉蛋豆类180大卡、油脂类90大卡","detail":[{"name":"米饭","amount":250,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201512613144756.jpg","code":"mifan_zheng","calory":0,"unit_id":null},{"name":"蒜蓉西兰花","amount":200,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_20128108532118062.jpg","code":"suanrongxilanhua","calory":0,"unit_id":null},{"name":"水煮鱼片","amount":180,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/7/12/user_mid_76228_1215841479.jpg","code":"shuizhuyupian","calory":0,"unit_id":null}],"calory":585},{"name":"extral_meal","time_span":"14:00-16:00","content":"加餐建议：水果类270大卡","detail":[{"name":"红提子葡萄","amount":20,"unit":"颗","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015261839131617.jpg","code":"hongtiziputao","calory":0,"unit_id":286},{"name":"火龙果","amount":1,"unit":"个","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015221718261622.jpg","code":"huolongguo","calory":0,"unit_id":91}],"calory":270},{"name":"dinner","time_span":"16:00-23:59","content":"晚餐建议：谷薯类180大卡、蔬菜类45大卡、肉蛋豆类90大卡、油脂类90大卡","detail":[{"name":"紫薯","amount":200,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015231333727008.jpg","code":"zishu","calory":0,"unit_id":null},{"name":"凉拌海带丝","amount":150,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/9/15/user_mid_130467_1221488996.jpg","code":"liangbanhaidaisi","calory":0,"unit_id":null},{"name":"五香白豆干","amount":100,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/6/20/user_76228_1213922422.jpg","code":"wuxiangbaidougan","calory":0,"unit_id":null}],"calory":405}]}
     * sports_plan : null
     */

    private WelcomeImgBean welcome_img;
    private DietPlanBean diet_plan;
    private Object sports_plan;

    public WelcomeImgBean getWelcome_img() {
        return welcome_img;
    }

    public void setWelcome_img(WelcomeImgBean welcome_img) {
        this.welcome_img = welcome_img;
    }

    public DietPlanBean getDiet_plan() {
        return diet_plan;
    }

    public void setDiet_plan(DietPlanBean diet_plan) {
        this.diet_plan = diet_plan;
    }

    public Object getSports_plan() {
        return sports_plan;
    }

    public void setSports_plan(Object sports_plan) {
        this.sports_plan = sports_plan;
    }

    public static class WelcomeImgBean {
        /**
         * hello_text : 小雪
         * back_img : http://up.boohee.cn/house/u/one/wallpaper/104_big_v2.jpg
         * back_img_small : http://up.boohee.cn/house/u/one/wallpaper/104_small_v2.jpg
         * date : 2016-11-22
         * week_images : [{"date":"2016-11-16","back_img":"http://up.boohee.cn/house/u/one/wallpaper/547_big.jpg"},{"date":"2016-11-17","back_img":"http://up.boohee.cn/house/u/one/wallpaper/207_big.jpg"},{"date":"2016-11-18","back_img":"http://up.boohee.cn/house/u/one/wallpaper/546_big.jpg"},{"date":"2016-11-19","back_img":"http://up.boohee.cn/house/u/one/wallpaper/548_big.jpg"},{"date":"2016-11-20","back_img":"http://up.boohee.cn/house/u/one/wallpaper/550_big.jpg"},{"date":"2016-11-21","back_img":"http://up.boohee.cn/house/u/one/wallpaper/549_big.jpg"},{"date":"2016-11-22","back_img":"http://up.boohee.cn/house/u/one/wallpaper/104_big_v2.jpg"}]
         */

        private String hello_text;
        private String back_img;
        private String back_img_small;
        private String date;
        private List<WeekImagesBean> week_images;

        public String getHello_text() {
            return hello_text;
        }

        public void setHello_text(String hello_text) {
            this.hello_text = hello_text;
        }

        public String getBack_img() {
            return back_img;
        }

        public void setBack_img(String back_img) {
            this.back_img = back_img;
        }

        public String getBack_img_small() {
            return back_img_small;
        }

        public void setBack_img_small(String back_img_small) {
            this.back_img_small = back_img_small;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<WeekImagesBean> getWeek_images() {
            return week_images;
        }

        public void setWeek_images(List<WeekImagesBean> week_images) {
            this.week_images = week_images;
        }

        public static class WeekImagesBean {
            /**
             * date : 2016-11-16
             * back_img : http://up.boohee.cn/house/u/one/wallpaper/547_big.jpg
             */

            private String date;
            private String back_img;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getBack_img() {
                return back_img;
            }

            public void setBack_img(String back_img) {
                this.back_img = back_img;
            }
        }
    }

    public static class DietPlanBean {
        /**
         * user_link : http://bingo.boohee.com/api/v1/user_diets.html
         * super_model_link : http://bingo.boohee.com/api/v1/user_diets/supermodel.html
         * data : [{"name":"breakfast","time_span":"00:00-10:00","content":"早餐建议：谷薯类270大卡、奶类135大卡、肉蛋豆类90大卡、坚果类90大卡","detail":[{"name":"玉米(鲜)","amount":1,"unit":"根(大)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201512613192563.jpg","code":"yumi_xian","calory":0,"unit_id":19},{"name":"牛奶","amount":1,"unit":"盒","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131143228872.jpg","code":"niuru_junzhi","calory":0,"unit_id":213},{"name":"鸡蛋","amount":1,"unit":"只(中)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131131916910.jpg","code":"jidan_junzhi","calory":0,"unit_id":34},{"name":"杏仁","amount":16,"unit":"颗","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201524163015644.jpg","code":"xingren","calory":0,"unit_id":84}],"calory":585},{"name":"lunch","time_span":"10:00-14:00","content":"午餐建议：谷薯类270大卡、蔬菜类45大卡、肉蛋豆类180大卡、油脂类90大卡","detail":[{"name":"米饭","amount":250,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201512613144756.jpg","code":"mifan_zheng","calory":0,"unit_id":null},{"name":"蒜蓉西兰花","amount":200,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_20128108532118062.jpg","code":"suanrongxilanhua","calory":0,"unit_id":null},{"name":"水煮鱼片","amount":180,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/7/12/user_mid_76228_1215841479.jpg","code":"shuizhuyupian","calory":0,"unit_id":null}],"calory":585},{"name":"extral_meal","time_span":"14:00-16:00","content":"加餐建议：水果类270大卡","detail":[{"name":"红提子葡萄","amount":20,"unit":"颗","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015261839131617.jpg","code":"hongtiziputao","calory":0,"unit_id":286},{"name":"火龙果","amount":1,"unit":"个","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015221718261622.jpg","code":"huolongguo","calory":0,"unit_id":91}],"calory":270},{"name":"dinner","time_span":"16:00-23:59","content":"晚餐建议：谷薯类180大卡、蔬菜类45大卡、肉蛋豆类90大卡、油脂类90大卡","detail":[{"name":"紫薯","amount":200,"unit":"克","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015231333727008.jpg","code":"zishu","calory":0,"unit_id":null},{"name":"凉拌海带丝","amount":150,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/9/15/user_mid_130467_1221488996.jpg","code":"liangbanhaidaisi","calory":0,"unit_id":null},{"name":"五香白豆干","amount":100,"unit":"克","image_url":"http://f1.boohee.com/house/upload_food/2008/6/20/user_76228_1213922422.jpg","code":"wuxiangbaidougan","calory":0,"unit_id":null}],"calory":405}]
         */

        private String user_link;
        private String super_model_link;
        private List<DataBean> data;

        public String getUser_link() {
            return user_link;
        }

        public void setUser_link(String user_link) {
            this.user_link = user_link;
        }

        public String getSuper_model_link() {
            return super_model_link;
        }

        public void setSuper_model_link(String super_model_link) {
            this.super_model_link = super_model_link;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * name : breakfast
             * time_span : 00:00-10:00
             * content : 早餐建议：谷薯类270大卡、奶类135大卡、肉蛋豆类90大卡、坚果类90大卡
             * detail : [{"name":"玉米(鲜)","amount":1,"unit":"根(大)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201512613192563.jpg","code":"yumi_xian","calory":0,"unit_id":19},{"name":"牛奶","amount":1,"unit":"盒","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131143228872.jpg","code":"niuru_junzhi","calory":0,"unit_id":213},{"name":"鸡蛋","amount":1,"unit":"只(中)","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_2015131131916910.jpg","code":"jidan_junzhi","calory":0,"unit_id":34},{"name":"杏仁","amount":16,"unit":"颗","image_url":"http://f1.boohee.com/house/food_mid/mid_photo_201524163015644.jpg","code":"xingren","calory":0,"unit_id":84}]
             * calory : 585
             */

            private String name;
            private String time_span;
            private String content;
            private int calory;
            private List<DetailBean> detail;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTime_span() {
                return time_span;
            }

            public void setTime_span(String time_span) {
                this.time_span = time_span;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCalory() {
                return calory;
            }

            public void setCalory(int calory) {
                this.calory = calory;
            }

            public List<DetailBean> getDetail() {
                return detail;
            }

            public void setDetail(List<DetailBean> detail) {
                this.detail = detail;
            }

            public static class DetailBean {
                /**
                 * name : 玉米(鲜)
                 * amount : 1
                 * unit : 根(大)
                 * image_url : http://f1.boohee.com/house/food_mid/mid_photo_201512613192563.jpg
                 * code : yumi_xian
                 * calory : 0
                 * unit_id : 19
                 */

                private String name;
                private int amount;
                private String unit;
                private String image_url;
                private String code;
                private int calory;
                private int unit_id;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getAmount() {
                    return amount;
                }

                public void setAmount(int amount) {
                    this.amount = amount;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public String getImage_url() {
                    return image_url;
                }

                public void setImage_url(String image_url) {
                    this.image_url = image_url;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getCalory() {
                    return calory;
                }

                public void setCalory(int calory) {
                    this.calory = calory;
                }

                public int getUnit_id() {
                    return unit_id;
                }

                public void setUnit_id(int unit_id) {
                    this.unit_id = unit_id;
                }
            }
        }
    }
}
