package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewGuideFormatOneBinding implements ViewBinding {
    public final ImageView ivCameraSet;
    public final ImageView ivGuideCycle;
    public final ImageView ivOuterCircle;
    public final ImageView ivRectGallery;
    private final ConstraintLayout rootView;
    public final ViewGuideFormatTwoBinding viewCameraSet;

    private ViewGuideFormatOneBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ViewGuideFormatTwoBinding viewGuideFormatTwoBinding) {
        this.rootView = constraintLayout;
        this.ivCameraSet = imageView;
        this.ivGuideCycle = imageView2;
        this.ivOuterCircle = imageView3;
        this.ivRectGallery = imageView4;
        this.viewCameraSet = viewGuideFormatTwoBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewGuideFormatOneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGuideFormatOneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_guide_format_one, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGuideFormatOneBinding bind(View view) {
        View findViewById;
        int i = R.id.iv_camera_set;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_guide_cycle;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_outer_circle;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_rect_gallery;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null && (findViewById = view.findViewById((i = R.id.view_camera_set))) != null) {
                        return new ViewGuideFormatOneBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, ViewGuideFormatTwoBinding.bind(findViewById));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}