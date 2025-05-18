package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.SettingImageTransModel;

/* loaded from: classes2.dex */
public abstract class ViewLayoutSettingImageTransBinding extends ViewDataBinding {

    @Bindable
    protected SettingImageTransModel mSettingSecurityModel;

    public abstract void setSettingSecurityModel(SettingImageTransModel settingImageTransModel);

    protected ViewLayoutSettingImageTransBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public SettingImageTransModel getSettingSecurityModel() {
        return this.mSettingSecurityModel;
    }

    public static ViewLayoutSettingImageTransBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingImageTransBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutSettingImageTransBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_setting_image_trans, viewGroup, z, obj);
    }

    public static ViewLayoutSettingImageTransBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingImageTransBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutSettingImageTransBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_setting_image_trans, null, false, obj);
    }

    public static ViewLayoutSettingImageTransBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutSettingImageTransBinding bind(View view, Object obj) {
        return (ViewLayoutSettingImageTransBinding) bind(obj, view, C1965R.layout.view_layout_setting_image_trans);
    }
}