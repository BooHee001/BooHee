package com.boohee.boohee.Bean.Shop_Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Dizner on 2016/11/25.
 */
@Table(name = "weight")
public class WeightLog {
    @Column(name = "_id",isId = true,autoGen = true)
    private int id;
    @Column(name = "date")
    private int date;
    @Column(name = "weight")
    private float weight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public WeightLog(int id, int date, float weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public WeightLog() {
    }
}
