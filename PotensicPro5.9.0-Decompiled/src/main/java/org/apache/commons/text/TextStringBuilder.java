package org.apache.commons.text;

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.matcher.StringMatcher;

/* loaded from: classes4.dex */
public class TextStringBuilder implements CharSequence, Appendable, Serializable, Builder<String> {
    static final int CAPACITY = 32;
    private static final int EOS = -1;
    private static final char SPACE = ' ';
    private static final long serialVersionUID = 1;
    private char[] buffer;
    private String newLine;
    private String nullText;
    private int reallocations;
    private int size;
    private static final int FALSE_STRING_SIZE = Boolean.FALSE.toString().length();
    private static final int TRUE_STRING_SIZE = Boolean.TRUE.toString().length();

    class TextStringBuilderReader extends Reader {
        private int mark;
        private int pos;

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Reader
        public boolean markSupported() {
            return true;
        }

        TextStringBuilderReader() {
        }

        @Override // java.io.Reader
        public void mark(int i) {
            this.mark = this.pos;
        }

        @Override // java.io.Reader
        public int read() {
            if (!ready()) {
                return -1;
            }
            TextStringBuilder textStringBuilder = TextStringBuilder.this;
            int i = this.pos;
            this.pos = i + 1;
            return textStringBuilder.charAt(i);
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            int i3;
            if (i < 0 || i2 < 0 || i > cArr.length || (i3 = i + i2) > cArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            if (this.pos >= TextStringBuilder.this.size()) {
                return -1;
            }
            if (this.pos + i2 > TextStringBuilder.this.size()) {
                i2 = TextStringBuilder.this.size() - this.pos;
            }
            TextStringBuilder textStringBuilder = TextStringBuilder.this;
            int i4 = this.pos;
            textStringBuilder.getChars(i4, i4 + i2, cArr, i);
            this.pos += i2;
            return i2;
        }

        @Override // java.io.Reader
        public boolean ready() {
            return this.pos < TextStringBuilder.this.size();
        }

        @Override // java.io.Reader
        public void reset() {
            this.pos = this.mark;
        }

        @Override // java.io.Reader
        public long skip(long j) {
            if (this.pos + j > TextStringBuilder.this.size()) {
                j = TextStringBuilder.this.size() - this.pos;
            }
            if (j < 0) {
                return 0L;
            }
            this.pos = (int) (this.pos + j);
            return j;
        }
    }

    class TextStringBuilderTokenizer extends StringTokenizer {
        TextStringBuilderTokenizer() {
        }

        @Override // org.apache.commons.text.StringTokenizer
        public String getContent() {
            String content = super.getContent();
            return content == null ? TextStringBuilder.this.toString() : content;
        }

        @Override // org.apache.commons.text.StringTokenizer
        protected List<String> tokenize(char[] cArr, int i, int i2) {
            if (cArr == null) {
                return super.tokenize(TextStringBuilder.this.getBuffer(), 0, TextStringBuilder.this.size());
            }
            return super.tokenize(cArr, i, i2);
        }
    }

    class TextStringBuilderWriter extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        TextStringBuilderWriter() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            TextStringBuilder.this.append(cArr);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            TextStringBuilder.this.append(cArr, i, i2);
        }

        @Override // java.io.Writer
        public void write(int i) {
            TextStringBuilder.this.append((char) i);
        }

