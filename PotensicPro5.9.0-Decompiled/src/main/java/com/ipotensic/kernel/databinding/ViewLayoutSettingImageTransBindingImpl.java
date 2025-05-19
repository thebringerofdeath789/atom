package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.model.SettingImageTransModel;

/* loaded from: classes2.dex */
public class ViewLayoutSettingImageTransBindingImpl extends ViewLayoutSettingImageTransBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    public ViewLayoutSettingImageTransBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 1, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingImageTransBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
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
        if (BR.settingSecurityModel != i) {
            return false;
        }
        setSettingSecurityModel((SettingImageTransModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingImageTransBinding
    public void setSettingSecurityModel(SettingImageTransModel settingImageTransModel) {
        this.mSettingSecurityModel = settingImageTransModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeSettingSecurityModel((SettingImageTransModel) obj, i2);
    }

    private boolean onChangeSettingSecurityModel(SettingImageTransModel settingImageTransModel, int i) {
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
