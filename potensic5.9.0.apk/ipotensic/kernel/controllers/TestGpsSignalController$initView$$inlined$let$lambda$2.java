package com.ipotensic.kernel.controllers;

import android.view.View;
import com.ipotensic.kernel.view.SwitchButton;
import kotlin.Metadata;

/* compiled from: TestGpsSignalController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"com/ipotensic/kernel/controllers/TestGpsSignalController$initView$1$2", "Lcom/ipotensic/kernel/view/SwitchButton$SwitchStateListener;", "onDisableClick", "", "onStateChanged", "view", "Landroid/view/View;", "isChecked", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TestGpsSignalController$initView$$inlined$let$lambda$2 implements SwitchButton.SwitchStateListener {
    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onDisableClick() {
    }

    TestGpsSignalController$initView$$inlined$let$lambda$2() {
    }

    @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
    public void onStateChanged(View view, boolean z) {
        TestGpsSignalController.this.setRecordLog(z);
    }
}