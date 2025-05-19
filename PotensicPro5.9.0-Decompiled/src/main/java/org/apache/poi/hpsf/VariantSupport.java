package org.apache.poi.hpsf;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import org.apache.poi.util.CodePageUtil;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* loaded from: classes4.dex */
public class VariantSupport extends Variant {
    protected static List<Long> unsupportedMessage;
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) VariantSupport.class);
    private static boolean logUnsupportedTypes = false;
    public static final int[] SUPPORTED_TYPES = {0, 2, 3, 20, 5, 64, 30, 31, 71, 11};

    public static void setLogUnsupportedTypes(boolean z) {
        logUnsupportedTypes = z;
    }

    public static boolean isLogUnsupportedTypes() {
        return logUnsupportedTypes;
    }

    protected static void writeUnsupportedTypeMessage(UnsupportedVariantTypeException unsupportedVariantTypeException) {
        if (isLogUnsupportedTypes()) {
            if (unsupportedMessage == null) {
                unsupportedMessage = new LinkedList();
            }
            Long valueOf = Long.valueOf(unsupportedVariantTypeException.getVariantType());
            if (unsupportedMessage.contains(valueOf)) {
                return;
            }
            logger.log(7, unsupportedVariantTypeException.getMessage());
            unsupportedMessage.add(valueOf);
        }
    }

    public boolean isSupportedType(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = SUPPORTED_TYPES;
            if (i2 >= iArr.length) {
                return false;
            }
            if (i == iArr[i2]) {
                return true;
            }
            i2++;
        }
    }

    public static Object read(byte[] bArr, int i, int i2, long j, int i3) throws ReadingNotSupportedException, UnsupportedEncodingException {
        int i4 = (int) j;
        TypedPropertyValue typedPropertyValue = new TypedPropertyValue(i4, (Object) null);
        try {
            int readValue = typedPropertyValue.readValue(bArr, i);
            if (i4 != 0 && i4 != 5) {
                if (i4 == 11) {
                    return Boolean.valueOf(((VariantBool) typedPropertyValue.getValue()).getValue());
                }
                if (i4 != 20) {
                    if (i4 == 64) {
                        Filetime filetime = (Filetime) typedPropertyValue.getValue();
                        return Util.filetimeToDate((int) filetime.getHigh(), (int) filetime.getLow());
                    }
                    if (i4 == 71) {
                        return ((ClipboardData) typedPropertyValue.getValue()).toByteArray();
                    }
                    if (i4 == 2) {
                        return Integer.valueOf(((Short) typedPropertyValue.getValue()).intValue());
                    }
                    if (i4 != 3) {
                        if (i4 == 30) {
                            return ((CodePageString) typedPropertyValue.getValue()).getJavaValue(i3);
                        }
                        if (i4 == 31) {
                            return ((UnicodeString) typedPropertyValue.getValue()).toJavaString();
                        }
                        byte[] bArr2 = new byte[readValue];
                        System.arraycopy(bArr, i, bArr2, 0, readValue);
                        throw new ReadingNotSupportedException(j, bArr2);
                    }
                }
            }
            return typedPropertyValue.getValue();
        } catch (UnsupportedOperationException unused) {
            int min = Math.min(i2, bArr.length - i);
            byte[] bArr3 = new byte[min];
            System.arraycopy(bArr, i, bArr3, 0, min);
            throw new ReadingNotSupportedException(j, bArr3);
        }
    }

    public static String codepageToEncoding(int i) throws UnsupportedEncodingException {
        return CodePageUtil.codepageToEncoding(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0140 A[LOOP:0: B:24:0x013c->B:26:0x0140, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int write(java.io.OutputStream r5, long r6, java.lang.Object r8, int r9) throws java.io.IOException, org.apache.poi.hpsf.WritingNotSupportedException {
        /*
            Method dump skipped, instructions count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.poi.hpsf.VariantSupport.write(java.io.OutputStream, long, java.lang.Object, int):int");
    }
}
