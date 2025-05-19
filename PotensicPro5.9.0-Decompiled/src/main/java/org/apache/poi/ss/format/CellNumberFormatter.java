package org.apache.poi.ss.format;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.format.CellFormatPart;

/* loaded from: classes5.dex */
public class CellNumberFormatter extends CellFormatter {
    private Special afterFractional;
    private Special afterInteger;
    private DecimalFormat decimalFmt;
    private Special decimalPoint;
    private String denominatorFmt;
    private List<Special> denominatorSpecials;
    private final String desc;
    private Special exponent;
    private List<Special> exponentDigitSpecials;
    private List<Special> exponentSpecials;
    private List<Special> fractionalSpecials;
    private boolean improperFraction;
    private boolean integerCommas;
    private List<Special> integerSpecials;
    private int maxDenominator;
    private Special numerator;
    private String numeratorFmt;
    private List<Special> numeratorSpecials;
    private String printfFmt;
    private double scale;
    private Special slash;
    private final List<Special> specials;
    static final CellFormatter SIMPLE_NUMBER = new CellFormatter("General") { // from class: org.apache.poi.ss.format.CellNumberFormatter.1
        @Override // org.apache.poi.ss.format.CellFormatter
        public void formatValue(StringBuffer stringBuffer, Object obj) {
            if (obj == null) {
                return;
            }
            if (!(obj instanceof Number)) {
                CellTextFormatter.SIMPLE_TEXT.formatValue(stringBuffer, obj);
            } else if (((Number) obj).doubleValue() % 1.0d == 0.0d) {
                CellNumberFormatter.SIMPLE_INT.formatValue(stringBuffer, obj);
            } else {
                CellNumberFormatter.SIMPLE_FLOAT.formatValue(stringBuffer, obj);
            }
        }

        @Override // org.apache.poi.ss.format.CellFormatter
        public void simpleValue(StringBuffer stringBuffer, Object obj) {
            formatValue(stringBuffer, obj);
        }
    };
    private static final CellFormatter SIMPLE_INT = new CellNumberFormatter("#");
    private static final CellFormatter SIMPLE_FLOAT = new CellNumberFormatter("#.#");

    static /* synthetic */ double access$1034(CellNumberFormatter cellNumberFormatter, double d) {
        double d2 = cellNumberFormatter.scale * d;
        cellNumberFormatter.scale = d2;
        return d2;
    }

    static class Special {
        final char ch;
        int pos;

        Special(char c, int i) {
            this.ch = c;
            this.pos = i;
        }

        public String toString() {
            return "'" + this.ch + "' @ " + this.pos;
        }
    }

    static class StringMod implements Comparable<StringMod> {
        public static final int AFTER = 2;
        public static final int BEFORE = 1;
        public static final int REPLACE = 3;
        Special end;
        boolean endInclusive;
        final int op;
        final Special special;
        boolean startInclusive;
        CharSequence toAdd;

        private StringMod(Special special, CharSequence charSequence, int i) {
            this.special = special;
            this.toAdd = charSequence;
            this.op = i;
        }

        public StringMod(Special special, boolean z, Special special2, boolean z2, char c) {
            this(special, z, special2, z2);
            this.toAdd = c + "";
        }

        public StringMod(Special special, boolean z, Special special2, boolean z2) {
            this.special = special;
            this.startInclusive = z;
            this.end = special2;
            this.endInclusive = z2;
            this.op = 3;
            this.toAdd = "";
        }

        @Override // java.lang.Comparable
        public int compareTo(StringMod stringMod) {
            int i = this.special.pos - stringMod.special.pos;
            return i != 0 ? i : this.op - stringMod.op;
        }

        public boolean equals(Object obj) {
            try {
                return compareTo((StringMod) obj) == 0;
            } catch (RuntimeException unused) {
                return false;
            }
        }

        public int hashCode() {
            return this.special.hashCode() + this.op;
        }
    }

    private class NumPartHandler implements CellFormatPart.PartHandler {
        private char insertSignForExponent;

        private NumPartHandler() {
        }

