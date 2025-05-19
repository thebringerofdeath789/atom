package com.logan.usb.utils;

import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class ByteToFileUtil {
    private FileOutputStream outputStream;

    public ByteToFileUtil(String str) throws Exception {
        this.outputStream = null;
        this.outputStream = new FileOutputStream(str);
    }

    public void save(byte[] bArr) throws Exception {
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            fileOutputStream.write(bArr);
            this.outputStream.flush();
        }
    }

    public void save(byte[] bArr, int i, int i2) throws Exception {
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            fileOutputStream.write(bArr, i, i2);
            this.outputStream.flush();
        }
    }

    public void finish() throws Exception {
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            fileOutputStream.close();
            this.outputStream = null;
        }
    }
}
