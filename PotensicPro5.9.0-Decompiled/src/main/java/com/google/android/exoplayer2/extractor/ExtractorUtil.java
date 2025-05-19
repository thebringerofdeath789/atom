package com.google.android.exoplayer2.extractor;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes.dex */
public final class ExtractorUtil {
    public static int peekToLength(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int peek = extractorInput.peek(bArr, i + i3, i2 - i3);
            if (peek == -1) {
                break;
            }
            i3 += peek;
        }
        return i3;
    }

    public static boolean readFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i, int i2) throws IOException {
        try {
            extractorInput.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean skipFullyQuietly(ExtractorInput extractorInput, int i) throws IOException {
        try {
            extractorInput.skipFully(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean peekFullyQuietly(ExtractorInput extractorInput, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return extractorInput.peekFully(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    private ExtractorUtil() {
    }
}
