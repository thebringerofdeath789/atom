package com.baidu.location;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.location.p011g.ServiceC0717a;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.mapbox.api.directions.p022v5.models.StepManeuver;

/* renamed from: com.baidu.location.f */
/* loaded from: classes.dex */
public class ServiceC0702f extends Service {
    public static boolean isServing = false;
    public static boolean isStartedServing = false;

    /* renamed from: mC */
    public static Context f1006mC = null;
    public static String replaceFileName = "repll.jar";

    /* renamed from: a */
    LLSInterface f1007a = null;

    /* renamed from: b */
    LLSInterface f1008b = null;

    /* renamed from: c */
    LLSInterface f1009c = null;

    public static float getFrameVersion() {
        return 9.401f;
    }

    public static String getJarFileName() {
        return "app.jar";
    }

    public static Context getServiceContext() {
        return f1006mC;
    }

    public static void setServiceContext(Context context) {
        f1006mC = context;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LLSInterface lLSInterface = this.f1009c;
        if (lLSInterface != null) {
            return lLSInterface.onBind(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        if (isServing) {
            Log.d("baidu_location_service", "baidu location service can not start again ...20190306..." + Process.myPid());
            return;
        }
        f1006mC = getApplicationContext();
        System.currentTimeMillis();
        this.f1008b = new ServiceC0717a();
        LLSInterface lLSInterface = this.f1007a;
        if (lLSInterface == null || lLSInterface.getVersion() < this.f1008b.getVersion()) {
            this.f1009c = this.f1008b;
            this.f1007a = null;
        } else {
            this.f1009c = this.f1007a;
            this.f1008b = null;
        }
        isServing = true;
        this.f1009c.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        isServing = false;
        LLSInterface lLSInterface = this.f1009c;
        if (lLSInterface != null) {
            lLSInterface.onDestroy();
        }
        if (isStartedServing) {
            stopForeground(true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra("command", 0);
                if (intExtra == 1) {
                    startForeground(intent.getIntExtra(TtmlNode.ATTR_ID, 0), (Notification) intent.getParcelableExtra(StepManeuver.NOTIFICATION));
                    isStartedServing = true;
                } else if (intExtra == 2) {
                    stopForeground(intent.getBooleanExtra("removenotify", true));
                    isStartedServing = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LLSInterface lLSInterface = this.f1009c;
        if (lLSInterface == null) {
            return 2;
        }
        return lLSInterface.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        LLSInterface lLSInterface = this.f1009c;
        if (lLSInterface != null) {
            lLSInterface.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return false;
    }
}