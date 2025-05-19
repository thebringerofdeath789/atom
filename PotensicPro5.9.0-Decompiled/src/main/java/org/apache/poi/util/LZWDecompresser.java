package org.apache.poi.util;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public abstract class LZWDecompresser {
    private final int codeLengthIncrease;
    private final boolean maskMeansCompressed;
    private final boolean positionIsBigEndian;

    public static int fromByte(byte b) {
        return b >= 0 ? b : b + 256;
    }

    public static byte fromInt(int i) {
        return i < 128 ? (byte) i : (byte) (i + InputDeviceCompat.SOURCE_ANY);
    }

    protected abstract int adjustDictionaryOffset(int i);

    protected abstract int populateDictionary(byte[] bArr);

    protected LZWDecompresser(boolean z, int i, boolean z2) {
        this.maskMeansCompressed = z;
        this.codeLengthIncrease = i;
        this.positionIsBigEndian = z2;
    }

    public byte[] decompress(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        decompress(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public void decompress(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i;
        byte[] bArr = new byte[4096];
        int populateDictionary = populateDictionary(bArr);
        byte[] bArr2 = new byte[this.codeLengthIncrease + 16];
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                return;
            }
            for (int i2 = 1; i2 < 256; i2 <<= 1) {
                if (((read & i2) > 0) ^ this.maskMeansCompressed) {
                    int read2 = inputStream.read();
                    if (read2 != -1) {
                        bArr[populateDictionary & 4095] = fromInt(read2);
                        populateDictionary++;
                        outputStream.write(new byte[]{fromInt(read2)});
                    }
                } else {
                    int read3 = inputStream.read();
                    int read4 = inputStream.read();
                    if (read3 != -1 && read4 != -1) {
                        int i3 = (read4 & 15) + this.codeLengthIncrease;
                        if (this.positionIsBigEndian) {
                            read3 <<= 4;
                            i = read4 >> 4;
                        } else {
                            i = (read4 & 240) << 4;
                        }
                        int adjustDictionaryOffset = adjustDictionaryOffset(read3 + i);
                        for (int i4 = 0; i4 < i3; i4++) {
                            bArr2[i4] = bArr[(adjustDictionaryOffset + i4) & 4095];
                            bArr[(populateDictionary + i4) & 4095] = bArr2[i4];
                        }
                        outputStream.write(bArr2, 0, i3);
                        populateDictionary += i3;
                    }
                }
            }
        }
    }
}
