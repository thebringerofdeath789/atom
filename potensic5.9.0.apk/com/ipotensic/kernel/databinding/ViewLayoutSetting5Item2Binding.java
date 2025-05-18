package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting5Item2Binding implements ViewBinding {
    public final ConstraintLayout clBattery;
    public final ConstraintLayout clCam;
    public final ConstraintLayout clEsc;
    public final ConstraintLayout clFlight;
    public final ConstraintLayout clFpv;
    public final ConstraintLayout clPtz;
    public final ConstraintLayout clRemote;
    public final TextView ivRemote;
    public final LinearLayout layoutBatteryUpdate;
    public final LinearLayout layoutCameraUpdate;
    public final LinearLayout layoutFlightUpdate;
    public final LinearLayout layoutFpvUpdate;
    public final LinearLayout layoutPtzUpdate;
    public final LinearLayout layoutRemoteUpdate;
    private final ConstraintLayout rootView;
    public final TextView tvApp;
    public final TextView tvAppTips;
    public final TextView tvBattery;
    public final TextView tvBatteryTips;
    public final TextView tvBatteryUpdate;
    public final TextView tvCamTips;
    public final TextView tvCamUpdate;
    public final TextView tvCamera;
    public final TextView tvEsc;
    public final TextView tvEscTips;
    public final TextView tvFlight;
    public final TextView tvFlightTips;
    public final TextView tvFlightUpdate;
    public final TextView tvFpv;
    public final TextView tvFpvTips;
    public final TextView tvFpvUpdate;
    public final TextView tvPtz;
    public final TextView tvPtzTips;
    public final TextView tvPtzUpdate;
    public final TextView tvRemoteTips;
    public final TextView tvRemoteUpdate;

    private ViewLayoutSetting5Item2Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, TextView textView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22) {
        this.rootView = constraintLayout;
        this.clBattery = constraintLayout2;
        this.clCam = constraintLayout3;
        this.clEsc = constraintLayout4;
        this.clFlight = constraintLayout5;
        this.clFpv = constraintLayout6;
        this.clPtz = constraintLayout7;
        this.clRemote = constraintLayout8;
        this.ivRemote = textView;
        this.layoutBatteryUpdate = linearLayout;
        this.layoutCameraUpdate = linearLayout2;
        this.layoutFlightUpdate = linearLayout3;
        this.layoutFpvUpdate = linearLayout4;
        this.layoutPtzUpdate = linearLayout5;
        this.layoutRemoteUpdate = linearLayout6;
        this.tvApp = textView2;
        this.tvAppTips = textView3;
        this.tvBattery = textView4;
        this.tvBatteryTips = textView5;
        this.tvBatteryUpdate = textView6;
        this.tvCamTips = textView7;
        this.tvCamUpdate = textView8;
        this.tvCamera = textView9;
        this.tvEsc = textView10;
        this.tvEscTips = textView11;
        this.tvFlight = textView12;
        this.tvFlightTips = textView13;
        this.tvFlightUpdate = textView14;
        this.tvFpv = textView15;
        this.tvFpvTips = textView16;
        this.tvFpvUpdate = textView17;
        this.tvPtz = textView18;
        this.tvPtzTips = textView19;
        this.tvPtzUpdate = textView20;
        this.tvRemoteTips = textView21;
        this.tvRemoteUpdate = textView22;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting5Item2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting5Item2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting5_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting5Item2Binding bind(View view) {
        int i = C1965R.id.cl_battery;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
        if (constraintLayout != null) {
            i = C1965R.id.cl_cam;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout2 != null) {
                i = C1965R.id.cl_esc;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(i);
                if (constraintLayout3 != null) {
                    i = C1965R.id.cl_flight;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(i);
                    if (constraintLayout4 != null) {
                        i = C1965R.id.cl_fpv;
                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(i);
                        if (constraintLayout5 != null) {
                            i = C1965R.id.cl_ptz;
                            ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(i);
                            if (constraintLayout6 != null) {
                                i = C1965R.id.cl_remote;
                                ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(i);
                                if (constraintLayout7 != null) {
                                    i = C1965R.id.iv_remote;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = C1965R.id.layout_battery_update;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                        if (linearLayout != null) {
                                            i = C1965R.id.layout_camera_update;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                            if (linearLayout2 != null) {
                                                i = C1965R.id.layout_flight_update;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                                                if (linearLayout3 != null) {
                                                    i = C1965R.id.layout_fpv_update;
                                                    LinearLayout linearLayout4 = (LinearLayout) view.findViewById(i);
                                                    if (linearLayout4 != null) {
                                                        i = C1965R.id.layout_ptz_update;
                                                        LinearLayout linearLayout5 = (LinearLayout) view.findViewById(i);
                                                        if (linearLayout5 != null) {
                                                            i = C1965R.id.layout_remote_update;
                                                            LinearLayout linearLayout6 = (LinearLayout) view.findViewById(i);
                                                            if (linearLayout6 != null) {
                                                                i = C1965R.id.tv_app;
                                                                TextView textView2 = (TextView) view.findViewById(i);
                                                                if (textView2 != null) {
                                                                    i = C1965R.id.tv_app_tips;
                                                                    TextView textView3 = (TextView) view.findViewById(i);
                                                                    if (textView3 != null) {
                                                                        i = C1965R.id.tv_battery;
                                                                        TextView textView4 = (TextView) view.findViewById(i);
                                                                        if (textView4 != null) {
                                                                            i = C1965R.id.tv_battery_tips;
                                                                            TextView textView5 = (TextView) view.findViewById(i);
                                                                            if (textView5 != null) {
                                                                                i = C1965R.id.tv_battery_update;
                                                                                TextView textView6 = (TextView) view.findViewById(i);
                                                                                if (textView6 != null) {
                                                                                    i = C1965R.id.tv_cam_tips;
                                                                                    TextView textView7 = (TextView) view.findViewById(i);
                                                                                    if (textView7 != null) {
                                                                                        i = C1965R.id.tv_cam_update;
                                                                                        TextView textView8 = (TextView) view.findViewById(i);
                                                                                        if (textView8 != null) {
                                                                                            i = C1965R.id.tv_camera;
                                                                                            TextView textView9 = (TextView) view.findViewById(i);
                                                                                            if (textView9 != null) {
                                                                                                i = C1965R.id.tv_esc;
                                                                                                TextView textView10 = (TextView) view.findViewById(i);
                                                                                                if (textView10 != null) {
                                                                                                    i = C1965R.id.tv_esc_tips;
                                                                                                    TextView textView11 = (TextView) view.findViewById(i);
                                                                                                    if (textView11 != null) {
                                                                                                        i = C1965R.id.tv_flight;
                                                                                                        TextView textView12 = (TextView) view.findViewById(i);
                                                                                                        if (textView12 != null) {
                                                                                                            i = C1965R.id.tv_flight_tips;
                                                                                                            TextView textView13 = (TextView) view.findViewById(i);
                                                                                                            if (textView13 != null) {
                                                                                                                i = C1965R.id.tv_flight_update;
                                                                                                                TextView textView14 = (TextView) view.findViewById(i);
                                                                                                                if (textView14 != null) {
                                                                                                                    i = C1965R.id.tv_fpv;
                                                                                                                    TextView textView15 = (TextView) view.findViewById(i);
                                                                                                                    if (textView15 != null) {
                                                                                                                        i = C1965R.id.tv_fpv_tips;
                                                                                                                        TextView textView16 = (TextView) view.findViewById(i);
                                                                                                                        if (textView16 != null) {
                                                                                                                            i = C1965R.id.tv_fpv_update;
                                                                                                                            TextView textView17 = (TextView) view.findViewById(i);
                                                                                                                            if (textView17 != null) {
                                                                                                                                i = C1965R.id.tv_ptz;
                                                                                                                                TextView textView18 = (TextView) view.findViewById(i);
                                                                                                                                if (textView18 != null) {
                                                                                                                                    i = C1965R.id.tv_ptz_tips;
                                                                                                                                    TextView textView19 = (TextView) view.findViewById(i);
                                                                                                                                    if (textView19 != null) {
                                                                                                                                        i = C1965R.id.tv_ptz_update;
                                                                                                                                        TextView textView20 = (TextView) view.findViewById(i);
                                                                                                                                        if (textView20 != null) {
                                                                                                                                            i = C1965R.id.tv_remote_tips;
                                                                                                                                            TextView textView21 = (TextView) view.findViewById(i);
                                                                                                                                            if (textView21 != null) {
                                                                                                                                                i = C1965R.id.tv_remote_update;
                                                                                                                                                TextView textView22 = (TextView) view.findViewById(i);
                                                                                                                                                if (textView22 != null) {
                                                                                                                                                    return new ViewLayoutSetting5Item2Binding((ConstraintLayout) view, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, constraintLayout7, textView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22);
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