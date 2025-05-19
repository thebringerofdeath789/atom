package com.baidu.location.b;

import android.os.Bundle;
import com.logan.user.model.UserConstants;

/* loaded from: classes.dex */
public class d {
    private static Object a = new Object();
    private static d b;
    private int c = -1;

    public static d a() {
        d dVar;
        synchronized (a) {
            if (b == null) {
                b = new d();
            }
            dVar = b;
        }
        return dVar;
    }

    public void a(int i, int i2, String str) {
        if (i2 != this.c) {
            this.c = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            b.a().a(bundle, UserConstants.REQUEST_CODE_DOWNLOAD_FEEDBACK_VIDEO_FILE);
        }
    }

    public void b() {
        this.c = -1;
    }
}
