package com.boohee.boohee.Bean.shop_Bean;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by Dizner on 16/11/28.
 */
@Table(name = "user")
public class UserBean {
    @Column(name = "_id", isId = true, autoGen = true)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "psw")
    private String psw;

    public UserBean(int id, String name, String psw) {
        this.id = id;
        this.name = name;
        this.psw = psw;
    }

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

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public UserBean() {
    }
}
