package com.boohee.boohee.presenter;

import com.boohee.boohee.PhotoBean.Seek_Bean;
import com.boohee.boohee.View.Partner_View.V_Seek_list_item;
import com.boohee.boohee.model.M_Seek_list_item;
import com.boohee.boohee.model.M_Seek_list_items;

/**
 * Created by Huochai on 2016/11/28.
 */

public class P_Seek_list_item_Impl implements P_Seek_list_item{

    M_Seek_list_item m_seek_list_item = new M_Seek_list_items(this);
    private V_Seek_list_item v_seek_list_item;

    public P_Seek_list_item_Impl(V_Seek_list_item v_seek_list_item) {
        this.v_seek_list_item = v_seek_list_item;
    }

    @Override
    public void getSeacher(String result) {
        v_seek_list_item.getSeacher(result);
    }
    public void seek_list_item(String seacher){
        m_seek_list_item.seek_list_item(seacher);

    }


}
