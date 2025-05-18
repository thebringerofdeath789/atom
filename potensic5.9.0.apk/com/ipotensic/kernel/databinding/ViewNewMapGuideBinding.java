package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewNewMapGuideBinding implements ViewBinding {
    public final Button btnConfirm;
    public final ImageView ivGuideDrone;
    public final ImageView ivGuideHome;
    public final ImageView ivGuideLine1;
    public final ImageView ivGuideLine2;
    public final ImageView ivGuideLine3;
    public final ImageView ivGuideRemote;
    private final ShadowLayout rootView;
    public final StrokeTextView tvGuideDrone;
    public final StrokeTextView tvGuideHome;
    public final StrokeTextView tvGuideRemote;

    private ViewNewMapGuideBinding(ShadowLayout shadowLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, StrokeTextView strokeTextView3) {
        this.rootView = shadowLayout;
        this.btnConfirm = button;
        this.ivGuideDrone = imageView;
        this.ivGuideHome = imageView2;
        this.ivGuideLine1 = imageView3;
        this.ivGuideLine2 = imageView4;
        this.ivGuideLine3 = imageView5;
        this.ivGuideRemote = imageView6;
        this.tvGuideDrone = strokeTextView;
        this.tvGuideHome = strokeTextView2;
        this.tvGuideRemote = strokeTextView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static ViewNewMapGuideBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewNewMapGuideBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_new_map_guide, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewNewMapGuideBinding bind(View view) {
        int i = C1965R.id.btn_confirm;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.iv_guide_drone;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1965R.id.iv_guide_home;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C1965R.id.iv_guide_line1;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = C1965R.id.iv_guide_line2;
                        ImageView imageView4 = (ImageView) view.findViewById(i);
                        if (imageView4 != null) {
                            i = C1965R.id.iv_guide_line3;
                            ImageView imageView5 = (ImageView) view.findViewById(i);
                            if (imageView5 != null) {
                                i = C1965R.id.iv_guide_remote;
                                ImageView imageView6 = (ImageView) view.findViewById(i);
                                if (imageView6 != null) {
                                    i = C1965R.id.tv_guide_drone;
                                    StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(i);
                                    if (strokeTextView != null) {
                                        i = C1965R.id.tv_guide_home;
                                        StrokeTextView strokeTextView2 = (StrokeTextView) view.findViewById(i);
                                        if (strokeTextView2 != null) {
                                            i = C1965R.id.tv_guide_remote;
                                            StrokeTextView strokeTextView3 = (StrokeTextView) view.findViewById(i);
                                            if (strokeTextView3 != null) {
                                                return new ViewNewMapGuideBinding((ShadowLayout) view, button, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, strokeTextView, strokeTextView2, strokeTextView3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}