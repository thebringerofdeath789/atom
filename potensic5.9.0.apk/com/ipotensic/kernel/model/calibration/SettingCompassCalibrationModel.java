package com.ipotensic.kernel.model.calibration;

import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;

/* loaded from: classes2.dex */
public class SettingCompassCalibrationModel {
    private OnCalibrationListener calibrationListener;
    public ObservableInt currentViewVisible = new ObservableInt(0);
    public ObservableInt calibrationResultResId = new ObservableInt(0);
    public ObservableInt imageId = new ObservableInt();
    public ObservableBoolean unitIsFt = new ObservableBoolean(false);
    public ObservableString unitFt = new ObservableString("m");
    public ObservableString compassHeightTips = new ObservableString("1.5m");
    public final ScaleClickListener startCalibration = new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.model.calibration.SettingCompassCalibrationModel.1
        @Override // com.ipotensic.baselib.listener.ScaleClickListener
        public void click(View view) {
            if (SettingCompassCalibrationModel.this.calibrationListener != null) {
                SettingCompassCalibrationModel.this.calibrationListener.startCalibration();
            }
        }
    };

    public interface OnCalibrationListener {
        void startCalibration();
    }

    public SettingCompassCalibrationModel(OnCalibrationListener onCalibrationListener) {
        this.calibrationListener = onCalibrationListener;
    }

    public void setViewVisible(int i) {
        if (this.currentViewVisible.get() != i) {
            this.currentViewVisible.set(i);
        }
    }

    public void setCalibrationResult(boolean z) {
        this.calibrationResultResId.set(z ? C1965R.mipmap.img_calibration_success : C1965R.mipmap.img_calibration_fail);
    }

    public void setImageId(int i) {
        if (this.imageId.get() != i) {
            this.imageId.set(i);
        }
    }

    public void setCompassHeight() {
        if (PhoneConfig.isFt) {
            this.unitIsFt.set(true);
            this.unitFt.set("ft");
            this.compassHeightTips.set("4.9ft");
        } else {
            this.unitIsFt.set(false);
            this.unitFt.set("m");
            this.compassHeightTips.set("1.5m");
        }
    }
}