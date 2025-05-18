package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.BigPackageViewModel;
import com.ipotensic.kernel.view.BigPackageDownloadUpgradeView;
import com.ipotensic.kernel.view.BigPackageModuleDetectionView;
import com.ipotensic.kernel.view.BigPackageSingleFirmwareProgressView;
import com.ipotensic.kernel.view.CountDownView;

/* loaded from: classes2.dex */
public class ActivityBigPackageBindingImpl extends ActivityBigPackageBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(52);
        sIncludes = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"view_big_package_fw_transfer_fail", "view_big_package_upgrade_finished"}, new int[]{1, 2}, new int[]{R.layout.view_big_package_fw_transfer_fail, R.layout.view_big_package_upgrade_finished});
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.btn_close, 4);
        sparseIntArray.put(R.id.view_big_package_download_upgrade, 5);
        sparseIntArray.put(R.id.layout_upgrade_state, 6);
        sparseIntArray.put(R.id.iv_firmware_state, 7);
        sparseIntArray.put(R.id.tv_firmware_state, 8);
        sparseIntArray.put(R.id.scroll_view_download_tips, 9);
        sparseIntArray.put(R.id.tv_download_tips, 10);
        sparseIntArray.put(R.id.layout_upgrade_considerations, 11);
        sparseIntArray.put(R.id.tv_download_considerations_content, 12);
        sparseIntArray.put(R.id.layout_not_conditions, 13);
        sparseIntArray.put(R.id.cl_connected_state, 14);
        sparseIntArray.put(R.id.tv_connected_state, 15);
        sparseIntArray.put(R.id.line_connected, 16);
        sparseIntArray.put(R.id.iv_connected, 17);
        sparseIntArray.put(R.id.cl_remote_battery_low, 18);
        sparseIntArray.put(R.id.tv_remote_battery_low, 19);
        sparseIntArray.put(R.id.line_remote, 20);
        sparseIntArray.put(R.id.iv_remote, 21);
        sparseIntArray.put(R.id.cl_plane_battery_low, 22);
        sparseIntArray.put(R.id.tv_plane_battery_low, 23);
        sparseIntArray.put(R.id.line_plane, 24);
        sparseIntArray.put(R.id.iv_plane, 25);
        sparseIntArray.put(R.id.cl_plane_unlock, 26);
        sparseIntArray.put(R.id.tv_plane_unlock, 27);
        sparseIntArray.put(R.id.line_unlock, 28);
        sparseIntArray.put(R.id.iv_unlock, 29);
        sparseIntArray.put(R.id.cl_plane_high_temp, 30);
        sparseIntArray.put(R.id.tv_plane_high_temp, 31);
        sparseIntArray.put(R.id.line_high_temp, 32);
        sparseIntArray.put(R.id.iv_high_temp, 33);
        sparseIntArray.put(R.id.cl_sd_state, 34);
        sparseIntArray.put(R.id.tv_sd_state, 35);
        sparseIntArray.put(R.id.line_sd, 36);
        sparseIntArray.put(R.id.iv_sd, 37);
        sparseIntArray.put(R.id.tv_format_sd, 38);
        sparseIntArray.put(R.id.tv_count_down, 39);
        sparseIntArray.put(R.id.scroll_view_check_condition, 40);
        sparseIntArray.put(R.id.tv_firmware_name, 41);
        sparseIntArray.put(R.id.tv_firmware_version, 42);
        sparseIntArray.put(R.id.view_single_firmware_progress, 43);
        sparseIntArray.put(R.id.tv_single_fw_upgrade_progress, 44);
        sparseIntArray.put(R.id.tv_upgrade_detail, 45);
        sparseIntArray.put(R.id.scroll_view_upgrade_tips, 46);
        sparseIntArray.put(R.id.tv_upgrade_considerations_content, 47);
        sparseIntArray.put(R.id.layout_not_network, 48);
        sparseIntArray.put(R.id.view_big_package_module_detection, 49);
        sparseIntArray.put(R.id.tv_current_detection_module, 50);
        sparseIntArray.put(R.id.fragment_upgrade_question, 51);
    }

    public ActivityBigPackageBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 52, sIncludes, sViewsWithIds));
    }

    private ActivityBigPackageBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ImageButton) objArr[4], (ConstraintLayout) objArr[14], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[30], (ConstraintLayout) objArr[26], (ConstraintLayout) objArr[18], (ConstraintLayout) objArr[34], (FrameLayout) objArr[51], (ImageView) objArr[17], (ImageView) objArr[7], (ImageView) objArr[33], (ImageView) objArr[25], (ImageView) objArr[21], (ImageView) objArr[37], (ImageView) objArr[29], (ConstraintLayout) objArr[0], (LinearLayout) objArr[13], (LinearLayout) objArr[48], (ViewBigPackageFwTransferFailBinding) objArr[1], (LinearLayout) objArr[11], (ViewBigPackageUpgradeFinishedBinding) objArr[2], (LinearLayout) objArr[6], (TextView) objArr[16], (TextView) objArr[32], (TextView) objArr[24], (TextView) objArr[20], (TextView) objArr[36], (TextView) objArr[28], (LinearLayout) objArr[40], (ScrollView) objArr[9], (ScrollView) objArr[46], (TextView) objArr[15], (CountDownView) objArr[39], (TextView) objArr[50], (TextView) objArr[12], (TextView) objArr[10], (TextView) objArr[41], (TextView) objArr[8], (TextView) objArr[42], (TextView) objArr[38], (TextView) objArr[23], (TextView) objArr[31], (TextView) objArr[27], (TextView) objArr[19], (TextView) objArr[35], (TextView) objArr[44], (TextView) objArr[3], (TextView) objArr[47], (TextView) objArr[45], (BigPackageDownloadUpgradeView) objArr[5], (BigPackageModuleDetectionView) objArr[49], (BigPackageSingleFirmwareProgressView) objArr[43]);
        this.mDirtyFlags = -1L;
        this.layoutBigPackageDownloadUpgrade.setTag(null);
        setContainedBinding(this.layoutTransferFail);
        setContainedBinding(this.layoutUpgradeFinished);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 8L;
        }
        this.layoutTransferFail.invalidateAll();
        this.layoutUpgradeFinished.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return this.layoutTransferFail.hasPendingBindings() || this.layoutUpgradeFinished.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.bigPackageViewModel != i) {
            return false;
        }
        setBigPackageViewModel((BigPackageViewModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ActivityBigPackageBinding
    public void setBigPackageViewModel(BigPackageViewModel bigPackageViewModel) {
        this.mBigPackageViewModel = bigPackageViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.layoutTransferFail.setLifecycleOwner(lifecycleOwner);
        this.layoutUpgradeFinished.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeLayoutUpgradeFinished((ViewBigPackageUpgradeFinishedBinding) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return onChangeLayoutTransferFail((ViewBigPackageFwTransferFailBinding) obj, i2);
    }

    private boolean onChangeLayoutUpgradeFinished(ViewBigPackageUpgradeFinishedBinding viewBigPackageUpgradeFinishedBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeLayoutTransferFail(ViewBigPackageFwTransferFailBinding viewBigPackageFwTransferFailBinding, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
        executeBindingsOn(this.layoutTransferFail);
        executeBindingsOn(this.layoutUpgradeFinished);
    }
}