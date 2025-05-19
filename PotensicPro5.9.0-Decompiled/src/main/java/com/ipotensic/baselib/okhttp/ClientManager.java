package com.ipotensic.baselib.okhttp;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.broadcasts.NetworkStateReceiver;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.enums.NetworkType;
import com.ipotensic.baselib.utils.NetworkUtil;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Dns;
import okhttp3.OkHttpClient;

/* loaded from: classes2.dex */
public class ClientManager {
    public static volatile ClientManager instance;
    private OkHttpClient okHttpClient = null;
    private final int TIMEOUT = 20;
    private Handler handler = new Handler();
    private Runnable timeoutRunnable = new Runnable() { // from class: com.ipotensic.baselib.okhttp.ClientManager.1
        @Override // java.lang.Runnable
        public void run() {
            ClientManager.this.setNormalClient();
            NetworkStateReceiver.getInstance().onCellularChanged(false);
        }
    };
    private ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.ipotensic.baselib.okhttp.ClientManager.2
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(final Network network) {
            synchronized (ClientManager.class) {
                ClientManager.this.okHttpClient = new OkHttpClient.Builder().connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(true).socketFactory(network.getSocketFactory()).dns(new Dns() { // from class: com.ipotensic.baselib.okhttp.ClientManager.2.1
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
                DDLog.w("切换4G client");
                ClientManager.this.handler.removeCallbacks(ClientManager.this.timeoutRunnable);
                NetworkStateReceiver.getInstance().onCellularChanged(true);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            DDLog.e("4G网络不可用");
            ClientManager.this.setNormalClient();
            NetworkStateReceiver.getInstance().onCellularChanged(false);
        }
    };

    public void init() {
    }

    private ClientManager() {
    }

    public static ClientManager getInstance() {
        if (instance == null) {
            synchronized (ClientManager.class) {
                if (instance == null) {
                    ClientManager clientManager = new ClientManager();
                    instance = clientManager;
                    return clientManager;
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
        if (!PhoneConfig.isConnectFlightWifi()) {
            setNormalClient();
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) PhoneConfig.applicationContext.getSystemService("connectivity");
            if (NetworkUtil.isVpnConnected(PhoneConfig.applicationContext)) {
                build = new NetworkRequest.Builder().addTransportType(4).removeCapability(15).addCapability(12).build();
            } else {
                build = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
            }
            DDLog.e("开始切换网络");
            connectivityManager.requestNetwork(build, this.networkCallback);
        } catch (Exception unused) {
        }
        this.handler.postDelayed(this.timeoutRunnable, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNormalClient() {
        this.okHttpClient = new OkHttpClient.Builder().connectTimeout(20L, TimeUnit.SECONDS).retryOnConnectionFailure(true).build();
    }
}
