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
import com.ipotensic.kernel.model.calibration.SettingGimbalCalibrationModel;
import com.ipotensic.kernel.view.ProgressLoadingView;
import com.logan.opengl.JfGLSurfaceView;

/* loaded from: classes2.dex */
public class ViewLayoutGimbalCalibrationBindingImpl extends ViewLayoutGimbalCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private OnClickListenerImpl mGimbalCalibrationModelStartCalibrationAndroidViewViewOnClickListener;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.view_video, 7);
        sparseIntArray.put(R.id.tv_count_down, 8);
        sparseIntArray.put(R.id.btn_close, 9);
        sparseIntArray.put(R.id.pic_gimbal_calibration, 10);
        sparseIntArray.put(R.id.loadingView, 11);
    }

    public ViewLayoutGimbalCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 12, sIncludes, sViewsWithIds));
    }

    private ViewLayoutGimbalCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (ImageButton) objArr[9], (Button) objArr[3], (ImageView) objArr[5], (ProgressLoadingView) objArr[11], (ImageView) objArr[10], (TextView) objArr[8], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[1], (JfGLSurfaceView) objArr[7]);
        this.mDirtyFlags = -1L;
        this.btnStartGimbalCalibration.setTag(null);
        this.ivGimbalCalibrationSuccess.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.tvGimbalCalibrationTips1.setTag(null);
        this.tvGimbalCalibrationTips2.setTag(null);
        this.tvGimbalResultTips.setTag(null);
        this.tvGimbalTitle.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
        if (BR.gimbalCalibrationModel != i) {
            return false;
        }
        setGimbalCalibrationModel((SettingGimbalCalibrationModel) obj);
        return true;
    }

    @Override // com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBinding
    public void setGimbalCalibrationModel(SettingGimbalCalibrationModel settingGimbalCalibrationModel) {
        this.mGimbalCalibrationModel = settingGimbalCalibrationModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.gimbalCalibrationModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return onChangeGimbalCalibrationModelTitleStr((ObservableString) obj, i2);
            case 1:
                return onChangeGimbalCalibrationModelCalibrationResultResId((ObservableInt) obj, i2);
            case 2:
                return onChangeGimbalCalibrationModelStartBtnVisible((ObservableBoolean) obj, i2);
            case 3:
                return onChangeGimbalCalibrationModelStartBtnStr((ObservableString) obj, i2);
            case 4:
                return onChangeGimbalCalibrationModelResultStr((ObservableString) obj, i2);
            case 5:
                return onChangeGimbalCalibrationModelStepTwoVisible((ObservableBoolean) obj, i2);
            case 6:
                return onChangeGimbalCalibrationModelStepOneVisible((ObservableBoolean) obj, i2);
            case 7:
                return onChangeGimbalCalibrationModelStepThreeVisible((ObservableBoolean) obj, i2);
            default:
                return false;
        }
    }

    private boolean onChangeGimbalCalibrationModelTitleStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelCalibrationResultResId(ObservableInt observableInt, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStartBtnVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStartBtnStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelResultStr(ObservableString observableString, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepTwoVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepOneVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeGimbalCalibrationModelStepThreeVisible(ObservableBoolean observableBoolean, int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0133  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instructions count: 497
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBindingImpl.executeBindings():void");
    }

    public static class OnClickListenerImpl implements View.OnClickListener {
        private SettingGimbalCalibrationModel value;

        public OnClickListenerImpl setValue(SettingGimbalCalibrationModel settingGimbalCalibrationModel) {
            this.value = settingGimbalCalibrationModel;
            if (settingGimbalCalibrationModel == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.value.startCalibration(view);
        }
    }
}
