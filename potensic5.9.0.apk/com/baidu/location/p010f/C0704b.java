package com.baidu.location.p010f;

import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.p007c.C0675b;
import com.baidu.location.p012h.C0733o;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.lang3.StringUtils;

/* renamed from: com.baidu.location.f.b */
/* loaded from: classes.dex */
public class C0704b {

    /* renamed from: a */
    public static int f1026a;

    /* renamed from: b */
    public static int f1027b;

    /* renamed from: m */
    private static String f1028m;

    /* renamed from: n */
    private static Class<?> f1029n;

    /* renamed from: A */
    private int f1030A;

    /* renamed from: c */
    private TelephonyManager f1031c;

    /* renamed from: d */
    private TelephonyManager f1032d;

    /* renamed from: e */
    private TelephonyManager f1033e;

    /* renamed from: f */
    private SubscriptionManager f1034f;

    /* renamed from: g */
    private C0703a f1035g;

    /* renamed from: h */
    private C0703a f1036h;

    /* renamed from: i */
    private List<C0703a> f1037i;

    /* renamed from: j */
    private d f1038j;

    /* renamed from: k */
    private boolean f1039k;

    /* renamed from: l */
    private boolean f1040l;

    /* renamed from: o */
    private a f1041o;

    /* renamed from: p */
    private b f1042p;

    /* renamed from: q */
    private c f1043q;

    /* renamed from: r */
    private boolean f1044r;

    /* renamed from: s */
    private boolean f1045s;

    /* renamed from: t */
    private boolean f1046t;

    /* renamed from: u */
    private int f1047u;

    /* renamed from: v */
    private int f1048v;

    /* renamed from: w */
    private long f1049w;

    /* renamed from: x */
    private final Object f1050x;

    /* renamed from: y */
    private Handler f1051y;

    /* renamed from: z */
    private boolean f1052z;

    /* renamed from: com.baidu.location.f.b$a */
    private class a extends TelephonyManager.CellInfoCallback {
        private a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            C0704b.this.m931n();
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.location.f.b$b */
    private class b extends TelephonyManager.CellInfoCallback {
        private b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (C0704b.this.f1045s) {
                C0704b.this.f1044r = !r2.f1044r;
            }
            if (!C0704b.this.f1045s || C0704b.this.f1044r) {
                C0704b.this.m931n();
            }
        }
    }

