package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewGuideFormatTwoBinding implements ViewBinding {
    public final ConstraintLayout cl1;
    public final ConstraintLayout cl2;
    public final ConstraintLayout cl3;
    public final ConstraintLayout cl4;
    public final ConstraintLayout cl5;
    public final ConstraintLayout clFormatSd;
    public final ScrollView guideScrollView;
    public final ImageView ivGuideCycle2;
    public final ImageView ivRectFormat;
    public final ImageView ivSet;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;
    public final View line5;
    public final View line6;
    public final ConstraintLayout llCameraSet;
    private final ConstraintLayout rootView;
    public final SwitchButton slideBtn;
    public final TextView tvCodeTitle;
    public final ImageView tvSd;
    public final TextView tvSdFormat;
    public final View viewBg;

    private ViewGuideFormatTwoBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ScrollView scrollView, ImageView imageView, ImageView imageView2, ImageView imageView3, View view, View view2, View view3, View view4, View view5, View view6, ConstraintLayout constraintLayout8, SwitchButton switchButton, TextView textView, ImageView imageView4, TextView textView2, View view7) {
        this.rootView = constraintLayout;
        this.cl1 = constraintLayout2;
        this.cl2 = constraintLayout3;
        this.cl3 = constraintLayout4;
        this.cl4 = constraintLayout5;
        this.cl5 = constraintLayout6;
        this.clFormatSd = constraintLayout7;
        this.guideScrollView = scrollView;
        this.ivGuideCycle2 = imageView;
        this.ivRectFormat = imageView2;
        this.ivSet = imageView3;
        this.line1 = view;
        this.line2 = view2;
        this.line3 = view3;
        this.line4 = view4;
        this.line5 = view5;
        this.line6 = view6;
        this.llCameraSet = constraintLayout8;
        this.slideBtn = switchButton;
        this.tvCodeTitle = textView;
        this.tvSd = imageView4;
        this.tvSdFormat = textView2;
        this.viewBg = view7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewGuideFormatTwoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewGuideFormatTwoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_guide_format_two, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewGuideFormatTwoBinding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        View findViewById5;
        View findViewById6;
        View findViewById7;
        int i = R.id.cl_1;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
        if (constraintLayout != null) {
            i = R.id.cl_2;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout2 != null) {
                i = R.id.cl_3;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(i);
                if (constraintLayout3 != null) {
                    i = R.id.cl_4;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout4 != null) {
                        i = R.id.cl_5;
                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(i);
                        if (constraintLayout5 != null) {
                            i = R.id.cl_format_sd;
                            ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(i);
                            if (constraintLayout6 != null) {
                                i = R.id.guide_scrollView;
                                ScrollView scrollView = (ScrollView) view.findViewById(i);
                                if (scrollView != null) {
                                    i = R.id.iv_guide_cycle_2;
                                    ImageView imageView = (ImageView) view.findViewById(i);
                                    if (imageView != null) {
                                        i = R.id.iv_rect_format;
                                        ImageView imageView2 = (ImageView) view.findViewById(i);
                                        if (imageView2 != null) {
                                            i = R.id.iv_set;
                                            ImageView imageView3 = (ImageView) view.findViewById(i);
                                            if (imageView3 != null && (findViewById = view.findViewById((i = R.id.line1))) != null && (findViewById2 = view.findViewById((i = R.id.line2))) != null && (findViewById3 = view.findViewById((i = R.id.line3))) != null && (findViewById4 = view.findViewById((i = R.id.line4))) != null && (findViewById5 = view.findViewById((i = R.id.line5))) != null && (findViewById6 = view.findViewById((i = R.id.line6))) != null) {
                                                i = R.id.ll_camera_set;
                                                ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(i);
                                                if (constraintLayout7 != null) {
                                                    i = R.id.slideBtn;
                                                    SwitchButton switchButton = (SwitchButton) view.findViewById(i);
                                                    if (switchButton != null) {
                                                        i = R.id.tv_code_title;
                                                        TextView textView = (TextView) view.findViewById(i);
                                                        if (textView != null) {
                                                            i = R.id.tv_sd;
                                                            ImageView imageView4 = (ImageView) view.findViewById(i);
                                                            if (imageView4 != null) {
                                                                i = R.id.tv_sd_format;
                                                                TextView textView2 = (TextView) view.findViewById(i);
                                                                if (textView2 != null && (findViewById7 = view.findViewById((i = R.id.view_bg))) != null) {
                                                                    return new ViewGuideFormatTwoBinding((ConstraintLayout) view, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, scrollView, imageView, imageView2, imageView3, findViewById, findViewById2, findViewById3, findViewById4, findViewById5, findViewById6, constraintLayout7, switchButton, textView, imageView4, textView2, findViewById7);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}