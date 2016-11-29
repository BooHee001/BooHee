package com.boohee.boohee.Bean.shop_Bean;

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
    private String date;
    @Column(name = "weight")
    private float weight;
    @Column(name = "position")
    private int position;

    public WeightLog(int id, String date, float weight, int position) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.position = position;
    }

    public WeightLog(String date, float weight, int position) {
        this.date = date;
        this.weight = weight;
        this.position = position;
    }

    public WeightLog(int id, String date, float weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public WeightLog() {
    }
}
