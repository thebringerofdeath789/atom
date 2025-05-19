package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.view.CountDownView;

/* loaded from: classes2.dex */
public abstract class ViewBigPackageUpgradeFinishedBinding extends ViewDataBinding {
    public final ImageButton btnUpgradeFinishedClose;
    public final ImageView ivUpgradeSuccess;
    public final ConstraintLayout layoutUpgradeFinished;
    public final TextView tvTips;
    public final TextView tvTitle;
    public final CountDownView tvUpgradeFinishedCountDown;

    protected ViewBigPackageUpgradeFinishedBinding(Object obj, View view, int i, ImageButton imageButton, ImageView imageView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, CountDownView countDownView) {
        super(obj, view, i);
        this.btnUpgradeFinishedClose = imageButton;
        this.ivUpgradeSuccess = imageView;
        this.layoutUpgradeFinished = constraintLayout;
        this.tvTips = textView;
        this.tvTitle = textView2;
        this.tvUpgradeFinishedCountDown = countDownView;
    }

    public static ViewBigPackageUpgradeFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageUpgradeFinishedBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewBigPackageUpgradeFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_big_package_upgrade_finished, viewGroup, z, obj);
    }

    public static ViewBigPackageUpgradeFinishedBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageUpgradeFinishedBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewBigPackageUpgradeFinishedBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_big_package_upgrade_finished, null, false, obj);
    }

    public static ViewBigPackageUpgradeFinishedBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewBigPackageUpgradeFinishedBinding bind(View view, Object obj) {
        return (ViewBigPackageUpgradeFinishedBinding) bind(obj, view, R.layout.view_big_package_upgrade_finished);
    }
}
