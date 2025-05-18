package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.model.calibration.SettingPairDroneModel;

/* loaded from: classes2.dex */
public abstract class ViewLayoutPairDroneAgainBinding extends ViewDataBinding {
    public final RelativeLayout btnBottom;
    public final ConstraintLayout clPairResult;
    public final ConstraintLayout clStartPair;
    public final ImageView ivClose;
    public final ImageView ivClose2;
    public final ImageView ivPairFail;
    public final ImageView ivRepairGif;

    @Bindable
    protected SettingPairDroneModel mPairDroneModel;
    public final TextView tvCodeStep;
    public final TextView tvCodeStepTwo;
    public final TextView tvCountDown;
    public final TextView tvRepairFailTitle;
    public final TextView tvRepairTitle;

    public abstract void setPairDroneModel(SettingPairDroneModel settingPairDroneModel);

    protected ViewLayoutPairDroneAgainBinding(Object obj, View view, int i, RelativeLayout relativeLayout, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.btnBottom = relativeLayout;
        this.clPairResult = constraintLayout;
        this.clStartPair = constraintLayout2;
        this.ivClose = imageView;
        this.ivClose2 = imageView2;
        this.ivPairFail = imageView3;
        this.ivRepairGif = imageView4;
        this.tvCodeStep = textView;
        this.tvCodeStepTwo = textView2;
        this.tvCountDown = textView3;
        this.tvRepairFailTitle = textView4;
        this.tvRepairTitle = textView5;
    }

    public SettingPairDroneModel getPairDroneModel() {
        return this.mPairDroneModel;
    }

    public static ViewLayoutPairDroneAgainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutPairDroneAgainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewLayoutPairDroneAgainBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_pair_drone_again, viewGroup, z, obj);
    }

    public static ViewLayoutPairDroneAgainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutPairDroneAgainBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewLayoutPairDroneAgainBinding) ViewDataBinding.inflateInternal(layoutInflater, C1965R.layout.view_layout_pair_drone_again, null, false, obj);
    }

    public static ViewLayoutPairDroneAgainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewLayoutPairDroneAgainBinding bind(View view, Object obj) {
        return (ViewLayoutPairDroneAgainBinding) bind(obj, view, C1965R.layout.view_layout_pair_drone_again);
    }
}