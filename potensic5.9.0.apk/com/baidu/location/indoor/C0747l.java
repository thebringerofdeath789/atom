package com.baidu.location.indoor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.Build;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.baidu.location.indoor.l */
/* loaded from: classes.dex */
public class C0747l {

    /* renamed from: a */
    private static final char[] f1516a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private Context f1517b;

    /* renamed from: e */
    private BluetoothAdapter f1520e;

    /* renamed from: f */
    private boolean f1521f;

    /* renamed from: g */
    private c f1522g;

    /* renamed from: c */
    private boolean f1518c = false;

    /* renamed from: d */
    private boolean f1519d = false;

    /* renamed from: h */
    private boolean f1523h = false;

    /* renamed from: i */
    private String f1524i = null;

    /* renamed from: j */
    private String f1525j = null;

    /* renamed from: k */
    private int f1526k = -1;

    /* renamed from: l */
    private int f1527l = -1;

    /* renamed from: m */
    private long f1528m = -1;

    /* renamed from: n */
    private ConcurrentMap<String, ScanResult> f1529n = new ConcurrentHashMap();

    /* renamed from: o */
    private Object f1530o = null;

    /* renamed from: p */
    private long f1531p = 0;

    /* renamed from: q */
    private boolean f1532q = false;

    /* renamed from: r */
    private long f1533r = -1;

    /* renamed from: com.baidu.location.indoor.l$a */
    private class a {

        /* renamed from: a */
        public String f1534a;

        /* renamed from: b */
        public int f1535b;

        /* renamed from: c */
        public long f1536c;

        public a(String str, int i, long j) {
            this.f1534a = str;
            this.f1535b = i;
            this.f1536c = j / 1000000;
        }

        public String toString() {
            return this.f1534a.toUpperCase() + ";" + this.f1535b + ";" + this.f1536c;
        }
    }

    /* renamed from: com.baidu.location.indoor.l$b */
    private class b {

        /* renamed from: a */
        public String f1538a;

        /* renamed from: b */
        public String f1539b;

        /* renamed from: c */
        public int f1540c;

        /* renamed from: d */
        public String f1541d;

        public b(String str, int i, int i2, int i3) {
            this.f1538a = Integer.toHexString(i);
            this.f1539b = Integer.toHexString(i2);
            this.f1540c = i3;
            this.f1541d = str;
        }

        public String toString() {
            return this.f1541d + "," + this.f1538a + "," + this.f1539b + "," + this.f1540c;
        }
    }

    /* renamed from: com.baidu.location.indoor.l$c */
    public interface c {
        /* renamed from: a */
        void mo1252a(boolean z, String str, String str2, String str3);
    }

