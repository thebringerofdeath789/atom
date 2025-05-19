package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final ImageView ivBackground;
    private final FrameLayout rootView;

    private ActivitySplashBinding(FrameLayout frameLayout, ImageView imageView) {
        this.rootView = frameLayout;
        this.ivBackground = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySplashBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_background);
        if (imageView != null) {
            return new ActivitySplashBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_background)));
    }
}
