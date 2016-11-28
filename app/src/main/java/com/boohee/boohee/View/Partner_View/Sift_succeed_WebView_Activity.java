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

public class Sift_succeed_WebView_Activity extends AppCompatActivity {
    private WebView succeed_webview = null;
    private TextView succeed_txt = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sift_succeed__web_view);
        initView();

        initData();



    }

    private void initView() {
        succeed_webview = (WebView) findViewById(R.id.succeed_webview);
        succeed_txt = (TextView) findViewById(R.id.succeed_txt);
    }

    private void initData() {
        WebSettings webSettings = succeed_webview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        succeed_webview.getSettings().setJavaScriptEnabled(true);
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
                    succeed_txt.setText(title);
                }

            }
        });

        succeed_webview.setWebViewClient(new WebViewClient() {
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

        succeed_webview.setWebChromeClient(chromClient);


        succeed_webview.loadUrl("http://m.boohee.com/");
    }

    public void onclick(View v){
        switch (v.getId()){
            case R.id.succeed_webview_back:

                finish();
                break;
        }

    }


}
