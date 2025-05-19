package org.apache.poi.ss.format;

/* loaded from: classes5.dex */
public class SimpleFraction {
    private final int denominator;
    private final int numerator;

    public static SimpleFraction buildFractionExactDenominator(double d, int i) {
        return new SimpleFraction((int) Math.round(d * i), i);
    }

    public static SimpleFraction buildFractionMaxDenominator(double d, int i) {
        return buildFractionMaxDenominator(d, 0.0d, i, 100);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x012f, code lost:
    
        throw new java.lang.RuntimeException("Overflow trying to convert " + r37 + " to fraction (" + r4 + r36 + r13 + r35);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.apache.poi.ss.format.SimpleFraction buildFractionMaxDenominator(double r37, double r39, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.format.SimpleFraction.buildFractionMaxDenominator(double, double, int, int):org.apache.poi.ss.format.SimpleFraction");
    }

    public SimpleFraction(int i, int i2) {
        this.numerator = i;
        this.denominator = i2;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }
}
