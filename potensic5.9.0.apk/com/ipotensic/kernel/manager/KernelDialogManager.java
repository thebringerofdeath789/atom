package com.ipotensic.kernel.manager;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog;
import com.ipotensic.kernel.view.dialog.ForceUnlockDialog;
import com.ipotensic.kernel.view.dialog.WeakSignalDialog;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevStateData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KernelDialogManager.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m2338d2 = {"Lcom/ipotensic/kernel/manager/KernelDialogManager;", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroidx/lifecycle/Lifecycle;)V", "batteryInstallSafetyDialog", "Lcom/ipotensic/kernel/view/dialog/BatteryInstallSafetyDialog;", "forceUnlockDialog", "Lcom/ipotensic/kernel/view/dialog/ForceUnlockDialog;", "weakSignalDialog", "Lcom/ipotensic/kernel/view/dialog/WeakSignalDialog;", "dismissBatteryInstallSafetyDialog", "", "dismissForceUnlockDialog", "dismissWeakSignalDialog", "release", "showBatteryInstallSafetyDialog", "context", "Landroid/content/Context;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "showForceUnlockDialog", "showWeakSignalDialog", "Kernel_mapboxRelease"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelDialogManager {
    private BatteryInstallSafetyDialog batteryInstallSafetyDialog;
    private ForceUnlockDialog forceUnlockDialog;
    private WeakSignalDialog weakSignalDialog;

    public KernelDialogManager(final Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.kernel.manager.KernelDialogManager.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkParameterIsNotNull(source, "source");
                Intrinsics.checkParameterIsNotNull(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycle.removeObserver(this);
                    KernelDialogManager.this.release();
                }
            }
        });
    }

    public final void showForceUnlockDialog(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (ForceUnlockDialog.INSTANCE.isUserConfirm()) {
            return;
        }
        ForceUnlockDialog forceUnlockDialog = this.forceUnlockDialog;
        if (forceUnlockDialog != null) {
            if (forceUnlockDialog == null) {
                Intrinsics.throwNpe();
            }
            if (forceUnlockDialog.isShowing()) {
                return;
            }
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData stateData = flightRevData.getFlightRevStateData();
        if (BaseSyncDialog.isShow || SPHelper.getInstance().getBoolean(SPHelper.KEY_FORCE_UNLOCK_DIALOG_NO_LONGER_SHOW, false)) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(stateData, "stateData");
        if (stateData.isImuPreparing()) {
            ForceUnlockDialog forceUnlockDialog2 = new ForceUnlockDialog(context, new ForceUnlockDialog.OnResultListener() { // from class: com.ipotensic.kernel.manager.KernelDialogManager$showForceUnlockDialog$1
                @Override // com.ipotensic.kernel.view.dialog.ForceUnlockDialog.OnResultListener
                public void onConfirm(boolean isNoLonger) {
                    if (isNoLonger) {
                        SPHelper.getInstance().putBoolean(SPHelper.KEY_FORCE_UNLOCK_DIALOG_NO_LONGER_SHOW, isNoLonger);
                    }
                    ForceUnlockDialog.INSTANCE.setUserConfirm(true);
                }
            });
            this.forceUnlockDialog = forceUnlockDialog2;
            if (forceUnlockDialog2 != null) {
                forceUnlockDialog2.show();
            }
        }
    }

    public final void dismissForceUnlockDialog() {
        ForceUnlockDialog forceUnlockDialog = this.forceUnlockDialog;
        if (forceUnlockDialog == null || !forceUnlockDialog.isShowing()) {
            return;
        }
        forceUnlockDialog.dismiss();
        this.forceUnlockDialog = (ForceUnlockDialog) null;
    }

    public final void showBatteryInstallSafetyDialog(Context context, DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dismissListener, "dismissListener");
        BatteryInstallSafetyDialog batteryInstallSafetyDialog = this.batteryInstallSafetyDialog;
        if (batteryInstallSafetyDialog != null) {
            if (batteryInstallSafetyDialog == null) {
                Intrinsics.throwNpe();
            }
            if (batteryInstallSafetyDialog.isShowing()) {
                return;
            }
        }
        if (BaseSyncDialog.isShow || !Conditions.isShowBatteryInstallSafetyDialog()) {
            return;
        }
        BatteryInstallSafetyDialog batteryInstallSafetyDialog2 = new BatteryInstallSafetyDialog(context, new BatteryInstallSafetyDialog.OnResultListener() { // from class: com.ipotensic.kernel.manager.KernelDialogManager$showBatteryInstallSafetyDialog$1
            @Override // com.ipotensic.kernel.view.dialog.BatteryInstallSafetyDialog.OnResultListener
            public void onConfirm(boolean isNoLonger) {
                SPHelper.getInstance().putBoolean(SPHelper.KEY_BATTERY_INSTALL_DIALOG_NO_LONGER_SHOW, isNoLonger);
                BatteryInstallSafetyDialog.INSTANCE.setUserConfirm(true);
            }
        });
        this.batteryInstallSafetyDialog = batteryInstallSafetyDialog2;
        if (batteryInstallSafetyDialog2 != null) {
            batteryInstallSafetyDialog2.setOnDismissListener(dismissListener);
        }
        BatteryInstallSafetyDialog batteryInstallSafetyDialog3 = this.batteryInstallSafetyDialog;
        if (batteryInstallSafetyDialog3 != null) {
            batteryInstallSafetyDialog3.show();
        }
    }

    public final void dismissBatteryInstallSafetyDialog() {
        BatteryInstallSafetyDialog batteryInstallSafetyDialog = this.batteryInstallSafetyDialog;
        if (batteryInstallSafetyDialog == null || !batteryInstallSafetyDialog.isShowing()) {
            return;
        }
        batteryInstallSafetyDialog.dismiss();
        this.batteryInstallSafetyDialog = (BatteryInstallSafetyDialog) null;
    }

    public final void showWeakSignalDialog(Context context, DialogInterface.OnDismissListener dismissListener) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(dismissListener, "dismissListener");
        WeakSignalDialog weakSignalDialog = this.weakSignalDialog;
        if (weakSignalDialog != null) {
            if (weakSignalDialog == null) {
                Intrinsics.throwNpe();
            }
            if (weakSignalDialog.isShowing()) {
                return;
            }
        }
        if (BaseSyncDialog.isShow || !Conditions.isShowWeakSignalDialog()) {
            return;
        }
        WeakSignalDialog weakSignalDialog2 = new WeakSignalDialog(context, new WeakSignalDialog.OnResultListener() { // from class: com.ipotensic.kernel.manager.KernelDialogManager$showWeakSignalDialog$1
            @Override // com.ipotensic.kernel.view.dialog.WeakSignalDialog.OnResultListener
            public void onConfirm(boolean isNoLonger) {
                SPHelper.getInstance().putBoolean(SPHelper.KEY_WEAK_SIGNAL_DIALOG_NO_LONGER_SHOW, isNoLonger);
                WeakSignalDialog.INSTANCE.setUserConfirm(true);
            }
        });
        this.weakSignalDialog = weakSignalDialog2;
        if (weakSignalDialog2 != null) {
            weakSignalDialog2.setOnDismissListener(dismissListener);
        }
        WeakSignalDialog weakSignalDialog3 = this.weakSignalDialog;
        if (weakSignalDialog3 != null) {
            weakSignalDialog3.show();
        }
    }

    public final void dismissWeakSignalDialog() {
        WeakSignalDialog weakSignalDialog = this.weakSignalDialog;
        if (weakSignalDialog == null || !weakSignalDialog.isShowing()) {
            return;
        }
        weakSignalDialog.dismiss();
        this.weakSignalDialog = (WeakSignalDialog) null;
    }

    public final void release() {
        dismissForceUnlockDialog();
        dismissWeakSignalDialog();
        dismissBatteryInstallSafetyDialog();
    }
}