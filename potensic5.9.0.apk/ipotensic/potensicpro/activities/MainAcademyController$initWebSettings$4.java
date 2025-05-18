package com.ipotensic.potensicpro.activities;

import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.ipotensic.baselib.DDLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.MessageBundle;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J0\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u0016"}, d2 = {"com/ipotensic/potensicpro/activities/MainAcademyController$initWebSettings$4", "Landroid/webkit/WebChromeClient;", "onHideCustomView", "", "onJsAlert", "", "view", "Landroid/webkit/WebView;", "url", "", "message", "result", "Landroid/webkit/JsResult;", "onProgressChanged", "newProgress", "", "onReceivedTitle", MessageBundle.TITLE_ENTRY, "onShowCustomView", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainAcademyController$initWebSettings$4 extends WebChromeClient {
    MainAcademyController$initWebSettings$4() {
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView view, String r4) {
        String str;
        super.onReceivedTitle(view, r4);
        str = MainAcademyController.this.TAG;
        DDLog.d(str, "onReceivedTitle---" + r4);
        MainAcademyController.access$getTitleView$p(MainAcademyController.this).setTitle(r4);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
        String str;
        str = MainAcademyController.this.TAG;
        DDLog.d(str, "alert---" + url + message + String.valueOf(result));
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
        DDLog.d(str, "onShowCustomView---");
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
        DDLog.d(str, "onHideCustomView---");
    }
}