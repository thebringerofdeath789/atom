package com.baidu.location.p010f;

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
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p006b.C0648b;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.netty.Constant;
import java.util.List;

/* renamed from: com.baidu.location.f.m */
/* loaded from: classes.dex */
public class C0715m {

    /* renamed from: a */
    public static long f1193a;

    /* renamed from: b */
    private static C0715m f1194b;

    /* renamed from: c */
    private WifiManager f1195c = null;

    /* renamed from: d */
    private a f1196d = null;

    /* renamed from: e */
    private C0714l f1197e = null;

    /* renamed from: f */
    private long f1198f = 0;

    /* renamed from: g */
    private long f1199g = 0;

    /* renamed from: h */
    private boolean f1200h = false;

    /* renamed from: i */
    private ConnectivityManager f1201i = null;

    /* renamed from: j */
    private Handler f1202j = new Handler();

    /* renamed from: k */
    private boolean f1203k = false;

    /* renamed from: l */
    private long f1204l = 0;

    /* renamed from: m */
    private long f1205m = 0;

    /* renamed from: com.baidu.location.f.m$a */
    private class a extends BroadcastReceiver {

        /* renamed from: b */
        private long f1207b;

        /* renamed from: c */
        private boolean f1208c;

        private a() {
            this.f1207b = 0L;
            this.f1208c = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                C0715m.f1193a = System.currentTimeMillis() / 1000;
                C0715m.this.f1202j.post(new RunnableC0716n(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.f1207b >= 5000) {
                this.f1207b = System.currentTimeMillis();
                if (this.f1208c) {
                    return;
                }
                this.f1208c = true;
            }
        }
    }

    private C0715m() {
    }

    /* renamed from: a */
    public static synchronized C0715m m1058a() {
        C0715m c0715m;
        synchronized (C0715m.class) {
            if (f1194b == null) {
                f1194b = new C0715m();
            }
            c0715m = f1194b;
        }
        return c0715m;
    }

