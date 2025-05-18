package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewLayoutSetting4Binding implements ViewBinding {
    public final ViewLayoutSetting4Item1Binding include1;
    public final ImageView ivBack;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;
    private final ConstraintLayout rootView;
    public final TextView tvBatteryCapacity;
    public final TextView tvBatteryType;
    public final TextView tvCycleTimes;
    public final TextView tvEstimatedFlightTime;
    public final TextView tvSetting;

    private ViewLayoutSetting4Binding(ConstraintLayout constraintLayout, ViewLayoutSetting4Item1Binding viewLayoutSetting4Item1Binding, ImageView imageView, View view, View view2, View view3, View view4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.include1 = viewLayoutSetting4Item1Binding;
        this.ivBack = imageView;
        this.line1 = view;
        this.line2 = view2;
        this.line3 = view3;
        this.line4 = view4;
        this.tvBatteryCapacity = textView;
        this.tvBatteryType = textView2;
        this.tvCycleTimes = textView3;
        this.tvEstimatedFlightTime = textView4;
        this.tvSetting = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewLayoutSetting4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewLayoutSetting4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_layout_setting_4, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewLayoutSetting4Binding bind(View view) {
        View findViewById;
        View findViewById2;
        View findViewById3;
        View findViewById4;
        int i = C1965R.id.include1;
        View findViewById5 = view.findViewById(i);
        if (findViewById5 != null) {
            ViewLayoutSetting4Item1Binding bind = ViewLayoutSetting4Item1Binding.bind(findViewById5);
            i = C1965R.id.iv_back;
            ImageView imageView = (ImageView) view.findViewById(i);
            if (imageView != null && (findViewById = view.findViewById((i = C1965R.id.line1))) != null && (findViewById2 = view.findViewById((i = C1965R.id.line2))) != null && (findViewById3 = view.findViewById((i = C1965R.id.line3))) != null && (findViewById4 = view.findViewById((i = C1965R.id.line4))) != null) {
                i = C1965R.id.tv_battery_capacity;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_battery_type;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_cycle_times;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            i = C1965R.id.tv_estimated_flight_time;
                            TextView textView4 = (TextView) view.findViewById(i);
                            if (textView4 != null) {
                                i = C1965R.id.tv_setting;
                                TextView textView5 = (TextView) view.findViewById(i);
                                if (textView5 != null) {
                                    return new ViewLayoutSetting4Binding((ConstraintLayout) view, bind, imageView, findViewById, findViewById2, findViewById3, findViewById4, textView, textView2, textView3, textView4, textView5);
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