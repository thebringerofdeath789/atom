package org.apache.commons.csv;

import com.mapbox.mapboxsdk.style.layers.Property;
import com.opencsv.ICSVParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public final class CSVFormat implements Serializable {
    public static final CSVFormat DEFAULT;
    public static final CSVFormat EXCEL;
    public static final CSVFormat INFORMIX_UNLOAD;
    public static final CSVFormat INFORMIX_UNLOAD_CSV;
    public static final CSVFormat MONGODB_CSV;
    public static final CSVFormat MONGODB_TSV;
    public static final CSVFormat MYSQL;
    public static final CSVFormat ORACLE;
    public static final CSVFormat POSTGRESQL_CSV;
    public static final CSVFormat POSTGRESQL_TEXT;
    public static final CSVFormat RFC4180;
    public static final CSVFormat TDF;
    private static final long serialVersionUID = 1;
    private final boolean allowDuplicateHeaderNames;
    private final boolean allowMissingColumnNames;
    private final boolean autoFlush;
    private final Character commentMarker;
    private final String delimiter;
    private final Character escapeCharacter;
    private final String[] header;
    private final String[] headerComments;
    private final boolean ignoreEmptyLines;
    private final boolean ignoreHeaderCase;
    private final boolean ignoreSurroundingSpaces;
    private final String nullString;
    private final Character quoteCharacter;
    private final QuoteMode quoteMode;
    private final String quotedNullString;
    private final String recordSeparator;
    private final boolean skipHeaderRecord;
    private final boolean trailingDelimiter;
    private final boolean trim;

    private static boolean isLineBreak(char c) {
        return c == '\n' || c == '\r';
    }

    /* synthetic */ CSVFormat(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static class Builder {
        private boolean allowDuplicateHeaderNames;
        private boolean allowMissingColumnNames;
        private boolean autoFlush;
        private Character commentMarker;
        private String delimiter;
        private Character escapeCharacter;
        private String[] headerComments;
        private String[] headers;
        private boolean ignoreEmptyLines;
        private boolean ignoreHeaderCase;
        private boolean ignoreSurroundingSpaces;
        private String nullString;
        private Character quoteCharacter;
        private QuoteMode quoteMode;
        private String quotedNullString;
        private String recordSeparator;
        private boolean skipHeaderRecord;
        private boolean trailingDelimiter;
        private boolean trim;

        public static Builder create() {
            return new Builder(CSVFormat.DEFAULT);
        }

        public static Builder create(CSVFormat cSVFormat) {
            return new Builder(cSVFormat);
        }

        private Builder(CSVFormat cSVFormat) {
            this.delimiter = cSVFormat.delimiter;
            this.quoteCharacter = cSVFormat.quoteCharacter;
            this.quoteMode = cSVFormat.quoteMode;
            this.commentMarker = cSVFormat.commentMarker;
            this.escapeCharacter = cSVFormat.escapeCharacter;
            this.ignoreSurroundingSpaces = cSVFormat.ignoreSurroundingSpaces;
            this.allowMissingColumnNames = cSVFormat.allowMissingColumnNames;
            this.ignoreEmptyLines = cSVFormat.ignoreEmptyLines;
            this.recordSeparator = cSVFormat.recordSeparator;
            this.nullString = cSVFormat.nullString;
            this.headerComments = cSVFormat.headerComments;
            this.headers = cSVFormat.header;
            this.skipHeaderRecord = cSVFormat.skipHeaderRecord;
            this.ignoreHeaderCase = cSVFormat.ignoreHeaderCase;
            this.trailingDelimiter = cSVFormat.trailingDelimiter;
            this.trim = cSVFormat.trim;
            this.autoFlush = cSVFormat.autoFlush;
            this.quotedNullString = cSVFormat.quotedNullString;
            this.allowDuplicateHeaderNames = cSVFormat.allowDuplicateHeaderNames;
        }

        public CSVFormat build() {
            return new CSVFormat(this, null);
        }

        public Builder setAllowDuplicateHeaderNames(boolean z) {
            this.allowDuplicateHeaderNames = z;
            return this;
        }

        public Builder setAllowMissingColumnNames(boolean z) {
            this.allowMissingColumnNames = z;
            return this;
        }

        public Builder setAutoFlush(boolean z) {
            this.autoFlush = z;
            return this;
        }

        public Builder setCommentMarker(char c) {
            setCommentMarker(Character.valueOf(c));
            return this;
        }

        public Builder setCommentMarker(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The comment start marker character cannot be a line break");
            }
            this.commentMarker = ch;
            return this;
        }

        public Builder setDelimiter(char c) {
            return setDelimiter(String.valueOf(c));
        }

        public Builder setDelimiter(String str) {
            if (CSVFormat.containsLineBreak(str)) {
                throw new IllegalArgumentException("The delimiter cannot be a line break");
            }
            this.delimiter = str;
            return this;
        }

        public Builder setEscape(char c) {
            setEscape(Character.valueOf(c));
            return this;
        }

        public Builder setEscape(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The escape character cannot be a line break");
            }
            this.escapeCharacter = ch;
            return this;
        }

        public Builder setHeader(Class<? extends Enum<?>> cls) {
            String[] strArr;
            if (cls != null) {
                Enum[] enumArr = (Enum[]) cls.getEnumConstants();
                strArr = new String[enumArr.length];
                for (int i = 0; i < enumArr.length; i++) {
                    strArr[i] = enumArr[i].name();
                }
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeader(ResultSet resultSet) throws SQLException {
            return setHeader(resultSet != null ? resultSet.getMetaData() : null);
        }

        public Builder setHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
            String[] strArr;
            if (resultSetMetaData != null) {
                int columnCount = resultSetMetaData.getColumnCount();
                strArr = new String[columnCount];
                int i = 0;
                while (i < columnCount) {
                    int i2 = i + 1;
                    strArr[i] = resultSetMetaData.getColumnLabel(i2);
                    i = i2;
                }
            } else {
                strArr = null;
            }
            return setHeader(strArr);
        }

        public Builder setHeader(String... strArr) {
            this.headers = (String[]) CSVFormat.clone(strArr);
            return this;
        }

        public Builder setHeaderComments(Object... objArr) {
            this.headerComments = (String[]) CSVFormat.clone(CSVFormat.toStringArray(objArr));
            return this;
        }

        public Builder setHeaderComments(String... strArr) {
            this.headerComments = (String[]) CSVFormat.clone(strArr);
            return this;
        }

        public Builder setIgnoreEmptyLines(boolean z) {
            this.ignoreEmptyLines = z;
            return this;
        }

        public Builder setIgnoreHeaderCase(boolean z) {
            this.ignoreHeaderCase = z;
            return this;
        }

        public Builder setIgnoreSurroundingSpaces(boolean z) {
            this.ignoreSurroundingSpaces = z;
            return this;
        }

        public Builder setNullString(String str) {
            this.nullString = str;
            this.quotedNullString = this.quoteCharacter + str + this.quoteCharacter;
            return this;
        }

        public Builder setQuote(char c) {
            setQuote(Character.valueOf(c));
            return this;
        }

        public Builder setQuote(Character ch) {
            if (CSVFormat.isLineBreak(ch)) {
                throw new IllegalArgumentException("The quoteChar cannot be a line break");
            }
            this.quoteCharacter = ch;
            return this;
        }

        public Builder setQuoteMode(QuoteMode quoteMode) {
            this.quoteMode = quoteMode;
            return this;
        }

        public Builder setRecordSeparator(char c) {
            this.recordSeparator = String.valueOf(c);
            return this;
        }

        public Builder setRecordSeparator(String str) {
            this.recordSeparator = str;
            return this;
        }

        public Builder setSkipHeaderRecord(boolean z) {
            this.skipHeaderRecord = z;
            return this;
        }

        public Builder setTrailingDelimiter(boolean z) {
            this.trailingDelimiter = z;
            return this;
        }

        public Builder setTrim(boolean z) {
            this.trim = z;
            return this;
        }
    }

    public enum Predefined {
        Default(CSVFormat.DEFAULT),
        Excel(CSVFormat.EXCEL),
        InformixUnload(CSVFormat.INFORMIX_UNLOAD),
        InformixUnloadCsv(CSVFormat.INFORMIX_UNLOAD_CSV),
        MongoDBCsv(CSVFormat.MONGODB_CSV),
        MongoDBTsv(CSVFormat.MONGODB_TSV),
        MySQL(CSVFormat.MYSQL),
        Oracle(CSVFormat.ORACLE),
        PostgreSQLCsv(CSVFormat.POSTGRESQL_CSV),
        PostgreSQLText(CSVFormat.POSTGRESQL_TEXT),
        RFC4180(CSVFormat.RFC4180),
        TDF(CSVFormat.TDF);

        private final CSVFormat format;

        Predefined(CSVFormat cSVFormat) {
            this.format = cSVFormat;
        }

        public CSVFormat getFormat() {
            return this.format;
        }
    }

    static {
        CSVFormat cSVFormat = new CSVFormat(",", Constants.DOUBLE_QUOTE_CHAR, null, null, null, false, true, "\r\n", null, null, null, false, false, false, false, false, false, true);
        DEFAULT = cSVFormat;
        EXCEL = cSVFormat.builder().setIgnoreEmptyLines(false).setAllowMissingColumnNames(true).build();
        INFORMIX_UNLOAD = cSVFormat.builder().setDelimiter('|').setEscape(ICSVParser.DEFAULT_ESCAPE_CHARACTER).setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').build();
        INFORMIX_UNLOAD_CSV = cSVFormat.builder().setDelimiter(",").setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').build();
        MONGODB_CSV = cSVFormat.builder().setDelimiter(",").setEscape(Constants.DOUBLE_QUOTE_CHAR).setQuote(Constants.DOUBLE_QUOTE_CHAR).setQuoteMode(QuoteMode.MINIMAL).setSkipHeaderRecord(false).build();
        MONGODB_TSV = cSVFormat.builder().setDelimiter('\t').setEscape(Constants.DOUBLE_QUOTE_CHAR).setQuote(Constants.DOUBLE_QUOTE_CHAR).setQuoteMode(QuoteMode.MINIMAL).setSkipHeaderRecord(false).build();
        MYSQL = cSVFormat.builder().setDelimiter('\t').setEscape(ICSVParser.DEFAULT_ESCAPE_CHARACTER).setIgnoreEmptyLines(false).setQuote((Character) null).setRecordSeparator('\n').setNullString("\\N").setQuoteMode(QuoteMode.ALL_NON_NULL).build();
        ORACLE = cSVFormat.builder().setDelimiter(",").setEscape(ICSVParser.DEFAULT_ESCAPE_CHARACTER).setIgnoreEmptyLines(false).setQuote(Constants.DOUBLE_QUOTE_CHAR).setNullString("\\N").setTrim(true).setRecordSeparator(System.lineSeparator()).setQuoteMode(QuoteMode.MINIMAL).build();
        POSTGRESQL_CSV = cSVFormat.builder().setDelimiter(",").setEscape(Constants.DOUBLE_QUOTE_CHAR).setIgnoreEmptyLines(false).setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').setNullString("").setQuoteMode(QuoteMode.ALL_NON_NULL).build();
        POSTGRESQL_TEXT = cSVFormat.builder().setDelimiter('\t').setEscape(ICSVParser.DEFAULT_ESCAPE_CHARACTER).setIgnoreEmptyLines(false).setQuote(Constants.DOUBLE_QUOTE_CHAR).setRecordSeparator('\n').setNullString("\\N").setQuoteMode(QuoteMode.ALL_NON_NULL).build();
        RFC4180 = cSVFormat.builder().setIgnoreEmptyLines(false).build();
        TDF = cSVFormat.builder().setDelimiter('\t').setIgnoreSurroundingSpaces(true).build();
    }

    @SafeVarargs
    static <T> T[] clone(T... tArr) {
        if (tArr == null) {
            return null;
        }
        return (T[]) ((Object[]) tArr.clone());
    }

    private static boolean contains(String str, char c) {
        return ((String) Objects.requireNonNull(str, Property.SYMBOL_Z_ORDER_SOURCE)).indexOf(c) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containsLineBreak(String str) {
        return contains(str, '\r') || contains(str, '\n');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isLineBreak(Character ch) {
        return ch != null && isLineBreak(ch.charValue());
    }

    public static CSVFormat newFormat(char c) {
        return new CSVFormat(String.valueOf(c), null, null, null, null, false, false, null, null, null, null, false, false, false, false, false, false, true);
    }

    static String[] toStringArray(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        String[] strArr = new String[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            strArr[i] = Objects.toString(objArr[i], null);
        }
        return strArr;
    }

    static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int length = charSequence.length();
        int i = 0;
        while (i < length && charSequence.charAt(i) <= ' ') {
            i++;
        }
        int i2 = length;
        while (i < i2 && charSequence.charAt(i2 - 1) <= ' ') {
            i2--;
        }
        return (i > 0 || i2 < length) ? charSequence.subSequence(i, i2) : charSequence;
    }

    public static CSVFormat valueOf(String str) {
        return Predefined.valueOf(str).getFormat();
    }

    private CSVFormat(Builder builder) {
        this.delimiter = builder.delimiter;
        this.quoteCharacter = builder.quoteCharacter;
        this.quoteMode = builder.quoteMode;
        this.commentMarker = builder.commentMarker;
        this.escapeCharacter = builder.escapeCharacter;
        this.ignoreSurroundingSpaces = builder.ignoreSurroundingSpaces;
        this.allowMissingColumnNames = builder.allowMissingColumnNames;
        this.ignoreEmptyLines = builder.ignoreEmptyLines;
        this.recordSeparator = builder.recordSeparator;
        this.nullString = builder.nullString;
        this.headerComments = builder.headerComments;
        this.header = builder.headers;
        this.skipHeaderRecord = builder.skipHeaderRecord;
        this.ignoreHeaderCase = builder.ignoreHeaderCase;
        this.trailingDelimiter = builder.trailingDelimiter;
        this.trim = builder.trim;
        this.autoFlush = builder.autoFlush;
        this.quotedNullString = builder.quotedNullString;
        this.allowDuplicateHeaderNames = builder.allowDuplicateHeaderNames;
        validate();
    }

    private CSVFormat(String str, Character ch, QuoteMode quoteMode, Character ch2, Character ch3, boolean z, boolean z2, String str2, String str3, Object[] objArr, String[] strArr, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.delimiter = str;
        this.quoteCharacter = ch;
        this.quoteMode = quoteMode;
        this.commentMarker = ch2;
        this.escapeCharacter = ch3;
        this.ignoreSurroundingSpaces = z;
        this.allowMissingColumnNames = z4;
        this.ignoreEmptyLines = z2;
        this.recordSeparator = str2;
        this.nullString = str3;
        this.headerComments = toStringArray(objArr);
        this.header = (String[]) clone(strArr);
        this.skipHeaderRecord = z3;
        this.ignoreHeaderCase = z5;
        this.trailingDelimiter = z7;
        this.trim = z6;
        this.autoFlush = z8;
        this.quotedNullString = ch + str3 + ch;
        this.allowDuplicateHeaderNames = z9;
        validate();
    }

    private void append(char c, Appendable appendable) throws IOException {
        appendable.append(c);
    }

    private void append(CharSequence charSequence, Appendable appendable) throws IOException {
        appendable.append(charSequence);
    }

    public Builder builder() {
        return Builder.create(this);
    }

    CSVFormat copy() {
        return builder().build();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CSVFormat cSVFormat = (CSVFormat) obj;
        return this.allowDuplicateHeaderNames == cSVFormat.allowDuplicateHeaderNames && this.allowMissingColumnNames == cSVFormat.allowMissingColumnNames && this.autoFlush == cSVFormat.autoFlush && Objects.equals(this.commentMarker, cSVFormat.commentMarker) && Objects.equals(this.delimiter, cSVFormat.delimiter) && Objects.equals(this.escapeCharacter, cSVFormat.escapeCharacter) && Arrays.equals(this.header, cSVFormat.header) && Arrays.equals(this.headerComments, cSVFormat.headerComments) && this.ignoreEmptyLines == cSVFormat.ignoreEmptyLines && this.ignoreHeaderCase == cSVFormat.ignoreHeaderCase && this.ignoreSurroundingSpaces == cSVFormat.ignoreSurroundingSpaces && Objects.equals(this.nullString, cSVFormat.nullString) && Objects.equals(this.quoteCharacter, cSVFormat.quoteCharacter) && this.quoteMode == cSVFormat.quoteMode && Objects.equals(this.quotedNullString, cSVFormat.quotedNullString) && Objects.equals(this.recordSeparator, cSVFormat.recordSeparator) && this.skipHeaderRecord == cSVFormat.skipHeaderRecord && this.trailingDelimiter == cSVFormat.trailingDelimiter && this.trim == cSVFormat.trim;
    }

    public String format(Object... objArr) {
        StringWriter stringWriter = new StringWriter();
        try {
            CSVPrinter cSVPrinter = new CSVPrinter(stringWriter, this);
            try {
                cSVPrinter.printRecord(objArr);
                String stringWriter2 = stringWriter.toString();
                String substring = stringWriter2.substring(0, this.recordSeparator != null ? stringWriter2.length() - this.recordSeparator.length() : stringWriter2.length());
                cSVPrinter.close();
                return substring;
            } finally {
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public boolean getAllowDuplicateHeaderNames() {
        return this.allowDuplicateHeaderNames;
    }

    public boolean getAllowMissingColumnNames() {
        return this.allowMissingColumnNames;
    }

    public boolean getAutoFlush() {
        return this.autoFlush;
    }

    public Character getCommentMarker() {
        return this.commentMarker;
    }

    @Deprecated
    public char getDelimiter() {
        return this.delimiter.charAt(0);
    }

    public String getDelimiterString() {
        return this.delimiter;
    }

    public Character getEscapeCharacter() {
        return this.escapeCharacter;
    }

    public String[] getHeader() {
        String[] strArr = this.header;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public String[] getHeaderComments() {
        String[] strArr = this.headerComments;
        if (strArr != null) {
            return (String[]) strArr.clone();
        }
        return null;
    }

    public boolean getIgnoreEmptyLines() {
        return this.ignoreEmptyLines;
    }

    public boolean getIgnoreHeaderCase() {
        return this.ignoreHeaderCase;
    }

    public boolean getIgnoreSurroundingSpaces() {
        return this.ignoreSurroundingSpaces;
    }

    public String getNullString() {
        return this.nullString;
    }

    public Character getQuoteCharacter() {
        return this.quoteCharacter;
    }

    public QuoteMode getQuoteMode() {
        return this.quoteMode;
    }

    public String getRecordSeparator() {
        return this.recordSeparator;
    }

    public boolean getSkipHeaderRecord() {
        return this.skipHeaderRecord;
    }

    public boolean getTrailingDelimiter() {
        return this.trailingDelimiter;
    }

    public boolean getTrim() {
        return this.trim;
    }

    public int hashCode() {
        return ((((Arrays.hashCode(this.header) + 31) * 31) + Arrays.hashCode(this.headerComments)) * 31) + Objects.hash(Boolean.valueOf(this.allowDuplicateHeaderNames), Boolean.valueOf(this.allowMissingColumnNames), Boolean.valueOf(this.autoFlush), this.commentMarker, this.delimiter, this.escapeCharacter, Boolean.valueOf(this.ignoreEmptyLines), Boolean.valueOf(this.ignoreHeaderCase), Boolean.valueOf(this.ignoreSurroundingSpaces), this.nullString, this.quoteCharacter, this.quoteMode, this.quotedNullString, this.recordSeparator, Boolean.valueOf(this.skipHeaderRecord), Boolean.valueOf(this.trailingDelimiter), Boolean.valueOf(this.trim));
    }

    public boolean isCommentMarkerSet() {
        return this.commentMarker != null;
    }

    private boolean isDelimiter(char c, CharSequence charSequence, int i, char[] cArr, int i2) {
        if (c != cArr[0] || i + i2 > charSequence.length()) {
            return false;
        }
        for (int i3 = 1; i3 < i2; i3++) {
            if (charSequence.charAt(i + i3) != cArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public boolean isEscapeCharacterSet() {
        return this.escapeCharacter != null;
    }

    public boolean isNullStringSet() {
        return this.nullString != null;
    }

    public boolean isQuoteCharacterSet() {
        return this.quoteCharacter != null;
    }

    public CSVParser parse(Reader reader) throws IOException {
        return new CSVParser(reader, this);
    }

    public CSVPrinter print(Appendable appendable) throws IOException {
        return new CSVPrinter(appendable, this);
    }

    public CSVPrinter print(File file, Charset charset) throws IOException {
        return new CSVPrinter(new OutputStreamWriter(new FileOutputStream(file), charset), this);
    }

    public void print(Object obj, Appendable appendable, boolean z) throws IOException {
        CharSequence obj2;
        if (obj == null) {
            if (this.nullString == null) {
                obj2 = "";
            } else if (QuoteMode.ALL == this.quoteMode) {
                obj2 = this.quotedNullString;
            } else {
                obj2 = this.nullString;
            }
        } else if (obj instanceof CharSequence) {
            obj2 = (CharSequence) obj;
        } else {
            if (obj instanceof Reader) {
                print((Reader) obj, appendable, z);
                return;
            }
            obj2 = obj.toString();
        }
        if (getTrim()) {
            obj2 = trim(obj2);
        }
        print(obj, obj2, appendable, z);
    }

    private void print(Object obj, CharSequence charSequence, Appendable appendable, boolean z) throws IOException {
        int length = charSequence.length();
        if (!z) {
            appendable.append(getDelimiterString());
        }
        if (obj == null) {
            appendable.append(charSequence);
            return;
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(obj, charSequence, appendable, z);
        } else if (isEscapeCharacterSet()) {
            printWithEscapes(charSequence, appendable);
        } else {
            appendable.append(charSequence, 0, length);
        }
    }

    public CSVPrinter print(Path path, Charset charset) throws IOException {
        return print(Files.newBufferedWriter(path, charset, new OpenOption[0]));
    }

    private void print(Reader reader, Appendable appendable, boolean z) throws IOException {
        if (!z) {
            append(getDelimiterString(), appendable);
        }
        if (isQuoteCharacterSet()) {
            printWithQuotes(reader, appendable);
            return;
        }
        if (isEscapeCharacterSet()) {
            printWithEscapes(reader, appendable);
        } else if (appendable instanceof Writer) {
            IOUtils.copyLarge(reader, (Writer) appendable);
        } else {
            IOUtils.copy(reader, appendable);
        }
    }

    public CSVPrinter printer() throws IOException {
        return new CSVPrinter(System.out, this);
    }

    public void println(Appendable appendable) throws IOException {
        if (getTrailingDelimiter()) {
            append(getDelimiterString(), appendable);
        }
        String str = this.recordSeparator;
        if (str != null) {
            append(str, appendable);
        }
    }

    public void printRecord(Appendable appendable, Object... objArr) throws IOException {
        int i = 0;
        while (i < objArr.length) {
            print(objArr[i], appendable, i == 0);
            i++;
        }
        println(appendable);
    }

    private void printWithEscapes(CharSequence charSequence, Appendable appendable) throws IOException {
        int length = charSequence.length();
        char[] charArray = getDelimiterString().toCharArray();
        int length2 = charArray.length;
        char charValue = getEscapeCharacter().charValue();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            boolean isDelimiter = isDelimiter(charAt, charSequence, i, charArray, length2);
            if (charAt == '\r' || charAt == '\n' || charAt == charValue || isDelimiter) {
                if (i > i2) {
                    appendable.append(charSequence, i2, i);
                }
                if (charAt == '\n') {
                    charAt = 'n';
                } else if (charAt == '\r') {
                    charAt = 'r';
                }
                appendable.append(charValue);
                appendable.append(charAt);
                if (isDelimiter) {
                    for (int i3 = 1; i3 < length2; i3++) {
                        i++;
                        char charAt2 = charSequence.charAt(i);
                        appendable.append(charValue);
                        appendable.append(charAt2);
                    }
                }
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            appendable.append(charSequence, i2, i);
        }
    }

    private void printWithEscapes(Reader reader, Appendable appendable) throws IOException {
        ExtendedBufferedReader extendedBufferedReader = new ExtendedBufferedReader(reader);
        char[] charArray = getDelimiterString().toCharArray();
        int length = charArray.length;
        char charValue = getEscapeCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        int i = 0;
        int i2 = 0;
        while (true) {
            int read = extendedBufferedReader.read();
            if (-1 == read) {
                break;
            }
            char c = (char) read;
            sb.append(c);
            boolean isDelimiter = isDelimiter(c, sb.toString() + new String(extendedBufferedReader.lookAhead(length - 1)), i, charArray, length);
            if (read == 13 || read == 10 || read == charValue || isDelimiter) {
                if (i > i2) {
                    append(sb.substring(i2, i), appendable);
                    sb.setLength(0);
                    i = -1;
                }
                int i3 = read == 10 ? 110 : read == 13 ? 114 : read;
                append(charValue, appendable);
                append((char) i3, appendable);
                if (isDelimiter) {
                    for (int i4 = 1; i4 < length; i4++) {
                        int read2 = extendedBufferedReader.read();
                        append(charValue, appendable);
                        append((char) read2, appendable);
                    }
                }
                i2 = i + 1;
            }
            i++;
        }
        if (i > i2) {
            append(sb.substring(i2, i), appendable);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x008d, code lost:
    
        if (r18.charAt(r15) <= ' ') goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void printWithQuotes(java.lang.Object r17, java.lang.CharSequence r18, java.lang.Appendable r19, boolean r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.csv.CSVFormat.printWithQuotes(java.lang.Object, java.lang.CharSequence, java.lang.Appendable, boolean):void");
    }

    /* renamed from: org.apache.commons.csv.CSVFormat$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$commons$csv$QuoteMode;

        static {
            int[] iArr = new int[QuoteMode.values().length];
            $SwitchMap$org$apache$commons$csv$QuoteMode = iArr;
            try {
                iArr[QuoteMode.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.ALL_NON_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NON_NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$commons$csv$QuoteMode[QuoteMode.MINIMAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private void printWithQuotes(Reader reader, Appendable appendable) throws IOException {
        if (getQuoteMode() == QuoteMode.NONE) {
            printWithEscapes(reader, appendable);
            return;
        }
        char charValue = getQuoteCharacter().charValue();
        StringBuilder sb = new StringBuilder(4096);
        append(charValue, appendable);
        int i = 0;
        while (true) {
            int read = reader.read();
            if (-1 == read) {
                break;
            }
            char c = (char) read;
            sb.append(c);
            if (read == charValue) {
                if (i > 0) {
                    append(sb.substring(0, i), appendable);
                    append(charValue, appendable);
                    sb.setLength(0);
                    i = -1;
                }
                append(c, appendable);
            }
            i++;
        }
        if (i > 0) {
            append(sb.substring(0, i), appendable);
        }
        append(charValue, appendable);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Delimiter=<").append(this.delimiter).append(Typography.greater);
        if (isEscapeCharacterSet()) {
            sb.append(' ');
            sb.append("Escape=<").append(this.escapeCharacter).append(Typography.greater);
        }
        if (isQuoteCharacterSet()) {
            sb.append(' ');
            sb.append("QuoteChar=<").append(this.quoteCharacter).append(Typography.greater);
        }
        if (this.quoteMode != null) {
            sb.append(' ');
            sb.append("QuoteMode=<").append(this.quoteMode).append(Typography.greater);
        }
        if (isCommentMarkerSet()) {
            sb.append(' ');
            sb.append("CommentStart=<").append(this.commentMarker).append(Typography.greater);
        }
        if (isNullStringSet()) {
            sb.append(' ');
            sb.append("NullString=<").append(this.nullString).append(Typography.greater);
        }
        if (this.recordSeparator != null) {
            sb.append(' ');
            sb.append("RecordSeparator=<").append(this.recordSeparator).append(Typography.greater);
        }
        if (getIgnoreEmptyLines()) {
            sb.append(" EmptyLines:ignored");
        }
        if (getIgnoreSurroundingSpaces()) {
            sb.append(" SurroundingSpaces:ignored");
        }
        if (getIgnoreHeaderCase()) {
            sb.append(" IgnoreHeaderCase:ignored");
        }
        sb.append(" SkipHeaderRecord:").append(this.skipHeaderRecord);
        if (this.headerComments != null) {
            sb.append(' ');
            sb.append("HeaderComments:").append(Arrays.toString(this.headerComments));
        }
        if (this.header != null) {
            sb.append(' ');
            sb.append("Header:").append(Arrays.toString(this.header));
        }
        return sb.toString();
    }

    private void validate() throws IllegalArgumentException {
        if (containsLineBreak(this.delimiter)) {
            throw new IllegalArgumentException("The delimiter cannot be a line break");
        }
        Character ch = this.quoteCharacter;
        if (ch != null && contains(this.delimiter, ch.charValue())) {
            throw new IllegalArgumentException("The quoteChar character and the delimiter cannot be the same ('" + this.quoteCharacter + "')");
        }
        Character ch2 = this.escapeCharacter;
        if (ch2 != null && contains(this.delimiter, ch2.charValue())) {
            throw new IllegalArgumentException("The escape character and the delimiter cannot be the same ('" + this.escapeCharacter + "')");
        }
        Character ch3 = this.commentMarker;
        if (ch3 != null && contains(this.delimiter, ch3.charValue())) {
            throw new IllegalArgumentException("The comment start character and the delimiter cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch4 = this.quoteCharacter;
        if (ch4 != null && ch4.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start character and the quoteChar cannot be the same ('" + this.commentMarker + "')");
        }
        Character ch5 = this.escapeCharacter;
        if (ch5 != null && ch5.equals(this.commentMarker)) {
            throw new IllegalArgumentException("The comment start and the escape character cannot be the same ('" + this.commentMarker + "')");
        }
        if (this.escapeCharacter == null && this.quoteMode == QuoteMode.NONE) {
            throw new IllegalArgumentException("No quotes mode set but no escape character is set");
        }
        if (this.header == null || this.allowDuplicateHeaderNames) {
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str : this.header) {
            if (!hashSet.add(str)) {
                throw new IllegalArgumentException("The header contains a duplicate entry: '" + str + "' in " + Arrays.toString(this.header));
            }
        }
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames() {
        return builder().setAllowDuplicateHeaderNames(true).build();
    }

    @Deprecated
    public CSVFormat withAllowDuplicateHeaderNames(boolean z) {
        return builder().setAllowDuplicateHeaderNames(z).build();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames() {
        return builder().setAllowMissingColumnNames(true).build();
    }

    @Deprecated
    public CSVFormat withAllowMissingColumnNames(boolean z) {
        return builder().setAllowMissingColumnNames(z).build();
    }

    @Deprecated
    public CSVFormat withAutoFlush(boolean z) {
        return builder().setAutoFlush(z).build();
    }

    @Deprecated
    public CSVFormat withCommentMarker(char c) {
        return builder().setCommentMarker(c).build();
    }

    @Deprecated
    public CSVFormat withCommentMarker(Character ch) {
        return builder().setCommentMarker(ch).build();
    }

    @Deprecated
    public CSVFormat withDelimiter(char c) {
        return builder().setDelimiter(c).build();
    }

    @Deprecated
    public CSVFormat withEscape(char c) {
        return builder().setEscape(c).build();
    }

    @Deprecated
    public CSVFormat withEscape(Character ch) {
        return builder().setEscape(ch).build();
    }

    @Deprecated
    public CSVFormat withFirstRecordAsHeader() {
        return builder().setHeader(new String[0]).setSkipHeaderRecord(true).build();
    }

    @Deprecated
    public CSVFormat withHeader(Class<? extends Enum<?>> cls) {
        return builder().setHeader(cls).build();
    }

    @Deprecated
    public CSVFormat withHeader(ResultSet resultSet) throws SQLException {
        return builder().setHeader(resultSet).build();
    }

    @Deprecated
    public CSVFormat withHeader(ResultSetMetaData resultSetMetaData) throws SQLException {
        return builder().setHeader(resultSetMetaData).build();
    }

    @Deprecated
    public CSVFormat withHeader(String... strArr) {
        return builder().setHeader(strArr).build();
    }

    @Deprecated
    public CSVFormat withHeaderComments(Object... objArr) {
        return builder().setHeaderComments(objArr).build();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines() {
        return builder().setIgnoreEmptyLines(true).build();
    }

    @Deprecated
    public CSVFormat withIgnoreEmptyLines(boolean z) {
        return builder().setIgnoreEmptyLines(z).build();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase() {
        return builder().setIgnoreHeaderCase(true).build();
    }

    @Deprecated
    public CSVFormat withIgnoreHeaderCase(boolean z) {
        return builder().setIgnoreHeaderCase(z).build();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces() {
        return builder().setIgnoreSurroundingSpaces(true).build();
    }

    @Deprecated
    public CSVFormat withIgnoreSurroundingSpaces(boolean z) {
        return builder().setIgnoreSurroundingSpaces(z).build();
    }

    @Deprecated
    public CSVFormat withNullString(String str) {
        return builder().setNullString(str).build();
    }

    @Deprecated
    public CSVFormat withQuote(char c) {
        return builder().setQuote(c).build();
    }

    @Deprecated
    public CSVFormat withQuote(Character ch) {
        return builder().setQuote(ch).build();
    }

    @Deprecated
    public CSVFormat withQuoteMode(QuoteMode quoteMode) {
        return builder().setQuoteMode(quoteMode).build();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(char c) {
        return builder().setRecordSeparator(c).build();
    }

    @Deprecated
    public CSVFormat withRecordSeparator(String str) {
        return builder().setRecordSeparator(str).build();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord() {
        return builder().setSkipHeaderRecord(true).build();
    }

    @Deprecated
    public CSVFormat withSkipHeaderRecord(boolean z) {
        return builder().setSkipHeaderRecord(z).build();
    }

    @Deprecated
    public CSVFormat withSystemRecordSeparator() {
        return builder().setRecordSeparator(System.lineSeparator()).build();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter() {
        return builder().setTrailingDelimiter(true).build();
    }

    @Deprecated
    public CSVFormat withTrailingDelimiter(boolean z) {
        return builder().setTrailingDelimiter(z).build();
    }

    @Deprecated
    public CSVFormat withTrim() {
        return builder().setTrim(true).build();
    }

    @Deprecated
    public CSVFormat withTrim(boolean z) {
        return builder().setTrim(z).build();
    }
}
