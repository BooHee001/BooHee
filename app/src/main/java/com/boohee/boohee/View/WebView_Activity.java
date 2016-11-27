package com.boohee.boohee.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.MyChromClient;
import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.MyWebViewClient;
import com.boohee.boohee.R;

public class WebView_Activity extends AppCompatActivity {

    private WebView Webview_this = null;
    private TextView WebView_txt = null;

    String WebView_Url;
    String WebView_txts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partner_sift_loseweight__webview);

        initView();

        initData();



    }

    private void initView() {

        Webview_this = (WebView) findViewById(R.id.Webview_this);
        WebView_txt = (TextView) findViewById(R.id.WebView_txt);

        Intent WebView_Intent = getIntent();
        WebView_Url = WebView_Intent.getStringExtra("weburl");
        WebView_txts = WebView_Intent.getStringExtra("webtxt");
        WebView_txt.setText(WebView_txts);
    }

    private void initData() {
        WebSettings webSettings = Webview_this.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setJavaScriptEnabled(true);
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
                    WebView_txt.setText(title);
                }

            }
        });

        Webview_this.setWebViewClient(new WebViewClient() {
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

        Webview_this.setWebChromeClient(chromClient);

//        Webview_this.loadUrl(WebView_Url);
        Webview_this.loadUrl("http://m.boohee.com/");
    }

    public void onclick(View v){
        switch (v.getId()){
            case R.id.Webview_back:

                finish();
                break;
        }

    }





}
