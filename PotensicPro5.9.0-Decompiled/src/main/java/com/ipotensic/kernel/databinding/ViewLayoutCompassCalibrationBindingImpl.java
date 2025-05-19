package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel;

/* loaded from: classes2.dex */
public class ViewLayoutCompassCalibrationBindingImpl extends ViewLayoutCompassCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final TextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_compass_title, 10);
        sparseIntArray.put(R.id.btn_close, 11);
        sparseIntArray.put(R.id.iv_rotating_axis, 12);
        sparseIntArray.put(R.id.img_atom, 13);
        sparseIntArray.put(R.id.tv_mini_geo_step_tips, 14);
        sparseIntArray.put(R.id.tv_fail_notice, 15);
        sparseIntArray.put(R.id.tv_count_down, 16);
    }

    public ViewLayoutCompassCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 17, sIncludes, sViewsWithIds));
    }

    private ViewLayoutCompassCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (ImageButton) objArr[11], (Button) objArr[5], (ConstraintLayout) objArr[8], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[1], (ImageView) objArr[13], (ImageView) objArr[9], (ImageView) objArr[7], (ImageView) objArr[12], (ImageView) objArr[2], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[16], (TextView) objArr[15], (TextView) objArr[14]);
        this.mDirtyFlags = -1L;
        this.btnStart.setTag(null);
        this.clCalibrationResult.setTag(null);
        this.clCalibrationStart.setTag(null);
        this.clCompassCalibration.setTag(null);
        this.ivCalibrationResult.setTag(null);
        this.ivMiniGeoStepTips.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.mboundView4 = textView;
        textView.setTag(null);
        this.picCompassCalibration.setTag(null);
        this.tvCompassHeightTip.setTag(null);
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
        if (BR.compassCalibrationModel != i) {
            return false;
        }
        setCompassCalibrationModel((SettingCompassCalibrationModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutCompassCalibrationBinding
    public void setCompassCalibrationModel(SettingCompassCalibrationModel settingCompassCalibrationModel) {
        this.mCompassCalibrationModel = settingCompassCalibrationModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.compassCalibrationModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return onChangeCompassCalibrationModelUnitIsFt((ObservableBoolean) obj, i2);
        }
        if (i == 1) {
            return onChangeCompassCalibrationModelCurrentViewVisible((ObservableInt) obj, i2);
        }
        if (i == 2) {
            return onChangeCompassCalibrationModelCalibrationResultResId((ObservableInt) obj, i2);
        }
        if (i == 3) {
            return onChangeCompassCalibrationModelCompassHeightTips((ObservableString) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return onChangeCompassCalibrationModelImageId((ObservableInt) obj, i2);
    }

    private boolean onChangeCompassCalibrationModelUnitIsFt(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCurrentViewVisible(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCalibrationResultResId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelCompassHeightTips(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeCompassCalibrationModelImageId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0133 A[ADDED_TO_REGION] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 503
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutCompassCalibrationBindingImpl.executeBindings():void");
    }
}
