package com.baidu.geofence.model;

import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.indoor.C0762u;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.geofence.model.c */
/* loaded from: classes.dex */
public class C0619c {
    /* renamed from: a */
    public static boolean m147a(DPoint dPoint, List<DPoint> list) {
        int size = list.size();
        DPoint dPoint2 = list.get(0);
        int i = 0;
        int i2 = 1;
        while (i2 <= size) {
            if (dPoint.equals(dPoint2)) {
                return true;
            }
            DPoint dPoint3 = list.get(i2 % size);
            if (dPoint.getLatitude() >= Math.min(dPoint2.getLatitude(), dPoint3.getLatitude()) && dPoint.getLatitude() <= Math.max(dPoint2.getLatitude(), dPoint3.getLatitude())) {
                if (dPoint.getLatitude() <= Math.min(dPoint2.getLatitude(), dPoint3.getLatitude()) || dPoint.getLatitude() >= Math.max(dPoint2.getLatitude(), dPoint3.getLatitude())) {
                    if (dPoint.getLatitude() == dPoint3.getLatitude() && dPoint.getLongitude() <= dPoint3.getLongitude()) {
                        DPoint dPoint4 = list.get((i2 + 1) % size);
                        if (dPoint.getLatitude() < Math.min(dPoint2.getLatitude(), dPoint4.getLatitude()) || dPoint.getLatitude() > Math.max(dPoint2.getLatitude(), dPoint4.getLatitude())) {
                            i += 2;
                        }
                        i++;
                    }
                } else if (dPoint.getLongitude() > Math.max(dPoint2.getLongitude(), dPoint3.getLongitude())) {
                    continue;
                } else {
                    if (dPoint2.getLatitude() == dPoint3.getLatitude() && dPoint.getLongitude() >= Math.min(dPoint2.getLongitude(), dPoint3.getLongitude())) {
                        return true;
                    }
                    if (dPoint2.getLongitude() != dPoint3.getLongitude()) {
                        double latitude = (((dPoint.getLatitude() - dPoint2.getLatitude()) * (dPoint3.getLongitude() - dPoint2.getLongitude())) / (dPoint3.getLatitude() - dPoint2.getLatitude())) + dPoint2.getLongitude();
                        if (Math.abs(dPoint.getLongitude() - latitude) < 2.0E-10d) {
                            return true;
                        }
                        if (dPoint.getLongitude() >= latitude) {
                        }
                    } else if (dPoint2.getLongitude() == dPoint.getLongitude()) {
                        return true;
                    }
                    i++;
                }
            }
            i2++;
            dPoint2 = dPoint3;
        }
        return i % 2 != 0;
    }

    /* renamed from: a */
    public static boolean m148a(BDLocation bDLocation, ArrayList<DPoint> arrayList) {
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < arrayList.size(); i++) {
            d2 += arrayList.get(i).getLatitude();
            d3 += arrayList.get(i).getLongitude();
        }
        DPoint dPoint = new DPoint(d2 / arrayList.size(), d3 / arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            double m1434a = C0762u.m1434a(arrayList.get(i2).getLatitude(), arrayList.get(i2).getLongitude(), dPoint.getLatitude(), dPoint.getLongitude());
            if (m1434a > d) {
                d = m1434a;
            }
        }
        float[] fArr = new float[2];
        Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), dPoint.getLatitude(), dPoint.getLongitude(), fArr);
        return ((double) fArr[0]) < d + 500.0d;
    }
}