package org.apache.xmlbeans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.apache.commons.lang3.time.TimeZones;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public final class GDate implements GDateSpecification, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final TimeZone GMTZONE;
    static final int MAX_YEAR = 292277265;
    private static final TimeZone[] MINUSZONE;
    static final int MIN_YEAR = -292275295;
    private static final TimeZone[] PLUSZONE;
    static final BigDecimal _one;
    private static final char[] _onesDigit;
    private static final char[] _tensDigit;
    static final BigDecimal _zero;
    static /* synthetic */ Class class$org$apache$xmlbeans$GDate = null;
    private static final long serialVersionUID = 1;
    private int _CY;
    private int _D;
    private int _M;
    private int _bits;
    private transient String _canonicalString;
    private BigDecimal _fs;
    private int _h;
    private int _m;
    private int _s;
    private transient String _string;
    private int _tzh;
    private int _tzm;
    private int _tzsign;

    static final int digitVal(char c) {
        return c - '0';
    }

    static final boolean isDigit(char c) {
        return ((char) (c + 65488)) <= '\t';
    }

    static final boolean isSpace(char c) {
        return c == '\t' || c == '\n' || c == '\r' || c == ' ';
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean isImmutable() {
        return true;
    }

    static {
        if (class$org$apache$xmlbeans$GDate == null) {
            class$org$apache$xmlbeans$GDate = class$("org.apache.xmlbeans.GDate");
        }
        $assertionsDisabled = true;
        _zero = BigDecimal.valueOf(0L);
        _one = BigDecimal.valueOf(1L);
        _tensDigit = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9', '9', '9', '9', '9', '9'};
        _onesDigit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        GMTZONE = TimeZone.getTimeZone(TimeZones.GMT_ID);
        MINUSZONE = new TimeZone[]{TimeZone.getTimeZone("GMT-00:00"), TimeZone.getTimeZone("GMT-01:00"), TimeZone.getTimeZone("GMT-02:00"), TimeZone.getTimeZone("GMT-03:00"), TimeZone.getTimeZone("GMT-04:00"), TimeZone.getTimeZone("GMT-05:00"), TimeZone.getTimeZone("GMT-06:00"), TimeZone.getTimeZone("GMT-07:00"), TimeZone.getTimeZone("GMT-08:00"), TimeZone.getTimeZone("GMT-09:00"), TimeZone.getTimeZone("GMT-10:00"), TimeZone.getTimeZone("GMT-11:00"), TimeZone.getTimeZone("GMT-12:00"), TimeZone.getTimeZone("GMT-13:00"), TimeZone.getTimeZone("GMT-14:00")};
        PLUSZONE = new TimeZone[]{TimeZone.getTimeZone("GMT+00:00"), TimeZone.getTimeZone("GMT+01:00"), TimeZone.getTimeZone("GMT+02:00"), TimeZone.getTimeZone("GMT+03:00"), TimeZone.getTimeZone("GMT+04:00"), TimeZone.getTimeZone("GMT+05:00"), TimeZone.getTimeZone("GMT+06:00"), TimeZone.getTimeZone("GMT+07:00"), TimeZone.getTimeZone("GMT+08:00"), TimeZone.getTimeZone("GMT+09:00"), TimeZone.getTimeZone("GMT+10:00"), TimeZone.getTimeZone("GMT+11:00"), TimeZone.getTimeZone("GMT+12:00"), TimeZone.getTimeZone("GMT+13:00"), TimeZone.getTimeZone("GMT+14:00")};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public GDate(CharSequence charSequence) {
        int i;
        int i2;
        boolean z;
        int twoDigit;
        int twoDigit2;
        int length = charSequence.length();
        while (length > 0 && isSpace(charSequence.charAt(length - 1))) {
            length--;
        }
        int i3 = 0;
        while (i3 < length && isSpace(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = length - i3;
        if (i4 >= 1 && charSequence.charAt(length - 1) == 'Z') {
            this._bits |= 1;
            length--;
        } else if (i4 >= 6 && charSequence.charAt(length - 3) == ':') {
            char charAt = charSequence.charAt(length - 6);
            if (charAt != '+') {
                i = charAt == '-' ? -1 : i;
            } else {
                i = 1;
            }
            int twoDigit3 = twoDigit(charSequence, length - 5);
            int twoDigit4 = twoDigit(charSequence, length - 2);
            if (twoDigit3 > 14) {
                throw new IllegalArgumentException("time zone hour must be two digits between -14 and +14");
            }
            if (twoDigit4 > 59) {
                throw new IllegalArgumentException("time zone minute must be two digits between 00 and 59");
            }
            this._bits |= 1;
            this._tzsign = i;
            this._tzh = twoDigit3;
            this._tzm = twoDigit4;
            length -= 6;
        }
        if (i3 < length && ((i2 = i3 + 2) >= length || charSequence.charAt(i2) != ':')) {
            if (i3 >= length || charSequence.charAt(i3) != '-') {
                z = false;
            } else {
                i3++;
                z = true;
            }
            int i5 = -i3;
            boolean z2 = i3 < length && digitVal(charSequence.charAt(i3)) == 0;
            int i6 = 0;
            while (true) {
                char charAt2 = i3 < length ? charSequence.charAt(i3) : (char) 0;
                if (!isDigit(charAt2)) {
                    int i7 = i5 + i3;
                    if (i7 > 9) {
                        throw new IllegalArgumentException("year too long (up to 9 digits)");
                    }
                    if (i7 >= 4) {
                        this._bits |= 2;
                        i6 = z ? -i6 : i6;
                        this._CY = i6;
                        if (i6 == 0) {
                            throw new IllegalArgumentException("year must not be zero");
                        }
                    } else if (i7 > 0) {
                        throw new IllegalArgumentException("year must be four digits (may pad with zeroes, e.g., 0560)");
                    }
                    int i8 = this._CY;
                    if (i8 > MAX_YEAR) {
                        throw new IllegalArgumentException("year value not supported: too big, must be less than 292277265");
                    }
                    if (i8 < MIN_YEAR) {
                        throw new IllegalArgumentException("year values not supported: too small, must be bigger than -292275295");
                    }
                    if (charAt2 != '-') {
                        if (z && !hasYear()) {
                            throw new IllegalArgumentException();
                        }
                    } else {
                        i3++;
                        if (length - i3 >= 2 && (twoDigit2 = twoDigit(charSequence, i3)) >= 1 && twoDigit2 <= 12) {
                            this._bits |= 4;
                            this._M = twoDigit2;
                            i3 += 2;
                        }
                        if ((i3 < length ? charSequence.charAt(i3) : (char) 0) != '-') {
                            if (!hasMonth()) {
                                throw new IllegalArgumentException();
                            }
                        } else {
                            i3++;
                            if (length - i3 >= 2 && (twoDigit = twoDigit(charSequence, i3)) >= 1 && twoDigit <= 31) {
                                this._bits |= 8;
                                this._D = twoDigit;
                                i3 += 2;
                            }
                            if (!hasDay()) {
                                if (hasMonth() && !hasYear()) {
                                    if ((i3 < length ? charSequence.charAt(i3) : (char) 0) == '-') {
                                        i3++;
                                    }
                                }
                                throw new IllegalArgumentException();
                            }
                        }
                    }
                } else {
                    if (z2 && i3 + i5 >= 4) {
                        throw new IllegalArgumentException(new StringBuffer().append("year value starting with zero must be 4 or less digits: ").append((Object) charSequence).toString());
                    }
                    i6 = (i6 * 10) + digitVal(charAt2);
                    i3++;
                }
            }
        }
        if (i3 < length) {
            if (hasYear() || hasMonth() || hasDay()) {
                if (charSequence.charAt(i3) != 'T') {
                    throw new IllegalArgumentException("date and time must be separated by 'T'");
                }
                i3++;
            }
            int i9 = i3 + 8;
            if (length < i9 || charSequence.charAt(i3 + 2) != ':' || charSequence.charAt(i3 + 5) != ':') {
                throw new IllegalArgumentException();
            }
            int twoDigit5 = twoDigit(charSequence, i3);
            if (twoDigit5 > 24) {
                throw new IllegalArgumentException("hour must be between 00 and 23");
            }
            int twoDigit6 = twoDigit(charSequence, i3 + 3);
            if (twoDigit6 >= 60) {
                throw new IllegalArgumentException("minute must be between 00 and 59");
            }
            int twoDigit7 = twoDigit(charSequence, i3 + 6);
            if (twoDigit7 >= 60) {
                throw new IllegalArgumentException("second must be between 00 and 59");
            }
            BigDecimal bigDecimal = _zero;
            if (i9 < length) {
                if (charSequence.charAt(i9) != '.') {
                    throw new IllegalArgumentException();
                }
                int i10 = i9 + 1;
                if (i10 < length) {
                    while (i10 < length) {
                        if (!isDigit(charSequence.charAt(i10))) {
                            throw new IllegalArgumentException();
                        }
                        i10++;
                    }
                    bigDecimal = new BigDecimal(charSequence.subSequence(i9, length).toString());
                }
            }
            this._bits |= 16;
            this._h = twoDigit5;
            this._m = twoDigit6;
            this._s = twoDigit7;
            this._fs = bigDecimal;
        }
        if (hasTime() && this._h == 24) {
            if (this._m != 0 || this._s != 0 || this._fs.compareTo(_zero) != 0) {
                throw new IllegalArgumentException("if hour is 24, minutes, seconds and fraction must be 0");
            }
            if (hasDate()) {
                GDateBuilder gDateBuilder = new GDateBuilder(this._CY, this._M, this._D, this._h, this._m, this._s, this._fs, this._tzsign, this._tzh, this._tzm);
                gDateBuilder.normalize24h();
                this._D = gDateBuilder.getDay();
                this._M = gDateBuilder.getMonth();
                this._CY = gDateBuilder.getYear();
                this._h = 0;
            } else if (hasDay()) {
                this._D++;
                this._h = 0;
            }
        }
        if (!isValid()) {
            throw new IllegalArgumentException("invalid date");
        }
    }

    public GDate(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal) {
        this._bits = 30;
        this._CY = i;
        this._M = i2;
        this._D = i3;
        this._h = i4;
        this._m = i5;
        this._s = i6;
        this._fs = bigDecimal == null ? _zero : bigDecimal;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDate(int i, int i2, int i3, int i4, int i5, int i6, BigDecimal bigDecimal, int i7, int i8, int i9) {
        this._bits = 31;
        this._CY = i;
        this._M = i2;
        this._D = i3;
        this._h = i4;
        this._m = i5;
        this._s = i6;
        this._fs = bigDecimal == null ? _zero : bigDecimal;
        this._tzsign = i7;
        this._tzh = i8;
        this._tzm = i9;
        if (!isValid()) {
            throw new IllegalArgumentException();
        }
    }

    public GDate(Date date) {
        this(new GDateBuilder(date));
    }

    public GDate(Calendar calendar) {
        int i;
        int i2;
        boolean z;
        int i3;
        int i4;
        boolean isSet = calendar.isSet(1);
        boolean isSet2 = calendar.isSet(0);
        boolean isSet3 = calendar.isSet(2);
        boolean isSet4 = calendar.isSet(5);
        boolean isSet5 = calendar.isSet(11);
        boolean isSet6 = calendar.isSet(10);
        boolean isSet7 = calendar.isSet(9);
        boolean isSet8 = calendar.isSet(12);
        boolean isSet9 = calendar.isSet(13);
        boolean isSet10 = calendar.isSet(14);
        boolean isSet11 = calendar.isSet(15);
        boolean isSet12 = calendar.isSet(16);
        if (isSet) {
            int i5 = calendar.get(1);
            if (isSet2 && (calendar instanceof GregorianCalendar) && calendar.get(0) == 0) {
                i5 = -i5;
            }
            this._bits |= 2;
            this._CY = i5;
        }
        if (isSet3) {
            this._bits |= 4;
            this._M = calendar.get(2) + 1;
        }
        if (isSet4) {
            this._bits |= 8;
            this._D = calendar.get(5);
        }
        BigDecimal bigDecimal = _zero;
        if (isSet5) {
            i2 = calendar.get(11);
            z = true;
            i = 12;
        } else if (isSet6 && isSet7) {
            i = 12;
            i2 = calendar.get(10) + (calendar.get(9) * 12);
            z = true;
        } else {
            i = 12;
            i2 = 0;
            z = false;
        }
        if (isSet8) {
            i3 = calendar.get(i);
            z = true;
        } else {
            i3 = 0;
        }
        if (isSet9) {
            i4 = calendar.get(13);
            z = true;
        } else {
            i4 = 0;
        }
        if (isSet10) {
            bigDecimal = BigDecimal.valueOf(calendar.get(14), 3);
            z = true;
        }
        if (z) {
            this._bits |= 16;
            this._h = i2;
            this._m = i3;
            this._s = i4;
            this._fs = bigDecimal;
        }
        if (isSet11) {
            int i6 = calendar.get(15);
            i6 = isSet12 ? i6 + calendar.get(16) : i6;
            this._bits |= 1;
            if (i6 == 0) {
                this._tzsign = 0;
                this._tzh = 0;
                this._tzm = 0;
                String id = calendar.getTimeZone().getID();
                if (id == null || id.length() <= 3) {
                    return;
                }
                char charAt = id.charAt(3);
                if (charAt == '+') {
                    this._tzsign = 1;
                    return;
                } else {
                    if (charAt != '-') {
                        return;
                    }
                    this._tzsign = -1;
                    return;
                }
            }
            int i7 = i6 < 0 ? -1 : 1;
            this._tzsign = i7;
            int i8 = i6 * i7;
            int i9 = i8 / 3600000;
            this._tzh = i9;
            this._tzm = (i8 - (i9 * 3600000)) / 60000;
        }
    }

    public GDate(GDateSpecification gDateSpecification) {
        if (gDateSpecification.hasTimeZone()) {
            this._bits |= 1;
            this._tzsign = gDateSpecification.getTimeZoneSign();
            this._tzh = gDateSpecification.getTimeZoneHour();
            this._tzm = gDateSpecification.getTimeZoneMinute();
        }
        if (gDateSpecification.hasTime()) {
            this._bits |= 16;
            this._h = gDateSpecification.getHour();
            this._m = gDateSpecification.getMinute();
            this._s = gDateSpecification.getSecond();
            this._fs = gDateSpecification.getFraction();
        }
        if (gDateSpecification.hasDay()) {
            this._bits |= 8;
            this._D = gDateSpecification.getDay();
        }
        if (gDateSpecification.hasMonth()) {
            this._bits |= 4;
            this._M = gDateSpecification.getMonth();
        }
        if (gDateSpecification.hasYear()) {
            this._bits |= 2;
            this._CY = gDateSpecification.getYear();
        }
    }

    private static final int twoDigit(CharSequence charSequence, int i) {
        char charAt = charSequence.charAt(i);
        char charAt2 = charSequence.charAt(i + 1);
        if (isDigit(charAt) && isDigit(charAt2)) {
            return (digitVal(charAt) * 10) + digitVal(charAt2);
        }
        return 100;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getFlags() {
        return this._bits;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTimeZone() {
        return (this._bits & 1) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasYear() {
        return (this._bits & 2) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasMonth() {
        return (this._bits & 4) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDay() {
        return (this._bits & 8) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasTime() {
        return (this._bits & 16) != 0;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final boolean hasDate() {
        return (this._bits & 14) == 14;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getYear() {
        return this._CY;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMonth() {
        return this._M;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getDay() {
        return this._D;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getHour() {
        return this._h;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getMinute() {
        return this._m;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getSecond() {
        return this._s;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final BigDecimal getFraction() {
        return this._fs;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneSign() {
        return this._tzsign;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneHour() {
        return this._tzh;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public final int getTimeZoneMinute() {
        return this._tzm;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getMillisecond() {
        BigDecimal bigDecimal = this._fs;
        if (bigDecimal == null) {
            return 0;
        }
        return bigDecimal.setScale(3, 1).unscaledValue().intValue();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String canonicalString() {
        ensureCanonicalString();
        return this._canonicalString;
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public boolean isValid() {
        return GDateBuilder.isValidGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getJulianDate() {
        return GDateBuilder.julianDateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public XmlCalendar getCalendar() {
        return new XmlCalendar(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public Date getDate() {
        return GDateBuilder.dateForGDate(this);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int compareToGDate(GDateSpecification gDateSpecification) {
        return GDateBuilder.compareGDate(this, gDateSpecification);
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public int getBuiltinTypeCode() {
        return GDateBuilder.btcForFlags(this._bits);
    }

    public GDate add(GDurationSpecification gDurationSpecification) {
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.addGDuration(gDurationSpecification);
        return gDateBuilder.toGDate();
    }

    public GDate subtract(GDurationSpecification gDurationSpecification) {
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.subtractGDuration(gDurationSpecification);
        return gDateBuilder.toGDate();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GDate)) {
            return false;
        }
        ensureCanonicalString();
        return this._canonicalString.equals(((GDate) obj).canonicalString());
    }

    public int hashCode() {
        ensureCanonicalString();
        return this._canonicalString.hashCode();
    }

    private void ensureCanonicalString() {
        if (this._canonicalString != null) {
            return;
        }
        boolean z = hasTimeZone() && getTimeZoneSign() != 0 && hasTime() && hasDay() == hasMonth() && hasDay() == hasYear();
        if (!z && getFraction() != null && getFraction().scale() > 0) {
            z = getFraction().unscaledValue().mod(GDateBuilder.TEN).signum() == 0;
        }
        if (!z) {
            this._canonicalString = toString();
            return;
        }
        GDateBuilder gDateBuilder = new GDateBuilder(this);
        gDateBuilder.normalize();
        this._canonicalString = gDateBuilder.toString();
    }

    @Override // org.apache.xmlbeans.GDateSpecification
    public String toString() {
        if (this._string == null) {
            this._string = formatGDate(this);
        }
        return this._string;
    }

    private static final int _padTwoAppend(char[] cArr, int i, int i2) {
        if (!$assertionsDisabled && (i2 < 0 || i2 >= 100)) {
            throw new AssertionError();
        }
        cArr[i] = _tensDigit[i2];
        cArr[i + 1] = _onesDigit[i2];
        return i + 2;
    }

    private static final int _padFourAppend(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            cArr[i] = NameUtil.HYPHEN;
            i2 = -i2;
            i++;
        }
        if (i2 >= 10000) {
            String num = Integer.toString(i2);
            num.getChars(0, num.length(), cArr, i);
            return i + num.length();
        }
        int i3 = i2 / 100;
        int i4 = i2 - (i3 * 100);
        char[] cArr2 = _tensDigit;
        cArr[i] = cArr2[i3];
        char[] cArr3 = _onesDigit;
        cArr[i + 1] = cArr3[i3];
        cArr[i + 2] = cArr2[i4];
        cArr[i + 3] = cArr3[i4];
        return i + 4;
    }

    static final TimeZone timeZoneForGDate(GDateSpecification gDateSpecification) {
        if (!gDateSpecification.hasTimeZone()) {
            return TimeZone.getDefault();
        }
        if (gDateSpecification.getTimeZoneSign() == 0) {
            return GMTZONE;
        }
        if (gDateSpecification.getTimeZoneMinute() == 0 && gDateSpecification.getTimeZoneHour() <= 14 && gDateSpecification.getTimeZoneHour() >= 0) {
            return gDateSpecification.getTimeZoneSign() < 0 ? MINUSZONE[gDateSpecification.getTimeZoneHour()] : PLUSZONE[gDateSpecification.getTimeZoneHour()];
        }
        char[] cArr = new char[9];
        cArr[0] = 'G';
        cArr[1] = 'M';
        cArr[2] = 'T';
        cArr[3] = gDateSpecification.getTimeZoneSign() < 0 ? NameUtil.HYPHEN : '+';
        _padTwoAppend(cArr, 4, gDateSpecification.getTimeZoneHour());
        cArr[6] = NameUtil.COLON;
        _padTwoAppend(cArr, 7, gDateSpecification.getTimeZoneMinute());
        return TimeZone.getTimeZone(new String(cArr));
    }

    static String formatGDate(GDateSpecification gDateSpecification) {
        int i;
        String bigDecimal;
        int indexOf;
        BigDecimal fraction = gDateSpecification.getFraction();
        char[] cArr = new char[(fraction == null ? 0 : fraction.scale()) + 33];
        boolean hasYear = gDateSpecification.hasYear();
        char c = NameUtil.HYPHEN;
        if (hasYear || gDateSpecification.hasMonth() || gDateSpecification.hasDay()) {
            if (gDateSpecification.hasYear()) {
                i = _padFourAppend(cArr, 0, gDateSpecification.getYear());
            } else {
                cArr[0] = NameUtil.HYPHEN;
                i = 1;
            }
            if (gDateSpecification.hasMonth() || gDateSpecification.hasDay()) {
                int i2 = i + 1;
                cArr[i] = NameUtil.HYPHEN;
                i = gDateSpecification.hasMonth() ? _padTwoAppend(cArr, i2, gDateSpecification.getMonth()) : i2;
                if (gDateSpecification.hasDay()) {
                    cArr[i] = NameUtil.HYPHEN;
                    i = _padTwoAppend(cArr, i + 1, gDateSpecification.getDay());
                }
            }
            if (gDateSpecification.hasTime()) {
                cArr[i] = 'T';
                i++;
            }
        } else {
            i = 0;
        }
        if (gDateSpecification.hasTime()) {
            int _padTwoAppend = _padTwoAppend(cArr, i, gDateSpecification.getHour());
            cArr[_padTwoAppend] = NameUtil.COLON;
            int _padTwoAppend2 = _padTwoAppend(cArr, _padTwoAppend + 1, gDateSpecification.getMinute());
            cArr[_padTwoAppend2] = NameUtil.COLON;
            i = _padTwoAppend(cArr, _padTwoAppend2 + 1, gDateSpecification.getSecond());
            if (fraction != _zero && (indexOf = (bigDecimal = fraction.toString()).indexOf(46)) >= 0) {
                bigDecimal.getChars(indexOf, bigDecimal.length(), cArr, i);
                i += bigDecimal.length() - indexOf;
            }
        }
        if (gDateSpecification.hasTimeZone()) {
            if (gDateSpecification.getTimeZoneSign() == 0) {
                cArr[i] = 'Z';
                i++;
            } else {
                int i3 = i + 1;
                if (gDateSpecification.getTimeZoneSign() > 0) {
                    c = '+';
                }
                cArr[i] = c;
                int _padTwoAppend3 = _padTwoAppend(cArr, i3, gDateSpecification.getTimeZoneHour());
                cArr[_padTwoAppend3] = NameUtil.COLON;
                i = _padTwoAppend(cArr, _padTwoAppend3 + 1, gDateSpecification.getTimeZoneMinute());
            }
        }
        return new String(cArr, 0, i);
    }
}
