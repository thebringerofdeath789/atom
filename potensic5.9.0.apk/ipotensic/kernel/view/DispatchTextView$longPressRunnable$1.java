package com.ipotensic.kernel.view;

import android.view.View;
import com.ipotensic.baselib.DDLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: DispatchTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class DispatchTextView$longPressRunnable$1 implements Runnable {
    DispatchTextView$longPressRunnable$1() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        DDLog.d("DispatchView", "onTouchEvent onLongClick");
        DispatchTextView.this.isLongClicked = true;
        Function1<View, Unit> onLongClick = DispatchTextView.this.getOnLongClick();
        if (onLongClick != null) {
            onLongClick.invoke(DispatchTextView.this);
        }
    }
}