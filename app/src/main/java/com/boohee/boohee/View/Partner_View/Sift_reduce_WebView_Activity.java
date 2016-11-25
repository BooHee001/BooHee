package com.boohee.boohee.View.Partner_View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.MyChromClient;
import com.boohee.boohee.Bean.Shop_Bean.Partner_Bean.MyWebViewClient;
import com.boohee.boohee.R;

public class Sift_reduce_WebView_Activity extends AppCompatActivity {

    private WebView reduce_webview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sift_reduce_webview);

        initView();

        initData();

    }

    private void initData() {
        WebSettings webSettings = reduce_webview.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        reduce_webview.getSettings().setJavaScriptEnabled(true);
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

                }

            }
        });

        reduce_webview.setWebViewClient(new WebViewClient() {
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

        reduce_webview.setWebChromeClient(chromClient);


        reduce_webview.loadUrl("http://one.boohee.com/api/v1/services/intro?app_device=Android&os_version=6.0.1&app_version=5.6.3.1&version_code=108&channel=huawei&app_key=one&token=w9eSJ5JcC3sySFicgim2");

    }

    private void initView() {
        reduce_webview = (WebView) findViewById(R.id.reduce_webview);
    }

    public void onclick(View v){
        switch (v.getId()){
            case R.id.reduce_webview_back:

                finish();
                break;

            case R.id.touch_service:

                Toast.makeText(Sift_reduce_WebView_Activity.this, "修建尚未完成，再等等吧~", Toast.LENGTH_SHORT).show();
                break;

            case R.id.i_want_pay:

                Toast.makeText(Sift_reduce_WebView_Activity.this, "修建尚未完成，再等等吧~", Toast.LENGTH_SHORT).show();
                break;
        }

    }


}
