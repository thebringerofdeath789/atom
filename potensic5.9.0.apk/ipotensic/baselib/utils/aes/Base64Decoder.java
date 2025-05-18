package com.ipotensic.baselib.utils.aes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes2.dex */
class Base64Decoder extends FilterInputStream {
    private static final char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final int[] ints = new int[128];
    private int carryOver;
    private int charCount;

    static {
        for (int i = 0; i < 64; i++) {
            ints[chars[i]] = i;
        }
    }

    public Base64Decoder(InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int read;
        do {
            read = this.in.read();
            if (read == -1) {
                return -1;
            }
        } while (Character.isWhitespace((char) read));
        int i = this.charCount + 1;
        this.charCount = i;
        if (read == 61) {
            return -1;
        }
        int i2 = ints[read];
        int i3 = (i - 1) % 4;
        if (i3 == 0) {
            this.carryOver = i2 & 63;
            return read();
        }
        if (i3 == 1) {
            int i4 = ((this.carryOver << 2) + (i2 >> 4)) & 255;
            this.carryOver = i2 & 15;
            return i4;
        }
        if (i3 == 2) {
            int i5 = ((this.carryOver << 4) + (i2 >> 2)) & 255;
            this.carryOver = i2 & 3;
            return i5;
        }
        if (i3 == 3) {
            return ((this.carryOver << 6) + i2) & 255;
        }
        return -1;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (bArr.length < (i2 + i) - 1) {
            throw new IOException("The input buffer is too small: " + i2 + " bytes requested starting at offset " + i + " while the buffer  is only " + bArr.length + " bytes long.");
        }
        int i3 = 0;
        while (i3 < i2) {
            int read = read();
            if (read == -1 && i3 == 0) {
                return -1;
            }
            if (read == -1) {
                break;
            }
            bArr[i + i3] = (byte) read;
            i3++;
        }
        return i3;
    }

    public static String decode(String str) {
        return new String(decodeToBytes(str));
    }

    public static byte[] decodeToBytes(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        Base64Decoder base64Decoder = new Base64Decoder(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (bArr.length * 0.67d));
        try {
            byte[] bArr2 = new byte[4096];
            while (true) {
                int read = base64Decoder.read(bArr2);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}