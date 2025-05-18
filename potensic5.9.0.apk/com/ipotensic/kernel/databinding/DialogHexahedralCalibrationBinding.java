package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class DialogHexahedralCalibrationBinding implements ViewBinding {
    public final ImageView ivBack;
    public final ImageView ivCalibrationBg;
    public final ImageView ivDown;
    public final ImageView ivLeft;
    public final ImageView ivLevel;
    public final ImageView ivRight;
    public final ImageView ivUp;
    public final LinearLayout llBottom;
    public final LinearLayout llStep;
    private final ShadowLayout rootView;
    public final TextView tvBack;
    public final TextView tvCalibrationTips;
    public final TextView tvCodeTitle;
    public final TextView tvDescribe;
    public final TextView tvDown;
    public final TextView tvLeft;
    public final TextView tvLevel;
    public final TextView tvRight;
    public final TextView tvUp;

    private DialogHexahedralCalibrationBinding(ShadowLayout shadowLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = shadowLayout;
        this.ivBack = imageView;
        this.ivCalibrationBg = imageView2;
        this.ivDown = imageView3;
        this.ivLeft = imageView4;
        this.ivLevel = imageView5;
        this.ivRight = imageView6;
        this.ivUp = imageView7;
        this.llBottom = linearLayout;
        this.llStep = linearLayout2;
        this.tvBack = textView;
        this.tvCalibrationTips = textView2;
        this.tvCodeTitle = textView3;
        this.tvDescribe = textView4;
        this.tvDown = textView5;
        this.tvLeft = textView6;
        this.tvLevel = textView7;
        this.tvRight = textView8;
        this.tvUp = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ShadowLayout getRoot() {
        return this.rootView;
    }

    public static DialogHexahedralCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogHexahedralCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.dialog_hexahedral_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogHexahedralCalibrationBinding bind(View view) {
        int i = C1965R.id.iv_back;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.iv_calibration_bg;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.iv_down;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = C1965R.id.iv_left;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = C1965R.id.iv_level;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = C1965R.id.iv_right;
                            ImageView imageView6 = (ImageView) view.findViewById(i);
                            if (imageView6 != null) {
                                i = C1965R.id.iv_up;
                                ImageView imageView7 = (ImageView) view.findViewById(i);
                                if (imageView7 != null) {
                                    i = C1965R.id.ll_bottom;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                    if (linearLayout != null) {
                                        i = C1965R.id.ll_step;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                        if (linearLayout2 != null) {
                                            i = C1965R.id.tv_back;
                                            TextView textView = (TextView) view.findViewById(i);
                                            if (textView != null) {
                                                i = C1965R.id.tv_calibration_tips;
                                                TextView textView2 = (TextView) view.findViewById(i);
                                                if (textView2 != null) {
                                                    i = C1965R.id.tv_code_title;
                                                    TextView textView3 = (TextView) view.findViewById(i);
                                                    if (textView3 != null) {
                                                        i = C1965R.id.tv_describe;
                                                        TextView textView4 = (TextView) view.findViewById(i);
                                                        if (textView4 != null) {
                                                            i = C1965R.id.tv_down;
                                                            TextView textView5 = (TextView) view.findViewById(i);
                                                            if (textView5 != null) {
                                                                i = C1965R.id.tv_left;
                                                                TextView textView6 = (TextView) view.findViewById(i);
                                                                if (textView6 != null) {
                                                                    i = C1965R.id.tv_level;
                                                                    TextView textView7 = (TextView) view.findViewById(i);
                                                                    if (textView7 != null) {
                                                                        i = C1965R.id.tv_right;
                                                                        TextView textView8 = (TextView) view.findViewById(i);
                                                                        if (textView8 != null) {
                                                                            i = C1965R.id.tv_up;
                                                                            TextView textView9 = (TextView) view.findViewById(i);
                                                                            if (textView9 != null) {
                                                                                return new DialogHexahedralCalibrationBinding((ShadowLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}