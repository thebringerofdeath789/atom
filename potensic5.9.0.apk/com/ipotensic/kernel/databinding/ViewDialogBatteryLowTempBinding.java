package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public final class ViewDialogBatteryLowTempBinding implements ViewBinding {
    public final ConstraintLayout batteryLowTempDialog;
    public final Button btnConfirm;
    public final LinearLayout layoutBottom;
    private final ConstraintLayout rootView;
    public final TextView tvCodeTitle;
    public final TextView tvDetail;
    public final TextView tvErrorCode;

    private ViewDialogBatteryLowTempBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Button button, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.batteryLowTempDialog = constraintLayout2;
        this.btnConfirm = button;
        this.layoutBottom = linearLayout;
        this.tvCodeTitle = textView;
        this.tvDetail = textView2;
        this.tvErrorCode = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogBatteryLowTempBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ViewDialogBatteryLowTempBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(C1965R.layout.view_dialog_battery_low_temp, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewDialogBatteryLowTempBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C1965R.id.btn_confirm;
        Button button = (Button) view.findViewById(i);
        if (button != null) {
            i = C1965R.id.layout_bottom;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i);
            if (linearLayout != null) {
                i = C1965R.id.tv_code_title;
                TextView textView = (TextView) view.findViewById(i);
                if (textView != null) {
                    i = C1965R.id.tv_detail;
                    TextView textView2 = (TextView) view.findViewById(i);
                    if (textView2 != null) {
                        i = C1965R.id.tv_error_code;
                        TextView textView3 = (TextView) view.findViewById(i);
                        if (textView3 != null) {
                            return new ViewDialogBatteryLowTempBinding(constraintLayout, constraintLayout, button, linearLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}