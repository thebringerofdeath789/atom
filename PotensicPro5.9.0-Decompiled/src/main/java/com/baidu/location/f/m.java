package com.baidu.location.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.h.o;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.netty.Constant;
import java.util.List;

/* loaded from: classes.dex */
public class m {
    public static long a;
    private static m b;
    private WifiManager c = null;
    private a d = null;
    private l e = null;
    private long f = 0;
    private long g = 0;
    private boolean h = false;
    private ConnectivityManager i = null;
    private Handler j = new Handler();
    private boolean k = false;
    private long l = 0;
    private long m = 0;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends BroadcastReceiver {
        private long b;
        private boolean c;

        private a() {
            this.b = 0L;
            this.c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                m.a = System.currentTimeMillis() / 1000;
                m.this.j.post(new n(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.b >= 5000) {
                this.b = System.currentTimeMillis();
                if (this.c) {
                    return;
                }
                this.c = true;
            }
        }
    }

    private m() {
    }

    public static synchronized m a() {
        m mVar;
        synchronized (m.class) {
            if (b == null) {
                b = new m();
            }
            mVar = b;
        }
        return mVar;
    }

    private String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static boolean a(l lVar, l lVar2) {
        boolean a2 = a(lVar, lVar2, o.az);
        long currentTimeMillis = System.currentTimeMillis() - com.baidu.location.b.b.c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !a2 || lVar2.h() - lVar.h() <= 30) {
            return a2;
        }
        return false;
    }

    public static boolean a(l lVar, l lVar2, float f) {
        if (lVar != null && lVar2 != null) {
            List<ScanResult> list = lVar.a;
            List<ScanResult> list2 = lVar2.a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2) != null ? list.get(i2).BSSID : null;
                        if (str != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                }
                                String str2 = list2.get(i3) != null ? list2.get(i3).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i++;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        WifiManager wifiManager = this.c;
        if (wifiManager == null) {
            return;
        }
        try {
            l a2 = a(wifiManager, System.currentTimeMillis());
            if (a2.a != null) {
                l lVar = this.e;
                if (lVar == null || !a2.a(lVar)) {
                    this.e = a2;
                }
            }
        } catch (Exception unused) {
        }
    }

    public l a(WifiManager wifiManager, long j) {
        l lVar = new l(null, 0L);
        return (wifiManager == null || o.f == 4) ? lVar : new l(wifiManager.getScanResults(), j);
    }

    public void b() {
        this.l = 0L;
    }

    public synchronized void c() {
        if (this.h) {
            return;
        }
        if (com.baidu.location.f.isServing) {
            this.c = (WifiManager) com.baidu.location.f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.d = new a();
            try {
                com.baidu.location.f.getServiceContext().registerReceiver(this.d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception unused) {
            }
            this.h = true;
        }
    }

    public List<WifiConfiguration> d() {
        try {
            WifiManager wifiManager = this.c;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public synchronized void e() {
        if (this.h) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.d);
                a = 0L;
            } catch (Exception unused) {
            }
            this.d = null;
            this.c = null;
            this.h = false;
        }
    }

    public boolean f() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.g;
        if (currentTimeMillis - j > 0 && currentTimeMillis - j <= 5000) {
            return false;
        }
        this.g = currentTimeMillis;
        b();
        return g();
    }

    public boolean g() {
        if (this.c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f;
        if (currentTimeMillis - j > 0) {
            long j2 = currentTimeMillis - j;
            long j3 = this.l;
            if (j2 <= j3 + 5000 || currentTimeMillis - (a * 1000) <= j3 + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && currentTimeMillis - this.f < 25000) {
                return false;
            }
            if (k() && !h() && currentTimeMillis - this.f <= this.l + Constant.DELAY_MILLIS) {
                return false;
            }
        }
        return j();
    }

    public boolean h() {
        return false;
    }

    public String i() {
        WifiManager wifiManager = this.c;
        if (wifiManager == null) {
            return "";
        }
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (Build.VERSION.SDK_INT <= 17) {
                    return "";
                }
                if (!this.c.isScanAlwaysAvailable()) {
                    return "";
                }
            }
            return "&wifio=1";
        } catch (Exception | NoSuchMethodError unused) {
            return "";
        }
    }

    public boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.m;
        if (currentTimeMillis >= 0 && currentTimeMillis <= SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return false;
        }
        this.m = System.currentTimeMillis();
        try {
            if ((this.c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.c.isScanAlwaysAvailable())) && o.f != 4) {
                this.c.startScan();
                this.f = System.currentTimeMillis();
                return true;
            }
        } catch (Exception | NoSuchMethodError unused) {
        }
        return false;
    }

    public boolean k() {
        try {
            if (this.i == null) {
                this.i = (ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.i;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean l() {
        l p;
        try {
            if ((!this.c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.c.isScanAlwaysAvailable())) || k() || (p = p()) == null) {
                return false;
            }
            return p.e();
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public WifiInfo m() {
        if (this.c != null && o.f != 4) {
            try {
                WifiInfo connectionInfo = this.c.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                    String bssid = connectionInfo.getBSSID();
                    if (bssid != null) {
                        String replace = bssid.replace(":", "");
                        if (!"000000000000".equals(replace) && !"".equals(replace)) {
                            if (replace.equals("020000000000")) {
                            }
                        }
                        return null;
                    }
                    return connectionInfo;
                }
            } catch (Error | Exception unused) {
            }
        }
        return null;
    }

    public String n() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo m = a().m();
        if (m != null && m.getBSSID() != null) {
            String replace = m.getBSSID().replace(":", "");
            int rssi = m.getRssi();
            String o = a().o();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100 && !replace.equals("020000000000")) {
                stringBuffer.append("&wf=");
                stringBuffer.append(replace);
                stringBuffer.append(";");
                stringBuffer.append("" + rssi + ";");
                String ssid = m.getSSID();
                if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
                    ssid = ssid.replace("&", "_");
                }
                stringBuffer.append(ssid);
                stringBuffer.append("&wf_n=1");
                if (o != null) {
                    stringBuffer.append("&wf_gw=");
                    stringBuffer.append(o);
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public String o() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.c;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public l p() {
        l lVar = this.e;
        return (lVar == null || !lVar.k()) ? r() : this.e;
    }

    public l q() {
        l lVar = this.e;
        return (lVar == null || !lVar.l()) ? r() : this.e;
    }

    public l r() {
        WifiManager wifiManager = this.c;
        if (wifiManager != null) {
            try {
                return a(wifiManager, this.f);
            } catch (Exception unused) {
            }
        }
        return a((WifiManager) null, 0L);
    }

    public boolean s() {
        try {
            if (!this.c.isWifiEnabled()) {
                if (Build.VERSION.SDK_INT > 17) {
                    if (this.c.isScanAlwaysAvailable()) {
                    }
                }
                return false;
            }
            return true;
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }
}
