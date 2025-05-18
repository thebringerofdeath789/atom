package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;

/* renamed from: com.baidu.location.b */
/* loaded from: classes.dex */
class ServiceConnectionC0644b implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ LocationClient f383a;

    ServiceConnectionC0644b(LocationClient locationClient) {
        this.f383a = locationClient;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        boolean z;
        Bundle m261e;
        this.f383a.f351g = new Messenger(iBinder);
        if (this.f383a.f351g == null) {
            return;
        }
        this.f383a.f349e = true;
        z = this.f383a.f335C;
        if (z) {
            this.f383a.f352h.obtainMessage(2).sendToTarget();
            return;
        }
        try {
            Message obtain = Message.obtain((Handler) null, 11);
            obtain.replyTo = this.f383a.f353i;
            m261e = this.f383a.m261e();
            obtain.setData(m261e);
            this.f383a.f351g.send(obtain);
            this.f383a.f349e = true;
            if (this.f383a.f347c != null) {
                this.f383a.f338F.booleanValue();
                this.f383a.f352h.obtainMessage(4).sendToTarget();
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f383a.f351g = null;
        this.f383a.f349e = false;
    }
}