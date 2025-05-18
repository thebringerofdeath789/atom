package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting2Binding implements ViewBinding {
    public final ImageView imgGeoHorizontal;
    public final ImageView imgGeoVertical;
    public final ImageView imgHexahedralBg;
    public final ImageView imgMiniGeoHorizontal;
    public final ImageView imgMiniGeoVertical;
    public final ImageView ivBack;
    public final ImageView ivMiniGeoStepTips;
    private final ConstraintLayout rootView;
    public final TextView tvGeomagneticTitle;
    public final TextView tvHexahedralTitle;
    public final TextView tvMiniGeoStepTips;
    public final TextView tvMiniGeoTip;
    public final TextView tvMiniStartGeoBtn;
    public final TextView tvMiniTitle;
    public final TextView tvP5CalibrationTips;
    public final TextView tvSetting;
    public final TextView tvStartGeoBtn;
    public final TextView tvStartHexahedralBtn;
    public final ConstraintLayout viewMiniProductGeo;
    public final ConstraintLayout viewOldProductGeo;

    private ViewLayoutSetting2Binding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.imgGeoHorizontal = imageView;
        this.imgGeoVertical = imageView2;
        this.imgHexahedralBg = imageView3;
        this.imgMiniGeoHorizontal = imageView4;
        this.imgMiniGeoVertical = imageView5;
        this.ivBack = imageView6;
        this.ivMiniGeoStepTips = imageView7;
        this.tvGeomagneticTitle = textView;
        this.tvHexahedralTitle = textView2;
        this.tvMiniGeoStepTips = textView3;
        this.tvMiniGeoTip = textView4;
        this.tvMiniStartGeoBtn = textView5;
        this.tvMiniTitle = textView6;
        this.tvP5CalibrationTips = textView7;
        this.tvSetting = textView8;
        this.tvStartGeoBtn = textView9;
        this.tvStartHexahedralBtn = textView10;
        this.viewMiniProductGeo = constraintLayout2;
        this.viewOldProductGeo = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting_2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting2Binding bind(View view) {
        int i = C1965R.id.img_geo_horizontal;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = C1965R.id.img_geo_vertical;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = C1965R.id.img_hexahedral_bg;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = C1965R.id.img_mini_geo_horizontal;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = C1965R.id.img_mini_geo_vertical;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = C1965R.id.iv_back;
                            ImageView imageView6 = (ImageView) view.findViewById(i);
                            if (imageView6 != null) {
                                i = C1965R.id.iv_mini_geo_step_tips;
                                ImageView imageView7 = (ImageView) view.findViewById(i);
                                if (imageView7 != null) {
                                    i = C1965R.id.tv_geomagnetic_title;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = C1965R.id.tv_hexahedral_title;
                                        TextView textView2 = (TextView) view.findViewById(i);
                                        if (textView2 != null) {
                                            i = C1965R.id.tv_mini_geo_step_tips;
                                            TextView textView3 = (TextView) view.findViewById(i);
                                            if (textView3 != null) {
                                                i = C1965R.id.tv_mini_geo_tip;
                                                TextView textView4 = (TextView) view.findViewById(i);
                                                if (textView4 != null) {
                                                    i = C1965R.id.tv_mini_start_geo_btn;
                                                    TextView textView5 = (TextView) view.findViewById(i);
                                                    if (textView5 != null) {
                                                        i = C1965R.id.tv_mini_title;
                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                        if (textView6 != null) {
                                                            i = C1965R.id.tv_p5_calibration_tips;
                                                            TextView textView7 = (TextView) view.findViewById(i);
                                                            if (textView7 != null) {
                                                                i = C1965R.id.tv_setting;
                                                                TextView textView8 = (TextView) view.findViewById(i);
                                                                if (textView8 != null) {
                                                                    i = C1965R.id.tv_start_geo_btn;
                                                                    TextView textView9 = (TextView) view.findViewById(i);
                                                                    if (textView9 != null) {
                                                                        i = C1965R.id.tv_start_hexahedral_btn;
                                                                        TextView textView10 = (TextView) view.findViewById(i);
                                                                        if (textView10 != null) {
                                                                            i = C1965R.id.view_mini_product_geo;
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                                                            if (constraintLayout != null) {
                                                                                i = C1965R.id.view_old_product_geo;
                                                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                                                                                if (constraintLayout2 != null) {
                                                                                    return new ViewLayoutSetting2Binding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, constraintLayout, constraintLayout2);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}