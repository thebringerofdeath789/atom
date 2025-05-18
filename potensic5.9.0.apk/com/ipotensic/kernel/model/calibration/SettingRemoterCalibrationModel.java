package com.ipotensic.kernel.model.calibration;

import androidx.lifecycle.Lifecycle;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.test.BaseModelObservable;

/* loaded from: classes2.dex */
public class SettingRemoterCalibrationModel extends BaseModelObservable {
    private boolean isSuccess;

    @Override // com.ipotensic.kernel.test.BaseModelObservable
    public void onDestroy() {
    }

    public SettingRemoterCalibrationModel(Lifecycle lifecycle, BaseModelObservable.OnPropertyChangeListener onPropertyChangeListener) {
        super(lifecycle, onPropertyChangeListener);
        this.isSuccess = false;
    }

    public void setCalibrationResult(boolean z) {
        this.isSuccess = z;
        notifyChange();
    }

    public int getCalibrationResult() {
        return this.isSuccess ? C1965R.mipmap.img_calibration_success : C1965R.mipmap.img_calibration_fail;
    }
}