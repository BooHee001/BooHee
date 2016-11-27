package com.boohee.boohee.Bean.shop_Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Dizner on 16/11/28.
 */
@Table(name = "type")
public class TypeBean {
    @Column(name = "_id",isId = true,autoGen = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "isTrue")
    private boolean isTrue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public TypeBean(int id, String name, boolean isTrue) {
        this.id = id;
        this.name = name;
        this.isTrue = isTrue;
    }

    public TypeBean(String name, boolean isTrue) {
        this.name = name;
        this.isTrue = isTrue;
    }

    public TypeBean() {
    }
}
