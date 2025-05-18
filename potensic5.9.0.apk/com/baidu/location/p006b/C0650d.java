package com.baidu.location.p006b;

import android.os.Bundle;
import com.logan.user.model.UserConstants;

/* renamed from: com.baidu.location.b.d */
/* loaded from: classes.dex */
public class C0650d {

    /* renamed from: a */
    private static Object f456a = new Object();

    /* renamed from: b */
    private static C0650d f457b;

    /* renamed from: c */
    private int f458c = -1;

    /* renamed from: a */
    public static C0650d m371a() {
        C0650d c0650d;
        synchronized (f456a) {
            if (f457b == null) {
                f457b = new C0650d();
            }
            c0650d = f457b;
        }
        return c0650d;
    }

    /* renamed from: a */
    public void m372a(int i, int i2, String str) {
        if (i2 != this.f458c) {
            this.f458c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            C0648b.m321a().m328a(bundle, UserConstants.REQUEST_CODE_DOWNLOAD_FEEDBACK_VIDEO_FILE);
        }
    }

    /* renamed from: b */
    public void m373b() {
        this.f458c = -1;
    }
}