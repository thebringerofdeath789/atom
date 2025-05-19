package io.netty.util;

/* loaded from: classes4.dex */
public class IllegalReferenceCountException extends IllegalStateException {
    private static final long serialVersionUID = -2507492394288153468L;

    public IllegalReferenceCountException() {
    }

    public IllegalReferenceCountException(int i) {
        this("refCnt: " + i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public IllegalReferenceCountException(int r3, int r4) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "refCnt: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r3 = r0.append(r3)
            java.lang.String r0 = ", "
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r4 <= 0) goto L23
            r0.<init>()
            java.lang.String r1 = "increment: "
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L2d
        L23:
            r0.<init>()
            java.lang.String r1 = "decrement: "
            java.lang.StringBuilder r0 = r0.append(r1)
            int r4 = -r4
        L2d:
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.IllegalReferenceCountException.<init>(int, int):void");
    }

    public IllegalReferenceCountException(String str) {
        super(str);
    }

    public IllegalReferenceCountException(String str, Throwable th) {
        super(str, th);
    }

    public IllegalReferenceCountException(Throwable th) {
        super(th);
    }
}
