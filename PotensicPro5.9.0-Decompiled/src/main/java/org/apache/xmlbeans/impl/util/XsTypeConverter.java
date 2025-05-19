package org.apache.xmlbeans.impl.util;

import aavax.xml.namespace.NamespaceContext;
import aavax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.GDate;
import org.apache.xmlbeans.GDateBuilder;
import org.apache.xmlbeans.GDateSpecification;
import org.apache.xmlbeans.XmlCalendar;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.impl.common.InvalidLexicalValueException;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
public final class XsTypeConverter {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final char[] CH_ZEROS;
    private static final BigDecimal DECIMAL__ZERO;
    private static final String EMPTY_PREFIX = "";
    private static final char NAMESPACE_SEP = ':';
    private static final String NAN_LEX = "NaN";
    private static final String NEG_INF_LEX = "-INF";
    private static final String POS_INF_LEX = "INF";
    private static final String[] URI_CHARS_REPLACED_WITH;
    private static final String[] URI_CHARS_TO_BE_REPLACED;
    static /* synthetic */ Class class$org$apache$xmlbeans$impl$util$XsTypeConverter;

    public static CharSequence printAnyURI(CharSequence charSequence) {
        return charSequence;
    }

    public static String printBoolean(boolean z) {
        return z ? BooleanUtils.TRUE : "false";
    }

    public static String printString(String str) {
        return str;
    }

