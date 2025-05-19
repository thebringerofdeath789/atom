package org.apache.poi.util;

import com.logan.flight.FlightConfig;

/* loaded from: classes5.dex */
public final class PngUtils {
    private static final byte[] PNG_FILE_HEADER = {-119, FlightConfig.P1_PRO_RC, 78, 71, 13, 10, 26, 10};

    private PngUtils() {
    }

    public static boolean matchesPngHeader(byte[] bArr, int i) {
        if (bArr == null || bArr.length - i < PNG_FILE_HEADER.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = PNG_FILE_HEADER;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr2[i2] != bArr[i2 + i]) {
                return false;
            }
            i2++;
        }
    }
}
