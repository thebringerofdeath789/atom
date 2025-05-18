package com.ipotensic.potensicpro.activities;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.JsViewModel;
import com.ipotensic.baselib.utils.NetworkUtils;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.potensicpro.R;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\u0016"}, d2 = {"com/ipotensic/potensicpro/activities/MainAcademyController$initWebSettings$5", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR, "Landroid/webkit/WebResourceError;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "app__GooglePalyRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainAcademyController$initWebSettings$5 extends WebViewClient {
    MainAcademyController$initWebSettings$5() {
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        String str;
        str = MainAcademyController.this.TAG;
        DDLog.d(str, "[shouldOverrideUrlLoading]" + url);
        if (url != null && (StringsKt.startsWith$default(url, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://", false, 2, (Object) null))) {
            if (StringsKt.endsWith$default(url, ".pdf", false, 2, (Object) null)) {
                if (MainAcademyController.this.getProgressBar().getVisibility() != 8) {
                    return true;
                }
                if (NetworkUtils.isNetConnected(MainAcademyController.this.getActivity())) {
                    MainAcademyController.this.loadPdf(url);
                    return true;
                }
                ToastUtil.toast(MainAcademyController.this.getActivity(), MainAcademyController.this.getActivity().getString(R.string.toast_no_network));
                return true;
            }
            if (!NetworkUtils.isNetConnected(MainAcademyController.this.getActivity())) {
                ToastUtil.toast(MainAcademyController.this.getActivity(), MainAcademyController.this.getActivity().getString(R.string.toast_no_network));
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
        DDLog.d(str, "[onPageStarted]" + url);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        String str;
        super.onPageFinished(view, url);
        str = MainAcademyController.this.TAG;
        DDLog.d(str, "[onPageFinished]" + url + ' ');
        MainAcademyController.this.jsMethodWithCallback(JsViewModel.GET_TITLE);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError r4) {
        String str;
        super.onReceivedError(view, request, r4);
        str = MainAcademyController.this.TAG;
        DDLog.e(str, "[onReceivedError]" + String.valueOf(r4));
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError r4) {
        String str;
        super.onReceivedSslError(view, handler, r4);
        str = MainAcademyController.this.TAG;
        DDLog.e(str, "[onReceivedSslError]" + String.valueOf(r4));
    }
}