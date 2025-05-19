package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.R;

/* loaded from: classes2.dex */
public class ViewLayoutSettingMainBindingImpl extends ViewLayoutSettingMainBinding {
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
        sparseIntArray.put(R.id.tv_setting_title, 1);
        sparseIntArray.put(R.id.layout_setting, 2);
        sparseIntArray.put(R.id.rg_setting, 3);
        sparseIntArray.put(R.id.tv_security, 4);
        sparseIntArray.put(R.id.tv_calibration, 5);
        sparseIntArray.put(R.id.tv_control, 6);
        sparseIntArray.put(R.id.tv_camera, 7);
        sparseIntArray.put(R.id.tv_image_trans, 8);
        sparseIntArray.put(R.id.tv_about, 9);
        sparseIntArray.put(R.id.fl_content, 10);
    }

    public ViewLayoutSettingMainBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingMainBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[10], (NestedScrollView) objArr[2], (RadioGroup) objArr[3], (RadioButton) objArr[9], (RadioButton) objArr[5], (RadioButton) objArr[7], (RadioButton) objArr[6], (RadioButton) objArr[8], (RadioButton) objArr[4], (TextView) objArr[1], (FrameLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.viewSetting.setTag(null);
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
