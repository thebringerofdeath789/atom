package com.ipotensic.kernel.maps;

/* loaded from: classes2.dex */
public class DsTransform {
    private static final double PI = 3.141592653589793d;
    private static final double a = 6378245.0d;
    private static final double ee = 0.006693421622965943d;
    private static final double x_PI = 52.35987755982988d;

    public static boolean out_of_china(double d, double d2) {
        return d <= 73.66d || d >= 135.05d || d2 <= 3.86d || d2 >= 53.55d;
    }

    public static double[] bd09togcj02(double d, double d2) {
        double d3 = d - 0.0065d;
        double d4 = d2 - 0.006d;
        double sqrt = Math.sqrt((d3 * d3) + (d4 * d4)) - (Math.sin(d4 * x_PI) * 2.0E-5d);
        double atan2 = Math.atan2(d4, d3) - (Math.cos(d3 * x_PI) * 3.0E-6d);
        return new double[]{Math.cos(atan2) * sqrt, sqrt * Math.sin(atan2)};
    }

    public static double[] gcj02tobd09(double d, double d2) {
        double sqrt = Math.sqrt((d * d) + (d2 * d2)) + (Math.sin(d2 * x_PI) * 2.0E-5d);
        double atan2 = Math.atan2(d2, d) + (Math.cos(d * x_PI) * 3.0E-6d);
        return new double[]{(Math.cos(atan2) * sqrt) + 0.0065d, (sqrt * Math.sin(atan2)) + 0.006d};
    }

    public static double[] wgs84togcj02(double d, double d2) {
        if (out_of_china(d, d2)) {
            return new double[]{d, d2};
        }
        double d3 = d - 105.0d;
        double d4 = d2 - 35.0d;
        double transformlat = transformlat(d3, d4);
        double transformlon = transformlon(d3, d4);
        double d5 = (d2 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((ee * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new double[]{d + ((transformlon * 180.0d) / (((a / sqrt) * Math.cos(d5)) * 3.141592653589793d)), d2 + ((transformlat * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d))};
    }

    public static double[] gcj02towgs84(double d, double d2) {
        if (out_of_china(d, d2)) {
            return new double[]{d, d2};
        }
        double d3 = d - 105.0d;
        double d4 = d2 - 35.0d;
        double transformlat = transformlat(d3, d4);
        double transformlon = transformlon(d3, d4);
        double d5 = (d2 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((ee * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new double[]{(d * 2.0d) - (d + ((transformlon * 180.0d) / (((a / sqrt) * Math.cos(d5)) * 3.141592653589793d))), (d2 * 2.0d) - (d2 + ((transformlat * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d)))};
    }

    public static double[] bd09towgs84(double d, double d2) {
        double[] bd09togcj02 = bd09togcj02(d, d2);
        return gcj02towgs84(bd09togcj02[0], bd09togcj02[1]);
    }

    public static double[] wgs84tobd09(double d, double d2) {
        double[] wgs84togcj02 = wgs84togcj02(d, d2);
        return gcj02tobd09(wgs84togcj02[0], wgs84togcj02[1]);
    }

    public static double transformlon(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin((d * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d * 3.141592653589793d) * 20.0d) + (Math.sin((d / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    public static double transformlat(double d, double d2) {
        double d3 = d * 2.0d;
        double sqrt = (-100.0d) + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin(d3 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d);
        double d4 = d2 * 3.141592653589793d;
        return sqrt + ((((Math.sin(d4) * 20.0d) + (Math.sin((d2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d4 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }
}