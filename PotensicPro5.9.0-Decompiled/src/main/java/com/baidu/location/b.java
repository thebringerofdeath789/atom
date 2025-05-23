package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* loaded from: classes.dex */
class b implements ServiceConnection {
    final /* synthetic */ LocationClient a;

    b(LocationClient locationClient) {
        this.a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle e;
        this.a.g = new Messenger(iBinder);
        if (this.a.g == null) {
            return;
        }
        this.a.e = true;
        z = this.a.C;
        if (z) {
            this.a.h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.a.i;
            e = this.a.e();
            obtain.setData(e);
            this.a.g.send(obtain);
            this.a.e = true;
            if (this.a.c != null) {
                this.a.F.booleanValue();
                this.a.h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.a.g = null;
        this.a.e = false;
    }
}