        @Override // java.io.Writer
        public void write(String str) {
            TextStringBuilder.this.append(str);
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            TextStringBuilder.this.append(str, i, i2);
        }
    }

    public static TextStringBuilder wrap(char[] cArr) {
        Objects.requireNonNull(cArr, "initialBuffer");
        return new TextStringBuilder(cArr, cArr.length);
    }

    public static TextStringBuilder wrap(char[] cArr, int i) {
        return new TextStringBuilder(cArr, i);
    }

    public TextStringBuilder() {
        this(32);
    }

    private TextStringBuilder(char[] cArr, int i) {
        this.buffer = (char[]) Objects.requireNonNull(cArr, "initialBuffer");
        if (i < 0 || i > cArr.length) {
            throw new IllegalArgumentException("initialBuffer.length=" + cArr.length + ", length=" + i);
        }
        this.size = i;
    }

    public TextStringBuilder(CharSequence charSequence) {
        this(StringUtils.length(charSequence) + 32);
        if (charSequence != null) {
            append(charSequence);
        }
    }

    public TextStringBuilder(int i) {
        this.buffer = new char[i <= 0 ? 32 : i];
    }

    public TextStringBuilder(String str) {
        this(StringUtils.length(str) + 32);
        if (str != null) {
            append(str);
        }
    }

    public TextStringBuilder append(boolean z) {
        if (z) {
            ensureCapacity(this.size + TRUE_STRING_SIZE);
            appendTrue(this.size);
        } else {
            ensureCapacity(this.size + FALSE_STRING_SIZE);
            appendFalse(this.size);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(char c) {
        ensureCapacity(length() + 1);
        char[] cArr = this.buffer;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
        return this;
    }

    public TextStringBuilder append(char[] cArr) {
        if (cArr == null) {
            return appendNull();
        }
        int length = cArr.length;
        if (length > 0) {
            int length2 = length();
            ensureCapacity(length2 + length);
            System.arraycopy(cArr, 0, this.buffer, length2, length);
            this.size += length;
        }
        return this;
    }

    public TextStringBuilder append(char[] cArr, int i, int i2) {
        if (cArr == null) {
            return appendNull();
        }
        if (i < 0 || i > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid startIndex: " + i2);
        }
        if (i2 < 0 || i + i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i2);
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            System.arraycopy(cArr, i, this.buffer, length, i2);
            this.size += i2;
        }
        return this;
    }

    public TextStringBuilder append(CharBuffer charBuffer) {
        return append(charBuffer, 0, StringUtils.length(charBuffer));
    }

    public TextStringBuilder append(CharBuffer charBuffer, int i, int i2) {
        if (charBuffer == null) {
            return appendNull();
        }
        if (charBuffer.hasArray()) {
            int remaining = charBuffer.remaining();
            if (i < 0 || i > remaining) {
                throw new StringIndexOutOfBoundsException("startIndex must be valid");
            }
            if (i2 < 0 || i + i2 > remaining) {
                throw new StringIndexOutOfBoundsException("length must be valid");
            }
            int length = length();
            ensureCapacity(length + i2);
            System.arraycopy(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, this.buffer, length, i2);
            this.size += i2;
        } else {
            append(charBuffer.toString(), i, i2);
        }
        return this;
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(CharSequence charSequence) {
        if (charSequence == null) {
            return appendNull();
        }
        if (charSequence instanceof TextStringBuilder) {
            return append((TextStringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuilder) {
            return append((StringBuilder) charSequence);
        }
        if (charSequence instanceof StringBuffer) {
            return append((StringBuffer) charSequence);
        }
        if (charSequence instanceof CharBuffer) {
            return append((CharBuffer) charSequence);
        }
        return append(charSequence.toString());
    }

    @Override // java.lang.Appendable
    public TextStringBuilder append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            return appendNull();
        }
        if (i2 <= 0) {
            throw new StringIndexOutOfBoundsException("endIndex must be valid");
        }
        if (i >= i2) {
            throw new StringIndexOutOfBoundsException("endIndex must be greater than startIndex");
        }
        return append(charSequence.toString(), i, i2 - i);
    }

    public TextStringBuilder append(double d) {
        return append(String.valueOf(d));
    }

    public TextStringBuilder append(float f) {
        return append(String.valueOf(f));
    }

    public TextStringBuilder append(int i) {
        return append(String.valueOf(i));
    }

    public TextStringBuilder append(long j) {
        return append(String.valueOf(j));
    }

    public TextStringBuilder append(Object obj) {
        if (obj == null) {
            return appendNull();
        }
        if (obj instanceof CharSequence) {
            return append((CharSequence) obj);
        }
        return append(obj.toString());
    }

    public TextStringBuilder append(String str) {
        return append(str, 0, StringUtils.length(str));
    }

    public TextStringBuilder append(String str, int i, int i2) {
        int i3;
        if (str == null) {
            return appendNull();
        }
        if (i < 0 || i > str.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > str.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            str.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public TextStringBuilder append(String str, Object... objArr) {
        return append(String.format(str, objArr));
    }

    public TextStringBuilder append(StringBuffer stringBuffer) {
        return append(stringBuffer, 0, StringUtils.length(stringBuffer));
    }

    public TextStringBuilder append(StringBuffer stringBuffer, int i, int i2) {
        int i3;
        if (stringBuffer == null) {
            return appendNull();
        }
        if (i < 0 || i > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > stringBuffer.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            stringBuffer.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public TextStringBuilder append(StringBuilder sb) {
        return append(sb, 0, StringUtils.length(sb));
    }

    public TextStringBuilder append(StringBuilder sb, int i, int i2) {
        int i3;
        if (sb == null) {
            return appendNull();
        }
        if (i < 0 || i > sb.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > sb.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            sb.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public TextStringBuilder append(TextStringBuilder textStringBuilder) {
        return append(textStringBuilder, 0, StringUtils.length(textStringBuilder));
    }

    public TextStringBuilder append(TextStringBuilder textStringBuilder, int i, int i2) {
        int i3;
        if (textStringBuilder == null) {
            return appendNull();
        }
        if (i < 0 || i > textStringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("startIndex must be valid");
        }
        if (i2 < 0 || (i3 = i + i2) > textStringBuilder.length()) {
            throw new StringIndexOutOfBoundsException("length must be valid");
        }
        if (i2 > 0) {
            int length = length();
            ensureCapacity(length + i2);
            textStringBuilder.getChars(i, i3, this.buffer, length);
            this.size += i2;
        }
        return this;
    }

    public TextStringBuilder appendAll(Iterable<?> iterable) {
        if (iterable != null) {
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public TextStringBuilder appendAll(Iterator<?> it) {
        if (it != null) {
            while (it.hasNext()) {
                append(it.next());
            }
        }
        return this;
    }

    public <T> TextStringBuilder appendAll(T... tArr) {
        if (tArr != null && tArr.length > 0) {
            for (T t : tArr) {
                append(t);
            }
        }
        return this;
    }

    private void appendFalse(int i) {
        char[] cArr = this.buffer;
        int i2 = i + 1;
        cArr[i] = 'f';
        int i3 = i2 + 1;
        cArr[i2] = 'a';
        int i4 = i3 + 1;
        cArr[i3] = 'l';
        cArr[i4] = 's';
        cArr[i4 + 1] = 'e';
        this.size += FALSE_STRING_SIZE;
    }

    public TextStringBuilder appendFixedWidthPadLeft(int i, int i2, char c) {
        return appendFixedWidthPadLeft(String.valueOf(i), i2, c);
    }

    public TextStringBuilder appendFixedWidthPadLeft(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i) {
                nullText.getChars(length - i, length, this.buffer, this.size);
            } else {
                int i2 = i - length;
                for (int i3 = 0; i3 < i2; i3++) {
                    this.buffer[this.size + i3] = c;
                }
                nullText.getChars(0, length, this.buffer, this.size + i2);
            }
            this.size += i;
        }
        return this;
    }

    public TextStringBuilder appendFixedWidthPadRight(int i, int i2, char c) {
        return appendFixedWidthPadRight(String.valueOf(i), i2, c);
    }

    public TextStringBuilder appendFixedWidthPadRight(Object obj, int i, char c) {
        if (i > 0) {
            ensureCapacity(this.size + i);
            String nullText = obj == null ? getNullText() : obj.toString();
            if (nullText == null) {
                nullText = "";
            }
            int length = nullText.length();
            if (length >= i) {
                nullText.getChars(0, i, this.buffer, this.size);
            } else {
                int i2 = i - length;
                nullText.getChars(0, length, this.buffer, this.size);
                for (int i3 = 0; i3 < i2; i3++) {
                    this.buffer[this.size + length + i3] = c;
                }
            }
            this.size += i;
        }
        return this;
    }

    public TextStringBuilder appendln(boolean z) {
        return append(z).appendNewLine();
    }

    public TextStringBuilder appendln(char c) {
        return append(c).appendNewLine();
    }

    public TextStringBuilder appendln(char[] cArr) {
        return append(cArr).appendNewLine();
    }

    public TextStringBuilder appendln(char[] cArr, int i, int i2) {
        return append(cArr, i, i2).appendNewLine();
    }

    public TextStringBuilder appendln(double d) {
        return append(d).appendNewLine();
    }

    public TextStringBuilder appendln(float f) {
        return append(f).appendNewLine();
    }

    public TextStringBuilder appendln(int i) {
        return append(i).appendNewLine();
    }

    public TextStringBuilder appendln(long j) {
        return append(j).appendNewLine();
    }

    public TextStringBuilder appendln(Object obj) {
        return append(obj).appendNewLine();
    }

    public TextStringBuilder appendln(String str) {
        return append(str).appendNewLine();
    }

    public TextStringBuilder appendln(String str, int i, int i2) {
        return append(str, i, i2).appendNewLine();
    }

    public TextStringBuilder appendln(String str, Object... objArr) {
        return append(str, objArr).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuffer stringBuffer) {
        return append(stringBuffer).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuffer stringBuffer, int i, int i2) {
        return append(stringBuffer, i, i2).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuilder sb) {
        return append(sb).appendNewLine();
    }

    public TextStringBuilder appendln(StringBuilder sb, int i, int i2) {
        return append(sb, i, i2).appendNewLine();
    }

    public TextStringBuilder appendln(TextStringBuilder textStringBuilder) {
        return append(textStringBuilder).appendNewLine();
    }

    public TextStringBuilder appendln(TextStringBuilder textStringBuilder, int i, int i2) {
        return append(textStringBuilder, i, i2).appendNewLine();
    }

    public TextStringBuilder appendNewLine() {
        String str = this.newLine;
        if (str == null) {
            append(System.lineSeparator());
            return this;
        }
        return append(str);
    }

    public TextStringBuilder appendNull() {
        String str = this.nullText;
        return str == null ? this : append(str);
    }

    public TextStringBuilder appendPadding(int i, char c) {
        if (i >= 0) {
            ensureCapacity(this.size + i);
            for (int i2 = 0; i2 < i; i2++) {
                char[] cArr = this.buffer;
                int i3 = this.size;
                this.size = i3 + 1;
                cArr[i3] = c;
            }
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c) {
        if (isNotEmpty()) {
            append(c);
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c, char c2) {
        if (isEmpty()) {
            append(c2);
        } else {
            append(c);
        }
        return this;
    }

    public TextStringBuilder appendSeparator(char c, int i) {
        if (i > 0) {
            append(c);
        }
        return this;
    }

    public TextStringBuilder appendSeparator(String str) {
        return appendSeparator(str, (String) null);
    }

    public TextStringBuilder appendSeparator(String str, int i) {
        if (str != null && i > 0) {
            append(str);
        }
        return this;
    }

    public TextStringBuilder appendSeparator(String str, String str2) {
        if (isEmpty()) {
            str = str2;
        }
        if (str != null) {
            append(str);
        }
        return this;
    }

    public void appendTo(Appendable appendable) throws IOException {
        if (appendable instanceof Writer) {
            ((Writer) appendable).write(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuilder) {
            ((StringBuilder) appendable).append(this.buffer, 0, this.size);
            return;
        }
        if (appendable instanceof StringBuffer) {
            ((StringBuffer) appendable).append(this.buffer, 0, this.size);
        } else if (appendable instanceof CharBuffer) {
            ((CharBuffer) appendable).put(this.buffer, 0, this.size);
        } else {
            appendable.append(this);
        }
    }

    private void appendTrue(int i) {
        char[] cArr = this.buffer;
        int i2 = i + 1;
        cArr[i] = 't';
        int i3 = i2 + 1;
        cArr[i2] = 'r';
        cArr[i3] = 'u';
        cArr[i3 + 1] = 'e';
        this.size += TRUE_STRING_SIZE;
    }

    public TextStringBuilder appendWithSeparators(Iterable<?> iterable, String str) {
        if (iterable != null) {
            String objects = Objects.toString(str, "");
            Iterator<?> it = iterable.iterator();
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(objects);
                }
            }
        }
        return this;
    }

    public TextStringBuilder appendWithSeparators(Iterator<?> it, String str) {
        if (it != null) {
            String objects = Objects.toString(str, "");
            while (it.hasNext()) {
                append(it.next());
                if (it.hasNext()) {
                    append(objects);
                }
            }
        }
        return this;
    }

    public TextStringBuilder appendWithSeparators(Object[] objArr, String str) {
        if (objArr != null && objArr.length > 0) {
            String objects = Objects.toString(str, "");
            append(objArr[0]);
            for (int i = 1; i < objArr.length; i++) {
                append(objects);
                append(objArr[i]);
            }
        }
        return this;
    }

    public Reader asReader() {
        return new TextStringBuilderReader();
    }

    public StringTokenizer asTokenizer() {
        return new TextStringBuilderTokenizer();
    }

    public Writer asWriter() {
        return new TextStringBuilderWriter();
    }

    @Override // org.apache.commons.text.Builder
    public String build() {
        return toString();
    }

    public int capacity() {
        return this.buffer.length;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        validateIndex(i);
        return this.buffer[i];
    }

    public TextStringBuilder clear() {
        this.size = 0;
        return this;
    }

    public boolean contains(char c) {
        char[] cArr = this.buffer;
        for (int i = 0; i < this.size; i++) {
            if (cArr[i] == c) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String str) {
        return indexOf(str, 0) >= 0;
    }

    public boolean contains(StringMatcher stringMatcher) {
        return indexOf(stringMatcher, 0) >= 0;
    }

    public TextStringBuilder delete(int i, int i2) {
        int validateRange = validateRange(i, i2);
        int i3 = validateRange - i;
        if (i3 > 0) {
            deleteImpl(i, validateRange, i3);
        }
        return this;
    }

    public TextStringBuilder deleteAll(char c) {
        int i = 0;
        while (i < this.size) {
            if (this.buffer[i] == c) {
                int i2 = i;
                do {
                    i2++;
                    if (i2 >= this.size) {
                        break;
                    }
                } while (this.buffer[i2] == c);
                int i3 = i2 - i;
                deleteImpl(i, i2, i3);
                i = i2 - i3;
            }
            i++;
        }
        return this;
    }

    public TextStringBuilder deleteAll(String str) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                deleteImpl(indexOf, indexOf + length, length);
                indexOf = indexOf(str, indexOf);
            }
        }
        return this;
    }

    public TextStringBuilder deleteAll(StringMatcher stringMatcher) {
        return replace(stringMatcher, null, 0, this.size, -1);
    }

    public TextStringBuilder deleteCharAt(int i) {
        validateIndex(i);
        deleteImpl(i, i + 1, 1);
        return this;
    }

    public TextStringBuilder deleteFirst(char c) {
        int i = 0;
        while (true) {
            if (i >= this.size) {
                break;
            }
            if (this.buffer[i] == c) {
                deleteImpl(i, i + 1, 1);
                break;
            }
            i++;
        }
        return this;
    }

    public TextStringBuilder deleteFirst(String str) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            deleteImpl(indexOf, indexOf + length, length);
        }
        return this;
    }

    public TextStringBuilder deleteFirst(StringMatcher stringMatcher) {
        return replace(stringMatcher, null, 0, this.size, 1);
    }

    private void deleteImpl(int i, int i2, int i3) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.size - i2);
        this.size -= i3;
    }

    public char drainChar(int i) {
        validateIndex(i);
        char c = this.buffer[i];
        deleteCharAt(i);
        return c;
    }

    public int drainChars(int i, int i2, char[] cArr, int i3) {
        int i4 = i2 - i;
        if (isEmpty() || i4 == 0 || cArr.length == 0) {
            return 0;
        }
        int min = Math.min(Math.min(this.size, i4), cArr.length - i3);
        getChars(i, min, cArr, i3);
        delete(i, min);
        return min;
    }

    public boolean endsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        int i = this.size;
        if (length > i) {
            return false;
        }
        int i2 = i - length;
        int i3 = 0;
        while (i3 < length) {
            if (this.buffer[i2] != str.charAt(i3)) {
                return false;
            }
            i3++;
            i2++;
        }
        return true;
    }

    public TextStringBuilder ensureCapacity(int i) {
        if (i > this.buffer.length) {
            reallocate(i * 2);
        }
        return this;
    }

    public boolean equals(Object obj) {
        return (obj instanceof TextStringBuilder) && equals((TextStringBuilder) obj);
    }

    public boolean equals(TextStringBuilder textStringBuilder) {
        return textStringBuilder != null && Arrays.equals(this.buffer, textStringBuilder.buffer);
    }

    public boolean equalsIgnoreCase(TextStringBuilder textStringBuilder) {
        if (this == textStringBuilder) {
            return true;
        }
        int i = this.size;
        if (i != textStringBuilder.size) {
            return false;
        }
        char[] cArr = this.buffer;
        char[] cArr2 = textStringBuilder.buffer;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            char c = cArr[i2];
            char c2 = cArr2[i2];
            if (c != c2 && Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                return false;
            }
        }
        return true;
    }

    char[] getBuffer() {
        return this.buffer;
    }

    public char[] getChars(char[] cArr) {
        int length = length();
        if (cArr == null || cArr.length < length) {
            cArr = new char[length];
        }
        System.arraycopy(this.buffer, 0, cArr, 0, length);
        return cArr;
    }

    public void getChars(int i, int i2, char[] cArr, int i3) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 < 0 || i2 > length()) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException("end < start");
        }
        System.arraycopy(this.buffer, i, cArr, i3, i2 - i);
    }

    public String getNewLineText() {
        return this.newLine;
    }

    public String getNullText() {
        return this.nullText;
    }

    public int hashCode() {
        return Arrays.hashCode(this.buffer);
    }

    public int indexOf(char c) {
        return indexOf(c, 0);
    }

    public int indexOf(char c, int i) {
        int max = Math.max(0, i);
        if (max >= this.size) {
            return -1;
        }
        char[] cArr = this.buffer;
        while (max < this.size) {
            if (cArr[max] == c) {
                return max;
            }
            max++;
        }
        return -1;
    }

    public int indexOf(String str) {
        return indexOf(str, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        r10 = r10 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int indexOf(java.lang.String r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            int r10 = java.lang.Math.max(r0, r10)
            r1 = -1
            if (r9 == 0) goto L3f
            int r2 = r8.size
            if (r10 < r2) goto Ld
            goto L3f
        Ld:
            int r2 = r9.length()
            r3 = 1
            if (r2 != r3) goto L1d
            char r9 = r9.charAt(r0)
            int r9 = r8.indexOf(r9, r10)
            return r9
        L1d:
            if (r2 != 0) goto L20
            return r10
        L20:
            int r4 = r8.size
            if (r2 <= r4) goto L25
            return r1
        L25:
            char[] r5 = r8.buffer
            int r4 = r4 - r2
            int r4 = r4 + r3
        L29:
            if (r10 >= r4) goto L3f
            r3 = r0
        L2c:
            if (r3 >= r2) goto L3e
            char r6 = r9.charAt(r3)
            int r7 = r10 + r3
            char r7 = r5[r7]
            if (r6 == r7) goto L3b
            int r10 = r10 + 1
            goto L29
        L3b:
            int r3 = r3 + 1
            goto L2c
        L3e:
            return r10
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.TextStringBuilder.indexOf(java.lang.String, int):int");
    }

    public int indexOf(StringMatcher stringMatcher) {
        return indexOf(stringMatcher, 0);
    }

    public int indexOf(StringMatcher stringMatcher, int i) {
        int i2;
        int max = Math.max(0, i);
        if (stringMatcher != null && max < (i2 = this.size)) {
            char[] cArr = this.buffer;
            for (int i3 = max; i3 < i2; i3++) {
                if (stringMatcher.isMatch(cArr, i3, max, i2) > 0) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public TextStringBuilder insert(int i, boolean z) {
        validateIndex(i);
        if (z) {
            int i2 = this.size;
            int i3 = TRUE_STRING_SIZE;
            ensureCapacity(i2 + i3);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i3 + i, this.size - i);
            appendTrue(i);
        } else {
            int i4 = this.size;
            int i5 = FALSE_STRING_SIZE;
            ensureCapacity(i4 + i5);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i5 + i, this.size - i);
            appendFalse(i);
        }
        return this;
    }

    public TextStringBuilder insert(int i, char c) {
        validateIndex(i);
        ensureCapacity(this.size + 1);
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i, cArr, i + 1, this.size - i);
        this.buffer[i] = c;
        this.size++;
        return this;
    }

    public TextStringBuilder insert(int i, char[] cArr) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        int length = cArr.length;
        if (length > 0) {
            ensureCapacity(this.size + length);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + length, this.size - i);
            System.arraycopy(cArr, 0, this.buffer, i, length);
            this.size += length;
        }
        return this;
    }

    public TextStringBuilder insert(int i, char[] cArr, int i2, int i3) {
        validateIndex(i);
        if (cArr == null) {
            return insert(i, this.nullText);
        }
        if (i2 < 0 || i2 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + i2);
        }
        if (i3 < 0 || i2 + i3 > cArr.length) {
            throw new StringIndexOutOfBoundsException("Invalid length: " + i3);
        }
        if (i3 > 0) {
            ensureCapacity(this.size + i3);
            char[] cArr2 = this.buffer;
            System.arraycopy(cArr2, i, cArr2, i + i3, this.size - i);
            System.arraycopy(cArr, i2, this.buffer, i, i3);
            this.size += i3;
        }
        return this;
    }

    public TextStringBuilder insert(int i, double d) {
        return insert(i, String.valueOf(d));
    }

    public TextStringBuilder insert(int i, float f) {
        return insert(i, String.valueOf(f));
    }

    public TextStringBuilder insert(int i, int i2) {
        return insert(i, String.valueOf(i2));
    }

    public TextStringBuilder insert(int i, long j) {
        return insert(i, String.valueOf(j));
    }

    public TextStringBuilder insert(int i, Object obj) {
        if (obj == null) {
            return insert(i, this.nullText);
        }
        return insert(i, obj.toString());
    }

    public TextStringBuilder insert(int i, String str) {
        int length;
        validateIndex(i);
        if (str == null) {
            str = this.nullText;
        }
        if (str != null && (length = str.length()) > 0) {
            int i2 = this.size + length;
            ensureCapacity(i2);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i, cArr, i + length, this.size - i);
            this.size = i2;
            str.getChars(0, length, this.buffer, i);
        }
        return this;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isNotEmpty() {
        return this.size != 0;
    }

    public boolean isReallocated() {
        return this.reallocations > 0;
    }

    public int lastIndexOf(char c) {
        return lastIndexOf(c, this.size - 1);
    }

    public int lastIndexOf(char c, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (i < 0) {
            return -1;
        }
        while (i >= 0) {
            if (this.buffer[i] == c) {
                return i;
            }
            i--;
        }
        return -1;
    }

    public int lastIndexOf(String str) {
        return lastIndexOf(str, this.size - 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        r9 = r9 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int lastIndexOf(java.lang.String r8, int r9) {
        /*
            r7 = this;
            int r0 = r7.size
            r1 = 1
            if (r9 < r0) goto L7
            int r9 = r0 + (-1)
        L7:
            r0 = -1
            if (r8 == 0) goto L40
            if (r9 >= 0) goto Ld
            goto L40
        Ld:
            int r2 = r8.length()
            if (r2 <= 0) goto L3d
            int r3 = r7.size
            if (r2 > r3) goto L3d
            r3 = 0
            if (r2 != r1) goto L23
            char r8 = r8.charAt(r3)
            int r8 = r7.lastIndexOf(r8, r9)
            return r8
        L23:
            int r9 = r9 - r2
            int r9 = r9 + r1
        L25:
            if (r9 < 0) goto L40
            r1 = r3
        L28:
            if (r1 >= r2) goto L3c
            char r4 = r8.charAt(r1)
            char[] r5 = r7.buffer
            int r6 = r9 + r1
            char r5 = r5[r6]
            if (r4 == r5) goto L39
            int r9 = r9 + (-1)
            goto L25
        L39:
            int r1 = r1 + 1
            goto L28
        L3c:
            return r9
        L3d:
            if (r2 != 0) goto L40
            return r9
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.TextStringBuilder.lastIndexOf(java.lang.String, int):int");
    }

    public int lastIndexOf(StringMatcher stringMatcher) {
        return lastIndexOf(stringMatcher, this.size);
    }

    public int lastIndexOf(StringMatcher stringMatcher, int i) {
        int i2 = this.size;
        if (i >= i2) {
            i = i2 - 1;
        }
        if (stringMatcher != null && i >= 0) {
            char[] cArr = this.buffer;
            int i3 = i + 1;
            while (i >= 0) {
                if (stringMatcher.isMatch(cArr, i, 0, i3) > 0) {
                    return i;
                }
                i--;
            }
        }
        return -1;
    }

    public String leftString(int i) {
        if (i <= 0) {
            return "";
        }
        if (i >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, 0, i);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.size;
    }

    public String midString(int i, int i2) {
        int i3;
        if (i < 0) {
            i = 0;
        }
        if (i2 <= 0 || i >= (i3 = this.size)) {
            return "";
        }
        if (i3 <= i + i2) {
            return new String(this.buffer, i, this.size - i);
        }
        return new String(this.buffer, i, i2);
    }

    public TextStringBuilder minimizeCapacity() {
        int length = this.buffer.length;
        int i = this.size;
        if (length > i) {
            reallocate(i);
        }
        return this;
    }

    public int readFrom(CharBuffer charBuffer) throws IOException {
        int i = this.size;
        int remaining = charBuffer.remaining();
        ensureCapacity(this.size + remaining);
        charBuffer.get(this.buffer, this.size, remaining);
        int i2 = this.size + remaining;
        this.size = i2;
        return i2 - i;
    }

    public int readFrom(Readable readable) throws IOException {
        if (readable instanceof Reader) {
            return readFrom((Reader) readable);
        }
        if (readable instanceof CharBuffer) {
            return readFrom((CharBuffer) readable);
        }
        int i = this.size;
        while (true) {
            ensureCapacity(this.size + 1);
            char[] cArr = this.buffer;
            int i2 = this.size;
            int read = readable.read(CharBuffer.wrap(cArr, i2, cArr.length - i2));
            if (read != -1) {
                this.size += read;
            } else {
                return this.size - i;
            }
        }
    }

    public int readFrom(Reader reader) throws IOException {
        int i = this.size;
        ensureCapacity(i + 1);
        char[] cArr = this.buffer;
        int i2 = this.size;
        int read = reader.read(cArr, i2, cArr.length - i2);
        if (read == -1) {
            return -1;
        }
        do {
            int i3 = this.size + read;
            this.size = i3;
            ensureCapacity(i3 + 1);
            char[] cArr2 = this.buffer;
            int i4 = this.size;
            read = reader.read(cArr2, i4, cArr2.length - i4);
        } while (read != -1);
        return this.size - i;
    }

    public int readFrom(Reader reader, int i) throws IOException {
        if (i <= 0) {
            return 0;
        }
        int i2 = this.size;
        ensureCapacity(i2 + i);
        int read = reader.read(this.buffer, this.size, i);
        if (read == -1) {
            return -1;
        }
        do {
            i -= read;
            int i3 = this.size + read;
            this.size = i3;
            read = reader.read(this.buffer, i3, i);
            if (i <= 0) {
                break;
            }
        } while (read != -1);
        return this.size - i2;
    }

    private void reallocate(int i) {
        this.buffer = Arrays.copyOf(this.buffer, i);
        this.reallocations++;
    }

    public TextStringBuilder replace(int i, int i2, String str) {
        int validateRange = validateRange(i, i2);
        replaceImpl(i, validateRange, validateRange - i, str, str == null ? 0 : str.length());
        return this;
    }

    public TextStringBuilder replace(StringMatcher stringMatcher, String str, int i, int i2, int i3) {
        return replaceImpl(stringMatcher, str, i, validateRange(i, i2), i3);
    }

    public TextStringBuilder replaceAll(char c, char c2) {
        if (c != c2) {
            for (int i = 0; i < this.size; i++) {
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                }
            }
        }
        return this;
    }

    public TextStringBuilder replaceAll(String str, String str2) {
        int length = str == null ? 0 : str.length();
        if (length > 0) {
            int length2 = str2 == null ? 0 : str2.length();
            int indexOf = indexOf(str, 0);
            while (indexOf >= 0) {
                replaceImpl(indexOf, indexOf + length, length, str2, length2);
                indexOf = indexOf(str, indexOf + length2);
            }
        }
        return this;
    }

    public TextStringBuilder replaceAll(StringMatcher stringMatcher, String str) {
        return replace(stringMatcher, str, 0, this.size, -1);
    }

    public TextStringBuilder replaceFirst(char c, char c2) {
        if (c != c2) {
            int i = 0;
            while (true) {
                if (i >= this.size) {
                    break;
                }
                char[] cArr = this.buffer;
                if (cArr[i] == c) {
                    cArr[i] = c2;
                    break;
                }
                i++;
            }
        }
        return this;
    }

    public TextStringBuilder replaceFirst(String str, String str2) {
        int indexOf;
        int length = str == null ? 0 : str.length();
        if (length > 0 && (indexOf = indexOf(str, 0)) >= 0) {
            replaceImpl(indexOf, indexOf + length, length, str2, str2 != null ? str2.length() : 0);
        }
        return this;
    }

    public TextStringBuilder replaceFirst(StringMatcher stringMatcher, String str) {
        return replace(stringMatcher, str, 0, this.size, 1);
    }

    private void replaceImpl(int i, int i2, int i3, String str, int i4) {
        int i5 = (this.size - i3) + i4;
        if (i4 != i3) {
            ensureCapacity(i5);
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i2, cArr, i + i4, this.size - i2);
            this.size = i5;
        }
        if (i4 > 0) {
            str.getChars(0, i4, this.buffer, i);
        }
    }

    private TextStringBuilder replaceImpl(StringMatcher stringMatcher, String str, int i, int i2, int i3) {
        if (stringMatcher != null && this.size != 0) {
            int length = str == null ? 0 : str.length();
            int i4 = i;
            while (i4 < i2 && i3 != 0) {
                int isMatch = stringMatcher.isMatch(this.buffer, i4, i, i2);
                if (isMatch > 0) {
                    replaceImpl(i4, i4 + isMatch, isMatch, str, length);
                    i2 = (i2 - isMatch) + length;
                    i4 = (i4 + length) - 1;
                    if (i3 > 0) {
                        i3--;
                    }
                }
                i4++;
            }
        }
        return this;
    }

    public TextStringBuilder reverse() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        int i2 = i / 2;
        char[] cArr = this.buffer;
        int i3 = 0;
        int i4 = i - 1;
        while (i3 < i2) {
            char c = cArr[i3];
            cArr[i3] = cArr[i4];
            cArr[i4] = c;
            i3++;
            i4--;
        }
        return this;
    }

    public String rightString(int i) {
        if (i <= 0) {
            return "";
        }
        if (i >= this.size) {
            return new String(this.buffer, 0, this.size);
        }
        return new String(this.buffer, this.size - i, i);
    }

    public TextStringBuilder set(CharSequence charSequence) {
        clear();
        append(charSequence);
        return this;
    }

    public TextStringBuilder setCharAt(int i, char c) {
        validateIndex(i);
        this.buffer[i] = c;
        return this;
    }

    public TextStringBuilder setLength(int i) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i2 = this.size;
        if (i < i2) {
            this.size = i;
        } else if (i > i2) {
            ensureCapacity(i);
            int i3 = this.size;
            this.size = i;
            Arrays.fill(this.buffer, i3, i, (char) 0);
        }
        return this;
    }

    public TextStringBuilder setNewLineText(String str) {
        this.newLine = str;
        return this;
    }

    public TextStringBuilder setNullText(String str) {
        if (str != null && str.isEmpty()) {
            str = null;
        }
        this.nullText = str;
        return this;
    }

    public int size() {
        return this.size;
    }

    public boolean startsWith(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return true;
        }
        if (length > this.size) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (this.buffer[i] != str.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (i2 > this.size) {
            throw new StringIndexOutOfBoundsException(i2);
        }
        if (i > i2) {
            throw new StringIndexOutOfBoundsException(i2 - i);
        }
        return substring(i, i2);
    }

    public String substring(int i) {
        return substring(i, this.size);
    }

    public String substring(int i, int i2) {
        return new String(this.buffer, i, validateRange(i, i2) - i);
    }

    public char[] toCharArray() {
        int i = this.size;
        return i == 0 ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOf(this.buffer, i);
    }

    public char[] toCharArray(int i, int i2) {
        int validateRange = validateRange(i, i2);
        return validateRange - i == 0 ? ArrayUtils.EMPTY_CHAR_ARRAY : Arrays.copyOfRange(this.buffer, i, validateRange);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.buffer, 0, this.size);
    }

    public StringBuffer toStringBuffer() {
        return new StringBuffer(this.size).append(this.buffer, 0, this.size);
    }

    public StringBuilder toStringBuilder() {
        return new StringBuilder(this.size).append(this.buffer, 0, this.size);
    }

    public TextStringBuilder trim() {
        int i = this.size;
        if (i == 0) {
            return this;
        }
        char[] cArr = this.buffer;
        int i2 = 0;
        while (i2 < i && cArr[i2] <= ' ') {
            i2++;
        }
        while (i2 < i && cArr[i - 1] <= ' ') {
            i--;
        }
        int i3 = this.size;
        if (i < i3) {
            delete(i, i3);
        }
        if (i2 > 0) {
            delete(0, i2);
        }
        return this;
    }

    protected void validateIndex(int i) {
        if (i < 0 || i >= this.size) {
            throw new StringIndexOutOfBoundsException(i);
        }
    }

    protected int validateRange(int i, int i2) {
        if (i < 0) {
            throw new StringIndexOutOfBoundsException(i);
        }
        int i3 = this.size;
        if (i2 > i3) {
            i2 = i3;
        }
        if (i <= i2) {
            return i2;
        }
        throw new StringIndexOutOfBoundsException("end < start");
    }
}
