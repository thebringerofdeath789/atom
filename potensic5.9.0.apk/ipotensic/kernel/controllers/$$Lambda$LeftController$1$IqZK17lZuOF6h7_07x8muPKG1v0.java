package com.ipotensic.kernel.controllers;

import com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog;
import com.logan.flight.data.FlightSendData;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$IqZK17lZuOF6h7_07x8muPKG1v0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$LeftController$1$IqZK17lZuOF6h7_07x8muPKG1v0 implements MiniTakeoffSlideUnlockDialog.SlideUnlockListener {
    public static final /* synthetic */ $$Lambda$LeftController$1$IqZK17lZuOF6h7_07x8muPKG1v0 INSTANCE = ;

    private /* synthetic */ $$Lambda$LeftController$1$IqZK17lZuOF6h7_07x8muPKG1v0() {
    }

    @Override // com.ipotensic.kernel.view.dialog.MiniTakeoffSlideUnlockDialog.SlideUnlockListener
    public final void takeOff(boolean z) {
        FlightSendData.get().setLaunch();
    }
}