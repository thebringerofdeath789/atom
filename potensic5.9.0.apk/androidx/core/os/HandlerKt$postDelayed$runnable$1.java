package androidx.core.os;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: Handler.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, m2338d2 = {"<anonymous>", "", "run"}, m2339k = 3, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    final /* synthetic */ Function0 $action;

    public HandlerKt$postDelayed$runnable$1(Function0 function0) {
        this.$action = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}