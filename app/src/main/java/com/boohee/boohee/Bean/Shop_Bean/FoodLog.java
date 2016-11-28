package com.boohee.boohee.Bean.shop_Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Dizner on 2016/11/25.
 */
@Table(name = "foodLog")
public class FoodLog {
    @Column(name = "_id",isId = true,autoGen = true)
    private int id;
    @Column(name = "type")
    private int type;
    @Column(name = "foodCount")
    private int foodCount;

    public FoodLog(int id, int type, int foodCount) {
        this.id = id;
        this.type = type;
        this.foodCount = foodCount;
    }

    public FoodLog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }
}
