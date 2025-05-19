package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ViewLayoutTestMaintainBindingImpl extends ViewLayoutTestMaintainBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.tv_title, 1);
        sparseIntArray.put(R.id.z_axis, 2);
        sparseIntArray.put(R.id.y_axis, 3);
        sparseIntArray.put(R.id.x_axis, 4);
        sparseIntArray.put(R.id.tv_result, 5);
        sparseIntArray.put(R.id.tv_threshold, 6);
        sparseIntArray.put(R.id.et_threshold, 7);
        sparseIntArray.put(R.id.tv_test_time, 8);
        sparseIntArray.put(R.id.et_test_time, 9);
        sparseIntArray.put(R.id.tv_notice, 10);
        sparseIntArray.put(R.id.tv_test, 11);
    }

    public ViewLayoutTestMaintainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ViewLayoutTestMaintainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[9], (EditText) objArr[7], (ConstraintLayout) objArr[0], (TextView) objArr[10], (TextView) objArr[5], (TextView) objArr[11], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[1], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2]);
        this.mDirtyFlags = -1L;
        this.layoutTestMaintain.setTag(null);
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
