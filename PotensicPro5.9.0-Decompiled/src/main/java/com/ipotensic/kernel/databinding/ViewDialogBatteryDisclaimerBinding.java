package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class ViewDialogBatteryDisclaimerBinding extends ViewDataBinding {
    public final Button btnConfirm;
    public final ConstraintLayout clUpgradeDialog;
    public final LinearLayout layoutBottom;
    public final TextView tvCodeTitle;
    public final TextView tvDetail;

    protected ViewDialogBatteryDisclaimerBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.btnConfirm = button;
        this.clUpgradeDialog = constraintLayout;
        this.layoutBottom = linearLayout;
        this.tvCodeTitle = textView;
        this.tvDetail = textView2;
    }

    public static ViewDialogBatteryDisclaimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBatteryDisclaimerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewDialogBatteryDisclaimerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_dialog_battery_disclaimer, viewGroup, z, obj);
    }

    public static ViewDialogBatteryDisclaimerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBatteryDisclaimerBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewDialogBatteryDisclaimerBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_dialog_battery_disclaimer, null, false, obj);
    }

    public static ViewDialogBatteryDisclaimerBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewDialogBatteryDisclaimerBinding bind(View view, Object obj) {
        return (ViewDialogBatteryDisclaimerBinding) bind(obj, view, R.layout.view_dialog_battery_disclaimer);
    }
}
