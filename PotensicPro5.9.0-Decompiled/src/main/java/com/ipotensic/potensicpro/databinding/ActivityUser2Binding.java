package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivityUser2Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ViewToolbarBinding toolbar;
    public final WebView webView;

    private ActivityUser2Binding(ConstraintLayout constraintLayout, ViewToolbarBinding viewToolbarBinding, WebView webView) {
        this.rootView = constraintLayout;
        this.toolbar = viewToolbarBinding;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityUser2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityUser2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_user2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityUser2Binding bind(View view) {
        int i = R.id.toolbar;
        View findViewById = view.findViewById(R.id.toolbar);
        if (findViewById != null) {
            ViewToolbarBinding bind = ViewToolbarBinding.bind(findViewById);
            WebView webView = (WebView) view.findViewById(R.id.web_view);
            if (webView != null) {
                return new ActivityUser2Binding((ConstraintLayout) view, bind, webView);
            }
            i = R.id.web_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
