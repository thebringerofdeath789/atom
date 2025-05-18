package com.baidu.location.p005a;

import android.content.Context;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.ipotensic.baselib.netty.Constant;
import org.json.JSONObject;

/* renamed from: com.baidu.location.a.a */
/* loaded from: classes.dex */
public class C0643a implements LBSAuthManagerListener {

    /* renamed from: b */
    private static Object f376b = new Object();

    /* renamed from: c */
    private static C0643a f377c;

    /* renamed from: d */
    private int f379d = 0;

    /* renamed from: e */
    private Context f380e = null;

    /* renamed from: f */
    private long f381f = 0;

    /* renamed from: g */
    private String f382g = null;

    /* renamed from: a */
    public int f378a = 0;

    /* renamed from: a */
    public static C0643a m295a() {
        C0643a c0643a;
        synchronized (f376b) {
            if (f377c == null) {
                f377c = new C0643a();
            }
            c0643a = f377c;
        }
        return c0643a;
    }

    /* renamed from: b */
    public static String m296b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    public static String m297c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public void m298a(Context context) {
        this.f380e = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.f381f = System.currentTimeMillis();
    }

    /* renamed from: a */
    public void m299a(Context context, String str) {
        LBSAuthManager.getInstance(context).setKey(str);
    }

    /* renamed from: b */
    public boolean m300b() {
        int i = this.f379d;
        boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
        if (this.f380e != null) {
            long currentTimeMillis = System.currentTimeMillis() - this.f381f;
            if (!z ? currentTimeMillis < 0 || currentTimeMillis > Constant.DELAY_MILLIS : currentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.f380e).authenticate(false, "lbs_locsdk", null, this);
                this.f381f = System.currentTimeMillis();
            }
        }
        return z;
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i, String str) {
        this.f379d = i;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token") && jSONObject.getString("token") != null) {
                    this.f382g = jSONObject.getString("token");
                }
                if (!jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                    return;
                }
                this.f378a = jSONObject.getInt("ak_permission");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}