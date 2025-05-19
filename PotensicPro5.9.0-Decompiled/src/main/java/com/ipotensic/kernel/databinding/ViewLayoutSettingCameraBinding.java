package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingCameraModel;
import com.ipotensic.kernel.view.CommonSelectionView;
import com.ipotensic.kernel.view.CommonTitleView;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingCameraBinding extends ViewDataBinding {
    public final CursorEditText edtWhiteBalance;
    public final CommonSelectionView gridLayout;
    public final ScrollView layoutSetting;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;

    @Bindable
    protected SettingCameraModel mSettingCameraModel;
    public final SwitchButton sbWater;
    public final CustomSeekbar sbWhiteBalance;
    public final CommonSelectionView segRecLayout;
    public final View spaceGeneral;
    public final SwitchButton switchBtnPhotoGpsLocation;
    public final TextView tvAutoWhiteBalance;
    public final TextView tvAuxLine;
    public final TextView tvFormat;
    public final TextView tvGeneralSetting;
    public final TextView tvOthers;
    public final TextView tvPhotoLocationTips;
    public final TextView tvRemainTips;
    public final TextView tvSdCard;
    public final TextView tvSdCardOption;
    public final TextView tvSeg;
    public final TextView tvWaterMark;
    public final TextView tvWhiteBalanceTip;
    public final View viewGeneralSettings;
    public final View viewOthers;
    public final View viewSdCard;
    public final CommonTitleView viewTitle;

    public abstract void setSettingCameraModel(SettingCameraModel settingCameraModel);

    protected ViewLayoutSettingCameraBinding(Object obj, View view, int i, CursorEditText cursorEditText, CommonSelectionView commonSelectionView, ScrollView scrollView, View view2, View view3, View view4, View view5, SwitchButton switchButton, CustomSeekbar customSeekbar, CommonSelectionView commonSelectionView2, View view6, SwitchButton switchButton2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, View view7, View view8, View view9, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.edtWhiteBalance = cursorEditText;
        this.gridLayout = commonSelectionView;
        this.layoutSetting = scrollView;
        this.line1 = view2;
        this.line2 = view3;
        this.line3 = view4;
        this.line4 = view5;
        this.sbWater = switchButton;
        this.sbWhiteBalance = customSeekbar;
        this.segRecLayout = commonSelectionView2;
        this.spaceGeneral = view6;
        this.switchBtnPhotoGpsLocation = switchButton2;
        this.tvAutoWhiteBalance = textView;
        this.tvAuxLine = textView2;
        this.tvFormat = textView3;
        this.tvGeneralSetting = textView4;
        this.tvOthers = textView5;
        this.tvPhotoLocationTips = textView6;
        this.tvRemainTips = textView7;
        this.tvSdCard = textView8;
        this.tvSdCardOption = textView9;
        this.tvSeg = textView10;
        this.tvWaterMark = textView11;
        this.tvWhiteBalanceTip = textView12;
        this.viewGeneralSettings = view7;
        this.viewOthers = view8;
        this.viewSdCard = view9;
        this.viewTitle = commonTitleView;
    }

    public SettingCameraModel getSettingCameraModel() {
        return this.mSettingCameraModel;
    }

    public static ViewLayoutSettingCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCameraBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingCameraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_camera, viewGroup, z, obj);
    }

    public static ViewLayoutSettingCameraBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCameraBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingCameraBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_camera, null, false, obj);
    }

    public static ViewLayoutSettingCameraBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingCameraBinding bind(View view, Object obj) {
        return (ViewLayoutSettingCameraBinding) bind(obj, view, R.layout.view_layout_setting_camera);
    }
}
