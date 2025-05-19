package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.adapter.ViewBindingAdapter;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.SettingSecurityModel;
import com.ipotensic.kernel.view.BatteryCircleProgressView;

/* loaded from: classes2.dex */
public class ViewLayoutSettingBatteryBindingImpl extends ViewLayoutSettingBatteryBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.battery_progress_view, 5);
        sparseIntArray.put(R.id.line4, 6);
        sparseIntArray.put(R.id.tvTemperatureTips, 7);
        sparseIntArray.put(R.id.tvCurrent, 8);
        sparseIntArray.put(R.id.tvVoltageTips, 9);
        sparseIntArray.put(R.id.tvCycleTimeTips, 10);
    }

    public ViewLayoutSettingBatteryBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private ViewLayoutSettingBatteryBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (BatteryCircleProgressView) objArr[5], (View) objArr[6], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[10], (TextView) objArr[1], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[9]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.tvCurrentValue.setTag(null);
        this.tvTempValue.setTag(null);
        this.tvVoltage.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
        setSettingSecurityModel((SettingSecurityModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutSettingBatteryBinding
    public void setSettingSecurityModel(SettingSecurityModel settingSecurityModel) {
        this.mSettingSecurityModel = settingSecurityModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.settingSecurityModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeSettingSecurityModelShowBatteryInfo((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeSettingSecurityModelTempValue((ObservableString) obj, i2);
        }
        if (i == 2) {
            return onChangeSettingSecurityModelVoltageValue((ObservableString) obj, i2);
        }
        if (i == 3) {
            return onChangeSettingSecurityModelCycleTimeValue((ObservableString) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeSettingSecurityModelCurrentValue((ObservableString) obj, i2);
    }

    private boolean onChangeSettingSecurityModelShowBatteryInfo(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelTempValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelVoltageValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelCycleTimeValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeSettingSecurityModelCurrentValue(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableString observableString;
        ObservableString observableString2;
        ObservableString observableString3;
        ObservableString observableString4;
        ObservableString observableString5;
        ObservableString observableString6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        SettingSecurityModel settingSecurityModel = this.mSettingSecurityModel;
        int i = 0;
        if ((127 & j) != 0) {
            long j2 = j & 97;
            if (j2 != 0) {
                ObservableBoolean observableBoolean = settingSecurityModel != null ? settingSecurityModel.showBatteryInfo : null;
                updateRegistration(0, observableBoolean);
                boolean z = observableBoolean != null ? observableBoolean.get() : false;
                if (j2 != 0) {
                    j |= z ? 256L : 128L;
                }
                if (!z) {
                    i = 8;
                }
            }
            if ((j & 98) != 0) {
                observableString2 = settingSecurityModel != null ? settingSecurityModel.tempValue : null;
                updateRegistration(1, observableString2);
            } else {
                observableString2 = null;
            }
            if ((j & 100) != 0) {
                observableString5 = settingSecurityModel != null ? settingSecurityModel.voltageValue : null;
                updateRegistration(2, observableString5);
            } else {
                observableString5 = null;
            }
            if ((j & 104) != 0) {
                observableString6 = settingSecurityModel != null ? settingSecurityModel.cycleTimeValue : null;
                updateRegistration(3, observableString6);
            } else {
                observableString6 = null;
            }
            if ((j & 112) != 0) {
                observableString = settingSecurityModel != null ? settingSecurityModel.currentValue : null;
                updateRegistration(4, observableString);
            } else {
                observableString = null;
            }
            ObservableString observableString7 = observableString5;
            observableString4 = observableString6;
            observableString3 = observableString7;
        } else {
            observableString = null;
            observableString2 = null;
            observableString3 = null;
            observableString4 = null;
        }
        if ((97 & j) != 0) {
            this.mboundView0.setVisibility(i);
        }
        if ((j & 104) != 0) {
            ViewBindingAdapter.setText(this.mboundView4, observableString4);
        }
        if ((112 & j) != 0) {
            ViewBindingAdapter.setText(this.tvCurrentValue, observableString);
        }
        if ((j & 98) != 0) {
            ViewBindingAdapter.setText(this.tvTempValue, observableString2);
        }
        if ((j & 100) != 0) {
            ViewBindingAdapter.setText(this.tvVoltage, observableString3);
        }
    }
}
