package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import com.baidu.android.bbalbs.common.security.Base64;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/* loaded from: classes.dex */
final class a {
    private static final String e = new String(Base64.decode(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 73, 61})) + new String(Base64.decode(new byte[]{90, 71, 108, 106, 100, FlightConfig.ATOM_RC, 82, 112, 89, FlightConfig.ATOM_RC, 73, 61}));
    private String a;
    private String b;
    private int c = 0;
    private int d = 2;

    a() {
    }

    static boolean a(Context context) {
        File c = c(context);
        if (c.exists()) {
            return c.delete();
        }
        return false;
    }

    static a b(Context context) {
        return d(d.a(c(context)));
    }

    public static boolean b(int i) {
        return i >= 14;
    }

    static a c(String str) {
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
            String g = g("ZGV2aWNlaWQ=");
            String g2 = g("dmVy");
            String str2 = SessionDescription.SUPPORTED_SDP_VERSION;
            String str3 = "";
            int i = 2;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (g.equals(nextName)) {
                    str3 = jsonReader.nextString();
                } else if (g2.equals(nextName)) {
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
            } catch (Exception e2) {
                d.a(e2);
            }
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            a aVar = new a();
            aVar.a(str3);
            aVar.a(i2);
            if (!aVar.d()) {
                aVar.b(str2);
            }
            return aVar;
        } catch (IOException unused2) {
            if (jsonReader != null) {
                try {
                    jsonReader.close();
                } catch (Exception e3) {
                    d.a(e3);
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            jsonReader2 = jsonReader;
            if (jsonReader2 != null) {
                try {
                    jsonReader2.close();
                } catch (Exception e4) {
                    d.a(e4);
                }
            }
            throw th;
        }
    }

    private static File c(Context context) {
        return new File(context.getFilesDir(), "libcuid.so");
    }

    static a d(String str) {
        return c(f(str));
    }

    public static boolean e(String str) {
        return TextUtils.isEmpty(str);
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = e;
            return new String(com.baidu.android.bbalbs.common.security.a.b(str2, str2, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    private static String g(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    public String a() {
        return this.a;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    boolean c() {
        String str;
        if (d()) {
            str = "O";
        } else {
            if (!e()) {
                return false;
            }
            str = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        this.b = str;
        return true;
    }

    public boolean d() {
        return b(this.c);
    }

    public boolean e() {
        return e(this.b);
    }
}
