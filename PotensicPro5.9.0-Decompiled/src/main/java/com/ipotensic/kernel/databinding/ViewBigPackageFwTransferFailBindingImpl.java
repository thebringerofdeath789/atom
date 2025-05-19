package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ViewBigPackageFwTransferFailBindingImpl extends ViewBigPackageFwTransferFailBinding {
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
        sparseIntArray.put(R.id.tv_upgrade_fail_title, 1);
        sparseIntArray.put(R.id.tv_upgrade_fail_faqs, 2);
        sparseIntArray.put(R.id.btn_upgrade_fail_close, 3);
        sparseIntArray.put(R.id.layout_fw_transfer_retry, 4);
        sparseIntArray.put(R.id.tv_upgrade_fail_content, 5);
        sparseIntArray.put(R.id.tv_error_code, 6);
        sparseIntArray.put(R.id.btn_transfer_exit, 7);
        sparseIntArray.put(R.id.btn_upgrade_retry, 8);
        sparseIntArray.put(R.id.btn_upgrade_exit, 9);
    }

    public ViewBigPackageFwTransferFailBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 10, sIncludes, sViewsWithIds));
    }

    private ViewBigPackageFwTransferFailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (Button) objArr[7], (Button) objArr[9], (ImageButton) objArr[3], (Button) objArr[8], (LinearLayout) objArr[4], (TextView) objArr[6], (TextView) objArr[5], (TextView) objArr[2], (TextView) objArr[1]);
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
