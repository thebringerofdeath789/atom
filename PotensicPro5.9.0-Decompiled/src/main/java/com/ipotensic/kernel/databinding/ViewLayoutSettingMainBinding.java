package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingMainBinding extends ViewDataBinding {
    public final FrameLayout flContent;
    public final NestedScrollView layoutSetting;
    public final RadioGroup rgSetting;
    public final RadioButton tvAbout;
    public final RadioButton tvCalibration;
    public final RadioButton tvCamera;
    public final RadioButton tvControl;
    public final RadioButton tvImageTrans;
    public final RadioButton tvSecurity;
    public final TextView tvSettingTitle;
    public final FrameLayout viewSetting;

    protected ViewLayoutSettingMainBinding(Object obj, View view, int i, FrameLayout frameLayout, NestedScrollView nestedScrollView, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView, FrameLayout frameLayout2) {
        super(obj, view, i);
        this.flContent = frameLayout;
        this.layoutSetting = nestedScrollView;
        this.rgSetting = radioGroup;
        this.tvAbout = radioButton;
        this.tvCalibration = radioButton2;
        this.tvCamera = radioButton3;
        this.tvControl = radioButton4;
        this.tvImageTrans = radioButton5;
        this.tvSecurity = radioButton6;
        this.tvSettingTitle = textView;
        this.viewSetting = frameLayout2;
    }

    public static ViewLayoutSettingMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_main, viewGroup, z, obj);
    }

    public static ViewLayoutSettingMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingMainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_setting_main, null, false, obj);
    }

    public static ViewLayoutSettingMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMainBinding bind(View view, Object obj) {
        return (ViewLayoutSettingMainBinding) bind(obj, view, R.layout.view_layout_setting_main);
    }
}
