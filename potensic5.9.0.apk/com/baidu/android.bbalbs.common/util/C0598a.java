package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.bbalbs.common.security.C0596a;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/* renamed from: com.baidu.android.bbalbs.common.util.a */
/* loaded from: classes.dex */
final class C0598a {

    /* renamed from: e */
    private static final String f87e = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, FlightConfig.ATOM_RC, 82, 112, 89, FlightConfig.ATOM_RC, 73, 61}));

    /* renamed from: a */
    private String f88a;

    /* renamed from: b */
    private String f89b;

    /* renamed from: c */
    private int f90c = 0;

    /* renamed from: d */
    private int f91d = 2;

    C0598a() {
    }

    /* renamed from: a */
    static boolean m30a(Context context) {
        File m34c = m34c(context);
        if (m34c.exists()) {
            return m34c.delete();
        }
        return false;
    }

    /* renamed from: b */
    static C0598a m31b(Context context) {
        return m35d(C0601d.m76a(m34c(context)));
    }

    /* renamed from: b */
    public static boolean m32b(int i) {
        return i >= 14;
    }

    /* renamed from: c */
    static C0598a m33c(String str) {
        JsonReader jsonReader;
        JsonReader jsonReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jsonReader = new JsonReader(new StringReader(str));
        } catch (IOException unused) {
            jsonReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            jsonReader.beginObject();
            String m38g = m38g("ZGV2aWNlaWQ=");
            String m38g2 = m38g("dmVy");
            String str2 = SessionDescription.SUPPORTED_SDP_VERSION;
            String str3 = "";
            int i = 2;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (m38g.equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else if (m38g2.equals(nextName)) {
                    i = jsonReader.nextInt();
                } else {
                    str2 = jsonReader.nextString();
                }
            }
            jsonReader.endObject();
            int i2 = 0;
            if (i == 2 && !TextUtils.isEmpty(str2)) {
                i2 = str2.length();
            }
            try {
                jsonReader.close();
            } catch (Exception e) {
                C0601d.m77a(e);
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            C0598a c0598a = new C0598a();
            c0598a.m41a(str3);
            c0598a.m40a(i2);
            if (!c0598a.m45d()) {
                c0598a.m43b(str2);
            }
            return c0598a;
        } catch (IOException unused2) {
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (Exception e2) {
                    C0601d.m77a(e2);
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            jsonReader2 = jsonReader;
            if (jsonReader2 != null) {
                try {
                    jsonReader2.close();
                } catch (Exception e3) {
                    C0601d.m77a(e3);
                }
            }
            throw th;
        }
    }

    /* renamed from: c */
    private static File m34c(Context context) {
        return new File(context.getFilesDir(), "libcuid.so");
    }

    /* renamed from: d */
    static C0598a m35d(String str) {
        return m33c(m37f(str));
    }

    /* renamed from: e */
    public static boolean m36e(String str) {
        return TextUtils.isEmpty(str);
    }

    /* renamed from: f */
    private static String m37f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = f87e;
            return new String(C0596a.m27b(str2, str2, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            C0601d.m77a(e);
            return "";
        }
    }

    /* renamed from: g */
    private static String m38g(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    /* renamed from: a */
    public String m39a() {
        return this.f88a;
    }

    /* renamed from: a */
    public void m40a(int i) {
        this.f90c = i;
    }

    /* renamed from: a */
    public void m41a(String str) {
        this.f88a = str;
    }

    /* renamed from: b */
    public String m42b() {
        return this.f89b;
    }

    /* renamed from: b */
    public void m43b(String str) {
        this.f89b = str;
    }

    /* renamed from: c */
    boolean m44c() {
        String str;
        if (m45d()) {
            str = "O";
        } else {
            if (!m46e()) {
                return false;
            }
            str = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        this.f89b = str;
        return true;
    }

    /* renamed from: d */
    public boolean m45d() {
        return m32b(this.f90c);
    }

    /* renamed from: e */
    public boolean m46e() {
        return m36e(this.f89b);
    }
}