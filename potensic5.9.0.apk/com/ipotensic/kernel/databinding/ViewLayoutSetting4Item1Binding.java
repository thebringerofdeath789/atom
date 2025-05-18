package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.BatteryProgressView;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting4Item1Binding implements ViewBinding {
    public final BatteryProgressView batteryProgressView;
    public final View line;
    public final ConstraintLayout right;
    private final ConstraintLayout rootView;
    public final TextView tvCurrent;
    public final TextView tvCurrentTips;
    public final TextView tvTemperature;
    public final TextView tvTemperatureTips;
    public final TextView tvVoltage;
    public final TextView tvVoltageTips;

    private ViewLayoutSetting4Item1Binding(ConstraintLayout constraintLayout, BatteryProgressView batteryProgressView, View view, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.batteryProgressView = batteryProgressView;
        this.line = view;
        this.right = constraintLayout2;
        this.tvCurrent = textView;
        this.tvCurrentTips = textView2;
        this.tvTemperature = textView3;
        this.tvTemperatureTips = textView4;
        this.tvVoltage = textView5;
        this.tvVoltageTips = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting4Item1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting4Item1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting4_item1, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting4Item1Binding bind(View view) {
        View findViewById;
        int i = C1965R.id.battery_progress_view;
        BatteryProgressView batteryProgressView = (BatteryProgressView) view.findViewById(i);
        if (batteryProgressView != null && (findViewById = view.findViewById((i = C1965R.id.line))) != null) {
            i = C1965R.id.right;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(i);
            if (constraintLayout != null) {
                i = C1965R.id.tv_current;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_current_tips;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_temperature;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            i = C1965R.id.tv_temperature_tips;
                            TextView textView4 = (TextView) view.findViewById(i);
                            if (textView4 != null) {
                                i = C1965R.id.tv_voltage;
                                TextView textView5 = (TextView) view.findViewById(i);
                                if (textView5 != null) {
                                    i = C1965R.id.tv_voltage_tips;
                                    TextView textView6 = (TextView) view.findViewById(i);
                                    if (textView6 != null) {
                                        return new ViewLayoutSetting4Item1Binding((ConstraintLayout) view, batteryProgressView, findViewById, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6);
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