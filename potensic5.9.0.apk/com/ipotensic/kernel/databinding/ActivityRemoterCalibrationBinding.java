package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CalRockerView;

/* loaded from: classes2.dex */
public final class ActivityRemoterCalibrationBinding implements ViewBinding {
    public final Button btnStartCal;
    public final CalRockerView calRockerViewLeft;
    public final CalRockerView calRockerViewRight;
    public final ImageView imgIcon;
    public final ImageView imgLeftWheel;
    public final ImageView imgRightWheel;
    public final ImageView imgWheelSegment;
    public final ImageView ivClose;
    public final ConstraintLayout layoutCalStep1;
    public final ConstraintLayout layoutCalStep2;
    public final LinearLayout layoutWheel;
    private final RelativeLayout rootView;
    public final TextView tvRockerTips;
    public final TextView tvTitle;
    public final TextView tvTitle1;
    public final TextView tvWheelTips;

    private ActivityRemoterCalibrationBinding(RelativeLayout relativeLayout, Button button, CalRockerView calRockerView, CalRockerView calRockerView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.btnStartCal = button;
        this.calRockerViewLeft = calRockerView;
        this.calRockerViewRight = calRockerView2;
        this.imgIcon = imageView;
        this.imgLeftWheel = imageView2;
        this.imgRightWheel = imageView3;
        this.imgWheelSegment = imageView4;
        this.ivClose = imageView5;
        this.layoutCalStep1 = constraintLayout;
        this.layoutCalStep2 = constraintLayout2;
        this.layoutWheel = linearLayout;
        this.tvRockerTips = textView;
        this.tvTitle = textView2;
        this.tvTitle1 = textView3;
        this.tvWheelTips = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityRemoterCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityRemoterCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.activity_remoter_calibration, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityRemoterCalibrationBinding bind(View view) {
        int i = C1965R.id.btn_start_cal;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.cal_rocker_view_left;
            CalRockerView calRockerView = (CalRockerView) view.findViewById(i);
            if (calRockerView != null) {
                i = C1965R.id.cal_rocker_view_right;
                CalRockerView calRockerView2 = (CalRockerView) view.findViewById(i);
                if (calRockerView2 != null) {
                    i = C1965R.id.img_icon;
                    ImageView imageView = (ImageView) view.findViewById(i);
                    if (imageView != null) {
                        i = C1965R.id.img_left_wheel;
                        ImageView imageView2 = (ImageView) view.findViewById(i);
                        if (imageView2 != null) {
                            i = C1965R.id.img_right_wheel;
                            ImageView imageView3 = (ImageView) view.findViewById(i);
                            if (imageView3 != null) {
                                i = C1965R.id.img_wheel_segment;
                                ImageView imageView4 = (ImageView) view.findViewById(i);
                                if (imageView4 != null) {
                                    i = C1965R.id.iv_close;
                                    ImageView imageView5 = (ImageView) view.findViewById(i);
                                    if (imageView5 != null) {
                                        i = C1965R.id.layout_cal_step1;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
                                        if (constraintLayout != null) {
                                            i = C1965R.id.layout_cal_step2;
                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
                                            if (constraintLayout2 != null) {
                                                i = C1965R.id.layout_wheel;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                                if (linearLayout != null) {
                                                    i = C1965R.id.tv_rocker_tips;
                                                    TextView textView = (TextView) view.findViewById(i);
                                                    if (textView != null) {
                                                        i = C1965R.id.tv_title;
                                                        TextView textView2 = (TextView) view.findViewById(i);
                                                        if (textView2 != null) {
                                                            i = C1965R.id.tv_title1;
                                                            TextView textView3 = (TextView) view.findViewById(i);
                                                            if (textView3 != null) {
                                                                i = C1965R.id.tv_wheel_tips;
                                                                TextView textView4 = (TextView) view.findViewById(i);
                                                                if (textView4 != null) {
                                                                    return new ActivityRemoterCalibrationBinding((RelativeLayout) view, button, calRockerView, calRockerView2, imageView, imageView2, imageView3, imageView4, imageView5, constraintLayout, constraintLayout2, linearLayout, textView, textView2, textView3, textView4);
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