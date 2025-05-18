package com.ipotensic.baselib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: classes2.dex */
public class NetworkUtils {
    public static int NETWORK_STATE_2G = 2;
    public static int NETWORK_STATE_3G = 3;
    public static int NETWORK_STATE_4G = 4;
    public static int NETWORK_STATE_CONNECTING = -2;
    public static int NETWORK_STATE_MOBILE_UNKNOWN = 5;
    public static int NETWORK_STATE_NONE = -1;
    public static int NETWORK_STATE_WIFI = 1;

    public static int getNetworkState(Context context) {
        NetworkInfo.State state;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return NETWORK_STATE_NONE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return NETWORK_STATE_NONE;
        }
        if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING) {
            return NETWORK_STATE_CONNECTING;
        }
        if (!activeNetworkInfo.isAvailable()) {
            return NETWORK_STATE_NONE;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return NETWORK_STATE_WIFI;
        }
        return NETWORK_STATE_4G;
    }

    public static boolean isMobile(int i) {
        return i > NETWORK_STATE_WIFI;
    }

    public static boolean isNetConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static synchronized boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        int type;
        synchronized (NetworkUtils.class) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !((type = activeNetworkInfo.getType()) == 1 || type == 9)) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        }
    }
}