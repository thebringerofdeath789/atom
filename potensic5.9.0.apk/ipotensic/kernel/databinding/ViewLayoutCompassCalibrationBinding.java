package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel;

/* loaded from: classes2.dex */
public abstract class ViewLayoutCompassCalibrationBinding extends ViewDataBinding {
    public final ImageButton btnClose;
    public final Button btnStart;
    public final ConstraintLayout clCalibrationResult;
    public final ConstraintLayout clCalibrationStart;
    public final ConstraintLayout clCompassCalibration;
    public final ImageView imgAtom;
    public final ImageView ivCalibrationResult;
    public final ImageView ivMiniGeoStepTips;
    public final ImageView ivRotatingAxis;

    @Bindable
    protected SettingCompassCalibrationModel mCompassCalibrationModel;
    public final ImageView picCompassCalibration;
    public final TextView tvCompassHeightTip;
    public final TextView tvCompassTitle;
    public final TextView tvCountDown;
    public final TextView tvFailNotice;
    public final TextView tvMiniGeoStepTips;

    public abstract void setCompassCalibrationModel(SettingCompassCalibrationModel settingCompassCalibrationModel);

    protected ViewLayoutCompassCalibrationBinding(Object obj, View view, int i, ImageButton imageButton, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.btnClose = imageButton;
        this.btnStart = button;
        this.clCalibrationResult = constraintLayout;
        this.clCalibrationStart = constraintLayout2;
        this.clCompassCalibration = constraintLayout3;
        this.imgAtom = imageView;
        this.ivCalibrationResult = imageView2;
        this.ivMiniGeoStepTips = imageView3;
        this.ivRotatingAxis = imageView4;
        this.picCompassCalibration = imageView5;
        this.tvCompassHeightTip = textView;
        this.tvCompassTitle = textView2;
        this.tvCountDown = textView3;
        this.tvFailNotice = textView4;
        this.tvMiniGeoStepTips = textView5;
    }

    public SettingCompassCalibrationModel getCompassCalibrationModel() {
        return this.mCompassCalibrationModel;
    }

    public static ViewLayoutCompassCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutCompassCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutCompassCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_compass_calibration, viewGroup, z, obj);
    }

    public static ViewLayoutCompassCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutCompassCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutCompassCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_compass_calibration, null, false, obj);
    }

    public static ViewLayoutCompassCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutCompassCalibrationBinding bind(View view, Object obj) {
        return (ViewLayoutCompassCalibrationBinding) bind(obj, view, R.layout.view_layout_compass_calibration);
    }
}