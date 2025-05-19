package org.apache.poi.util;

import java.nio.charset.Charset;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.telnet.TelnetCommand;

/* loaded from: classes5.dex */
public class StringUtil {
    private static Map<Integer, Integer> msCodepointToUnicode;
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    private static final Charset UTF16LE = Charset.forName("UTF-16LE");
    private static final int[] symbolMap_f020 = {32, 33, 8704, 35, 8707, 37, 38, 8717, 40, 41, 8727, 43, 44, 8722, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 8773, 913, 914, 935, 916, 917, 934, 915, 919, 921, 977, 922, 923, 924, 925, 927, 928, 920, 929, 931, 932, 933, 962, 937, 926, 936, 918, 91, 8765, 93, 8869, 95, 32, 945, 946, 967, 948, 949, 966, 947, 951, 953, 981, 954, 955, 956, 957, 959, 960, 952, 961, 963, 964, 965, 982, 969, 958, 968, 950, 123, 124, 125, 8764, 32};
    private static final int[] symbolMap_f0a0 = {8364, 978, 8242, 8804, 8260, 8734, 402, 9827, 9830, 9829, 9824, 8596, 8591, 8593, 8594, 8595, 176, 177, 8243, 8805, FTPReply.NAME_SYSTEM_TYPE, 181, 8706, 8729, TelnetCommand.EC, 8800, 8801, 8776, 8230, 9168, 9135, 8629, 8501, 8475, 8476, 8472, 8855, 8853, 8709, 8745, 8746, 8835, 8839, 8836, 8834, 8838, 8712, 8713, 8736, 8711, 174, 169, 8482, 8719, 8730, 8901, 172, 8743, 8744, 8660, 8656, 8657, 8658, 8659, 9674, 9001, 174, 169, 8482, 8721, 9115, 9116, 9117, 9121, 9122, 9123, 9127, 9128, 9129, 9130, 32, 9002, 8747, 8992, 9134, 8993, 9118, 9119, 9120, 9124, 9125, 9126, 9131, 9132, 9133, 32};

    private StringUtil() {
    }

    public static String getFromUnicodeLE(byte[] bArr, int i, int i2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        if (i < 0 || i >= bArr.length) {
            throw new ArrayIndexOutOfBoundsException("Illegal offset " + i + " (String data is of length " + bArr.length + ")");
        }
        if (i2 < 0 || (bArr.length - i) / 2 < i2) {
            throw new IllegalArgumentException("Illegal length " + i2);
        }
        return new String(bArr, i, i2 * 2, UTF16LE);
    }

    public static String getFromUnicodeLE(byte[] bArr) {
        return bArr.length == 0 ? "" : getFromUnicodeLE(bArr, 0, bArr.length / 2);
    }

    public static byte[] getToUnicodeLE(String str) {
        return str.getBytes(UTF16LE);
    }

    public static String getFromCompressedUnicode(byte[] bArr, int i, int i2) {
        return new String(bArr, i, Math.min(i2, bArr.length - i), ISO_8859_1);
    }

