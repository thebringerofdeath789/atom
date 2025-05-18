package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingCalibrationBinding extends ViewDataBinding {
    public final TextView tvCalibration;
    public final TextView tvGimbalAdjustment;
    public final TextView tvGimbalCalibration;
    public final TextView tvPairDrone;
    public final TextView tvRemoterCalibration;
    public final View viewGimbalBg;
    public final View viewGimbalLine;
    public final CommonTitleView viewTitle;

    protected ViewLayoutSettingCalibrationBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.tvCalibration = textView;
        this.tvGimbalAdjustment = textView2;
        this.tvGimbalCalibration = textView3;
        this.tvPairDrone = textView4;
        this.tvRemoterCalibration = textView5;
        this.viewGimbalBg = view2;
        this.viewGimbalLine = view3;
        this.viewTitle = commonTitleView;
    }

    public static ViewLayoutSettingCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_calibration, viewGroup, z, obj);
    }

    public static ViewLayoutSettingCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_calibration, null, false, obj);
    }

    public static ViewLayoutSettingCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCalibrationBinding bind(View view, Object obj) {
        return (ViewLayoutSettingCalibrationBinding) bind(obj, view, R.layout.view_layout_setting_calibration);
    }
}