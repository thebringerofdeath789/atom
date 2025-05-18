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
    public final LinearLayout bgFlySafety;
    public final View bgUnit;
    public final ConstraintLayout constraintlayoutFlightFence;
    public final CommonSelectionView crv;
    public final CommonSwitchView csvBeginner;
    public final CommonSelectionView csvLost;
    public final CommonSelectionView csvUnit;
    public final CommonSwitchView cswStop;
    public final CursorEditText edtDistanceLimit;
    public final CursorEditText edtHeightLimit;
    public final CursorEditText edtReturnHeight;
    public final ImageView ivPlayReturnHeightVideo;
    public final LinearLayout layoutDistanceLimit;
    public final ConstraintLayout layoutFence;
    public final LinearLayout layoutFlightFence;
    public final LinearLayout layoutReturnHeight;
    public final ScrollView layoutSetting;
    public final LinearLayout layoutUom;
    public final LinearLayout layoutUomExpend;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;
    public final View line5;

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
    public final TextView tvFlightRouteUploadRecord;
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
    public final TextView tvUomExpand;
    public final TextView tvUomTips;
    public final TextView tvUploadState;
    public final CommonSwitchView viewFightTip;
    public final CommonSwitchView viewSilentReturn;
    public final CommonTitleView viewTitle;
    public final ViewStubProxy vsBattery;

    public abstract void setSettingSecurityModel(SettingSecurityModel settingSecurityModel);

    protected ViewLayoutSettingSecurityBinding(Object obj, View view, int i, Guideline guideline, Guideline guideline2, LinearLayout linearLayout, LinearLayout linearLayout2, View view2, ConstraintLayout constraintLayout, CommonSelectionView commonSelectionView, CommonSwitchView commonSwitchView, CommonSelectionView commonSelectionView2, CommonSelectionView commonSelectionView3, CommonSwitchView commonSwitchView2, CursorEditText cursorEditText, CursorEditText cursorEditText2, CursorEditText cursorEditText3, ImageView imageView, LinearLayout linearLayout3, ConstraintLayout constraintLayout2, LinearLayout linearLayout4, LinearLayout linearLayout5, ScrollView scrollView, LinearLayout linearLayout6, LinearLayout linearLayout7, View view3, View view4, View view5, View view6, View view7, CustomSeekbar customSeekbar, CustomSeekbar customSeekbar2, View view8, SwitchButton switchButton, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, ImageButton imageButton, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, CommonSwitchView commonSwitchView3, CommonSwitchView commonSwitchView4, CommonTitleView commonTitleView, ViewStubProxy viewStubProxy) {
        super(obj, view, i);
        this.baseLineLeft = guideline;
        this.baseLineRight = guideline2;
        this.bgBattery = linearLayout;
        this.bgFlySafety = linearLayout2;
        this.bgUnit = view2;
        this.constraintlayoutFlightFence = constraintLayout;
        this.crv = commonSelectionView;
        this.csvBeginner = commonSwitchView;
        this.csvLost = commonSelectionView2;
        this.csvUnit = commonSelectionView3;
        this.cswStop = commonSwitchView2;
        this.edtDistanceLimit = cursorEditText;
        this.edtHeightLimit = cursorEditText2;
        this.edtReturnHeight = cursorEditText3;
        this.ivPlayReturnHeightVideo = imageView;
        this.layoutDistanceLimit = linearLayout3;
        this.layoutFence = constraintLayout2;
        this.layoutFlightFence = linearLayout4;
        this.layoutReturnHeight = linearLayout5;
        this.layoutSetting = scrollView;
        this.layoutUom = linearLayout6;
        this.layoutUomExpend = linearLayout7;
        this.line1 = view3;
        this.line2 = view4;
        this.line3 = view5;
        this.line4 = view6;
        this.line5 = view7;
        this.seekbarDistanceLimit = customSeekbar;
        this.seekbarHeightLimit = customSeekbar2;
        this.spaceUnit = view8;
        this.switchBtnNoLimit = switchButton;
        this.tvAltitudeCarefulTips = textView;
        this.tvBatteryInfo = textView2;
        this.tvDistanceLimit = textView3;
        this.tvFlightFence = textView4;
        this.tvFlightRouteUploadRecord = textView5;
        this.tvHeightLimit = textView6;
        this.tvHeightNoLimit = textView7;
        this.tvLostActionWarning = textView8;
        this.tvLostChild = textView9;
        this.tvLostChildFunction = imageButton;
        this.tvReturnHeight = textView10;
        this.tvSignalLost = textView11;
        this.tvSpeedChange = textView12;
        this.tvSpeedSetting = textView13;
        this.tvUnit = textView14;
        this.tvUnitDistanceLimit = textView15;
        this.tvUnitHeightLimit = textView16;
        this.tvUomExpand = textView17;
        this.tvUomTips = textView18;
        this.tvUploadState = textView19;
        this.viewFightTip = commonSwitchView3;
        this.viewSilentReturn = commonSwitchView4;
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