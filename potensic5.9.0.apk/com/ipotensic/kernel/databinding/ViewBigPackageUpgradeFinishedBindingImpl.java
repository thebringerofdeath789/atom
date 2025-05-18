package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.view.CountDownView;

/* loaded from: classes2.dex */
public class ViewBigPackageUpgradeFinishedBindingImpl extends ViewBigPackageUpgradeFinishedBinding {
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
        sparseIntArray.put(C1965R.id.tv_title, 1);
        sparseIntArray.put(C1965R.id.btn_upgrade_finished_close, 2);
        sparseIntArray.put(C1965R.id.iv_upgrade_success, 3);
        sparseIntArray.put(C1965R.id.tv_tips, 4);
        sparseIntArray.put(C1965R.id.tv_upgrade_finished_count_down, 5);
    }

    public ViewBigPackageUpgradeFinishedBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 6, sIncludes, sViewsWithIds));
    }

    private ViewBigPackageUpgradeFinishedBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ImageButton) objArr[2], (ImageView) objArr[3], (ConstraintLayout) objArr[0], (TextView) objArr[4], (TextView) objArr[1], (CountDownView) objArr[5]);
        this.mDirtyFlags = -1L;
        this.layoutUpgradeFinished.setTag(null);
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