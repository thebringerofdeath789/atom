package com.ipotensic.baselib.broadcasts;

import android.net.ConnectivityManager;
import android.net.Network;

/* loaded from: classes2.dex */
public class SetNetworkCallback extends ConnectivityManager.NetworkCallback {
    private ConnectivityManager connectivityManager;
    private onDefaultNetworkSetListener defaultNetworkSetListener;

    public interface onDefaultNetworkSetListener {
        void onDefaultNetworkSet();
    }

    public void init(ConnectivityManager connectivityManager, onDefaultNetworkSetListener ondefaultnetworksetlistener) {
        this.connectivityManager = connectivityManager;
        this.defaultNetworkSetListener = ondefaultnetworksetlistener;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        super.onAvailable(network);
    }
}
