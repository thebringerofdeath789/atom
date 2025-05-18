package com.baidu.location.p006b;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.baidu.location.ServiceC0702f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.location.b.r */
/* loaded from: classes.dex */
public class C0664r {

    /* renamed from: a */
    public List<c> f670a = new ArrayList();

    /* renamed from: b */
    private LocationManager f671b = null;

    /* renamed from: c */
    private b f672c = null;

    /* renamed from: d */
    private boolean f673d = false;

    /* renamed from: com.baidu.location.b.r$a */
    private static class a {

        /* renamed from: a */
        private static C0664r f674a = new C0664r();
    }

    /* renamed from: com.baidu.location.b.r$b */
    private class b implements LocationListener {
        private b() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            Iterator<c> it = C0664r.this.f670a.iterator();
            while (it.hasNext()) {
                it.next().mo545a(location);
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    /* renamed from: com.baidu.location.b.r$c */
    public interface c {
        /* renamed from: a */
        void mo545a(Location location);
    }

    /* renamed from: a */
    public static C0664r m539a() {
        return a.f674a;
    }

    /* renamed from: a */
    public void m540a(c cVar) {
        if (cVar == null) {
            return;
        }
        if (!this.f670a.contains(cVar)) {
            this.f670a.add(cVar);
        }
        if (this.f670a.size() != 1 || this.f673d) {
            return;
        }
        m541b();
        this.f673d = true;
    }

    /* renamed from: b */
    public void m541b() {
        try {
            if (this.f671b == null) {
                this.f671b = (LocationManager) ServiceC0702f.getServiceContext().getSystemService("location");
            }
            if (this.f672c == null) {
                this.f672c = new b();
            }
            LocationManager locationManager = this.f671b;
            if (locationManager == null || !locationManager.isProviderEnabled("network")) {
                return;
            }
            this.f671b.requestLocationUpdates("network", 1000L, 0.0f, this.f672c);
        } catch (Exception unused) {
        }
    }

    /* renamed from: b */
    public void m542b(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f670a.remove(cVar);
        if (this.f670a.size() == 0 && this.f673d) {
            m543c();
            this.f673d = false;
        }
    }

    /* renamed from: c */
    public void m543c() {
        LocationManager locationManager;
        b bVar = this.f672c;
        if (bVar == null || (locationManager = this.f671b) == null) {
            return;
        }
        locationManager.removeUpdates(bVar);
        this.f672c = null;
    }
}