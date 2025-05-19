package com.baidu.location.f;

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
import com.baidu.location.h.o;
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

/* loaded from: classes.dex */
public class b {
    public static int a;
    public static int b;
    private static String m;
    private static Class<?> n;
    private int A;
    private TelephonyManager c;
    private TelephonyManager d;
    private TelephonyManager e;
    private SubscriptionManager f;
    private com.baidu.location.f.a g;
    private com.baidu.location.f.a h;
    private List<com.baidu.location.f.a> i;
    private d j;
    private boolean k;
    private boolean l;
    private a o;
    private C0011b p;
    private c q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private long w;
    private final Object x;
    private Handler y;
    private boolean z;

    private class a extends TelephonyManager.CellInfoCallback {
        private a() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            b.this.n();
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onError(int i, Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.location.f.b$b, reason: collision with other inner class name */
    private class C0011b extends TelephonyManager.CellInfoCallback {
        private C0011b() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (b.this.s) {
                b.this.r = !r2.r;
            }
            if (!b.this.s || b.this.r) {
                b.this.n();
            }
        }
    }

    private class c extends TelephonyManager.CellInfoCallback {
        private c() {
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public void onCellInfo(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            if (b.this.s) {
                b.this.r = !r2.r;
            }
            if (!b.this.s || b.this.r) {
                b.this.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d extends PhoneStateListener {
        public d() {
        }

        @Override // android.telephony.PhoneStateListener
        public void onCellInfoChanged(List<CellInfo> list) {
            if (list == null) {
                return;
            }
            b.this.y.post(new com.baidu.location.f.c(this));
        }

        @Override // android.telephony.PhoneStateListener
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            com.baidu.location.f.a aVar;
            int cdmaDbm;
            if (b.this.g != null) {
                if (b.this.g.i == 'g') {
                    aVar = b.this.g;
                    cdmaDbm = signalStrength.getGsmSignalStrength();
                } else {
                    if (b.this.g.i != 'c') {
                        return;
                    }
                    aVar = b.this.g;
                    cdmaDbm = signalStrength.getCdmaDbm();
                }
                aVar.h = cdmaDbm;
            }
        }
    }

    private static class e {
        private static final b a = new b();
    }

    private static class f implements Comparator<i> {
        private f() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(i iVar, i iVar2) {
            return iVar.g - iVar2.g;
        }
    }

    private b() {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new com.baidu.location.f.a();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.r = true;
        this.s = false;
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = 0L;
        this.x = new Object();
        this.y = new Handler();
        this.z = false;
        this.A = 30;
        if (Build.VERSION.SDK_INT >= this.A) {
            this.z = o.b("android.telephony.TelephonyManager$CellInfoCallback");
        }
    }

    private static int a(int i) {
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i;
    }

    public static int a(CellIdentityNr cellIdentityNr) {
        try {
            return o.a(cellIdentityNr, "getHwTac");
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int a(String str) {
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
    
        r4.j = r18.getCellConnectionStatus();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.baidu.location.f.a a(android.telephony.CellInfo r18, com.baidu.location.f.a r19, android.telephony.TelephonyManager r20) {
        /*
            Method dump skipped, instructions count: 811
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.b.a(android.telephony.CellInfo, com.baidu.location.f.a, android.telephony.TelephonyManager):com.baidu.location.f.a");
    }

    private com.baidu.location.f.a a(CellLocation cellLocation) {
        return a(cellLocation, false);
    }

    private com.baidu.location.f.a a(CellLocation cellLocation, boolean z) {
        if (cellLocation == null || this.c == null) {
            return null;
        }
        com.baidu.location.f.a aVar = new com.baidu.location.f.a();
        aVar.l = 1;
        if (z) {
            aVar.f();
        }
        aVar.g = System.currentTimeMillis();
        try {
            String networkOperator = this.c.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                int i = -1;
                if (networkOperator.length() >= 3) {
                    i = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    aVar.c = i < 0 ? this.g.c : i;
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
                    i = this.g.d;
                }
                aVar.d = i;
            }
            a = this.c.getSimState();
        } catch (Exception unused) {
            b = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            aVar.a = ((GsmCellLocation) cellLocation).getLac();
            aVar.b = r9.getCid();
            aVar.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            aVar.i = 'c';
            if (n == null) {
                try {
                    n = Class.forName("android.telephony.cdma.CdmaCellLocation");
                } catch (Exception unused2) {
                    n = null;
                    return aVar;
                }
            }
            Class<?> cls = n;
            if (cls != null && cls.isInstance(cellLocation)) {
                try {
                    int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                    if (systemId < 0) {
                        systemId = this.g.d;
                    }
                    aVar.d = systemId;
                    aVar.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                    aVar.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                    int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                    if (baseStationLatitude < Integer.MAX_VALUE) {
                        aVar.e = baseStationLatitude;
                    }
                    int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                    if (baseStationLongitude < Integer.MAX_VALUE) {
                        aVar.f = baseStationLongitude;
                    }
                } catch (Exception unused3) {
                    b = 3;
                    return aVar;
                }
            }
        }
        d(aVar);
        return aVar;
    }

    public static com.baidu.location.f.a a(com.baidu.location.f.a aVar, TelephonyManager telephonyManager, boolean z) {
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
            return null;
        }
        try {
            a = telephonyManager.getSimState();
            List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
            if (allCellInfo == null || allCellInfo.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            com.baidu.location.f.a aVar2 = null;
            for (CellInfo cellInfo : allCellInfo) {
                if (cellInfo.isRegistered()) {
                    boolean z2 = aVar2 != null;
                    com.baidu.location.f.a a2 = a(cellInfo, aVar, telephonyManager);
                    if (a2 != null) {
                        if (!a2.b()) {
                            a2 = null;
                        } else if (z2 && aVar2 != null) {
                            aVar2.m = a2.j();
                            aVar2.n = a2.h();
                        }
                        if (aVar2 == null) {
                            aVar2 = a2;
                        }
                    }
                }
            }
            m = a(b(arrayList));
            return aVar2;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static b a() {
        return e.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static i a(CellInfo cellInfo, TelephonyManager telephonyManager) {
        i iVar;
        long elapsedRealtimeNanos;
        k kVar;
        long elapsedRealtimeNanos2;
        j jVar;
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
                i iVar2 = new i();
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                iVar2.a = 1;
                if (cellInfo.isRegistered()) {
                    iVar2.d = 1;
                }
                if (i >= 28) {
                    iVar2.b = cellIdentity.getMccString();
                    iVar2.c = cellIdentity.getMncString();
                    iVar2.f = cellInfo.getCellConnectionStatus();
                } else {
                    iVar2.b = cellIdentity.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity.getMcc());
                    iVar2.c = cellIdentity.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity.getMnc()) : null;
                }
                if (i >= 30) {
                    elapsedRealtimeNanos6 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                    currentTimeMillis4 = System.currentTimeMillis();
                } else {
                    elapsedRealtimeNanos6 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                    currentTimeMillis4 = System.currentTimeMillis();
                }
                iVar2.e = currentTimeMillis4 - elapsedRealtimeNanos6;
                iVar = iVar2;
            } else {
                if (cellInfo instanceof CellInfoCdma) {
                    i iVar3 = new i();
                    CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                    iVar3.a = 2;
                    iVar3.c = cellIdentity2.getSystemId() != Integer.MAX_VALUE ? String.valueOf(cellIdentity2.getSystemId()) : null;
                    if (cellInfo.isRegistered()) {
                        iVar3.d = 1;
                    }
                    if (i >= 28) {
                        iVar3.f = cellInfo.getCellConnectionStatus();
                    }
                    try {
                        String networkOperator = telephonyManager.getNetworkOperator();
                        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                            iVar3.b = networkOperator.substring(0, 3);
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
                        iVar3.e = currentTimeMillis3 - elapsedRealtimeNanos5;
                    } catch (Error unused2) {
                        iVar3.e = System.currentTimeMillis();
                    }
                    return iVar3;
                }
                if (cellInfo instanceof CellInfoWcdma) {
                    i iVar4 = new i();
                    CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    iVar4.a = 4;
                    if (cellInfo.isRegistered()) {
                        iVar4.d = 1;
                    }
                    if (i >= 28) {
                        iVar4.b = cellIdentity3.getMccString();
                        iVar4.c = cellIdentity3.getMncString();
                        iVar4.f = cellInfo.getCellConnectionStatus();
                    } else {
                        iVar4.b = cellIdentity3.getMcc() == Integer.MAX_VALUE ? null : String.valueOf(cellIdentity3.getMcc());
                        iVar4.c = cellIdentity3.getMnc() != Integer.MAX_VALUE ? String.valueOf(cellIdentity3.getMnc()) : null;
                    }
                    if (i >= 30) {
                        elapsedRealtimeNanos4 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                        currentTimeMillis2 = System.currentTimeMillis();
                    } else {
                        elapsedRealtimeNanos4 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                        currentTimeMillis2 = System.currentTimeMillis();
                    }
                    iVar4.e = currentTimeMillis2 - elapsedRealtimeNanos4;
                    iVar = iVar4;
                } else {
                    if (cellInfo instanceof CellInfoTdscdma) {
                        if (i < 28) {
                            return null;
                        }
                        i iVar5 = new i();
                        CellIdentityTdscdma cellIdentity4 = ((CellInfoTdscdma) cellInfo).getCellIdentity();
                        iVar5.a = 5;
                        if (cellInfo.isRegistered()) {
                            iVar5.d = 1;
                        }
                        iVar5.b = cellIdentity4.getMccString();
                        iVar5.c = cellIdentity4.getMncString();
                        iVar5.f = cellInfo.getCellConnectionStatus();
                        try {
                            if (i >= 30) {
                                elapsedRealtimeNanos3 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                currentTimeMillis = System.currentTimeMillis();
                            } else {
                                elapsedRealtimeNanos3 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            iVar5.e = currentTimeMillis - elapsedRealtimeNanos3;
                            return iVar5;
                        } catch (Error unused3) {
                            iVar5.e = System.currentTimeMillis();
                            return iVar5;
                        }
                    }
                    if (cellInfo instanceof CellInfoLte) {
                        j jVar2 = new j();
                        CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                        CellIdentityLte cellIdentity5 = cellInfoLte.getCellIdentity();
                        CellSignalStrengthLte cellSignalStrength = cellInfoLte.getCellSignalStrength();
                        j jVar3 = jVar2;
                        jVar3.a = 3;
                        if (cellInfo.isRegistered()) {
                            jVar3.d = 1;
                        }
                        jVar3.h = cellIdentity5.getCi();
                        jVar3.i = cellIdentity5.getPci();
                        jVar3.j = cellIdentity5.getTac();
                        jVar3.r = cellSignalStrength.getTimingAdvance();
                        if (i >= 28) {
                            jVar3.b = cellIdentity5.getMccString();
                            jVar3.c = cellIdentity5.getMncString();
                            jVar3.f = cellInfo.getCellConnectionStatus();
                            jVar3.l = cellIdentity5.getBandwidth();
                        } else {
                            if (cellIdentity5.getMcc() != Integer.MAX_VALUE) {
                                jVar3.b = String.valueOf(cellIdentity5.getMcc());
                            }
                            if (cellIdentity5.getMnc() != Integer.MAX_VALUE) {
                                jVar3.c = String.valueOf(cellIdentity5.getMnc());
                            }
                        }
                        if (i >= 24) {
                            jVar3.k = cellIdentity5.getEarfcn();
                        }
                        if (i >= 29) {
                            jVar3.m = Math.abs(cellSignalStrength.getRssi());
                        }
                        if (i >= 26) {
                            jVar3.n = Math.abs(cellSignalStrength.getRsrp());
                            jVar3.g = Math.abs(cellSignalStrength.getRsrp());
                            jVar3.o = cellSignalStrength.getRsrq();
                            jVar3.p = cellSignalStrength.getRssnr();
                            jVar3.q = cellSignalStrength.getCqi();
                        }
                        try {
                            if (i >= 30) {
                                elapsedRealtimeNanos2 = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                                jVar = jVar2;
                            } else {
                                elapsedRealtimeNanos2 = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                                jVar = jVar2;
                            }
                            jVar.e = System.currentTimeMillis() - elapsedRealtimeNanos2;
                            return jVar2;
                        } catch (Error unused4) {
                            jVar3.e = System.currentTimeMillis();
                            return jVar2;
                        }
                    }
                    if (!(cellInfo instanceof CellInfoNr) || i < 29) {
                        return null;
                    }
                    k kVar2 = new k();
                    try {
                        cellIdentityNr = (CellIdentityNr) ((CellInfoNr) cellInfo).getCellIdentity();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    CellSignalStrengthNr cellSignalStrengthNr = (CellSignalStrengthNr) ((CellInfoNr) cellInfo).getCellSignalStrength();
                    if (cellIdentityNr != null) {
                        k kVar3 = kVar2;
                        kVar3.a = 6;
                        kVar3.b = cellIdentityNr.getMccString();
                        kVar3.c = cellIdentityNr.getMncString();
                        kVar3.h = cellIdentityNr.getNci();
                        kVar3.i = cellIdentityNr.getPci();
                        kVar3.j = cellIdentityNr.getTac();
                        if (kVar3.j == Integer.MAX_VALUE) {
                            try {
                                kVar2.j = a(cellIdentityNr);
                            } catch (Throwable unused5) {
                            }
                        }
                        if (kVar3.j == Integer.MAX_VALUE) {
                            try {
                                kVar2.j = a(cellIdentityNr.toString());
                            } catch (Throwable unused6) {
                            }
                        }
                        kVar3.k = cellIdentityNr.getNrarfcn();
                    }
                    if (cellInfo.isRegistered()) {
                        kVar2.d = 1;
                    }
                    k kVar4 = kVar2;
                    kVar4.f = cellInfo.getCellConnectionStatus();
                    kVar4.l = Math.abs(cellSignalStrengthNr.getSsRsrp());
                    kVar4.g = Math.abs(cellSignalStrengthNr.getSsRsrp());
                    kVar4.m = cellSignalStrengthNr.getSsRsrq();
                    kVar4.n = cellSignalStrengthNr.getSsSinr();
                    kVar4.o = Math.abs(cellSignalStrengthNr.getCsiRsrp());
                    kVar4.p = cellSignalStrengthNr.getCsiRsrq();
                    kVar4.q = cellSignalStrengthNr.getCsiSinr();
                    try {
                        if (i >= 30) {
                            elapsedRealtimeNanos = SystemClock.elapsedRealtime() - cellInfo.getTimestampMillis();
                            kVar = kVar2;
                        } else {
                            elapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000;
                            kVar = kVar2;
                        }
                        kVar.e = System.currentTimeMillis() - elapsedRealtimeNanos;
                        iVar = kVar2;
                    } catch (Error unused7) {
                        kVar4.e = System.currentTimeMillis();
                        iVar = kVar2;
                    }
                }
            }
        } catch (Error unused8) {
            telephonyManager.e = System.currentTimeMillis();
            iVar = telephonyManager;
        }
        return iVar;
    }

    private static String a(List<i> list) {
        if (list == null || list.size() == 0) {
        }
        return null;
    }

    private int b(String str) {
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

    private static List<i> b(List<i> list) {
        if (list.size() == 0) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        Collections.sort(list.subList(1, list.size()), new f());
        return list.subList(0, list.size());
    }

    private void d(com.baidu.location.f.a aVar) {
        com.baidu.location.f.a aVar2;
        com.baidu.location.f.a aVar3 = this.g;
        if (aVar.b() && ((aVar2 = this.g) == null || !aVar2.a(aVar) || a(this.g, aVar))) {
            this.g = aVar;
        }
        if (aVar.b()) {
            if (aVar3 == null || !aVar3.a(aVar)) {
                if (!aVar.b()) {
                    List<com.baidu.location.f.a> list = this.i;
                    if (list != null) {
                        list.clear();
                        return;
                    }
                    return;
                }
                int size = this.i.size();
                com.baidu.location.f.a aVar4 = size == 0 ? null : this.i.get(size - 1);
                if (aVar4 != null && aVar4.b == this.g.b && aVar4.a == this.g.a) {
                    return;
                }
                this.i.add(this.g);
                if (this.i.size() > 3) {
                    this.i.remove(0);
                }
                k();
                this.l = false;
            }
        }
    }

    private String e(com.baidu.location.f.a aVar) {
        com.baidu.location.f.a a2;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = null;
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.c.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    sb.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (a2 = a(cellInfo, this.g, this.c)) != null) {
                            if (a2.a != -1 && a2.b != -1) {
                                sb.append(a2.c).append("|").append(a2.d).append("|").append(a2.a).append("|").append(a2.b).append("|").append(a2.h).append(";");
                            }
                            if (Build.VERSION.SDK_INT > 28 && a2.k == 6 && a2.o != null && a2.b()) {
                                if (sb2 == null) {
                                    StringBuilder sb3 = new StringBuilder();
                                    try {
                                        sb3.append("&ncnr=");
                                        sb2 = sb3;
                                    } catch (Throwable unused) {
                                        sb2 = sb3;
                                    }
                                }
                                sb2.append(a2.h());
                                sb2.append("_");
                                sb2.append(a2.o);
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

    public static String i() {
        String str = m;
        if (str == null || str.length() == 0) {
            return null;
        }
        return m.replace("\n", "");
    }

    private void j() {
        String f2 = o.f();
        if (f2 == null) {
            return;
        }
        File file = new File(f2 + File.separator + "lcvif2.dat");
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
                        com.baidu.location.f.a aVar = new com.baidu.location.f.a(readInt3, readLong2, readInt, readInt2, 0, c2, -1);
                        aVar.g = readLong;
                        if (aVar.b()) {
                            this.l = true;
                            this.i.add(aVar);
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

    private void k() {
        List<com.baidu.location.f.a> list = this.i;
        if (list == null && this.h == null) {
            return;
        }
        if (list == null && this.h != null) {
            LinkedList linkedList = new LinkedList();
            this.i = linkedList;
            linkedList.add(this.h);
        }
        String f2 = o.f();
        if (f2 == null || this.i == null) {
            return;
        }
        File file = new File(f2 + File.separator + "lcvif2.dat");
        int size = this.i.size();
        try {
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, InternalZipConstants.WRITE_MODE);
            randomAccessFile.seek(0L);
            randomAccessFile.writeLong(this.i.get(size - 1).g);
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
                randomAccessFile.writeLong(this.i.get(i2).g);
                randomAccessFile.writeInt(this.i.get(i2).c);
                randomAccessFile.writeInt(this.i.get(i2).d);
                randomAccessFile.writeInt(this.i.get(i2).a);
                randomAccessFile.writeLong(this.i.get(i2).b);
                if (this.i.get(i2).i == 'g') {
                    randomAccessFile.writeInt(1);
                } else if (this.i.get(i2).i == 'c') {
                    randomAccessFile.writeInt(2);
                } else {
                    randomAccessFile.writeInt(3);
                }
            }
            randomAccessFile.close();
        } catch (Exception unused) {
        }
    }

    private void l() {
        if (this.o == null) {
            this.o = new a();
        }
        this.c.requestCellInfoUpdate(com.baidu.location.f.getServiceContext().getMainExecutor(), this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        CellLocation cellLocation;
        com.baidu.location.f.a a2 = a(this.g, this.c, false);
        if (a2 != null) {
            d(a2);
        }
        if (Build.VERSION.SDK_INT <= 28 && (a2 == null || !a2.b())) {
            try {
                cellLocation = this.c.getCellLocation();
            } catch (Throwable unused) {
                cellLocation = null;
            }
            if (cellLocation != null) {
                a(cellLocation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            m();
            synchronized (this.x) {
                this.x.notifyAll();
            }
        } catch (Exception unused) {
        }
        com.baidu.location.c.b.a().e();
    }

    public HashSet<String> a(com.baidu.location.f.a aVar) {
        com.baidu.location.f.a a2;
        HashSet<String> hashSet = new HashSet<>();
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                List<CellInfo> allCellInfo = this.c.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered() && (a2 = a(cellInfo, this.g, this.c)) != null) {
                            String str = "";
                            if (a2.a != -1 && a2.b != -1) {
                                str = (aVar.a != a2.a ? new StringBuilder().append(a2.a).append("|").append(a2.b) : new StringBuilder().append(a2.b).append("")).toString();
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

    public boolean a(com.baidu.location.f.a aVar, com.baidu.location.f.a aVar2) {
        boolean z;
        if (aVar == null && aVar2 == null) {
            return false;
        }
        if (aVar == null || aVar2 == null) {
            return true;
        }
        float f2 = o.aH;
        float abs = Math.abs(aVar.h - aVar2.h) / (aVar.h != 0 ? aVar.h : -1);
        if (aVar.m != null && aVar2.m != null) {
            if (Math.abs(Math.abs(r7 - b(aVar2.m)) / (b(aVar.m) != 0 ? r7 : -1)) > f2) {
                z = true;
                return abs <= f2 || z;
            }
        }
        z = false;
        if (abs <= f2) {
        }
    }

    public String b(com.baidu.location.f.a aVar) {
        String e2;
        int intValue;
        String str = "";
        try {
            e2 = e(aVar);
            intValue = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
            if (e2 != null && !e2.equals("")) {
                if (!e2.equals("&nc=")) {
                    return e2;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (intValue >= 17) {
            return e2;
        }
        str = e2;
        if (str == null || !str.equals("&nc=")) {
            return str;
        }
        return null;
    }

    public synchronized void b() {
        if (this.k) {
            return;
        }
        if (com.baidu.location.f.isServing) {
            this.c = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
            this.i = new LinkedList();
            this.j = new d();
            j();
            if (this.c != null && this.j != null) {
                if (Build.VERSION.SDK_INT < this.A || !this.z) {
                    try {
                        this.c.listen(this.j, 1280);
                    } catch (Exception unused) {
                    }
                }
                this.k = true;
            }
        }
    }

    public String c(com.baidu.location.f.a aVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(aVar.i);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", Integer.valueOf(aVar.c), Integer.valueOf(aVar.d), Integer.valueOf(aVar.a), Long.valueOf(aVar.b), Integer.valueOf(aVar.h)));
        if (aVar.e < Integer.MAX_VALUE && aVar.f < Integer.MAX_VALUE) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", Double.valueOf(aVar.f / 14400.0d), Double.valueOf(aVar.e / 14400.0d)));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(aVar.g);
        stringBuffer.append("&cl_api=");
        stringBuffer.append(aVar.l);
        stringBuffer.append("&clp=");
        stringBuffer.append(aVar.k);
        if (aVar.o != null) {
            stringBuffer.append("&clnrs=");
            stringBuffer.append(aVar.o);
        }
        if (Build.VERSION.SDK_INT >= 28 && aVar.j != Integer.MAX_VALUE) {
            stringBuffer.append("&cl_cs=");
            stringBuffer.append(aVar.j);
        }
        try {
            List<com.baidu.location.f.a> list = this.i;
            if (list != null && list.size() > 0) {
                int size = this.i.size();
                stringBuffer.append("&clt=");
                for (int i = 0; i < size; i++) {
                    com.baidu.location.f.a aVar2 = this.i.get(i);
                    if (aVar2 != null) {
                        if (aVar2.c != aVar.c) {
                            stringBuffer.append(aVar2.c);
                        }
                        stringBuffer.append("|");
                        if (aVar2.d != aVar.d) {
                            stringBuffer.append(aVar2.d);
                        }
                        stringBuffer.append("|");
                        if (aVar2.a != aVar.a) {
                            stringBuffer.append(aVar2.a);
                        }
                        stringBuffer.append("|");
                        if (aVar2.b != aVar.b) {
                            stringBuffer.append(aVar2.b);
                        }
                        stringBuffer.append("|");
                        stringBuffer.append((System.currentTimeMillis() - aVar2.g) / 1000);
                        stringBuffer.append(";");
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (a > 100) {
            a = 0;
        }
        stringBuffer.append("&cs=" + (a + (b << 8)));
        if (aVar.m != null) {
            stringBuffer.append(aVar.m);
        }
        stringBuffer.append("&cl_list=").append(i());
        return stringBuffer.toString();
    }

    public synchronized void c() {
        TelephonyManager telephonyManager;
        if (this.k) {
            d dVar = this.j;
            if (dVar != null && (telephonyManager = this.c) != null) {
                telephonyManager.listen(dVar, 0);
            }
            this.j = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.i.clear();
            this.i = null;
            k();
            this.k = false;
        }
    }

    public boolean d() {
        return this.l;
    }

    public int e() {
        TelephonyManager telephonyManager = this.c;
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.baidu.location.f.a f() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.b.f():com.baidu.location.f.a");
    }

    public String g() {
        int i = -1;
        try {
            TelephonyManager telephonyManager = this.c;
            if (telephonyManager != null) {
                i = telephonyManager.getSimState();
            }
        } catch (Exception unused) {
        }
        return "&sim=" + i;
    }

    public int h() {
        return 0;
    }
}
