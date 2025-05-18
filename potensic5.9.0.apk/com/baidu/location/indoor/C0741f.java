package com.baidu.location.indoor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.location.p011g.ServiceC0717a;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.netty.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.baidu.location.indoor.f */
/* loaded from: classes.dex */
public class C0741f {

    /* renamed from: c */
    private static final char[] f1481c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: d */
    private static C0741f f1482d = null;

    /* renamed from: g */
    private Context f1487g;

    /* renamed from: h */
    private BluetoothAdapter f1488h;

    /* renamed from: k */
    private String f1491k;

    /* renamed from: o */
    private String f1495o;

    /* renamed from: p */
    private int f1496p;

    /* renamed from: q */
    private int f1497q;

    /* renamed from: r */
    private String f1498r;

    /* renamed from: e */
    private ConcurrentMap<String, ScanResult> f1485e = new ConcurrentHashMap();

    /* renamed from: f */
    private ConcurrentMap<String, List<ScanResult>> f1486f = new ConcurrentHashMap();

    /* renamed from: i */
    private volatile int f1489i = 0;

    /* renamed from: a */
    public volatile boolean f1483a = false;

    /* renamed from: j */
    private volatile boolean f1490j = false;

    /* renamed from: l */
    private long f1492l = -1;

    /* renamed from: m */
    private long f1493m = -1;

    /* renamed from: n */
    private Object f1494n = null;

    /* renamed from: b */
    public long f1484b = -1;

    /* renamed from: s */
    private long f1499s = 0;

    /* renamed from: t */
    private long f1500t = -1;

    /* renamed from: u */
    private long f1501u = 0;

    /* renamed from: com.baidu.location.indoor.f$a */
    public class a {

        /* renamed from: b */
        private String f1503b;

        /* renamed from: c */
        private String f1504c;

        /* renamed from: d */
        private String f1505d;

        /* renamed from: e */
        private int f1506e;

        /* renamed from: f */
        private int f1507f;

        /* renamed from: g */
        private int f1508g;

        /* renamed from: h */
        private long f1509h;

        public a(String str, String str2, int i, long j) {
            this.f1503b = str;
            this.f1504c = str2;
            this.f1508g = -i;
            this.f1509h = j / 1000000;
        }

        /* renamed from: a */
        public String m1228a() {
            return this.f1503b.toUpperCase() + ";" + this.f1508g + ";" + this.f1509h;
        }

        /* renamed from: a */
        public void m1229a(int i) {
            this.f1506e = i;
        }

        /* renamed from: a */
        public void m1230a(String str) {
            this.f1505d = str;
        }

        /* renamed from: b */
        public String m1231b() {
            return this.f1506e + "," + this.f1507f + "," + this.f1508g;
        }

        /* renamed from: b */
        public void m1232b(int i) {
            this.f1507f = i;
        }

        public String toString() {
            return this.f1504c + ";" + this.f1503b + ";" + this.f1505d + ";" + this.f1506e + ";" + this.f1507f + ";" + this.f1508g + ";" + this.f1509h;
        }
    }

