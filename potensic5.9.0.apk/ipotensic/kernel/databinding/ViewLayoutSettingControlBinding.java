package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingControlModel;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingControlBinding extends ViewDataBinding {
    public final Guideline baseLineLeft;
    public final CursorEditText edtSmooth;
    public final CursorEditText edtSpeed;
    public final Group groutGimbal;
    public final ImageButton ibGimbalMode;
    public final LinearLayout layoutMaxPitchSpeed;
    public final LinearLayout layoutPitchAngle;
    public final RelativeLayout layoutPitchAngle45;
    public final LinearLayout layoutRollSmooth;
    public final ScrollView layoutSetting;
    public final View line1;
    public final View line2;
    public final View linePitchAngle45;
    public final LinearLayout llGimbalMode;

    @Bindable
    protected SettingControlModel mSettingControlModel;
    public final CustomSeekbar seekbarSmooth;
    public final CustomSeekbar seekbarSpeed;
    public final View spaceGimbal;
    public final TextView tvControllerSetting;
    public final TextView tvCurrentAngle;
    public final TextView tvCurrentAngleValue;
    public final TextView tvDefault;
    public final TextView tvGimbalMode;
    public final TextView tvGimbalSetting;
    public final TextView tvMaxPitch;
    public final TextView tvRollSmooth;
    public final TextView tvStickMode;
    public final TextView tvUnitCircleSpeed;
    public final View viewGimbalSetting;
    public final CommonTitleView viewTitle;

    public abstract void setSettingControlModel(SettingControlModel settingControlModel);

    protected ViewLayoutSettingControlBinding(Object obj, View view, int i, Guideline guideline, CursorEditText cursorEditText, CursorEditText cursorEditText2, Group group, ImageButton imageButton, LinearLayout linearLayout, LinearLayout linearLayout2, RelativeLayout relativeLayout, LinearLayout linearLayout3, ScrollView scrollView, View view2, View view3, View view4, LinearLayout linearLayout4, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, View view5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view6, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.baseLineLeft = guideline;
        this.edtSmooth = cursorEditText;
        this.edtSpeed = cursorEditText2;
        this.groutGimbal = group;
        this.ibGimbalMode = imageButton;
        this.layoutMaxPitchSpeed = linearLayout;
        this.layoutPitchAngle = linearLayout2;
        this.layoutPitchAngle45 = relativeLayout;
        this.layoutRollSmooth = linearLayout3;
        this.layoutSetting = scrollView;
        this.line1 = view2;
        this.line2 = view3;
        this.linePitchAngle45 = view4;
        this.llGimbalMode = linearLayout4;
        this.seekbarSmooth = customSeekbar;
        this.seekbarSpeed = customSeekbar2;
        this.spaceGimbal = view5;
        this.tvControllerSetting = textView;
        this.tvCurrentAngle = textView2;
        this.tvCurrentAngleValue = textView3;
        this.tvDefault = textView4;
        this.tvGimbalMode = textView5;
        this.tvGimbalSetting = textView6;
        this.tvMaxPitch = textView7;
        this.tvRollSmooth = textView8;
        this.tvStickMode = textView9;
        this.tvUnitCircleSpeed = textView10;
        this.viewGimbalSetting = view6;
        this.viewTitle = commonTitleView;
    }

    public SettingControlModel getSettingControlModel() {
        return this.mSettingControlModel;
    }

    public static ViewLayoutSettingControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingControlBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingControlBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_control, viewGroup, z, obj);
    }

    public static ViewLayoutSettingControlBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingControlBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingControlBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_control, null, false, obj);
    }

    public static ViewLayoutSettingControlBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingControlBinding bind(View view, Object obj) {
        return (ViewLayoutSettingControlBinding) bind(obj, view, R.layout.view_layout_setting_control);
    }
}