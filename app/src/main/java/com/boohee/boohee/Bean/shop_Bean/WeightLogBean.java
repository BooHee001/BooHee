package com.boohee.boohee.Bean.shop_Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Dizner on 16/11/28.
 */
@Table(name = "weight")
public class WeightLogBean {
    @Column(name = "_id",isId = true)
    private int id;
    @Column(name = "date")
    private long date;
    @Column(name = "weight")
    private int weight;

    public WeightLogBean(int weight, int id, long date) {
        this.weight = weight;
        this.id = id;
        this.date = date;
    }

    public WeightLogBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
