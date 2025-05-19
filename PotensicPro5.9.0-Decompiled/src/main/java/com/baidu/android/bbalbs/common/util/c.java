package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* loaded from: classes.dex */
public final class c {
    private static b b = null;
    private static String c = "";
    private static volatile String d = "";
    private final Context a;

    private c(Context context) {
        this.a = context.getApplicationContext();
    }

    static String a() {
        if (TextUtils.isEmpty(c)) {
            c = "0newiqr3mini0";
        }
        return c;
    }

    public static String a(Context context) {
        return b(context).a();
    }

    public static void a(String str) {
        if (!d.a(str, 5)) {
            throw new IllegalArgumentException("expect src only letter or number , less than 6");
        }
        synchronized (b.class) {
            if (TextUtils.isEmpty(d)) {
                d = str;
                int length = 5 - str.length();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("0newiqr3");
                stringBuffer.append(str);
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(SessionDescription.SUPPORTED_SDP_VERSION);
                }
                c = stringBuffer.toString().trim();
            }
        }
    }

    private b b() {
        b b2 = b.b(this.a);
        boolean z = b2 == null;
        if (b2 == null) {
            a b3 = a.b(this.a);
            if (b3 == null) {
                b2 = b.a(this.a, a());
            } else {
                b3.c();
                b2 = b.a(b3);
            }
        }
        if (z) {
            b2.a(this.a);
        }
        a.a(this.a);
        return b2;
    }

    private static b b(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new c(context).b();
                }
            }
        }
        return b;
    }
}
