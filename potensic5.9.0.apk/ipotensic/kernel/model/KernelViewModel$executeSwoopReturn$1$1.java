package com.ipotensic.kernel.model;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.FlightConfig;
import kotlin.Metadata;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016\u00a8\u0006\u0005"}, d2 = {"com/ipotensic/kernel/model/KernelViewModel$executeSwoopReturn$1$1", "Lcom/ipotensic/kernel/view/dialog/GeneralDialog$DialogListener;", "cancel", "", "confirm", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelViewModel$executeSwoopReturn$1$1 implements GeneralDialog.DialogListener {
    KernelViewModel$executeSwoopReturn$1$1() {
    }

    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
    public void cancel() {
        DDLog.e("\u4fef\u51b2\u8fd4\u822aswoopReturnDialog onCancel");
        if (!FlightConfig.isConnectFlight()) {
            KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
        } else {
            KernelViewModel.this.exitSwoopReturn();
        }
        KernelViewModel.this.stopSwoopReturnCountTimer();
    }

    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
    public void confirm() {
        DDLog.e("\u4fef\u51b2\u8fd4\u822aswoopReturnDialog onConfirm");
        if (FlightConfig.isConnectFlight()) {
            KernelViewModel.this.enterSwoopReturn();
        } else {
            KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
        }
        KernelViewModel.this.stopSwoopReturnCountTimer();
    }
}