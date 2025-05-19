package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.configs.UsbConfig;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class b {
    private static final String e = a(new byte[]{FlightConfig.P1_SELF_B_RC, 72, FlightConfig.ATOM_TI_18650_BATTERY, 79, 75, 72, 69, UsbConfig.REV_REMOTER_MUTE_CODE, 76, UsbConfig.REV_REMOTER_STATE, 103, 61}, new byte[]{82, UsbConfig.REV_REMOTER_STATE, 104, 90, 83, 122, 65, 105, 101, 49, 107, 61});
    private static final String f = a(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, FlightConfig.P1_SELF_B_RC, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 100, FlightConfig.P1_SELF_B_RC, FlightConfig.ATOM_SE_RC, 121, 89, 61});
    private String a;
    private String b;
    private int c = 3;
    private int d;

    b() {
    }

    static b a(Context context, String str) {
        return b(context, str);
    }

    static b a(a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        b bVar = new b();
        bVar.a(aVar.a());
        bVar.b(aVar.b());
        return bVar;
    }

    private static String a(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(Base64.decode(bArr2)));
        }
        return sb.toString();
    }

    static b b(Context context) {
        File d = d(context);
        if (d.exists()) {
            return d(d.a(d));
        }
        return null;
    }

    private static b b(Context context, String str) {
        StringBuilder append;
        b bVar = new b();
        boolean z = Build.VERSION.SDK_INT < 23;
        String a = d.a(context);
        if (z) {
            String e2 = e(context);
            if (TextUtils.isEmpty(e2)) {
                e2 = UUID.randomUUID().toString();
                c(context, e2);
            }
            append = new StringBuilder().append(a).append(e2);
        } else {
            append = new StringBuilder().append("com.baidu").append(a);
        }
        bVar.a(com.baidu.android.bbalbs.common.security.b.a(append.toString().getBytes(), true));
        bVar.b(str);
        bVar.a(Build.VERSION.SDK_INT);
        return bVar;
    }

    private String b() {
        try {
            JSONObject put = new JSONObject().put(i("ZGV2aWNlaWQ="), this.a);
            String i = i("ZmxhZw==");
            String str = this.b;
            if (str == null) {
                str = SessionDescription.SUPPORTED_SDP_VERSION;
            }
            return put.put(i, str).put(i("dmVy"), this.c).put(i("c2Rr"), this.d).toString();
        } catch (JSONException e2) {
            d.a(e2);
            return null;
        }
    }

    static b c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(i("ZmxhZw=="), SessionDescription.SUPPORTED_SDP_VERSION);
            String string = jSONObject.getString(i("ZGV2aWNlaWQ="));
            int optInt = jSONObject.optInt(i("c2Rr"), 0);
            if (!TextUtils.isEmpty(string)) {
                b bVar = new b();
                bVar.a(string);
                bVar.b(optString);
                bVar.a(optInt);
                return bVar;
            }
        } catch (JSONException e2) {
            d.a(e2);
        }
        return null;
    }

    private static void c(Context context, String str) {
        if (TextUtils.isEmpty(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k")) && d.b(context)) {
            d.a(context, "XL5g0WZAHpIaKspIHIHYg5k", g(str));
        }
    }

    private boolean c(Context context) {
        String e2 = e(b());
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput("libcuid_v3.so", 0);
                fileOutputStream.write(e2.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream == null) {
                    return true;
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception e3) {
                    d.a(e3);
                    return true;
                }
            } catch (Exception e4) {
                d.a(e4);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e5) {
                        d.a(e5);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e6) {
                    d.a(e6);
                }
            }
            throw th;
        }
    }

    static b d(String str) {
        return c(f(str));
    }

    private static File d(Context context) {
        return new File(context.getFilesDir(), "libcuid_v3.so");
    }

    private static String e(Context context) {
        return h(d.a(context, "XL5g0WZAHpIaKspIHIHYg5k"));
    }

    static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(com.baidu.android.bbalbs.common.security.a.a(e, f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.security.a.b(e, f, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(com.baidu.android.bbalbs.common.security.a.a(f, e, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            d.a(e2);
            return "";
        }
    }

    static String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(com.baidu.android.bbalbs.common.security.a.b(f, e, Base64.decode(str.getBytes())));
        } catch (Exception e2) {
            d.a(e2);
            return "";
        }
    }

    static String i(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    public String a() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        return this.a + "|" + this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(String str) {
        this.a = str;
    }

    boolean a(Context context) {
        return c(context);
    }

    public void b(String str) {
        this.b = str;
    }
}