        @Override // org.apache.poi.ss.format.CellFormatPart.PartHandler
        public String handlePart(Matcher matcher, String str, CellFormatType cellFormatType, StringBuffer stringBuffer) {
            int length = stringBuffer.length();
            char charAt = str.charAt(0);
            if (charAt != '#') {
                if (charAt == '%') {
                    CellNumberFormatter.access$1034(CellNumberFormatter.this, 100.0d);
                } else if (charAt != '?') {
                    if (charAt == 'E' || charAt == 'e') {
                        if (CellNumberFormatter.this.exponent == null && CellNumberFormatter.this.specials.size() > 0) {
                            CellNumberFormatter.this.specials.add(CellNumberFormatter.this.exponent = new Special('.', length));
                            this.insertSignForExponent = str.charAt(1);
                            return str.substring(0, 1);
                        }
                    } else {
                        switch (charAt) {
                            case '.':
                                if (CellNumberFormatter.this.decimalPoint == null && CellNumberFormatter.this.specials.size() > 0) {
                                    CellNumberFormatter.this.specials.add(CellNumberFormatter.this.decimalPoint = new Special('.', length));
                                    break;
                                }
                                break;
                            case '/':
                                if (CellNumberFormatter.this.slash == null && CellNumberFormatter.this.specials.size() > 0) {
                                    CellNumberFormatter cellNumberFormatter = CellNumberFormatter.this;
                                    cellNumberFormatter.numerator = cellNumberFormatter.previousNumber();
                                    if (CellNumberFormatter.this.numerator == CellNumberFormatter.firstDigit(CellNumberFormatter.this.specials)) {
                                        CellNumberFormatter.this.improperFraction = true;
                                    }
                                    CellNumberFormatter.this.specials.add(CellNumberFormatter.this.slash = new Special('.', length));
                                    break;
                                }
                                break;
                            case '0':
                                break;
                            default:
                                return null;
                        }
                    }
                }
                return str;
            }
            if (this.insertSignForExponent != 0) {
                CellNumberFormatter.this.specials.add(new Special(this.insertSignForExponent, length));
                stringBuffer.append(this.insertSignForExponent);
                this.insertSignForExponent = (char) 0;
                length++;
            }
            for (int i = 0; i < str.length(); i++) {
                CellNumberFormatter.this.specials.add(new Special(str.charAt(i), length + i));
            }
            return str;
        }
    }

    public CellNumberFormatter(String str) {
        super(str);
        int interpretPrecision;
        int i;
        this.scale = 1.0d;
        LinkedList linkedList = new LinkedList();
        this.specials = linkedList;
        StringBuffer parseFormat = CellFormatPart.parseFormat(str, CellFormatType.NUMBER, new NumPartHandler());
        if ((this.decimalPoint != null || this.exponent != null) && this.slash != null) {
            this.slash = null;
            this.numerator = null;
        }
        interpretCommas(parseFormat);
        if (this.decimalPoint == null) {
            interpretPrecision = 0;
            i = 0;
        } else {
            interpretPrecision = interpretPrecision();
            i = interpretPrecision + 1;
            if (interpretPrecision == 0) {
                linkedList.remove(this.decimalPoint);
                this.decimalPoint = null;
            }
        }
        boolean z = true;
        if (interpretPrecision == 0) {
            this.fractionalSpecials = Collections.emptyList();
        } else {
            this.fractionalSpecials = linkedList.subList(linkedList.indexOf(this.decimalPoint) + 1, fractionalEnd());
        }
        Special special = this.exponent;
        if (special == null) {
            this.exponentSpecials = Collections.emptyList();
        } else {
            int indexOf = linkedList.indexOf(special);
            this.exponentSpecials = specialsFor(indexOf, 2);
            this.exponentDigitSpecials = specialsFor(indexOf + 2);
        }
        if (this.slash == null) {
            this.numeratorSpecials = Collections.emptyList();
            this.denominatorSpecials = Collections.emptyList();
        } else {
            Special special2 = this.numerator;
            if (special2 == null) {
                this.numeratorSpecials = Collections.emptyList();
            } else {
                this.numeratorSpecials = specialsFor(linkedList.indexOf(special2));
            }
            List<Special> specialsFor = specialsFor(linkedList.indexOf(this.slash) + 1);
            this.denominatorSpecials = specialsFor;
            if (specialsFor.isEmpty()) {
                this.numeratorSpecials = Collections.emptyList();
            } else {
                this.maxDenominator = maxValue(this.denominatorSpecials);
                this.numeratorFmt = singleNumberFormat(this.numeratorSpecials);
                this.denominatorFmt = singleNumberFormat(this.denominatorSpecials);
            }
        }
        this.integerSpecials = linkedList.subList(0, integerEnd());
        if (this.exponent == null) {
            StringBuffer stringBuffer = new StringBuffer("%");
            stringBuffer.append('0').append(calculateIntegerPartWidth() + i).append('.').append(interpretPrecision);
            stringBuffer.append("f");
            this.printfFmt = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            List<Special> list = this.integerSpecials;
            if (list.size() == 1) {
                stringBuffer2.append(SessionDescription.SUPPORTED_SDP_VERSION);
                z = false;
            } else {
                Iterator<Special> it = list.iterator();
                while (it.hasNext()) {
                    if (isDigitFmt(it.next())) {
                        stringBuffer2.append(z ? '#' : '0');
                        z = false;
                    }
                }
            }
            if (this.fractionalSpecials.size() > 0) {
                stringBuffer2.append('.');
                Iterator<Special> it2 = this.fractionalSpecials.iterator();
                while (it2.hasNext()) {
                    if (isDigitFmt(it2.next())) {
                        if (!z) {
                            stringBuffer2.append('0');
                        }
                        z = false;
                    }
                }
            }
            stringBuffer2.append('E');
            List<Special> list2 = this.exponentSpecials;
            placeZeros(stringBuffer2, list2.subList(2, list2.size()));
            this.decimalFmt = new DecimalFormat(stringBuffer2.toString());
        }
        if (this.exponent != null) {
            this.scale = 1.0d;
        }
        this.desc = parseFormat.toString();
    }

