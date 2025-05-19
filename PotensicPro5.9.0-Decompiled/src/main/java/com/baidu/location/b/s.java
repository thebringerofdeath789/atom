package com.baidu.location.b;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class s {
    private static Object a = new Object();
    private static s b;
    private SharedPreferences c;
    private SharedPreferences d = null;

    public s() {
        this.c = null;
        try {
            if (com.baidu.location.f.getServiceContext() != null) {
                this.c = com.baidu.location.f.getServiceContext().getSharedPreferences("MapCoreServicePreIA", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.c = null;
        }
    }

    public static s a() {
        s sVar;
        synchronized (a) {
            if (b == null) {
                b = new s();
            }
            sVar = b;
        }
        return sVar;
    }

    public SharedPreferences a(Context context) {
        if (this.d == null && context != null) {
            try {
                this.d = context.getSharedPreferences("MapCoreServicePregck", 0);
            } catch (Exception e) {
                e.printStackTrace();
                this.d = null;
            }
        }
        return this.d;
    }

    public synchronized String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }
}
