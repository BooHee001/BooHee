package com.boohee.boohee.Bean.Shop_Bean.Partner_Bean;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by PF on 2016/10/17.
 */
public class MyChromClient extends WebChromeClient {

    public interface ChromCallback{
        void onProgressChanged(int progress);
        void onReceivedTitle(String title);
    }

    private ChromCallback mCallback = null;
    public void setChromListener(ChromCallback mCallback){
        this.mCallback = mCallback;
    }

    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);

        if (mCallback != null){
            mCallback.onProgressChanged(newProgress);
        }
    }

    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);

        if (mCallback != null){
            mCallback.onReceivedTitle(title);
        }
    }
}
