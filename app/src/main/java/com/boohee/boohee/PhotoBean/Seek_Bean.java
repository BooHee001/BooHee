package com.boohee.boohee.PhotoBean;

import java.util.List;

/**
 * Created by Huochai on 2016/11/28.
 */

public class Seek_Bean {

    /**
     * keyword_count : 6
     * keywords : ["米饭","苹果","鸡蛋","香蕉","橘子","牛奶"]
     */

    private int keyword_count;
    private List<String> keywords;

    public int getKeyword_count() {
        return keyword_count;
    }

    public void setKeyword_count(int keyword_count) {
        this.keyword_count = keyword_count;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
