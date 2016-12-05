package com.boohee.boohee.View.Partner_View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


import com.boohee.boohee.Bean.shop_Bean.partner_Bean.MyChromClient;
import com.boohee.boohee.Bean.shop_Bean.partner_Bean.MyWebViewClient;

import com.boohee.boohee.R;

public class Sift_item_ViewPager_WebView1 extends AppCompatActivity {

    private WebView vp1_webview = null;
    private TextView vp1_title_txt = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sift_item__view_pager__webview1);

        initView();

        initData();
    }

    private void initData() {

        WebSettings webSettings = vp1_webview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        vp1_webview.getSettings().setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        MyChromClient chromClient = new MyChromClient();
        MyWebViewClient client = new MyWebViewClient();
        client.setClientListener(new MyWebViewClient.ClientCallback() {
            @Override
            public void onStart(String url) {

            }

            @Override
            public void onFinish(String url) {

            }
        });

        chromClient.setChromListener(new MyChromClient.ChromCallback() {

            @Override
            public void onProgressChanged(int progress) {

            }

            @Override
            public void onReceivedTitle(String title) {
                if (!TextUtils.isEmpty(title)){
                    setTitle(title);
                    vp1_title_txt.setText(title);
                }

            }
        });

        vp1_webview.setWebViewClient(new WebViewClient() {
            // 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            // 重写此方法可以让webview处理https请求
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, android.net.http.SslError error) {
//                handler.proceed();
//            }
        });

        vp1_webview.setWebChromeClient(chromClient);


        vp1_webview.loadUrl("http://one.boohee.com/store/pages/bbhw");

    }

    private void initView() {
        vp1_webview = (WebView) findViewById(R.id.vp1_webview);
        vp1_title_txt = (TextView) findViewById(R.id.vp1_title_txt);
    }

    public void onclick(View v){
        switch (v.getId()){
            case R.id.vp1_webview_back:

                finish();
                break;
        }

    }
}
