package com.ipotensic.kernel.manager;

import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog;
import kotlin.Metadata;

/* compiled from: KernelDialogManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/kernel/manager/KernelDialogManager$showBatteryInstallSafetyDialog$1", "Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog$OnResultListener;", "onConfirm", "", "isNoLonger", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelDialogManager$showBatteryInstallSafetyDialog$1 implements BatteryInstallSafetyDialog.OnResultListener {
    KernelDialogManager$showBatteryInstallSafetyDialog$1() {
    }

    @Override // com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog.OnResultListener
    public void onConfirm(boolean isNoLonger) {
        SPHelper.getInstance().putBoolean(SPHelper.KEY_BATTERY_INSTALL_DIALOG_NO_LONGER_SHOW, isNoLonger);
        BatteryInstallSafetyDialog.INSTANCE.setUserConfirm(true);
    }
}