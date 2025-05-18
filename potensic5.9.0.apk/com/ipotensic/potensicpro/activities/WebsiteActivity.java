package com.ipotensic.potensicpro.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.notchtools.NotchTools;
import com.ipotensic.potensicpro.C2640R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* loaded from: classes2.dex */
public class WebsiteActivity extends BaseActivity implements View.OnClickListener {
    private HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
    private ProgressBar progressBar;
    private WebView webView;

    public void jumpToBrowser(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        context.startActivity(intent);
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(C2640R.layout.activity_official_website);
        this.progressBar = (ProgressBar) findViewById(C2640R.id.progress);
        findViewById(C2640R.id.img_return).setOnClickListener(this);
        if (getResources().getConfiguration().orientation == 1) {
            ((RelativeLayout) findViewById(C2640R.id.layout_top)).setPadding(0, NotchTools.getFullScreenTools().getStatusHeight(getWindow()), 0, 0);
        }
        DDLog.m1687i("加载url：");
        WebView webView = (WebView) findViewById(C2640R.id.webview);
        this.webView = webView;
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        this.webView.addJavascriptInterface(this, "Android");
        settings.setUseWideViewPort(true);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setDomStorageEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        this.webView.setWebViewClient(new WebViewClient() { // from class: com.ipotensic.potensicpro.activities.WebsiteActivity.1
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, WebResourceRequest webResourceRequest) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView2, String str) {
                return false;
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
                WebsiteActivity.this.progressBar.setVisibility(4);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView2, String str, Bitmap bitmap) {
                super.onPageStarted(webView2, str, bitmap);
                WebsiteActivity.this.progressBar.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView webView2, WebResourceRequest webResourceRequest) {
                try {
                    DDLog.m1684e("request url：" + webResourceRequest.getUrl());
                } catch (Exception e) {
                    DDLog.m1684e("请求出错:" + e.getMessage());
                }
                return super.shouldInterceptRequest(webView2, webResourceRequest);
            }
        });
        this.webView.setWebChromeClient(new WebChromeClient() { // from class: com.ipotensic.potensicpro.activities.WebsiteActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                if (i >= 100) {
                    WebsiteActivity.this.progressBar.setVisibility(4);
                } else {
                    WebsiteActivity.this.progressBar.setVisibility(0);
                    WebsiteActivity.this.progressBar.setProgress(i);
                }
                super.onProgressChanged(webView2, i);
            }
        });
        this.webView.loadUrl("");
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.webView.clearCache(true);
        this.webView.clearHistory();
        this.webView.clearFormData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        toBack();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != C2640R.id.img_return) {
            return;
        }
        toBack();
    }

    private void toBack() {
        if (this.webView.canGoBack()) {
            this.webView.goBack();
        } else {
            finish();
        }
    }

    private OkHttpClient createOkHttpClient() {
        return new OkHttpClient.Builder().addNetworkInterceptor(new Interceptor() { // from class: com.ipotensic.potensicpro.activities.WebsiteActivity.4
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        }).cookieJar(new CookieJar() { // from class: com.ipotensic.potensicpro.activities.WebsiteActivity.3
            @Override // okhttp3.CookieJar
            public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                WebsiteActivity.this.cookieStore.put(httpUrl.host(), list);
            }

            @Override // okhttp3.CookieJar
            public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                List<Cookie> list = (List) WebsiteActivity.this.cookieStore.get(httpUrl.host());
                return list != null ? list : new ArrayList();
            }
        }).build();
    }
}