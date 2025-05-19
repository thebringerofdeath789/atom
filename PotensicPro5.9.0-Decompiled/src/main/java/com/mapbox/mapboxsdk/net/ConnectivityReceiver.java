package com.mapbox.mapboxsdk.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mapbox.mapboxsdk.log.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ConnectivityReceiver extends BroadcastReceiver {
    private static ConnectivityReceiver INSTANCE = null;
    private static final String LOG_CONNECTED = "connected - true";
    private static final String LOG_NOT_CONNECTED = "connected - false";
    private static final String TAG = "Mbgl-ConnectivityReceiver";
    private int activationCounter;
    private Boolean connected;
    private Context context;
    private List<ConnectivityListener> listeners = new CopyOnWriteArrayList();

    public static synchronized ConnectivityReceiver instance(Context context) {
        ConnectivityReceiver connectivityReceiver;
        synchronized (ConnectivityReceiver.class) {
            if (INSTANCE == null) {
                ConnectivityReceiver connectivityReceiver2 = new ConnectivityReceiver(context.getApplicationContext());
                INSTANCE = connectivityReceiver2;
                connectivityReceiver2.addListener(new NativeConnectivityListener());
            }
            connectivityReceiver = INSTANCE;
        }
        return connectivityReceiver;
    }

    private ConnectivityReceiver(Context context) {
        this.context = context;
    }

    public void activate() {
        if (this.activationCounter == 0) {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.activationCounter++;
    }

    public void deactivate() {
        int i = this.activationCounter - 1;
        this.activationCounter = i;
        if (i == 0) {
            this.context.unregisterReceiver(INSTANCE);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.connected != null) {
            return;
        }
        notifyListeners(isNetworkActive());
    }

    public void setConnected(Boolean bool) {
        boolean isNetworkActive;
        this.connected = bool;
        if (bool != null) {
            isNetworkActive = bool.booleanValue();
        } else {
            isNetworkActive = isNetworkActive();
        }
        notifyListeners(isNetworkActive);
    }

    private void notifyListeners(boolean z) {
        Logger.v(TAG, z ? LOG_CONNECTED : LOG_NOT_CONNECTED);
        Iterator<ConnectivityListener> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkStateChanged(z);
        }
    }

    public void addListener(ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
    }

    public void removeListener(ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
    }

    public boolean isConnected() {
        Boolean bool = this.connected;
        return bool != null ? bool.booleanValue() : isNetworkActive();
    }

    private boolean isNetworkActive() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
