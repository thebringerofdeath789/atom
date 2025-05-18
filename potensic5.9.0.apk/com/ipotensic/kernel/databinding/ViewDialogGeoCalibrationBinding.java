package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogGeoCalibrationBinding implements ViewBinding {
    public final Button btnStart;
    public final ImageView imgGeoHorizontal;
    public final ImageView imgGeoVertical;
    public final ImageView ivCancel;
    public final RelativeLayout llHorizontal;
    public final RelativeLayout llVertical;
    private final LinearLayout rootView;
    public final ScrollView scrollView;
    public final TextView tvContentOne;
    public final TextView tvContentTwo;
    public final TextView tvGeoCalibration;
    public final TextView tvMiniGeoTips;
    public final TextView tvOne;
    public final TextView tvTwo;

    private ViewDialogGeoCalibrationBinding(LinearLayout linearLayout, Button button, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = linearLayout;
        this.btnStart = button;
        this.imgGeoHorizontal = imageView;
        this.imgGeoVertical = imageView2;
        this.ivCancel = imageView3;
        this.llHorizontal = relativeLayout;
        this.llVertical = relativeLayout2;
        this.scrollView = scrollView;
        this.tvContentOne = textView;
        this.tvContentTwo = textView2;
        this.tvGeoCalibration = textView3;
        this.tvMiniGeoTips = textView4;
        this.tvOne = textView5;
        this.tvTwo = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogGeoCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogGeoCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_geo_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogGeoCalibrationBinding bind(View view) {
        int i = C1965R.id.btn_start;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.img_geo_horizontal;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null) {
                i = C1965R.id.img_geo_vertical;
                ImageView imageView2 = (ImageView) view.findViewById(i);
                if (imageView2 != null) {
                    i = C1965R.id.iv_cancel;
                    ImageView imageView3 = (ImageView) view.findViewById(i);
                    if (imageView3 != null) {
                        i = C1965R.id.ll_horizontal;
                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                        if (relativeLayout != null) {
                            i = C1965R.id.ll_vertical;
                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                            if (relativeLayout2 != null) {
                                i = C1965R.id.scroll_view;
                                ScrollView scrollView = (ScrollView) view.findViewById(i);
                                if (scrollView != null) {
                                    i = C1965R.id.tv_content_one;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = C1965R.id.tv_content_two;
                                        TextView textView2 = (TextView) view.findViewById(i);
                                        if (textView2 != null) {
                                            i = C1965R.id.tv_geo_calibration;
                                            TextView textView3 = (TextView) view.findViewById(i);
                                            if (textView3 != null) {
                                                i = C1965R.id.tv_mini_geo_tips;
                                                TextView textView4 = (TextView) view.findViewById(i);
                                                if (textView4 != null) {
                                                    i = C1965R.id.tv_one;
                                                    TextView textView5 = (TextView) view.findViewById(i);
                                                    if (textView5 != null) {
                                                        i = C1965R.id.tv_two;
                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                        if (textView6 != null) {
                                                            return new ViewDialogGeoCalibrationBinding((LinearLayout) view, button, imageView, imageView2, imageView3, relativeLayout, relativeLayout2, scrollView, textView, textView2, textView3, textView4, textView5, textView6);
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