    /* renamed from: com.baidu.location.f.b$c */
    private class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (C0704b.this.f1045s) {
                C0704b.this.f1044r = !r2.f1044r;
            }
            if (!C0704b.this.f1045s || C0704b.this.f1044r) {
                C0704b.this.m931n();
            }
        }
    }

    /* renamed from: com.baidu.location.f.b$d */
    private class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            C0704b.this.f1051y.post(new RunnableC0705c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            C0703a c0703a;
            int cdmaDbm;
            if (C0704b.this.f1035g != null) {
                if (C0704b.this.f1035g.f1018i == 'g') {
                    c0703a = C0704b.this.f1035g;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else {
                    if (C0704b.this.f1035g.f1018i != 'c') {
                        return;
                    }
                    c0703a = C0704b.this.f1035g;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                c0703a.f1017h = cdmaDbm;
            }
        }
    }

    /* renamed from: com.baidu.location.f.b$e */
    private static class e {

        /* renamed from: a */
        private static final C0704b f1057a = new C0704b();
    }

    /* renamed from: com.baidu.location.f.b$f */
    private static class f implements Comparator<C0711i> {
        private f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C0711i c0711i, C0711i c0711i2) {
            return c0711i.f1166g - c0711i2.f1166g;
        }
    }

    private C0704b() {
        this.f1031c = null;
        this.f1032d = null;
        this.f1033e = null;
        this.f1034f = null;
        this.f1035g = new C0703a();
        this.f1036h = null;
        this.f1037i = null;
        this.f1038j = null;
        this.f1039k = false;
        this.f1040l = false;
        this.f1044r = true;
        this.f1045s = false;
        this.f1046t = false;
        this.f1047u = -1;
        this.f1048v = -1;
        this.f1049w = 0L;
        this.f1050x = new Object();
        this.f1051y = new Handler();
        this.f1052z = false;
        this.f1030A = 30;
        if (Build.VERSION.SDK_INT >= this.f1030A) {
            this.f1052z = C0733o.m1154b("android.telephony.TelephonyManager$CellInfoCallback");
        }
    }

    /* renamed from: a */
    private static int m905a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    /* renamed from: a */
    public static int m906a(CellIdentityNr cellIdentityNr) {
        try {
            return C0733o.m1136a(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: a */
    public static int m907a(String str) {
        if (str == null || !str.contains("mNrTac")) {
            return -1;
        }
        Matcher matcher = Pattern.compile("mNrTac=(.+?)\\}").matcher(str.replace(StringUtils.SPACE, ""));
        while (true) {
            int i = -1;
            while (matcher.find()) {
                if (matcher.groupCount() >= 1) {
                    try {
                        i = Integer.parseInt(matcher.group(1));
                    } catch (Throwable unused) {
                    }
                }
            }
            return i;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x00ea, code lost:
    
        if (r0 < 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x00ed, code lost:
    
        if (r0 > 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0134, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0187, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0066, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 28) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0068, code lost:
    
        r4.f1019j = r18.getCellConnectionStatus();
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.location.p010f.C0703a m908a(android.telephony.CellInfo r18, com.baidu.location.p010f.C0703a r19, android.telephony.TelephonyManager r20) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p010f.C0704b.m908a(android.telephony.CellInfo, com.baidu.location.f.a, android.telephony.TelephonyManager):com.baidu.location.f.a");
    }

    /* renamed from: a */
    private C0703a m909a(CellLocation cellLocation) {
        return m910a(cellLocation, false);
    }

    /* renamed from: a */
    private C0703a m910a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.f1031c == null) {
            return null;
        }
        C0703a c0703a = new C0703a();
        c0703a.f1021l = 1;
        if (z) {
            c0703a.m900f();
        }
        c0703a.f1016g = System.currentTimeMillis();
        try {
            String networkOperator = this.f1031c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    c0703a.f1012c = i < 0 ? this.f1035g.f1012c : i;
                }
                String substring = networkOperator.substring(3);
                if (substring != null) {
                    char[] charArray = substring.toCharArray();
                    int i2 = 0;
                    while (i2 < charArray.length && Character.isDigit(charArray[i2])) {
                        i2++;
                    }
                    i = Integer.valueOf(substring.substring(0, i2)).intValue();
                }
                if (i < 0) {
                    i = this.f1035g.f1013d;
                }
                c0703a.f1013d = i;
            }
            f1026a = this.f1031c.getSimState();
        } catch (Exception unused) {
            f1027b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            c0703a.f1010a = ((GsmCellLocation) cellLocation).getLac();
            c0703a.f1011b = r9.getCid();
            c0703a.f1018i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            c0703a.f1018i = 'c';
            if (f1029n == null) {
                try {
                    f1029n = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    f1029n = null;
                    return c0703a;
                }
            }
            Class<?> cls = f1029n;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.f1035g.f1013d;
                    }
                    c0703a.f1013d = systemId;
                    c0703a.f1011b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    c0703a.f1010a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        c0703a.f1014e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        c0703a.f1015f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    f1027b = 3;
                    return c0703a;
                }
            }
        }
        m921d(c0703a);
        return c0703a;
    }

    /* renamed from: a */
    public static C0703a m911a(C0703a c0703a, TelephonyManager telephonyManager, boolean z) {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            f1026a = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            C0703a c0703a2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z2 = c0703a2 != null;
                    C0703a m908a = m908a(cellInfo, c0703a, telephonyManager);
                    if (m908a != null) {
                        if (!m908a.m896b()) {
                            m908a = null;
                        } else if (z2 && c0703a2 != null) {
                            c0703a2.f1022m = m908a.m904j();
                            c0703a2.f1023n = m908a.m902h();
                        }
                        if (c0703a2 == null) {
                            c0703a2 = m908a;
                        }
                    }
                }
            }
            f1028m = m914a(m918b(arrayList));
            return c0703a2;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C0704b m912a() {
        return e.f1057a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private static C0711i m913a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        C0711i c0711i;
        long elapsedRealtimeNanos;
        C0713k c0713k;
        long elapsedRealtimeNanos2;
        C0712j c0712j;
        long elapsedRealtimeNanos3;
        long currentTimeMillis;
        long elapsedRealtimeNanos4;
        long currentTimeMillis2;
        long elapsedRealtimeNanos5;
        long currentTimeMillis3;
        long elapsedRealtimeNanos6;
        long currentTimeMillis4;
        int i = Build.VERSION.SDK_INT;
        CellIdentityNr cellIdentityNr = null;
        if (i < 17) {
            return null;
        }
        try {
            if (cellInfo instanceof CellInfoGsm) {
                C0711i c0711i2 = new C0711i();
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                c0711i2.f1160a = 1;
                if (cellInfo.isRegistered()) {
                    c0711i2.f1163d = 1;
                }
                if (i >= 28) {
                    c0711i2.f1161b = cellIdentity.getMccString();
                    c0711i2.f1162c = cellIdentity.getMncString();
                    c0711i2.f1165f = cellInfo.getCellConnectionStatus();
                } else {
                    c0711i2.f1161b = cellIdentity.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity.getMcc());
                    c0711i2.f1162c = cellIdentity.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity.getMnc()) : null;
                }
                if (i >= 30) {
                    elapsedRealtimeNanos6 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    currentTimeMillis4 = System.currentTimeMillis();
                } else {
                    elapsedRealtimeNanos6 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    currentTimeMillis4 = System.currentTimeMillis();
                }
                c0711i2.f1164e = currentTimeMillis4 - elapsedRealtimeNanos6;
                c0711i = c0711i2;
            } else {
                if (cellInfo instanceof CellInfoCdma) {
                    C0711i c0711i3 = new C0711i();
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    c0711i3.f1160a = 2;
                    c0711i3.f1162c = cellIdentity2.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity2.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        c0711i3.f1163d = 1;
                    }
                    if (i >= 28) {
                        c0711i3.f1165f = cellInfo.getCellConnectionStatus();
                    }
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            c0711i3.f1161b = networkOperator.substring(0, 3);
                        }
                    } catch (Exception unused) {
                    }
                    try {
                        if (i >= 30) {
                            elapsedRealtimeNanos5 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                            currentTimeMillis3 = System.currentTimeMillis();
                        } else {
                            elapsedRealtimeNanos5 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            currentTimeMillis3 = System.currentTimeMillis();
                        }
                        c0711i3.f1164e = currentTimeMillis3 - elapsedRealtimeNanos5;
                    } catch (Error unused2) {
                        c0711i3.f1164e = System.currentTimeMillis();
                    }
                    return c0711i3;
                }
                if (cellInfo instanceof CellInfoWcdma) {
                    C0711i c0711i4 = new C0711i();
                    CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    c0711i4.f1160a = 4;
                    if (cellInfo.isRegistered()) {
                        c0711i4.f1163d = 1;
                    }
                    if (i >= 28) {
                        c0711i4.f1161b = cellIdentity3.getMccString();
                        c0711i4.f1162c = cellIdentity3.getMncString();
                        c0711i4.f1165f = cellInfo.getCellConnectionStatus();
                    } else {
                        c0711i4.f1161b = cellIdentity3.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity3.getMcc());
                        c0711i4.f1162c = cellIdentity3.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity3.getMnc()) : null;
                    }
                    if (i >= 30) {
                        elapsedRealtimeNanos4 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                        currentTimeMillis2 = System.currentTimeMillis();
                    } else {
                        elapsedRealtimeNanos4 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                        currentTimeMillis2 = System.currentTimeMillis();
                    }
                    c0711i4.f1164e = currentTimeMillis2 - elapsedRealtimeNanos4;
                    c0711i = c0711i4;
                } else {
                    if (cellInfo instanceof CellInfoTdscdma) {
                        if (i < 28) {
                            return null;
                        }
                        C0711i c0711i5 = new C0711i();
                        CellIdentityTdscdma cellIdentity4 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        c0711i5.f1160a = 5;
                        if (cellInfo.isRegistered()) {
                            c0711i5.f1163d = 1;
                        }
                        c0711i5.f1161b = cellIdentity4.getMccString();
                        c0711i5.f1162c = cellIdentity4.getMncString();
                        c0711i5.f1165f = cellInfo.getCellConnectionStatus();
                        try {
                            if (i >= 30) {
                                elapsedRealtimeNanos3 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                currentTimeMillis = System.currentTimeMillis();
                            } else {
                                elapsedRealtimeNanos3 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            c0711i5.f1164e = currentTimeMillis - elapsedRealtimeNanos3;
                            return c0711i5;
                        } catch (Error unused3) {
                            c0711i5.f1164e = System.currentTimeMillis();
                            return c0711i5;
                        }
                    }
                    if (cellInfo instanceof CellInfoLte) {
                        C0712j c0712j2 = new C0712j();
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity5 = cellInfoLte.getCellIdentity();
                        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                        C0712j c0712j3 = c0712j2;
                        c0712j3.f1160a = 3;
                        if (cellInfo.isRegistered()) {
                            c0712j3.f1163d = 1;
                        }
                        c0712j3.f1167h = cellIdentity5.getCi();
                        c0712j3.f1168i = cellIdentity5.getPci();
                        c0712j3.f1169j = cellIdentity5.getTac();
                        c0712j3.f1177r = cellSignalStrength.getTimingAdvance();
                        if (i >= 28) {
                            c0712j3.f1161b = cellIdentity5.getMccString();
                            c0712j3.f1162c = cellIdentity5.getMncString();
                            c0712j3.f1165f = cellInfo.getCellConnectionStatus();
                            c0712j3.f1171l = cellIdentity5.getBandwidth();
                        } else {
                            if (cellIdentity5.getMcc() != Integer.MAX_VALUE) {
                                c0712j3.f1161b = String.valueOf(cellIdentity5.getMcc());
                            }
                            if (cellIdentity5.getMnc() != Integer.MAX_VALUE) {
                                c0712j3.f1162c = String.valueOf(cellIdentity5.getMnc());
                            }
                        }
                        if (i >= 24) {
                            c0712j3.f1170k = cellIdentity5.getEarfcn();
                        }
                        if (i >= 29) {
                            c0712j3.f1172m = Math.abs(cellSignalStrength.getRssi());
                        }
                        if (i >= 26) {
                            c0712j3.f1173n = Math.abs(cellSignalStrength.getRsrp());
                            c0712j3.f1166g = Math.abs(cellSignalStrength.getRsrp());
                            c0712j3.f1174o = cellSignalStrength.getRsrq();
                            c0712j3.f1175p = cellSignalStrength.getRssnr();
                            c0712j3.f1176q = cellSignalStrength.getCqi();
                        }
                        try {
                            if (i >= 30) {
                                elapsedRealtimeNanos2 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                c0712j = c0712j2;
                            } else {
                                elapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                c0712j = c0712j2;
                            }
                            c0712j.f1164e = System.currentTimeMillis() - elapsedRealtimeNanos2;
                            return c0712j2;
                        } catch (Error unused4) {
                            c0712j3.f1164e = System.currentTimeMillis();
                            return c0712j2;
                        }
                    }
                    if (!(cellInfo instanceof CellInfoNr) || i < 29) {
                        return null;
                    }
                    C0713k c0713k2 = new C0713k();
                    try {
                        cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                    if (cellIdentityNr != null) {
                        C0713k c0713k3 = c0713k2;
                        c0713k3.f1160a = 6;
                        c0713k3.f1161b = cellIdentityNr.getMccString();
                        c0713k3.f1162c = cellIdentityNr.getMncString();
                        c0713k3.f1178h = cellIdentityNr.getNci();
                        c0713k3.f1179i = cellIdentityNr.getPci();
                        c0713k3.f1180j = cellIdentityNr.getTac();
                        if (c0713k3.f1180j == Integer.MAX_VALUE) {
                            try {
                                c0713k2.f1180j = m906a(cellIdentityNr);
                            } catch (Throwable unused5) {
                            }
                        }
                        if (c0713k3.f1180j == Integer.MAX_VALUE) {
                            try {
                                c0713k2.f1180j = m907a(cellIdentityNr.toString());
                            } catch (Throwable unused6) {
                            }
                        }
                        c0713k3.f1181k = cellIdentityNr.getNrarfcn();
                    }
                    if (cellInfo.isRegistered()) {
                        c0713k2.f1163d = 1;
                    }
                    C0713k c0713k4 = c0713k2;
                    c0713k4.f1165f = cellInfo.getCellConnectionStatus();
                    c0713k4.f1182l = Math.abs(cellSignalStrengthNr.getSsRsrp());
                    c0713k4.f1166g = Math.abs(cellSignalStrengthNr.getSsRsrp());
                    c0713k4.f1183m = cellSignalStrengthNr.getSsRsrq();
                    c0713k4.f1184n = cellSignalStrengthNr.getSsSinr();
                    c0713k4.f1185o = Math.abs(cellSignalStrengthNr.getCsiRsrp());
                    c0713k4.f1186p = cellSignalStrengthNr.getCsiRsrq();
                    c0713k4.f1187q = cellSignalStrengthNr.getCsiSinr();
                    try {
                        if (i >= 30) {
                            elapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                            c0713k = c0713k2;
                        } else {
                            elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            c0713k = c0713k2;
                        }
                        c0713k.f1164e = System.currentTimeMillis() - elapsedRealtimeNanos;
                        c0711i = c0713k2;
                    } catch (Error unused7) {
                        c0713k4.f1164e = System.currentTimeMillis();
                        c0711i = c0713k2;
                    }
                }
            }
        } catch (Error unused8) {
            telephonyManager.f1164e = System.currentTimeMillis();
            c0711i = telephonyManager;
        }
        return c0711i;
    }

    /* renamed from: a */
    private static String m914a(List<C0711i> list) {
        if (list == null || list.size() == 0) {
        }
        return null;
    }

    /* renamed from: b */
    private int m917b(String str) {
        if (str == null || !str.contains("cl_s2")) {
            return -1;
        }
        try {
            Matcher matcher = Pattern.compile("cl_s2=[0-9]{1,}").matcher(str);
            if (!matcher.find()) {
                return -1;
            }
            String group = matcher.group();
            return Integer.parseInt(group.substring(group.indexOf("cl_s2=") + 6, group.length()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* renamed from: b */
    private static List<C0711i> m918b(List<C0711i> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new f());
        return list.subList(0, list.size());
    }

    /* renamed from: d */
    private void m921d(C0703a c0703a) {
        C0703a c0703a2;
        C0703a c0703a3 = this.f1035g;
        if (c0703a.m896b() && ((c0703a2 = this.f1035g) == null || !c0703a2.m895a(c0703a) || m933a(this.f1035g, c0703a))) {
            this.f1035g = c0703a;
        }
        if (c0703a.m896b()) {
            if (c0703a3 == null || !c0703a3.m895a(c0703a)) {
                if (!c0703a.m896b()) {
                    List<C0703a> list = this.f1037i;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.f1037i.size();
                C0703a c0703a4 = size == 0 ? null : this.f1037i.get(size - 1);
                if (c0703a4 != null && c0703a4.f1011b == this.f1035g.f1011b && c0703a4.f1010a == this.f1035g.f1010a) {
                    return;
                }
                this.f1037i.add(this.f1035g);
                if (this.f1037i.size() > 3) {
                    this.f1037i.remove(0);
                }
                m928k();
                this.f1040l = false;
            }
        }
    }

    /* renamed from: e */
    private String m924e(C0703a c0703a) {
        C0703a m908a;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.f1031c.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (m908a = m908a(cellInfo, this.f1035g, this.f1031c)) != null) {
                            if (m908a.f1010a != -1 && m908a.f1011b != -1) {
                                sb.append(m908a.f1012c).append("|").append(m908a.f1013d).append("|").append(m908a.f1010a).append("|").append(m908a.f1011b).append("|").append(m908a.f1017h).append(";");
                            }
                            if (Build.VERSION.SDK_INT > 28 && m908a.f1020k == 6 && m908a.f1024o != null && m908a.m896b()) {
                                if (sb2 == null) {
                                    StringBuilder sb3 = new StringBuilder();
                                    try {
                                        sb3.append("&ncnr=");
                                        sb2 = sb3;
                                    } catch (Throwable unused) {
                                        sb2 = sb3;
                                    }
                                }
                                sb2.append(m908a.m902h());
                                sb2.append("_");
                                sb2.append(m908a.f1024o);
                                sb2.append(";");
                            }
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
        return sb2 != null ? sb.toString() + sb2.toString() : sb.toString();
    }

    /* renamed from: i */
    public static String m926i() {
        String str = f1028m;
        if (str == null || str.length() == 0) {
            return null;
        }
        return f1028m.replace("\n", "");
    }

    /* renamed from: j */
    private void m927j() {
        String m1164f = C0733o.m1164f();
        if (m1164f == null) {
            return;
        }
        File file = new File(m1164f + File.separator + "lcvif2.dat");
        if (file.exists()) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
                long j = 0;
                randomAccessFile.seek(0L);
                if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                    randomAccessFile.close();
                    file.delete();
                    return;
                }
                randomAccessFile.readInt();
                int i = 0;
                while (i < 3) {
                    long readLong = randomAccessFile.readLong();
                    int readInt = randomAccessFile.readInt();
                    int readInt2 = randomAccessFile.readInt();
                    int readInt3 = randomAccessFile.readInt();
                    long readLong2 = randomAccessFile.readLong();
                    int readInt4 = randomAccessFile.readInt();
                    char c2 = readInt4 == 1 ? 'g' : (char) 0;
                    if (readInt4 == 2) {
                        c2 = 'c';
                    }
                    if (readLong != j) {
                        C0703a c0703a = new C0703a(readInt3, readLong2, readInt, readInt2, 0, c2, -1);
                        c0703a.f1016g = readLong;
                        if (c0703a.m896b()) {
                            this.f1040l = true;
                            this.f1037i.add(c0703a);
                        }
                    }
                    i++;
                    j = 0;
                }
                randomAccessFile.close();
            } catch (Exception unused) {
                file.delete();
            }
        }
    }

    /* renamed from: k */
    private void m928k() {
        List<C0703a> list = this.f1037i;
        if (list == null && this.f1036h == null) {
            return;
        }
        if (list == null && this.f1036h != null) {
            LinkedList linkedList = new LinkedList();
            this.f1037i = linkedList;
            linkedList.add(this.f1036h);
        }
        String m1164f = C0733o.m1164f();
        if (m1164f == null || this.f1037i == null) {
            return;
        }
        File file = new File(m1164f + File.separator + "lcvif2.dat");
        int size = this.f1037i.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.f1037i.get(size - 1).f1016g);
            randomAccessFile.writeInt(size);
            for (int i = 0; i < 3 - size; i++) {
                randomAccessFile.writeLong(0L);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeInt(-1);
                randomAccessFile.writeLong(-1L);
                randomAccessFile.writeInt(2);
            }
            for (int i2 = 0; i2 < size; i2++) {
                randomAccessFile.writeLong(this.f1037i.get(i2).f1016g);
                randomAccessFile.writeInt(this.f1037i.get(i2).f1012c);
                randomAccessFile.writeInt(this.f1037i.get(i2).f1013d);
                randomAccessFile.writeInt(this.f1037i.get(i2).f1010a);
                randomAccessFile.writeLong(this.f1037i.get(i2).f1011b);
                if (this.f1037i.get(i2).f1018i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.f1037i.get(i2).f1018i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    /* renamed from: l */
    private void m929l() {
        if (this.f1041o == null) {
            this.f1041o = new a();
        }
        this.f1031c.requestCellInfoUpdate(ServiceC0702f.getServiceContext().getMainExecutor(), this.f1041o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public synchronized void m930m() {
        CellLocation cellLocation;
        C0703a m911a = m911a(this.f1035g, this.f1031c, false);
        if (m911a != null) {
            m921d(m911a);
        }
        if (Build.VERSION.SDK_INT <= 28 && (m911a == null || !m911a.m896b())) {
            try {
                cellLocation = this.f1031c.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                m909a(cellLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m931n() {
        try {
            m930m();
            synchronized (this.f1050x) {
                this.f1050x.notifyAll();
            }
        } catch (Exception unused) {
        }
        C0675b.m634a().m644e();
    }

    /* renamed from: a */
    public HashSet<String> m932a(C0703a c0703a) {
        C0703a m908a;
        HashSet<String> hashSet = new HashSet<>();
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                List<CellInfo> allCellInfo = this.f1031c.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (m908a = m908a(cellInfo, this.f1035g, this.f1031c)) != null) {
                            String str = "";
                            if (m908a.f1010a != -1 && m908a.f1011b != -1) {
                                str = (c0703a.f1010a != m908a.f1010a ? new StringBuilder().append(m908a.f1010a).append("|").append(m908a.f1011b) : new StringBuilder().append(m908a.f1011b).append("")).toString();
                            }
                            hashSet.add(str);
                        }
                    }
                }
            } catch (Exception | NoSuchMethodError e2) {
                e2.printStackTrace();
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public boolean m933a(C0703a c0703a, C0703a c0703a2) {
        boolean z;
        if (c0703a == null && c0703a2 == null) {
            return false;
        }
        if (c0703a == null || c0703a2 == null) {
            return true;
        }
        float f2 = C0733o.f1348aH;
        float abs = Math.abs(c0703a.f1017h - c0703a2.f1017h) / (c0703a.f1017h != 0 ? c0703a.f1017h : -1);
        if (c0703a.f1022m != null && c0703a2.f1022m != null) {
            if (Math.abs(Math.abs(r7 - m917b(c0703a2.f1022m)) / (m917b(c0703a.f1022m) != 0 ? r7 : -1)) > f2) {
                z = true;
                return abs <= f2 || z;
            }
        }
        z = false;
        if (abs <= f2) {
        }
    }

    /* renamed from: b */
    public String m934b(C0703a c0703a) {
        String m924e;
        int intValue;
        String str = "";
        try {
            m924e = m924e(c0703a);
            intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (m924e != null && !m924e.equals("")) {
                if (!m924e.equals("&nc=")) {
                    return m924e;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (intValue >= 17) {
            return m924e;
        }
        str = m924e;
        if (str == null || !str.equals("&nc=")) {
            return str;
        }
        return null;
    }

    /* renamed from: b */
    public synchronized void m935b() {
        if (this.f1039k) {
            return;
        }
        if (ServiceC0702f.isServing) {
            this.f1031c = (TelephonyManager) ServiceC0702f.getServiceContext().getSystemService("phone");
            this.f1037i = new LinkedList();
            this.f1038j = new d();
            m927j();
            if (this.f1031c != null && this.f1038j != null) {
                if (Build.VERSION.SDK_INT < this.f1030A || !this.f1052z) {
                    try {
                        this.f1031c.listen(this.f1038j, 1280);
                    } catch (Exception unused) {
                    }
                }
                this.f1039k = true;
            }
        }
    }

    /* renamed from: c */
    public String m936c(C0703a c0703a) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(c0703a.f1018i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(c0703a.f1012c), Integer.valueOf(c0703a.f1013d), Integer.valueOf(c0703a.f1010a), Long.valueOf(c0703a.f1011b), Integer.valueOf(c0703a.f1017h)));
        if (c0703a.f1014e < Integer.MAX_VALUE && c0703a.f1015f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(c0703a.f1015f / 14400.0d), Double.valueOf(c0703a.f1014e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(c0703a.f1016g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(c0703a.f1021l);
        stringBuffer.append("&clp=");
        stringBuffer.append(c0703a.f1020k);
        if (c0703a.f1024o != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(c0703a.f1024o);
        }
        if (Build.VERSION.SDK_INT >= 28 && c0703a.f1019j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(c0703a.f1019j);
        }
        try {
            List<C0703a> list = this.f1037i;
            if (list != null && list.size() > 0) {
                int size = this.f1037i.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    C0703a c0703a2 = this.f1037i.get(i);
                    if (c0703a2 != null) {
                        if (c0703a2.f1012c != c0703a.f1012c) {
                            stringBuffer.append(c0703a2.f1012c);
                        }
                        stringBuffer.append("|");
                        if (c0703a2.f1013d != c0703a.f1013d) {
                            stringBuffer.append(c0703a2.f1013d);
                        }
                        stringBuffer.append("|");
                        if (c0703a2.f1010a != c0703a.f1010a) {
                            stringBuffer.append(c0703a2.f1010a);
                        }
                        stringBuffer.append("|");
                        if (c0703a2.f1011b != c0703a.f1011b) {
                            stringBuffer.append(c0703a2.f1011b);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - c0703a2.f1016g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (f1026a > 100) {
            f1026a = 0;
        }
        stringBuffer.append("&cs=" + (f1026a + (f1027b << 8)));
        if (c0703a.f1022m != null) {
            stringBuffer.append(c0703a.f1022m);
        }
        stringBuffer.append("&cl_list=").append(m926i());
        return stringBuffer.toString();
    }

    /* renamed from: c */
    public synchronized void m937c() {
        TelephonyManager telephonyManager;
        if (this.f1039k) {
            d dVar = this.f1038j;
            if (dVar != null && (telephonyManager = this.f1031c) != null) {
                telephonyManager.listen(dVar, 0);
            }
            this.f1038j = null;
            this.f1031c = null;
            this.f1032d = null;
            this.f1033e = null;
            this.f1037i.clear();
            this.f1037i = null;
            m928k();
            this.f1039k = false;
        }
    }

    /* renamed from: d */
    public boolean m938d() {
        return this.f1040l;
    }

    /* renamed from: e */
    public int m939e() {
        TelephonyManager telephonyManager = this.f1031c;
        if (telephonyManager == null) {
            return 0;
        }
        try {
            return telephonyManager.getNetworkType();
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x00ff, code lost:
    
        if (r0 != false) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00a3 A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:51:0x0041, B:53:0x0045, B:54:0x0054, B:56:0x0064, B:58:0x0067, B:60:0x006d, B:62:0x0070, B:63:0x0072, B:65:0x0078, B:67:0x007e, B:68:0x0083, B:70:0x0089, B:72:0x008d, B:73:0x008f, B:74:0x009f, B:76:0x00a3, B:77:0x00aa, B:79:0x00ae, B:80:0x00bf, B:82:0x00c5, B:84:0x00c9, B:85:0x00cb, B:86:0x00db, B:88:0x00df, B:89:0x00e6, B:91:0x00ea, B:92:0x00fb, B:95:0x00d2, B:97:0x00d6, B:98:0x00f9, B:99:0x0096, B:101:0x009a, B:102:0x00bd, B:103:0x0081), top: B:50:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ae A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:51:0x0041, B:53:0x0045, B:54:0x0054, B:56:0x0064, B:58:0x0067, B:60:0x006d, B:62:0x0070, B:63:0x0072, B:65:0x0078, B:67:0x007e, B:68:0x0083, B:70:0x0089, B:72:0x008d, B:73:0x008f, B:74:0x009f, B:76:0x00a3, B:77:0x00aa, B:79:0x00ae, B:80:0x00bf, B:82:0x00c5, B:84:0x00c9, B:85:0x00cb, B:86:0x00db, B:88:0x00df, B:89:0x00e6, B:91:0x00ea, B:92:0x00fb, B:95:0x00d2, B:97:0x00d6, B:98:0x00f9, B:99:0x0096, B:101:0x009a, B:102:0x00bd, B:103:0x0081), top: B:50:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00df A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:51:0x0041, B:53:0x0045, B:54:0x0054, B:56:0x0064, B:58:0x0067, B:60:0x006d, B:62:0x0070, B:63:0x0072, B:65:0x0078, B:67:0x007e, B:68:0x0083, B:70:0x0089, B:72:0x008d, B:73:0x008f, B:74:0x009f, B:76:0x00a3, B:77:0x00aa, B:79:0x00ae, B:80:0x00bf, B:82:0x00c5, B:84:0x00c9, B:85:0x00cb, B:86:0x00db, B:88:0x00df, B:89:0x00e6, B:91:0x00ea, B:92:0x00fb, B:95:0x00d2, B:97:0x00d6, B:98:0x00f9, B:99:0x0096, B:101:0x009a, B:102:0x00bd, B:103:0x0081), top: B:50:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ea A[Catch: Exception -> 0x00ff, TryCatch #0 {Exception -> 0x00ff, blocks: (B:51:0x0041, B:53:0x0045, B:54:0x0054, B:56:0x0064, B:58:0x0067, B:60:0x006d, B:62:0x0070, B:63:0x0072, B:65:0x0078, B:67:0x007e, B:68:0x0083, B:70:0x0089, B:72:0x008d, B:73:0x008f, B:74:0x009f, B:76:0x00a3, B:77:0x00aa, B:79:0x00ae, B:80:0x00bf, B:82:0x00c5, B:84:0x00c9, B:85:0x00cb, B:86:0x00db, B:88:0x00df, B:89:0x00e6, B:91:0x00ea, B:92:0x00fb, B:95:0x00d2, B:97:0x00d6, B:98:0x00f9, B:99:0x0096, B:101:0x009a, B:102:0x00bd, B:103:0x0081), top: B:50:0x0041 }] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.location.p010f.C0703a m940f() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p010f.C0704b.m940f():com.baidu.location.f.a");
    }

    /* renamed from: g */
    public String m941g() {
        int i = -1;
        try {
            TelephonyManager telephonyManager = this.f1031c;
            if (telephonyManager != null) {
                i = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + i;
    }

    /* renamed from: h */
    public int m942h() {
        return 0;
    }
}