package org.apache.poi.util;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public final class LittleEndianOutputStream extends FilterOutputStream implements LittleEndianOutput {
    public LittleEndianOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double d) {
        writeLong(Double.doubleToLongBits(d));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int i) {
        int i2 = (i >>> 24) & 255;
        int i3 = (i >>> 16) & 255;
        int i4 = (i >>> 8) & 255;
        try {
            this.out.write((i >>> 0) & 255);
            this.out.write(i4);
            this.out.write(i3);
            this.out.write(i2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long j) {
        writeInt((int) (j >> 0));
        writeInt((int) (j >> 32));
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int i) {
        int i2 = (i >>> 8) & 255;
        try {
            this.out.write((i >>> 0) & 255);
            this.out.write(i2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr) {
        try {
            super.write(bArr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, org.apache.poi.util.LittleEndianOutput
    public void write(byte[] bArr, int i, int i2) {
        try {
            super.write(bArr, i, i2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
