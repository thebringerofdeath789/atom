package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.calibration.SettingPairDroneModel;

/* loaded from: classes2.dex */
public class ViewLayoutPairDroneAgainBindingImpl extends ViewLayoutPairDroneAgainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_start_pair, 1);
        sparseIntArray.put(R.id.tv_repair_title, 2);
        sparseIntArray.put(R.id.iv_close, 3);
        sparseIntArray.put(R.id.iv_repair_gif, 4);
        sparseIntArray.put(R.id.btn_bottom, 5);
        sparseIntArray.put(R.id.tv_code_step, 6);
        sparseIntArray.put(R.id.tv_code_step_two, 7);
        sparseIntArray.put(R.id.cl_pair_result, 8);
        sparseIntArray.put(R.id.tv_repair_fail_title, 9);
        sparseIntArray.put(R.id.iv_close2, 10);
        sparseIntArray.put(R.id.iv_pair_fail, 11);
        sparseIntArray.put(R.id.tv_count_down, 12);
    }

    public ViewLayoutPairDroneAgainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ViewLayoutPairDroneAgainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (RelativeLayout) objArr[5], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[1], (ImageView) objArr[3], (ImageView) objArr[10], (ImageView) objArr[11], (ImageView) objArr[4], (TextView) objArr[6], (TextView) objArr[7], (TextView) objArr[12], (TextView) objArr[9], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.mboundView0 = relativeLayout;
        relativeLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (BR.pairDroneModel != i) {
            return false;
        }
        setPairDroneModel((SettingPairDroneModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutPairDroneAgainBinding
    public void setPairDroneModel(SettingPairDroneModel settingPairDroneModel) {
        this.mPairDroneModel = settingPairDroneModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangePairDroneModel((SettingPairDroneModel) obj, i2);
    }

    private boolean onChangePairDroneModel(SettingPairDroneModel settingPairDroneModel, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
