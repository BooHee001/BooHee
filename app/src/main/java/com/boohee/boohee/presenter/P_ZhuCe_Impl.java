package com.boohee.boohee.presenter;

import com.boohee.boohee.View.V_ZhuCe;
import com.boohee.boohee.model.M_ZhuCe;
import com.boohee.boohee.model.M_ZhuCe_Impl;

/**
 * Created by as on 2016/11/28.
 */

public class P_ZhuCe_Impl implements P_ZhuCe {
    M_ZhuCe m_zhuCe = new M_ZhuCe_Impl(this);
    private V_ZhuCe v_zhuCe;

    public P_ZhuCe_Impl(V_ZhuCe v_zhuCe) {
        this.v_zhuCe = v_zhuCe;
    }

    @Override
    public void setData(String resutl) {
        v_zhuCe.setData(resutl);

    }
    public void initData(int userno, String uerimg, String username, String pwd, String gander, int statuer, int bitbirthday, int uersweight){
        m_zhuCe.initData(userno,uerimg,username,pwd,gander,statuer,bitbirthday,uersweight);
    }
}