    static {
        if (class$org$apache$xmlbeans$impl$util$XsTypeConverter == null) {
            class$org$apache$xmlbeans$impl$util$XsTypeConverter = class$("org.apache.xmlbeans.impl.util.XsTypeConverter");
        }
        $assertionsDisabled = true;
        DECIMAL__ZERO = new BigDecimal(0.0d);
        URI_CHARS_TO_BE_REPLACED = new String[]{StringUtils.SPACE, "{", StringSubstitutor.DEFAULT_VAR_END, "|", "\\", "^", "[", "]", "`"};
        URI_CHARS_REPLACED_WITH = new String[]{"%20", "%7b", "%7d", "%7c", "%5c", "%5e", "%5b", "%5d", "%60"};
        CH_ZEROS = new char[]{'0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0', '0'};
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public static float lexFloat(CharSequence charSequence) throws NumberFormatException {
        char charAt;
        String obj = charSequence.toString();
        try {
            if (charSequence.length() > 0 && (((charAt = charSequence.charAt(charSequence.length() - 1)) == 'f' || charAt == 'F') && charSequence.charAt(charSequence.length() - 2) != 'N')) {
                throw new NumberFormatException(new StringBuffer().append("Invalid char '").append(charAt).append("' in float.").toString());
            }
            return Float.parseFloat(obj);
        } catch (NumberFormatException e) {
            if (obj.equals(POS_INF_LEX)) {
                return Float.POSITIVE_INFINITY;
            }
            if (obj.equals(NEG_INF_LEX)) {
                return Float.NEGATIVE_INFINITY;
            }
            if (obj.equals(NAN_LEX)) {
                return Float.NaN;
            }
            throw e;
        }
    }

    public static float lexFloat(CharSequence charSequence, Collection collection) {
        try {
            return lexFloat(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid float: ").append((Object) charSequence).toString()));
            return Float.NaN;
        }
    }

    public static String printFloat(float f) {
        return f == Float.POSITIVE_INFINITY ? POS_INF_LEX : f == Float.NEGATIVE_INFINITY ? NEG_INF_LEX : Float.isNaN(f) ? NAN_LEX : Float.toString(f);
    }

    public static double lexDouble(CharSequence charSequence) throws NumberFormatException {
        char charAt;
        String obj = charSequence.toString();
        try {
            if (charSequence.length() > 0 && ((charAt = charSequence.charAt(charSequence.length() - 1)) == 'd' || charAt == 'D')) {
                throw new NumberFormatException(new StringBuffer().append("Invalid char '").append(charAt).append("' in double.").toString());
            }
            return Double.parseDouble(obj);
        } catch (NumberFormatException e) {
            if (obj.equals(POS_INF_LEX)) {
                return Double.POSITIVE_INFINITY;
            }
            if (obj.equals(NEG_INF_LEX)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (obj.equals(NAN_LEX)) {
                return Double.NaN;
            }
            throw e;
        }
    }

    public static double lexDouble(CharSequence charSequence, Collection collection) {
        try {
            return lexDouble(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid double: ").append((Object) charSequence).toString()));
            return Double.NaN;
        }
    }

    public static String printDouble(double d) {
        return d == Double.POSITIVE_INFINITY ? POS_INF_LEX : d == Double.NEGATIVE_INFINITY ? NEG_INF_LEX : Double.isNaN(d) ? NAN_LEX : Double.toString(d);
    }

    public static BigDecimal lexDecimal(CharSequence charSequence) throws NumberFormatException {
        return new BigDecimal(trimTrailingZeros(charSequence.toString()));
    }

    public static BigDecimal lexDecimal(CharSequence charSequence, Collection collection) {
        try {
            return lexDecimal(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid long: ").append((Object) charSequence).toString()));
            return DECIMAL__ZERO;
        }
    }

    public static String printDecimal(BigDecimal bigDecimal) {
        char[] cArr;
        char[] cArr2;
        String bigInteger = bigDecimal.unscaledValue().toString();
        int scale = bigDecimal.scale();
        if (scale == 0 || (bigDecimal.longValue() == 0 && scale < 0)) {
            return bigInteger;
        }
        int i = bigDecimal.signum() < 0 ? 1 : 0;
        StringBuffer stringBuffer = new StringBuffer(bigInteger.length() + 1 + Math.abs(scale));
        if (i == 1) {
            stringBuffer.append(NameUtil.HYPHEN);
        }
        if (scale > 0) {
            int length = scale - (bigInteger.length() - i);
            if (length >= 0) {
                stringBuffer.append("0.");
                while (true) {
                    cArr2 = CH_ZEROS;
                    if (length <= cArr2.length) {
                        break;
                    }
                    stringBuffer.append(cArr2);
                    length -= cArr2.length;
                }
                stringBuffer.append(cArr2, 0, length);
                stringBuffer.append(bigInteger.substring(i));
            } else {
                int i2 = i - length;
                stringBuffer.append(bigInteger.substring(i, i2));
                stringBuffer.append('.');
                stringBuffer.append(bigInteger.substring(i2));
            }
        } else {
            stringBuffer.append(bigInteger.substring(i));
            while (true) {
                cArr = CH_ZEROS;
                if (scale >= (-cArr.length)) {
                    break;
                }
                stringBuffer.append(cArr);
                scale += cArr.length;
            }
            stringBuffer.append(cArr, 0, -scale);
        }
        return stringBuffer.toString();
    }

    public static BigInteger lexInteger(CharSequence charSequence) throws NumberFormatException {
        if (charSequence.length() > 1 && charSequence.charAt(0) == '+' && charSequence.charAt(1) == '-') {
            throw new NumberFormatException("Illegal char sequence '+-'");
        }
        return new BigInteger(trimInitialPlus(charSequence.toString()));
    }

    public static BigInteger lexInteger(CharSequence charSequence, Collection collection) {
        try {
            return lexInteger(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid long: ").append((Object) charSequence).toString()));
            return BigInteger.ZERO;
        }
    }

    public static String printInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static long lexLong(CharSequence charSequence) throws NumberFormatException {
        return Long.parseLong(trimInitialPlus(charSequence.toString()));
    }

    public static long lexLong(CharSequence charSequence, Collection collection) {
        try {
            return lexLong(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid long: ").append((Object) charSequence).toString()));
            return 0L;
        }
    }

    public static String printLong(long j) {
        return Long.toString(j);
    }

    public static short lexShort(CharSequence charSequence) throws NumberFormatException {
        return parseShort(charSequence);
    }

    public static short lexShort(CharSequence charSequence, Collection collection) {
        try {
            return lexShort(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid short: ").append((Object) charSequence).toString()));
            return (short) 0;
        }
    }

    public static String printShort(short s) {
        return Short.toString(s);
    }

    public static int lexInt(CharSequence charSequence) throws NumberFormatException {
        return parseInt(charSequence);
    }

    public static int lexInt(CharSequence charSequence, Collection collection) {
        try {
            return lexInt(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid int:").append((Object) charSequence).toString()));
            return 0;
        }
    }

    public static String printInt(int i) {
        return Integer.toString(i);
    }

    public static byte lexByte(CharSequence charSequence) throws NumberFormatException {
        return parseByte(charSequence);
    }

    public static byte lexByte(CharSequence charSequence, Collection collection) {
        try {
            return lexByte(charSequence);
        } catch (NumberFormatException unused) {
            collection.add(XmlError.forMessage(new StringBuffer().append("invalid byte: ").append((Object) charSequence).toString()));
            return (byte) 0;
        }
    }

    public static String printByte(byte b) {
        return Byte.toString(b);
    }

    public static boolean lexBoolean(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            if ('0' == charAt) {
                return false;
            }
            if ('1' == charAt) {
                return true;
            }
        } else if (length == 4) {
            if ('t' == charSequence.charAt(0) && 'r' == charSequence.charAt(1) && 'u' == charSequence.charAt(2) && 'e' == charSequence.charAt(3)) {
                return true;
            }
        } else if (length == 5 && 'f' == charSequence.charAt(0) && 'a' == charSequence.charAt(1) && 'l' == charSequence.charAt(2) && 's' == charSequence.charAt(3) && 'e' == charSequence.charAt(4)) {
            return false;
        }
        throw new InvalidLexicalValueException(new StringBuffer().append("invalid boolean: ").append((Object) charSequence).toString());
    }

    public static boolean lexBoolean(CharSequence charSequence, Collection collection) {
        try {
            return lexBoolean(charSequence);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return false;
        }
    }

    public static String lexString(CharSequence charSequence, Collection collection) {
        return charSequence.toString();
    }

    public static String lexString(CharSequence charSequence) {
        return charSequence.toString();
    }

    public static QName lexQName(CharSequence charSequence, NamespaceContext namespaceContext) {
        boolean z;
        String obj;
        String str;
        int i = 0;
        while (true) {
            if (i >= charSequence.length()) {
                z = false;
                break;
            }
            if (charSequence.charAt(i) == ':') {
                z = true;
                break;
            }
            i++;
        }
        String str2 = "";
        if (z) {
            str = charSequence.subSequence(0, i).toString();
            obj = charSequence.subSequence(i + 1, charSequence.length()).toString();
            if (i == 0) {
                throw new InvalidLexicalValueException(new StringBuffer().append("invalid xsd:QName '").append(charSequence.toString()).append("'").toString());
            }
        } else {
            obj = charSequence.toString();
            str = "";
        }
        String namespaceURI = namespaceContext.getNamespaceURI(str);
        if (namespaceURI != null) {
            str2 = namespaceURI;
        } else if (str != null && str.length() > 0) {
            throw new InvalidLexicalValueException(new StringBuffer().append("Can't resolve prefix: ").append(str).toString());
        }
        return new QName(str2, obj);
    }

    public static QName lexQName(String str, Collection collection, NamespaceContext namespaceContext) {
        try {
            return lexQName(str, namespaceContext);
        } catch (InvalidLexicalValueException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new QName(null, str.substring(str.indexOf(58)));
        }
    }

    public static String printQName(QName qName, NamespaceContext namespaceContext, Collection collection) {
        String str;
        String namespaceURI = qName.getNamespaceURI();
        if (!$assertionsDisabled && namespaceURI == null) {
            throw new AssertionError();
        }
        if (namespaceURI.length() > 0) {
            str = namespaceContext.getPrefix(namespaceURI);
            if (str == null) {
                collection.add(XmlError.forMessage(new StringBuffer().append("NamespaceContext does not provide prefix for namespaceURI ").append(namespaceURI).toString()));
            }
        } else {
            str = null;
        }
        return getQNameString(namespaceURI, qName.getLocalPart(), str);
    }

    public static String getQNameString(String str, String str2, String str3) {
        return (str3 == null || str == null || str.length() <= 0 || str3.length() <= 0) ? str2 : new StringBuffer().append(str3).append(':').append(str2).toString();
    }

    public static GDate lexGDate(CharSequence charSequence) {
        return new GDate(charSequence);
    }

    public static GDate lexGDate(String str, Collection collection) {
        try {
            return lexGDate(str);
        } catch (IllegalArgumentException e) {
            collection.add(XmlError.forMessage(e.getMessage()));
            return new GDateBuilder().toGDate();
        }
    }

    public static String printGDate(GDate gDate, Collection collection) {
        return gDate.toString();
    }

    public static XmlCalendar lexDateTime(CharSequence charSequence) {
        return getGDateValue(charSequence, 14).getCalendar();
    }

    public static String printDateTime(Calendar calendar) {
        return printDateTime(calendar, 14);
    }

    public static String printTime(Calendar calendar) {
        return printDateTime(calendar, 15);
    }

    public static String printDate(Calendar calendar) {
        return printDateTime(calendar, 16);
    }

    public static String printDate(Date date) {
        return getGDateValue(date, 16).toString();
    }

    public static String printDateTime(Calendar calendar, int i) {
        return getGDateValue(calendar, i).toString();
    }

    public static String printDateTime(Date date) {
        return getGDateValue(date, 14).toString();
    }

    public static CharSequence printHexBinary(byte[] bArr) {
        return HexBin.bytesToString(bArr);
    }

    public static byte[] lexHexBinary(CharSequence charSequence) {
        byte[] decode = HexBin.decode(charSequence.toString().getBytes());
        if (decode != null) {
            return decode;
        }
        throw new InvalidLexicalValueException("invalid hexBinary value");
    }

    public static CharSequence printBase64Binary(byte[] bArr) {
        return new String(Base64.encode(bArr));
    }

    public static byte[] lexBase64Binary(CharSequence charSequence) {
        byte[] decode = Base64.decode(charSequence.toString().getBytes());
        if (decode != null) {
            return decode;
        }
        throw new InvalidLexicalValueException("invalid base64Binary value");
    }

    public static GDateSpecification getGDateValue(Date date, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(date);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static GDateSpecification getGDateValue(Calendar calendar, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(calendar);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    public static GDateSpecification getGDateValue(CharSequence charSequence, int i) {
        GDateBuilder gDateBuilder = new GDateBuilder(charSequence);
        gDateBuilder.setBuiltinTypeCode(i);
        return gDateBuilder.toGDate();
    }

    private static String trimInitialPlus(String str) {
        return (str.length() <= 0 || str.charAt(0) != '+') ? str : str.substring(1);
    }

    private static String trimTrailingZeros(String str) {
        int lastIndexOf;
        int length = str.length() - 1;
        if (str.charAt(length) != '0' || (lastIndexOf = str.lastIndexOf(46)) < 0) {
            return str;
        }
        while (length > lastIndexOf) {
            if (str.charAt(length) != '0') {
                return str.substring(0, length + 1);
            }
            length--;
        }
        return str.substring(0, lastIndexOf);
    }

    private static int parseInt(CharSequence charSequence) {
        return parseIntXsdNumber(charSequence, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static short parseShort(CharSequence charSequence) {
        return (short) parseIntXsdNumber(charSequence, -32768, 32767);
    }

    private static byte parseByte(CharSequence charSequence) {
        return (byte) parseIntXsdNumber(charSequence, -128, 127);
    }

    private static int parseIntXsdNumber(CharSequence charSequence, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int length = charSequence.length();
        int i8 = 1;
        if (length < 1) {
            throw new NumberFormatException(new StringBuffer().append("For input string: \"").append(charSequence.toString()).append("\"").toString());
        }
        char charAt = charSequence.charAt(0);
        if (charAt == '-') {
            i6 = i / 10;
            i7 = -(i % 10);
            i5 = 1;
        } else {
            if (charAt == '+') {
                i3 = -(i2 / 10);
                i4 = i2 % 10;
                i5 = 1;
            } else {
                i3 = -(i2 / 10);
                i4 = i2 % 10;
                i5 = 0;
            }
            i8 = -1;
            int i9 = i4;
            i6 = i3;
            i7 = i9;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < length - i5; i11++) {
            int digit = Character.digit(charSequence.charAt(i11 + i5), 10);
            if (digit < 0) {
                throw new NumberFormatException(new StringBuffer().append("For input string: \"").append(charSequence.toString()).append("\"").toString());
            }
            if (i10 < i6 || (i10 == i6 && digit > i7)) {
                throw new NumberFormatException(new StringBuffer().append("For input string: \"").append(charSequence.toString()).append("\"").toString());
            }
            i10 = (i10 * 10) - digit;
        }
        return i8 * i10;
    }

    public static CharSequence lexAnyURI(CharSequence charSequence) {
        StringBuffer stringBuffer = new StringBuffer(charSequence.toString());
        for (int i = 0; i < URI_CHARS_TO_BE_REPLACED.length; i++) {
            int i2 = 0;
            while (true) {
                int indexOf = stringBuffer.indexOf(URI_CHARS_TO_BE_REPLACED[i], i2);
                if (indexOf >= 0) {
                    stringBuffer.replace(indexOf, indexOf + 1, URI_CHARS_REPLACED_WITH[i]);
                    i2 = indexOf + 3;
                }
            }
        }
        try {
            URI.create(stringBuffer.toString());
            return charSequence;
        } catch (IllegalArgumentException e) {
            throw new InvalidLexicalValueException(new StringBuffer().append("invalid anyURI value: ").append((Object) charSequence).toString(), e);
        }
    }
}