    /* renamed from: com.baidu.location.indoor.f$b */
    class b implements Comparator<a> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return aVar.f1508g - aVar2.f1508g;
        }
    }

    private C0741f() {
    }

    /* renamed from: a */
    private a m1210a(ScanResult scanResult) {
        if (TextUtils.isEmpty(scanResult.getDevice().getAddress()) || scanResult.getRssi() > 0) {
            return null;
        }
        boolean z = false;
        a aVar = new a(scanResult.getDevice().getAddress().replaceAll(":", ""), scanResult.getDevice().getName(), scanResult.getRssi(), scanResult.getTimestampNanos());
        if (scanResult.getScanRecord() != null) {
            byte[] bytes = scanResult.getScanRecord().getBytes();
            int i = 2;
            while (true) {
                if (i > 5) {
                    break;
                }
                int i2 = i + 2;
                if ((bytes[i2] & 255) == 2 && (bytes[i + 3] & 255) == 21) {
                    z = true;
                    break;
                }
                if (((bytes[i] & 255) != 45 || (bytes[i + 1] & 255) != 36 || (bytes[i2] & 255) != 191 || (bytes[i + 3] & 255) != 22) && (bytes[i] & 255) == 173 && (bytes[i + 1] & 255) == 119 && (bytes[i2] & 255) == 0) {
                    int i3 = bytes[i + 3] & 255;
                }
                i++;
            }
            if (!z) {
                return aVar;
            }
            int i4 = ((bytes[i + 20] & 255) * 256) + (bytes[i + 21] & 255);
            int i5 = ((bytes[i + 22] & 255) * 256) + (bytes[i + 23] & 255);
            if (bytes.length > 26) {
                aVar.m1230a(m1212a(Arrays.copyOfRange(bytes, 9, 25)));
            }
            aVar.m1229a(i4);
            aVar.m1232b(i5);
        }
        return aVar;
    }

    /* renamed from: a */
    public static synchronized C0741f m1211a() {
        C0741f c0741f;
        synchronized (C0741f.class) {
            if (f1482d == null) {
                f1482d = new C0741f();
            }
            c0741f = f1482d;
        }
        return c0741f;
    }

    /* renamed from: a */
    private static String m1212a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f1481c;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        String str = new String(cArr);
        try {
            return str.toUpperCase();
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if (r3.f1487g.getPackageManager().hasSystemFeature("android.hardware.bluetooth") != false) goto L7;
     */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1216f() {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = r3.f1487g     // Catch: java.lang.Exception -> L1f
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L1f
            java.lang.String r2 = "android.hardware.bluetooth_le"
            boolean r1 = r1.hasSystemFeature(r2)     // Catch: java.lang.Exception -> L1f
            if (r1 != 0) goto L1d
            android.content.Context r1 = r3.f1487g     // Catch: java.lang.Exception -> L1f
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L1f
            java.lang.String r2 = "android.hardware.bluetooth"
            boolean r1 = r1.hasSystemFeature(r2)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto L23
        L1d:
            r1 = 1
            goto L24
        L1f:
            r1 = move-exception
            r1.printStackTrace()
        L23:
            r1 = r0
        L24:
            android.bluetooth.BluetoothAdapter r2 = r3.f1488h
            if (r2 == 0) goto L34
            if (r1 != 0) goto L2b
            goto L34
        L2b:
            boolean r0 = r2.isEnabled()     // Catch: java.lang.Exception -> L30
            return r0
        L30:
            r1 = move-exception
            r1.printStackTrace()
        L34:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0741f.m1216f():boolean");
    }

    /* renamed from: g */
    private void m1217g() {
        if (this.f1488h == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                this.f1494n = new C0742g(this);
                this.f1488h.getBluetoothLeScanner().startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), (ScanCallback) this.f1494n);
                this.f1483a = true;
                if (C0739d.m1200a().m1208b() != null || ServiceC0717a.m1087a() == null) {
                    return;
                }
                ServiceC0717a.m1087a().postDelayed(new RunnableC0743h(this), C0733o.f1351aK * 1000);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: h */
    private void m1218h() {
        this.f1485e.clear();
        this.f1495o = "";
        this.f1496p = -1;
        this.f1497q = -1;
        this.f1498r = "";
        this.f1491k = "";
        this.f1484b = -1L;
    }

    /* renamed from: i */
    private void m1219i() {
        if (System.currentTimeMillis() - this.f1501u <= Constant.DELAY_MILLIS || C0739d.m1200a().m1208b() == null) {
            return;
        }
        this.f1501u = System.currentTimeMillis();
        Handler m1087a = ServiceC0717a.m1087a();
        if (m1087a != null) {
            m1087a.postDelayed(new RunnableC0744i(this), 1000L);
            m1087a.postDelayed(new RunnableC0745j(this), SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m1220j() {
        ConcurrentMap<String, ScanResult> concurrentMap = this.f1485e;
        if (concurrentMap == null || concurrentMap.values().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f1485e.values());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        C0738c m1208b = C0739d.m1200a().m1208b();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a m1210a = m1210a((ScanResult) it.next());
            if (m1210a != null) {
                arrayList2.add(m1210a);
            }
        }
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, new b());
            sb.append(((a) arrayList2.get(0)).toString());
            for (int i = 1; i < arrayList2.size(); i++) {
                sb.append("|").append(((a) arrayList2.get(i)).toString());
            }
            if (m1208b != null) {
                int size = arrayList2.size();
                if (size > m1208b.m1189a()) {
                    size = m1208b.m1189a();
                }
                this.f1496p = size;
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar = (a) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(aVar.f1505d) && m1208b.f1438h != null) {
                        for (int i3 = 0; i3 < m1208b.f1438h.length; i3++) {
                            if (TextUtils.equals(aVar.f1505d, m1208b.f1438h[i3])) {
                                sb2.append(((a) arrayList2.get(i2)).m1228a()).append("|");
                                sb3.append(((a) arrayList2.get(i2)).m1231b()).append("|");
                            }
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(sb2) || TextUtils.isEmpty(sb2.toString())) {
            this.f1495o = "";
        } else {
            this.f1495o = sb2.toString();
        }
        if (TextUtils.isEmpty(sb3) || TextUtils.isEmpty(sb3.toString())) {
            this.f1498r = "";
        } else {
            this.f1498r = sb3.toString();
        }
        this.f1491k = sb.toString();
        this.f1492l = System.currentTimeMillis();
    }

    /* renamed from: k */
    private boolean m1221k() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f1484b;
        long j2 = currentTimeMillis - j;
        if (j2 > Constant.DELAY_MILLIS && j > 100000 && this.f1483a) {
            m1219i();
        }
        return Math.abs(j2) <= 5000 && Math.abs(currentTimeMillis - this.f1492l) <= 5000;
    }

    /* renamed from: b */
    public synchronized void m1222b() {
        if (m1216f()) {
            if (!this.f1483a) {
                m1217g();
            }
        }
    }

    /* renamed from: c */
    public synchronized void m1223c() {
        if (this.f1483a) {
            try {
                this.f1488h.getBluetoothLeScanner().stopScan((ScanCallback) this.f1494n);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f1489i = 0;
            this.f1483a = false;
            this.f1500t = System.currentTimeMillis();
            Context context = this.f1487g;
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("BluetoothManager", 0).edit();
                edit.putLong("lastStopScanBluetoothTime", this.f1500t);
                edit.apply();
            }
            m1218h();
        }
    }

    /* renamed from: d */
    public int m1224d() {
        return this.f1497q;
    }

    /* renamed from: e */
    public synchronized String m1225e() {
        if (!m1221k() || TextUtils.isEmpty(this.f1498r)) {
            return null;
        }
        return this.f1498r;
    }
}