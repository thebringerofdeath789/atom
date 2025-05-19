package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.calibration.SettingRemoterCalibrationModel;
import com.ipotensic.kernel.view.CalRockerView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutRemoterControllerCalibrationBinding extends ViewDataBinding {
    public final Button btnStartCal;
    public final CalRockerView calRockerViewLeft;
    public final CalRockerView calRockerViewRight;
    public final ConstraintLayout clCalibrationResult;
    public final ImageView imgIcon;
    public final ImageView imgLeftWheel;
    public final ImageView imgRightWheel;
    public final ImageView imgWheelSegment;
    public final ImageView ivCalibrationResult;
    public final ImageView ivClose;
    public final ConstraintLayout layoutCalStep1;
    public final ConstraintLayout layoutCalStep2;
    public final LinearLayout layoutWheel;

    @Bindable
    protected SettingRemoterCalibrationModel mRemoterControllerModel;
    public final TextView tvCountDown;
    public final TextView tvResultTitle;
    public final TextView tvRockerTips;
    public final TextView tvTitle;
    public final TextView tvTitle1;
    public final TextView tvWheelTips;

    public abstract void setRemoterControllerModel(SettingRemoterCalibrationModel settingRemoterCalibrationModel);

    protected ViewLayoutRemoterControllerCalibrationBinding(Object obj, View view, int i, Button button, CalRockerView calRockerView, CalRockerView calRockerView2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.btnStartCal = button;
        this.calRockerViewLeft = calRockerView;
        this.calRockerViewRight = calRockerView2;
        this.clCalibrationResult = constraintLayout;
        this.imgIcon = imageView;
        this.imgLeftWheel = imageView2;
        this.imgRightWheel = imageView3;
        this.imgWheelSegment = imageView4;
        this.ivCalibrationResult = imageView5;
        this.ivClose = imageView6;
        this.layoutCalStep1 = constraintLayout2;
        this.layoutCalStep2 = constraintLayout3;
        this.layoutWheel = linearLayout;
        this.tvCountDown = textView;
        this.tvResultTitle = textView2;
        this.tvRockerTips = textView3;
        this.tvTitle = textView4;
        this.tvTitle1 = textView5;
        this.tvWheelTips = textView6;
    }

    public SettingRemoterCalibrationModel getRemoterControllerModel() {
        return this.mRemoterControllerModel;
    }

    public static ViewLayoutRemoterControllerCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRemoterControllerCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutRemoterControllerCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_remoter_controller_calibration, viewGroup, z, obj);
    }

    public static ViewLayoutRemoterControllerCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRemoterControllerCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutRemoterControllerCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_remoter_controller_calibration, null, false, obj);
    }

    public static ViewLayoutRemoterControllerCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutRemoterControllerCalibrationBinding bind(View view, Object obj) {
        return (ViewLayoutRemoterControllerCalibrationBinding) bind(obj, view, R.layout.view_layout_remoter_controller_calibration);
    }
}
