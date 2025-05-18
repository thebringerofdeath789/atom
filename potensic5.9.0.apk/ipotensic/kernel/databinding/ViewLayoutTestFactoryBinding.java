package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutTestFactoryBinding implements ViewBinding {
    public final Button btnCamTemp;
    public final Button btnLossPkgClose;
    public final Button btnLossPkgOpen;
    public final ConstraintLayout layoutTestFactory;
    public final LinearLayout layoutTestP1Self;
    private final ConstraintLayout rootView;
    public final Button tvCameraTestMode;
    public final Button tvClearImuData;
    public final Button tvFlight24gTest;
    public final Button tvFlightAlwaysLightMode;
    public final Button tvFlightFixedMode;
    public final Button tvFlightFixedSpeedMode;
    public final Button tvFlightShiningMode;
    public final Button tvFlightSweepMode;
    public final Button tvFlightTestMode;
    public final Button tvFlightVariableMode;
    public final Button tvRestoreFactorySetting;

    private ViewLayoutTestFactoryBinding(ConstraintLayout constraintLayout, Button button, Button button2, Button button3, ConstraintLayout constraintLayout2, LinearLayout linearLayout, Button button4, Button button5, Button button6, Button button7, Button button8, Button button9, Button button10, Button button11, Button button12, Button button13, Button button14) {
        this.rootView = constraintLayout;
        this.btnCamTemp = button;
        this.btnLossPkgClose = button2;
        this.btnLossPkgOpen = button3;
        this.layoutTestFactory = constraintLayout2;
        this.layoutTestP1Self = linearLayout;
        this.tvCameraTestMode = button4;
        this.tvClearImuData = button5;
        this.tvFlight24gTest = button6;
        this.tvFlightAlwaysLightMode = button7;
        this.tvFlightFixedMode = button8;
        this.tvFlightFixedSpeedMode = button9;
        this.tvFlightShiningMode = button10;
        this.tvFlightSweepMode = button11;
        this.tvFlightTestMode = button12;
        this.tvFlightVariableMode = button13;
        this.tvRestoreFactorySetting = button14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutTestFactoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutTestFactoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_test_factory, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutTestFactoryBinding bind(View view) {
        int i = R.id.btn_cam_temp;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = R.id.btn_loss_pkg_close;
            Button button2 = (Button) view.findViewById(i);
            if (button2 != null) {
                i = R.id.btn_loss_pkg_open;
                Button button3 = (Button) view.findViewById(i);
                if (button3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.layout_test_p1_self;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        i = R.id.tv_camera_test_mode;
                        Button button4 = (Button) view.findViewById(i);
                        if (button4 != null) {
                            i = R.id.tv_clear_imu_data;
                            Button button5 = (Button) view.findViewById(i);
                            if (button5 != null) {
                                i = R.id.tv_flight_24g_test;
                                Button button6 = (Button) view.findViewById(i);
                                if (button6 != null) {
                                    i = R.id.tv_flight_always_light_mode;
                                    Button button7 = (Button) view.findViewById(i);
                                    if (button7 != null) {
                                        i = R.id.tv_flight_fixed_mode;
                                        Button button8 = (Button) view.findViewById(i);
                                        if (button8 != null) {
                                            i = R.id.tv_flight_fixed_speed_mode;
                                            Button button9 = (Button) view.findViewById(i);
                                            if (button9 != null) {
                                                i = R.id.tv_flight_shining_mode;
                                                Button button10 = (Button) view.findViewById(i);
                                                if (button10 != null) {
                                                    i = R.id.tv_flight_sweep_mode;
                                                    Button button11 = (Button) view.findViewById(i);
                                                    if (button11 != null) {
                                                        i = R.id.tv_flight_test_mode;
                                                        Button button12 = (Button) view.findViewById(i);
                                                        if (button12 != null) {
                                                            i = R.id.tv_flight_variable_mode;
                                                            Button button13 = (Button) view.findViewById(i);
                                                            if (button13 != null) {
                                                                i = R.id.tv_restore_factory_setting;
                                                                Button button14 = (Button) view.findViewById(i);
                                                                if (button14 != null) {
                                                                    return new ViewLayoutTestFactoryBinding(constraintLayout, button, button2, button3, constraintLayout, linearLayout, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13, button14);
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