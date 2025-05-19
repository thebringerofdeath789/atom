package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CircleBatteryView;

/* loaded from: classes2.dex */
public final class ViewLayoutTopControllerBinding implements ViewBinding {
    public final ImageView ivFollowMe;
    public final ImageView ivGimbalTips;
    public final ImageView ivGps;
    public final ImageView ivHaveDirectionMode;
    public final ImageView ivHd;
    public final ImageView ivHotSpot;
    public final ImageView ivLockUp;
    public final ImageView ivLogo;
    public final ImageView ivPointFlight;
    public final ImageView ivSignalHd;
    public final ImageView ivSpeedMode;
    public final ImageView ivUav;
    public final RelativeLayout layoutBattery;
    public final RelativeLayout layoutConnectState;
    public final RoundRelativeLayout layoutState;
    public final View line;
    public final LinearLayout llDistance;
    public final LinearLayout llSignal;
    private final ConstraintLayout rootView;
    public final TextView tvDeviceStatus;
    public final StrokeTextView tvGimbalTips;
    public final StrokeTextView tvGps;
    public final TextView tvLowPowerTips;
    public final ImageView tvNewSetting;
    public final StrokeTextView tvRemainFlightTime;
    public final StrokeTextView tvUavStatus;
    public final CircleBatteryView viewBatteryPercentage;

    private ViewLayoutTopControllerBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RoundRelativeLayout roundRelativeLayout, View view, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, StrokeTextView strokeTextView, StrokeTextView strokeTextView2, TextView textView2, ImageView imageView13, StrokeTextView strokeTextView3, StrokeTextView strokeTextView4, CircleBatteryView circleBatteryView) {
        this.rootView = constraintLayout;
        this.ivFollowMe = imageView;
        this.ivGimbalTips = imageView2;
        this.ivGps = imageView3;
        this.ivHaveDirectionMode = imageView4;
        this.ivHd = imageView5;
        this.ivHotSpot = imageView6;
        this.ivLockUp = imageView7;
        this.ivLogo = imageView8;
        this.ivPointFlight = imageView9;
        this.ivSignalHd = imageView10;
        this.ivSpeedMode = imageView11;
        this.ivUav = imageView12;
        this.layoutBattery = relativeLayout;
        this.layoutConnectState = relativeLayout2;
        this.layoutState = roundRelativeLayout;
        this.line = view;
        this.llDistance = linearLayout;
        this.llSignal = linearLayout2;
        this.tvDeviceStatus = textView;
        this.tvGimbalTips = strokeTextView;
        this.tvGps = strokeTextView2;
        this.tvLowPowerTips = textView2;
        this.tvNewSetting = imageView13;
        this.tvRemainFlightTime = strokeTextView3;
        this.tvUavStatus = strokeTextView4;
        this.viewBatteryPercentage = circleBatteryView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTopControllerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTopControllerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_top_controller, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTopControllerBinding bind(View view) {
        View findViewById;
        int i = R.id.iv_follow_me;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.iv_gimbal_tips;
            ImageView imageView2 = (ImageView) view.findViewById(i);
            if (imageView2 != null) {
                i = R.id.iv_gps;
                ImageView imageView3 = (ImageView) view.findViewById(i);
                if (imageView3 != null) {
                    i = R.id.iv_have_direction_mode;
                    ImageView imageView4 = (ImageView) view.findViewById(i);
                    if (imageView4 != null) {
                        i = R.id.iv_hd;
                        ImageView imageView5 = (ImageView) view.findViewById(i);
                        if (imageView5 != null) {
                            i = R.id.iv_hot_spot;
                            ImageView imageView6 = (ImageView) view.findViewById(i);
                            if (imageView6 != null) {
                                i = R.id.iv_lock_up;
                                ImageView imageView7 = (ImageView) view.findViewById(i);
                                if (imageView7 != null) {
                                    i = R.id.iv_logo;
                                    ImageView imageView8 = (ImageView) view.findViewById(i);
                                    if (imageView8 != null) {
                                        i = R.id.iv_point_flight;
                                        ImageView imageView9 = (ImageView) view.findViewById(i);
                                        if (imageView9 != null) {
                                            i = R.id.iv_signal_hd;
                                            ImageView imageView10 = (ImageView) view.findViewById(i);
                                            if (imageView10 != null) {
                                                i = R.id.iv_speed_mode;
                                                ImageView imageView11 = (ImageView) view.findViewById(i);
                                                if (imageView11 != null) {
                                                    i = R.id.iv_uav;
                                                    ImageView imageView12 = (ImageView) view.findViewById(i);
                                                    if (imageView12 != null) {
                                                        i = R.id.layout_battery;
                                                        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
                                                        if (relativeLayout != null) {
                                                            i = R.id.layout_connect_state;
                                                            RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(i);
                                                            if (relativeLayout2 != null) {
                                                                i = R.id.layout_state;
                                                                RoundRelativeLayout roundRelativeLayout = (RoundRelativeLayout) view.findViewById(i);
                                                                if (roundRelativeLayout != null && (findViewById = view.findViewById((i = R.id.line))) != null) {
                                                                    i = R.id.ll_distance;
                                                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                                                    if (linearLayout != null) {
                                                                        i = R.id.ll_signal;
                                                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                                                        if (linearLayout2 != null) {
                                                                            i = R.id.tv_device_status;
                                                                            TextView textView = (TextView) view.findViewById(i);
                                                                            if (textView != null) {
                                                                                i = R.id.tv_gimbal_tips;
                                                                                StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(i);
                                                                                if (strokeTextView != null) {
                                                                                    i = R.id.tv_gps;
                                                                                    StrokeTextView strokeTextView2 = (StrokeTextView) view.findViewById(i);
                                                                                    if (strokeTextView2 != null) {
                                                                                        i = R.id.tv_low_power_tips;
                                                                                        TextView textView2 = (TextView) view.findViewById(i);
                                                                                        if (textView2 != null) {
                                                                                            i = R.id.tv_new_setting;
                                                                                            ImageView imageView13 = (ImageView) view.findViewById(i);
                                                                                            if (imageView13 != null) {
                                                                                                i = R.id.tv_remain_flight_time;
                                                                                                StrokeTextView strokeTextView3 = (StrokeTextView) view.findViewById(i);
                                                                                                if (strokeTextView3 != null) {
                                                                                                    i = R.id.tv_uav_status;
                                                                                                    StrokeTextView strokeTextView4 = (StrokeTextView) view.findViewById(i);
                                                                                                    if (strokeTextView4 != null) {
                                                                                                        i = R.id.view_battery_percentage;
                                                                                                        CircleBatteryView circleBatteryView = (CircleBatteryView) view.findViewById(i);
                                                                                                        if (circleBatteryView != null) {
                                                                                                            return new ViewLayoutTopControllerBinding((ConstraintLayout) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12, relativeLayout, relativeLayout2, roundRelativeLayout, findViewById, linearLayout, linearLayout2, textView, strokeTextView, strokeTextView2, textView2, imageView13, strokeTextView3, strokeTextView4, circleBatteryView);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
