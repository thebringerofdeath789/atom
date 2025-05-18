package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Item7Binding implements ViewBinding {
    public final CursorEditText edtSpeed;
    public final ImageButton ivLeft;
    public final ImageButton ivRight;
    public final LinearLayout layoutAltitudeSetting;
    public final ConstraintLayout layoutCircle;
    public final LinearLayout layoutSurroundSpeedSetting;
    private final ConstraintLayout rootView;
    public final CustomSeekbar seekBarRadius;
    public final CustomSeekbar seekBarSpeed;
    public final TextView tvDirectionTips;
    public final CursorEditText tvRadius;
    public final TextView tvRadiusFt;
    public final TextView tvRadiusTips;
    public final TextView tvSpeedFt;
    public final TextView tvSpeedTips;
    public final TextView tvUnitCircleRadius;
    public final TextView tvUnitCircleSpeed;

    private ViewLayoutSetting1Item7Binding(ConstraintLayout constraintLayout, CursorEditText cursorEditText, ImageButton imageButton, ImageButton imageButton2, LinearLayout linearLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout2, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, TextView textView, CursorEditText cursorEditText2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.edtSpeed = cursorEditText;
        this.ivLeft = imageButton;
        this.ivRight = imageButton2;
        this.layoutAltitudeSetting = linearLayout;
        this.layoutCircle = constraintLayout2;
        this.layoutSurroundSpeedSetting = linearLayout2;
        this.seekBarRadius = customSeekbar;
        this.seekBarSpeed = customSeekbar2;
        this.tvDirectionTips = textView;
        this.tvRadius = cursorEditText2;
        this.tvRadiusFt = textView2;
        this.tvRadiusTips = textView3;
        this.tvSpeedFt = textView4;
        this.tvSpeedTips = textView5;
        this.tvUnitCircleRadius = textView6;
        this.tvUnitCircleSpeed = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Item7Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Item7Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting1_item7, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Item7Binding bind(View view) {
        int i = C1965R.id.edt_speed;
        CursorEditText cursorEditText = (CursorEditText) view.findViewById(i);
        if (cursorEditText != null) {
            i = C1965R.id.iv_left;
            ImageButton imageButton = (ImageButton) view.findViewById(i);
            if (imageButton != null) {
                i = C1965R.id.iv_right;
                ImageButton imageButton2 = (ImageButton) view.findViewById(i);
                if (imageButton2 != null) {
                    i = C1965R.id.layout_altitude_setting;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
                    if (linearLayout != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = C1965R.id.layout_surround_speed_setting;
                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(i);
                        if (linearLayout2 != null) {
                            i = C1965R.id.seekBar_radius;
                            CustomSeekbar customSeekbar = (CustomSeekbar) view.findViewById(i);
                            if (customSeekbar != null) {
                                i = C1965R.id.seekBar_speed;
                                CustomSeekbar customSeekbar2 = (CustomSeekbar) view.findViewById(i);
                                if (customSeekbar2 != null) {
                                    i = C1965R.id.tv_direction_tips;
                                    TextView textView = (TextView) view.findViewById(i);
                                    if (textView != null) {
                                        i = C1965R.id.tv_radius;
                                        CursorEditText cursorEditText2 = (CursorEditText) view.findViewById(i);
                                        if (cursorEditText2 != null) {
                                            i = C1965R.id.tv_radius_ft;
                                            TextView textView2 = (TextView) view.findViewById(i);
                                            if (textView2 != null) {
                                                i = C1965R.id.tv_radius_tips;
                                                TextView textView3 = (TextView) view.findViewById(i);
                                                if (textView3 != null) {
                                                    i = C1965R.id.tv_speed_ft;
                                                    TextView textView4 = (TextView) view.findViewById(i);
                                                    if (textView4 != null) {
                                                        i = C1965R.id.tv_speed_tips;
                                                        TextView textView5 = (TextView) view.findViewById(i);
                                                        if (textView5 != null) {
                                                            i = C1965R.id.tv_unit_circle_radius;
                                                            TextView textView6 = (TextView) view.findViewById(i);
                                                            if (textView6 != null) {
                                                                i = C1965R.id.tv_unit_circle_speed;
                                                                TextView textView7 = (TextView) view.findViewById(i);
                                                                if (textView7 != null) {
                                                                    return new ViewLayoutSetting1Item7Binding(constraintLayout, cursorEditText, imageButton, imageButton2, linearLayout, constraintLayout, linearLayout2, customSeekbar, customSeekbar2, textView, cursorEditText2, textView2, textView3, textView4, textView5, textView6, textView7);
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