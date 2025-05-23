package org.apache.commons.text;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes4.dex */
public class WordUtils {
    public static String wrap(String str, int i) {
        return wrap(str, i, null, false);
    }

    public static String wrap(String str, int i, String str2, boolean z) {
        return wrap(str, i, str2, z, StringUtils.SPACE);
    }

    public static String wrap(String str, int i, String str2, boolean z, String str3) {
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = System.lineSeparator();
        }
        if (i < 1) {
            i = 1;
        }
        if (StringUtils.isBlank(str3)) {
            str3 = StringUtils.SPACE;
        }
        Pattern compile = Pattern.compile(str3);
        int length = str.length();
        int i4 = 0;
        StringBuilder sb = new StringBuilder(length + 32);
        loop0: while (true) {
            i2 = -1;
            while (i4 < length) {
                Matcher matcher = compile.matcher(str.substring(i4, Math.min((int) Math.min(2147483647L, i4 + i + 1), length)));
                if (matcher.find()) {
                    if (matcher.start() == 0) {
                        i2 = matcher.end() - matcher.start();
                        if (i2 != 0) {
                            i4 += matcher.end();
                        } else {
                            i4++;
                        }
                    }
                    i3 = matcher.start() + i4;
                } else {
                    i3 = -1;
                }
                if (length - i4 <= i) {
                    break loop0;
                }
                while (matcher.find()) {
                    i3 = matcher.start() + i4;
                }
                if (i3 >= i4) {
                    sb.append((CharSequence) str, i4, i3);
                    sb.append(str2);
                } else if (z) {
                    if (i2 == 0) {
                        i4--;
                    }
                    int i5 = i + i4;
                    sb.append((CharSequence) str, i4, i5);
                    sb.append(str2);
                    i4 = i5;
                } else {
                    Matcher matcher2 = compile.matcher(str.substring(i4 + i));
                    if (matcher2.find()) {
                        i2 = matcher2.end() - matcher2.start();
                        i3 = matcher2.start() + i4 + i;
                    }
                    if (i3 >= 0) {
                        if (i2 == 0 && i4 != 0) {
                            i4--;
                        }
                        sb.append((CharSequence) str, i4, i3);
                        sb.append(str2);
                    } else {
                        if (i2 == 0 && i4 != 0) {
                            i4--;
                        }
                        sb.append((CharSequence) str, i4, str.length());
                        i4 = length;
                    }
                }
                i4 = i3 + 1;
            }
            break loop0;
        }
        if (i2 == 0 && i4 < length) {
            i4--;
        }
        sb.append((CharSequence) str, i4, str.length());
        return sb.toString();
    }

    public static String capitalize(String str) {
        return capitalize(str, null);
    }

    public static String capitalize(String str, char... cArr) {
        int codePointAt;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (generateDelimiterSet.contains(Integer.valueOf(codePointAt))) {
                    break;
                }
                if (z) {
                    int titleCase = Character.toTitleCase(codePointAt);
                    iArr[i2] = titleCase;
                    i += Character.charCount(titleCase);
                    z = false;
                    i2++;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String capitalizeFully(String str) {
        return capitalizeFully(str, null);
    }

    public static String capitalizeFully(String str, char... cArr) {
        return StringUtils.isEmpty(str) ? str : capitalize(str.toLowerCase(), cArr);
    }

    public static String uncapitalize(String str) {
        return uncapitalize(str, null);
    }

    public static String uncapitalize(String str, char... cArr) {
        int codePointAt;
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        int length = str.length();
        int[] iArr = new int[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            boolean z = true;
            while (i < length) {
                codePointAt = str.codePointAt(i);
                if (generateDelimiterSet.contains(Integer.valueOf(codePointAt))) {
                    break;
                }
                if (z) {
                    int lowerCase = Character.toLowerCase(codePointAt);
                    iArr[i2] = lowerCase;
                    i += Character.charCount(lowerCase);
                    z = false;
                    i2++;
                } else {
                    iArr[i2] = codePointAt;
                    i += Character.charCount(codePointAt);
                    i2++;
                }
            }
            return new String(iArr, 0, i2);
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
    }

    public static String swapCase(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int[] iArr = new int[length];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (Character.isUpperCase(codePointAt) || Character.isTitleCase(codePointAt)) {
                codePointAt = Character.toLowerCase(codePointAt);
            } else {
                if (!Character.isLowerCase(codePointAt)) {
                    z = Character.isWhitespace(codePointAt);
                } else if (z) {
                    codePointAt = Character.toTitleCase(codePointAt);
                } else {
                    codePointAt = Character.toUpperCase(codePointAt);
                }
                iArr[i2] = codePointAt;
                i += Character.charCount(codePointAt);
                i2++;
            }
            z = false;
            iArr[i2] = codePointAt;
            i += Character.charCount(codePointAt);
            i2++;
        }
        return new String(iArr, 0, i2);
    }

    public static String initials(String str) {
        return initials(str, null);
    }

    public static String initials(String str, char... cArr) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (cArr != null && cArr.length == 0) {
            return "";
        }
        Set<Integer> generateDelimiterSet = generateDelimiterSet(cArr);
        int length = str.length();
        int[] iArr = new int[(length / 2) + 1];
        boolean z = true;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (generateDelimiterSet.contains(Integer.valueOf(codePointAt)) || (cArr == null && Character.isWhitespace(codePointAt))) {
                z = true;
            } else if (z) {
                iArr[i2] = codePointAt;
                i2++;
                z = false;
            }
            i += Character.charCount(codePointAt);
        }
        return new String(iArr, 0, i2);
    }

    public static boolean containsAllWords(CharSequence charSequence, CharSequence... charSequenceArr) {
        if (StringUtils.isEmpty(charSequence) || ArrayUtils.isEmpty(charSequenceArr)) {
            return false;
        }
        for (CharSequence charSequence2 : charSequenceArr) {
            if (StringUtils.isBlank(charSequence2) || !Pattern.compile(".*\\b" + ((Object) charSequence2) + "\\b.*").matcher(charSequence).matches()) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public static boolean isDelimiter(char c, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(c);
        }
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    @Deprecated
    public static boolean isDelimiter(int i, char[] cArr) {
        if (cArr == null) {
            return Character.isWhitespace(i);
        }
        for (int i2 = 0; i2 < cArr.length; i2++) {
            if (Character.codePointAt(cArr, i2) == i) {
                return true;
            }
        }
        return false;
    }

    public static String abbreviate(String str, int i, int i2, String str2) {
        boolean z = true;
        Validate.isTrue(i2 >= -1, "upper value cannot be less than -1", new Object[0]);
        if (i2 < i && i2 != -1) {
            z = false;
        }
        Validate.isTrue(z, "upper value is less than lower value", new Object[0]);
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        if (i > str.length()) {
            i = str.length();
        }
        if (i2 == -1 || i2 > str.length()) {
            i2 = str.length();
        }
        StringBuilder sb = new StringBuilder();
        int indexOf = StringUtils.indexOf(str, StringUtils.SPACE, i);
        if (indexOf == -1) {
            sb.append((CharSequence) str, 0, i2);
            if (i2 != str.length()) {
                sb.append(StringUtils.defaultString(str2));
            }
        } else if (indexOf > i2) {
            sb.append((CharSequence) str, 0, i2);
            sb.append(StringUtils.defaultString(str2));
        } else {
            sb.append((CharSequence) str, 0, indexOf);
            sb.append(StringUtils.defaultString(str2));
        }
        return sb.toString();
    }

    private static Set<Integer> generateDelimiterSet(char[] cArr) {
        HashSet hashSet = new HashSet();
        if (cArr == null || cArr.length == 0) {
            if (cArr == null) {
                hashSet.add(Integer.valueOf(Character.codePointAt(new char[]{' '}, 0)));
            }
            return hashSet;
        }
        for (int i = 0; i < cArr.length; i++) {
            hashSet.add(Integer.valueOf(Character.codePointAt(cArr, i)));
        }
        return hashSet;
    }
}
