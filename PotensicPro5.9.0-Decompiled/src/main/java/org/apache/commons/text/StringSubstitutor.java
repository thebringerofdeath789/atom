package org.apache.commons.text;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang3.Validate;
import org.apache.commons.text.lookup.StringLookup;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;

/* loaded from: classes4.dex */
public class StringSubstitutor {
    public static final char DEFAULT_ESCAPE = '$';
    private boolean disableSubstitutionInValues;
    private boolean enableSubstitutionInVariables;
    private boolean enableUndefinedVariableException;
    private char escapeChar;
    private StringMatcher prefixMatcher;
    private boolean preserveEscapes;
    private StringMatcher suffixMatcher;
    private StringMatcher valueDelimiterMatcher;
    private StringLookup variableResolver;
    public static final String DEFAULT_VAR_START = "${";
    public static final StringMatcher DEFAULT_PREFIX = StringMatcherFactory.INSTANCE.stringMatcher(DEFAULT_VAR_START);
    public static final String DEFAULT_VAR_END = "}";
    public static final StringMatcher DEFAULT_SUFFIX = StringMatcherFactory.INSTANCE.stringMatcher(DEFAULT_VAR_END);
    public static final String DEFAULT_VAR_DEFAULT = ":-";
    public static final StringMatcher DEFAULT_VALUE_DELIMITER = StringMatcherFactory.INSTANCE.stringMatcher(DEFAULT_VAR_DEFAULT);

    private static final class Result {
        public final boolean altered;
        public final int lengthChange;

        private Result(boolean z, int i) {
            this.altered = z;
            this.lengthChange = i;
        }

        public String toString() {
            return "Result [altered=" + this.altered + ", lengthChange=" + this.lengthChange + "]";
        }
    }

    public static StringSubstitutor createInterpolator() {
        return new StringSubstitutor(StringLookupFactory.INSTANCE.interpolatorStringLookup());
    }

    public static <V> String replace(Object obj, Map<String, V> map) {
        return new StringSubstitutor(map).replace(obj);
    }

    public static <V> String replace(Object obj, Map<String, V> map, String str, String str2) {
        return new StringSubstitutor(map, str, str2).replace(obj);
    }

