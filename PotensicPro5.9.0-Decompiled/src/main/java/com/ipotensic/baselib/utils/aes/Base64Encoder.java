package com.ipotensic.baselib.utils.aes;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes2.dex */
public class Base64Encoder extends FilterOutputStream {
    private static final char[] chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private int carryOver;
    private int charCount;

    public Base64Encoder(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (i < 0) {
            i += 256;
        }
        int i2 = this.charCount;
        if (i2 % 3 == 0) {
            this.carryOver = i & 3;
            this.out.write(chars[i >> 2]);
        } else if (i2 % 3 == 1) {
            int i3 = ((this.carryOver << 4) + (i >> 4)) & 63;
            this.carryOver = i & 15;
            this.out.write(chars[i3]);
        } else if (i2 % 3 == 2) {
            int i4 = ((this.carryOver << 2) + (i >> 6)) & 63;
            OutputStream outputStream = this.out;
            char[] cArr = chars;
            outputStream.write(cArr[i4]);
            this.out.write(cArr[i & 63]);
            this.carryOver = 0;
        }
        int i5 = this.charCount + 1;
        this.charCount = i5;
        if (i5 % 57 == 0) {
            this.out.write(10);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = 0; i3 < i2; i3++) {
            write(bArr[i + i3]);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i = this.charCount;
        if (i % 3 == 1) {
            this.out.write(chars[(this.carryOver << 4) & 63]);
            this.out.write(61);
            this.out.write(61);
        } else if (i % 3 == 2) {
            this.out.write(chars[(this.carryOver << 2) & 63]);
            this.out.write(61);
        }
        super.close();
    }

    public static String encode(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        return encode(bArr);
    }

    public static String encode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) (bArr.length * 1.37d));
        Base64Encoder base64Encoder = new Base64Encoder(byteArrayOutputStream);
        try {
            base64Encoder.write(bArr);
            base64Encoder.close();
            return byteArrayOutputStream.toString("UTF-8");
        } catch (IOException unused) {
            return null;
        }
    }
}
