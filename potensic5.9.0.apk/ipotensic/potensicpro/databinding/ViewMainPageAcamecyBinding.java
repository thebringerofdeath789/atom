package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.TitleView;
import com.ipotensic.potensicpro.R;

/* loaded from: classes2.dex */
public final class ViewMainPageAcamecyBinding implements ViewBinding {
    public final FrameLayout flVideo;
    public final ImageView imgLoading;
    public final FrameLayout llContainer;
    private final FrameLayout rootView;
    public final TitleView titleView;

    private ViewMainPageAcamecyBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3, TitleView titleView) {
        this.rootView = frameLayout;
        this.flVideo = frameLayout2;
        this.imgLoading = imageView;
        this.llContainer = frameLayout3;
        this.titleView = titleView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ViewMainPageAcamecyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewMainPageAcamecyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_main_page_acamecy, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMainPageAcamecyBinding bind(View view) {
        int i = R.id.fl_video;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.fl_video);
        if (frameLayout != null) {
            i = R.id.img_loading;
            ImageView imageView = (ImageView) view.findViewById(R.id.img_loading);
            if (imageView != null) {
                FrameLayout frameLayout2 = (FrameLayout) view;
                i = R.id.title_view;
                TitleView titleView = (TitleView) view.findViewById(R.id.title_view);
                if (titleView != null) {
                    return new ViewMainPageAcamecyBinding(frameLayout2, frameLayout, imageView, frameLayout2, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}