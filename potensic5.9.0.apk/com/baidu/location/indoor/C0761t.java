package com.baidu.location.indoor;

import android.location.Location;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.indoor.t */
/* loaded from: classes.dex */
public class C0761t {

    /* renamed from: a */
    private List<Location> f1742a;

    /* renamed from: b */
    private String f1743b;

    /* renamed from: c */
    private Location f1744c = null;

    C0761t(String str, Location[] locationArr) {
        if (locationArr == null || locationArr.length <= 0) {
            return;
        }
        m1432a(locationArr);
        this.f1743b = str;
    }

    /* renamed from: a */
    private void m1432a(Location[] locationArr) {
        if (locationArr == null || locationArr.length <= 0) {
            return;
        }
        if (this.f1742a == null) {
            this.f1742a = new ArrayList();
        }
        double d = 0.0d;
        double d2 = 0.0d;
        for (int i = 0; i < locationArr.length; i++) {
            d += locationArr[i].getLatitude();
            d2 += locationArr[i].getLongitude();
            this.f1742a.add(locationArr[i]);
        }
        if (this.f1744c == null) {
            Location location = new Location("gps");
            this.f1744c = location;
            location.setLatitude(d / locationArr.length);
            this.f1744c.setLongitude(d2 / locationArr.length);
        }
    }

    /* renamed from: a */
    public String m1433a() {
        return this.f1743b;
    }
}