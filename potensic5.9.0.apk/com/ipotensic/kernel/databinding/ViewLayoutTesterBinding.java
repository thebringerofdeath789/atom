package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutTesterBinding implements ViewBinding {
    public final Button btnAttiTakeoff;
    public final Button btnFlowModeOpen;
    public final Button btnGpsModeOpen;
    public final Button btnNoConditionUnlock;
    public final Button btnPtzCalibration;
    public final TextView cameraCtrlState;
    public final TextView dbmState;
    public final TextView flightCtrlRevNum;
    public final TextView flightCtrlState;
    public final TextView fpvState;
    public final TextView horizontalAccuracy;
    public final TextView imuTemperature;
    public final LinearLayout layoutTest;
    public final ConstraintLayout layoutTestMain;
    public final LinearLayout llVoltage;
    public final TextView mcuState;
    public final TextView positionAccuracy;
    public final TextView remoteRevNum;
    private final ConstraintLayout rootView;
    public final ScrollView scrollViewGimbal;
    public final TextView speedAccuracy;
    public final TextView speedVertical;
    public final TextView tofHeight;
    public final TextView tofPrecision;
    public final TextView tofTemperature;
    public final TextView tvAngle;
    public final TextView tvBeidou;
    public final TextView tvChannel;
    public final TextView tvCompass;
    public final TextView tvFrameRate;
    public final TextView tvGeoLevel;
    public final TextView tvPitch;
    public final TextView tvReturnAltitude;
    public final TextView tvRoll;
    public final TextView tvSixCalibration;
    public final TextView tvStartSave;
    public final TextView tvStopSave;
    public final TextView tvVoltage1;
    public final TextView tvVoltage2;
    public final TextView tvVoltage3;
    public final TextView tvVoltage4;
    public final TextView tvWifiSignalValue;
    public final TextView tvWindDirection;
    public final TextView tvWindSpeed;
    public final TextView verticalAccuracy;
    public final TextView wifiSignal;

    private ViewLayoutTesterBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, Button button4, Button button5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, TextView textView8, TextView textView9, TextView textView10, ScrollView scrollView, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36) {
        this.rootView = constraintLayout;
        this.btnAttiTakeoff = button;
        this.btnFlowModeOpen = button2;
        this.btnGpsModeOpen = button3;
        this.btnNoConditionUnlock = button4;
        this.btnPtzCalibration = button5;
        this.cameraCtrlState = textView;
        this.dbmState = textView2;
        this.flightCtrlRevNum = textView3;
        this.flightCtrlState = textView4;
        this.fpvState = textView5;
        this.horizontalAccuracy = textView6;
        this.imuTemperature = textView7;
        this.layoutTest = linearLayout;
        this.layoutTestMain = constraintLayout2;
        this.llVoltage = linearLayout2;
        this.mcuState = textView8;
        this.positionAccuracy = textView9;
        this.remoteRevNum = textView10;
        this.scrollViewGimbal = scrollView;
        this.speedAccuracy = textView11;
        this.speedVertical = textView12;
        this.tofHeight = textView13;
        this.tofPrecision = textView14;
        this.tofTemperature = textView15;
        this.tvAngle = textView16;
        this.tvBeidou = textView17;
        this.tvChannel = textView18;
        this.tvCompass = textView19;
        this.tvFrameRate = textView20;
        this.tvGeoLevel = textView21;
        this.tvPitch = textView22;
        this.tvReturnAltitude = textView23;
        this.tvRoll = textView24;
        this.tvSixCalibration = textView25;
        this.tvStartSave = textView26;
        this.tvStopSave = textView27;
        this.tvVoltage1 = textView28;
        this.tvVoltage2 = textView29;
        this.tvVoltage3 = textView30;
        this.tvVoltage4 = textView31;
        this.tvWifiSignalValue = textView32;
        this.tvWindDirection = textView33;
        this.tvWindSpeed = textView34;
        this.verticalAccuracy = textView35;
        this.wifiSignal = textView36;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTesterBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTesterBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_tester, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTesterBinding bind(View view) {
        int i = C1965R.id.btn_atti_takeoff;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.btn_flow_mode_open;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = C1965R.id.btn_gps_mode_open;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    i = C1965R.id.btn_no_condition_unlock;
                    Button button4 = (Button) view.findViewById(i);
                    if (button4 != null) {
                        i = C1965R.id.btn_ptz_calibration;
                        Button button5 = (Button) view.findViewById(i);
                        if (button5 != null) {
                            i = C1965R.id.camera_ctrl_state;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = C1965R.id.dbm_state;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = C1965R.id.flight_ctrl_rev_num;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = C1965R.id.flight_ctrl_state;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = C1965R.id.fpv_state;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = C1965R.id.horizontal_accuracy;
                                                TextView textView6 = (TextView) view.findViewById(i);
                                                if (textView6 != null) {
                                                    i = C1965R.id.imu_temperature;
                                                    TextView textView7 = (TextView) view.findViewById(i);
                                                    if (textView7 != null) {
                                                        i = C1965R.id.layout_test;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                                        if (linearLayout != null) {
                                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                            i = C1965R.id.ll_voltage;
                                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                                            if (linearLayout2 != null) {
                                                                i = C1965R.id.mcu_state;
                                                                TextView textView8 = (TextView) view.findViewById(i);
                                                                if (textView8 != null) {
                                                                    i = C1965R.id.position_accuracy;
                                                                    TextView textView9 = (TextView) view.findViewById(i);
                                                                    if (textView9 != null) {
                                                                        i = C1965R.id.remote_rev_num;
                                                                        TextView textView10 = (TextView) view.findViewById(i);
                                                                        if (textView10 != null) {
                                                                            i = C1965R.id.scroll_view_gimbal;
                                                                            ScrollView scrollView = (ScrollView) view.findViewById(i);
                                                                            if (scrollView != null) {
                                                                                i = C1965R.id.speed_accuracy;
                                                                                TextView textView11 = (TextView) view.findViewById(i);
                                                                                if (textView11 != null) {
                                                                                    i = C1965R.id.speed_vertical;
                                                                                    TextView textView12 = (TextView) view.findViewById(i);
                                                                                    if (textView12 != null) {
                                                                                        i = C1965R.id.tof_height;
                                                                                        TextView textView13 = (TextView) view.findViewById(i);
                                                                                        if (textView13 != null) {
                                                                                            i = C1965R.id.tof_precision;
                                                                                            TextView textView14 = (TextView) view.findViewById(i);
                                                                                            if (textView14 != null) {
                                                                                                i = C1965R.id.tof_temperature;
                                                                                                TextView textView15 = (TextView) view.findViewById(i);
                                                                                                if (textView15 != null) {
                                                                                                    i = C1965R.id.tv_angle;
                                                                                                    TextView textView16 = (TextView) view.findViewById(i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = C1965R.id.tv_beidou;
                                                                                                        TextView textView17 = (TextView) view.findViewById(i);
                                                                                                        if (textView17 != null) {
                                                                                                            i = C1965R.id.tv_channel;
                                                                                                            TextView textView18 = (TextView) view.findViewById(i);
                                                                                                            if (textView18 != null) {
                                                                                                                i = C1965R.id.tv_compass;
                                                                                                                TextView textView19 = (TextView) view.findViewById(i);
                                                                                                                if (textView19 != null) {
                                                                                                                    i = C1965R.id.tv_frame_rate;
                                                                                                                    TextView textView20 = (TextView) view.findViewById(i);
                                                                                                                    if (textView20 != null) {
                                                                                                                        i = C1965R.id.tv_geo_level;
                                                                                                                        TextView textView21 = (TextView) view.findViewById(i);
                                                                                                                        if (textView21 != null) {
                                                                                                                            i = C1965R.id.tv_pitch;
                                                                                                                            TextView textView22 = (TextView) view.findViewById(i);
                                                                                                                            if (textView22 != null) {
                                                                                                                                i = C1965R.id.tv_return_altitude;
                                                                                                                                TextView textView23 = (TextView) view.findViewById(i);
                                                                                                                                if (textView23 != null) {
                                                                                                                                    i = C1965R.id.tv_roll;
                                                                                                                                    TextView textView24 = (TextView) view.findViewById(i);
                                                                                                                                    if (textView24 != null) {
                                                                                                                                        i = C1965R.id.tv_six_calibration;
                                                                                                                                        TextView textView25 = (TextView) view.findViewById(i);
                                                                                                                                        if (textView25 != null) {
                                                                                                                                            i = C1965R.id.tv_start_save;
                                                                                                                                            TextView textView26 = (TextView) view.findViewById(i);
                                                                                                                                            if (textView26 != null) {
                                                                                                                                                i = C1965R.id.tv_stop_save;
                                                                                                                                                TextView textView27 = (TextView) view.findViewById(i);
                                                                                                                                                if (textView27 != null) {
                                                                                                                                                    i = C1965R.id.tv_voltage_1;
                                                                                                                                                    TextView textView28 = (TextView) view.findViewById(i);
                                                                                                                                                    if (textView28 != null) {
                                                                                                                                                        i = C1965R.id.tv_voltage_2;
                                                                                                                                                        TextView textView29 = (TextView) view.findViewById(i);
                                                                                                                                                        if (textView29 != null) {
                                                                                                                                                            i = C1965R.id.tv_voltage_3;
                                                                                                                                                            TextView textView30 = (TextView) view.findViewById(i);
                                                                                                                                                            if (textView30 != null) {
                                                                                                                                                                i = C1965R.id.tv_voltage_4;
                                                                                                                                                                TextView textView31 = (TextView) view.findViewById(i);
                                                                                                                                                                if (textView31 != null) {
                                                                                                                                                                    i = C1965R.id.tv_wifi_signal_value;
                                                                                                                                                                    TextView textView32 = (TextView) view.findViewById(i);
                                                                                                                                                                    if (textView32 != null) {
                                                                                                                                                                        i = C1965R.id.tv_wind_direction;
                                                                                                                                                                        TextView textView33 = (TextView) view.findViewById(i);
                                                                                                                                                                        if (textView33 != null) {
                                                                                                                                                                            i = C1965R.id.tv_wind_speed;
                                                                                                                                                                            TextView textView34 = (TextView) view.findViewById(i);
                                                                                                                                                                            if (textView34 != null) {
                                                                                                                                                                                i = C1965R.id.vertical_accuracy;
                                                                                                                                                                                TextView textView35 = (TextView) view.findViewById(i);
                                                                                                                                                                                if (textView35 != null) {
                                                                                                                                                                                    i = C1965R.id.wifi_signal;
                                                                                                                                                                                    TextView textView36 = (TextView) view.findViewById(i);
                                                                                                                                                                                    if (textView36 != null) {
                                                                                                                                                                                        return new ViewLayoutTesterBinding(constraintLayout, button, button2, button3, button4, button5, textView, textView2, textView3, textView4, textView5, textView6, textView7, linearLayout, constraintLayout, linearLayout2, textView8, textView9, textView10, scrollView, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, textView34, textView35, textView36);
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