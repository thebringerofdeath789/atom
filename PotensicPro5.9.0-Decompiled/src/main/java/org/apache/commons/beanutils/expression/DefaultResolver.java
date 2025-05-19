package org.apache.commons.beanutils.expression;

/* loaded from: classes4.dex */
public class DefaultResolver implements Resolver {
    private static final char INDEXED_END = ']';
    private static final char INDEXED_START = '[';
    private static final char MAPPED_END = ')';
    private static final char MAPPED_START = '(';
    private static final char NESTED = '.';

    @Override // org.apache.commons.beanutils.expression.Resolver
    public int getIndex(String str) {
        char charAt;
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length() && (charAt = str.charAt(i)) != '.' && charAt != '('; i++) {
                if (charAt == '[') {
                    int indexOf = str.indexOf(93, i);
                    if (indexOf < 0) {
                        throw new IllegalArgumentException("Missing End Delimiter");
                    }
                    String substring = str.substring(i + 1, indexOf);
                    if (substring.length() == 0) {
                        throw new IllegalArgumentException("No Index Value");
                    }
                    try {
                        return Integer.parseInt(substring, 10);
                    } catch (Exception unused) {
                        throw new IllegalArgumentException("Invalid index value '" + substring + "'");
                    }
                }
            }
        }
        return -1;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public String getKey(String str) {
        char charAt;
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length() && (charAt = str.charAt(i)) != '.' && charAt != '['; i++) {
                if (charAt == '(') {
                    int indexOf = str.indexOf(41, i);
                    if (indexOf < 0) {
                        throw new IllegalArgumentException("Missing End Delimiter");
                    }
                    return str.substring(i + 1, indexOf);
                }
            }
        }
        return null;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public String getProperty(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.') {
                return str.substring(0, i);
            }
            if (charAt == '(' || charAt == '[') {
                return str.substring(0, i);
            }
        }
        return str;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public boolean hasNested(String str) {
        return (str == null || str.length() == 0 || remove(str) == null) ? false : true;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public boolean isIndexed(String str) {
        char charAt;
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length() && (charAt = str.charAt(i)) != '.' && charAt != '('; i++) {
                if (charAt == '[') {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public boolean isMapped(String str) {
        char charAt;
        if (str != null && str.length() != 0) {
            for (int i = 0; i < str.length() && (charAt = str.charAt(i)) != '.' && charAt != '['; i++) {
                if (charAt == '(') {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public String next(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (z) {
                if (charAt == ']') {
                    return str.substring(0, i + 1);
                }
            } else if (z2) {
                if (charAt == ')') {
                    return str.substring(0, i + 1);
                }
            } else {
                if (charAt == '.') {
                    return str.substring(0, i);
                }
                if (charAt == '(') {
                    z2 = true;
                } else if (charAt == '[') {
                    z = true;
                }
            }
        }
        return str;
    }

    @Override // org.apache.commons.beanutils.expression.Resolver
    public String remove(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String next = next(str);
        if (str.length() == next.length()) {
            return null;
        }
        int length = next.length();
        if (str.charAt(length) == '.') {
            length++;
        }
        return str.substring(length);
    }
}
