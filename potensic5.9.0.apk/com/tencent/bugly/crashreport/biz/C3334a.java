package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3400w;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.a */
/* loaded from: classes3.dex */
public final class C3334a {

    /* renamed from: a */
    private Context f2894a;

    /* renamed from: b */
    private long f2895b;

    /* renamed from: c */
    private int f2896c;

    /* renamed from: d */
    private boolean f2897d;

    /* renamed from: a */
    static /* synthetic */ void m1815a(C3334a c3334a, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> m1819a;
        if (userInfoBean != null) {
            if (!z && userInfoBean.f2876b != 1 && (m1819a = c3334a.m1819a(C3337a.m1854a(c3334a.f2894a).f2970d)) != null && m1819a.size() >= 20) {
                C3401x.m2246a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(m1819a.size()));
                return;
            }
            long m2202a = C3393p.m2187a().m2202a("t_ui", m1812a(userInfoBean), (InterfaceC3392o) null, true);
            if (m2202a >= 0) {
                C3401x.m2251c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(m2202a));
                userInfoBean.f2875a = m2202a;
            }
        }
    }

    public C3334a(Context context, boolean z) {
        this.f2897d = true;
        this.f2894a = context;
        this.f2897d = z;
    }

    /* renamed from: a */
    public final void m1821a(int i, boolean z, long j) {
        C3340a m1927a = C3340a.m1927a();
        if (m1927a != null && !m1927a.m1937c().f3001f && i != 1 && i != 3) {
            C3401x.m2253e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f2896c++;
        }
        C3337a m1854a = C3337a.m1854a(this.f2894a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f2876b = i;
        userInfoBean.f2877c = m1854a.f2970d;
        userInfoBean.f2878d = m1854a.m1878g();
        userInfoBean.f2879e = System.currentTimeMillis();
        userInfoBean.f2880f = -1L;
        userInfoBean.f2888n = m1854a.f2977k;
        userInfoBean.f2889o = i == 1 ? 1 : 0;
        userInfoBean.f2886l = m1854a.m1864a();
        userInfoBean.f2887m = m1854a.f2983q;
        userInfoBean.f2881g = m1854a.f2984r;
        userInfoBean.f2882h = m1854a.f2985s;
        userInfoBean.f2883i = m1854a.f2986t;
        userInfoBean.f2885k = m1854a.f2987u;
        userInfoBean.f2892r = m1854a.m1892t();
        userInfoBean.f2893s = m1854a.m1897y();
        userInfoBean.f2890p = m1854a.m1898z();
        userInfoBean.f2891q = m1854a.m1856A();
        C3400w.m2238a().m2241a(new a(userInfoBean, z), 0L);
    }

    /* renamed from: a */
    public final void m1820a() {
        this.f2895b = C3403z.m2298b() + 86400000;
        C3400w.m2238a().m2241a(new b(), (this.f2895b - System.currentTimeMillis()) + 5000);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a */
    class a implements Runnable {

        /* renamed from: a */
        private boolean f2901a;

        /* renamed from: b */
        private UserInfoBean f2902b;

        public a(UserInfoBean userInfoBean, boolean z) {
            this.f2902b = userInfoBean;
            this.f2901a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3337a m1855b;
            try {
                UserInfoBean userInfoBean = this.f2902b;
                if (userInfoBean != null) {
                    if (userInfoBean != null && (m1855b = C3337a.m1855b()) != null) {
                        userInfoBean.f2884j = m1855b.m1874e();
                    }
                    C3401x.m2251c("[UserInfo] Record user info.", new Object[0]);
                    C3334a.m1815a(C3334a.this, this.f2902b, false);
                }
                if (this.f2901a) {
                    C3334a c3334a = C3334a.this;
                    C3400w m2238a = C3400w.m2238a();
                    if (m2238a != null) {
                        m2238a.m2240a(c3334a.new AnonymousClass2());
                    }
                }
            } catch (Throwable th) {
                if (C3401x.m2247a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f2 A[Catch: all -> 0x0173, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011c A[Catch: all -> 0x0173, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0125 A[Catch: all -> 0x0173, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0007, B:12:0x000f, B:16:0x0017, B:18:0x001d, B:22:0x0027, B:24:0x003c, B:27:0x0045, B:29:0x004c, B:30:0x004f, B:32:0x0055, B:34:0x0069, B:36:0x0079, B:43:0x0081, B:45:0x008b, B:46:0x0090, B:48:0x0096, B:50:0x00a4, B:52:0x00b1, B:53:0x00b4, B:56:0x00c2, B:58:0x00c6, B:60:0x00cb, B:63:0x00d0, B:73:0x00d7, B:74:0x00ec, B:76:0x00f2, B:78:0x00f7, B:81:0x00fe, B:84:0x0116, B:86:0x011c, B:89:0x0125, B:91:0x012b, B:94:0x0134, B:96:0x013e, B:99:0x0147, B:102:0x0165, B:107:0x016a, B:111:0x00e6), top: B:2:0x0001 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void m1818c() {
        /*
            Method dump skipped, instructions count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C3334a.m1818c():void");
    }

    /* renamed from: b */
    public final void m1822b() {
        C3400w m2238a = C3400w.m2238a();
        if (m2238a != null) {
            m2238a.m2240a(new AnonymousClass2());
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                C3334a.this.m1818c();
            } catch (Throwable th) {
                C3401x.m2247a(th);
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$b */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C3334a.this.f2895b) {
                C3400w.m2238a().m2241a(C3334a.this.new b(), (C3334a.this.f2895b - currentTimeMillis) + 5000);
            } else {
                C3334a.this.m1821a(3, false, 0L);
                C3334a.this.m1820a();
            }
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$c */
    class c implements Runnable {

        /* renamed from: a */
        private long f2905a;

        public c(long j) {
            this.f2905a = 21600000L;
            this.f2905a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C3334a c3334a = C3334a.this;
            C3400w m2238a = C3400w.m2238a();
            if (m2238a != null) {
                m2238a.m2240a(c3334a.new AnonymousClass2());
            }
            C3334a c3334a2 = C3334a.this;
            long j = this.f2905a;
            C3400w.m2238a().m2241a(c3334a2.new c(j), j);
        }
    }

    /* renamed from: a */
    public final List<UserInfoBean> m1819a(String str) {
        Cursor cursor;
        try {
            cursor = C3393p.m2187a().m2203a("t_ui", null, C3403z.m2294a(str) ? null : "_pc = '" + str + "'", null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean m1813a = m1813a(cursor);
                    if (m1813a != null) {
                        arrayList.add(m1813a);
                    } else {
                        try {
                            sb.append(" or _id").append(" = ").append(cursor.getLong(cursor.getColumnIndex("_id")));
                        } catch (Throwable unused) {
                            C3401x.m2252d("[Database] unknown id.", new Object[0]);
                        }
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    C3401x.m2252d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(C3393p.m2187a().m2201a("t_ui", sb2.substring(4), (String[]) null, (InterfaceC3392o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C3401x.m2247a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: a */
    private static void m1816a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            sb.append(" or _id").append(" = ").append(list.get(i).f2875a);
        }
        String sb2 = sb.toString();
        if (sb2.length() > 0) {
            sb2 = sb2.substring(4);
        }
        String str = sb2;
        sb.setLength(0);
        try {
            C3401x.m2251c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C3393p.m2187a().m2201a("t_ui", str, (String[]) null, (InterfaceC3392o) null, true)));
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static ContentValues m1812a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f2875a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f2875a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f2879e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f2880f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f2876b));
            contentValues.put("_pc", userInfoBean.f2877c);
            contentValues.put("_dt", C3403z.m2295a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static UserInfoBean m1813a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C3403z.m2276a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f2875a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}