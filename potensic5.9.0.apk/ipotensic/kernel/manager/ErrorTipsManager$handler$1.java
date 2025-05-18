package com.ipotensic.kernel.manager;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.ipotensic.kernel.utils.AnimationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorTipsManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "handleMessage"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class ErrorTipsManager$handler$1 implements Handler.Callback {
    ErrorTipsManager$handler$1() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        if (msg.what == -1) {
            ErrorTipsManager errorTipsManager = ErrorTipsManager.this;
            View childView = errorTipsManager.getChildView(errorTipsManager.getMContext(), msg.arg1, msg.obj.toString());
            ErrorTipsManager.this.getLeftErrorTipView().addView(childView);
            AnimationUtil.transInLeft(childView);
            return true;
        }
        ErrorTipsManager.this.finish(msg.what);
        return true;
    }
}