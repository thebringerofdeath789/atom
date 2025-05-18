package com.ipotensic.kernel.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.ipotensic.kernel.BR;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.calibration.SettingRemoterCalibrationModel;
import com.ipotensic.kernel.view.CalRockerView;

/* loaded from: classes2.dex */
public class ViewLayoutRemoterControllerCalibrationBindingImpl extends ViewLayoutRemoterControllerCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RelativeLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.layout_cal_step1, 2);
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.img_icon, 4);
        sparseIntArray.put(R.id.btn_start_cal, 5);
        sparseIntArray.put(R.id.layout_cal_step2, 6);
        sparseIntArray.put(R.id.tv_title1, 7);
        sparseIntArray.put(R.id.tv_rocker_tips, 8);
        sparseIntArray.put(R.id.cal_rocker_view_left, 9);
        sparseIntArray.put(R.id.cal_rocker_view_right, 10);
        sparseIntArray.put(R.id.tv_wheel_tips, 11);
        sparseIntArray.put(R.id.img_wheel_segment, 12);
        sparseIntArray.put(R.id.layout_wheel, 13);
        sparseIntArray.put(R.id.img_left_wheel, 14);
        sparseIntArray.put(R.id.img_right_wheel, 15);
        sparseIntArray.put(R.id.cl_calibration_result, 16);
        sparseIntArray.put(R.id.tv_result_title, 17);
        sparseIntArray.put(R.id.tv_count_down, 18);
        sparseIntArray.put(R.id.iv_close, 19);
    }

    public ViewLayoutRemoterControllerCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 20, sIncludes, sViewsWithIds));
    }

    private ViewLayoutRemoterControllerCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[5], (CalRockerView) objArr[9], (CalRockerView) objArr[10], (ConstraintLayout) objArr[16], (ImageView) objArr[4], (ImageView) objArr[14], (ImageView) objArr[15], (ImageView) objArr[12], (ImageView) objArr[1], (ImageView) objArr[19], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[6], (LinearLayout) objArr[13], (TextView) objArr[18], (TextView) objArr[17], (TextView) objArr[8], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[11]);
        this.mDirtyFlags = -1L;
        this.ivCalibrationResult.setTag(null);
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
        if (BR.remoterControllerModel != i) {
            return false;
        }
        setRemoterControllerModel((SettingRemoterCalibrationModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutRemoterControllerCalibrationBinding
    public void setRemoterControllerModel(SettingRemoterCalibrationModel settingRemoterCalibrationModel) {
        updateRegistration(0, settingRemoterCalibrationModel);
        this.mRemoterControllerModel = settingRemoterCalibrationModel;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.remoterControllerModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeRemoterControllerModel((SettingRemoterCalibrationModel) obj, i2);
    }

    private boolean onChangeRemoterControllerModel(SettingRemoterCalibrationModel settingRemoterCalibrationModel, int i) {
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
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        int i = 0;
        SettingRemoterCalibrationModel settingRemoterCalibrationModel = this.mRemoterControllerModel;
        long j2 = j & 3;
        if (j2 != 0 && settingRemoterCalibrationModel != null) {
            i = settingRemoterCalibrationModel.getCalibrationResult();
        }
        if (j2 != 0) {
            this.ivCalibrationResult.setImageResource(i);
        }
    }
}