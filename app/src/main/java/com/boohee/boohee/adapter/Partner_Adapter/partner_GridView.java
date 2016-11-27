package com.boohee.boohee.adapter.Partner_Adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by Huochai on 2016/11/25.
 */

public class partner_GridView extends GridView {


        public partner_GridView(Context context) {
            super(context);
        }

        public partner_GridView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }

        public partner_GridView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
        }

}
