package com.mapbox.android.core.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ConnectivityReceiver extends BroadcastReceiver {
    private int activationCounter;
    private Context context;
    private CopyOnWriteArrayList<ConnectivityListener> connectivityListeners = new CopyOnWriteArrayList<>();
    private Boolean connectedFlag = null;

    public ConnectivityReceiver(Context context) {
        this.context = context;
    }

    private static boolean getSystemConnectivity(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            return connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean getManagedConnectivity() {
        Boolean bool = this.connectedFlag;
        if (bool == null) {
            return getSystemConnectivity(this.context);
        }
        return bool.booleanValue();
    }

    public static boolean isConnected(Context context) {
        return getSystemConnectivity(context);
    }

    public boolean isConnected() {
        return getManagedConnectivity();
    }

    public Boolean getConnectedFlag() {
        return this.connectedFlag;
    }

    public void setConnectedFlag(Boolean bool) {
        this.connectedFlag = bool;
    }

    public void addConnectivityListener(ConnectivityListener connectivityListener) {
        if (this.connectivityListeners.contains(connectivityListener)) {
            return;
        }
        this.connectivityListeners.add(connectivityListener);
    }

    public boolean removeConnectivityListener(ConnectivityListener connectivityListener) {
        return this.connectivityListeners.remove(connectivityListener);
    }

    public void requestConnectivityUpdates() {
        if (this.activationCounter == 0) {
            this.context.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        this.activationCounter++;
    }

    public void removeConnectivityUpdates() {
        int i = this.activationCounter - 1;
        this.activationCounter = i;
        if (i == 0) {
            this.context.unregisterReceiver(this);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean managedConnectivity = getManagedConnectivity();
        Iterator<ConnectivityListener> it = this.connectivityListeners.iterator();
        while (it.hasNext()) {
            it.next().onConnectivityChanged(managedConnectivity);
        }
    }
}
