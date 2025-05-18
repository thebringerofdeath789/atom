package com.ipotensic.kernel.controllers;

import com.ipotensic.kernel.view.dialog.SlideUnlockDialog;
import com.logan.flight.data.FlightSendData;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.controllers.-$$Lambda$LeftController$1$sPDzpV63ovY-GIy0xayiYku2ziA */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$LeftController$1$sPDzpV63ovYGIy0xayiYku2ziA implements SlideUnlockDialog.SlideResultListener {
    public static final /* synthetic */ $$Lambda$LeftController$1$sPDzpV63ovYGIy0xayiYku2ziA INSTANCE = ;

    private /* synthetic */ $$Lambda$LeftController$1$sPDzpV63ovYGIy0xayiYku2ziA() {
    }

    @Override // com.ipotensic.kernel.view.dialog.SlideUnlockDialog.SlideResultListener
    public final void dealEvent() {
        FlightSendData.get().setLaunch();
    }
}