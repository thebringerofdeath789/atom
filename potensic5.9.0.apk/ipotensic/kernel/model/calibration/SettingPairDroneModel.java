package com.ipotensic.kernel.model.calibration;

import androidx.lifecycle.Lifecycle;
import com.ipotensic.kernel.test.BaseModelObservable;

/* loaded from: classes2.dex */
public class SettingPairDroneModel extends BaseModelObservable {
    @Override // com.ipotensic.kernel.test.BaseModelObservable
    public void onDestroy() {
    }

    public SettingPairDroneModel(Lifecycle lifecycle, BaseModelObservable.OnPropertyChangeListener onPropertyChangeListener) {
        super(lifecycle, onPropertyChangeListener);
    }
}