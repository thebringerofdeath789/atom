package com.mapbox.mapboxsdk.module.http;

import okhttp3.OkHttpClient;
import okio.Buffer;

/* loaded from: classes3.dex */
public class HttpRequestUtil {
    public static void setLogEnabled(boolean z) {
        HttpRequestImpl.enableLog(z);
    }

    public static void setPrintRequestUrlOnFailure(boolean z) {
        HttpRequestImpl.enablePrintRequestUrlOnFailure(z);
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        HttpRequestImpl.setOkHttpClient(okHttpClient);
    }

    static String toHumanReadableAscii(String str) {
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt > 31 && codePointAt < 127) {
                i += Character.charCount(codePointAt);
            } else {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, i);
                while (i < length) {
                    int codePointAt2 = str.codePointAt(i);
                    buffer.writeUtf8CodePoint((codePointAt2 <= 31 || codePointAt2 >= 127) ? 63 : codePointAt2);
                    i += Character.charCount(codePointAt2);
                }
                return buffer.readUtf8();
            }
        }
        return str;
    }
}
