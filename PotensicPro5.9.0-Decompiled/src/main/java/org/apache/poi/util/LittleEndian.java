package org.apache.poi.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes5.dex */
public class LittleEndian implements LittleEndianConsts {
    public static int ubyteToInt(byte b) {
        return b & 255;
    }

    public static final class BufferUnderrunException extends IOException {
        private static final long serialVersionUID = 8736973884877006145L;

        BufferUnderrunException() {
            super("buffer underrun");
        }
    }

    public static byte[] getByteArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static double getDouble(byte[] bArr) {
        return Double.longBitsToDouble(getLong(bArr, 0));
    }

    public static double getDouble(byte[] bArr, int i) {
        return Double.longBitsToDouble(getLong(bArr, i));
    }

    public static float getFloat(byte[] bArr) {
        return getFloat(bArr, 0);
    }

    public static float getFloat(byte[] bArr, int i) {
        return Float.intBitsToFloat(getInt(bArr, i));
    }

    public static int getInt(byte[] bArr) {
        return getInt(bArr, 0);
    }

    public static int getInt(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        int i5 = bArr[i2] & 255;
        return ((bArr[i4 + 1] & 255) << 24) + ((bArr[i4] & 255) << 16) + (i5 << 8) + (i3 << 0);
    }

    public static long getLong(byte[] bArr) {
        return getLong(bArr, 0);
    }

    public static long getLong(byte[] bArr, int i) {
        long j = bArr[i + 7] & 255;
        for (int i2 = (i + 8) - 1; i2 >= i; i2--) {
            j = (j << 8) | (bArr[i2] & 255);
        }
        return j;
    }

    public static short getShort(byte[] bArr) {
        return getShort(bArr, 0);
    }

    public static short getShort(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) + ((bArr[i] & 255) << 0));
    }

    public static short[] getShortArray(byte[] bArr, int i, int i2) {
        int i3 = i2 / 2;
        short[] sArr = new short[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            sArr[i4] = getShort(bArr, (i4 * 2) + i);
        }
        return sArr;
    }

    public static short getUByte(byte[] bArr) {
        return (short) (bArr[0] & 255);
    }

    public static short getUByte(byte[] bArr, int i) {
        return (short) (bArr[i] & 255);
    }

    public static long getUInt(byte[] bArr) {
        return getUInt(bArr, 0);
    }

    public static long getUInt(byte[] bArr, int i) {
        return getInt(bArr, i) & 4294967295L;
    }

    @Deprecated
    public static int getUnsignedByte(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int getUShort(byte[] bArr) {
        return getUShort(bArr, 0);
    }

    public static int getUShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) + ((bArr[i] & 255) << 0);
    }

    public static void putByte(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    public static void putDouble(byte[] bArr, int i, double d) {
        putLong(bArr, i, Double.doubleToLongBits(d));
    }

    public static void putDouble(double d, OutputStream outputStream) throws IOException {
        putLong(Double.doubleToLongBits(d), outputStream);
    }

    public static void putFloat(byte[] bArr, int i, float f) {
        putInt(bArr, i, Float.floatToIntBits(f));
    }

    public static void putFloat(float f, OutputStream outputStream) throws IOException {
        putInt(Float.floatToIntBits(f), outputStream);
    }

    @Deprecated
    public static void putInt(byte[] bArr, int i) {
        putInt(bArr, 0, i);
    }

    public static void putInt(byte[] bArr, int i, int i2) {
        int i3 = i + 1;
        bArr[i] = (byte) ((i2 >>> 0) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        bArr[i4 + 1] = (byte) ((i2 >>> 24) & 255);
    }

    public static void putInt(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((i >>> 0) & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
        outputStream.write((byte) ((i >>> 16) & 255));
        outputStream.write((byte) ((i >>> 24) & 255));
    }

    public static void putLong(byte[] bArr, int i, long j) {
        bArr[i + 0] = (byte) ((j >>> 0) & 255);
        bArr[i + 1] = (byte) ((j >>> 8) & 255);
        bArr[i + 2] = (byte) ((j >>> 16) & 255);
        bArr[i + 3] = (byte) ((j >>> 24) & 255);
        bArr[i + 4] = (byte) ((j >>> 32) & 255);
        bArr[i + 5] = (byte) ((j >>> 40) & 255);
        bArr[i + 6] = (byte) ((j >>> 48) & 255);
        bArr[i + 7] = (byte) ((j >>> 56) & 255);
    }

    public static void putLong(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((j >>> 0) & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
        outputStream.write((byte) ((j >>> 32) & 255));
        outputStream.write((byte) ((j >>> 40) & 255));
        outputStream.write((byte) ((j >>> 48) & 255));
        outputStream.write((byte) ((j >>> 56) & 255));
    }

    public static void putShort(byte[] bArr, int i, short s) {
        bArr[i] = (byte) ((s >>> 0) & 255);
        bArr[i + 1] = (byte) ((s >>> 8) & 255);
    }

    @Deprecated
    public static void putShort(byte[] bArr, short s) {
        putShort(bArr, 0, s);
    }

    public static void putShort(OutputStream outputStream, short s) throws IOException {
        outputStream.write((byte) ((s >>> 0) & 255));
        outputStream.write((byte) ((s >>> 8) & 255));
    }

    public static void putShortArray(byte[] bArr, int i, short[] sArr) {
        for (short s : sArr) {
            putShort(bArr, i, s);
            i += 2;
        }
    }

    public static void putUByte(byte[] bArr, int i, short s) {
        bArr[i] = (byte) (s & 255);
    }

    public static void putUInt(byte[] bArr, int i, long j) {
        int i2 = i + 1;
        bArr[i] = (byte) ((j >>> 0) & 255);
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j >>> 8) & 255);
        bArr[i3] = (byte) ((j >>> 16) & 255);
        bArr[i3 + 1] = (byte) ((j >>> 24) & 255);
    }

    @Deprecated
    public static void putUInt(byte[] bArr, long j) {
        putUInt(bArr, 0, j);
    }

    public static void putUInt(long j, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((j >>> 0) & 255));
        outputStream.write((byte) ((j >>> 8) & 255));
        outputStream.write((byte) ((j >>> 16) & 255));
        outputStream.write((byte) ((j >>> 24) & 255));
    }

    public static void putUShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) ((i2 >>> 0) & 255);
        bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
    }

    public static void putUShort(int i, OutputStream outputStream) throws IOException {
        outputStream.write((byte) ((i >>> 0) & 255));
        outputStream.write((byte) ((i >>> 8) & 255));
    }

    public static int readInt(InputStream inputStream) throws IOException, BufferUnderrunException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new BufferUnderrunException();
    }

    public static long readUInt(InputStream inputStream) throws IOException, BufferUnderrunException {
        return readInt(inputStream) & 4294967295L;
    }

    public static long readLong(InputStream inputStream) throws IOException, BufferUnderrunException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        int read5 = inputStream.read();
        int read6 = inputStream.read();
        int read7 = inputStream.read();
        int read8 = inputStream.read();
        if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
            return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + (read << 0);
        }
        throw new BufferUnderrunException();
    }

    public static short readShort(InputStream inputStream) throws IOException, BufferUnderrunException {
        return (short) readUShort(inputStream);
    }

    public static int readUShort(InputStream inputStream) throws IOException, BufferUnderrunException {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return (read2 << 8) + (read << 0);
        }
        throw new BufferUnderrunException();
    }

    private LittleEndian() {
    }
}
