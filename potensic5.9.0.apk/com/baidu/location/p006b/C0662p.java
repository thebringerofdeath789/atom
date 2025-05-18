package com.baidu.location.p006b;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Poi;
import com.baidu.location.PoiRegion;
import com.baidu.location.ServiceC0702f;
import com.baidu.location.indoor.C0755n;
import com.baidu.location.p006b.AbstractC0659m;
import com.baidu.location.p007c.C0675b;
import com.baidu.location.p009e.C0686a;
import com.baidu.location.p009e.C0693h;
import com.baidu.location.p010f.C0703a;
import com.baidu.location.p010f.C0704b;
import com.baidu.location.p010f.C0707e;
import com.baidu.location.p010f.C0709g;
import com.baidu.location.p010f.C0714l;
import com.baidu.location.p010f.C0715m;
import com.baidu.location.p012h.C0733o;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.location.b.p */
/* loaded from: classes.dex */
public class C0662p extends AbstractC0659m {

    /* renamed from: g */
    public static String f621g = "0";

    /* renamed from: i */
    public static boolean f622i = false;

    /* renamed from: j */
    private static C0662p f623j;

    /* renamed from: A */
    private long f624A;

    /* renamed from: E */
    private double f628E;

    /* renamed from: F */
    private double f629F;

    /* renamed from: f */
    public AbstractC0659m.b f649f;

    /* renamed from: k */
    private boolean f651k = true;

    /* renamed from: l */
    private String f652l = null;

    /* renamed from: m */
    private BDLocation f653m = null;

    /* renamed from: n */
    private BDLocation f654n = null;

    /* renamed from: o */
    private Location f655o = null;

    /* renamed from: p */
    private C0714l f656p = null;

    /* renamed from: q */
    private C0703a f657q = null;

    /* renamed from: r */
    private HashSet<String> f658r = null;

    /* renamed from: s */
    private C0714l f659s = null;

    /* renamed from: t */
    private C0703a f660t = null;

    /* renamed from: u */
    private boolean f661u = true;

    /* renamed from: v */
    private volatile boolean f662v = false;

    /* renamed from: w */
    private boolean f663w = false;

    /* renamed from: x */
    private long f664x = 0;

    /* renamed from: y */
    private long f665y = 0;

    /* renamed from: z */
    private Address f666z = null;

    /* renamed from: B */
    private String f625B = null;

    /* renamed from: C */
    private List<Poi> f626C = null;

    /* renamed from: D */
    private PoiRegion f627D = null;

    /* renamed from: G */
    private boolean f630G = false;

    /* renamed from: H */
    private long f631H = 0;

    /* renamed from: I */
    private long f632I = 0;

    /* renamed from: J */
    private a f633J = null;

    /* renamed from: K */
    private boolean f634K = false;

    /* renamed from: L */
    private boolean f635L = false;

    /* renamed from: M */
    private boolean f636M = true;

    /* renamed from: h */
    public final Handler f650h = new AbstractC0659m.a();

    /* renamed from: N */
    private boolean f637N = false;

    /* renamed from: O */
    private boolean f638O = false;

    /* renamed from: P */
    private b f639P = null;

    /* renamed from: Q */
    private boolean f640Q = false;

    /* renamed from: R */
    private int f641R = 0;

    /* renamed from: S */
    private long f642S = 0;

    /* renamed from: T */
    private boolean f643T = false;

    /* renamed from: U */
    private String f644U = null;

    /* renamed from: V */
    private boolean f645V = false;

    /* renamed from: W */
    private boolean f646W = false;

    /* renamed from: X */
    private boolean f647X = false;

    /* renamed from: Y */
    private boolean f648Y = true;

