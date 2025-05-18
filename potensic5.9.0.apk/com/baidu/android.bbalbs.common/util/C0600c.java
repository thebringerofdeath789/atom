package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;

/* renamed from: com.baidu.android.bbalbs.common.util.c */
/* loaded from: classes.dex */
public final class C0600c {

    /* renamed from: b */
    private static C0599b f98b = null;

    /* renamed from: c */
    private static String f99c = "";

    /* renamed from: d */
    private static volatile String f100d = "";

    /* renamed from: a */
    private final Context f101a;

    private C0600c(Context context) {
        this.f101a = context.getApplicationContext();
    }

    /* renamed from: a */
    static String m69a() {
        if (TextUtils.isEmpty(f99c)) {
            f99c = "0newiqr3mini0";
        }
        return f99c;
    }

    /* renamed from: a */
    public static String m70a(Context context) {
        return m73b(context).m64a();
    }

    /* renamed from: a */
    public static void m71a(String str) {
        if (!C0601d.m79a(str, 5)) {
            throw new IllegalArgumentException("expect src only letter or number , less than 6");
        }
        synchronized (C0599b.class) {
            if (TextUtils.isEmpty(f100d)) {
                f100d = str;
                int length = 5 - str.length();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("0newiqr3");
                stringBuffer.append(str);
                for (int i = 0; i < length; i++) {
                    stringBuffer.append(SessionDescription.SUPPORTED_SDP_VERSION);
                }
                f99c = stringBuffer.toString().trim();
            }
        }
    }

    /* renamed from: b */
    private C0599b m72b() {
        C0599b m50b = C0599b.m50b(this.f101a);
        boolean z = m50b == null;
        if (m50b == null) {
            C0598a m31b = C0598a.m31b(this.f101a);
            if (m31b == null) {
                m50b = C0599b.m47a(this.f101a, m69a());
            } else {
                m31b.m44c();
                m50b = C0599b.m48a(m31b);
            }
        }
        if (z) {
            m50b.m67a(this.f101a);
        }
        C0598a.m30a(this.f101a);
        return m50b;
    }

    /* renamed from: b */
    private static C0599b m73b(Context context) {
        if (f98b == null) {
            synchronized (C0599b.class) {
                if (f98b == null) {
                    f98b = new C0600c(context).m72b();
                }
            }
        }
        return f98b;
    }
}