    /* renamed from: com.baidu.location.indoor.l$d */
    class d implements Comparator<b> {
        d() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar.f1540c - bVar2.f1540c;
        }
    }

    /* renamed from: com.baidu.location.indoor.l$e */
    class e implements Comparator<a> {
        e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(a aVar, a aVar2) {
            return aVar2.f1535b - aVar.f1535b;
        }
    }

    public C0747l(Context context) {
        this.f1521f = false;
        this.f1517b = context;
        if (this.f1520e == null) {
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    this.f1520e = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
                    this.f1521f = this.f1517b.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                } else {
                    this.f1520e = BluetoothAdapter.getDefaultAdapter();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m1234a(List<a> list, int i) {
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, new e());
        sb.append(list.get(0).toString());
        for (int i2 = 1; i2 < list.size() && i2 < i; i2++) {
            sb.append("|").append(list.get(i2).toString());
        }
        this.f1526k = list.size();
        return sb.toString();
    }

    /* renamed from: a */
    public static String m1235a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            int i3 = i * 2;
            char[] cArr2 = f1516a;
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

    /* renamed from: a */
    private void m1236a(ConcurrentMap<String, ScanResult> concurrentMap) {
        ArrayList arrayList = new ArrayList(concurrentMap.values());
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ScanResult scanResult = (ScanResult) it.next();
            Iterator it2 = it;
            arrayList3.add(new a(scanResult.getDevice().getAddress().replaceAll(":", ""), scanResult.getRssi(), scanResult.getTimestampNanos()));
            if (this.f1518c) {
                scanResult.getScanRecord().getAdvertiseFlags();
                byte[] bytes = scanResult.getScanRecord().getBytes();
                if (bytes.length >= 26) {
                    b m1244a = m1244a(bytes, scanResult.getRssi(), scanResult.getDevice().getAddress().replaceAll(":", ""));
                    if (m1244a != null) {
                        arrayList4.add(m1244a);
                    }
                    String m1235a = m1235a(Arrays.copyOfRange(bytes, 9, 25));
                    arrayList2.add(m1235a);
                    hashMap.put(m1235a, scanResult.getDevice().getName());
                    hashMap2.put(m1235a, m1235a(Arrays.copyOfRange(bytes, 0, 9)));
                    if (hashMap3.get(m1235a) == null) {
                        hashMap3.put(m1235a, 0);
                    }
                    hashMap3.put(m1235a, Integer.valueOf(((Integer) hashMap3.get(m1235a)).intValue() + 1));
                }
            }
            it = it2;
        }
        String str = null;
        int i = 0;
        for (String str2 : hashMap3.keySet()) {
            if (((Integer) hashMap3.get(str2)).intValue() > i) {
                i = ((Integer) hashMap3.get(str2)).intValue();
                str = str2;
            }
        }
        boolean z = i > 3;
        c cVar = this.f1522g;
        if (cVar != null && this.f1518c) {
            cVar.mo1252a(z, str, (String) hashMap.get(str), (String) hashMap2.get(str));
            this.f1518c = false;
        }
        if (arrayList3.size() > 2) {
            this.f1524i = m1234a(arrayList3, 32);
            this.f1525j = m1237b(arrayList4, 32);
        } else {
            this.f1524i = "";
            this.f1525j = "";
        }
        if (this.f1523h && C0739d.m1200a().m1208b() != null && m1239h() && !this.f1532q && m1240i()) {
            m1238g();
        }
    }

    /* renamed from: b */
    private String m1237b(List<b> list, int i) {
        if (list == null || list.size() <= 0) {
            this.f1527l = 0;
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, new d());
        sb.append(list.get(0).toString());
        for (int i2 = 1; i2 < list.size() && i2 < i; i2++) {
            sb.append("|").append(list.get(i2).toString());
        }
        this.f1527l = list.size();
        return sb.toString();
    }

    /* renamed from: g */
    private void m1238g() {
    }

    /* renamed from: h */
    private boolean m1239h() {
        return System.currentTimeMillis() - this.f1528m > 5000;
    }

    /* renamed from: i */
    private boolean m1240i() {
        return System.currentTimeMillis() - this.f1533r > 5000;
    }

    /* renamed from: j */
    private void m1241j() {
        this.f1524i = "";
        this.f1525j = "";
        this.f1527l = -1;
        this.f1526k = -1;
        this.f1528m = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b A[RETURN] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m1242k() {
        /*
            r7 = this;
            java.lang.String r0 = ""
            java.io.File r1 = new java.io.File
            android.content.Context r2 = r7.f1517b
            java.io.File r2 = r2.getCacheDir()
            java.lang.String r3 = "ibct"
            r1.<init>(r2, r3)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 != 0) goto L17
            return r3
        L17:
            r2 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Exception -> L42
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Exception -> L42
            r5.<init>(r1)     // Catch: java.lang.Exception -> L42
            r4.<init>(r5)     // Catch: java.lang.Exception -> L42
            r1 = r2
            r2 = r0
        L24:
            java.lang.String r1 = r4.readLine()     // Catch: java.lang.Exception -> L40
            if (r1 == 0) goto L3c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L40
            r5.<init>()     // Catch: java.lang.Exception -> L40
            java.lang.StringBuilder r2 = r5.append(r2)     // Catch: java.lang.Exception -> L40
            java.lang.StringBuilder r2 = r2.append(r1)     // Catch: java.lang.Exception -> L40
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L40
            goto L24
        L3c:
            r4.close()     // Catch: java.lang.Exception -> L42
            goto L4a
        L40:
            r2 = move-exception
            goto L46
        L42:
            r1 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L46:
            r2.printStackTrace()
            r2 = r1
        L4a:
            if (r2 == 0) goto L6d
            java.lang.String r1 = r2.trim()
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L57
            goto L6d
        L57:
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L6d
            long r0 = r0.longValue()     // Catch: java.lang.Exception -> L6d
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L6d
            long r4 = r4 - r0
            r0 = 259200(0x3f480, double:1.28062E-318)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 >= 0) goto L6d
            r0 = 1
            return r0
        L6d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.indoor.C0747l.m1242k():boolean");
    }

    /* renamed from: l */
    private void m1243l() {
        try {
            FileWriter fileWriter = new FileWriter(new File(this.f1517b.getCacheDir(), "ibct"));
            fileWriter.write(System.currentTimeMillis() + "");
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public b m1244a(byte[] bArr, int i, String str) {
        C0738c m1208b;
        int i2;
        boolean z;
        int i3 = -i;
        if (str == null || i3 < 0 || (m1208b = C0739d.m1200a().m1208b()) == null) {
            return null;
        }
        int i4 = 2;
        while (true) {
            if (i4 > 5) {
                z = false;
                break;
            }
            int i5 = i4 + 2;
            if ((bArr[i5] & 255) == 2 && (bArr[i4 + 3] & 255) == 21) {
                z = true;
                break;
            }
            if (((bArr[i4] & 255) != 45 || (bArr[i4 + 1] & 255) != 36 || (bArr[i5] & 255) != 191 || (bArr[i4 + 3] & 255) != 22) && (bArr[i4] & 255) == 173 && (bArr[i4 + 1] & 255) == 119 && (bArr[i5] & 255) == 0) {
                int i6 = bArr[i4 + 3] & 255;
            }
            i4++;
        }
        if (!z) {
            return null;
        }
        String m1235a = m1235a(Arrays.copyOfRange(bArr, 9, 25));
        String[] m1190b = m1208b.m1190b();
        if (m1190b != null && m1190b.length > 0) {
            for (String str2 : m1190b) {
                if (m1235a.equalsIgnoreCase(str2)) {
                    return new b(m1235a, ((bArr[i4 + 20] & 255) * 256) + (bArr[i4 + 21] & 255), ((bArr[i4 + 22] & 255) * 256) + (bArr[i4 + 23] & 255), i3);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public boolean m1245a() {
        BluetoothAdapter bluetoothAdapter = this.f1520e;
        if (bluetoothAdapter != null && this.f1521f) {
            try {
                return bluetoothAdapter.isEnabled();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m1246a(c cVar) {
        if (this.f1518c || this.f1519d) {
            return false;
        }
        this.f1519d = true;
        if (!m1245a() || m1242k()) {
            return false;
        }
        m1243l();
        this.f1522g = cVar;
        return true;
    }

    /* renamed from: b */
    public void m1247b() {
        this.f1519d = false;
        this.f1518c = false;
        this.f1532q = false;
        this.f1533r = -1L;
    }

    /* renamed from: c */
    public void m1248c() {
        if (this.f1523h) {
            try {
                BluetoothLeScanner bluetoothLeScanner = this.f1520e.getBluetoothLeScanner();
                if (bluetoothLeScanner != null) {
                    bluetoothLeScanner.stopScan((ScanCallback) this.f1530o);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this.f1523h = false;
            this.f1532q = false;
            this.f1533r = -1L;
            m1241j();
        }
    }

    /* renamed from: d */
    public String m1249d() {
        m1236a(this.f1529n);
        return this.f1524i;
    }

    /* renamed from: e */
    public long m1250e() {
        return this.f1528m;
    }

    /* renamed from: f */
    public boolean m1251f() {
        return System.currentTimeMillis() - this.f1528m <= SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    }
}