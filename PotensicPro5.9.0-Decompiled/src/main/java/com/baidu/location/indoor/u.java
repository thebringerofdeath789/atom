package com.baidu.location.indoor;

/* loaded from: classes.dex */
public class u {
    private static double a = 6378137.0d;

    public static double a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double radians = Math.toRadians(d);
        Math.toRadians(d2);
        double radians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        double radians3 = Math.toRadians(d5);
        double radians4 = Math.toRadians(d6) / 2.0d;
        double d7 = radians3 / 2.0d;
        double sin = (Math.sin(radians4) * Math.sin(radians4)) + (Math.cos(radians) * Math.cos(radians2) * Math.sin(d7) * Math.sin(d7));
        return Math.atan2(Math.sqrt(sin), Math.sqrt(1.0d - sin)) * 2.0d * a;
    }
}
