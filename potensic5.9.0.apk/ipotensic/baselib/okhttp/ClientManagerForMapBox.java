package com.ipotensic.baselib.okhttp;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.utils.NetworkUtil;
import com.mapbox.mapboxsdk.module.http.HttpRequestImpl;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public class ClientManagerForMapBox {
    public static volatile ClientManagerForMapBox instance;
    private OkHttpClient okHttpClient = null;
    private final int TIMEOUT = 20;
    private Handler handler = new Handler();
    private Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.baselib.okhttp.ClientManagerForMapBox.1
        @Override // java.lang.Runnable
        public void run() {
            ClientManagerForMapBox.this.setNormalClient();
        }
    };
    private boolean isStart = false;
    private ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.ipotensic.baselib.okhttp.ClientManagerForMapBox.2
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(final Network network) {
            synchronized (ClientManagerForMapBox.class) {
                ClientManagerForMapBox.this.okHttpClient = new OkHttpClient.Builder().dispatcher(ClientManagerForMapBox.this.getDispatcher()).connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(true).socketFactory(network.getSocketFactory()).dns(new Dns() { // from class: com.ipotensic.baselib.okhttp.ClientManagerForMapBox.2.1
                    @Override // okhttp3.Dns
                    public List<InetAddress> lookup(String str) throws UnknownHostException {
                        if (Build.VERSION.SDK_INT >= 21) {
                            List<InetAddress> asList = Arrays.asList(network.getAllByName(str));
                            DDLog.d("NetworkDns", "List : " + asList);
                            return asList;
                        }
                        return SYSTEM.lookup(str);
                    }
                }).build();
                DDLog.w("\u5207\u63624G client");
                ClientManagerForMapBox.this.handler.removeCallbacks(ClientManagerForMapBox.this.timeoutRunnable);
                HttpRequestImpl.setOkHttpClient(ClientManagerForMapBox.this.okHttpClient);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            DDLog.e("4G\u7f51\u7edc\u4e0d\u53ef\u7528");
            ClientManagerForMapBox.this.setNormalClient();
        }
    };

    private ClientManagerForMapBox() {
    }

    public static ClientManagerForMapBox getInstance() {
        if (instance == null) {
            synchronized (ClientManagerForMapBox.class) {
                if (instance == null) {
                    ClientManagerForMapBox clientManagerForMapBox = new ClientManagerForMapBox();
                    instance = clientManagerForMapBox;
                    return clientManagerForMapBox;
                }
            }
        }
        return instance;
    }

    public synchronized OkHttpClient getClient() {
        if (this.okHttpClient == null) {
            setNormalClient();
        }
        return this.okHttpClient;
    }

    public void onNetworkChanged(NetworkType networkType) {
        NetworkRequest build;
        try {
            if (!PhoneConfig.isConnectFlightWifi()) {
                setNormalClient();
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) PhoneConfig.applicationContext.getSystemService("connectivity");
            if (NetworkUtil.isVpnConnected(PhoneConfig.applicationContext)) {
                build = new NetworkRequest.Builder().addTransportType(4).removeCapability(15).addCapability(12).build();
            } else {
                build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
            }
            connectivityManager.requestNetwork(build, this.networkCallback);
            this.handler.postDelayed(this.timeoutRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalClient() {
        OkHttpClient build = new OkHttpClient.Builder().dispatcher(getDispatcher()).connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
        this.okHttpClient = build;
        HttpRequestImpl.setOkHttpClient(build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Dispatcher getDispatcher() {
        Dispatcher dispatcher;
        dispatcher = new Dispatcher();
        if (Build.VERSION.SDK_INT >= 21) {
            dispatcher.setMaxRequestsPerHost(20);
        } else {
            dispatcher.setMaxRequestsPerHost(10);
        }
        return dispatcher;
    }
}