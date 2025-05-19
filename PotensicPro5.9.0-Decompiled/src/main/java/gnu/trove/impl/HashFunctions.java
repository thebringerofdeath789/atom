package gnu.trove.impl;

/* loaded from: classes3.dex */
public final class HashFunctions {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int hash(int i) {
        return i;
    }

    public static int hash(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int hash(double d) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public static int hash(float f) {
        return Float.floatToIntBits(f * 6.6360896E8f);
    }

    public static int hash(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
