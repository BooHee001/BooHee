package com.boohee.boohee.presenter;

import com.boohee.boohee.View.V_Login;
import com.boohee.boohee.model.M_Login;
import com.boohee.boohee.model.M_Login_Impl;

/**
 * Created by as on 2016/11/28.
 */

public class P_Login_Impl implements P_Login{
    M_Login m_login = new M_Login_Impl(this);
    private V_Login v_login;

    public P_Login_Impl(V_Login v_login) {
        this.v_login = v_login;
    }

    @Override
    public void getResult(String result) {
        v_login.getResult(result);

    }
    public void getResult(int userno, String pwd){
        m_login.getResult(userno,pwd);
    }
}
