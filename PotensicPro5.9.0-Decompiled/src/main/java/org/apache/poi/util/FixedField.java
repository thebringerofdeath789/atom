package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public interface FixedField {
    void readFromBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException;

    void readFromStream(InputStream inputStream) throws IOException, LittleEndian.BufferUnderrunException;

    String toString();

    void writeToBytes(byte[] bArr) throws ArrayIndexOutOfBoundsException;
}
