package org.apache.commons.text.io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.TextStringBuilder;
import org.apache.commons.text.matcher.StringMatcher;
import org.apache.commons.text.matcher.StringMatcherFactory;

/* loaded from: classes4.dex */
public class StringSubstitutorReader extends FilterReader {
    private static final int EOS = -1;
    private final TextStringBuilder buffer;
    private boolean eos;
    private final StringMatcher prefixEscapeMatcher;
    private final char[] read1CharBuffer;
    private final StringSubstitutor stringSubstitutor;
    private int toDrain;

    public StringSubstitutorReader(Reader reader, StringSubstitutor stringSubstitutor) {
        super(reader);
        this.buffer = new TextStringBuilder();
        this.read1CharBuffer = new char[]{0};
        this.stringSubstitutor = (StringSubstitutor) Objects.requireNonNull(stringSubstitutor);
        this.prefixEscapeMatcher = StringMatcherFactory.INSTANCE.charMatcher(stringSubstitutor.getEscapeChar()).andThen(stringSubstitutor.getVariablePrefixMatcher());
    }

    private int buffer(int i) throws IOException {
        int readFrom = this.buffer.readFrom(((FilterReader) this).in, i);
        this.eos = readFrom == -1;
        return readFrom;
    }

    private int bufferOrDrainOnEos(int i, char[] cArr, int i2, int i3) throws IOException {
        return drainOnEos(buffer(i), cArr, i2, i3);
    }

    private int drain(char[] cArr, int i, int i2) {
        int drainChars = this.buffer.drainChars(0, Math.min(this.buffer.length(), i2), cArr, i);
        this.toDrain -= drainChars;
        if (this.buffer.isEmpty() || this.toDrain == 0) {
            this.toDrain = 0;
        }
        return drainChars;
    }

    private int drainOnEos(int i, char[] cArr, int i2, int i3) {
        if (i != -1) {
            return i;
        }
        if (!this.buffer.isNotEmpty()) {
            return -1;
        }
        this.toDrain = this.buffer.size();
        return drain(cArr, i2, i3);
    }

    private boolean isBufferMatchAt(StringMatcher stringMatcher, int i) {
        return stringMatcher.isMatch(this.buffer, i) == stringMatcher.size();
    }

    private boolean isDraining() {
        return this.toDrain > 0;
    }

    @Override // java.io.FilterReader, java.io.Reader
    public int read() throws IOException {
        int read;
        do {
            read = read(this.read1CharBuffer, 0, 1);
            if (read == -1) {
                return -1;
            }
        } while (read < 1);
        return this.read1CharBuffer[0];
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b3, code lost:
    
        if (r6 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        r3 = r3 + r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b6, code lost:
    
        r3 = r3 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00b7, code lost:
    
        if (r3 <= 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ba, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
    
        return -1;
     */
    @Override // java.io.FilterReader, java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read(char[] r10, int r11, int r12) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.io.StringSubstitutorReader.read(char[], int, int):int");
    }

    private int readCount(int i, int i2) {
        int size = this.buffer.size() - i2;
        if (size >= i) {
            return 0;
        }
        return i - size;
    }
}
