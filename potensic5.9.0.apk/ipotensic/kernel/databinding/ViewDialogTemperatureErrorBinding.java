package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public final class ViewDialogTemperatureErrorBinding implements ViewBinding {
    public final ImageView ivBatteryTemperatureError;
    private final ConstraintLayout rootView;
    public final TextView tvBatteryTemperature;
    public final TextView tvBatteryTemperatureErrorNotice;
    public final TextView tvDialogTitle;

    private ViewDialogTemperatureErrorBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivBatteryTemperatureError = imageView;
        this.tvBatteryTemperature = textView;
        this.tvBatteryTemperatureErrorNotice = textView2;
        this.tvDialogTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogTemperatureErrorBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogTemperatureErrorBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.view_dialog_temperature_error, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogTemperatureErrorBinding bind(View view) {
        int i = R.id.iv_battery_temperature_error;
        ImageView imageView = (ImageView) view.findViewById(i);
        if (imageView != null) {
            i = R.id.tv_battery_temperature;
            TextView textView = (TextView) view.findViewById(i);
            if (textView != null) {
                i = R.id.tv_battery_temperature_error_notice;
                TextView textView2 = (TextView) view.findViewById(i);
                if (textView2 != null) {
                    i = R.id.tv_dialog_title;
                    TextView textView3 = (TextView) view.findViewById(i);
                    if (textView3 != null) {
                        return new ViewDialogTemperatureErrorBinding((ConstraintLayout) view, imageView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}