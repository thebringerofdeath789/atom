package org.apache.xmlbeans.impl.regex;

import com.opencsv.ICSVParser;
import java.text.CharacterIterator;
import okio.Utf8;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes5.dex */
public final class REUtil {
    static final int CACHESIZE = 20;
    static final RegularExpression[] regexCache = new RegularExpression[20];

    static final int composeFromSurrogates(int i, int i2) {
        return ((((i - 55296) << 10) + 65536) + i2) - Utf8.LOG_SURROGATE_HEADER;
    }

    static final int getOptionValue(int i) {
        if (i == 44) {
            return 1024;
        }
        if (i == 70) {
            return 256;
        }
        if (i == 72) {
            return 128;
        }
        if (i == 88) {
            return 512;
        }
        if (i == 105) {
            return 2;
        }
        if (i == 109) {
            return 8;
        }
        if (i == 115) {
            return 4;
        }
        if (i == 117) {
            return 32;
        }
        if (i != 119) {
            return i != 120 ? 0 : 16;
        }
        return 64;
    }

    static final boolean isHighSurrogate(int i) {
        return (i & 64512) == 55296;
    }

    static final boolean isLowSurrogate(int i) {
        return (i & 64512) == 56320;
    }

    private REUtil() {
    }

    static final String decomposeToSurrogates(int i) {
        int i2 = i - 65536;
        return new String(new char[]{(char) ((i2 >> 10) + 55296), (char) ((i2 & 1023) + Utf8.LOG_SURROGATE_HEADER)});
    }

    static final String substring(CharacterIterator characterIterator, int i, int i2) {
        int i3 = i2 - i;
        char[] cArr = new char[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            cArr[i4] = characterIterator.setIndex(i4 + i);
        }
        return new String(cArr);
    }

    static final int parseOptions(String str) throws ParseException {
        if (str == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int optionValue = getOptionValue(str.charAt(i2));
            if (optionValue == 0) {
                throw new ParseException(new StringBuffer().append("Unknown Option: ").append(str.substring(i2)).toString(), -1);
            }
            i |= optionValue;
        }
        return i;
    }

    static final String createOptionString(int i) {
        StringBuffer stringBuffer = new StringBuffer(9);
        if ((i & 256) != 0) {
            stringBuffer.append('F');
        }
        if ((i & 128) != 0) {
            stringBuffer.append('H');
        }
        if ((i & 512) != 0) {
            stringBuffer.append('X');
        }
        if ((i & 2) != 0) {
            stringBuffer.append('i');
        }
        if ((i & 8) != 0) {
            stringBuffer.append('m');
        }
        if ((i & 4) != 0) {
            stringBuffer.append('s');
        }
        if ((i & 32) != 0) {
            stringBuffer.append('u');
        }
        if ((i & 64) != 0) {
            stringBuffer.append('w');
        }
        if ((i & 16) != 0) {
            stringBuffer.append('x');
        }
        if ((i & 1024) != 0) {
            stringBuffer.append(',');
        }
        return stringBuffer.toString().intern();
    }

    static String stripExtendedComment(String str) {
        char charAt;
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char charAt2 = str.charAt(i);
            if (charAt2 != '\t' && charAt2 != '\n' && charAt2 != '\f' && charAt2 != '\r' && charAt2 != ' ') {
                if (charAt2 == '#') {
                    do {
                        i = i2;
                        if (i < length) {
                            i2 = i + 1;
                            charAt = str.charAt(i);
                            if (charAt == '\r') {
                                break;
                            }
                        }
                    } while (charAt != '\n');
                } else if (charAt2 == '\\' && i2 < length) {
                    char charAt3 = str.charAt(i2);
                    if (charAt3 == '#' || charAt3 == '\t' || charAt3 == '\n' || charAt3 == '\f' || charAt3 == '\r' || charAt3 == ' ') {
                        stringBuffer.append(charAt3);
                    } else {
                        stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                        stringBuffer.append(charAt3);
                    }
                    i2++;
                } else {
                    stringBuffer.append(charAt2);
                }
            }
            i = i2;
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0104, code lost:
    
        r2 = r10[r6];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void main(java.lang.String[] r10) {
        /*
            Method dump skipped, instructions count: 563
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xmlbeans.impl.regex.REUtil.main(java.lang.String[]):void");
    }

    public static RegularExpression createRegex(String str, String str2) throws ParseException {
        RegularExpression regularExpression;
        int parseOptions = parseOptions(str2);
        synchronized (regexCache) {
            int i = 0;
            while (true) {
                regularExpression = null;
                if (i >= 20) {
                    break;
                }
                try {
                    RegularExpression regularExpression2 = regexCache[i];
                    if (regularExpression2 == null) {
                        i = -1;
                        break;
                    }
                    if (regularExpression2.equals(str, parseOptions)) {
                        regularExpression = regularExpression2;
                        break;
                    }
                    i++;
                } finally {
                }
            }
            if (regularExpression == null) {
                regularExpression = new RegularExpression(str, str2);
                RegularExpression[] regularExpressionArr = regexCache;
                System.arraycopy(regularExpressionArr, 0, regularExpressionArr, 1, 19);
                regularExpressionArr[0] = regularExpression;
            } else if (i != 0) {
                RegularExpression[] regularExpressionArr2 = regexCache;
                System.arraycopy(regularExpressionArr2, 0, regularExpressionArr2, 1, i);
                regularExpressionArr2[0] = regularExpression;
            }
        }
        return regularExpression;
    }

    public static boolean matches(String str, String str2) throws ParseException {
        return createRegex(str, null).matches(str2);
    }

    public static boolean matches(String str, String str2, String str3) throws ParseException {
        return createRegex(str, str2).matches(str3);
    }

    public static String quoteMeta(String str) {
        int length = str.length();
        StringBuffer stringBuffer = null;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (".*+?{[()|\\^$".indexOf(charAt) >= 0) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(((length - i) * 2) + i);
                    if (i > 0) {
                        stringBuffer.append(str.substring(0, i));
                    }
                }
                stringBuffer.append(ICSVParser.DEFAULT_ESCAPE_CHARACTER);
                stringBuffer.append(charAt);
            } else if (stringBuffer != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer != null ? stringBuffer.toString() : str;
    }

    static void dumpString(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(Integer.toHexString(str.charAt(i)));
            System.out.print(StringUtils.SPACE);
        }
        System.out.println();
    }
}
