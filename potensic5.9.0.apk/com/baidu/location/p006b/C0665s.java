package com.baidu.location.p006b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.location.ServiceC0702f;

/* renamed from: com.baidu.location.b.s */
/* loaded from: classes.dex */
public class C0665s {

    /* renamed from: a */
    private static Object f676a = new Object();

    /* renamed from: b */
    private static C0665s f677b;

    /* renamed from: c */
    private SharedPreferences f678c;

    /* renamed from: d */
    private SharedPreferences f679d = null;

    public C0665s() {
        this.f678c = null;
        try {
            if (ServiceC0702f.getServiceContext() != null) {
                this.f678c = ServiceC0702f.getServiceContext().getSharedPreferences("MapCoreServicePreIA", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f678c = null;
        }
    }

    /* renamed from: a */
    public static C0665s m546a() {
        C0665s c0665s;
        synchronized (f676a) {
            if (f677b == null) {
                f677b = new C0665s();
            }
            c0665s = f677b;
        }
        return c0665s;
    }

    /* renamed from: a */
    public SharedPreferences m547a(Context context) {
        if (this.f679d == null && context != null) {
            try {
                this.f679d = context.getSharedPreferences("MapCoreServicePregck", 0);
            } catch (Exception e) {
                e.printStackTrace();
                this.f679d = null;
            }
        }
        return this.f679d;
    }

    /* renamed from: a */
    public synchronized String m548a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f678c;
        if (sharedPreferences != null) {
            try {
                str2 = sharedPreferences.getString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }
}