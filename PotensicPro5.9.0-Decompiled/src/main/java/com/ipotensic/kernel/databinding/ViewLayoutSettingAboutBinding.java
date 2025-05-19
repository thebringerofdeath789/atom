package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingAboutModel;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingAboutBinding extends ViewDataBinding {
    public final ConstraintLayout clDeviceModel;
    public final ConstraintLayout clFirmwareVersion;
    public final LinearLayout llBatteryVersion;
    public final LinearLayout llCameraVersion;
    public final LinearLayout llDroneSn;
    public final LinearLayout llEscVersion;
    public final LinearLayout llFlightVersion;
    public final LinearLayout llFpvVersion;
    public final LinearLayout llGimbalVersion;
    public final LinearLayout llRemoteVersion;

    @Bindable
    protected SettingAboutModel mSettingAboutModel;
    public final RelativeLayout rlDeviceModel;
    public final RelativeLayout rlFirmwareVersion;
    public final RelativeLayout rlVersion;
    public final TextView tvBigPackageVersion;
    public final TextView tvDeviceModel;
    public final TextView tvProduct;
    public final CommonTitleView viewTitle;

    public abstract void setSettingAboutModel(SettingAboutModel settingAboutModel);

    protected ViewLayoutSettingAboutBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView, TextView textView2, TextView textView3, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.clDeviceModel = constraintLayout;
        this.clFirmwareVersion = constraintLayout2;
        this.llBatteryVersion = linearLayout;
        this.llCameraVersion = linearLayout2;
        this.llDroneSn = linearLayout3;
        this.llEscVersion = linearLayout4;
        this.llFlightVersion = linearLayout5;
        this.llFpvVersion = linearLayout6;
        this.llGimbalVersion = linearLayout7;
        this.llRemoteVersion = linearLayout8;
        this.rlDeviceModel = relativeLayout;
        this.rlFirmwareVersion = relativeLayout2;
        this.rlVersion = relativeLayout3;
        this.tvBigPackageVersion = textView;
        this.tvDeviceModel = textView2;
        this.tvProduct = textView3;
        this.viewTitle = commonTitleView;
    }

    public SettingAboutModel getSettingAboutModel() {
        return this.mSettingAboutModel;
    }

    public static ViewLayoutSettingAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_about, viewGroup, z, obj);
    }

    public static ViewLayoutSettingAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingAboutBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingAboutBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_about, null, false, obj);
    }

    public static ViewLayoutSettingAboutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingAboutBinding bind(View view, Object obj) {
        return (ViewLayoutSettingAboutBinding) bind(obj, view, R.layout.view_layout_setting_about);
    }
}
