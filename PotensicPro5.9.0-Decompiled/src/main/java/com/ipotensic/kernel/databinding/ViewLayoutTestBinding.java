package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class ViewLayoutTestBinding extends ViewDataBinding {
    protected ViewLayoutTestBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    public static ViewLayoutTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_test, viewGroup, z, obj);
    }

    public static ViewLayoutTestBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutTestBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_test, null, false, obj);
    }

    public static ViewLayoutTestBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestBinding bind(View view, Object obj) {
        return (ViewLayoutTestBinding) bind(obj, view, R.layout.view_layout_test);
    }
}
