package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel;
import com.ipotensic.kernel.view.CursorStringEditText;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutGimbalFineTuningBinding extends ViewDataBinding {
    public final ImageButton btnClose;
    public final ImageButton btnPlusLevel;
    public final ImageButton btnPlusYaw;
    public final ImageButton btnReduceLevel;
    public final ImageButton btnReduceYaw;
    public final CursorStringEditText etLevelValue;
    public final CursorStringEditText etYawValue;
    public final LinearLayout llLevel;

    @Bindable
    protected SettingGimbalFineTuningModel mGimbalFineTuningModel;
    public final TextView tvCountDown;
    public final TextView tvDefaultValueLevel;
    public final TextView tvDefaultValueYaw;
    public final TextView tvLevel;
    public final TextView tvYaw;
    public final View viewLine;
    public final JfGLSurfaceView viewVideo;

    public abstract void setGimbalFineTuningModel(SettingGimbalFineTuningModel settingGimbalFineTuningModel);

    protected ViewLayoutGimbalFineTuningBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, CursorStringEditText cursorStringEditText, CursorStringEditText cursorStringEditText2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, JfGLSurfaceView jfGLSurfaceView) {
        super(obj, view, i);
        this.btnClose = imageButton;
        this.btnPlusLevel = imageButton2;
        this.btnPlusYaw = imageButton3;
        this.btnReduceLevel = imageButton4;
        this.btnReduceYaw = imageButton5;
        this.etLevelValue = cursorStringEditText;
        this.etYawValue = cursorStringEditText2;
        this.llLevel = linearLayout;
        this.tvCountDown = textView;
        this.tvDefaultValueLevel = textView2;
        this.tvDefaultValueYaw = textView3;
        this.tvLevel = textView4;
        this.tvYaw = textView5;
        this.viewLine = view2;
        this.viewVideo = jfGLSurfaceView;
    }

    public SettingGimbalFineTuningModel getGimbalFineTuningModel() {
        return this.mGimbalFineTuningModel;
    }

    public static ViewLayoutGimbalFineTuningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalFineTuningBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutGimbalFineTuningBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_gimbal_fine_tuning, viewGroup, z, obj);
    }

    public static ViewLayoutGimbalFineTuningBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalFineTuningBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutGimbalFineTuningBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_gimbal_fine_tuning, null, false, obj);
    }

    public static ViewLayoutGimbalFineTuningBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutGimbalFineTuningBinding bind(View view, Object obj) {
        return (ViewLayoutGimbalFineTuningBinding) bind(obj, view, C1965R.layout.view_layout_gimbal_fine_tuning);
    }
}