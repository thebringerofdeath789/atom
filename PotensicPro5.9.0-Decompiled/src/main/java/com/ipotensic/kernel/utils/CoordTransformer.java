package com.ipotensic.kernel.utils;

import com.ipotensic.baselib.bean.MyLatLng;

/* loaded from: classes2.dex */
public class CoordTransformer {
    public static double a = 6378245.0d;
    public static double ee = 0.006693421622965943d;
    public static double pi = 3.141592653589793d;

    public static MyLatLng gcj02ToWgs84(double d, double d2) {
        MyLatLng transform = transform(d, d2);
        return new MyLatLng((d * 2.0d) - transform.getLat(), (d2 * 2.0d) - transform.getLng());
    }

    public static MyLatLng transformFromWGSToGCJ02(MyLatLng myLatLng) {
        double transformLat = transformLat(myLatLng.getLng() - 105.0d, myLatLng.getLat() - 35.0d);
        double transformLon = transformLon(myLatLng.getLng() - 105.0d, myLatLng.getLat() - 35.0d);
        double lat = (myLatLng.getLat() / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(lat);
        double d = 1.0d - ((ee * sin) * sin);
        double sqrt = Math.sqrt(d);
        double d2 = a;
        return new MyLatLng(myLatLng.getLat() + ((transformLat * 180.0d) / ((((1.0d - ee) * d2) / (d * sqrt)) * 3.141592653589793d)), myLatLng.getLng() + ((transformLon * 180.0d) / (((d2 / sqrt) * Math.cos(lat)) * 3.141592653589793d)));
    }

    private static double transformLat(double d, double d2) {
        double d3 = d * 2.0d;
        return (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((d * 6.0d) * pi) * 20.0d) + (Math.sin(d3 * pi) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(pi * d2) * 20.0d) + (Math.sin((d2 / 3.0d) * pi) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * pi) * 160.0d) + (Math.sin((d2 * pi) / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    private static double transformLon(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * pi) * 20.0d) + (Math.sin((d * 2.0d) * pi) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(pi * d) * 20.0d) + (Math.sin((d / 3.0d) * pi) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * pi) * 150.0d) + (Math.sin((d / 30.0d) * pi) * 300.0d)) * 2.0d) / 3.0d);
    }

    private static MyLatLng transform(double d, double d2) {
        double d3 = d2 - 105.0d;
        double d4 = d - 35.0d;
        double transformLat = transformLat(d3, d4);
        double transformLon = transformLon(d3, d4);
        double d5 = (d / 180.0d) * pi;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((ee * sin) * sin);
        double sqrt = Math.sqrt(d6);
        double d7 = a;
        return new MyLatLng(d + ((transformLat * 180.0d) / ((((1.0d - ee) * d7) / (d6 * sqrt)) * pi)), d2 + ((transformLon * 180.0d) / (((d7 / sqrt) * Math.cos(d5)) * pi)));
    }
}
