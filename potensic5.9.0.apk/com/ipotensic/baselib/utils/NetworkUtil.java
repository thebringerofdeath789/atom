package com.ipotensic.baselib.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.ipotensic.baselib.DDLog;

/* loaded from: classes2.dex */
public class NetworkUtil {
    public static boolean isVpnConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager.getActiveNetworkInfo() == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null) {
                    return false;
                }
                return networkCapabilities.hasTransport(4);
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(17);
            return networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean is4GConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (Build.VERSION.SDK_INT >= 23) {
            for (Network network : connectivityManager.getAllNetworks()) {
                DDLog.m1691w("has 4G:" + connectivityManager.getNetworkCapabilities(network).hasTransport(0));
            }
            return false;
        }
        return connectivityManager.getNetworkInfo(0).isConnected();
    }
}