    private static void placeZeros(StringBuffer stringBuffer, List<Special> list) {
        Iterator<Special> it = list.iterator();
        while (it.hasNext()) {
            if (isDigitFmt(it.next())) {
                stringBuffer.append('0');
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Special firstDigit(List<Special> list) {
        for (Special special : list) {
            if (isDigitFmt(special)) {
                return special;
            }
        }
        return null;
    }

    static StringMod insertMod(Special special, CharSequence charSequence, int i) {
        return new StringMod(special, charSequence, i);
    }

    static StringMod deleteMod(Special special, boolean z, Special special2, boolean z2) {
        return new StringMod(special, z, special2, z2);
    }

    static StringMod replaceMod(Special special, boolean z, Special special2, boolean z2, char c) {
        return new StringMod(special, z, special2, z2, c);
    }

    private static String singleNumberFormat(List<Special> list) {
        return "%0" + list.size() + "d";
    }

    private static int maxValue(List<Special> list) {
        return (int) Math.round(Math.pow(10.0d, list.size()) - 1.0d);
    }

    private List<Special> specialsFor(int i, int i2) {
        if (i >= this.specials.size()) {
            return Collections.emptyList();
        }
        int i3 = i2 + i;
        ListIterator<Special> listIterator = this.specials.listIterator(i3);
        Special next = listIterator.next();
        while (listIterator.hasNext()) {
            Special next2 = listIterator.next();
            if (!isDigitFmt(next2) || next2.pos - next.pos > 1) {
                break;
            }
            i3++;
            next = next2;
        }
        return this.specials.subList(i, i3 + 1);
    }

    private List<Special> specialsFor(int i) {
        return specialsFor(i, 0);
    }

    private static boolean isDigitFmt(Special special) {
        return special.ch == '0' || special.ch == '?' || special.ch == '#';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Special previousNumber() {
        List<Special> list = this.specials;
        ListIterator<Special> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Special previous = listIterator.previous();
            if (isDigitFmt(previous)) {
                while (listIterator.hasPrevious()) {
                    Special previous2 = listIterator.previous();
                    if (previous.pos - previous2.pos > 1 || !isDigitFmt(previous2)) {
                        break;
                    }
                    previous = previous2;
                }
                return previous;
            }
        }
        return null;
    }

    private int calculateIntegerPartWidth() {
        Special next;
        ListIterator<Special> listIterator = this.specials.listIterator();
        int i = 0;
        while (listIterator.hasNext() && (next = listIterator.next()) != this.afterInteger) {
            if (isDigitFmt(next)) {
                i++;
            }
        }
        return i;
    }

    private int interpretPrecision() {
        Special special = this.decimalPoint;
        if (special == null) {
            return -1;
        }
        int i = 0;
        List<Special> list = this.specials;
        ListIterator<Special> listIterator = list.listIterator(list.indexOf(special));
        if (listIterator.hasNext()) {
            listIterator.next();
        }
        while (listIterator.hasNext() && isDigitFmt(listIterator.next())) {
            i++;
        }
        return i;
    }

    private void interpretCommas(StringBuffer stringBuffer) {
        ListIterator<Special> listIterator = this.specials.listIterator(integerEnd());
        int i = 0;
        this.integerCommas = false;
        boolean z = true;
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().ch != ',') {
                z = false;
            } else if (z) {
                this.scale /= 1000.0d;
            } else {
                this.integerCommas = true;
            }
        }
        if (this.decimalPoint != null) {
            ListIterator<Special> listIterator2 = this.specials.listIterator(fractionalEnd());
            while (listIterator2.hasPrevious() && listIterator2.previous().ch == ',') {
                this.scale /= 1000.0d;
            }
        }
        ListIterator<Special> listIterator3 = this.specials.listIterator();
        while (listIterator3.hasNext()) {
            Special next = listIterator3.next();
            next.pos -= i;
            if (next.ch == ',') {
                i++;
                listIterator3.remove();
                stringBuffer.deleteCharAt(next.pos);
            }
        }
    }

    private int integerEnd() {
        Special special = this.decimalPoint;
        if (special != null) {
            this.afterInteger = special;
        } else {
            Special special2 = this.exponent;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                Special special3 = this.numerator;
                if (special3 != null) {
                    this.afterInteger = special3;
                } else {
                    this.afterInteger = null;
                }
            }
        }
        Special special4 = this.afterInteger;
        return special4 == null ? this.specials.size() : this.specials.indexOf(special4);
    }

