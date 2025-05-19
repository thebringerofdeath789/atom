package com.ipotensic.potensicpro.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.view.mapscaleview.MapScaleView;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.viewmodel.FindDroneViewModel;
import com.mapbox.mapboxsdk.maps.MapView;

/* loaded from: classes2.dex */
public abstract class ActivityFindMyDroneBinding extends ViewDataBinding {
    public final ConstraintLayout btnStartBeep;
    public final ImageView imgSpeakerBeep;
    public final ImageView ivBack;
    public final ImageView ivSearch;

    @Bindable
    protected FindDroneViewModel mFindDroneViewModel;
    public final MapView mapView;
    public final MapScaleView scaleView;
    public final Toolbar toolbar;
    public final TextView tvCodeTitle;
    public final ConstraintLayout tvIconStartBeep;
    public final TextView tvStartBeep;

    public abstract void setFindDroneViewModel(FindDroneViewModel findDroneViewModel);

    protected ActivityFindMyDroneBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, MapView mapView, MapScaleView mapScaleView, Toolbar toolbar, TextView textView, ConstraintLayout constraintLayout2, TextView textView2) {
        super(obj, view, i);
        this.btnStartBeep = constraintLayout;
        this.imgSpeakerBeep = imageView;
        this.ivBack = imageView2;
        this.ivSearch = imageView3;
        this.mapView = mapView;
        this.scaleView = mapScaleView;
        this.toolbar = toolbar;
        this.tvCodeTitle = textView;
        this.tvIconStartBeep = constraintLayout2;
        this.tvStartBeep = textView2;
    }

    public FindDroneViewModel getFindDroneViewModel() {
        return this.mFindDroneViewModel;
    }

    public static ActivityFindMyDroneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFindMyDroneBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityFindMyDroneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_find_my_drone, viewGroup, z, obj);
    }

    public static ActivityFindMyDroneBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFindMyDroneBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityFindMyDroneBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_find_my_drone, null, false, obj);
    }

    public static ActivityFindMyDroneBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityFindMyDroneBinding bind(View view, Object obj) {
        return (ActivityFindMyDroneBinding) bind(obj, view, R.layout.activity_find_my_drone);
    }
}
