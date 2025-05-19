package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.BatteryCircleProgressView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingBatteryBinding extends ViewDataBinding {
    public final BatteryCircleProgressView batteryProgressView;
    public final View line4;

    @Bindable
    protected SettingSecurityModel mSettingSecurityModel;
    public final TextView tvCurrent;
    public final TextView tvCurrentValue;
    public final TextView tvCycleTimeTips;
    public final TextView tvTempValue;
    public final TextView tvTemperatureTips;
    public final TextView tvVoltage;
    public final TextView tvVoltageTips;

    public abstract void setSettingSecurityModel(SettingSecurityModel settingSecurityModel);

    protected ViewLayoutSettingBatteryBinding(Object obj, View view, int i, BatteryCircleProgressView batteryCircleProgressView, View view2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.batteryProgressView = batteryCircleProgressView;
        this.line4 = view2;
        this.tvCurrent = textView;
        this.tvCurrentValue = textView2;
        this.tvCycleTimeTips = textView3;
        this.tvTempValue = textView4;
        this.tvTemperatureTips = textView5;
        this.tvVoltage = textView6;
        this.tvVoltageTips = textView7;
    }

    public SettingSecurityModel getSettingSecurityModel() {
        return this.mSettingSecurityModel;
    }

    public static ViewLayoutSettingBatteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingBatteryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingBatteryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_battery, viewGroup, z, obj);
    }

    public static ViewLayoutSettingBatteryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingBatteryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingBatteryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_battery, null, false, obj);
    }

    public static ViewLayoutSettingBatteryBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingBatteryBinding bind(View view, Object obj) {
        return (ViewLayoutSettingBatteryBinding) bind(obj, view, R.layout.view_layout_setting_battery);
    }
}
