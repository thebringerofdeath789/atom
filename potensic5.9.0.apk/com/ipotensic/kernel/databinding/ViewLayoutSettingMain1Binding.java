package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.SettingMainModel;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingMain1Binding extends ViewDataBinding {
    public final FrameLayout flContent;
    public final NestedScrollView layoutSetting;

    @Bindable
    protected SettingMainModel mSettingMainModel;
    public final RadioGroup rgSetting;
    public final RadioButton tvAbout;
    public final RadioButton tvCalibration;
    public final RadioButton tvCamera;
    public final RadioButton tvControl;
    public final RadioButton tvImageTrans;
    public final RadioButton tvSecurity;
    public final TextView tvSettingTitle;
    public final ConstraintLayout viewSetting;

    public abstract void setSettingMainModel(SettingMainModel settingMainModel);

    protected ViewLayoutSettingMain1Binding(Object obj, View view, int i, FrameLayout frameLayout, NestedScrollView nestedScrollView, RadioGroup radioGroup, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5, RadioButton radioButton6, TextView textView, ConstraintLayout constraintLayout) {
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
        this.viewSetting = constraintLayout;
    }

    public SettingMainModel getSettingMainModel() {
        return this.mSettingMainModel;
    }

    public static ViewLayoutSettingMain1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMain1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingMain1Binding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_setting_main1, viewGroup, z, obj);
    }

    public static ViewLayoutSettingMain1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMain1Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingMain1Binding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_setting_main1, null, false, obj);
    }

    public static ViewLayoutSettingMain1Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingMain1Binding bind(View view, Object obj) {
        return (ViewLayoutSettingMain1Binding) bind(obj, view, C1965R.layout.view_layout_setting_main1);
    }
}