    public static String replace(Object obj, Properties properties) {
        if (properties == null) {
            return obj.toString();
        }
        HashMap hashMap = new HashMap();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            hashMap.put(str, properties.getProperty(str));
        }
        return replace(obj, hashMap);
    }

    public static String replaceSystemProperties(Object obj) {
        return new StringSubstitutor(StringLookupFactory.INSTANCE.systemPropertyStringLookup()).replace(obj);
    }

    public StringSubstitutor() {
        this((StringLookup) null, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public <V> StringSubstitutor(Map<String, V> map) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, '$');
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2, char c) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, c);
    }

    public <V> StringSubstitutor(Map<String, V> map, String str, String str2, char c, String str3) {
        this(StringLookupFactory.INSTANCE.mapStringLookup(map), str, str2, c, str3);
    }

    public StringSubstitutor(StringLookup stringLookup) {
        this(stringLookup, DEFAULT_PREFIX, DEFAULT_SUFFIX, '$');
    }

    public StringSubstitutor(StringLookup stringLookup, String str, String str2, char c) {
        setVariableResolver(stringLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiterMatcher(DEFAULT_VALUE_DELIMITER);
    }

    public StringSubstitutor(StringLookup stringLookup, String str, String str2, char c, String str3) {
        setVariableResolver(stringLookup);
        setVariablePrefix(str);
        setVariableSuffix(str2);
        setEscapeChar(c);
        setValueDelimiter(str3);
    }

    public StringSubstitutor(StringLookup stringLookup, StringMatcher stringMatcher, StringMatcher stringMatcher2, char c) {
        this(stringLookup, stringMatcher, stringMatcher2, c, DEFAULT_VALUE_DELIMITER);
    }

    public StringSubstitutor(StringLookup stringLookup, StringMatcher stringMatcher, StringMatcher stringMatcher2, char c, StringMatcher stringMatcher3) {
        setVariableResolver(stringLookup);
        setVariablePrefixMatcher(stringMatcher);
        setVariableSuffixMatcher(stringMatcher2);
        setEscapeChar(c);
        setValueDelimiterMatcher(stringMatcher3);
    }

    public StringSubstitutor(StringSubstitutor stringSubstitutor) {
        this.disableSubstitutionInValues = stringSubstitutor.isDisableSubstitutionInValues();
        this.enableSubstitutionInVariables = stringSubstitutor.isEnableSubstitutionInVariables();
        this.enableUndefinedVariableException = stringSubstitutor.isEnableUndefinedVariableException();
        this.escapeChar = stringSubstitutor.getEscapeChar();
        this.prefixMatcher = stringSubstitutor.getVariablePrefixMatcher();
        this.preserveEscapes = stringSubstitutor.isPreserveEscapes();
        this.suffixMatcher = stringSubstitutor.getVariableSuffixMatcher();
        this.valueDelimiterMatcher = stringSubstitutor.getValueDelimiterMatcher();
        this.variableResolver = stringSubstitutor.getStringLookup();
    }

    private void checkCyclicSubstitution(String str, List<String> list) {
        if (list.contains(str)) {
            TextStringBuilder textStringBuilder = new TextStringBuilder(256);
            textStringBuilder.append("Infinite loop in property interpolation of ");
            textStringBuilder.append(list.remove(0));
            textStringBuilder.append(": ");
            textStringBuilder.appendWithSeparators(list, "->");
            throw new IllegalStateException(textStringBuilder.toString());
        }
    }

    public char getEscapeChar() {
        return this.escapeChar;
    }

    public StringLookup getStringLookup() {
        return this.variableResolver;
    }

    public StringMatcher getValueDelimiterMatcher() {
        return this.valueDelimiterMatcher;
    }

    public StringMatcher getVariablePrefixMatcher() {
        return this.prefixMatcher;
    }

    public StringMatcher getVariableSuffixMatcher() {
        return this.suffixMatcher;
    }

    public boolean isDisableSubstitutionInValues() {
        return this.disableSubstitutionInValues;
    }

    public boolean isEnableSubstitutionInVariables() {
        return this.enableSubstitutionInVariables;
    }

    public boolean isEnableUndefinedVariableException() {
        return this.enableUndefinedVariableException;
    }

    public boolean isPreserveEscapes() {
        return this.preserveEscapes;
    }

    public String replace(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(cArr.length).append(cArr);
        substitute(append, 0, cArr.length);
        return append.toString();
    }

    public String replace(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(cArr, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        return replace(charSequence, 0, charSequence.length());
    }

    public String replace(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(charSequence.toString(), i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(Object obj) {
        if (obj == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder().append(obj);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(String str) {
        if (str == null) {
            return null;
        }
        TextStringBuilder textStringBuilder = new TextStringBuilder(str);
        return !substitute(textStringBuilder, 0, str.length()) ? str : textStringBuilder.toString();
    }

    public String replace(String str, int i, int i2) {
        if (str == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(str, i, i2);
        if (!substitute(append, 0, i2)) {
            return str.substring(i, i2 + i);
        }
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(stringBuffer.length()).append(stringBuffer);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public String replace(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(textStringBuilder.length()).append(textStringBuilder);
        substitute(append, 0, append.length());
        return append.toString();
    }

    public String replace(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return null;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(textStringBuilder, i, i2);
        substitute(append, 0, i2);
        return append.toString();
    }

    public boolean replaceIn(StringBuffer stringBuffer) {
        if (stringBuffer == null) {
            return false;
        }
        return replaceIn(stringBuffer, 0, stringBuffer.length());
    }

    public boolean replaceIn(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer == null) {
            return false;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(stringBuffer, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        stringBuffer.replace(i, i2 + i, append.toString());
        return true;
    }

    public boolean replaceIn(StringBuilder sb) {
        if (sb == null) {
            return false;
        }
        return replaceIn(sb, 0, sb.length());
    }

    public boolean replaceIn(StringBuilder sb, int i, int i2) {
        if (sb == null) {
            return false;
        }
        TextStringBuilder append = new TextStringBuilder(i2).append(sb, i, i2);
        if (!substitute(append, 0, i2)) {
            return false;
        }
        sb.replace(i, i2 + i, append.toString());
        return true;
    }

    public boolean replaceIn(TextStringBuilder textStringBuilder) {
        if (textStringBuilder == null) {
            return false;
        }
        return substitute(textStringBuilder, 0, textStringBuilder.length());
    }

    public boolean replaceIn(TextStringBuilder textStringBuilder, int i, int i2) {
        if (textStringBuilder == null) {
            return false;
        }
        return substitute(textStringBuilder, i, i2);
    }

    protected String resolveVariable(String str, TextStringBuilder textStringBuilder, int i, int i2) {
        StringLookup stringLookup = getStringLookup();
        if (stringLookup == null) {
            return null;
        }
        return stringLookup.lookup(str);
    }

    public StringSubstitutor setDisableSubstitutionInValues(boolean z) {
        this.disableSubstitutionInValues = z;
        return this;
    }

    public StringSubstitutor setEnableSubstitutionInVariables(boolean z) {
        this.enableSubstitutionInVariables = z;
        return this;
    }

    public StringSubstitutor setEnableUndefinedVariableException(boolean z) {
        this.enableUndefinedVariableException = z;
        return this;
    }

    public StringSubstitutor setEscapeChar(char c) {
        this.escapeChar = c;
        return this;
    }

    public StringSubstitutor setPreserveEscapes(boolean z) {
        this.preserveEscapes = z;
        return this;
    }

    public StringSubstitutor setValueDelimiter(char c) {
        return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setValueDelimiter(String str) {
        if (str == null || str.length() == 0) {
            setValueDelimiterMatcher(null);
            return this;
        }
        return setValueDelimiterMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public StringSubstitutor setValueDelimiterMatcher(StringMatcher stringMatcher) {
        this.valueDelimiterMatcher = stringMatcher;
        return this;
    }

    public StringSubstitutor setVariablePrefix(char c) {
        return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setVariablePrefix(String str) {
        Validate.isTrue(str != null, "Variable prefix must not be null!", new Object[0]);
        return setVariablePrefixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public StringSubstitutor setVariablePrefixMatcher(StringMatcher stringMatcher) {
        Validate.isTrue(stringMatcher != null, "Variable prefix matcher must not be null!", new Object[0]);
        this.prefixMatcher = stringMatcher;
        return this;
    }

    public StringSubstitutor setVariableResolver(StringLookup stringLookup) {
        this.variableResolver = stringLookup;
        return this;
    }

    public StringSubstitutor setVariableSuffix(char c) {
        return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.charMatcher(c));
    }

    public StringSubstitutor setVariableSuffix(String str) {
        Validate.isTrue(str != null, "Variable suffix must not be null!", new Object[0]);
        return setVariableSuffixMatcher(StringMatcherFactory.INSTANCE.stringMatcher(str));
    }

    public StringSubstitutor setVariableSuffixMatcher(StringMatcher stringMatcher) {
        Validate.isTrue(stringMatcher != null, "Variable suffix matcher must not be null!", new Object[0]);
        this.suffixMatcher = stringMatcher;
        return this;
    }

    protected boolean substitute(TextStringBuilder textStringBuilder, int i, int i2) {
        return substitute(textStringBuilder, i, i2, null).altered;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0174 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.apache.commons.text.StringSubstitutor.Result substitute(org.apache.commons.text.TextStringBuilder r26, int r27, int r28, java.util.List<java.lang.String> r29) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.StringSubstitutor.substitute(org.apache.commons.text.TextStringBuilder, int, int, java.util.List):org.apache.commons.text.StringSubstitutor$Result");
    }
}