    public static String readCompressedUnicode(LittleEndianInput littleEndianInput, int i) {
        byte[] bArr = new byte[i];
        littleEndianInput.readFully(bArr);
        return new String(bArr, ISO_8859_1);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput) {
        int readUShort = littleEndianInput.readUShort();
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, readUShort);
        }
        return readUnicodeLE(littleEndianInput, readUShort);
    }

    public static String readUnicodeString(LittleEndianInput littleEndianInput, int i) {
        if ((littleEndianInput.readByte() & 1) == 0) {
            return readCompressedUnicode(littleEndianInput, i);
        }
        return readUnicodeLE(littleEndianInput, i);
    }

    public static void writeUnicodeString(LittleEndianOutput littleEndianOutput, String str) {
        littleEndianOutput.writeShort(str.length());
        boolean hasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(hasMultibyte ? 1 : 0);
        if (hasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static void writeUnicodeStringFlagAndData(LittleEndianOutput littleEndianOutput, String str) {
        boolean hasMultibyte = hasMultibyte(str);
        littleEndianOutput.writeByte(hasMultibyte ? 1 : 0);
        if (hasMultibyte) {
            putUnicodeLE(str, littleEndianOutput);
        } else {
            putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public static int getEncodedSize(String str) {
        return (str.length() * (hasMultibyte(str) ? 2 : 1)) + 3;
    }

    public static void putCompressedUnicode(String str, byte[] bArr, int i) {
        byte[] bytes = str.getBytes(ISO_8859_1);
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static void putCompressedUnicode(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(ISO_8859_1));
    }

    public static void putUnicodeLE(String str, byte[] bArr, int i) {
        byte[] bytes = str.getBytes(UTF16LE);
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static void putUnicodeLE(String str, LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(str.getBytes(UTF16LE));
    }

    public static String readUnicodeLE(LittleEndianInput littleEndianInput, int i) {
        byte[] bArr = new byte[i * 2];
        littleEndianInput.readFully(bArr);
        return new String(bArr, UTF16LE);
    }

    public static String format(String str, Object[] objArr) {
        int i;
        int i2;
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = 0;
        int i4 = 0;
        while (i3 < str.length()) {
            if (str.charAt(i3) == '%') {
                if (i4 >= objArr.length) {
                    stringBuffer.append("?missing data?");
                } else if ((objArr[i4] instanceof Number) && (i2 = i3 + 1) < str.length()) {
                    i3 += matchOptionalFormatting((Number) objArr[i4], str.substring(i2), stringBuffer);
                    i4++;
                } else {
                    stringBuffer.append(objArr[i4].toString());
                    i4++;
                }
            } else if (str.charAt(i3) == '\\' && (i = i3 + 1) < str.length() && str.charAt(i) == '%') {
                stringBuffer.append('%');
                i3 = i;
            } else {
                stringBuffer.append(str.charAt(i3));
            }
            i3++;
        }
        return stringBuffer.toString();
    }

    private static int matchOptionalFormatting(Number number, String str, StringBuffer stringBuffer) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        if (str.length() > 0 && Character.isDigit(str.charAt(0))) {
            numberFormat.setMinimumIntegerDigits(Integer.parseInt(str.charAt(0) + ""));
            if (2 < str.length() && str.charAt(1) == '.' && Character.isDigit(str.charAt(2))) {
                numberFormat.setMaximumFractionDigits(Integer.parseInt(str.charAt(2) + ""));
                numberFormat.format(number, stringBuffer, new FieldPosition(0));
                return 3;
            }
            numberFormat.format(number, stringBuffer, new FieldPosition(0));
            return 1;
        }
        if (str.length() > 0 && str.charAt(0) == '.' && 1 < str.length() && Character.isDigit(str.charAt(1))) {
            numberFormat.setMaximumFractionDigits(Integer.parseInt(str.charAt(1) + ""));
            numberFormat.format(number, stringBuffer, new FieldPosition(0));
            return 2;
        }
        numberFormat.format(number, stringBuffer, new FieldPosition(0));
        return 1;
    }

    public static String getPreferredEncoding() {
        return ISO_8859_1.name();
    }

    public static boolean hasMultibyte(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) > 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUnicodeString(String str) {
        Charset charset = ISO_8859_1;
        return !str.equals(new String(str.getBytes(charset), charset));
    }

    public static class StringsIterator implements Iterator<String> {
        private int position = 0;
        private String[] strings;

        @Override // java.util.Iterator
        public void remove() {
        }

        public StringsIterator(String[] strArr) {
            if (strArr != null) {
                this.strings = strArr;
            } else {
                this.strings = new String[0];
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.strings.length;
        }

        @Override // java.util.Iterator
        public String next() {
            int i = this.position;
            this.position = i + 1;
            String[] strArr = this.strings;
            if (i >= strArr.length) {
                throw new ArrayIndexOutOfBoundsException(i);
            }
            return strArr[i];
        }
    }

    public static String mapMsCodepointString(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        initMsCodepointMap();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            Integer valueOf = Integer.valueOf(str.codePointAt(i));
            Integer num = msCodepointToUnicode.get(valueOf);
            if (num == null) {
                num = valueOf;
            }
            sb.appendCodePoint(num.intValue());
            i += Character.charCount(valueOf.intValue());
        }
        return sb.toString();
    }

    public static synchronized void mapMsCodepoint(int i, int i2) {
        synchronized (StringUtil.class) {
            initMsCodepointMap();
            msCodepointToUnicode.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    private static synchronized void initMsCodepointMap() {
        synchronized (StringUtil.class) {
            if (msCodepointToUnicode != null) {
                return;
            }
            msCodepointToUnicode = new HashMap();
            int i = 61472;
            int[] iArr = symbolMap_f020;
            int length = iArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                msCodepointToUnicode.put(Integer.valueOf(i), Integer.valueOf(iArr[i3]));
                i3++;
                i++;
            }
            int i4 = 61600;
            int[] iArr2 = symbolMap_f0a0;
            int length2 = iArr2.length;
            while (i2 < length2) {
                int i5 = i4 + 1;
                msCodepointToUnicode.put(Integer.valueOf(i4), Integer.valueOf(iArr2[i2]));
                i2++;
                i4 = i5;
            }
        }
    }
}
