package com.ipotensic.potensicpro.activities;

import com.ipotensic.baselib.enums.State;
import com.ipotensic.potensicpro.view.ConnectStateView;

/* compiled from: lambda */
/* renamed from: com.ipotensic.potensicpro.activities.-$$Lambda$MainDeviceController$SPnKeAJwekGSrqeD5NGiUAcuPLM */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$MainDeviceController$SPnKeAJwekGSrqeD5NGiUAcuPLM implements ConnectStateView.OnConnectStateChangeListener {
    public /* synthetic */ $$Lambda$MainDeviceController$SPnKeAJwekGSrqeD5NGiUAcuPLM() {
    }

    @Override // com.ipotensic.potensicpro.view.ConnectStateView.OnConnectStateChangeListener
    public final void onStateChanged(State state) {
        MainDeviceController.this.lambda$initView$0$MainDeviceController(state);
    }
}