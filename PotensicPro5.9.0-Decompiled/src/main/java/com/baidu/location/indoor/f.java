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

/* loaded from: classes.dex */
public class f {
    private static final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static f d = null;
    private Context g;
    private BluetoothAdapter h;
    private String k;
    private String o;
    private int p;
    private int q;
    private String r;
    private ConcurrentMap<String, ScanResult> e = new ConcurrentHashMap();
    private ConcurrentMap<String, List<ScanResult>> f = new ConcurrentHashMap();
    private volatile int i = 0;
    public volatile boolean a = false;
    private volatile boolean j = false;
    private long l = -1;
    private long m = -1;
    private Object n = null;
    public long b = -1;
    private long s = 0;
    private long t = -1;
    private long u = 0;

    public class a {
        private String b;
        private String c;
        private String d;
        private int e;
        private int f;
        private int g;
        private long h;

        public a(String str, String str2, int i, long j) {
            this.b = str;
            this.c = str2;
            this.g = -i;
            this.h = j / 1000000;
        }

        public String a() {
            return this.b.toUpperCase() + ";" + this.g + ";" + this.h;
        }

        public void a(int i) {
            this.e = i;
        }

        public void a(String str) {
            this.d = str;
        }

        public String b() {
            return this.e + "," + this.f + "," + this.g;
        }

        public void b(int i) {
            this.f = i;
        }

        public String toString() {
            return this.c + ";" + this.b + ";" + this.d + ";" + this.e + ";" + this.f + ";" + this.g + ";" + this.h;
        }
    }

    class b implements Comparator<a> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return aVar.g - aVar2.g;
        }
    }

    private f() {
    }

    private a a(ScanResult scanResult) {
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
                aVar.a(a(Arrays.copyOfRange(bytes, 9, 25)));
            }
            aVar.a(i4);
            aVar.b(i5);
        }
        return aVar;
    }

    public static synchronized f a() {
        f fVar;
        synchronized (f.class) {
            if (d == null) {
                d = new f();
            }
            fVar = d;
        }
        return fVar;
    }

    private static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = c;
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
    
        if (r3.g.getPackageManager().hasSystemFeature("android.hardware.bluetooth") != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean f() {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = r3.g     // Catch: java.lang.Exception -> L1f
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch: java.lang.Exception -> L1f
            java.lang.String r2 = "android.hardware.bluetooth_le"
            boolean r1 = r1.hasSystemFeature(r2)     // Catch: java.lang.Exception -> L1f
            if (r1 != 0) goto L1d
            android.content.Context r1 = r3.g     // Catch: java.lang.Exception -> L1f
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
            android.bluetooth.BluetoothAdapter r2 = r3.h
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.f.f():boolean");
    }

    private void g() {
        if (this.h == null) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                this.n = new g(this);
                this.h.getBluetoothLeScanner().startScan((List<ScanFilter>) null, new ScanSettings.Builder().setScanMode(2).build(), (ScanCallback) this.n);
                this.a = true;
                if (d.a().b() != null || com.baidu.location.g.a.a() == null) {
                    return;
                }
                com.baidu.location.g.a.a().postDelayed(new h(this), com.baidu.location.h.o.aK * 1000);
            }
        } catch (Exception unused) {
        }
    }

    private void h() {
        this.e.clear();
        this.o = "";
        this.p = -1;
        this.q = -1;
        this.r = "";
        this.k = "";
        this.b = -1L;
    }

    private void i() {
        if (System.currentTimeMillis() - this.u <= Constant.DELAY_MILLIS || d.a().b() == null) {
            return;
        }
        this.u = System.currentTimeMillis();
        Handler a2 = com.baidu.location.g.a.a();
        if (a2 != null) {
            a2.postDelayed(new i(this), 1000L);
            a2.postDelayed(new j(this), SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        ConcurrentMap<String, ScanResult> concurrentMap = this.e;
        if (concurrentMap == null || concurrentMap.values().size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.e.values());
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        c b2 = d.a().b();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a a2 = a((ScanResult) it.next());
            if (a2 != null) {
                arrayList2.add(a2);
            }
        }
        if (arrayList2.size() > 0) {
            Collections.sort(arrayList2, new b());
            sb.append(((a) arrayList2.get(0)).toString());
            for (int i = 1; i < arrayList2.size(); i++) {
                sb.append("|").append(((a) arrayList2.get(i)).toString());
            }
            if (b2 != null) {
                int size = arrayList2.size();
                if (size > b2.a()) {
                    size = b2.a();
                }
                this.p = size;
                for (int i2 = 0; i2 < size; i2++) {
                    a aVar = (a) arrayList2.get(i2);
                    if (!TextUtils.isEmpty(aVar.d) && b2.h != null) {
                        for (int i3 = 0; i3 < b2.h.length; i3++) {
                            if (TextUtils.equals(aVar.d, b2.h[i3])) {
                                sb2.append(((a) arrayList2.get(i2)).a()).append("|");
                                sb3.append(((a) arrayList2.get(i2)).b()).append("|");
                            }
                        }
                    }
                }
            }
        }
        if (TextUtils.isEmpty(sb2) || TextUtils.isEmpty(sb2.toString())) {
            this.o = "";
        } else {
            this.o = sb2.toString();
        }
        if (TextUtils.isEmpty(sb3) || TextUtils.isEmpty(sb3.toString())) {
            this.r = "";
        } else {
            this.r = sb3.toString();
        }
        this.k = sb.toString();
        this.l = System.currentTimeMillis();
    }

    private boolean k() {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.b;
        long j2 = currentTimeMillis - j;
        if (j2 > Constant.DELAY_MILLIS && j > 100000 && this.a) {
            i();
        }
        return Math.abs(j2) <= 5000 && Math.abs(currentTimeMillis - this.l) <= 5000;
    }

    public synchronized void b() {
        if (f()) {
            if (!this.a) {
                g();
            }
        }
    }

    public synchronized void c() {
        if (this.a) {
            try {
                this.h.getBluetoothLeScanner().stopScan((ScanCallback) this.n);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.i = 0;
            this.a = false;
            this.t = System.currentTimeMillis();
            Context context = this.g;
            if (context != null) {
                SharedPreferences.Editor edit = context.getSharedPreferences("BluetoothManager", 0).edit();
                edit.putLong("lastStopScanBluetoothTime", this.t);
                edit.apply();
            }
            h();
        }
    }

    public int d() {
        return this.q;
    }

    public synchronized String e() {
        if (!k() || TextUtils.isEmpty(this.r)) {
            return null;
        }
        return this.r;
    }
}
