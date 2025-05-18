package com.ipotensic.baselib.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.broadcasts.SetNetworkCallback;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.listener.OnNetworkChangeListener;
import com.ipotensic.baselib.okhttp.ClientManager;
import com.ipotensic.baselib.okhttp.ClientManagerForMapBox;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes2.dex */
public class NetworkStateReceiver extends BroadcastReceiver {
    private static volatile NetworkStateReceiver instance;
    private boolean isRunning = false;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Set<OnNetworkChangeListener> mCallbacks = new CopyOnWriteArraySet();
    private Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.baselib.broadcasts.NetworkStateReceiver.5
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkStateReceiver.this.onNetworkChanged(PhoneConfig.networkType);
            } catch (Exception unused) {
            }
        }
    };

    private NetworkStateReceiver() {
    }

    public static NetworkStateReceiver getInstance() {
        if (instance == null) {
            synchronized (NetworkStateReceiver.class) {
                if (instance == null) {
                    NetworkStateReceiver networkStateReceiver = new NetworkStateReceiver();
                    instance = networkStateReceiver;
                    return networkStateReceiver;
                }
            }
        }
        return instance;
    }

    public void register(Context context) {
        if (this.isRunning) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.ethernet.ETHERNET_STATE_CHANGED");
            intentFilter.addAction("android.net.ethernet.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.intent.action.ANY_DATA_STATE");
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (Build.VERSION.SDK_INT >= 26) {
                context.registerReceiver(getInstance(), intentFilter, 2);
            } else {
                context.registerReceiver(getInstance(), intentFilter);
            }
            this.isRunning = true;
            DDLog.w("\u6ce8\u518c\u7f51\u7edc\u76d1\u542c\u5e7f\u64ad:" + context.getClass().getSimpleName());
        } catch (Exception e) {
            DDLog.e("\u6ce8\u518c\u76d1\u542c\u9519\u8bef:" + e.getMessage());
        }
    }

    public void unRegister(Context context) {
        if (this.isRunning) {
            context.unregisterReceiver(getInstance());
            this.isRunning = false;
            DDLog.w("\u53d6\u6d88\u6ce8\u518c\u7f51\u7edc\u76d1\u542c\u5e7f\u64ad:" + context.getClass().getSimpleName());
        }
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void addCallback(OnNetworkChangeListener onNetworkChangeListener) {
        if (this.mCallbacks.contains(onNetworkChangeListener)) {
            return;
        }
        this.mCallbacks.add(onNetworkChangeListener);
        onNetworkChangeListener.onNetworkChanged(PhoneConfig.networkType);
    }

    public void removeCallback(OnNetworkChangeListener onNetworkChangeListener) {
        this.mCallbacks.remove(onNetworkChangeListener);
    }

    /* renamed from: com.ipotensic.baselib.broadcasts.NetworkStateReceiver$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ NetworkType val$networkType;

        AnonymousClass1(NetworkType networkType) {
            r2 = networkType;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = NetworkStateReceiver.this.mCallbacks.iterator();
            while (it.hasNext()) {
                ((OnNetworkChangeListener) it.next()).onNetworkChanged(r2);
            }
            ClientManager.getInstance().onNetworkChanged(r2);
            ClientManagerForMapBox.getInstance().onNetworkChanged(r2);
        }
    }

    public void onNetworkChanged(NetworkType networkType) {
        this.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.broadcasts.NetworkStateReceiver.1
            final /* synthetic */ NetworkType val$networkType;

            AnonymousClass1(NetworkType networkType2) {
                r2 = networkType2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NetworkStateReceiver.this.mCallbacks.iterator();
                while (it.hasNext()) {
                    ((OnNetworkChangeListener) it.next()).onNetworkChanged(r2);
                }
                ClientManager.getInstance().onNetworkChanged(r2);
                ClientManagerForMapBox.getInstance().onNetworkChanged(r2);
            }
        });
    }

    /* renamed from: com.ipotensic.baselib.broadcasts.NetworkStateReceiver$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ boolean val$isCellularConnected;

        AnonymousClass2(boolean z) {
            r2 = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = NetworkStateReceiver.this.mCallbacks.iterator();
            while (it.hasNext()) {
                ((OnNetworkChangeListener) it.next()).onCellularStateChanged(r2);
            }
        }
    }

    public void onCellularChanged(boolean z) {
        PhoneConfig.isCellularWhenConnectFlightWifi = z;
        this.mainHandler.post(new Runnable() { // from class: com.ipotensic.baselib.broadcasts.NetworkStateReceiver.2
            final /* synthetic */ boolean val$isCellularConnected;

            AnonymousClass2(boolean z2) {
                r2 = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = NetworkStateReceiver.this.mCallbacks.iterator();
                while (it.hasNext()) {
                    ((OnNetworkChangeListener) it.next()).onCellularStateChanged(r2);
                }
            }
        });
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        DDLog.w("action:" + action);
        if (action.equals("android.net.wifi.STATE_CHANGE")) {
            checkNetworkConnect(context);
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            checkNetworkConnect(context);
        }
    }

    private void checkNetworkConnect(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            int type = activeNetworkInfo.getType();
            PhoneConfig.networkType = NetworkType.TYPE_NONE;
            DDLog.w("\u7f51\u7edc\u7c7b\u578b:" + type);
            if (type == 0) {
                DDLog.i("4G\u7f51\u7edc");
                if (checkFlightConnect(context) || PhoneConfig.networkType == NetworkType.TYPE_234G) {
                    return;
                }
                PhoneConfig.networkType = NetworkType.TYPE_234G;
                setDefaultNet(context, 0, null);
                onNetworkChanged(PhoneConfig.networkType);
                return;
            }
            if (type == 1) {
                DDLog.i("wifi\u7f51\u7edc");
                if (checkFlightConnect(context) || PhoneConfig.networkType == NetworkType.TYPE_WIFI) {
                    return;
                }
                PhoneConfig.networkType = NetworkType.TYPE_WIFI;
                setDefaultNet(context, 1, null);
                onNetworkChanged(PhoneConfig.networkType);
                return;
            }
            if (type != 9) {
                return;
            }
            DDLog.i("\u7f51\u7ebf\u8fde\u63a5");
            if (checkFlightConnect(context) || PhoneConfig.networkType == NetworkType.TYPE_OTHERS) {
                return;
            }
            PhoneConfig.networkType = NetworkType.TYPE_OTHERS;
            setDefaultNet(context, 3, null);
            onNetworkChanged(PhoneConfig.networkType);
            return;
        }
        DDLog.d("\u65e0\u7f51\u7edc");
        if (checkFlightConnect(context) || PhoneConfig.networkType == NetworkType.TYPE_NONE) {
            return;
        }
        PhoneConfig.networkType = NetworkType.TYPE_NONE;
        setDefaultNet(context, 0, null);
        onNetworkChanged(PhoneConfig.networkType);
    }

    private boolean checkFlightConnect(Context context) {
        String ip = getIp(context);
        DDLog.w("\u7f51\u7edc\u8fde\u63a5wifi ip:" + ip);
        if (ip == null || !ip.trim().contains(PhoneConfig.CONNECT_IP)) {
            return false;
        }
        DDLog.w("\u98de\u673a\u7f51\u7edc");
        if (UsbConfig.isUsbConnected) {
            return false;
        }
        PhoneConfig.networkType = NetworkType.TYPE_WIFI_FLIGHT;
        setDefaultNet(context, 1, new SetNetworkCallback.onDefaultNetworkSetListener() { // from class: com.ipotensic.baselib.broadcasts.NetworkStateReceiver.3
            AnonymousClass3() {
            }

            @Override // com.ipotensic.baselib.broadcasts.SetNetworkCallback.onDefaultNetworkSetListener
            public void onDefaultNetworkSet() {
                NetworkStateReceiver.this.onNetworkChanged(PhoneConfig.networkType);
            }
        });
        return true;
    }

    /* renamed from: com.ipotensic.baselib.broadcasts.NetworkStateReceiver$3 */
    class AnonymousClass3 implements SetNetworkCallback.onDefaultNetworkSetListener {
        AnonymousClass3() {
        }

        @Override // com.ipotensic.baselib.broadcasts.SetNetworkCallback.onDefaultNetworkSetListener
        public void onDefaultNetworkSet() {
            NetworkStateReceiver.this.onNetworkChanged(PhoneConfig.networkType);
        }
    }

    public String getIp(Context context) {
        DhcpInfo dhcpInfo = ((WifiManager) context.getSystemService("wifi")).getDhcpInfo();
        DDLog.w("dhcpinfo:" + dhcpInfo.toString());
        return intToIp(dhcpInfo.ipAddress);
    }

    private String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    private void setDefaultNet(Context context, int i, SetNetworkCallback.onDefaultNetworkSetListener ondefaultnetworksetlistener) {
        DDLog.w("\u8bbe\u7f6e\u9ed8\u8ba4\u7f51\u7edc\u4e3awifi\uff1a" + (i == 1));
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (i != 1) {
            if (Build.VERSION.SDK_INT >= 23) {
                connectivityManager.bindProcessToNetwork(null);
                return;
            } else {
                ConnectivityManager.setProcessDefaultNetwork(null);
                return;
            }
        }
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        builder.addTransportType(i);
        this.mainHandler.postDelayed(this.timeoutRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        try {
            connectivityManager.requestNetwork(builder.build(), new ConnectivityManager.NetworkCallback() { // from class: com.ipotensic.baselib.broadcasts.NetworkStateReceiver.4
                final /* synthetic */ ConnectivityManager val$cm;
                final /* synthetic */ SetNetworkCallback.onDefaultNetworkSetListener val$defaultNetworkSetListener;

                AnonymousClass4(ConnectivityManager connectivityManager2, SetNetworkCallback.onDefaultNetworkSetListener ondefaultnetworksetlistener2) {
                    r2 = connectivityManager2;
                    r3 = ondefaultnetworksetlistener2;
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    NetworkStateReceiver.this.mainHandler.removeCallbacks(NetworkStateReceiver.this.timeoutRunnable);
                    try {
                        if (Build.VERSION.SDK_INT >= 23) {
                            r2.bindProcessToNetwork(network);
                        } else {
                            ConnectivityManager.setProcessDefaultNetwork(network);
                        }
                        DDLog.w("\u8bbe\u7f6e\u9ed8\u8ba4\u7f51\u7edc\u6210\u529f");
                        SetNetworkCallback.onDefaultNetworkSetListener ondefaultnetworksetlistener2 = r3;
                        if (ondefaultnetworksetlistener2 != null) {
                            ondefaultnetworksetlistener2.onDefaultNetworkSet();
                        }
                    } catch (Exception e) {
                        DDLog.e("\u7f51\u7edc ConnectivityManager.NetworkCallback.onAvailable: " + e.getMessage());
                    }
                    r2.unregisterNetworkCallback(this);
                }
            });
        } catch (Exception unused) {
        }
    }

    /* renamed from: com.ipotensic.baselib.broadcasts.NetworkStateReceiver$4 */
    class AnonymousClass4 extends ConnectivityManager.NetworkCallback {
        final /* synthetic */ ConnectivityManager val$cm;
        final /* synthetic */ SetNetworkCallback.onDefaultNetworkSetListener val$defaultNetworkSetListener;

        AnonymousClass4(ConnectivityManager connectivityManager2, SetNetworkCallback.onDefaultNetworkSetListener ondefaultnetworksetlistener2) {
            r2 = connectivityManager2;
            r3 = ondefaultnetworksetlistener2;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            NetworkStateReceiver.this.mainHandler.removeCallbacks(NetworkStateReceiver.this.timeoutRunnable);
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    r2.bindProcessToNetwork(network);
                } else {
                    ConnectivityManager.setProcessDefaultNetwork(network);
                }
                DDLog.w("\u8bbe\u7f6e\u9ed8\u8ba4\u7f51\u7edc\u6210\u529f");
                SetNetworkCallback.onDefaultNetworkSetListener ondefaultnetworksetlistener2 = r3;
                if (ondefaultnetworksetlistener2 != null) {
                    ondefaultnetworksetlistener2.onDefaultNetworkSet();
                }
            } catch (Exception e) {
                DDLog.e("\u7f51\u7edc ConnectivityManager.NetworkCallback.onAvailable: " + e.getMessage());
            }
            r2.unregisterNetworkCallback(this);
        }
    }

    /* renamed from: com.ipotensic.baselib.broadcasts.NetworkStateReceiver$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                NetworkStateReceiver.this.onNetworkChanged(PhoneConfig.networkType);
            } catch (Exception unused) {
            }
        }
    }
}