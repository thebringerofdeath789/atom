package com.ipotensic.baselib.base;

import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.ipotensic.baselib.C1819R;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.bean.CommonBean;
import com.ipotensic.baselib.bean.TitleBean;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.TitleView;
import com.ipotensic.baselib.views.badgeview.DisplayUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: WebActivity.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0003J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0014H\u0002J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010'\u001a\u00020\u001fH\u0016J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0014J\b\u0010.\u001a\u00020\u001fH\u0014J\b\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, m2338d2 = {"Lcom/ipotensic/baselib/base/WebActivity;", "Lcom/ipotensic/baselib/base/BaseActivity;", "()V", "flVideo", "Landroid/widget/FrameLayout;", "isHome", "", "jsInterface", "Lcom/ipotensic/baselib/base/JsViewModel;", "mCustomView", "Landroid/view/View;", "mCustomViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "progressBar", "Landroid/widget/ImageView;", "getProgressBar", "()Landroid/widget/ImageView;", "setProgressBar", "(Landroid/widget/ImageView;)V", MessageBundle.TITLE_ENTRY, "", "titleView", "Lcom/ipotensic/baselib/views/TitleView;", "url", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "webView", "Landroid/webkit/WebView;", "hideLoading", "", "initObserver", "initWebSettings", "jsMethod", "params", "jsMethodWithCallback", "function", "loadPdf", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "showLoading", "Companion", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class WebActivity extends BaseActivity {
    private static final String TAG = "WebActivity";
    public static final String WEB_TITLE = "WEB_TITLE";
    public static final String WEB_URL = "WEB_URL";
    private HashMap _$_findViewCache;
    private FrameLayout flVideo;
    private boolean isHome;
    private JsViewModel jsInterface;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    public ImageView progressBar;
    private String title;
    private TitleView titleView;
    private String url;
    private WebView webView;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void loadPdf(String url) {
        Intrinsics.checkParameterIsNotNull(url, "url");
    }

    public static final /* synthetic */ FrameLayout access$getFlVideo$p(WebActivity webActivity) {
        FrameLayout frameLayout = webActivity.flVideo;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flVideo");
        }
        return frameLayout;
    }

    public static final /* synthetic */ JsViewModel access$getJsInterface$p(WebActivity webActivity) {
        JsViewModel jsViewModel = webActivity.jsInterface;
        if (jsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        return jsViewModel;
    }

    public static final /* synthetic */ TitleView access$getTitleView$p(WebActivity webActivity) {
        TitleView titleView = webActivity.titleView;
        if (titleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        return titleView;
    }

    public static final /* synthetic */ WebView access$getWebView$p(WebActivity webActivity) {
        WebView webView = webActivity.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView;
    }

    public final ImageView getProgressBar() {
        ImageView imageView = this.progressBar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        return imageView;
    }

    public final void setProgressBar(ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.progressBar = imageView;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStateBarShow(true);
        setContentView(C1819R.layout.activity_webview);
        ViewModel viewModel = new ViewModelProvider(this).get(JsViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProvider(this).…(JsViewModel::class.java)");
        this.jsInterface = (JsViewModel) viewModel;
        this.url = getIntent().getStringExtra(WEB_URL);
        this.title = getIntent().getStringExtra(WEB_TITLE);
        initWebSettings();
        initObserver();
        String str = this.url;
        if (str != null) {
            if (NetworkUtils.isNetConnected(this)) {
                WebView webView = this.webView;
                if (webView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                webView.loadUrl(str);
                return;
            }
            ToastUtil.toast(this, getString(C1819R.string.toast_no_network));
        }
    }

    private final void initWebSettings() {
        View findViewById = findViewById(C1819R.id.title_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.title_view)");
        this.titleView = (TitleView) findViewById;
        View findViewById2 = findViewById(C1819R.id.img_loading);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.img_loading)");
        this.progressBar = (ImageView) findViewById2;
        View findViewById3 = findViewById(C1819R.id.fl_video);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "findViewById(R.id.fl_video)");
        this.flVideo = (FrameLayout) findViewById3;
        this.webView = new WebView(getApplicationContext());
        FrameLayout frameLayout = (FrameLayout) findViewById(C1819R.id.ll_container);
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        frameLayout.addView(webView);
        WebView webView2 = this.webView;
        if (webView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        ViewGroup.LayoutParams layoutParams = webView2.getLayoutParams();
        if (layoutParams == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = DisplayUtil.dp2px(this, 88.0f);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView3.setLayoutParams(layoutParams2);
        TitleView titleView = this.titleView;
        if (titleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView.setTitle(this.title);
        TitleView titleView2 = this.titleView;
        if (titleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView2.setOnLeftClick(new Function0<Unit>() { // from class: com.ipotensic.baselib.base.WebActivity$initWebSettings$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WebActivity.this.onBackPressed();
            }
        });
        TitleView titleView3 = this.titleView;
        if (titleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView3.setOnRightClick(new Function1<String, Unit>() { // from class: com.ipotensic.baselib.base.WebActivity$initWebSettings$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String tag) {
                Intrinsics.checkParameterIsNotNull(tag, "tag");
                Gson gson = new Gson();
                int hashCode = tag.hashCode();
                if (hashCode == 106905) {
                    if (tag.equals(TitleBean.TAG_LANGUAGE)) {
                        CommonBean commonBean = new CommonBean(JsViewModel.SHOW_LANGUAGE, null);
                        WebActivity webActivity = WebActivity.this;
                        String json = gson.toJson(commonBean);
                        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(bean)");
                        webActivity.jsMethod(json);
                        return;
                    }
                    return;
                }
                if (hashCode == 3208415 && tag.equals(TitleBean.TAG_HOME)) {
                    CommonBean commonBean2 = new CommonBean(JsViewModel.GO_HOME, null);
                    WebActivity webActivity2 = WebActivity.this;
                    String json2 = gson.toJson(commonBean2);
                    Intrinsics.checkExpressionValueIsNotNull(json2, "gson.toJson(bean)");
                    webActivity2.jsMethod(json2);
                }
            }
        });
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        WebSettings settings = webView4.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setSupportZoom(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(-1);
        settings.setAllowFileAccess(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setMixedContentMode(0);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        JsViewModel jsViewModel = this.jsInterface;
        if (jsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        webView5.addJavascriptInterface(jsViewModel, "Android");
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView6.setWebChromeClient(new WebChromeClient() { // from class: com.ipotensic.baselib.base.WebActivity$initWebSettings$4
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                DDLog.m1683d("WebActivity", "onReceivedTitle---" + title);
                WebActivity.access$getTitleView$p(WebActivity.this).setTitle(title);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                DDLog.m1683d("WebActivity", "alert---" + url + message + String.valueOf(result));
                return super.onJsAlert(view, url, message, result);
            }

            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
                View view2;
                View view3;
                View view4;
                view2 = WebActivity.this.mCustomView;
                if (view2 != null) {
                    if (callback != null) {
                        callback.onCustomViewHidden();
                        return;
                    }
                    return;
                }
                WebActivity webActivity = WebActivity.this;
                if (view == null) {
                    Intrinsics.throwNpe();
                }
                webActivity.mCustomView = view;
                view3 = WebActivity.this.mCustomView;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                WebActivity webActivity2 = WebActivity.this;
                if (callback == null) {
                    Intrinsics.throwNpe();
                }
                webActivity2.mCustomViewCallback = callback;
                FrameLayout access$getFlVideo$p = WebActivity.access$getFlVideo$p(WebActivity.this);
                view4 = WebActivity.this.mCustomView;
                access$getFlVideo$p.addView(view4);
                WebActivity.access$getWebView$p(WebActivity.this).setVisibility(8);
                WebActivity.access$getFlVideo$p(WebActivity.this).setVisibility(0);
                WebActivity.access$getFlVideo$p(WebActivity.this).bringToFront();
                WebActivity.this.setRequestedOrientation(0);
                super.onShowCustomView(view, callback);
                DDLog.m1683d("WebActivity", "onShowCustomView---");
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                View view;
                View view2;
                WebChromeClient.CustomViewCallback customViewCallback;
                view = WebActivity.this.mCustomView;
                if (view != null) {
                    view.setVisibility(8);
                }
                FrameLayout access$getFlVideo$p = WebActivity.access$getFlVideo$p(WebActivity.this);
                view2 = WebActivity.this.mCustomView;
                access$getFlVideo$p.removeView(view2);
                WebActivity.this.mCustomView = (View) null;
                WebActivity.access$getWebView$p(WebActivity.this).setVisibility(0);
                WebActivity.access$getFlVideo$p(WebActivity.this).setVisibility(8);
                try {
                    customViewCallback = WebActivity.this.mCustomViewCallback;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                } catch (Exception unused) {
                }
                WebActivity.this.setRequestedOrientation(1);
                super.onHideCustomView();
                DDLog.m1683d("WebActivity", "onHideCustomView---");
            }
        });
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView7.setWebViewClient(new WebViewClient() { // from class: com.ipotensic.baselib.base.WebActivity$initWebSettings$5
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                DDLog.m1683d("WebActivity", "[shouldOverrideUrlLoading]" + url);
                if (url != null && (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null))) {
                    if (StringsKt.endsWith$default(url, ".pdf", false, 2, (Object) null)) {
                        if (WebActivity.this.getProgressBar().getVisibility() != 8) {
                            return true;
                        }
                        if (NetworkUtils.isNetConnected(WebActivity.this)) {
                            WebActivity.this.loadPdf(url);
                            return true;
                        }
                        WebActivity webActivity = WebActivity.this;
                        ToastUtil.toast(webActivity, webActivity.getString(C1819R.string.toast_no_network));
                        return true;
                    }
                    if (!NetworkUtils.isNetConnected(WebActivity.this)) {
                        WebActivity webActivity2 = WebActivity.this;
                        ToastUtil.toast(webActivity2, webActivity2.getString(C1819R.string.toast_no_network));
                        return true;
                    }
                    if (view == null) {
                        return true;
                    }
                    view.loadUrl(url);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                DDLog.m1683d("WebActivity", "[onPageStarted]" + url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                DDLog.m1683d("WebActivity", "[onPageFinished]" + url);
                WebActivity.this.jsMethodWithCallback(JsViewModel.GET_TITLE);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                DDLog.m1685e("WebActivity", "[onReceivedError]" + String.valueOf(error));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                DDLog.m1685e("WebActivity", "[onReceivedSslError]" + String.valueOf(error));
            }
        });
    }

    private final void initObserver() {
        JsViewModel jsViewModel = this.jsInterface;
        if (jsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        jsViewModel.getTitleBeanData().observe(this, new Observer<TitleBean>() { // from class: com.ipotensic.baselib.base.WebActivity$initObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(TitleBean titleBean) {
                WebActivity webActivity = WebActivity.this;
                Integer isHome = titleBean != null ? titleBean.isHome() : null;
                webActivity.isHome = isHome != null && isHome.intValue() == 1;
                WebActivity.access$getTitleView$p(WebActivity.this).setTitle(titleBean);
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        DDLog.m1683d(TAG, "[onConfigurationChanged]" + newConfig.orientation);
        int i = newConfig.orientation;
        if (i == 1) {
            TitleView titleView = this.titleView;
            if (titleView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleView");
            }
            titleView.setVisibility(0);
            FrameLayout frameLayout = this.flVideo;
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("flVideo");
            }
            frameLayout.postDelayed(new Runnable() { // from class: com.ipotensic.baselib.base.WebActivity$onConfigurationChanged$2
                @Override // java.lang.Runnable
                public final void run() {
                    WebActivity.this.setStateBarShow(true);
                }
            }, 100L);
            return;
        }
        if (i != 2) {
            return;
        }
        TitleView titleView2 = this.titleView;
        if (titleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView2.setVisibility(8);
        FrameLayout frameLayout2 = this.flVideo;
        if (frameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flVideo");
        }
        frameLayout2.postDelayed(new Runnable() { // from class: com.ipotensic.baselib.base.WebActivity$onConfigurationChanged$1
            @Override // java.lang.Runnable
            public final void run() {
                WebActivity.this.setFullscreen();
            }
        }, 100L);
    }

    public void showLoading() {
        ImageView imageView = this.progressBar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        imageView.setVisibility(0);
        ImageView imageView2 = this.progressBar;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        imageView2.bringToFront();
    }

    public void hideLoading() {
        ImageView imageView = this.progressBar;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        imageView.setVisibility(8);
        ImageView imageView2 = this.progressBar;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        imageView2.clearAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jsMethod(String params) {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.loadUrl("javascript:phoneCallJsMethod('" + params + "')");
        DDLog.m1683d(TAG, "jsMethod---" + params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jsMethodWithCallback(final String function) {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.evaluateJavascript("javascript:phoneCallJsMethodWithCallback('" + function + "')", new ValueCallback<String>() { // from class: com.ipotensic.baselib.base.WebActivity$jsMethodWithCallback$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String it) {
                JsViewModel access$getJsInterface$p = WebActivity.access$getJsInterface$p(WebActivity.this);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                access$getJsInterface$p.parseTitle(it);
                DDLog.m1683d("WebActivity", "jsMethodWithCallback---" + function + ",callback=" + it);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        if (webView.canGoBack() && !this.isHome) {
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView2.goBack();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        hideLoading();
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        ViewParent parent = webView.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            viewGroup.removeView(webView2);
        }
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView3.stopLoading();
        WebView webView4 = this.webView;
        if (webView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        WebSettings settings = webView4.getSettings();
        Intrinsics.checkExpressionValueIsNotNull(settings, "webView.settings");
        settings.setJavaScriptEnabled(false);
        WebView webView5 = this.webView;
        if (webView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView5.clearHistory();
        WebView webView6 = this.webView;
        if (webView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView6.clearView();
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView7.removeAllViews();
        WebView webView8 = this.webView;
        if (webView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView8.destroy();
        super.onDestroy();
    }
}