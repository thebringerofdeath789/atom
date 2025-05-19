package com.baidu.location.b;

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
import com.baidu.location.b.m;
import com.baidu.location.e.h;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class p extends m {
    public static String g = "0";
    public static boolean i = false;
    private static p j;
    private long A;
    private double E;
    private double F;
    public m.b f;
    private boolean k = true;
    private String l = null;
    private BDLocation m = null;
    private BDLocation n = null;
    private Location o = null;
    private com.baidu.location.f.l p = null;
    private com.baidu.location.f.a q = null;
    private HashSet<String> r = null;
    private com.baidu.location.f.l s = null;
    private com.baidu.location.f.a t = null;
    private boolean u = true;
    private volatile boolean v = false;
    private boolean w = false;
    private long x = 0;
    private long y = 0;
    private Address z = null;
    private String B = null;
    private List<Poi> C = null;
    private PoiRegion D = null;
    private boolean G = false;
    private long H = 0;
    private long I = 0;
    private a J = null;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    public final Handler h = new m.a();
    private boolean N = false;
    private boolean O = false;
    private b P = null;
    private boolean Q = false;
    private int R = 0;
    private long S = 0;
    private boolean T = false;
    private String U = null;
    private boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = true;

    private class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(p pVar, q qVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.K) {
                p.this.K = false;
                if (p.this.L || com.baidu.location.f.g.a().k()) {
                    return;
                }
                p.this.a(false, false);
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(p pVar, q qVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.this.Q) {
                p.this.Q = false;
            }
            if (p.this.w) {
                p.this.w = false;
                p.this.h(null);
            }
        }
    }

    private p() {
        this.f = null;
        this.f = new m.b();
    }

    private boolean a(com.baidu.location.f.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (this.t == null) {
            return true;
        }
        return !aVar.a(r0);
    }

    private boolean a(com.baidu.location.f.a aVar, com.baidu.location.f.a aVar2) {
        if (aVar2 == aVar) {
            return false;
        }
        if (aVar2 == null || aVar == null) {
            return true;
        }
        return !aVar.a(aVar2);
    }

    private boolean a(com.baidu.location.f.a aVar, HashSet<String> hashSet) {
        this.b = com.baidu.location.f.b.a().f();
        boolean a2 = a(aVar, this.b);
        if (com.baidu.location.h.o.aF == 0) {
            return a2;
        }
        boolean z = a2 || com.baidu.location.f.b.a().a(aVar, this.b);
        this.c = com.baidu.location.f.b.a().a(this.b);
        return z || a(hashSet, this.c);
    }

    private boolean a(com.baidu.location.f.l lVar) {
        this.a = com.baidu.location.f.m.a().q();
        if (lVar == this.a) {
            return false;
        }
        if (this.a == null || lVar == null) {
            return true;
        }
        return !lVar.c(this.a);
    }

    private boolean a(HashSet<String> hashSet, HashSet<String> hashSet2) {
        if ((hashSet == null || hashSet.isEmpty()) && (hashSet2 == null || hashSet2.isEmpty())) {
            return false;
        }
        if (hashSet == null || hashSet.isEmpty() || hashSet2 == null || hashSet2.isEmpty()) {
            return true;
        }
        int size = hashSet.size();
        Iterator<String> it = hashSet.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (hashSet2.contains(it.next())) {
                i2++;
            }
        }
        return ((float) i2) < ((float) size) * com.baidu.location.h.o.aG;
    }

    private void b(String str) {
        this.W = str != null && "subway".equals(str.toLowerCase());
    }

    public static synchronized p c() {
        p pVar;
        synchronized (p.class) {
            if (j == null) {
                j = new p();
            }
            pVar = j;
        }
        return pVar;
    }

    private void c(Message message) {
        if (com.baidu.location.h.o.ax && !com.baidu.location.h.o.d(com.baidu.location.f.getServiceContext())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.setLocType(62);
            com.baidu.location.b.b.a().a(bDLocation);
            return;
        }
        if (com.baidu.location.h.o.b()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            i = true;
        }
        if (com.baidu.location.indoor.n.a().f()) {
            return;
        }
        com.baidu.location.f.e.a().b();
        int d = com.baidu.location.b.b.a().d(message);
        if (d == 1) {
            d(message);
            return;
        }
        if (d == 2) {
            if (com.baidu.location.f.g.a().k()) {
                e(message);
            }
        } else {
            if (d != 3 && d != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(d)));
            }
            g(message);
        }
    }

    private void d(Message message) {
        if (com.baidu.location.f.g.a().k()) {
            e(message);
            u.a().c();
        } else {
            g(message);
            u.a().b();
        }
    }

    private void d(BDLocation bDLocation) {
        if (com.baidu.location.h.o.l || bDLocation.getMockGpsStrategy() <= 0) {
            com.baidu.location.b.b.a().a(bDLocation);
        } else {
            com.baidu.location.b.b.a().c(bDLocation);
        }
    }

    private void e(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.f.g.a().g());
        Location h = com.baidu.location.f.g.a().h();
        if (h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(h.getProvider())) {
            bDLocation.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
        }
        if (h != null) {
            bDLocation.setExtrainfo(h.getExtras());
        }
        if (com.baidu.location.h.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.h.o.g || com.baidu.location.h.o.i) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.F, this.E, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                Address address = this.z;
                if (address != null) {
                    bDLocation.setAddr(address);
                }
                String str = this.B;
                if (str != null) {
                    bDLocation.setLocationDescribe(str);
                }
                List<Poi> list = this.C;
                if (list != null) {
                    bDLocation.setPoiList(list);
                }
                PoiRegion poiRegion = this.D;
                if (poiRegion != null) {
                    bDLocation.setPoiRegion(poiRegion);
                }
            } else {
                this.G = true;
                g(null);
            }
        }
        this.m = bDLocation;
        this.n = null;
        d(bDLocation);
    }

    private void e(BDLocation bDLocation) {
        this.X = bDLocation != null && bDLocation.isInIndoorPark();
    }

    private void f(Message message) {
        b bVar;
        if (!com.baidu.location.f.m.a().g()) {
            h(message);
            return;
        }
        this.w = true;
        if (this.P == null) {
            this.P = new b(this, null);
        }
        if (this.Q && (bVar = this.P) != null) {
            this.h.removeCallbacks(bVar);
        }
        this.h.postDelayed(this.P, 3500L);
        this.Q = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.R = 0;
        if (!this.u) {
            f(message);
            this.I = SystemClock.uptimeMillis();
            return;
        }
        this.R = 1;
        this.I = SystemClock.uptimeMillis();
        if (com.baidu.location.f.m.a().l()) {
            f(message);
        } else {
            h(message);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void h(android.os.Message r19) {
        /*
            Method dump skipped, instructions count: 702
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.p.h(android.os.Message):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b1, code lost:
    
        if (r0.getPoiList() == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m() {
        /*
            r15 = this;
            double r0 = java.lang.Math.random()
            android.os.SystemClock.uptimeMillis()
            com.baidu.location.f.b r2 = com.baidu.location.f.b.a()
            com.baidu.location.f.a r2 = r2.f()
            com.baidu.location.f.m r3 = com.baidu.location.f.m.a()
            com.baidu.location.f.l r3 = r3.p()
            if (r3 == 0) goto L24
            int r4 = r3.a()
            if (r4 <= 0) goto L24
            long r4 = r3.g()
            goto L26
        L24:
            r4 = 0
        L26:
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L3a
            boolean r2 = r2.e()
            if (r2 == 0) goto L3a
            if (r3 == 0) goto L38
            int r2 = r3.a()
            if (r2 != 0) goto L3a
        L38:
            r2 = r6
            goto L3b
        L3a:
            r2 = r7
        L3b:
            com.baidu.location.e.h r3 = com.baidu.location.e.h.a()
            boolean r3 = r3.d()
            r8 = 0
            if (r3 == 0) goto Lb8
            com.baidu.location.e.h r3 = com.baidu.location.e.h.a()
            boolean r3 = r3.f()
            if (r3 == 0) goto Lb8
            r9 = 60
            int r3 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r3 >= 0) goto Lb8
            if (r2 != 0) goto L6a
            r2 = 0
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto Lb8
            com.baidu.location.e.h r2 = com.baidu.location.e.h.a()
            double r2 = r2.o()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto Lb8
        L6a:
            com.baidu.location.e.h r9 = com.baidu.location.e.h.a()
            com.baidu.location.f.b r0 = com.baidu.location.f.b.a()
            com.baidu.location.f.a r10 = r0.f()
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()
            com.baidu.location.f.l r11 = r0.p()
            r12 = 0
            com.baidu.location.e.h$b r13 = com.baidu.location.e.h.b.IS_MIX_MODE
            com.baidu.location.e.h$a r14 = com.baidu.location.e.h.a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r9.a(r10, r11, r12, r13, r14)
            if (r0 != 0) goto L8b
        L89:
            r1 = r7
            goto Lb4
        L8b:
            java.lang.String r1 = com.baidu.location.h.o.e
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
            boolean r2 = com.baidu.location.h.o.g
            if (r2 == 0) goto La9
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto La9
            r1 = r7
        La9:
            boolean r2 = com.baidu.location.h.o.i
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
            boolean r0 = r15.v
            if (r0 == 0) goto Le0
            com.baidu.location.BDLocation r0 = new com.baidu.location.BDLocation
            r0.<init>(r8)
            r1 = 161(0xa1, float:2.26E-43)
            r0.setLocType(r1)
            boolean r1 = r15.v
            if (r1 == 0) goto Le0
            r15.L = r6
            com.baidu.location.b.b r1 = com.baidu.location.b.b.a()
            r1.a(r0)
            r15.m = r0
            goto Le1
        Le0:
            r6 = r7
        Le1:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.p.m():boolean");
    }

    private String[] n() {
        boolean z;
        d a2;
        int i2;
        String[] strArr = {"", "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int b2 = com.baidu.location.h.o.b(com.baidu.location.f.getServiceContext());
        String str = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        if (b2 == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(b2);
        String e = com.baidu.location.h.o.e(com.baidu.location.f.getServiceContext());
        if (e.contains("per=0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(e);
        if (Build.VERSION.SDK_INT >= 23) {
            stringBuffer.append("&loc=");
            int c = com.baidu.location.h.o.c(com.baidu.location.f.getServiceContext());
            if (c == 0) {
                strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
                z = true;
            } else {
                z = false;
            }
            stringBuffer.append(c);
        } else {
            z = false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            stringBuffer.append("&lmd=");
            int c2 = com.baidu.location.h.o.c(com.baidu.location.f.getServiceContext());
            if (c2 >= 0) {
                stringBuffer.append(c2);
            }
        }
        String g2 = com.baidu.location.f.b.a().g();
        String i3 = com.baidu.location.f.m.a().i();
        stringBuffer.append(i3);
        stringBuffer.append(g2);
        stringBuffer.append(com.baidu.location.h.o.f(com.baidu.location.f.getServiceContext()));
        if (b2 != 1) {
            if (e.contains("per=0|0|")) {
                d.a().a(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
            } else if (z) {
                d.a().a(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
            } else if (g2 != null && i3 != null && g2.equals("&sim=1") && !i3.equals("&wifio=1")) {
                a2 = d.a();
                i2 = 6;
                str = "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!";
            } else if (!com.baidu.location.h.o.l()) {
                d.a().a(62, 9, "Location failed beacuse we can not get any loc information!");
            }
            strArr[0] = stringBuffer.toString();
            return strArr;
        }
        a2 = d.a();
        i2 = 7;
        a2.a(62, i2, str);
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void o() {
        this.v = false;
        this.L = false;
        this.M = false;
        this.G = false;
        p();
        if (this.Y) {
            this.Y = false;
        }
    }

    private void p() {
        if (this.m == null || !com.baidu.location.f.m.a().k()) {
            return;
        }
        aa.a().d();
    }

    public Address a(BDLocation bDLocation) {
        if (com.baidu.location.h.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.h.o.g || com.baidu.location.h.o.i) {
            Location.distanceBetween(this.F, this.E, bDLocation.getLatitude(), bDLocation.getLongitude(), new float[2]);
            if (r0[0] < 100.0d) {
                Address address = this.z;
                if (address != null) {
                    return address;
                }
            } else {
                this.B = null;
                this.C = null;
                this.D = null;
                this.G = true;
                this.h.post(new q(this));
            }
        }
        return null;
    }

    @Override // com.baidu.location.b.m
    public void a() {
        BDLocation bDLocation;
        a aVar = this.J;
        if (aVar != null && this.K) {
            this.K = false;
            this.h.removeCallbacks(aVar);
        }
        if (com.baidu.location.f.g.a().k()) {
            BDLocation bDLocation2 = new BDLocation(com.baidu.location.f.g.a().g());
            Location h = com.baidu.location.f.g.a().h();
            if (h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(h.getProvider())) {
                bDLocation2.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (h != null) {
                bDLocation2.setExtrainfo(h.getExtras());
            }
            if (com.baidu.location.h.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.h.o.g || com.baidu.location.h.o.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.F, this.E, bDLocation2.getLatitude(), bDLocation2.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address = this.z;
                    if (address != null) {
                        bDLocation2.setAddr(address);
                    }
                    String str = this.B;
                    if (str != null) {
                        bDLocation2.setLocationDescribe(str);
                    }
                    List<Poi> list = this.C;
                    if (list != null) {
                        bDLocation2.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.D;
                    if (poiRegion != null) {
                        bDLocation2.setPoiRegion(poiRegion);
                    }
                }
            }
            com.baidu.location.b.b.a().a(bDLocation2);
        } else {
            if (this.L) {
                o();
                return;
            }
            if (com.baidu.location.e.h.a().d() && com.baidu.location.e.h.a().e()) {
                bDLocation = com.baidu.location.e.h.a().a(com.baidu.location.f.b.a().f(), com.baidu.location.f.m.a().p(), null, h.b.IS_NOT_MIX_MODE, h.a.NEED_TO_LOG);
                if (bDLocation != null && bDLocation.getLocType() == 66) {
                    com.baidu.location.b.b.a().a(bDLocation);
                }
            } else {
                bDLocation = null;
            }
            if (bDLocation == null || bDLocation.getLocType() == 67) {
                if (this.k || this.m == null) {
                    if (com.baidu.location.e.a.a().a) {
                        bDLocation = com.baidu.location.e.a.a().a(false);
                    } else if (bDLocation == null) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(67);
                    }
                    if (bDLocation != null) {
                        com.baidu.location.b.b.a().a(bDLocation);
                        if (bDLocation.getLocType() == 67 && !this.O) {
                            d.a().a(67, 3, "Offline location failed, please check the net (wifi/cell)!");
                        }
                        boolean z = true;
                        if (com.baidu.location.h.o.e.equals(TtmlNode.COMBINE_ALL) && bDLocation.getAddrStr() == null) {
                            z = false;
                        }
                        if (com.baidu.location.h.o.g && bDLocation.getLocationDescribe() == null) {
                            z = false;
                        }
                        if (!((com.baidu.location.h.o.i && bDLocation.getPoiList() == null) ? false : z)) {
                            bDLocation.setLocType(67);
                        }
                    }
                } else {
                    com.baidu.location.b.b.a().a(this.m);
                }
            }
            this.n = null;
        }
        o();
    }

    @Override // com.baidu.location.b.m
    public void a(Message message) {
        a aVar = this.J;
        if (aVar != null && this.K) {
            this.K = false;
            this.h.removeCallbacks(aVar);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        int i2 = message.arg1;
        if (bDLocation != null && bDLocation.getLocType() == 161) {
            b(bDLocation.getTraffic());
            e(bDLocation);
            if (i2 == 1) {
                c.a().a(bDLocation, "gcj02", null);
            }
        }
        if (bDLocation != null && bDLocation.getLocType() == 167 && this.O) {
            bDLocation.setLocType(62);
        }
        b(bDLocation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0044, code lost:
    
        if (com.baidu.location.e.a.a().a == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x003a, code lost:
    
        if (r0.getLocType() != 67) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9, boolean r10) {
        /*
            r8 = this;
            com.baidu.location.e.h r0 = com.baidu.location.e.h.a()
            boolean r0 = r0.d()
            r1 = 0
            if (r0 == 0) goto L47
            com.baidu.location.e.h r0 = com.baidu.location.e.h.a()
            boolean r0 = r0.g()
            if (r0 == 0) goto L47
            com.baidu.location.e.h r2 = com.baidu.location.e.h.a()
            com.baidu.location.f.b r0 = com.baidu.location.f.b.a()
            com.baidu.location.f.a r3 = r0.f()
            com.baidu.location.f.m r0 = com.baidu.location.f.m.a()
            com.baidu.location.f.l r4 = r0.p()
            r5 = 0
            com.baidu.location.e.h$b r6 = com.baidu.location.e.h.b.IS_NOT_MIX_MODE
            com.baidu.location.e.h$a r7 = com.baidu.location.e.h.a.NEED_TO_LOG
            com.baidu.location.BDLocation r0 = r2.a(r3, r4, r5, r6, r7)
            if (r0 == 0) goto L3c
            int r2 = r0.getLocType()
            r3 = 67
            if (r2 != r3) goto L5b
        L3c:
            if (r9 == 0) goto L5b
            com.baidu.location.e.a r9 = com.baidu.location.e.a.a()
            boolean r9 = r9.a
            if (r9 == 0) goto L5b
            goto L51
        L47:
            if (r9 == 0) goto L5a
            com.baidu.location.e.a r9 = com.baidu.location.e.a.a()
            boolean r9 = r9.a
            if (r9 == 0) goto L5a
        L51:
            com.baidu.location.e.a r9 = com.baidu.location.e.a.a()
            com.baidu.location.BDLocation r0 = r9.a(r1)
            goto L5b
        L5a:
            r0 = 0
        L5b:
            if (r0 == 0) goto L99
            int r9 = r0.getLocType()
            r2 = 66
            if (r9 != r2) goto L99
            r9 = 1
            java.lang.String r2 = com.baidu.location.h.o.e
            java.lang.String r3 = "all"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L77
            java.lang.String r2 = r0.getAddrStr()
            if (r2 != 0) goto L77
            r9 = r1
        L77:
            boolean r2 = com.baidu.location.h.o.g
            if (r2 == 0) goto L82
            java.lang.String r2 = r0.getLocationDescribe()
            if (r2 != 0) goto L82
            r9 = r1
        L82:
            boolean r2 = com.baidu.location.h.o.i
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
            com.baidu.location.b.b r9 = com.baidu.location.b.b.a()
            r9.a(r0)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.p.a(boolean, boolean):void");
    }

    public void b(Message message) {
        if (this.N) {
            c(message);
        }
    }

    public void b(BDLocation bDLocation) {
        d a2;
        int i2;
        String str;
        String i3;
        int c;
        com.baidu.location.f.l lVar;
        BDLocation bDLocation2;
        BDLocation bDLocation3 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            Address address = bDLocation.getAddress();
            this.z = address;
            if (address != null && address.cityCode != null) {
                g = this.z.cityCode;
                this.A = System.currentTimeMillis();
            }
            this.E = bDLocation.getLongitude();
            this.F = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.B = bDLocation.getLocationDescribe();
            this.E = bDLocation.getLongitude();
            this.F = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.C = bDLocation.getPoiList();
            this.E = bDLocation.getLongitude();
            this.F = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiRegion() != null) {
            this.D = bDLocation.getPoiRegion();
            this.E = bDLocation.getLongitude();
            this.F = bDLocation.getLatitude();
        }
        boolean z = false;
        if (com.baidu.location.f.g.a().k()) {
            BDLocation bDLocation4 = new BDLocation(com.baidu.location.f.g.a().g());
            Location h = com.baidu.location.f.g.a().h();
            if (h != null && BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU.equals(h.getProvider())) {
                bDLocation4.setGnssProvider(BDLocation.BDLOCATION_GNSS_PROVIDER_FROM_BAIDU_BEIDOU);
            }
            if (h != null) {
                bDLocation4.setExtrainfo(h.getExtras());
            }
            if (com.baidu.location.h.o.e.equals(TtmlNode.COMBINE_ALL) || com.baidu.location.h.o.g || com.baidu.location.h.o.i) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.F, this.E, bDLocation4.getLatitude(), bDLocation4.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    Address address2 = this.z;
                    if (address2 != null) {
                        bDLocation4.setAddr(address2);
                    }
                    String str2 = this.B;
                    if (str2 != null) {
                        bDLocation4.setLocationDescribe(str2);
                    }
                    List<Poi> list = this.C;
                    if (list != null) {
                        bDLocation4.setPoiList(list);
                    }
                    PoiRegion poiRegion = this.D;
                    if (poiRegion != null) {
                        bDLocation4.setPoiRegion(poiRegion);
                    }
                }
            }
            d(bDLocation4);
            o();
            return;
        }
        if (this.L) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation5 = this.m;
            if (bDLocation5 != null) {
                Location.distanceBetween(bDLocation5.getLatitude(), this.m.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr2);
            }
            if (fArr2[0] <= 10.0f) {
                if (bDLocation.getUserIndoorState() > -1) {
                    this.m = bDLocation;
                    com.baidu.location.b.b.a().a(bDLocation);
                }
                o();
                return;
            }
            this.m = bDLocation;
            if (!this.M) {
                this.M = false;
                com.baidu.location.b.b.a().a(bDLocation);
            }
            o();
            return;
        }
        if (bDLocation.getLocType() == 167) {
            d.a().a(167, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.getLocType() == 161) {
            if (Build.VERSION.SDK_INT >= 19 && ((c = com.baidu.location.h.o.c(com.baidu.location.f.getServiceContext())) == 0 || c == 2)) {
                d.a().a(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.getRadius() >= 100.0f && bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("cl") && (i3 = com.baidu.location.f.m.a().i()) != null && !i3.equals("&wifio=1")) {
                d.a().a(161, 2, "NetWork location successful, open wifi will be better!");
            }
        } else {
            int i4 = 160;
            if (bDLocation.getLocType() == 160) {
                a2 = d.a();
                i2 = 10;
                str = "Coarse location successful, open Accurately locate permission will be better!";
            } else if (com.baidu.location.h.o.l()) {
                i4 = 62;
                if (bDLocation.getLocType() == 62) {
                    a2 = d.a();
                    i2 = 11;
                    str = "Coarse location failed because we can not get any loc result";
                }
            }
            a2.a(i4, i2, str);
        }
        String str3 = null;
        this.n = null;
        if (bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && (bDLocation2 = this.m) != null && bDLocation2.getLocType() == 161 && "wf".equals(this.m.getNetworkLocationType()) && System.currentTimeMillis() - this.y < 30000) {
            this.n = bDLocation;
            z = true;
        }
        com.baidu.location.b.b a3 = com.baidu.location.b.b.a();
        if (z) {
            a3.a(this.m);
        } else {
            a3.a(bDLocation);
            this.y = System.currentTimeMillis();
        }
        if (!com.baidu.location.h.o.a(bDLocation)) {
            this.m = null;
        } else if (!z) {
            this.m = bDLocation;
        }
        int a4 = com.baidu.location.h.o.a(d, "ssid\":\"", "\"");
        if (a4 != Integer.MIN_VALUE && (lVar = this.p) != null) {
            str3 = lVar.c(a4);
        }
        this.l = str3;
        if (com.baidu.location.e.h.a().d() && bDLocation.getLocType() == 161 && "cl".equals(bDLocation.getNetworkLocationType()) && a(this.q)) {
            com.baidu.location.e.h.a().a(this.q, null, bDLocation3, h.b.IS_NOT_MIX_MODE, h.a.NO_NEED_TO_LOG);
            this.t = this.q;
        }
        if (com.baidu.location.e.h.a().d() && bDLocation.getLocType() == 161 && "wf".equals(bDLocation.getNetworkLocationType())) {
            com.baidu.location.e.h.a().a(null, this.p, bDLocation3, h.b.IS_NOT_MIX_MODE, h.a.NO_NEED_TO_LOG);
            this.s = this.p;
        }
        if (this.q != null) {
            com.baidu.location.e.a.a().a(d, this.q, this.p, bDLocation3);
        }
        if (com.baidu.location.f.m.a().k()) {
            com.baidu.location.e.h.a().i();
            com.baidu.location.e.h.a().m();
        }
        o();
    }

    public void c(BDLocation bDLocation) {
        this.m = new BDLocation(bDLocation);
    }

    public void d() {
        this.u = true;
        this.v = false;
        this.N = true;
    }

    public void e() {
        this.v = false;
        this.w = false;
        this.L = false;
        this.M = true;
        l();
        this.N = false;
    }

    public String f() {
        return this.B;
    }

    public List<Poi> g() {
        return this.C;
    }

    public PoiRegion h() {
        return this.D;
    }

    public boolean i() {
        return this.k;
    }

    public void j() {
        if (!this.w) {
            com.baidu.location.c.b.a().d();
        } else {
            h(null);
            this.w = false;
        }
    }

    public boolean k() {
        return this.X;
    }

    public void l() {
        this.m = null;
    }
}
