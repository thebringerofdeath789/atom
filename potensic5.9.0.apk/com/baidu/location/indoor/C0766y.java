package com.baidu.location.indoor;

import android.location.Location;
import android.os.Handler;
import com.baidu.location.BDLocation;

/* renamed from: com.baidu.location.indoor.y */
/* loaded from: classes.dex */
public class C0766y {

    /* renamed from: a */
    private a f1770a;

    /* renamed from: c */
    private BDLocation f1772c;

    /* renamed from: b */
    private long f1771b = 450;

    /* renamed from: d */
    private b f1773d = null;

    /* renamed from: e */
    private b f1774e = null;

    /* renamed from: f */
    private b f1775f = new b();

    /* renamed from: g */
    private b f1776g = new b();

    /* renamed from: h */
    private b f1777h = new b();

    /* renamed from: i */
    private b f1778i = new b();

    /* renamed from: j */
    private BDLocation f1779j = null;

    /* renamed from: k */
    private long f1780k = -1;

    /* renamed from: l */
    private boolean f1781l = false;

    /* renamed from: m */
    private Handler f1782m = new Handler();

    /* renamed from: n */
    private Runnable f1783n = new RunnableC0767z(this);

    /* renamed from: o */
    private Runnable f1784o = new RunnableC0736aa(this);

    /* renamed from: com.baidu.location.indoor.y$a */
    public interface a {
        /* renamed from: a */
        void mo1430a(BDLocation bDLocation);
    }

    /* renamed from: com.baidu.location.indoor.y$b */
    private class b {

        /* renamed from: a */
        public double f1785a;

        /* renamed from: b */
        public double f1786b;

        public b() {
            this.f1785a = 0.0d;
            this.f1786b = 0.0d;
        }

        public b(double d, double d2) {
            this.f1785a = d;
            this.f1786b = d2;
        }

        public b(b bVar) {
            this.f1785a = bVar.f1785a;
            this.f1786b = bVar.f1786b;
        }

        /* renamed from: a */
        public b m1470a(double d) {
            return C0766y.this.new b(this.f1785a * d, this.f1786b * d);
        }

        /* renamed from: a */
        public b m1471a(b bVar) {
            return C0766y.this.new b(this.f1785a - bVar.f1785a, this.f1786b - bVar.f1786b);
        }

        /* renamed from: b */
        public b m1472b(b bVar) {
            return C0766y.this.new b(this.f1785a + bVar.f1785a, this.f1786b + bVar.f1786b);
        }

        /* renamed from: b */
        public boolean m1473b(double d) {
            double abs = Math.abs(this.f1785a);
            double abs2 = Math.abs(this.f1786b);
            return abs > 0.0d && abs < d && abs2 > 0.0d && abs2 < d;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public b m1454a(b bVar) {
        b bVar2 = this.f1773d;
        if (bVar2 == null || bVar == null) {
            return null;
        }
        b m1471a = bVar2.m1471a(bVar);
        this.f1778i = this.f1778i.m1472b(m1471a);
        b m1471a2 = this.f1777h.m1471a(this.f1775f);
        this.f1775f = new b(this.f1777h);
        this.f1777h = new b(m1471a);
        b m1470a = m1471a.m1470a(0.2d);
        b m1470a2 = this.f1778i.m1470a(0.01d);
        return m1470a.m1472b(m1470a2).m1472b(m1471a2.m1470a(-0.02d));
    }

    /* renamed from: a */
    public void m1465a() {
        if (this.f1781l) {
            this.f1781l = false;
            this.f1782m.removeCallbacks(this.f1784o);
            m1468b();
        }
    }

    /* renamed from: a */
    public void m1466a(long j) {
        this.f1771b = j;
    }

    /* renamed from: a */
    public synchronized void m1467a(BDLocation bDLocation) {
        double latitude = bDLocation.getLatitude();
        double longitude = bDLocation.getLongitude();
        this.f1772c = bDLocation;
        this.f1773d = new b(latitude, longitude);
        if (this.f1774e == null) {
            this.f1774e = new b(latitude, longitude);
        }
        BDLocation bDLocation2 = this.f1779j;
        if (bDLocation2 == null) {
            this.f1779j = new BDLocation(bDLocation);
        } else {
            double latitude2 = bDLocation2.getLatitude();
            double longitude2 = this.f1779j.getLongitude();
            double latitude3 = bDLocation.getLatitude();
            double longitude3 = bDLocation.getLongitude();
            float[] fArr = new float[2];
            Location.distanceBetween(latitude2, longitude2, latitude3, longitude3, fArr);
            if (fArr[0] > 10.0f) {
                this.f1779j.setLatitude(latitude3);
                this.f1779j.setLongitude(longitude3);
            } else {
                this.f1779j.setLatitude((latitude2 + latitude3) / 2.0d);
                this.f1779j.setLongitude((longitude2 + longitude3) / 2.0d);
            }
        }
    }

    /* renamed from: b */
    public void m1468b() {
        this.f1780k = -1L;
        this.f1774e = null;
        this.f1773d = null;
        this.f1775f = new b();
        this.f1776g = new b();
        this.f1777h = new b();
        this.f1778i = new b();
    }

    /* renamed from: c */
    public boolean m1469c() {
        return this.f1781l;
    }
}