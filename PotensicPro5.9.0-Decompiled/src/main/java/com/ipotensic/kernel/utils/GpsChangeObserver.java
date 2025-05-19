package com.ipotensic.kernel.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.location.LocationManager;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.listener.SimpleResultListener;

/* loaded from: classes2.dex */
public class GpsChangeObserver {
    private String GPS_ACTION = "android.location.PROVIDERS_CHANGED";
    private final ContentObserver contentObserver = new ContentObserver(null) { // from class: com.ipotensic.kernel.utils.GpsChangeObserver.1
        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            super.onChange(z);
            GpsChangeObserver gpsChangeObserver = GpsChangeObserver.this;
            boolean gpsIsOpen = gpsChangeObserver.gpsIsOpen(gpsChangeObserver.context);
            DDLog.e("收到gps开关通知1:" + gpsIsOpen);
            if (GpsChangeObserver.this.isGpsOpen != gpsIsOpen) {
                GpsChangeObserver.this.isGpsOpen = gpsIsOpen;
                PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.GpsChangeObserver.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (GpsChangeObserver.this.mInterface != null) {
                            GpsChangeObserver.this.mInterface.onResult(Boolean.valueOf(GpsChangeObserver.this.isGpsOpen));
                        }
                    }
                });
            }
        }
    };
    private Context context;
    private boolean isGpsOpen;
    private SimpleResultListener<Boolean> mInterface;
    private Receiver receiver;

    public GpsChangeObserver(AppCompatActivity appCompatActivity, SimpleResultListener<Boolean> simpleResultListener) {
        this.context = appCompatActivity;
        this.mInterface = simpleResultListener;
        this.isGpsOpen = gpsIsOpen(appCompatActivity);
        observeWifiSwitch();
    }

    private void observeWifiSwitch() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(this.GPS_ACTION);
        Receiver receiver = new Receiver();
        this.receiver = receiver;
        this.context.registerReceiver(receiver, intentFilter);
        this.context.getContentResolver().registerContentObserver(Settings.Secure.getUriFor("location_providers_allowed"), false, this.contentObserver);
    }

    public void onDestroy() {
        try {
            Receiver receiver = this.receiver;
            if (receiver != null) {
                this.context.unregisterReceiver(receiver);
            }
            this.context.getContentResolver().unregisterContentObserver(this.contentObserver);
            if (this.context != null) {
                this.context = null;
            }
        } catch (Exception unused) {
        }
    }

    class Receiver extends BroadcastReceiver {
        Receiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().matches(GpsChangeObserver.this.GPS_ACTION)) {
                boolean gpsIsOpen = GpsChangeObserver.this.gpsIsOpen(context);
                DDLog.e("收到gps开关通知:" + gpsIsOpen);
                if (GpsChangeObserver.this.isGpsOpen != gpsIsOpen) {
                    GpsChangeObserver.this.isGpsOpen = gpsIsOpen;
                    PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.utils.GpsChangeObserver.Receiver.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (GpsChangeObserver.this.mInterface != null) {
                                GpsChangeObserver.this.mInterface.onResult(Boolean.valueOf(GpsChangeObserver.this.isGpsOpen));
                            }
                        }
                    });
                }
            }
        }
    }

    public boolean gpsIsOpen(Context context) {
        return ((LocationManager) context.getApplicationContext().getSystemService("location")).isProviderEnabled("gps");
    }
}
