package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.SettingMainModel;

/* loaded from: classes2.dex */
public class ViewLayoutSettingMain1BindingImpl extends ViewLayoutSettingMain1Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mSettingMainModelBtnSecurityClickAndroidViewViewOnClickListener;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_setting_title, 2);
        sparseIntArray.put(R.id.layout_setting, 3);
        sparseIntArray.put(R.id.rg_setting, 4);
        sparseIntArray.put(R.id.tv_calibration, 5);
        sparseIntArray.put(R.id.tv_control, 6);
        sparseIntArray.put(R.id.tv_camera, 7);
        sparseIntArray.put(R.id.tv_image_trans, 8);
        sparseIntArray.put(R.id.tv_about, 9);
        sparseIntArray.put(R.id.fl_content, 10);
    }

    public ViewLayoutSettingMain1BindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingMain1BindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[10], (NestedScrollView) objArr[3], (RadioGroup) objArr[4], (RadioButton) objArr[9], (RadioButton) objArr[5], (RadioButton) objArr[7], (RadioButton) objArr[6], (RadioButton) objArr[8], (RadioButton) objArr[1], (TextView) objArr[2], (ConstraintLayout) objArr[0]);
        this.mDirtyFlags = -1L;
        this.tvSecurity.setTag(null);
        this.viewSetting.setTag(null);
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
        if (BR.settingMainModel != i) {
            return false;
        }
        setSettingMainModel((SettingMainModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingMain1Binding
    public void setSettingMainModel(SettingMainModel settingMainModel) {
        this.mSettingMainModel = settingMainModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.settingMainModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        OnClickListenerImpl onClickListenerImpl = null;
        SettingMainModel settingMainModel = this.mSettingMainModel;
        long j2 = j & 3;
        if (j2 != 0 && settingMainModel != null) {
            OnClickListenerImpl onClickListenerImpl2 = this.mSettingMainModelBtnSecurityClickAndroidViewViewOnClickListener;
            if (onClickListenerImpl2 == null) {
                onClickListenerImpl2 = new OnClickListenerImpl();
                this.mSettingMainModelBtnSecurityClickAndroidViewViewOnClickListener = onClickListenerImpl2;
            }
            onClickListenerImpl = onClickListenerImpl2.setValue(settingMainModel);
        }
        if (j2 != 0) {
            this.tvSecurity.setOnClickListener(onClickListenerImpl);
        }
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingMainModel value;

        public OnClickListenerImpl setValue(SettingMainModel settingMainModel) {
            this.value = settingMainModel;
            if (settingMainModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.btnSecurityClick(view);
        }
    }
}