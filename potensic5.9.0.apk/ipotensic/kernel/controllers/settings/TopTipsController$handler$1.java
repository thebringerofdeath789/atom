package com.ipotensic.kernel.controllers.settings;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: TopTipsController.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017\u00a8\u0006\u0006"}, d2 = {"com/ipotensic/kernel/controllers/settings/TopTipsController$handler$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TopTipsController$handler$1 extends Handler {
    TopTipsController$handler$1(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkParameterIsNotNull(r3, "msg");
        TextView access$getTvCountDown$p = TopTipsController.access$getTvCountDown$p(TopTipsController.this);
        StringBuilder append = new StringBuilder().append(PropertyUtils.MAPPED_DELIM);
        i = TopTipsController.this.countDownNum;
        access$getTvCountDown$p.setText(append.append(i).append("s)").toString());
        i2 = TopTipsController.this.countDownNum;
        if (i2 <= 0) {
            TopTipsController.this.close();
            return;
        }
        TopTipsController topTipsController = TopTipsController.this;
        i3 = topTipsController.countDownNum;
        topTipsController.countDownNum = i3 - 1;
        sendEmptyMessageDelayed(0, 1000L);
    }
}