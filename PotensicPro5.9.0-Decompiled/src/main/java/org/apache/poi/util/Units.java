package org.apache.poi.util;

/* loaded from: classes5.dex */
public class Units {
    public static final int EMU_PER_PIXEL = 9525;
    public static final int EMU_PER_POINT = 12700;

    public static double fixedPointToDecimal(int i) {
        return (i >> 16) + (((i >> 0) & 65535) / 65536.0d);
    }

    public static double toPoints(long j) {
        return j / 12700.0d;
    }

    public static int toEMU(double d) {
        return (int) Math.round(d * 12700.0d);
    }
}
