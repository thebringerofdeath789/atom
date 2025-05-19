package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewStubProxy;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingSecurityBinding extends ViewDataBinding {
    public final Guideline baseLineLeft;
    public final Guideline baseLineRight;
    public final LinearLayout bgBattery;
    public final View bgUnit;
    public final ConstraintLayout constraintlayoutFlightFence;
    public final CommonSelectionView crv;
    public final CommonSwitchView csvBeginner;
    public final CommonSelectionView csvLost;
    public final CommonSelectionView csvUnit;
    public final CursorEditText edtDistanceLimit;
    public final CursorEditText edtHeightLimit;
    public final CursorEditText edtReturnHeight;
    public final ImageView ivPlayReturnHeightVideo;
    public final LinearLayout layoutDistanceLimit;
    public final ConstraintLayout layoutFence;
    public final LinearLayout layoutFlightFence;
    public final LinearLayout layoutReturnHeight;
    public final ScrollView layoutSetting;
    public final View line1;
    public final View line2;
    public final View line3;

    @Bindable
    protected SettingSecurityModel mSettingSecurityModel;
    public final CustomSeekbar seekbarDistanceLimit;
    public final CustomSeekbar seekbarHeightLimit;
    public final View spaceUnit;
    public final SwitchButton switchBtnNoLimit;
    public final TextView tvAltitudeCarefulTips;
    public final TextView tvBatteryInfo;
    public final TextView tvDistanceLimit;
    public final TextView tvFlightFence;
    public final TextView tvHeightLimit;
    public final TextView tvHeightNoLimit;
    public final TextView tvLostActionWarning;
    public final TextView tvLostChild;
    public final ImageButton tvLostChildFunction;
    public final TextView tvReturnHeight;
    public final TextView tvSignalLost;
    public final TextView tvSpeedChange;
    public final TextView tvSpeedSetting;
    public final TextView tvUnit;
    public final TextView tvUnitDistanceLimit;
    public final TextView tvUnitHeightLimit;
    public final CommonSwitchView viewFightTip;
    public final CommonSwitchView viewSilentReturn;
    public final CommonTitleView viewTitle;
    public final ViewStubProxy vsBattery;

    public abstract void setSettingSecurityModel(SettingSecurityModel settingSecurityModel);

    protected ViewLayoutSettingSecurityBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, LinearLayout linearLayout, View view2, ConstraintLayout constraintLayout, CommonSelectionView commonSelectionView, CommonSwitchView commonSwitchView, CommonSelectionView commonSelectionView2, CommonSelectionView commonSelectionView3, CursorEditText cursorEditText, CursorEditText cursorEditText2, CursorEditText cursorEditText3, ImageView imageView, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ScrollView scrollView, View view3, View view4, View view5, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, View view6, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, ImageButton imageButton, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, CommonSwitchView commonSwitchView2, CommonSwitchView commonSwitchView3, CommonTitleView commonTitleView, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.baseLineLeft = guideline;
        this.baseLineRight = guideline2;
        this.bgBattery = linearLayout;
        this.bgUnit = view2;
        this.constraintlayoutFlightFence = constraintLayout;
        this.crv = commonSelectionView;
        this.csvBeginner = commonSwitchView;
        this.csvLost = commonSelectionView2;
        this.csvUnit = commonSelectionView3;
        this.edtDistanceLimit = cursorEditText;
        this.edtHeightLimit = cursorEditText2;
        this.edtReturnHeight = cursorEditText3;
        this.ivPlayReturnHeightVideo = imageView;
        this.layoutDistanceLimit = linearLayout2;
        this.layoutFence = constraintLayout2;
        this.layoutFlightFence = linearLayout3;
        this.layoutReturnHeight = linearLayout4;
        this.layoutSetting = scrollView;
        this.line1 = view3;
        this.line2 = view4;
        this.line3 = view5;
        this.seekbarDistanceLimit = customSeekbar;
        this.seekbarHeightLimit = customSeekbar2;
        this.spaceUnit = view6;
        this.switchBtnNoLimit = switchButton;
        this.tvAltitudeCarefulTips = textView;
        this.tvBatteryInfo = textView2;
        this.tvDistanceLimit = textView3;
        this.tvFlightFence = textView4;
        this.tvHeightLimit = textView5;
        this.tvHeightNoLimit = textView6;
        this.tvLostActionWarning = textView7;
        this.tvLostChild = textView8;
        this.tvLostChildFunction = imageButton;
        this.tvReturnHeight = textView9;
        this.tvSignalLost = textView10;
        this.tvSpeedChange = textView11;
        this.tvSpeedSetting = textView12;
        this.tvUnit = textView13;
        this.tvUnitDistanceLimit = textView14;
        this.tvUnitHeightLimit = textView15;
        this.viewFightTip = commonSwitchView2;
        this.viewSilentReturn = commonSwitchView3;
        this.viewTitle = commonTitleView;
        this.vsBattery = viewStubProxy;
    }

    public SettingSecurityModel getSettingSecurityModel() {
        return this.mSettingSecurityModel;
    }

    public static ViewLayoutSettingSecurityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingSecurityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_security, viewGroup, z, obj);
    }

    public static ViewLayoutSettingSecurityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurityBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingSecurityBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_security, null, false, obj);
    }

    public static ViewLayoutSettingSecurityBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurityBinding bind(View view, Object obj) {
        return (ViewLayoutSettingSecurityBinding) bind(obj, view, R.layout.view_layout_setting_security);
    }
}
