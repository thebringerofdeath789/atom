package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting3Item1Binding implements ViewBinding {
    public final ImageView ivArrowOne;
    public final ImageView ivArrowTwo;
    public final ConstraintLayout layoutMiniRepair;
    public final ConstraintLayout layoutRemoterCalibration;
    public final LinearLayout layoutRemoterSetting;
    public final View line;
    public final View line1;
    private final LinearLayout rootView;
    public final TextView tvNoAccessRepairing;
    public final TextView tvRemoterCalibration;
    public final TextView tvRemoterCalibrationTips;
    public final TextView tvRepairingAircraft;

    private ViewLayoutSetting3Item1Binding(LinearLayout linearLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, View view, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.ivArrowOne = imageView;
        this.ivArrowTwo = imageView2;
        this.layoutMiniRepair = constraintLayout;
        this.layoutRemoterCalibration = constraintLayout2;
        this.layoutRemoterSetting = linearLayout2;
        this.line = view;
        this.line1 = view2;
        this.tvNoAccessRepairing = textView;
        this.tvRemoterCalibration = textView2;
        this.tvRemoterCalibrationTips = textView3;
        this.tvRepairingAircraft = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting3Item1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting3Item1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting3_item1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting3Item1Binding bind(View view) {
        View findViewById;
        int i = R.id.iv_arrow_one;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_arrow_two;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.layout_mini_repair;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                if (constraintLayout != null) {
                    i = R.id.layout_remoter_calibration;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout2 != null) {
                        LinearLayout linearLayout = (LinearLayout) view;
                        i = R.id.line;
                        View findViewById2 = view.findViewById(i);
                        if (findViewById2 != null && (findViewById = view.findViewById((i = R.id.line1))) != null) {
                            i = R.id.tv_no_access_repairing;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = R.id.tv_remoter_calibration;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = R.id.tv_remoter_calibration_tips;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = R.id.tv_repairing_aircraft;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            return new ViewLayoutSetting3Item1Binding(linearLayout, imageView, imageView2, constraintLayout, constraintLayout2, linearLayout, findViewById2, findViewById, textView, textView2, textView3, textView4);
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
