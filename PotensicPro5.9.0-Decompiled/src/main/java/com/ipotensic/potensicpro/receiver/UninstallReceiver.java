package com.ipotensic.potensicpro.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public class UninstallReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (TextUtils.isEmpty(action)) {
                return;
            }
            DDLog.e("action:" + action);
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                DDLog.e("第一次安装app ");
            } else if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                DDLog.e("卸载app");
            }
        }
    }
}
