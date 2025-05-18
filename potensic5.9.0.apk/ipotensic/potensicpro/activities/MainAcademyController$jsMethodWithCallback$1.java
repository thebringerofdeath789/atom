package com.ipotensic.potensicpro.activities;

import android.webkit.ValueCallback;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.JsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MainAcademyController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class MainAcademyController$jsMethodWithCallback$1<T> implements ValueCallback<String> {
    final /* synthetic */ String $function;

    MainAcademyController$jsMethodWithCallback$1(String str) {
        function = str;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(String it) {
        String str;
        JsViewModel access$getJsInterface$p = MainAcademyController.access$getJsInterface$p(MainAcademyController.this);
        Intrinsics.checkExpressionValueIsNotNull(it, "it");
        access$getJsInterface$p.parseTitle(it);
        str = MainAcademyController.this.TAG;
        DDLog.d(str, "jsMethodWithCallback---" + function + ",callback=" + it);
    }
}