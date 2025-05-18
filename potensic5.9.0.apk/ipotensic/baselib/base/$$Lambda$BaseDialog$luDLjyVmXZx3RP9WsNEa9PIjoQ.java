package com.ipotensic.baselib.base;

import android.view.View;
import android.view.Window;

/* compiled from: lambda */
/* renamed from: com.ipotensic.baselib.base.-$$Lambda$BaseDialog$luDLjy-VmXZx3RP9WsNEa9PIjoQ */
/* loaded from: classes2.dex */
public final /* synthetic */ class $$Lambda$BaseDialog$luDLjyVmXZx3RP9WsNEa9PIjoQ implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ Window f$0;

    public /* synthetic */ $$Lambda$BaseDialog$luDLjyVmXZx3RP9WsNEa9PIjoQ(Window window) {
        window = window;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        window.getDecorView().setSystemUiVisibility(5894);
    }
}