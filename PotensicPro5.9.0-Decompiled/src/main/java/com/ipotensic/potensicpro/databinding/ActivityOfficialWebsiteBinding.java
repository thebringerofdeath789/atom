package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityOfficialWebsiteBinding implements ViewBinding {
    public final ImageView imgReturn;
    public final RelativeLayout layoutTop;
    public final ProgressBar progress;
    private final LinearLayout rootView;
    public final WebView webview;

    private ActivityOfficialWebsiteBinding(LinearLayout linearLayout, ImageView imageView, RelativeLayout relativeLayout, ProgressBar progressBar, WebView webView) {
        this.rootView = linearLayout;
        this.imgReturn = imageView;
        this.layoutTop = relativeLayout;
        this.progress = progressBar;
        this.webview = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityOfficialWebsiteBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityOfficialWebsiteBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_official_website, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityOfficialWebsiteBinding bind(View view) {
        int i = R.id.img_return;
        ImageView imageView = (ImageView) view.findViewById(R.id.img_return);
        if (imageView != null) {
            i = R.id.layout_top;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.layout_top);
            if (relativeLayout != null) {
                i = R.id.progress;
                ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
                if (progressBar != null) {
                    i = R.id.webview;
                    WebView webView = (WebView) view.findViewById(R.id.webview);
                    if (webView != null) {
                        return new ActivityOfficialWebsiteBinding((LinearLayout) view, imageView, relativeLayout, progressBar, webView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