    /* renamed from: a */
    private String m1059a(long j) {
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

    /* renamed from: a */
    public static boolean m1060a(C0714l c0714l, C0714l c0714l2) {
        boolean m1061a = m1061a(c0714l, c0714l2, C0733o.f1385az);
        long currentTimeMillis = System.currentTimeMillis() - C0648b.f423c;
        if (currentTimeMillis <= 0 || currentTimeMillis >= 30000 || !m1061a || c0714l2.m1052h() - c0714l.m1052h() <= 30) {
            return m1061a;
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m1061a(C0714l c0714l, C0714l c0714l2, float f) {
        if (c0714l != null && c0714l2 != null) {
            List<ScanResult> list = c0714l.f1188a;
            List<ScanResult> list2 = c0714l2.f1188a;
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
    /* renamed from: t */
    public void m1066t() {
        WifiManager wifiManager = this.f1195c;
        if (wifiManager == null) {
            return;
        }
        try {
            C0714l m1067a = m1067a(wifiManager, System.currentTimeMillis());
            if (m1067a.f1188a != null) {
                C0714l c0714l = this.f1197e;
                if (c0714l == null || !m1067a.m1041a(c0714l)) {
                    this.f1197e = m1067a;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public C0714l m1067a(WifiManager wifiManager, long j) {
        C0714l c0714l = new C0714l(null, 0L);
        return (wifiManager == null || C0733o.f1390f == 4) ? c0714l : new C0714l(wifiManager.getScanResults(), j);
    }

    /* renamed from: b */
    public void m1068b() {
        this.f1204l = 0L;
    }

    /* renamed from: c */
    public synchronized void m1069c() {
        if (this.f1200h) {
            return;
        }
        if (ServiceC0702f.isServing) {
            this.f1195c = (WifiManager) ServiceC0702f.getServiceContext().getApplicationContext().getSystemService("wifi");
            this.f1196d = new a();
            try {
                ServiceC0702f.getServiceContext().registerReceiver(this.f1196d, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception unused) {
            }
            this.f1200h = true;
        }
    }

    /* renamed from: d */
    public List<WifiConfiguration> m1070d() {
        try {
            WifiManager wifiManager = this.f1195c;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: e */
    public synchronized void m1071e() {
        if (this.f1200h) {
            try {
                ServiceC0702f.getServiceContext().unregisterReceiver(this.f1196d);
                f1193a = 0L;
            } catch (Exception unused) {
            }
            this.f1196d = null;
            this.f1195c = null;
            this.f1200h = false;
        }
    }

    /* renamed from: f */
    public boolean m1072f() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1199g;
        if (currentTimeMillis - j > 0 && currentTimeMillis - j <= 5000) {
            return false;
        }
        this.f1199g = currentTimeMillis;
        m1068b();
        return m1073g();
    }

    /* renamed from: g */
    public boolean m1073g() {
        if (this.f1195c == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1198f;
        if (currentTimeMillis - j > 0) {
            long j2 = currentTimeMillis - j;
            long j3 = this.f1204l;
            if (j2 <= j3 + 5000 || currentTimeMillis - (f1193a * 1000) <= j3 + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && currentTimeMillis - this.f1198f < 25000) {
                return false;
            }
            if (m1077k() && !m1074h() && currentTimeMillis - this.f1198f <= this.f1204l + Constant.DELAY_MILLIS) {
                return false;
            }
        }
        return m1076j();
    }

    /* renamed from: h */
    public boolean m1074h() {
        return false;
    }

    /* renamed from: i */
    public String m1075i() {
        WifiManager wifiManager = this.f1195c;
        if (wifiManager == null) {
            return "";
        }
        try {
            if (!wifiManager.isWifiEnabled()) {
                if (Build.VERSION.SDK_INT <= 17) {
                    return "";
                }
                if (!this.f1195c.isScanAlwaysAvailable()) {
                    return "";
                }
            }
            return "&wifio=1";
        } catch (Exception | NoSuchMethodError unused) {
            return "";
        }
    }

    /* renamed from: j */
    public boolean m1076j() {
        long currentTimeMillis = System.currentTimeMillis() - this.f1205m;
        if (currentTimeMillis >= 0 && currentTimeMillis <= SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            return false;
        }
        this.f1205m = System.currentTimeMillis();
        try {
            if ((this.f1195c.isWifiEnabled() || (Build.VERSION.SDK_INT > 17 && this.f1195c.isScanAlwaysAvailable())) && C0733o.f1390f != 4) {
                this.f1195c.startScan();
                this.f1198f = System.currentTimeMillis();
                return true;
            }
        } catch (Exception | NoSuchMethodError unused) {
        }
        return false;
    }

    /* renamed from: k */
    public boolean m1077k() {
        try {
            if (this.f1201i == null) {
                this.f1201i = (ConnectivityManager) ServiceC0702f.getServiceContext().getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.f1201i;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    /* renamed from: l */
    public boolean m1078l() {
        C0714l m1082p;
        try {
            if ((!this.f1195c.isWifiEnabled() && (Build.VERSION.SDK_INT <= 17 || !this.f1195c.isScanAlwaysAvailable())) || m1077k() || (m1082p = m1082p()) == null) {
                return false;
            }
            return m1082p.m1049e();
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    /* renamed from: m */
    public WifiInfo m1079m() {
        if (this.f1195c != null && C0733o.f1390f != 4) {
            try {
                WifiInfo connectionInfo = this.f1195c.getConnectionInfo();
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

    /* renamed from: n */
    public String m1080n() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo m1079m = m1058a().m1079m();
        if (m1079m != null && m1079m.getBSSID() != null) {
            String replace = m1079m.getBSSID().replace(":", "");
            int rssi = m1079m.getRssi();
            String m1081o = m1058a().m1081o();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (replace != null && rssi < 100 && !replace.equals("020000000000")) {
                stringBuffer.append("&wf=");
                stringBuffer.append(replace);
                stringBuffer.append(";");
                stringBuffer.append("" + rssi + ";");
                String ssid = m1079m.getSSID();
                if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
                    ssid = ssid.replace("&", "_");
                }
                stringBuffer.append(ssid);
                stringBuffer.append("&wf_n=1");
                if (m1081o != null) {
                    stringBuffer.append("&wf_gw=");
                    stringBuffer.append(m1081o);
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    /* renamed from: o */
    public String m1081o() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.f1195c;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return m1059a(dhcpInfo.gateway);
    }

    /* renamed from: p */
    public C0714l m1082p() {
        C0714l c0714l = this.f1197e;
        return (c0714l == null || !c0714l.m1055k()) ? m1084r() : this.f1197e;
    }

    /* renamed from: q */
    public C0714l m1083q() {
        C0714l c0714l = this.f1197e;
        return (c0714l == null || !c0714l.m1056l()) ? m1084r() : this.f1197e;
    }

    /* renamed from: r */
    public C0714l m1084r() {
        WifiManager wifiManager = this.f1195c;
        if (wifiManager != null) {
            try {
                return m1067a(wifiManager, this.f1198f);
            } catch (Exception unused) {
            }
        }
        return m1067a((WifiManager) null, 0L);
    }

    /* renamed from: s */
    public boolean m1085s() {
        try {
            if (!this.f1195c.isWifiEnabled()) {
                if (Build.VERSION.SDK_INT > 17) {
                    if (this.f1195c.isScanAlwaysAvailable()) {
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