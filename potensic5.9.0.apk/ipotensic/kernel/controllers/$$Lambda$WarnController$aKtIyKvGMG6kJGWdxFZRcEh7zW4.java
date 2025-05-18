package com.ipotensic.kernel.controllers;

import com.ipotensic.baselib.observer.LifeCycleNotifyBoolean;
import com.ipotensic.kernel.manager.TipManager;

/* compiled from: lambda */
/* renamed from: com.ipotensic.kernel.controllers.-$$Lambda$WarnController$aKtIyKvGMG6kJGWdxFZRcEh7zW4 */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$WarnController$aKtIyKvGMG6kJGWdxFZRcEh7zW4 implements LifeCycleNotifyBoolean.OnNotifyListener {
    public final /* synthetic */ TipManager f$1;

    public /* synthetic */ $$Lambda$WarnController$aKtIyKvGMG6kJGWdxFZRcEh7zW4(TipManager tipManager) {
        tipManager = tipManager;
    }

    @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
    public final void onNotifyChanged(boolean z) {
        WarnController.this.lambda$new$2$WarnController(tipManager, z);
    }
}