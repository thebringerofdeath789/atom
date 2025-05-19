package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting1Item5Binding implements ViewBinding {
    public final RelativeLayout layoutSpeedSetting;
    private final ConstraintLayout rootView;
    public final TextView tvGearSetting;
    public final TextView tvGentlyMode;
    public final TextView tvNormalMode;
    public final TextView tvSportMode;

    private ViewLayoutSetting1Item5Binding(ConstraintLayout constraintLayout, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.layoutSpeedSetting = relativeLayout;
        this.tvGearSetting = textView;
        this.tvGentlyMode = textView2;
        this.tvNormalMode = textView3;
        this.tvSportMode = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting1Item5Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting1Item5Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_layout_setting1_item5, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting1Item5Binding bind(View view) {
        int i = R.id.layout_speed_setting;
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(i);
        if (relativeLayout != null) {
            i = R.id.tv_gear_setting;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_gently_mode;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = R.id.tv_normal_mode;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        i = R.id.tv_sport_mode;
                        TextView textView4 = (TextView) view.findViewById(i);
                        if (textView4 != null) {
                            return new ViewLayoutSetting1Item5Binding((ConstraintLayout) view, relativeLayout, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