    /* renamed from: com.baidu.location.b.p$a */
    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(C0662p c0662p, RunnableC0663q runnableC0663q) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0662p.this.f634K) {
                C0662p.this.f634K = false;
                if (C0662p.this.f635L || C0709g.m959a().m1031k()) {
                    return;
                }
                C0662p.this.m526a(false, false);
            }
        }
    }

    /* renamed from: com.baidu.location.b.p$b */
    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(C0662p c0662p, RunnableC0663q runnableC0663q) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0662p.this.f640Q) {
                C0662p.this.f640Q = false;
            }
            if (C0662p.this.f663w) {
                C0662p.this.f663w = false;
                C0662p.this.m520h(null);
            }
        }
    }

    private C0662p() {
        this.f649f = null;
        this.f649f = new AbstractC0659m.b();
    }

    /* renamed from: a */
    private boolean m500a(C0703a c0703a) {
        if (c0703a == null) {
            return false;
        }
        if (this.f660t == null) {
            return true;
        }
        return !c0703a.m895a(r0);
    }

    /* renamed from: a */
    private boolean m501a(C0703a c0703a, C0703a c0703a2) {
        if (c0703a2 == c0703a) {
            return false;
        }
        if (c0703a2 == null || c0703a == null) {
            return true;
        }
        return !c0703a.m895a(c0703a2);
    }

    /* renamed from: a */
    private boolean m502a(C0703a c0703a, HashSet<String> hashSet) {
        this.f579b = C0704b.m912a().m940f();
        boolean m501a = m501a(c0703a, this.f579b);
        if (C0733o.f1346aF == 0) {
            return m501a;
        }
        boolean z = m501a || C0704b.m912a().m933a(c0703a, this.f579b);
        this.f580c = C0704b.m912a().m932a(this.f579b);
        return z || m504a(hashSet, this.f580c);
    }

    /* renamed from: a */
    private boolean m503a(C0714l c0714l) {
        this.f578a = C0715m.m1058a().m1083q();
        if (c0714l == this.f578a) {
            return false;
        }
        if (this.f578a == null || c0714l == null) {
            return true;
        }
        return !c0714l.m1047c(this.f578a);
    }

    /* renamed from: a */
    private boolean m504a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if ((hashSet == null || hashSet.isEmpty()) && (hashSet2 == null || hashSet2.isEmpty())) {
            return false;
        }
        if (hashSet == null || hashSet.isEmpty() || hashSet2 == null || hashSet2.isEmpty()) {
            return true;
        }
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (hashSet2.contains(it.next())) {
                i++;
            }
        }
        return ((float) i) < ((float) size) * C0733o.f1347aG;
    }

    /* renamed from: b */
    private void m506b(String str) {
        this.f646W = str != null && "subway".equals(str.toLowerCase());
    }

    /* renamed from: c */
    public static synchronized C0662p m509c() {
        C0662p c0662p;
        synchronized (C0662p.class) {
            if (f623j == null) {
                f623j = new C0662p();
            }
            c0662p = f623j;
        }
        return c0662p;
    }

    /* renamed from: c */
    private void m510c(Message message) {
        if (C0733o.f1383ax && !C0733o.m1161d(ServiceC0702f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            C0648b.m321a().m330a(bDLocation);
            return;
        }
        if (C0733o.m1152b()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            f622i = true;
        }
        if (C0755n.m1327a().m1388f()) {
            return;
        }
        C0707e.m946a().m951b();
        int m338d = C0648b.m321a().m338d(message);
        if (m338d == 1) {
            m513d(message);
            return;
        }
        if (m338d == 2) {
            if (C0709g.m959a().m1031k()) {
                m516e(message);
            }
        } else {
            if (m338d != 3 && m338d != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(m338d)));
            }
            m519g(message);
        }
    }

    /* renamed from: d */
    private void m513d(Message message) {
        if (C0709g.m959a().m1031k()) {
            m516e(message);
            C0667u.m571a().m575c();
        } else {
            m519g(message);
            C0667u.m571a().m573b();
        }
    }

    /* renamed from: d */
    private void m514d(BDLocation bDLocation) {
        if (C0733o.f1396l || bDLocation.getMockGpsStrategy() <= 0) {
            C0648b.m321a().m330a(bDLocation);
        } else {
            C0648b.m321a().m336c(bDLocation);
        }
    }

    /* renamed from: e */
    private void m516e(Message message) {
        BDLocation bDLocation = new BDLocation(C0709g.m959a().m1027g());
        Location m1028h = C0709g.m959a().m1028h();
        if (m1028h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(m1028h.getProvider())) {
            bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
        }
        if (m1028h != null) {
            bDLocation.setExtrainfo(m1028h.getExtras());
        }
        if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL) || C0733o.f1391g || C0733o.f1393i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f629F, this.f628E, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.f666z;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.f625B;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.f626C;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
                PoiRegion poiRegion = this.f627D;
                if (poiRegion != null) {
                    bDLocation.setPoiRegion(poiRegion);
                }
            } else {
                this.f630G = true;
                m519g(null);
            }
        }
        this.f653m = bDLocation;
        this.f654n = null;
        m514d(bDLocation);
    }

    /* renamed from: e */
    private void m517e(BDLocation bDLocation) {
        this.f647X = bDLocation != null && bDLocation.isInIndoorPark();
    }

    /* renamed from: f */
    private void m518f(Message message) {
        b bVar;
        if (!C0715m.m1058a().m1073g()) {
            m520h(message);
            return;
        }
        this.f663w = true;
        if (this.f639P == null) {
            this.f639P = new b(this, null);
        }
        if (this.f640Q && (bVar = this.f639P) != null) {
            this.f650h.removeCallbacks(bVar);
        }
        this.f650h.postDelayed(this.f639P, 3500L);
        this.f640Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m519g(Message message) {
        this.f641R = 0;
        if (!this.f661u) {
            m518f(message);
            this.f632I = SystemClock.uptimeMillis();
            return;
        }
        this.f641R = 1;
        this.f632I = SystemClock.uptimeMillis();
        if (C0715m.m1058a().m1078l()) {
            m518f(message);
        } else {
            m520h(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cc, code lost:
    
        if (r11 <= 0) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:111:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x027c  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m520h(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0662p.m520h(android.os.Message):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b1, code lost:
    
        if (r0.getPoiList() == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m521m() {
        /*
            r15 = this;
            double r0 = java.lang.Math.random()
            android.os.SystemClock.uptimeMillis()
            com.baidu.location.f.b r2 = com.baidu.location.p010f.C0704b.m912a()
            com.baidu.location.f.a r2 = r2.m940f()
            com.baidu.location.f.m r3 = com.baidu.location.p010f.C0715m.m1058a()
            com.baidu.location.f.l r3 = r3.m1082p()
            if (r3 == 0) goto L24
            int r4 = r3.m1037a()
            if (r4 <= 0) goto L24
            long r4 = r3.m1051g()
            goto L26
        L24:
            r4 = 0
        L26:
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L3a
            boolean r2 = r2.m899e()
            if (r2 == 0) goto L3a
            if (r3 == 0) goto L38
            int r2 = r3.m1037a()
            if (r2 != 0) goto L3a
        L38:
            r2 = r6
            goto L3b
        L3a:
            r2 = r7
        L3b:
            com.baidu.location.e.h r3 = com.baidu.location.p009e.C0693h.m828a()
            boolean r3 = r3.m840d()
            r8 = 0
            if (r3 == 0) goto Lb8
            com.baidu.location.e.h r3 = com.baidu.location.p009e.C0693h.m828a()
            boolean r3 = r3.m842f()
            if (r3 == 0) goto Lb8
            r9 = 60
            int r3 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r3 >= 0) goto Lb8
            if (r2 != 0) goto L6a
            r2 = 0
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto Lb8
            com.baidu.location.e.h r2 = com.baidu.location.p009e.C0693h.m828a()
            double r2 = r2.m851o()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lb8
        L6a:
            com.baidu.location.e.h r9 = com.baidu.location.p009e.C0693h.m828a()
            com.baidu.location.f.b r0 = com.baidu.location.p010f.C0704b.m912a()
            com.baidu.location.f.a r10 = r0.m940f()
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()
            com.baidu.location.f.l r11 = r0.m1082p()
            r12 = 0
            com.baidu.location.e.h$b r13 = com.baidu.location.p009e.C0693h.b.IS_MIX_MODE
            com.baidu.location.e.h$a r14 = com.baidu.location.p009e.C0693h.a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r9.m837a(r10, r11, r12, r13, r14)
            if (r0 != 0) goto L8b
        L89:
            r1 = r7
            goto Lb4
        L8b:
            java.lang.String r1 = com.baidu.location.p012h.C0733o.f1389e
            java.lang.String r2 = "all"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L9d
            java.lang.String r1 = r0.getAddrStr()
            if (r1 != 0) goto L9d
            r1 = r7
            goto L9e
        L9d:
            r1 = r6
        L9e:
            boolean r2 = com.baidu.location.p012h.C0733o.f1391g
            if (r2 == 0) goto La9
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto La9
            r1 = r7
        La9:
            boolean r2 = com.baidu.location.p012h.C0733o.f1393i
            if (r2 == 0) goto Lb4
            java.util.List r2 = r0.getPoiList()
            if (r2 != 0) goto Lb4
            goto L89
        Lb4:
            if (r1 != 0) goto Lb7
            goto Lb8
        Lb7:
            r8 = r0
        Lb8:
            if (r8 == 0) goto Le0
            int r0 = r8.getLocType()
            r1 = 66
            if (r0 != r1) goto Le0
            boolean r0 = r15.f662v
            if (r0 == 0) goto Le0
            com.baidu.location.BDLocation r0 = new com.baidu.location.BDLocation
            r0.<init>(r8)
            r1 = 161(0xa1, float:2.26E-43)
            r0.setLocType(r1)
            boolean r1 = r15.f662v
            if (r1 == 0) goto Le0
            r15.f635L = r6
            com.baidu.location.b.b r1 = com.baidu.location.p006b.C0648b.m321a()
            r1.m330a(r0)
            r15.f653m = r0
            goto Le1
        Le0:
            r6 = r7
        Le1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0662p.m521m():boolean");
    }

    /* renamed from: n */
    private String[] m522n() {
        boolean z;
        C0650d m371a;
        int i;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int m1150b = C0733o.m1150b(ServiceC0702f.getServiceContext());
        String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        if (m1150b == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(m1150b);
        String m1163e = C0733o.m1163e(ServiceC0702f.getServiceContext());
        if (m1163e.contains("per=0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(m1163e);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int m1156c = C0733o.m1156c(ServiceC0702f.getServiceContext());
            if (m1156c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(m1156c);
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            int m1156c2 = C0733o.m1156c(ServiceC0702f.getServiceContext());
            if (m1156c2 >= 0) {
                stringBuffer.append(m1156c2);
            }
        }
        String m941g = C0704b.m912a().m941g();
        String m1075i = C0715m.m1058a().m1075i();
        stringBuffer.append(m1075i);
        stringBuffer.append(m941g);
        stringBuffer.append(C0733o.m1165f(ServiceC0702f.getServiceContext()));
        if (m1150b != 1) {
            if (m1163e.contains("per=0|0|")) {
                C0650d.m371a().m372a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
            } else if (z) {
                C0650d.m371a().m372a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
            } else if (m941g != null && m1075i != null && m941g.equals("&sim=1") && !m1075i.equals("&wifio=1")) {
                m371a = C0650d.m371a();
                i = 6;
                str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
            } else if (!C0733o.m1173l()) {
                C0650d.m371a().m372a(62, 9, "Location failed beacuse we can not get any loc information!");
            }
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        m371a = C0650d.m371a();
        i = 7;
        m371a.m372a(62, i, str);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    /* renamed from: o */
    private void m523o() {
        this.f662v = false;
        this.f635L = false;
        this.f636M = false;
        this.f630G = false;
        m524p();
        if (this.f648Y) {
            this.f648Y = false;
        }
    }

    /* renamed from: p */
    private void m524p() {
        if (this.f653m == null || !C0715m.m1058a().m1077k()) {
            return;
        }
        C0646aa.m312a().m317d();
    }

    /* renamed from: a */
    public Address m525a(BDLocation bDLocation) {
        if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL) || C0733o.f1391g || C0733o.f1393i) {
            Location.distanceBetween(this.f629F, this.f628E, bDLocation.getLatitude(), bDLocation.getLongitude(), new float[2]);
            if (r0[0] < 100.0d) {
                Address address = this.f666z;
                if (address != null) {
                    return address;
                }
            } else {
                this.f625B = null;
                this.f626C = null;
                this.f627D = null;
                this.f630G = true;
                this.f650h.post(new RunnableC0663q(this));
            }
        }
        return null;
    }

    @Override // com.baidu.location.p006b.AbstractC0659m
    /* renamed from: a */
    public void mo463a() {
        BDLocation bDLocation;
        a aVar = this.f633J;
        if (aVar != null && this.f634K) {
            this.f634K = false;
            this.f650h.removeCallbacks(aVar);
        }
        if (C0709g.m959a().m1031k()) {
            BDLocation bDLocation2 = new BDLocation(C0709g.m959a().m1027g());
            Location m1028h = C0709g.m959a().m1028h();
            if (m1028h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(m1028h.getProvider())) {
                bDLocation2.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (m1028h != null) {
                bDLocation2.setExtrainfo(m1028h.getExtras());
            }
            if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL) || C0733o.f1391g || C0733o.f1393i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f629F, this.f628E, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.f666z;
                    if (address != null) {
                        bDLocation2.setAddr(address);
                    }
                    String str = this.f625B;
                    if (str != null) {
                        bDLocation2.setLocationDescribe(str);
                    }
                    List<Poi> list = this.f626C;
                    if (list != null) {
                        bDLocation2.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.f627D;
                    if (poiRegion != null) {
                        bDLocation2.setPoiRegion(poiRegion);
                    }
                }
            }
            C0648b.m321a().m330a(bDLocation2);
        } else {
            if (this.f635L) {
                m523o();
                return;
            }
            if (C0693h.m828a().m840d() && C0693h.m828a().m841e()) {
                bDLocation = C0693h.m828a().m837a(C0704b.m912a().m940f(), C0715m.m1058a().m1082p(), null, C0693h.b.IS_NOT_MIX_MODE, C0693h.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    C0648b.m321a().m330a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.f651k || this.f653m == null) {
                    if (C0686a.m702a().f855a) {
                        bDLocation = C0686a.m702a().m716a(false);
                    } else if (bDLocation == null) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(67);
                    }
                    if (bDLocation != null) {
                        C0648b.m321a().m330a(bDLocation);
                        if (bDLocation.getLocType() == 67 && !this.f638O) {
                            C0650d.m371a().m372a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z = true;
                        if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL) && bDLocation.getAddrStr() == null) {
                            z = false;
                        }
                        if (C0733o.f1391g && bDLocation.getLocationDescribe() == null) {
                            z = false;
                        }
                        if (!((C0733o.f1393i && bDLocation.getPoiList() == null) ? false : z)) {
                            bDLocation.setLocType(67);
                        }
                    }
                } else {
                    C0648b.m321a().m330a(this.f653m);
                }
            }
            this.f654n = null;
        }
        m523o();
    }

    @Override // com.baidu.location.p006b.AbstractC0659m
    /* renamed from: a */
    public void mo464a(Message message) {
        a aVar = this.f633J;
        if (aVar != null && this.f634K) {
            this.f634K = false;
            this.f650h.removeCallbacks(aVar);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        int i = message.arg1;
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            m506b(bDLocation.getTraffic());
            m517e(bDLocation);
            if (i == 1) {
                C0649c.m358a().m367a(bDLocation, "gcj02", null);
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.f638O) {
            bDLocation.setLocType(62);
        }
        m528b(bDLocation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0044, code lost:
    
        if (com.baidu.location.p009e.C0686a.m702a().f855a == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003a, code lost:
    
        if (r0.getLocType() != 67) goto L19;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m526a(boolean r9, boolean r10) {
        /*
            r8 = this;
            com.baidu.location.e.h r0 = com.baidu.location.p009e.C0693h.m828a()
            boolean r0 = r0.m840d()
            r1 = 0
            if (r0 == 0) goto L47
            com.baidu.location.e.h r0 = com.baidu.location.p009e.C0693h.m828a()
            boolean r0 = r0.m843g()
            if (r0 == 0) goto L47
            com.baidu.location.e.h r2 = com.baidu.location.p009e.C0693h.m828a()
            com.baidu.location.f.b r0 = com.baidu.location.p010f.C0704b.m912a()
            com.baidu.location.f.a r3 = r0.m940f()
            com.baidu.location.f.m r0 = com.baidu.location.p010f.C0715m.m1058a()
            com.baidu.location.f.l r4 = r0.m1082p()
            r5 = 0
            com.baidu.location.e.h$b r6 = com.baidu.location.p009e.C0693h.b.IS_NOT_MIX_MODE
            com.baidu.location.e.h$a r7 = com.baidu.location.p009e.C0693h.a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r2.m837a(r3, r4, r5, r6, r7)
            if (r0 == 0) goto L3c
            int r2 = r0.getLocType()
            r3 = 67
            if (r2 != r3) goto L5b
        L3c:
            if (r9 == 0) goto L5b
            com.baidu.location.e.a r9 = com.baidu.location.p009e.C0686a.m702a()
            boolean r9 = r9.f855a
            if (r9 == 0) goto L5b
            goto L51
        L47:
            if (r9 == 0) goto L5a
            com.baidu.location.e.a r9 = com.baidu.location.p009e.C0686a.m702a()
            boolean r9 = r9.f855a
            if (r9 == 0) goto L5a
        L51:
            com.baidu.location.e.a r9 = com.baidu.location.p009e.C0686a.m702a()
            com.baidu.location.BDLocation r0 = r9.m716a(r1)
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 == 0) goto L99
            int r9 = r0.getLocType()
            r2 = 66
            if (r9 != r2) goto L99
            r9 = 1
            java.lang.String r2 = com.baidu.location.p012h.C0733o.f1389e
            java.lang.String r3 = "all"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L77
            java.lang.String r2 = r0.getAddrStr()
            if (r2 != 0) goto L77
            r9 = r1
        L77:
            boolean r2 = com.baidu.location.p012h.C0733o.f1391g
            if (r2 == 0) goto L82
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto L82
            r9 = r1
        L82:
            boolean r2 = com.baidu.location.p012h.C0733o.f1393i
            if (r2 == 0) goto L8d
            java.util.List r2 = r0.getPoiList()
            if (r2 != 0) goto L8d
            goto L8e
        L8d:
            r1 = r9
        L8e:
            if (r1 != 0) goto L92
            if (r10 == 0) goto L99
        L92:
            com.baidu.location.b.b r9 = com.baidu.location.p006b.C0648b.m321a()
            r9.m330a(r0)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.p006b.C0662p.m526a(boolean, boolean):void");
    }

    /* renamed from: b */
    public void m527b(Message message) {
        if (this.f637N) {
            m510c(message);
        }
    }

    /* renamed from: b */
    public void m528b(BDLocation bDLocation) {
        C0650d m371a;
        int i;
        String str;
        String m1075i;
        int m1156c;
        C0714l c0714l;
        BDLocation bDLocation2;
        BDLocation bDLocation3 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            Address address = bDLocation.getAddress();
            this.f666z = address;
            if (address != null && address.cityCode != null) {
                f621g = this.f666z.cityCode;
                this.f624A = System.currentTimeMillis();
            }
            this.f628E = bDLocation.getLongitude();
            this.f629F = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.f625B = bDLocation.getLocationDescribe();
            this.f628E = bDLocation.getLongitude();
            this.f629F = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.f626C = bDLocation.getPoiList();
            this.f628E = bDLocation.getLongitude();
            this.f629F = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.f627D = bDLocation.getPoiRegion();
            this.f628E = bDLocation.getLongitude();
            this.f629F = bDLocation.getLatitude();
        }
        boolean z = false;
        if (C0709g.m959a().m1031k()) {
            BDLocation bDLocation4 = new BDLocation(C0709g.m959a().m1027g());
            Location m1028h = C0709g.m959a().m1028h();
            if (m1028h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(m1028h.getProvider())) {
                bDLocation4.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (m1028h != null) {
                bDLocation4.setExtrainfo(m1028h.getExtras());
            }
            if (C0733o.f1389e.equals(TtmlNode.COMBINE_ALL) || C0733o.f1391g || C0733o.f1393i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f629F, this.f628E, bDLocation4.getLatitude(), bDLocation4.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address2 = this.f666z;
                    if (address2 != null) {
                        bDLocation4.setAddr(address2);
                    }
                    String str2 = this.f625B;
                    if (str2 != null) {
                        bDLocation4.setLocationDescribe(str2);
                    }
                    List<Poi> list = this.f626C;
                    if (list != null) {
                        bDLocation4.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.f627D;
                    if (poiRegion != null) {
                        bDLocation4.setPoiRegion(poiRegion);
                    }
                }
            }
            m514d(bDLocation4);
            m523o();
            return;
        }
        if (this.f635L) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation5 = this.f653m;
            if (bDLocation5 != null) {
                Location.distanceBetween(bDLocation5.getLatitude(), this.f653m.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] <= 10.0f) {
                if (bDLocation.getUserIndoorState() > -1) {
                    this.f653m = bDLocation;
                    C0648b.m321a().m330a(bDLocation);
                }
                m523o();
                return;
            }
            this.f653m = bDLocation;
            if (!this.f636M) {
                this.f636M = false;
                C0648b.m321a().m330a(bDLocation);
            }
            m523o();
            return;
        }
        if (bDLocation.getLocType() == 167) {
            C0650d.m371a().m372a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.getLocType() == 161) {
            if (Build.VERSION.SDK_INT >= 19 && ((m1156c = C0733o.m1156c(ServiceC0702f.getServiceContext())) == 0 || m1156c == 2)) {
                C0650d.m371a().m372a(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (m1075i = C0715m.m1058a().m1075i()) != null && !m1075i.equals("&wifio=1")) {
                C0650d.m371a().m372a(161, 2, "NetWork location successful, open wifi will be better!");
            }
        } else {
            int i2 = 160;
            if (bDLocation.getLocType() == 160) {
                m371a = C0650d.m371a();
                i = 10;
                str = "Coarse location successful, open Accurately locate permission will be better!";
            } else if (C0733o.m1173l()) {
                i2 = 62;
                if (bDLocation.getLocType() == 62) {
                    m371a = C0650d.m371a();
                    i = 11;
                    str = "Coarse location failed because we can not get any loc result";
                }
            }
            m371a.m372a(i2, i, str);
        }
        String str3 = null;
        this.f654n = null;
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.f653m) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.f653m.getNetworkLocationType()) && System.currentTimeMillis() - this.f665y < 30000) {
            this.f654n = bDLocation;
            z = true;
        }
        C0648b m321a = C0648b.m321a();
        if (z) {
            m321a.m330a(this.f653m);
        } else {
            m321a.m330a(bDLocation);
            this.f665y = System.currentTimeMillis();
        }
        if (!C0733o.m1148a(bDLocation)) {
            this.f653m = null;
        } else if (!z) {
            this.f653m = bDLocation;
        }
        int m1137a = C0733o.m1137a(f577d, "ssid\":\"", "\"");
        if (m1137a != Integer.MIN_VALUE && (c0714l = this.f656p) != null) {
            str3 = c0714l.m1046c(m1137a);
        }
        this.f652l = str3;
        if (C0693h.m828a().m840d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && m500a(this.f657q)) {
            C0693h.m828a().m837a(this.f657q, null, bDLocation3, C0693h.b.IS_NOT_MIX_MODE, C0693h.a.NO_NEED_TO_LOG);
            this.f660t = this.f657q;
        }
        if (C0693h.m828a().m840d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
            C0693h.m828a().m837a(null, this.f656p, bDLocation3, C0693h.b.IS_NOT_MIX_MODE, C0693h.a.NO_NEED_TO_LOG);
            this.f659s = this.f656p;
        }
        if (this.f657q != null) {
            C0686a.m702a().m717a(f577d, this.f657q, this.f656p, bDLocation3);
        }
        if (C0715m.m1058a().m1077k()) {
            C0693h.m828a().m845i();
            C0693h.m828a().m849m();
        }
        m523o();
    }

    /* renamed from: c */
    public void m529c(BDLocation bDLocation) {
        this.f653m = new BDLocation(bDLocation);
    }

    /* renamed from: d */
    public void m530d() {
        this.f661u = true;
        this.f662v = false;
        this.f637N = true;
    }

    /* renamed from: e */
    public void m531e() {
        this.f662v = false;
        this.f663w = false;
        this.f635L = false;
        this.f636M = true;
        m538l();
        this.f637N = false;
    }

    /* renamed from: f */
    public String m532f() {
        return this.f625B;
    }

    /* renamed from: g */
    public List<Poi> m533g() {
        return this.f626C;
    }

    /* renamed from: h */
    public PoiRegion m534h() {
        return this.f627D;
    }

    /* renamed from: i */
    public boolean m535i() {
        return this.f651k;
    }

    /* renamed from: j */
    public void m536j() {
        if (!this.f663w) {
            C0675b.m634a().m643d();
        } else {
            m520h(null);
            this.f663w = false;
        }
    }

    /* renamed from: k */
    public boolean m537k() {
        return this.f647X;
    }

    /* renamed from: l */
    public void m538l() {
        this.f653m = null;
    }
}