package com.opencsv;

import com.opencsv.enums.CSVReaderNullFieldIndicator;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class CSVParser extends AbstractCSVParser {
    private static final int BEGINNING_OF_LINE = 3;
    private Locale errorLocale;
    private final char escape;
    private final boolean ignoreLeadingWhiteSpace;
    private final boolean ignoreQuotations;
    private boolean inField;
    private final boolean strictQuotes;
    private int tokensOnLastCompleteLine;

    private boolean isSameCharacter(char c, char c2) {
        return c != 0 && c == c2;
    }

    public CSVParser() {
        this(',', '\"', ICSVParser.DEFAULT_ESCAPE_CHARACTER, false, true, false, DEFAULT_NULL_FIELD_INDICATOR, Locale.getDefault());
    }

    CSVParser(char c, char c2, char c3, boolean z, boolean z2, boolean z3, CSVReaderNullFieldIndicator cSVReaderNullFieldIndicator, Locale locale) {
        super(c, c2, cSVReaderNullFieldIndicator);
        this.tokensOnLastCompleteLine = -1;
        this.inField = false;
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
        if (anyCharactersAreTheSame(c, c2, c3)) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("special.characters.must.differ"));
        }
        if (c == 0) {
            throw new UnsupportedOperationException(ResourceBundle.getBundle(ICSVParser.DEFAULT_BUNDLE_NAME, this.errorLocale).getString("define.separator"));
        }
        this.escape = c3;
        this.strictQuotes = z;
        this.ignoreLeadingWhiteSpace = z2;
        this.ignoreQuotations = z3;
    }

    public char getEscape() {
        return this.escape;
    }

    public boolean isStrictQuotes() {
        return this.strictQuotes;
    }

    public boolean isIgnoreLeadingWhiteSpace() {
        return this.ignoreLeadingWhiteSpace;
    }

    public boolean isIgnoreQuotations() {
        return this.ignoreQuotations;
    }

    private boolean anyCharactersAreTheSame(char c, char c2, char c3) {
        return isSameCharacter(c, c2) || isSameCharacter(c, c3) || isSameCharacter(c2, c3);
    }

    @Override // com.opencsv.AbstractCSVParser
    /* renamed from: convertToCsvValue */
    protected String lambda$parseToLine$0$AbstractCSVParser(String str, boolean z) {
        String str2 = (str != null || this.nullFieldIndicator.equals(CSVReaderNullFieldIndicator.NEITHER)) ? str : "";
        StringBuilder sb = new StringBuilder(str2 == null ? 16 : str2.length() * 2);
        boolean contains = StringUtils.contains(str2, getQuotechar());
        boolean contains2 = StringUtils.contains(str2, getEscape());
        boolean z2 = z || isSurroundWithQuotes(str, StringUtils.contains(str2, getSeparator()));
        if (contains) {
            str2 = str2.replaceAll(Character.toString(getQuotechar()), Character.toString(getQuotechar()) + getQuotechar());
        }
        if (contains2) {
            str2 = str2.replace(Character.toString(getEscape()), Character.toString(getEscape()) + getEscape());
        }
        if (z2) {
            sb.append(getQuotechar());
        }
        sb.append(str2);
        if (z2) {
            sb.append(getQuotechar());
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0042, code lost:
    
        r3.add(convertEmptyToNullIfNeeded(r4.takeOutput(), r5));
        r8.inField = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004c  */
    @Override // com.opencsv.AbstractCSVParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected java.lang.String[] parseLine(java.lang.String r9, boolean r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opencsv.CSVParser.parseLine(java.lang.String, boolean):java.lang.String[]");
    }

    private void handleQuoteCharButNotStrictQuotes(String str, StringFragmentCopier stringFragmentCopier) {
        int i;
        if (this.strictQuotes || (i = stringFragmentCopier.f2722i) <= 3 || str.charAt(i - 2) == this.separator || str.length() <= i || str.charAt(i) == this.separator) {
            return;
        }
        if (this.ignoreLeadingWhiteSpace && !stringFragmentCopier.isEmptyOutput() && StringUtils.isWhitespace(stringFragmentCopier.peekOutput())) {
            stringFragmentCopier.clearOutput();
        } else {
            stringFragmentCopier.appendPrev();
        }
    }

    private void handleEscapeCharacter(String str, StringFragmentCopier stringFragmentCopier, boolean z) {
        if (isNextCharacterEscapable(str, inQuotes(z), stringFragmentCopier.f2722i - 1)) {
            stringFragmentCopier.takeInput();
            stringFragmentCopier.appendPrev();
        }
    }

    private String convertEmptyToNullIfNeeded(String str, boolean z) {
        if (str.isEmpty() && shouldConvertEmptyToNull(z)) {
            return null;
        }
        return str;
    }

    /* renamed from: com.opencsv.CSVParser$1 */
    static /* synthetic */ class C32911 {
        static final /* synthetic */ int[] $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator;

        static {
            int[] iArr = new int[CSVReaderNullFieldIndicator.values().length];
            $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator = iArr;
            try {
                iArr[CSVReaderNullFieldIndicator.BOTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_SEPARATORS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[CSVReaderNullFieldIndicator.EMPTY_QUOTES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private boolean shouldConvertEmptyToNull(boolean z) {
        int i = C32911.$SwitchMap$com$opencsv$enums$CSVReaderNullFieldIndicator[this.nullFieldIndicator.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return !z;
        }
        if (i != 3) {
            return false;
        }
        return z;
    }

    private boolean inQuotes(boolean z) {
        return (z && !this.ignoreQuotations) || this.inField;
    }

    private boolean isNextCharacterEscapedQuote(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterQuoteCharacter(str.charAt(i2));
    }

    private boolean isCharacterQuoteCharacter(char c) {
        return c == this.quotechar;
    }

    private boolean isCharacterEscapeCharacter(char c) {
        return c == this.escape;
    }

    private boolean isCharacterSeparator(char c) {
        return c == this.separator;
    }

    private boolean isCharacterEscapable(char c) {
        return isCharacterQuoteCharacter(c) || isCharacterEscapeCharacter(c) || isCharacterSeparator(c);
    }

    protected boolean isNextCharacterEscapable(String str, boolean z, int i) {
        int i2;
        return z && str.length() > (i2 = i + 1) && isCharacterEscapable(str.charAt(i2));
    }

    @Override // com.opencsv.ICSVParser
    public void setErrorLocale(Locale locale) {
        this.errorLocale = (Locale) ObjectUtils.defaultIfNull(locale, Locale.getDefault());
    }

    private static class StringFragmentCopier {
        private final String input;

        /* renamed from: sb */
        private StringBuilder f2723sb;

        /* renamed from: i */
        private int f2722i = 0;
        private int pendingSubstrFrom = 0;
        private int pendingSubstrTo = 0;

        StringFragmentCopier(String str) {
            this.input = str;
        }

        public boolean isEmptyInput() {
            return this.f2722i >= this.input.length();
        }

        public char takeInput() {
            String str = this.input;
            int i = this.f2722i;
            this.f2722i = i + 1;
            return str.charAt(i);
        }

        private StringBuilder materializeBuilder() {
            if (this.f2723sb == null) {
                this.f2723sb = new StringBuilder(this.input.length() + 128);
            }
            int i = this.pendingSubstrFrom;
            int i2 = this.pendingSubstrTo;
            if (i < i2) {
                this.f2723sb.append((CharSequence) this.input, i, i2);
                int i3 = this.f2722i;
                this.pendingSubstrTo = i3;
                this.pendingSubstrFrom = i3;
            }
            return this.f2723sb;
        }

        public void append(String str) {
            materializeBuilder().append(str);
        }

        public void append(char c) {
            materializeBuilder().append(c);
        }

        public void appendPrev() {
            int i = this.pendingSubstrTo;
            if (i == this.pendingSubstrFrom) {
                int i2 = this.f2722i;
                this.pendingSubstrFrom = i2 - 1;
                this.pendingSubstrTo = i2;
            } else if (i == this.f2722i - 1) {
                this.pendingSubstrTo = i + 1;
            } else {
                materializeBuilder().append(this.input.charAt(this.f2722i - 1));
            }
        }

        public boolean isEmptyOutput() {
            StringBuilder sb;
            return this.pendingSubstrFrom >= this.pendingSubstrTo && ((sb = this.f2723sb) == null || sb.length() == 0);
        }

        public void clearOutput() {
            StringBuilder sb = this.f2723sb;
            if (sb != null) {
                sb.setLength(0);
            }
            int i = this.f2722i;
            this.pendingSubstrTo = i;
            this.pendingSubstrFrom = i;
        }

        public String peekOutput() {
            StringBuilder sb = this.f2723sb;
            if (sb == null || sb.length() == 0) {
                return this.input.substring(this.pendingSubstrFrom, this.pendingSubstrTo);
            }
            return materializeBuilder().toString();
        }

        public String takeOutput() {
            String peekOutput = peekOutput();
            clearOutput();
            return peekOutput;
        }
    }
}