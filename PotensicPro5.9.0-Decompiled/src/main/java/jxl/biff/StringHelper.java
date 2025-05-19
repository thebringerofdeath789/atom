package jxl.biff;

import common.Logger;
import java.io.UnsupportedEncodingException;
import jxl.WorkbookSettings;

/* loaded from: classes4.dex */
public final class StringHelper {
    static /* synthetic */ Class class$jxl$biff$StringHelper;
    private static Logger logger;

    static {
        Class cls = class$jxl$biff$StringHelper;
        if (cls == null) {
            cls = class$("jxl.biff.StringHelper");
            class$jxl$biff$StringHelper = cls;
        }
        logger = Logger.getLogger(cls);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private StringHelper() {
    }

    public static byte[] getBytes(String str) {
        return str.getBytes();
    }

    public static byte[] getBytes(String str, WorkbookSettings workbookSettings) {
        try {
            return str.getBytes(workbookSettings.getEncoding());
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static byte[] getUnicodeBytes(String str) {
        try {
            byte[] bytes = str.getBytes("UnicodeLittle");
            if (bytes.length != (str.length() * 2) + 2) {
                return bytes;
            }
            int length = bytes.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(bytes, 2, bArr, 0, length);
            return bArr;
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static void getBytes(String str, byte[] bArr, int i) {
        byte[] bytes = getBytes(str);
        System.arraycopy(bytes, 0, bArr, i, bytes.length);
    }

    public static void getUnicodeBytes(String str, byte[] bArr, int i) {
        byte[] unicodeBytes = getUnicodeBytes(str);
        System.arraycopy(unicodeBytes, 0, bArr, i, unicodeBytes.length);
    }

    public static String getString(byte[] bArr, int i, int i2, WorkbookSettings workbookSettings) {
        try {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, i2, bArr2, 0, i);
            return new String(bArr2, workbookSettings.getEncoding());
        } catch (UnsupportedEncodingException e) {
            logger.warn(e.toString());
            return "";
        }
    }

    public static String getUnicodeString(byte[] bArr, int i, int i2) {
        int i3 = i * 2;
        try {
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return new String(bArr2, "UnicodeLittle");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static final String replace(String str, String str2, String str3) {
        int indexOf = str.indexOf(str2);
        while (indexOf != -1) {
            StringBuffer stringBuffer = new StringBuffer(str.substring(0, indexOf));
            stringBuffer.append(str3);
            stringBuffer.append(str.substring(str2.length() + indexOf));
            str = stringBuffer.toString();
            indexOf = str.indexOf(str2, indexOf + str3.length());
        }
        return str;
    }
}
