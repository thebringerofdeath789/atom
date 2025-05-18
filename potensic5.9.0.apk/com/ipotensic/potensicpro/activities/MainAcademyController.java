package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.gson.Gson;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.base.JsViewModel;
import com.ipotensic.baselib.bean.CommonBean;
import com.ipotensic.baselib.bean.TitleBean;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.LanguageHelper;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.TitleView;
import com.ipotensic.baselib.views.badgeview.DisplayUtil;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.potensicpro.C2640R;
import java.io.File;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: MainAcademyController.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\bH\u0002J\b\u0010%\u001a\u00020\"H\u0016J\b\u0010&\u001a\u00020\"H\u0002J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010)\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0013H\u0003J\u0010\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\bH\u0002J\u0010\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\bH\u0002J\u0010\u0010.\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0006\u0010/\u001a\u00020\u000fJ\u000e\u00100\u001a\u00020\"2\u0006\u00101\u001a\u000202J\b\u00103\u001a\u00020\"H\u0016J\b\u00104\u001a\u00020\"H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000¨\u00065"}, m2338d2 = {"Lcom/ipotensic/potensicpro/activities/MainAcademyController;", "Lcom/ipotensic/kernel/controllers/BaseController;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "viewStub", "Landroid/view/ViewStub;", "(Landroidx/appcompat/app/AppCompatActivity;Landroid/view/ViewStub;)V", "TAG", "", "getActivity", "()Landroidx/appcompat/app/AppCompatActivity;", "fileName", "flVideo", "Landroid/widget/FrameLayout;", "isHome", "", "jsInterface", "Lcom/ipotensic/baselib/base/JsViewModel;", "mCustomView", "Landroid/view/View;", "mCustomViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "progressBar", "Landroid/widget/ImageView;", "getProgressBar", "()Landroid/widget/ImageView;", "setProgressBar", "(Landroid/widget/ImageView;)V", "titleView", "Lcom/ipotensic/baselib/views/TitleView;", "url", "webView", "Landroid/webkit/WebView;", "downloadPdf", "", "goPdfPage", "filePath", "hideLoading", "initObserver", "initView", "baseView", "initWebSettings", "jsMethod", "params", "jsMethodWithCallback", "function", "loadPdf", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroy", "showLoading", "app__GooglePalyRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainAcademyController extends BaseController {
    private final String TAG;
    private final AppCompatActivity activity;
    private String fileName;
    private FrameLayout flVideo;
    private boolean isHome;
    private JsViewModel jsInterface;
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    public ImageView progressBar;
    private TitleView titleView;
    private String url;
    private WebView webView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainAcademyController(AppCompatActivity activity, ViewStub viewStub) {
        super(activity, viewStub);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(viewStub, "viewStub");
        this.activity = activity;
        this.TAG = "MainAcademyController";
    }

    public static final /* synthetic */ FrameLayout access$getFlVideo$p(MainAcademyController mainAcademyController) {
        FrameLayout frameLayout = mainAcademyController.flVideo;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flVideo");
        }
        return frameLayout;
    }

    public static final /* synthetic */ JsViewModel access$getJsInterface$p(MainAcademyController mainAcademyController) {
        JsViewModel jsViewModel = mainAcademyController.jsInterface;
        if (jsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        return jsViewModel;
    }

    public static final /* synthetic */ TitleView access$getTitleView$p(MainAcademyController mainAcademyController) {
        TitleView titleView = mainAcademyController.titleView;
        if (titleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        return titleView;
    }

    public static final /* synthetic */ WebView access$getWebView$p(MainAcademyController mainAcademyController) {
        WebView webView = mainAcademyController.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        return webView;
    }

    public final AppCompatActivity getActivity() {
        return this.activity;
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

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View baseView) {
        ViewModel viewModel = new ViewModelProvider(this.activity).get(JsViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel, "ViewModelProvider(activi…(JsViewModel::class.java)");
        this.jsInterface = (JsViewModel) viewModel;
        this.url = "http://appserver.depstech.com/index.php/webapp/app/index?product=Atom&language=english&curLanguage=" + LanguageHelper.getLanguageType(getContext()) + "&clienttype=1";
        if (baseView == null) {
            Intrinsics.throwNpe();
        }
        initWebSettings(baseView);
        initObserver();
        String str = this.url;
        if (str != null) {
            if (NetworkUtils.isNetConnected(this.activity)) {
                WebView webView = this.webView;
                if (webView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("webView");
                }
                webView.loadUrl(str);
                return;
            }
            AppCompatActivity appCompatActivity = this.activity;
            ToastUtil.toast(appCompatActivity, appCompatActivity.getString(C2640R.string.toast_no_network));
        }
    }

    private final void initWebSettings(View baseView) {
        View findViewById = baseView.findViewById(C2640R.id.title_view);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "baseView.findViewById(R.id.title_view)");
        this.titleView = (TitleView) findViewById;
        View findViewById2 = baseView.findViewById(C2640R.id.img_loading);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "baseView.findViewById(R.id.img_loading)");
        this.progressBar = (ImageView) findViewById2;
        View findViewById3 = baseView.findViewById(C2640R.id.fl_video);
        Intrinsics.checkExpressionValueIsNotNull(findViewById3, "baseView.findViewById(R.id.fl_video)");
        this.flVideo = (FrameLayout) findViewById3;
        this.webView = new WebView(this.activity.getApplicationContext());
        FrameLayout frameLayout = (FrameLayout) baseView.findViewById(C2640R.id.ll_container);
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
        layoutParams2.topMargin = DisplayUtil.dp2px(this.activity, 88.0f);
        WebView webView3 = this.webView;
        if (webView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView3.setLayoutParams(layoutParams2);
        TitleView titleView = this.titleView;
        if (titleView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView.setTitle(this.activity.getString(C2640R.string.guide_homepage_academy_title));
        TitleView titleView2 = this.titleView;
        if (titleView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView2.setOnLeftClick(new Function0<Unit>() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$initWebSettings$1
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
                MainAcademyController.this.onBackPressed();
            }
        });
        TitleView titleView3 = this.titleView;
        if (titleView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleView");
        }
        titleView3.setOnRightClick(new Function1<String, Unit>() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$initWebSettings$2
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
                        MainAcademyController mainAcademyController = MainAcademyController.this;
                        String json = gson.toJson(commonBean);
                        Intrinsics.checkExpressionValueIsNotNull(json, "gson.toJson(bean)");
                        mainAcademyController.jsMethod(json);
                        return;
                    }
                    return;
                }
                if (hashCode == 3208415 && tag.equals(TitleBean.TAG_HOME)) {
                    CommonBean commonBean2 = new CommonBean(JsViewModel.GO_HOME, null);
                    MainAcademyController mainAcademyController2 = MainAcademyController.this;
                    String json2 = gson.toJson(commonBean2);
                    Intrinsics.checkExpressionValueIsNotNull(json2, "gson.toJson(bean)");
                    mainAcademyController2.jsMethod(json2);
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
        webView6.setWebChromeClient(new WebChromeClient() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$initWebSettings$4
            @Override // android.webkit.WebChromeClient
            public void onReceivedTitle(WebView view, String title) {
                String str;
                super.onReceivedTitle(view, title);
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "onReceivedTitle---" + title);
                MainAcademyController.access$getTitleView$p(MainAcademyController.this).setTitle(title);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                String str;
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "alert---" + url + message + String.valueOf(result));
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
                String str;
                view2 = MainAcademyController.this.mCustomView;
                if (view2 != null) {
                    if (callback != null) {
                        callback.onCustomViewHidden();
                        return;
                    }
                    return;
                }
                MainAcademyController mainAcademyController = MainAcademyController.this;
                if (view == null) {
                    Intrinsics.throwNpe();
                }
                mainAcademyController.mCustomView = view;
                view3 = MainAcademyController.this.mCustomView;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
                MainAcademyController mainAcademyController2 = MainAcademyController.this;
                if (callback == null) {
                    Intrinsics.throwNpe();
                }
                mainAcademyController2.mCustomViewCallback = callback;
                FrameLayout access$getFlVideo$p = MainAcademyController.access$getFlVideo$p(MainAcademyController.this);
                view4 = MainAcademyController.this.mCustomView;
                access$getFlVideo$p.addView(view4);
                MainAcademyController.access$getWebView$p(MainAcademyController.this).setVisibility(8);
                MainAcademyController.access$getFlVideo$p(MainAcademyController.this).setVisibility(0);
                MainAcademyController.access$getFlVideo$p(MainAcademyController.this).bringToFront();
                super.onShowCustomView(view, callback);
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "onShowCustomView---");
            }

            @Override // android.webkit.WebChromeClient
            public void onHideCustomView() {
                View view;
                View view2;
                String str;
                WebChromeClient.CustomViewCallback customViewCallback;
                view = MainAcademyController.this.mCustomView;
                if (view != null) {
                    view.setVisibility(8);
                }
                FrameLayout access$getFlVideo$p = MainAcademyController.access$getFlVideo$p(MainAcademyController.this);
                view2 = MainAcademyController.this.mCustomView;
                access$getFlVideo$p.removeView(view2);
                MainAcademyController.this.mCustomView = (View) null;
                MainAcademyController.access$getWebView$p(MainAcademyController.this).setVisibility(0);
                MainAcademyController.access$getFlVideo$p(MainAcademyController.this).setVisibility(8);
                try {
                    customViewCallback = MainAcademyController.this.mCustomViewCallback;
                    if (customViewCallback != null) {
                        customViewCallback.onCustomViewHidden();
                    }
                } catch (Exception unused) {
                }
                super.onHideCustomView();
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "onHideCustomView---");
            }
        });
        WebView webView7 = this.webView;
        if (webView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView7.setWebViewClient(new WebViewClient() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$initWebSettings$5
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                String str;
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "[shouldOverrideUrlLoading]" + url);
                if (url != null && (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null))) {
                    if (StringsKt.endsWith$default(url, ".pdf", false, 2, (Object) null)) {
                        if (MainAcademyController.this.getProgressBar().getVisibility() != 8) {
                            return true;
                        }
                        if (NetworkUtils.isNetConnected(MainAcademyController.this.getActivity())) {
                            MainAcademyController.this.loadPdf(url);
                            return true;
                        }
                        ToastUtil.toast(MainAcademyController.this.getActivity(), MainAcademyController.this.getActivity().getString(C2640R.string.toast_no_network));
                        return true;
                    }
                    if (!NetworkUtils.isNetConnected(MainAcademyController.this.getActivity())) {
                        ToastUtil.toast(MainAcademyController.this.getActivity(), MainAcademyController.this.getActivity().getString(C2640R.string.toast_no_network));
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
                String str;
                super.onPageStarted(view, url, favicon);
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "[onPageStarted]" + url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                String str;
                super.onPageFinished(view, url);
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "[onPageFinished]" + url + ' ');
                MainAcademyController.this.jsMethodWithCallback(JsViewModel.GET_TITLE);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                String str;
                super.onReceivedError(view, request, error);
                str = MainAcademyController.this.TAG;
                DDLog.m1685e(str, "[onReceivedError]" + String.valueOf(error));
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                String str;
                super.onReceivedSslError(view, handler, error);
                str = MainAcademyController.this.TAG;
                DDLog.m1685e(str, "[onReceivedSslError]" + String.valueOf(error));
            }
        });
    }

    private final void initObserver() {
        JsViewModel jsViewModel = this.jsInterface;
        if (jsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("jsInterface");
        }
        jsViewModel.getTitleBeanData().observe(this.activity, new Observer<TitleBean>() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$initObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(TitleBean titleBean) {
                boolean z;
                MainAcademyController mainAcademyController = MainAcademyController.this;
                Integer isHome = titleBean != null ? titleBean.isHome() : null;
                mainAcademyController.isHome = isHome != null && isHome.intValue() == 1;
                ImageView ivBack = MainAcademyController.access$getTitleView$p(MainAcademyController.this).getIvBack();
                z = MainAcademyController.this.isHome;
                ivBack.setVisibility(z ? 4 : 0);
                MainAcademyController.access$getTitleView$p(MainAcademyController.this).setTitle(titleBean);
            }
        });
    }

    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkParameterIsNotNull(newConfig, "newConfig");
        try {
            DDLog.m1683d(this.TAG, "[onConfigurationChanged]" + newConfig.orientation);
            int i = newConfig.orientation;
            if (i == 1) {
                TitleView titleView = this.titleView;
                if (titleView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("titleView");
                }
                titleView.setVisibility(0);
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
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadPdf(String url) {
        try {
            int lastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) url, InternalZipConstants.ZIP_FILE_SEPARATOR, 0, false, 6, (Object) null) + 1;
            if (url == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String substring = url.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
            this.fileName = substring;
            this.fileName = URLDecoder.decode(substring, "UTF-8");
            DDLog.m1683d(this.TAG, "fileName=" + this.fileName);
            StringBuilder sb = new StringBuilder();
            LocalFileManager localFileManager = LocalFileManager.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(localFileManager, "LocalFileManager.getInstance()");
            File file = new File(sb.append(localFileManager.getPDF_DIR()).append(File.separator).append(this.fileName).toString());
            if (file.exists()) {
                String absolutePath = file.getAbsolutePath();
                Intrinsics.checkExpressionValueIsNotNull(absolutePath, "file.absolutePath");
                goPdfPage(absolutePath);
                return;
            }
            downloadPdf(url);
        } catch (Exception e) {
            DDLog.m1685e(this.TAG, "Exception=" + e);
        }
    }

    private final void downloadPdf(String url) {
        showLoading();
        new Thread(new MainAcademyController$downloadPdf$1(this, url)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goPdfPage(String filePath) {
        Intent intent = new Intent(this.activity, (Class<?>) PdfShowActivity.class);
        intent.putExtra(PdfShowActivity.FILE_PATH, new File(filePath));
        this.activity.startActivity(intent);
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
        ImageView imageView3 = this.progressBar;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressBar");
        }
        AnimationUtil.selfRotate(imageView3);
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
        DDLog.m1683d(this.TAG, "jsMethod---" + params);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void jsMethodWithCallback(final String function) {
        WebView webView = this.webView;
        if (webView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("webView");
        }
        webView.evaluateJavascript("javascript:phoneCallJsMethodWithCallback('" + function + "')", new ValueCallback<String>() { // from class: com.ipotensic.potensicpro.activities.MainAcademyController$jsMethodWithCallback$1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(String it) {
                String str;
                JsViewModel access$getJsInterface$p = MainAcademyController.access$getJsInterface$p(MainAcademyController.this);
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                access$getJsInterface$p.parseTitle(it);
                str = MainAcademyController.this.TAG;
                DDLog.m1683d(str, "jsMethodWithCallback---" + function + ",callback=" + it);
            }
        });
    }

    public final boolean onBackPressed() {
        try {
            OkHttpUtil.getInstance().cancelDownload();
            hideLoading();
            WebView webView = this.webView;
            if (webView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            if (!webView.canGoBack() || this.isHome) {
                return false;
            }
            WebView webView2 = this.webView;
            if (webView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("webView");
            }
            webView2.goBack();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        try {
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
        } catch (Exception unused) {
        }
        super.onDestroy();
    }
}