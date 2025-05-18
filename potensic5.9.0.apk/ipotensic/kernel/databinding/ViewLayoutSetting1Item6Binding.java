package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Item6Binding implements ViewBinding {
    public final LinearLayout layoutAltitudeSetting;
    public final LinearLayout layoutDistanceSetting;
    public final ConstraintLayout layoutFlyFenceSetting;
    private final ConstraintLayout rootView;
    public final CustomSeekbar seekBarAltitude;
    public final CustomSeekbar seekBarDistance;
    public final SwitchButton switchBtnNoLimit;
    public final TextView tvAltitudeCarefulTips;
    public final TextView tvAltitudeFt1;
    public final TextView tvDistanceFt1;
    public final TextView tvFlyFenceAltitide;
    public final TextView tvFlyFenceDistance;
    public final CursorEditText tvShowAltitudeValue;
    public final CursorEditText tvShowDistanceValue;
    public final TextView tvUnitDistance;
    public final TextView tvUnitHeight;

    private ViewLayoutSetting1Item6Binding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, CursorEditText cursorEditText, CursorEditText cursorEditText2, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.layoutAltitudeSetting = linearLayout;
        this.layoutDistanceSetting = linearLayout2;
        this.layoutFlyFenceSetting = constraintLayout2;
        this.seekBarAltitude = customSeekbar;
        this.seekBarDistance = customSeekbar2;
        this.switchBtnNoLimit = switchButton;
        this.tvAltitudeCarefulTips = textView;
        this.tvAltitudeFt1 = textView2;
        this.tvDistanceFt1 = textView3;
        this.tvFlyFenceAltitide = textView4;
        this.tvFlyFenceDistance = textView5;
        this.tvShowAltitudeValue = cursorEditText;
        this.tvShowDistanceValue = cursorEditText2;
        this.tvUnitDistance = textView6;
        this.tvUnitHeight = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Item6Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Item6Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting1_item6, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Item6Binding bind(View view) {
        int i = R.id.layout_altitude_setting;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
        if (linearLayout != null) {
            i = R.id.layout_distance_setting;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
            if (linearLayout2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.seekBar_altitude;
                CustomSeekbar customSeekbar = (CustomSeekbar) view.findViewById(i);
                if (customSeekbar != null) {
                    i = R.id.seekBar_distance;
                    CustomSeekbar customSeekbar2 = (CustomSeekbar) view.findViewById(i);
                    if (customSeekbar2 != null) {
                        i = R.id.switch_btn_no_limit;
                        SwitchButton switchButton = (SwitchButton) view.findViewById(i);
                        if (switchButton != null) {
                            i = R.id.tv_altitude_careful_tips;
                            TextView textView = (TextView) view.findViewById(i);
                            if (textView != null) {
                                i = R.id.tv_altitude_ft1;
                                TextView textView2 = (TextView) view.findViewById(i);
                                if (textView2 != null) {
                                    i = R.id.tv_distance_ft1;
                                    TextView textView3 = (TextView) view.findViewById(i);
                                    if (textView3 != null) {
                                        i = R.id.tv_fly_fence_altitide;
                                        TextView textView4 = (TextView) view.findViewById(i);
                                        if (textView4 != null) {
                                            i = R.id.tv_fly_fence_distance;
                                            TextView textView5 = (TextView) view.findViewById(i);
                                            if (textView5 != null) {
                                                i = R.id.tv_show_altitude_value;
                                                CursorEditText cursorEditText = (CursorEditText) view.findViewById(i);
                                                if (cursorEditText != null) {
                                                    i = R.id.tv_show_distance_value;
                                                    CursorEditText cursorEditText2 = (CursorEditText) view.findViewById(i);
                                                    if (cursorEditText2 != null) {
                                                        i = R.id.tv_unit_distance;
                                                        TextView textView6 = (TextView) view.findViewById(i);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_unit_height;
                                                            TextView textView7 = (TextView) view.findViewById(i);
                                                            if (textView7 != null) {
                                                                return new ViewLayoutSetting1Item6Binding(constraintLayout, linearLayout, linearLayout2, constraintLayout, customSeekbar, customSeekbar2, switchButton, textView, textView2, textView3, textView4, textView5, cursorEditText, cursorEditText2, textView6, textView7);
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