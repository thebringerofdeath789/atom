package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public abstract class ViewLayoutTestMaintainBinding extends ViewDataBinding {
    public final EditText etTestTime;
    public final EditText etThreshold;
    public final ConstraintLayout layoutTestMaintain;
    public final TextView tvNotice;
    public final TextView tvResult;
    public final TextView tvTest;
    public final TextView tvTestTime;
    public final TextView tvThreshold;
    public final TextView tvTitle;
    public final TextView xAxis;
    public final TextView yAxis;
    public final TextView zAxis;

    protected ViewLayoutTestMaintainBinding(Object obj, View view, int i, EditText editText, EditText editText2, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i);
        this.etTestTime = editText;
        this.etThreshold = editText2;
        this.layoutTestMaintain = constraintLayout;
        this.tvNotice = textView;
        this.tvResult = textView2;
        this.tvTest = textView3;
        this.tvTestTime = textView4;
        this.tvThreshold = textView5;
        this.tvTitle = textView6;
        this.xAxis = textView7;
        this.yAxis = textView8;
        this.zAxis = textView9;
    }

    public static ViewLayoutTestMaintainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestMaintainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutTestMaintainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_test_maintain, viewGroup, z, obj);
    }

    public static ViewLayoutTestMaintainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestMaintainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutTestMaintainBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_layout_test_maintain, null, false, obj);
    }

    public static ViewLayoutTestMaintainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutTestMaintainBinding bind(View view, Object obj) {
        return (ViewLayoutTestMaintainBinding) bind(obj, view, R.layout.view_layout_test_maintain);
    }
}
