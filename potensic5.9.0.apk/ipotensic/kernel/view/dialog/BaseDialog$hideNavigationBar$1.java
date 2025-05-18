package com.ipotensic.kernel.view.dialog;

import android.view.View;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "visibility", "", "onSystemUiVisibilityChange"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class BaseDialog$hideNavigationBar$1 implements View.OnSystemUiVisibilityChangeListener {
    final /* synthetic */ Window $window;

    BaseDialog$hideNavigationBar$1(Window window) {
        window = window;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        View decorView = window.getDecorView();
        Intrinsics.checkExpressionValueIsNotNull(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
    }
}