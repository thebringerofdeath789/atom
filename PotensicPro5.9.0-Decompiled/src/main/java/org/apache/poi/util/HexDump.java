package org.apache.poi.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import net.lingala.zip4j.crypto.PBKDF2.BinTools;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes5.dex */
public class HexDump {
    public static final String EOL = System.getProperty("line.separator");
    private static final char[] _hexcodes = BinTools.hex.toCharArray();
    private static final int[] _shifts = {60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};

    private HexDump() {
    }

    public static void dump(byte[] bArr, long j, OutputStream outputStream, int i, int i2) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (bArr.length == 0) {
            outputStream.write(("No Data" + EOL).getBytes());
            outputStream.flush();
            return;
        }
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i + " into array of length " + bArr.length);
        }
        if (outputStream == null) {
            throw new IllegalArgumentException("cannot write to nullstream");
        }
        long j2 = j + i;
        StringBuffer stringBuffer = new StringBuffer(74);
        int min = Math.min(bArr.length, i2 + i);
        while (i < min) {
            int i3 = min - i;
            if (i3 > 16) {
                i3 = 16;
            }
            stringBuffer.append(dump(j2)).append(' ');
            for (int i4 = 0; i4 < 16; i4++) {
                if (i4 < i3) {
                    stringBuffer.append(dump(bArr[i4 + i]));
                } else {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(' ');
            }
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i5 + i;
                if (bArr[i6] >= 32 && bArr[i6] < Byte.MAX_VALUE) {
                    stringBuffer.append((char) bArr[i6]);
                } else {
                    stringBuffer.append('.');
                }
            }
            stringBuffer.append(EOL);
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            stringBuffer.setLength(0);
            j2 += i3;
            i += 16;
        }
    }

    public static synchronized void dump(byte[] bArr, long j, OutputStream outputStream, int i) throws IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException {
        synchronized (HexDump.class) {
            dump(bArr, j, outputStream, i, bArr.length - i);
        }
    }

    public static String dump(byte[] bArr, long j, int i) {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("illegal index: " + i + " into array of length " + bArr.length);
        }
        long j2 = j + i;
        StringBuffer stringBuffer = new StringBuffer(74);
        while (i < bArr.length) {
            int length = bArr.length - i;
            if (length > 16) {
                length = 16;
            }
            stringBuffer.append(dump(j2)).append(' ');
            for (int i2 = 0; i2 < 16; i2++) {
                if (i2 < length) {
                    stringBuffer.append(dump(bArr[i2 + i]));
                } else {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(' ');
            }
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i3 + i;
                if (bArr[i4] >= 32 && bArr[i4] < Byte.MAX_VALUE) {
                    stringBuffer.append((char) bArr[i4]);
                } else {
                    stringBuffer.append('.');
                }
            }
            stringBuffer.append(EOL);
            j2 += length;
            i += 16;
        }
        return stringBuffer.toString();
    }

    private static String dump(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        for (int i = 0; i < 8; i++) {
            char[] cArr = _hexcodes;
            int[] iArr = _shifts;
            stringBuffer.append(cArr[((int) (j >> iArr[(iArr.length + i) - 8])) & 15]);
        }
        return stringBuffer.toString();
    }

    private static String dump(byte b) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.setLength(0);
        for (int i = 0; i < 2; i++) {
            stringBuffer.append(_hexcodes[(b >> _shifts[i + 6]) & 15]);
        }
        return stringBuffer.toString();
    }

    public static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        for (int i = 0; i < bArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(toHex(bArr[i]));
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    public static String toHex(short[] sArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(PropertyUtils.INDEXED_DELIM);
        for (int i = 0; i < sArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(toHex(sArr[i]));
        }
        stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        return stringBuffer.toString();
    }

    public static String toHex(byte[] bArr, int i) {
        int round = (int) Math.round((Math.log(bArr.length) / Math.log(10.0d)) + 0.5d);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < round; i2++) {
            stringBuffer.append('0');
        }
        stringBuffer.append(": ");
        DecimalFormat decimalFormat = new DecimalFormat(stringBuffer.toString());
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(decimalFormat.format(0L));
        int i3 = -1;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i3++;
            if (i3 == i) {
                stringBuffer2.append('\n');
                stringBuffer2.append(decimalFormat.format(i4));
                i3 = 0;
            } else if (i4 > 0) {
                stringBuffer2.append(", ");
            }
            stringBuffer2.append(toHex(bArr[i4]));
        }
        return stringBuffer2.toString();
    }

    public static String toHex(short s) {
        return toHex(s, 4);
    }

    public static String toHex(byte b) {
        return toHex(b, 2);
    }

    public static String toHex(int i) {
        return toHex(i, 8);
    }

    public static String toHex(long j) {
        return toHex(j, 16);
    }

    private static String toHex(long j, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(_hexcodes[(int) ((j >> _shifts[(16 - i) + i2]) & 15)]);
        }
        return stringBuffer.toString();
    }

    public static void dump(InputStream inputStream, PrintStream printStream, int i, int i2) throws IOException {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (i2 != -1) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 <= 0 || (read = inputStream.read()) == -1) {
                    break;
                }
                byteArrayOutputStream.write(read);
                i2 = i3;
            }
        } else {
            int read2 = inputStream.read();
            while (read2 != -1) {
                byteArrayOutputStream.write(read2);
                read2 = inputStream.read();
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        dump(byteArray, 0L, printStream, i, byteArray.length);
    }

    private static char[] toHexChars(long j, int i) {
        int i2 = (i * 2) + 2;
        char[] cArr = new char[i2];
        do {
            i2--;
            cArr[i2] = _hexcodes[(int) (15 & j)];
            j >>>= 4;
        } while (i2 > 1);
        cArr[0] = '0';
        cArr[1] = 'x';
        return cArr;
    }

    public static char[] longToHex(long j) {
        return toHexChars(j, 8);
    }

    public static char[] intToHex(int i) {
        return toHexChars(i, 4);
    }

    public static char[] shortToHex(int i) {
        return toHexChars(i, 2);
    }

    public static char[] byteToHex(int i) {
        return toHexChars(i, 1);
    }

    public static void main(String[] strArr) throws Exception {
        File file = new File(strArr[0]);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bArr = new byte[(int) file.length()];
        bufferedInputStream.read(bArr);
        System.out.println(dump(bArr, 0L, 0));
        bufferedInputStream.close();
    }
}
