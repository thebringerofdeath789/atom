package org.apache.commons.text.matcher;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.matcher.AbstractStringMatcher;

/* loaded from: classes4.dex */
public final class StringMatcherFactory {
    private static final AbstractStringMatcher.CharMatcher COMMA_MATCHER = new AbstractStringMatcher.CharMatcher(',');
    private static final AbstractStringMatcher.CharMatcher DOUBLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher('\"');
    public static final StringMatcherFactory INSTANCE = new StringMatcherFactory();
    private static final AbstractStringMatcher.NoneMatcher NONE_MATCHER = new AbstractStringMatcher.NoneMatcher();
    private static final AbstractStringMatcher.CharSetMatcher QUOTE_MATCHER = new AbstractStringMatcher.CharSetMatcher("'\"".toCharArray());
    private static final AbstractStringMatcher.CharMatcher SINGLE_QUOTE_MATCHER = new AbstractStringMatcher.CharMatcher('\'');
    private static final AbstractStringMatcher.CharMatcher SPACE_MATCHER = new AbstractStringMatcher.CharMatcher(' ');
    private static final AbstractStringMatcher.CharSetMatcher SPLIT_MATCHER = new AbstractStringMatcher.CharSetMatcher(" \t\n\r\f".toCharArray());
    private static final AbstractStringMatcher.CharMatcher TAB_MATCHER = new AbstractStringMatcher.CharMatcher('\t');
    private static final AbstractStringMatcher.TrimMatcher TRIM_MATCHER = new AbstractStringMatcher.TrimMatcher();

    private StringMatcherFactory() {
    }

    public StringMatcher andMatcher(StringMatcher... stringMatcherArr) {
        int length = ArrayUtils.getLength(stringMatcherArr);
        if (length == 0) {
            return NONE_MATCHER;
        }
        if (length == 1) {
            return stringMatcherArr[0];
        }
        return new AbstractStringMatcher.AndStringMatcher(stringMatcherArr);
    }

    public StringMatcher charMatcher(char c) {
        return new AbstractStringMatcher.CharMatcher(c);
    }

    public StringMatcher charSetMatcher(char... cArr) {
        int length = ArrayUtils.getLength(cArr);
        if (length == 0) {
            return NONE_MATCHER;
        }
        if (length == 1) {
            return new AbstractStringMatcher.CharMatcher(cArr[0]);
        }
        return new AbstractStringMatcher.CharSetMatcher(cArr);
    }

    public StringMatcher charSetMatcher(String str) {
        int length = StringUtils.length(str);
        if (length == 0) {
            return NONE_MATCHER;
        }
        if (length == 1) {
            return new AbstractStringMatcher.CharMatcher(str.charAt(0));
        }
        return new AbstractStringMatcher.CharSetMatcher(str.toCharArray());
    }

    public StringMatcher commaMatcher() {
        return COMMA_MATCHER;
    }

    public StringMatcher doubleQuoteMatcher() {
        return DOUBLE_QUOTE_MATCHER;
    }

    public StringMatcher noneMatcher() {
        return NONE_MATCHER;
    }

    public StringMatcher quoteMatcher() {
        return QUOTE_MATCHER;
    }

    public StringMatcher singleQuoteMatcher() {
        return SINGLE_QUOTE_MATCHER;
    }

    public StringMatcher spaceMatcher() {
        return SPACE_MATCHER;
    }

    public StringMatcher splitMatcher() {
        return SPLIT_MATCHER;
    }

    public StringMatcher stringMatcher(char... cArr) {
        int length = ArrayUtils.getLength(cArr);
        if (length == 0) {
            return NONE_MATCHER;
        }
        return length == 1 ? new AbstractStringMatcher.CharMatcher(cArr[0]) : new AbstractStringMatcher.CharArrayMatcher(cArr);
    }

    public StringMatcher stringMatcher(String str) {
        return StringUtils.isEmpty(str) ? NONE_MATCHER : stringMatcher(str.toCharArray());
    }

    public StringMatcher tabMatcher() {
        return TAB_MATCHER;
    }

    public StringMatcher trimMatcher() {
        return TRIM_MATCHER;
    }
}
