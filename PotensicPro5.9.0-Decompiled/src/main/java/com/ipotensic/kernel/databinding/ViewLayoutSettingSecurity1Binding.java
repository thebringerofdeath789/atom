package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.BatteryCircleProgressView;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingSecurity1Binding extends ViewDataBinding {
    public final BatteryCircleProgressView batteryProgressView;
    public final LinearLayout bgBattery;
    public final RelativeLayout constraintlayoutFlightFence;
    public final CommonSelectionView crv;
    public final CommonSwitchView csvBeginner;
    public final CommonSelectionView csvLost;
    public final CommonSelectionView csvUnit;
    public final CursorEditText edtDistanceLimit;
    public final CursorEditText edtHeightLimit;
    public final CursorEditText edtReturnHeight;
    public final ImageView ivPlayReturnHeightVideo;
    public final ConstraintLayout layoutBattery;
    public final ScrollView layoutSetting;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;

    @Bindable
    protected SettingSecurityModel mSettingSecurityModel;
    public final RelativeLayout rlLost;
    public final RelativeLayout rlUnit;
    public final CustomSeekbar seekbarDistanceLimit;
    public final CustomSeekbar seekbarHeightLimit;
    public final SwitchButton switchBtnNoLimit;
    public final TextView tvAltitudeCarefulTips;
    public final TextView tvBatteryInfo;
    public final TextView tvCurrent;
    public final TextView tvCurrentValue;
    public final TextView tvCycleTimeTips;
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
    public final TextView tvTempValue;
    public final TextView tvTemperatureTips;
    public final TextView tvUnit;
    public final TextView tvUnitDistanceLimit;
    public final TextView tvUnitHeightLimit;
    public final TextView tvVoltage;
    public final TextView tvVoltageTips;
    public final CommonSwitchView viewFightTip;
    public final CommonSwitchView viewSilentReturn;
    public final CommonTitleView viewTitle;

    public abstract void setSettingSecurityModel(SettingSecurityModel settingSecurityModel);

    protected ViewLayoutSettingSecurity1Binding(Object obj, View view, int i, BatteryCircleProgressView batteryCircleProgressView, LinearLayout linearLayout, RelativeLayout relativeLayout, CommonSelectionView commonSelectionView, CommonSwitchView commonSwitchView, CommonSelectionView commonSelectionView2, CommonSelectionView commonSelectionView3, CursorEditText cursorEditText, CursorEditText cursorEditText2, CursorEditText cursorEditText3, ImageView imageView, ConstraintLayout constraintLayout, ScrollView scrollView, View view2, View view3, View view4, View view5, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, ImageButton imageButton, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, CommonSwitchView commonSwitchView2, CommonSwitchView commonSwitchView3, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.batteryProgressView = batteryCircleProgressView;
        this.bgBattery = linearLayout;
        this.constraintlayoutFlightFence = relativeLayout;
        this.crv = commonSelectionView;
        this.csvBeginner = commonSwitchView;
        this.csvLost = commonSelectionView2;
        this.csvUnit = commonSelectionView3;
        this.edtDistanceLimit = cursorEditText;
        this.edtHeightLimit = cursorEditText2;
        this.edtReturnHeight = cursorEditText3;
        this.ivPlayReturnHeightVideo = imageView;
        this.layoutBattery = constraintLayout;
        this.layoutSetting = scrollView;
        this.line1 = view2;
        this.line2 = view3;
        this.line3 = view4;
        this.line4 = view5;
        this.rlLost = relativeLayout2;
        this.rlUnit = relativeLayout3;
        this.seekbarDistanceLimit = customSeekbar;
        this.seekbarHeightLimit = customSeekbar2;
        this.switchBtnNoLimit = switchButton;
        this.tvAltitudeCarefulTips = textView;
        this.tvBatteryInfo = textView2;
        this.tvCurrent = textView3;
        this.tvCurrentValue = textView4;
        this.tvCycleTimeTips = textView5;
        this.tvDistanceLimit = textView6;
        this.tvFlightFence = textView7;
        this.tvHeightLimit = textView8;
        this.tvHeightNoLimit = textView9;
        this.tvLostActionWarning = textView10;
        this.tvLostChild = textView11;
        this.tvLostChildFunction = imageButton;
        this.tvReturnHeight = textView12;
        this.tvSignalLost = textView13;
        this.tvSpeedChange = textView14;
        this.tvSpeedSetting = textView15;
        this.tvTempValue = textView16;
        this.tvTemperatureTips = textView17;
        this.tvUnit = textView18;
        this.tvUnitDistanceLimit = textView19;
        this.tvUnitHeightLimit = textView20;
        this.tvVoltage = textView21;
        this.tvVoltageTips = textView22;
        this.viewFightTip = commonSwitchView2;
        this.viewSilentReturn = commonSwitchView3;
        this.viewTitle = commonTitleView;
    }

    public SettingSecurityModel getSettingSecurityModel() {
        return this.mSettingSecurityModel;
    }

    public static ViewLayoutSettingSecurity1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurity1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingSecurity1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_security1, viewGroup, z, obj);
    }

    public static ViewLayoutSettingSecurity1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurity1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingSecurity1Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_security1, null, false, obj);
    }

    public static ViewLayoutSettingSecurity1Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingSecurity1Binding bind(View view, Object obj) {
        return (ViewLayoutSettingSecurity1Binding) bind(obj, view, R.layout.view_layout_setting_security1);
    }
}
