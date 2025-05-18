package com.ipotensic.kernel.view.dialog;

import android.content.DialogInterface;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.view.dialog.-$$Lambda$GeoCalibrationDialog$neglmjUT02-KJ1F7Z24zAKDZguI */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$GeoCalibrationDialog$neglmjUT02KJ1F7Z24zAKDZguI implements DialogInterface.OnDismissListener {
    public final /* synthetic */ int f$1;

    public /* synthetic */ $$Lambda$GeoCalibrationDialog$neglmjUT02KJ1F7Z24zAKDZguI(int i) {
        i = i;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        GeoCalibrationDialog.this.lambda$onCalibrateResult$0$GeoCalibrationDialog(i, dialogInterface);
    }
}