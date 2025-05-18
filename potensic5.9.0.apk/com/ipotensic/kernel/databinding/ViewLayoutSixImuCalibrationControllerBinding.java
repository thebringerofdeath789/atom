package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.FormView;

/* loaded from: classes2.dex */
public final class ViewLayoutSixImuCalibrationControllerBinding implements ViewBinding {
    public final AppCompatButton btnQuit;
    public final AppCompatButton btnStart;
    public final FormView form;
    public final ConstraintLayout layoutMain;
    public final LinearLayout layoutResult;
    public final LinearLayout layoutState;
    private final ConstraintLayout rootView;
    public final TextView tvBack;
    public final TextView tvBelow;
    public final TextView tvFront;
    public final TextView tvLeft;
    public final TextView tvRight;
    public final AppCompatTextView tvState;
    public final AppCompatTextView tvTips1;
    public final TextView tvUp;

    private ViewLayoutSixImuCalibrationControllerBinding(ConstraintLayout constraintLayout, AppCompatButton appCompatButton, AppCompatButton appCompatButton2, FormView formView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, TextView textView6) {
        this.rootView = constraintLayout;
        this.btnQuit = appCompatButton;
        this.btnStart = appCompatButton2;
        this.form = formView;
        this.layoutMain = constraintLayout2;
        this.layoutResult = linearLayout;
        this.layoutState = linearLayout2;
        this.tvBack = textView;
        this.tvBelow = textView2;
        this.tvFront = textView3;
        this.tvLeft = textView4;
        this.tvRight = textView5;
        this.tvState = appCompatTextView;
        this.tvTips1 = appCompatTextView2;
        this.tvUp = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSixImuCalibrationControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSixImuCalibrationControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_six_imu_calibration_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSixImuCalibrationControllerBinding bind(View view) {
        int i = C1965R.id.btn_quit;
        AppCompatButton appCompatButton = (AppCompatButton) view.findViewById(i);
        if (appCompatButton != null) {
            i = C1965R.id.btn_start;
            AppCompatButton appCompatButton2 = (AppCompatButton) view.findViewById(i);
            if (appCompatButton2 != null) {
                i = C1965R.id.form;
                FormView formView = (FormView) view.findViewById(i);
                if (formView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = C1965R.id.layout_result;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        i = C1965R.id.layout_state;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                        if (linearLayout2 != null) {
                            i = C1965R.id.tv_back;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C1965R.id.tv_below;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C1965R.id.tv_front;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = C1965R.id.tv_left;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = C1965R.id.tv_right;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = C1965R.id.tv_state;
                                                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(i);
                                                if (appCompatTextView != null) {
                                                    i = C1965R.id.tv_tips1;
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(i);
                                                    if (appCompatTextView2 != null) {
                                                        i = C1965R.id.tv_up;
                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                        if (textView6 != null) {
                                                            return new ViewLayoutSixImuCalibrationControllerBinding(constraintLayout, appCompatButton, appCompatButton2, formView, constraintLayout, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, appCompatTextView, appCompatTextView2, textView6);
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