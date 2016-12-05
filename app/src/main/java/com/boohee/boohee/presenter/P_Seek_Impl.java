package com.boohee.boohee.presenter;

import com.boohee.boohee.PhotoBean.Seek_Bean;
import com.boohee.boohee.View.Partner_View.V_Seek;
import com.boohee.boohee.model.Seek_Model_impl;

/**
 * Created by Huochai on 2016/11/28.
 */

public class P_Seek_Impl implements P_Seek{

    Seek_Model_impl seek_model_impl = new Seek_Model_impl(this);
    private V_Seek v_seek;

    public P_Seek_Impl(V_Seek v_seek) {
        this.v_seek = v_seek;
    }

    @Override
    public void setSeek_Beans(Seek_Bean seek_bean) {
        v_seek.setSeek_Beans(seek_bean);
    }
    public void initSeek(){
        seek_model_impl.initSeek();
    }


}
