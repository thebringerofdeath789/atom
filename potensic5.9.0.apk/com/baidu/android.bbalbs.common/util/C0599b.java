package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.android.bbalbs.common.security.C0596a;
import com.baidu.android.bbalbs.common.security.C0597b;
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

/* renamed from: com.baidu.android.bbalbs.common.util.b */
/* loaded from: classes.dex */
final class C0599b {

    /* renamed from: e */
    private static final String f92e = m49a(new byte[]{FlightConfig.P1_SELF_B_RC, 72, FlightConfig.ATOM_TI_18650_BATTERY, 79, 75, 72, 69, UsbConfig.REV_REMOTER_MUTE_CODE, 76, UsbConfig.REV_REMOTER_STATE, 103, 61}, new byte[]{82, UsbConfig.REV_REMOTER_STATE, 104, 90, 83, 122, 65, 105, 101, 49, 107, 61});

    /* renamed from: f */
    private static final String f93f = m49a(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, FlightConfig.P1_SELF_B_RC, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, UsbCameraHandler.MSG_ID_UPGRADE_HANDSHAKE_STATE, 100, FlightConfig.P1_SELF_B_RC, FlightConfig.ATOM_SE_RC, 121, 89, 61});

    /* renamed from: a */
    private String f94a;

    /* renamed from: b */
    private String f95b;

    /* renamed from: c */
    private int f96c = 3;

    /* renamed from: d */
    private int f97d;

    C0599b() {
    }

    /* renamed from: a */
    static C0599b m47a(Context context, String str) {
        return m51b(context, str);
    }

    /* renamed from: a */
    static C0599b m48a(C0598a c0598a) {
        if (c0598a == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        C0599b c0599b = new C0599b();
        c0599b.m66a(c0598a.m39a());
        c0599b.m68b(c0598a.m42b());
        return c0599b;
    }

    /* renamed from: a */
    private static String m49a(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(Base64.decode(bArr2)));
        }
        return sb.toString();
    }

    /* renamed from: b */
    static C0599b m50b(Context context) {
        File m57d = m57d(context);
        if (m57d.exists()) {
            return m56d(C0601d.m76a(m57d));
        }
        return null;
    }

    /* renamed from: b */
    private static C0599b m51b(Context context, String str) {
        StringBuilder append;
        C0599b c0599b = new C0599b();
        boolean z = Build.VERSION.SDK_INT < 23;
        String m74a = C0601d.m74a(context);
        if (z) {
            String m58e = m58e(context);
            if (TextUtils.isEmpty(m58e)) {
                m58e = UUID.randomUUID().toString();
                m54c(context, m58e);
            }
            append = new StringBuilder().append(m74a).append(m58e);
        } else {
            append = new StringBuilder().append("com.baidu").append(m74a);
        }
        c0599b.m66a(C0597b.m29a(append.toString().getBytes(), true));
        c0599b.m68b(str);
        c0599b.m65a(Build.VERSION.SDK_INT);
        return c0599b;
    }

    /* renamed from: b */
    private String m52b() {
        try {
            JSONObject put = new JSONObject().put(m63i("ZGV2aWNlaWQ="), this.f94a);
            String m63i = m63i("ZmxhZw==");
            String str = this.f95b;
            if (str == null) {
                str = SessionDescription.SUPPORTED_SDP_VERSION;
            }
            return put.put(m63i, str).put(m63i("dmVy"), this.f96c).put(m63i("c2Rr"), this.f97d).toString();
        } catch (JSONException e) {
            C0601d.m77a(e);
            return null;
        }
    }

    /* renamed from: c */
    static C0599b m53c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString(m63i("ZmxhZw=="), SessionDescription.SUPPORTED_SDP_VERSION);
            String string = jSONObject.getString(m63i("ZGV2aWNlaWQ="));
            int optInt = jSONObject.optInt(m63i("c2Rr"), 0);
            if (!TextUtils.isEmpty(string)) {
                C0599b c0599b = new C0599b();
                c0599b.m66a(string);
                c0599b.m68b(optString);
                c0599b.m65a(optInt);
                return c0599b;
            }
        } catch (JSONException e) {
            C0601d.m77a(e);
        }
        return null;
    }

    /* renamed from: c */
    private static void m54c(Context context, String str) {
        if (TextUtils.isEmpty(C0601d.m75a(context, "XL5g0WZAHpIaKspIHIHYg5k")) && C0601d.m80b(context)) {
            C0601d.m78a(context, "XL5g0WZAHpIaKspIHIHYg5k", m61g(str));
        }
    }

    /* renamed from: c */
    private boolean m55c(Context context) {
        String m59e = m59e(m52b());
        FileOutputStream fileOutputStream = null;
        try {
            try {
                fileOutputStream = context.openFileOutput("libcuid_v3.so", 0);
                fileOutputStream.write(m59e.getBytes());
                fileOutputStream.flush();
                if (fileOutputStream == null) {
                    return true;
                }
                try {
                    fileOutputStream.close();
                    return true;
                } catch (Exception e) {
                    C0601d.m77a(e);
                    return true;
                }
            } catch (Exception e2) {
                C0601d.m77a(e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e3) {
                        C0601d.m77a(e3);
                    }
                }
                return false;
            }
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                    C0601d.m77a(e4);
                }
            }
            throw th;
        }
    }

    /* renamed from: d */
    static C0599b m56d(String str) {
        return m53c(m60f(str));
    }

    /* renamed from: d */
    private static File m57d(Context context) {
        return new File(context.getFilesDir(), "libcuid_v3.so");
    }

    /* renamed from: e */
    private static String m58e(Context context) {
        return m62h(C0601d.m75a(context, "XL5g0WZAHpIaKspIHIHYg5k"));
    }

    /* renamed from: e */
    static String m59e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(C0596a.m26a(f92e, f93f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            C0601d.m77a(e);
            return "";
        }
    }

    /* renamed from: f */
    static String m60f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C0596a.m27b(f92e, f93f, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            C0601d.m77a(e);
            return "";
        }
    }

    /* renamed from: g */
    static String m61g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(C0596a.m26a(f93f, f92e, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e) {
            C0601d.m77a(e);
            return "";
        }
    }

    /* renamed from: h */
    static String m62h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(C0596a.m27b(f93f, f92e, Base64.decode(str.getBytes())));
        } catch (Exception e) {
            C0601d.m77a(e);
            return "";
        }
    }

    /* renamed from: i */
    static String m63i(String str) {
        return new String(Base64.decode(str.getBytes()));
    }

    /* renamed from: a */
    public String m64a() {
        if (TextUtils.isEmpty(this.f95b)) {
            this.f95b = SessionDescription.SUPPORTED_SDP_VERSION;
        }
        return this.f94a + "|" + this.f95b;
    }

    /* renamed from: a */
    public void m65a(int i) {
        this.f97d = i;
    }

    /* renamed from: a */
    public void m66a(String str) {
        this.f94a = str;
    }

    /* renamed from: a */
    boolean m67a(Context context) {
        return m55c(context);
    }

    /* renamed from: b */
    public void m68b(String str) {
        this.f95b = str;
    }
}