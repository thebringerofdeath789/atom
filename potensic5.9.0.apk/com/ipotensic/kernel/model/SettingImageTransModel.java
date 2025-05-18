package com.ipotensic.kernel.model;

import androidx.lifecycle.Lifecycle;
import com.ipotensic.kernel.test.BaseModelObservable;

/* loaded from: classes2.dex */
public class SettingImageTransModel extends BaseModelObservable {
    public int value;

    @Override // com.ipotensic.kernel.test.BaseModelObservable
    public void onDestroy() {
    }

    public SettingImageTransModel(Lifecycle lifecycle, BaseModelObservable.OnPropertyChangeListener onPropertyChangeListener) {
        super(lifecycle, onPropertyChangeListener);
        this.value = 0;
    }
}