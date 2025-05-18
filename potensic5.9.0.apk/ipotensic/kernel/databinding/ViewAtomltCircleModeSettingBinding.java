package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;

/* loaded from: classes2.dex */
public final class ViewAtomltCircleModeSettingBinding implements ViewBinding {
    public final CursorEditText atomLTEdtRadius;
    public final CursorEditText atomLTEdtSpeed;
    public final ImageButton atomLTIvLeft;
    public final ImageButton atomLTIvRight;
    public final CustomSeekbar atomLTSeekBarRadius;
    public final CustomSeekbar atomLTSeekBarSpeed;
    public final TextView atomLTTvUnitCircleRadius;
    public final TextView atomLTTvUnitCircleSpeed;
    public final LinearLayout layoutAltitudeSetting;
    public final ConstraintLayout layoutCircleAtomLT;
    public final LinearLayout layoutCircleDirection;
    public final LinearLayout layoutSurroundSpeedSetting;
    private final ConstraintLayout rootView;
    public final Button startCircleFlight;
    public final TextView tvCircleFlightSetting;
    public final TextView tvDirectionTips;
    public final TextView tvRadiusTips;
    public final TextView tvSpeedTips;

    private ViewAtomltCircleModeSettingBinding(ConstraintLayout constraintLayout, CursorEditText cursorEditText, CursorEditText cursorEditText2, ImageButton imageButton, ImageButton imageButton2, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, TextView textView, TextView textView2, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, LinearLayout linearLayout3, Button button, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.atomLTEdtRadius = cursorEditText;
        this.atomLTEdtSpeed = cursorEditText2;
        this.atomLTIvLeft = imageButton;
        this.atomLTIvRight = imageButton2;
        this.atomLTSeekBarRadius = customSeekbar;
        this.atomLTSeekBarSpeed = customSeekbar2;
        this.atomLTTvUnitCircleRadius = textView;
        this.atomLTTvUnitCircleSpeed = textView2;
        this.layoutAltitudeSetting = linearLayout;
        this.layoutCircleAtomLT = constraintLayout2;
        this.layoutCircleDirection = linearLayout2;
        this.layoutSurroundSpeedSetting = linearLayout3;
        this.startCircleFlight = button;
        this.tvCircleFlightSetting = textView3;
        this.tvDirectionTips = textView4;
        this.tvRadiusTips = textView5;
        this.tvSpeedTips = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewAtomltCircleModeSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewAtomltCircleModeSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_atomlt_circle_mode_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewAtomltCircleModeSettingBinding bind(View view) {
        int i = R.id.atomLT_edt_radius;
        CursorEditText cursorEditText = (CursorEditText) view.findViewById(i);
        if (cursorEditText != null) {
            i = R.id.atomLT_edt_speed;
            CursorEditText cursorEditText2 = (CursorEditText) view.findViewById(i);
            if (cursorEditText2 != null) {
                i = R.id.atomLT_iv_left;
                ImageButton imageButton = (ImageButton) view.findViewById(i);
                if (imageButton != null) {
                    i = R.id.atomLT_iv_right;
                    ImageButton imageButton2 = (ImageButton) view.findViewById(i);
                    if (imageButton2 != null) {
                        i = R.id.atomLT_seekBar_radius;
                        CustomSeekbar customSeekbar = (CustomSeekbar) view.findViewById(i);
                        if (customSeekbar != null) {
                            i = R.id.atomLT_seekBar_speed;
                            CustomSeekbar customSeekbar2 = (CustomSeekbar) view.findViewById(i);
                            if (customSeekbar2 != null) {
                                i = R.id.atomLT_tv_unit_circle_radius;
                                TextView textView = (TextView) view.findViewById(i);
                                if (textView != null) {
                                    i = R.id.atomLT_tv_unit_circle_speed;
                                    TextView textView2 = (TextView) view.findViewById(i);
                                    if (textView2 != null) {
                                        i = R.id.layout_altitude_setting;
                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                                        if (linearLayout != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i = R.id.layout_circle_direction;
                                            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                                            if (linearLayout2 != null) {
                                                i = R.id.layout_surround_speed_setting;
                                                LinearLayout linearLayout3 = (LinearLayout) view.findViewById(i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.start_circle_flight;
                                                    Button button = (Button) view.findViewById(i);
                                                    if (button != null) {
                                                        i = R.id.tvCircleFlightSetting;
                                                        TextView textView3 = (TextView) view.findViewById(i);
                                                        if (textView3 != null) {
                                                            i = R.id.tv_direction_tips;
                                                            TextView textView4 = (TextView) view.findViewById(i);
                                                            if (textView4 != null) {
                                                                i = R.id.tv_radius_tips;
                                                                TextView textView5 = (TextView) view.findViewById(i);
                                                                if (textView5 != null) {
                                                                    i = R.id.tv_speed_tips;
                                                                    TextView textView6 = (TextView) view.findViewById(i);
                                                                    if (textView6 != null) {
                                                                        return new ViewAtomltCircleModeSettingBinding(constraintLayout, cursorEditText, cursorEditText2, imageButton, imageButton2, customSeekbar, customSeekbar2, textView, textView2, linearLayout, constraintLayout, linearLayout2, linearLayout3, button, textView3, textView4, textView5, textView6);
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