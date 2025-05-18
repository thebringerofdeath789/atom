package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.calibration.SettingGimbalCalibrationModel;
import com.ipotensic.kernel.view.ProgressLoadingView;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutGimbalCalibrationBinding extends ViewDataBinding {
    public final ImageButton btnClose;
    public final Button btnStartGimbalCalibration;
    public final ImageView ivGimbalCalibrationSuccess;
    public final ProgressLoadingView loadingView;

    @Bindable
    protected SettingGimbalCalibrationModel mGimbalCalibrationModel;
    public final ImageView picGimbalCalibration;
    public final TextView tvCountDown;
    public final TextView tvGimbalCalibrationTips1;
    public final TextView tvGimbalCalibrationTips2;
    public final TextView tvGimbalResultTips;
    public final TextView tvGimbalTitle;
    public final JfGLSurfaceView viewVideo;

    public abstract void setGimbalCalibrationModel(SettingGimbalCalibrationModel settingGimbalCalibrationModel);

    protected ViewLayoutGimbalCalibrationBinding(Object obj, View view, int i, ImageButton imageButton, Button button, ImageView imageView, ProgressLoadingView progressLoadingView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, JfGLSurfaceView jfGLSurfaceView) {
        super(obj, view, i);
        this.btnClose = imageButton;
        this.btnStartGimbalCalibration = button;
        this.ivGimbalCalibrationSuccess = imageView;
        this.loadingView = progressLoadingView;
        this.picGimbalCalibration = imageView2;
        this.tvCountDown = textView;
        this.tvGimbalCalibrationTips1 = textView2;
        this.tvGimbalCalibrationTips2 = textView3;
        this.tvGimbalResultTips = textView4;
        this.tvGimbalTitle = textView5;
        this.viewVideo = jfGLSurfaceView;
    }

    public SettingGimbalCalibrationModel getGimbalCalibrationModel() {
        return this.mGimbalCalibrationModel;
    }

    public static ViewLayoutGimbalCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalCalibrationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutGimbalCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_gimbal_calibration, viewGroup, z, obj);
    }

    public static ViewLayoutGimbalCalibrationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalCalibrationBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutGimbalCalibrationBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_gimbal_calibration, null, false, obj);
    }

    public static ViewLayoutGimbalCalibrationBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalCalibrationBinding bind(View view, Object obj) {
        return (ViewLayoutGimbalCalibrationBinding) bind(obj, view, C1965R.layout.view_layout_gimbal_calibration);
    }
}