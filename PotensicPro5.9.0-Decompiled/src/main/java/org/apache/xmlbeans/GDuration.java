package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;

/* loaded from: classes5.dex */
public final class GDuration implements GDurationSpecification, Serializable {
    private static final int SEEN_DAY = 3;
    private static final int SEEN_HOUR = 4;
    private static final int SEEN_MINUTE = 5;
    private static final int SEEN_MONTH = 2;
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_SECOND = 6;
    private static final int SEEN_YEAR = 1;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    public GDuration() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0122 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public GDuration(java.lang.CharSequence r17) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.GDuration.<init>(java.lang.CharSequence):void");
    }

    public GDuration(int i, int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
        if (i != 1 && i != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i;
        this._CY = i2;
        this._M = i3;
        this._D = i4;
        this._h = i5;
        this._m = i6;
        this._s = i7;
        this._fs = bigDecimal == null ? GDate._zero : bigDecimal;
    }

    public GDuration(GDurationSpecification gDurationSpecification) {
        this._sign = gDurationSpecification.getSign();
        this._CY = gDurationSpecification.getYear();
        this._M = gDurationSpecification.getMonth();
        this._D = gDurationSpecification.getDay();
        this._h = gDurationSpecification.getHour();
        this._m = gDurationSpecification.getMinute();
        this._s = gDurationSpecification.getSecond();
        this._fs = gDurationSpecification.getFraction();
    }

    public Object clone() {
        return new GDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSign() {
        return this._sign;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public boolean isValid() {
        return GDurationBuilder.isValidDuration(this);
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return GDurationBuilder.compareDurations(this, gDurationSpecification);
    }

    public String toString() {
        return GDurationBuilder.formatDuration(this);
    }

    public GDuration add(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, this._sign * gDurationSpecification.getSign());
    }

    public GDuration subtract(GDurationSpecification gDurationSpecification) {
        return _add(gDurationSpecification, (-this._sign) * gDurationSpecification.getSign());
    }

    private GDuration _add(GDurationSpecification gDurationSpecification, int i) {
        GDuration gDuration = new GDuration(this);
        gDuration._CY += gDurationSpecification.getYear() * i;
        gDuration._M += gDurationSpecification.getMonth() * i;
        gDuration._D += gDurationSpecification.getDay() * i;
        gDuration._h += gDurationSpecification.getHour() * i;
        gDuration._m += gDurationSpecification.getMinute() * i;
        gDuration._s += gDurationSpecification.getSecond() * i;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return gDuration;
        }
        if (gDuration._fs.signum() == 0 && i == 1) {
            gDuration._fs = gDurationSpecification.getFraction();
        } else {
            gDuration._fs = i > 0 ? gDuration._fs.add(gDurationSpecification.getFraction()) : gDuration._fs.subtract(gDurationSpecification.getFraction());
        }
        return gDuration;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GDuration)) {
            return false;
        }
        GDuration gDuration = (GDuration) obj;
        return this._sign == gDuration.getSign() && this._CY == gDuration.getYear() && this._M == gDuration.getMonth() && this._D == gDuration.getDay() && this._h == gDuration.getHour() && this._m == gDuration.getMinute() && this._s == gDuration.getSecond() && this._fs.equals(gDuration.getFraction());
    }

    public int hashCode() {
        return this._s + (this._m * 67) + (this._h * 3607) + (this._D * 86407) + (this._M * 2678407) + (this._CY * 32140807) + (this._sign * 11917049);
    }
}
