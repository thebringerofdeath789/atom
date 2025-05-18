package com.ipotensic.kernel.model;

import android.app.Application;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.ipotensic.baselib.listener.LiveDataObserver;

/* loaded from: classes2.dex */
public class SettingMainModel extends AndroidViewModel {
    public static final int CHILD_INDICATOR_STICK_MODE = 6;
    public static final int INDICATOR_ABOUT = 5;
    public static final int INDICATOR_CALIBRATION = 1;
    public static final int INDICATOR_CAMERA = 3;
    public static final int INDICATOR_CONTROL = 2;
    public static final int INDICATOR_IMAGE_TRANS = 4;
    public static final int INDICATOR_SECURITY = 0;
    public final float SELECT_ALPHA;
    public final float SELECT_ANIM_SCALE;
    public final float UNSELECT_ALPHA;
    public LiveDataObserver<Integer> indicatorIndex;

    public interface OnValueChangedListener {
        void onPageChange(int i);
    }

    public SettingMainModel(Application application) {
        super(application);
        this.SELECT_ANIM_SCALE = 0.98f;
        this.UNSELECT_ALPHA = 0.5f;
        this.SELECT_ALPHA = 1.0f;
    }

    public void init(LifecycleOwner lifecycleOwner, final OnValueChangedListener onValueChangedListener) {
        this.indicatorIndex = new LiveDataObserver<>(0, lifecycleOwner, new Observer<Integer>() { // from class: com.ipotensic.kernel.model.SettingMainModel.1
            @Override // androidx.lifecycle.Observer
            public void onChanged(Integer num) {
                onValueChangedListener.onPageChange(num.intValue());
            }
        });
    }

    public void setIndicatorIndex(int i) {
        if (this.indicatorIndex.getValue() == null || this.indicatorIndex.getValue().intValue() != i) {
            this.indicatorIndex.setValue(Integer.valueOf(i));
        }
    }

    public int getIndicatorIndex() {
        if (this.indicatorIndex.getValue() == null) {
            return 0;
        }
        int intValue = this.indicatorIndex.getValue().intValue();
        if (intValue == 6) {
            return 2;
        }
        return intValue;
    }

    public void btnSecurityClick(View view) {
        setIndicatorIndex(0);
    }

    public void btnCalibrationClick(View view) {
        setIndicatorIndex(1);
    }

    public void btnControlClick(View view) {
        setIndicatorIndex(2);
    }

    public void btnCameraClick(View view) {
        setIndicatorIndex(3);
    }

    public void btnImageTransClick(View view) {
        setIndicatorIndex(4);
    }

    public void btnAboutClick(View view) {
        setIndicatorIndex(5);
    }
}