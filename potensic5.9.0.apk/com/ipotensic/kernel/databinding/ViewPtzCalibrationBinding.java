package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewPtzCalibrationBinding implements ViewBinding {
    public final ImageButton btnPtzPlus;
    public final ImageButton btnPtzSub;
    public final ImageView ivPtzBg;
    public final ConstraintLayout layoutPtzMicroCal;
    private final RelativeLayout rootView;
    public final TextView tvPtzValue;

    private ViewPtzCalibrationBinding(RelativeLayout relativeLayout, ImageButton imageButton, ImageButton imageButton2, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        this.rootView = relativeLayout;
        this.btnPtzPlus = imageButton;
        this.btnPtzSub = imageButton2;
        this.ivPtzBg = imageView;
        this.layoutPtzMicroCal = constraintLayout;
        this.tvPtzValue = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewPtzCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewPtzCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_ptz_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewPtzCalibrationBinding bind(View view) {
        int i = C1965R.id.btn_ptz_plus;
        ImageButton imageButton = (ImageButton) view.findViewById(i);
        if (imageButton != null) {
            i = C1965R.id.btn_ptz_sub;
            ImageButton imageButton2 = (ImageButton) view.findViewById(i);
            if (imageButton2 != null) {
                i = C1965R.id.iv_ptz_bg;
                ImageView imageView = (ImageView) view.findViewById(i);
                if (imageView != null) {
                    i = C1965R.id.layout_ptz_micro_cal;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout != null) {
                        i = C1965R.id.tv_ptz_value;
                        TextView textView = (TextView) view.findViewById(i);
                        if (textView != null) {
                            return new ViewPtzCalibrationBinding((RelativeLayout) view, imageButton, imageButton2, imageView, constraintLayout, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}