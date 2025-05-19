package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public class GDurationBuilder implements GDurationSpecification, Serializable {
    private static final GDate[] _compDate = {new GDate(1696, 9, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1697, 2, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 3, 1, 0, 0, 0, null, 0, 0, 0), new GDate(1903, 7, 1, 0, 0, 0, null, 0, 0, 0)};
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private int _sign;

    private static final int _mod(long j, int i, long j2) {
        return (int) (j - (j2 * i));
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final boolean isImmutable() {
        return true;
    }

    public GDurationBuilder() {
        this._sign = 1;
        this._fs = GDate._zero;
    }

    public GDurationBuilder(String str) {
        this(new GDuration(str));
    }

    public GDurationBuilder(int i, int i2, int i3, int i4, int i5, int i6, int i7, BigDecimal bigDecimal) {
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

    public GDurationBuilder(GDurationSpecification gDurationSpecification) {
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
        return new GDurationBuilder(this);
    }

    public GDuration toGDuration() {
        return new GDuration(this);
    }

    public void addGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, this._sign * gDurationSpecification.getSign());
    }

    public void subtractGDuration(GDurationSpecification gDurationSpecification) {
        _add(gDurationSpecification, (-this._sign) * gDurationSpecification.getSign());
    }

    private void _add(GDurationSpecification gDurationSpecification, int i) {
        this._CY += gDurationSpecification.getYear() * i;
        this._M += gDurationSpecification.getMonth() * i;
        this._D += gDurationSpecification.getDay() * i;
        this._h += gDurationSpecification.getHour() * i;
        this._m += gDurationSpecification.getMinute() * i;
        this._s += gDurationSpecification.getSecond() * i;
        if (gDurationSpecification.getFraction().signum() == 0) {
            return;
        }
        if (this._fs.signum() == 0 && i == 1) {
            this._fs = gDurationSpecification.getFraction();
        } else {
            this._fs = i > 0 ? this._fs.add(gDurationSpecification.getFraction()) : this._fs.subtract(gDurationSpecification.getFraction());
        }
    }

    public final void setSign(int i) {
        if (i != 1 && i != -1) {
            throw new IllegalArgumentException();
        }
        this._sign = i;
    }

    public void setYear(int i) {
        this._CY = i;
    }

    public void setMonth(int i) {
        this._M = i;
    }

    public void setDay(int i) {
        this._D = i;
    }

    public void setHour(int i) {
        this._h = i;
    }

    public void setMinute(int i) {
        this._m = i;
    }

    public void setSecond(int i) {
        this._s = i;
    }

    public void setFraction(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            bigDecimal = GDate._zero;
        }
        this._fs = bigDecimal;
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
        return isValidDuration(this);
    }

    public void normalize() {
        _normalizeImpl(true);
    }

    private static final long _fQuotient(long j, int i) {
        if ((j < 0) == (i < 0)) {
            return j / i;
        }
        long j2 = i;
        return -(((j2 - j) - 1) / j2);
    }

    private void _normalizeImpl(boolean z) {
        long j;
        int i;
        BigDecimal bigDecimal;
        int i2;
        int i3;
        int i4;
        int i5 = this._M;
        if (i5 < 0 || i5 > 11) {
            long j2 = i5;
            long _fQuotient = _fQuotient(j2, 12);
            this._M = _mod(j2, 12, _fQuotient);
            this._CY = (int) (this._CY + _fQuotient);
        }
        BigDecimal bigDecimal2 = this._fs;
        if (bigDecimal2 == null || (bigDecimal2.signum() >= 0 && this._fs.compareTo(GDate._one) < 0)) {
            j = 0;
        } else {
            BigDecimal scale = this._fs.setScale(0, 3);
            this._fs = this._fs.subtract(scale);
            j = scale.intValue();
        }
        if (j != 0 || (i2 = this._s) < 0 || i2 > 59 || (i3 = this._m) < 0 || i3 > 50 || (i4 = this._h) < 0 || i4 > 23) {
            long j3 = this._s + j;
            long _fQuotient2 = _fQuotient(j3, 60);
            this._s = _mod(j3, 60, _fQuotient2);
            long j4 = this._m + _fQuotient2;
            long _fQuotient3 = _fQuotient(j4, 60);
            this._m = _mod(j4, 60, _fQuotient3);
            long j5 = this._h + _fQuotient3;
            long _fQuotient4 = _fQuotient(j5, 24);
            this._h = _mod(j5, 24, _fQuotient4);
            this._D = (int) (this._D + _fQuotient4);
        }
        if (this._CY == 0 && this._M == 0 && this._D == 0 && this._h == 0 && this._m == 0 && this._s == 0 && ((bigDecimal = this._fs) == null || bigDecimal.signum() == 0)) {
            this._sign = 1;
        }
        if (z) {
            int i6 = this._D;
            if (i6 < 0 || this._CY < 0) {
                int _getTotalSignSlowly = (i6 > 0 || ((i = this._CY) >= 0 && !(i == 0 && this._M == 0))) ? _getTotalSignSlowly() : -this._sign;
                if (_getTotalSignSlowly == 2) {
                    _getTotalSignSlowly = this._CY < 0 ? -this._sign : this._sign;
                }
                int i7 = _getTotalSignSlowly != 0 ? _getTotalSignSlowly : 1;
                if (i7 != this._sign) {
                    this._sign = i7;
                    this._CY = -this._CY;
                    this._M = -this._M;
                    this._D = -this._D;
                    this._h = -this._h;
                    this._m = -this._m;
                    this._s = -this._s;
                    BigDecimal bigDecimal3 = this._fs;
                    if (bigDecimal3 != null) {
                        this._fs = bigDecimal3.negate();
                    }
                }
                _normalizeImpl(false);
            }
        }
    }

    static boolean isValidDuration(GDurationSpecification gDurationSpecification) {
        return (gDurationSpecification.getSign() == 1 || gDurationSpecification.getSign() == -1) && gDurationSpecification.getYear() >= 0 && gDurationSpecification.getMonth() >= 0 && gDurationSpecification.getDay() >= 0 && gDurationSpecification.getHour() >= 0 && gDurationSpecification.getMinute() >= 0 && gDurationSpecification.getSecond() >= 0 && gDurationSpecification.getFraction().signum() >= 0;
    }

    @Override // org.apache.xmlbeans.GDurationSpecification
    public final int compareToGDuration(GDurationSpecification gDurationSpecification) {
        return compareDurations(this, gDurationSpecification);
    }

    public String toString() {
        return formatDuration(this);
    }

    static int compareDurations(GDurationSpecification gDurationSpecification, GDurationSpecification gDurationSpecification2) {
        if (gDurationSpecification.getFraction().signum() == 0 && gDurationSpecification2.getFraction().signum() == 0) {
            int sign = gDurationSpecification.getSign();
            long j = sign;
            long year = ((gDurationSpecification.getYear() * 12) + gDurationSpecification.getMonth()) * j;
            long sign2 = gDurationSpecification2.getSign();
            long year2 = ((gDurationSpecification2.getYear() * 12) + gDurationSpecification2.getMonth()) * sign2;
            long day = j * ((((((gDurationSpecification.getDay() * 24) + gDurationSpecification.getHour()) * 60) + gDurationSpecification.getMinute()) * 60) + gDurationSpecification.getSecond());
            long day2 = sign2 * ((((((gDurationSpecification2.getDay() * 24) + gDurationSpecification2.getHour()) * 60) + gDurationSpecification2.getMinute()) * 60) + gDurationSpecification2.getSecond());
            if (year == year2) {
                if (day == day2) {
                    return 0;
                }
                if (day < day2) {
                    return -1;
                }
                if (day > day2) {
                    return 1;
                }
            }
            if (year < year2 && day - day2 < 2419200) {
                return -1;
            }
            if (year > year2 && day2 - day < 2419200) {
                return 1;
            }
        }
        GDurationBuilder gDurationBuilder = new GDurationBuilder(gDurationSpecification);
        gDurationBuilder.subtractGDuration(gDurationSpecification2);
        return gDurationBuilder._getTotalSignSlowly();
    }

    private int _getTotalSignSlowly() {
        GDate[] gDateArr;
        GDateBuilder gDateBuilder = new GDateBuilder();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            gDateArr = _compDate;
            if (i >= gDateArr.length) {
                break;
            }
            gDateBuilder.setGDate(gDateArr[i]);
            gDateBuilder.addGDuration(this);
            int compareToGDate = gDateBuilder.compareToGDate(gDateArr[i]);
            if (compareToGDate == -1) {
                i3++;
            } else if (compareToGDate == 0) {
                i4++;
            } else if (compareToGDate == 1) {
                i2++;
            }
            i++;
        }
        if (i2 == gDateArr.length) {
            return 1;
        }
        if (i3 == gDateArr.length) {
            return -1;
        }
        return i4 == gDateArr.length ? 0 : 2;
    }

    static String formatDuration(GDurationSpecification gDurationSpecification) {
        StringBuffer stringBuffer = new StringBuffer(30);
        if (gDurationSpecification.getSign() < 0) {
            stringBuffer.append(NameUtil.HYPHEN);
        }
        stringBuffer.append('P');
        if (gDurationSpecification.getYear() != 0) {
            stringBuffer.append(gDurationSpecification.getYear());
            stringBuffer.append('Y');
        }
        if (gDurationSpecification.getMonth() != 0) {
            stringBuffer.append(gDurationSpecification.getMonth());
            stringBuffer.append('M');
        }
        if (gDurationSpecification.getDay() != 0) {
            stringBuffer.append(gDurationSpecification.getDay());
            stringBuffer.append('D');
        }
        if (gDurationSpecification.getHour() != 0 || gDurationSpecification.getMinute() != 0 || gDurationSpecification.getSecond() != 0 || gDurationSpecification.getFraction().signum() != 0) {
            stringBuffer.append('T');
        }
        if (gDurationSpecification.getHour() != 0) {
            stringBuffer.append(gDurationSpecification.getHour());
            stringBuffer.append('H');
        }
        if (gDurationSpecification.getMinute() != 0) {
            stringBuffer.append(gDurationSpecification.getMinute());
            stringBuffer.append('M');
        }
        if (gDurationSpecification.getFraction().signum() != 0) {
            BigDecimal fraction = gDurationSpecification.getFraction();
            if (gDurationSpecification.getSecond() != 0) {
                fraction = fraction.add(BigDecimal.valueOf(gDurationSpecification.getSecond()));
            }
            stringBuffer.append(stripTrailingZeros(toPlainString(fraction)));
            stringBuffer.append('S');
        } else if (gDurationSpecification.getSecond() != 0) {
            stringBuffer.append(gDurationSpecification.getSecond());
            stringBuffer.append('S');
        } else if (stringBuffer.length() <= 2) {
            stringBuffer.append("T0S");
        }
        return stringBuffer.toString();
    }

    public static String toPlainString(BigDecimal bigDecimal) {
        BigInteger unscaledValue = bigDecimal.unscaledValue();
        int scale = bigDecimal.scale();
        String bigInteger = unscaledValue.toString();
        if (scale == 0) {
            return bigInteger;
        }
        int i = bigInteger.charAt(0) == '-' ? 1 : 0;
        int length = (bigInteger.length() - scale) - i;
        StringBuffer stringBuffer = new StringBuffer(bigInteger.length() + 2 + (length <= 0 ? (-length) + 1 : 0));
        if (length <= 0) {
            if (i != 0) {
                stringBuffer.append(NameUtil.HYPHEN);
            }
            stringBuffer.append('0').append('.');
            while (length < 0) {
                stringBuffer.append('0');
                length++;
            }
            stringBuffer.append(bigInteger.substring(i));
        } else if (length < bigInteger.length()) {
            stringBuffer.append(bigInteger);
            stringBuffer.insert(length + i, '.');
        } else {
            stringBuffer.append(bigInteger);
            if (!unscaledValue.equals(BigInteger.ZERO)) {
                for (int length2 = bigInteger.length(); length2 < length; length2++) {
                    stringBuffer.append('0');
                }
            }
        }
        return stringBuffer.toString();
    }

    public static String stripTrailingZeros(String str) {
        boolean z;
        int length = str.length() - 1;
        int i = length;
        while (length >= 0 && str.charAt(length) == '0') {
            length--;
            i--;
        }
        while (true) {
            if (length < 0) {
                z = false;
                break;
            }
            if (str.charAt(length) == 'E') {
                return str;
            }
            if (str.charAt(length) == '.') {
                z = true;
                break;
            }
            length--;
        }
        return z ? str.substring(0, i + 1) : str;
    }
}
