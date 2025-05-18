package common;

/* loaded from: classes3.dex */
public class LengthUnit extends BaseUnit {
    private static int count;
    public static LengthUnit POINTS = new LengthUnit();
    public static LengthUnit METRES = new LengthUnit();
    public static LengthUnit CENTIMETRES = new LengthUnit();
    public static LengthUnit INCHES = new LengthUnit();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private LengthUnit() {
        /*
            r2 = this;
            int r0 = common.LengthUnit.count
            int r1 = r0 + 1
            common.LengthUnit.count = r1
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: common.LengthUnit.<init>():void");
    }

    public static int getCount() {
        return count;
    }
}