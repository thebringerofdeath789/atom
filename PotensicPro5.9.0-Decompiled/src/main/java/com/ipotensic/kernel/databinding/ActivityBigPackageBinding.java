package com.ipotensic.kernel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.BigPackageViewModel;
import com.ipotensic.kernel.view.BigPackageDownloadUpgradeView;
import com.ipotensic.kernel.view.BigPackageModuleDetectionView;
import com.ipotensic.kernel.view.BigPackageSingleFirmwareProgressView;
import com.ipotensic.kernel.view.CountDownView;

/* loaded from: classes2.dex */
public abstract class ActivityBigPackageBinding extends ViewDataBinding {
    public final ImageButton btnClose;
    public final ConstraintLayout clConnectedState;
    public final ConstraintLayout clPlaneBatteryLow;
    public final ConstraintLayout clPlaneHighTemp;
    public final ConstraintLayout clPlaneUnlock;
    public final ConstraintLayout clRemoteBatteryLow;
    public final ConstraintLayout clSdState;
    public final FrameLayout fragmentUpgradeQuestion;
    public final ImageView ivConnected;
    public final ImageView ivFirmwareState;
    public final ImageView ivHighTemp;
    public final ImageView ivPlane;
    public final ImageView ivRemote;
    public final ImageView ivSd;
    public final ImageView ivUnlock;
    public final ConstraintLayout layoutBigPackageDownloadUpgrade;
    public final LinearLayout layoutNotConditions;
    public final LinearLayout layoutNotNetwork;
    public final ViewBigPackageFwTransferFailBinding layoutTransferFail;
    public final LinearLayout layoutUpgradeConsiderations;
    public final ViewBigPackageUpgradeFinishedBinding layoutUpgradeFinished;
    public final LinearLayout layoutUpgradeState;
    public final TextView lineConnected;
    public final TextView lineHighTemp;
    public final TextView linePlane;
    public final TextView lineRemote;
    public final TextView lineSd;
    public final TextView lineUnlock;

    @Bindable
    protected BigPackageViewModel mBigPackageViewModel;
    public final LinearLayout scrollViewCheckCondition;
    public final ScrollView scrollViewDownloadTips;
    public final ScrollView scrollViewUpgradeTips;
    public final TextView tvConnectedState;
    public final CountDownView tvCountDown;
    public final TextView tvCurrentDetectionModule;
    public final TextView tvDownloadConsiderationsContent;
    public final TextView tvDownloadTips;
    public final TextView tvFirmwareName;
    public final TextView tvFirmwareState;
    public final TextView tvFirmwareVersion;
    public final TextView tvFormatSd;
    public final TextView tvPlaneBatteryLow;
    public final TextView tvPlaneHighTemp;
    public final TextView tvPlaneUnlock;
    public final TextView tvRemoteBatteryLow;
    public final TextView tvSdState;
    public final TextView tvSingleFwUpgradeProgress;
    public final TextView tvTitle;
    public final TextView tvUpgradeConsiderationsContent;
    public final TextView tvUpgradeDetail;
    public final BigPackageDownloadUpgradeView viewBigPackageDownloadUpgrade;
    public final BigPackageModuleDetectionView viewBigPackageModuleDetection;
    public final BigPackageSingleFirmwareProgressView viewSingleFirmwareProgress;

    public abstract void setBigPackageViewModel(BigPackageViewModel bigPackageViewModel);

    protected ActivityBigPackageBinding(Object obj, View view, int i, ImageButton imageButton, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ConstraintLayout constraintLayout7, LinearLayout linearLayout, LinearLayout linearLayout2, ViewBigPackageFwTransferFailBinding viewBigPackageFwTransferFailBinding, LinearLayout linearLayout3, ViewBigPackageUpgradeFinishedBinding viewBigPackageUpgradeFinishedBinding, LinearLayout linearLayout4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, LinearLayout linearLayout5, ScrollView scrollView, ScrollView scrollView2, TextView textView7, CountDownView countDownView, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, BigPackageDownloadUpgradeView bigPackageDownloadUpgradeView, BigPackageModuleDetectionView bigPackageModuleDetectionView, BigPackageSingleFirmwareProgressView bigPackageSingleFirmwareProgressView) {
        super(obj, view, i);
        this.btnClose = imageButton;
        this.clConnectedState = constraintLayout;
        this.clPlaneBatteryLow = constraintLayout2;
        this.clPlaneHighTemp = constraintLayout3;
        this.clPlaneUnlock = constraintLayout4;
        this.clRemoteBatteryLow = constraintLayout5;
        this.clSdState = constraintLayout6;
        this.fragmentUpgradeQuestion = frameLayout;
        this.ivConnected = imageView;
        this.ivFirmwareState = imageView2;
        this.ivHighTemp = imageView3;
        this.ivPlane = imageView4;
        this.ivRemote = imageView5;
        this.ivSd = imageView6;
        this.ivUnlock = imageView7;
        this.layoutBigPackageDownloadUpgrade = constraintLayout7;
        this.layoutNotConditions = linearLayout;
        this.layoutNotNetwork = linearLayout2;
        this.layoutTransferFail = viewBigPackageFwTransferFailBinding;
        this.layoutUpgradeConsiderations = linearLayout3;
        this.layoutUpgradeFinished = viewBigPackageUpgradeFinishedBinding;
        this.layoutUpgradeState = linearLayout4;
        this.lineConnected = textView;
        this.lineHighTemp = textView2;
        this.linePlane = textView3;
        this.lineRemote = textView4;
        this.lineSd = textView5;
        this.lineUnlock = textView6;
        this.scrollViewCheckCondition = linearLayout5;
        this.scrollViewDownloadTips = scrollView;
        this.scrollViewUpgradeTips = scrollView2;
        this.tvConnectedState = textView7;
        this.tvCountDown = countDownView;
        this.tvCurrentDetectionModule = textView8;
        this.tvDownloadConsiderationsContent = textView9;
        this.tvDownloadTips = textView10;
        this.tvFirmwareName = textView11;
        this.tvFirmwareState = textView12;
        this.tvFirmwareVersion = textView13;
        this.tvFormatSd = textView14;
        this.tvPlaneBatteryLow = textView15;
        this.tvPlaneHighTemp = textView16;
        this.tvPlaneUnlock = textView17;
        this.tvRemoteBatteryLow = textView18;
        this.tvSdState = textView19;
        this.tvSingleFwUpgradeProgress = textView20;
        this.tvTitle = textView21;
        this.tvUpgradeConsiderationsContent = textView22;
        this.tvUpgradeDetail = textView23;
        this.viewBigPackageDownloadUpgrade = bigPackageDownloadUpgradeView;
        this.viewBigPackageModuleDetection = bigPackageModuleDetectionView;
        this.viewSingleFirmwareProgress = bigPackageSingleFirmwareProgressView;
    }

    public BigPackageViewModel getBigPackageViewModel() {
        return this.mBigPackageViewModel;
    }

    public static ActivityBigPackageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBigPackageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityBigPackageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_big_package, viewGroup, z, obj);
    }

    public static ActivityBigPackageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBigPackageBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityBigPackageBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_big_package, null, false, obj);
    }

    public static ActivityBigPackageBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBigPackageBinding bind(View view, Object obj) {
        return (ActivityBigPackageBinding) bind(obj, view, R.layout.activity_big_package);
    }
}
