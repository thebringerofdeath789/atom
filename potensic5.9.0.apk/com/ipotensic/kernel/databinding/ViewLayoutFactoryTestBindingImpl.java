package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CommonSwitchView;
import com.ipotensic.kernel.view.CommonTitleView;

/* loaded from: classes2.dex */
public class ViewLayoutFactoryTestBindingImpl extends ViewLayoutFactoryTestBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(C1965R.id.view_title, 1);
        sparseIntArray.put(C1965R.id.ll_test, 2);
        sparseIntArray.put(C1965R.id.view_factory_test, 3);
        sparseIntArray.put(C1965R.id.view_office_test, 4);
        sparseIntArray.put(C1965R.id.view_camera_test, 5);
        sparseIntArray.put(C1965R.id.view_maintain_test, 6);
        sparseIntArray.put(C1965R.id.view_open_model_test, 7);
        sparseIntArray.put(C1965R.id.view_open_gps_test, 8);
        sparseIntArray.put(C1965R.id.view_imu_cal, 9);
        sparseIntArray.put(C1965R.id.view_location_test, 10);
        sparseIntArray.put(C1965R.id.view_fpv_test, 11);
        sparseIntArray.put(C1965R.id.view_gps_signal_test, 12);
    }

    public ViewLayoutFactoryTestBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 13, sIncludes, sViewsWithIds));
    }

    private ViewLayoutFactoryTestBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2], (CommonSwitchView) objArr[5], (CommonSwitchView) objArr[3], (CommonSwitchView) objArr[11], (CommonSwitchView) objArr[12], (CommonSwitchView) objArr[9], (CommonSwitchView) objArr[10], (CommonSwitchView) objArr[6], (CommonSwitchView) objArr[4], (CommonSwitchView) objArr[8], (CommonSwitchView) objArr[7], (CommonTitleView) objArr[1]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
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
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}