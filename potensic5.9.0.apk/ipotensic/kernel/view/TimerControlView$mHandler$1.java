package com.ipotensic.kernel.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimerControlView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/kernel/view/TimerControlView$mHandler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TimerControlView$mHandler$1 extends Handler {
    TimerControlView$mHandler$1(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r2) {
        Intrinsics.checkParameterIsNotNull(r2, "msg");
        if (r2.what == 0) {
            TimerControlView.this.invalidate();
        } else if (r2.what == 1) {
            TimerControlView.this.invalidate();
        }
    }
}