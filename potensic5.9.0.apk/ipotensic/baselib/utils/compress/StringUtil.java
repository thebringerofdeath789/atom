package com.ipotensic.baselib.utils.compress;

/* loaded from: classes2.dex */
public class StringUtil {
    public static String null2Length0(String str) {
        return str == null ? "" : str;
    }

    private StringUtil() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isSpace(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean equals(CharSequence charSequence, CharSequence charSequence2) {
        int length;
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || (length = charSequence.length()) != charSequence2.length()) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return charSequence.equals(charSequence2);
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != charSequence2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equalsIgnoreCase(String str, String str2) {
        return str == str2 || (str2 != null && str.length() == str2.length() && str.regionMatches(true, 0, str2, 0, str2.length()));
    }

    public static int length(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        return charSequence.length();
    }

    public static String upperFirstLetter(String str) {
        return (isEmpty(str) || !Character.isLowerCase(str.charAt(0))) ? str : String.valueOf((char) (str.charAt(0) - ' ')) + str.substring(1);
    }

    public static String lowerFirstLetter(String str) {
        return (isEmpty(str) || !Character.isUpperCase(str.charAt(0))) ? str : String.valueOf((char) (str.charAt(0) + ' ')) + str.substring(1);
    }

    public static String reverse(String str) {
        int length = length(str);
        if (length <= 1) {
            return str;
        }
        int i = length >> 1;
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < i; i2++) {
            char c = charArray[i2];
            int i3 = (length - i2) - 1;
            charArray[i2] = charArray[i3];
            charArray[i3] = c;
        }
        return new String(charArray);
    }

    public static String toDBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == '\u3000') {
                charArray[i] = ' ';
            } else if ('\uff01' <= charArray[i] && charArray[i] <= '\uff5e') {
                charArray[i] = (char) (charArray[i] - '\ufee0');
            } else {
                charArray[i] = charArray[i];
            }
        }
        return new String(charArray);
    }

    public static String toSBC(String str) {
        if (isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            if (charArray[i] == ' ') {
                charArray[i] = '\u3000';
            } else if ('!' <= charArray[i] && charArray[i] <= '~') {
                charArray[i] = (char) (charArray[i] + '\ufee0');
            } else {
                charArray[i] = charArray[i];
            }
        }
        return new String(charArray);
    }
}