    private int fractionalEnd() {
        Special special = this.exponent;
        if (special != null) {
            this.afterFractional = special;
        } else {
            Special special2 = this.numerator;
            if (special2 != null) {
                this.afterInteger = special2;
            } else {
                this.afterFractional = null;
            }
        }
        Special special3 = this.afterFractional;
        return special3 == null ? this.specials.size() : this.specials.indexOf(special3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0044  */
    @Override // org.apache.poi.ss.format.CellFormatter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void formatValue(java.lang.StringBuffer r19, java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.format.CellNumberFormatter.formatValue(java.lang.StringBuffer, java.lang.Object):void");
    }

    private void writeScientific(double d, StringBuffer stringBuffer, Set<StringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        FieldPosition fieldPosition = new FieldPosition(1);
        this.decimalFmt.format(d, stringBuffer2, fieldPosition);
        writeInteger(stringBuffer2, stringBuffer, this.integerSpecials, set, this.integerCommas);
        writeFractional(stringBuffer2, stringBuffer);
        int endIndex = fieldPosition.getEndIndex() + 1;
        char charAt = stringBuffer2.charAt(endIndex);
        if (charAt != '-') {
            stringBuffer2.insert(endIndex, '+');
            charAt = '+';
        }
        Special next = this.exponentSpecials.listIterator(1).next();
        char c = next.ch;
        if (charAt == '-' || c == '+') {
            set.add(replaceMod(next, true, next, true, charAt));
        } else {
            set.add(deleteMod(next, true, next, true));
        }
        writeInteger(new StringBuffer(stringBuffer2.substring(endIndex + 1)), stringBuffer, this.exponentDigitSpecials, set, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0136 A[Catch: RuntimeException -> 0x015f, TryCatch #0 {RuntimeException -> 0x015f, blocks: (B:52:0x0110, B:54:0x0114, B:57:0x011d, B:41:0x0132, B:43:0x0136, B:44:0x0143, B:40:0x012d), top: B:51:0x0110 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void writeFraction(double r17, java.lang.StringBuffer r19, double r20, java.lang.StringBuffer r22, java.util.Set<org.apache.poi.ss.format.CellNumberFormatter.StringMod> r23) {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.ss.format.CellNumberFormatter.writeFraction(double, java.lang.StringBuffer, double, java.lang.StringBuffer, java.util.Set):void");
    }

    private static boolean hasChar(char c, List<Special>... listArr) {
        for (List<Special> list : listArr) {
            Iterator<Special> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().ch == c) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasOnly(char c, List<Special>... listArr) {
        for (List<Special> list : listArr) {
            Iterator<Special> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().ch != c) {
                    return false;
                }
            }
        }
        return true;
    }

    private void writeSingleInteger(String str, int i, StringBuffer stringBuffer, List<Special> list, Set<StringMod> set) {
        StringBuffer stringBuffer2 = new StringBuffer();
        Formatter formatter = new Formatter(stringBuffer2);
        try {
            formatter.format(LOCALE, str, Integer.valueOf(i));
            formatter.close();
            writeInteger(stringBuffer2, stringBuffer, list, set, false);
        } catch (Throwable th) {
            formatter.close();
            throw th;
        }
    }

    private void writeInteger(StringBuffer stringBuffer, StringBuffer stringBuffer2, List<Special> list, Set<StringMod> set, boolean z) {
        boolean z2;
        char charAt;
        int length;
        int indexOf = stringBuffer.indexOf(".") - 1;
        if (indexOf < 0) {
            if (this.exponent != null && list == this.integerSpecials) {
                length = stringBuffer.indexOf("E");
            } else {
                length = stringBuffer.length();
            }
            indexOf = length - 1;
        }
        int i = 0;
        while (i < indexOf && ((charAt = stringBuffer.charAt(i)) == '0' || charAt == ',')) {
            i++;
        }
        ListIterator<Special> listIterator = list.listIterator(list.size());
        Special special = null;
        int i2 = 0;
        while (listIterator.hasPrevious()) {
            char charAt2 = indexOf >= 0 ? stringBuffer.charAt(indexOf) : '0';
            Special previous = listIterator.previous();
            boolean z3 = z && i2 > 0 && i2 % 3 == 0;
            if (charAt2 != '0' || previous.ch == '0' || previous.ch == '?' || indexOf >= i) {
                z2 = previous.ch == '?' && indexOf < i;
                int i3 = previous.pos;
                if (z2) {
                    charAt2 = ' ';
                }
                stringBuffer2.setCharAt(i3, charAt2);
                special = previous;
            } else {
                z2 = false;
            }
            if (z3) {
                set.add(insertMod(previous, z2 ? StringUtils.SPACE : ",", 2));
            }
            i2++;
            indexOf--;
        }
        if (indexOf >= 0) {
            int i4 = indexOf + 1;
            StringBuffer stringBuffer3 = new StringBuffer(stringBuffer.substring(0, i4));
            if (z) {
                while (i4 > 0) {
                    if (i2 > 0 && i2 % 3 == 0) {
                        stringBuffer3.insert(i4, ',');
                    }
                    i2++;
                    i4--;
                }
            }
            set.add(insertMod(special, stringBuffer3, 1));
        }
    }

    private void writeFractional(StringBuffer stringBuffer, StringBuffer stringBuffer2) {
        int length;
        if (this.fractionalSpecials.size() > 0) {
            int indexOf = stringBuffer.indexOf(".") + 1;
            if (this.exponent != null) {
                length = stringBuffer.indexOf("e");
            } else {
                length = stringBuffer.length();
            }
            do {
                length--;
                if (length <= indexOf) {
                    break;
                }
            } while (stringBuffer.charAt(length) == '0');
            ListIterator<Special> listIterator = this.fractionalSpecials.listIterator();
            while (listIterator.hasNext()) {
                Special next = listIterator.next();
                char charAt = stringBuffer.charAt(indexOf);
                if (charAt != '0' || next.ch == '0' || indexOf < length) {
                    stringBuffer2.setCharAt(next.pos, charAt);
                } else if (next.ch == '?') {
                    stringBuffer2.setCharAt(next.pos, ' ');
                }
                indexOf++;
            }
        }
    }

    @Override // org.apache.poi.ss.format.CellFormatter
    public void simpleValue(StringBuffer stringBuffer, Object obj) {
        SIMPLE_NUMBER.formatValue(stringBuffer, obj);
    }
}
