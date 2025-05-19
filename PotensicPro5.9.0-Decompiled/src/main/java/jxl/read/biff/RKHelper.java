package jxl.read.biff;

/* loaded from: classes4.dex */
final class RKHelper {
    private RKHelper() {
    }

    public static double getDouble(int i) {
        if ((i & 2) != 0) {
            double d = i >> 2;
            return (i & 1) != 0 ? d / 100.0d : d;
        }
        double longBitsToDouble = Double.longBitsToDouble((i & (-4)) << 32);
        return (i & 1) != 0 ? longBitsToDouble / 100.0d : longBitsToDouble;
    }
}
