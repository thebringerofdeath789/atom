package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public abstract class ViewLayoutFactoryTestBinding extends ViewDataBinding {
    public final LinearLayout llTest;
    public final CommonSwitchView viewCameraTest;
    public final CommonSwitchView viewFactoryTest;
    public final CommonSwitchView viewFpvTest;
    public final CommonSwitchView viewGpsSignalTest;
    public final CommonSwitchView viewImuCal;
    public final CommonSwitchView viewLocationTest;
    public final CommonSwitchView viewMaintainTest;
    public final CommonSwitchView viewOfficeTest;
    public final CommonSwitchView viewOpenGpsTest;
    public final CommonSwitchView viewOpenModelTest;
    public final CommonTitleView viewTitle;

    protected ViewLayoutFactoryTestBinding(Object obj, View view, int i, LinearLayout linearLayout, CommonSwitchView commonSwitchView, CommonSwitchView commonSwitchView2, CommonSwitchView commonSwitchView3, CommonSwitchView commonSwitchView4, CommonSwitchView commonSwitchView5, CommonSwitchView commonSwitchView6, CommonSwitchView commonSwitchView7, CommonSwitchView commonSwitchView8, CommonSwitchView commonSwitchView9, CommonSwitchView commonSwitchView10, CommonTitleView commonTitleView) {
        super(obj, view, i);
        this.llTest = linearLayout;
        this.viewCameraTest = commonSwitchView;
        this.viewFactoryTest = commonSwitchView2;
        this.viewFpvTest = commonSwitchView3;
        this.viewGpsSignalTest = commonSwitchView4;
        this.viewImuCal = commonSwitchView5;
        this.viewLocationTest = commonSwitchView6;
        this.viewMaintainTest = commonSwitchView7;
        this.viewOfficeTest = commonSwitchView8;
        this.viewOpenGpsTest = commonSwitchView9;
        this.viewOpenModelTest = commonSwitchView10;
        this.viewTitle = commonTitleView;
    }

    public static ViewLayoutFactoryTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutFactoryTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutFactoryTestBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_factory_test, viewGroup, z, obj);
    }

    public static ViewLayoutFactoryTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutFactoryTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutFactoryTestBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_factory_test, null, false, obj);
    }

    public static ViewLayoutFactoryTestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutFactoryTestBinding bind(View view, Object obj) {
        return (ViewLayoutFactoryTestBinding) bind(obj, view, C1965R.layout.view_layout_factory_test);
    }
}