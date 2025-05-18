package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C3329b;
import com.tencent.bugly.crashreport.common.info.C3337a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.C3340a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C3368ah;
import com.tencent.bugly.proguard.C3370aj;
import com.tencent.bugly.proguard.C3371ak;
import com.tencent.bugly.proguard.C3393p;
import com.tencent.bugly.proguard.C3395r;
import com.tencent.bugly.proguard.C3398u;
import com.tencent.bugly.proguard.C3401x;
import com.tencent.bugly.proguard.C3403z;
import com.tencent.bugly.proguard.InterfaceC3392o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.b */
/* loaded from: classes3.dex */
public final class C3350b {

    /* renamed from: a */
    private static int f3124a;

    /* renamed from: b */
    private Context f3125b;

    /* renamed from: c */
    private C3398u f3126c;

    /* renamed from: d */
    private C3393p f3127d;

    /* renamed from: e */
    private C3340a f3128e;

    /* renamed from: f */
    private InterfaceC3392o f3129f;

    /* renamed from: g */
    private BuglyStrategy.C3327a f3130g;

    public C3350b(int i, Context context, C3398u c3398u, C3393p c3393p, C3340a c3340a, BuglyStrategy.C3327a c3327a, InterfaceC3392o interfaceC3392o) {
        f3124a = i;
        this.f3125b = context;
        this.f3126c = c3398u;
        this.f3127d = c3393p;
        this.f3128e = c3340a;
        this.f3130g = c3327a;
        this.f3129f = interfaceC3392o;
    }

    /* renamed from: a */
    private static List<C3343a> m1973a(List<C3343a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C3343a c3343a : list) {
            if (c3343a.f3087d && c3343a.f3085b <= currentTimeMillis - 86400000) {
                arrayList.add(c3343a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private CrashDetailBean m1970a(List<C3343a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> m1978b;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C3343a c3343a : list) {
            if (c3343a.f3088e) {
                arrayList.add(c3343a);
            }
        }
        if (arrayList.size() > 0 && (m1978b = m1978b(arrayList)) != null && m1978b.size() > 0) {
            Collections.sort(m1978b);
            for (int i = 0; i < m1978b.size(); i++) {
                CrashDetailBean crashDetailBean3 = m1978b.get(i);
                if (i == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else if (crashDetailBean3.f3076s != null && (split = crashDetailBean3.f3076s.split("\n")) != null) {
                    for (String str : split) {
                        if (!crashDetailBean2.f3076s.contains(str)) {
                            crashDetailBean2.f3077t++;
                            crashDetailBean2.f3076s += str + "\n";
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f3067j = true;
            crashDetailBean.f3077t = 0;
            crashDetailBean.f3076s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (C3343a c3343a2 : list) {
            if (!c3343a2.f3088e && !c3343a2.f3087d && !crashDetailBean2.f3076s.contains(new StringBuilder().append(c3343a2.f3085b).toString())) {
                crashDetailBean2.f3077t++;
                crashDetailBean2.f3076s += c3343a2.f3085b + "\n";
            }
        }
        if (crashDetailBean2.f3075r != crashDetailBean.f3075r && !crashDetailBean2.f3076s.contains(new StringBuilder().append(crashDetailBean.f3075r).toString())) {
            crashDetailBean2.f3077t++;
            crashDetailBean2.f3076s += crashDetailBean.f3075r + "\n";
        }
        return crashDetailBean2;
    }

    /* renamed from: a */
    public final boolean m1985a(CrashDetailBean crashDetailBean) {
        return m1986b(crashDetailBean);
    }

    /* renamed from: b */
    public final boolean m1986b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return true;
        }
        if (C3351c.f3146n != null && !C3351c.f3146n.isEmpty()) {
            C3401x.m2251c("Crash filter for crash stack is: %s", C3351c.f3146n);
            if (crashDetailBean.f3074q.contains(C3351c.f3146n)) {
                C3401x.m2252d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (C3351c.f3147o != null && !C3351c.f3147o.isEmpty()) {
            C3401x.m2251c("Crash regular filter for crash stack is: %s", C3351c.f3147o);
            if (Pattern.compile(C3351c.f3147o).matcher(crashDetailBean.f3074q).find()) {
                C3401x.m2252d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f3059b != 2) {
            C3395r c3395r = new C3395r();
            c3395r.f3428b = 1;
            c3395r.f3429c = crashDetailBean.f3034A;
            c3395r.f3430d = crashDetailBean.f3035B;
            c3395r.f3431e = crashDetailBean.f3075r;
            this.f3127d.m2209b(1);
            this.f3127d.m2208a(c3395r);
            C3401x.m2249b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C3401x.m2249b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C3343a> m1977b = m1977b();
        ArrayList arrayList = null;
        if (m1977b != null && m1977b.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(m1973a(m1977b));
            m1977b.removeAll(arrayList);
            if (m1977b.size() > 20) {
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ").append("(");
                sb.append("SELECT _id").append(" FROM t_cr").append(" order by _id").append(" limit 5");
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                try {
                    C3401x.m2251c("deleted first record %s data %d", "t_cr", Integer.valueOf(C3393p.m2187a().m2201a("t_cr", sb2, (String[]) null, (InterfaceC3392o) null, true)));
                } catch (Throwable th) {
                    if (!C3401x.m2247a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            if (!C3329b.f2869c && C3351c.f3136d) {
                boolean z = false;
                for (C3343a c3343a : m1977b) {
                    if (crashDetailBean.f3078u.equals(c3343a.f3086c)) {
                        if (c3343a.f3088e) {
                            z = true;
                        }
                        arrayList2.add(c3343a);
                    }
                }
                if (z || arrayList2.size() >= C3351c.f3135c) {
                    C3401x.m2246a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean m1970a = m1970a(arrayList2, crashDetailBean);
                    for (C3343a c3343a2 : arrayList2) {
                        if (c3343a2.f3084a != m1970a.f3058a) {
                            arrayList.add(c3343a2);
                        }
                    }
                    m1989e(m1970a);
                    m1979c(arrayList);
                    C3401x.m2249b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        m1989e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            m1979c(arrayList);
        }
        C3401x.m2249b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public final List<CrashDetailBean> m1982a() {
        StrategyBean m1937c = C3340a.m1927a().m1937c();
        if (m1937c == null) {
            C3401x.m2252d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!m1937c.f3000e) {
            C3401x.m2252d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C3401x.m2249b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long m2298b = C3403z.m2298b();
        List<C3343a> m1977b = m1977b();
        C3401x.m2251c("Size of crash list loaded from DB: %s", Integer.valueOf(m1977b.size()));
        if (m1977b == null || m1977b.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(m1973a(m1977b));
        m1977b.removeAll(arrayList);
        Iterator<C3343a> it = m1977b.iterator();
        while (it.hasNext()) {
            C3343a next = it.next();
            if (next.f3085b < m2298b - C3351c.f3139g) {
                it.remove();
                arrayList.add(next);
            } else if (next.f3087d) {
                if (next.f3085b >= currentTimeMillis - 86400000) {
                    it.remove();
                } else if (!next.f3088e) {
                    it.remove();
                    arrayList.add(next);
                }
            } else if (next.f3089f >= 3 && next.f3085b < currentTimeMillis - 86400000) {
                it.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            m1979c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        List<CrashDetailBean> m1978b = m1978b(m1977b);
        if (m1978b != null && m1978b.size() > 0) {
            String str = C3337a.m1855b().f2977k;
            Iterator<CrashDetailBean> it2 = m1978b.iterator();
            while (it2.hasNext()) {
                CrashDetailBean next2 = it2.next();
                if (!str.equals(next2.f3063f)) {
                    it2.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            m1980d(arrayList2);
        }
        return m1978b;
    }

    /* renamed from: c */
    public final void m1987c(CrashDetailBean crashDetailBean) {
        int i = crashDetailBean.f3059b;
        if (i != 0) {
            if (i != 1) {
                if (i == 3 && !C3351c.m1990a().m2016q()) {
                    return;
                }
            } else if (!C3351c.m1990a().m2015p()) {
                return;
            }
        } else if (!C3351c.m1990a().m2015p()) {
            return;
        }
        if (this.f3129f != null) {
            C3401x.m2251c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            int i2 = crashDetailBean.f3059b;
        }
    }

    /* renamed from: a */
    public final void m1983a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (C3351c.f3144l) {
            C3401x.m2246a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m1984a(arrayList, 3000L, z, crashDetailBean.f3059b == 7, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0088 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:20:0x0041, B:23:0x004f, B:27:0x0058, B:28:0x0068, B:30:0x006e, B:33:0x0088, B:35:0x0090, B:37:0x0096, B:39:0x009e, B:41:0x00a8, B:43:0x00b0, B:45:0x00b7, B:47:0x00c3, B:49:0x007e), top: B:19:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090 A[Catch: all -> 0x00cc, TryCatch #0 {all -> 0x00cc, blocks: (B:20:0x0041, B:23:0x004f, B:27:0x0058, B:28:0x0068, B:30:0x006e, B:33:0x0088, B:35:0x0090, B:37:0x0096, B:39:0x009e, B:41:0x00a8, B:43:0x00b0, B:45:0x00b7, B:47:0x00c3, B:49:0x007e), top: B:19:0x0041 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1984a(final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> r15, long r16, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C3350b.m1984a(java.util.List, long, boolean, boolean, boolean):void");
    }

    /* renamed from: a */
    public static void m1975a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C3401x.m2251c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C3401x.m2251c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f3060c, Integer.valueOf(crashDetailBean.f3069l), Boolean.valueOf(crashDetailBean.f3061d), Boolean.valueOf(crashDetailBean.f3067j));
                crashDetailBean.f3069l++;
                crashDetailBean.f3061d = z;
                C3401x.m2251c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f3060c, Integer.valueOf(crashDetailBean.f3069l), Boolean.valueOf(crashDetailBean.f3061d), Boolean.valueOf(crashDetailBean.f3067j));
            }
            Iterator<CrashDetailBean> it = list.iterator();
            while (it.hasNext()) {
                C3351c.m1990a().m1997a(it.next());
            }
            C3401x.m2251c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        C3401x.m2249b("[crash] upload fail.", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00af A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ce A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0176 A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019f A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ce A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0184 A[Catch: all -> 0x01f1, TryCatch #0 {all -> 0x01f1, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0071, B:19:0x0087, B:22:0x00af, B:24:0x00b5, B:25:0x00c8, B:27:0x00ce, B:30:0x00e0, B:32:0x00ee, B:33:0x0101, B:35:0x010d, B:37:0x0119, B:38:0x0151, B:41:0x013e, B:44:0x016b, B:46:0x0176, B:47:0x019b, B:49:0x019f, B:51:0x01a2, B:52:0x01bc, B:53:0x01ca, B:55:0x01ce, B:57:0x01e9, B:62:0x0184, B:64:0x0188, B:66:0x0092, B:68:0x0096, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1988d(com.tencent.bugly.crashreport.crash.CrashDetailBean r13) {
        /*
            Method dump skipped, instructions count: 546
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C3350b.m1988d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    /* renamed from: f */
    private static ContentValues m1981f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f3058a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f3058a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f3075r));
            contentValues.put("_s1", crashDetailBean.f3078u);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f3061d ? 1 : 0));
            if (!crashDetailBean.f3067j) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f3069l));
            contentValues.put("_dt", C3403z.m2295a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static CrashDetailBean m1969a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C3403z.m2276a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f3058a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: e */
    public final void m1989e(CrashDetailBean crashDetailBean) {
        ContentValues m1981f;
        if (crashDetailBean == null || (m1981f = m1981f(crashDetailBean)) == null) {
            return;
        }
        long m2202a = C3393p.m2187a().m2202a("t_cr", m1981f, (InterfaceC3392o) null, true);
        if (m2202a >= 0) {
            C3401x.m2251c("insert %s success!", "t_cr");
            crashDetailBean.f3058a = m2202a;
        }
    }

    /* renamed from: b */
    private List<CrashDetailBean> m1978b(List<C3343a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ").append("(");
        Iterator<C3343a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f3084a).append(",");
        }
        if (sb.toString().contains(",")) {
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        }
        sb.append(")");
        String sb2 = sb.toString();
        sb.setLength(0);
        try {
            cursor = C3393p.m2187a().m2203a("t_cr", null, sb2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb.append("_id in ").append("(");
                int i = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean m1969a = m1969a(cursor);
                    if (m1969a != null) {
                        arrayList.add(m1969a);
                    } else {
                        try {
                            sb.append(cursor.getLong(cursor.getColumnIndex("_id"))).append(",");
                            i++;
                        } catch (Throwable unused) {
                            C3401x.m2252d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb3 = sb.toString();
                if (i > 0) {
                    C3401x.m2252d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C3393p.m2187a().m2201a("t_cr", sb3, (String[]) null, (InterfaceC3392o) null, true)));
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

    /* renamed from: b */
    private static C3343a m1976b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3343a c3343a = new C3343a();
            c3343a.f3084a = cursor.getLong(cursor.getColumnIndex("_id"));
            c3343a.f3085b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3343a.f3086c = cursor.getString(cursor.getColumnIndex("_s1"));
            c3343a.f3087d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c3343a.f3088e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c3343a.f3089f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c3343a;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    private List<C3343a> m1977b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor m2203a = C3393p.m2187a().m2203a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (m2203a == null) {
                if (m2203a != null) {
                    m2203a.close();
                }
                return null;
            }
            try {
                if (m2203a.getCount() <= 0) {
                    if (m2203a != null) {
                        m2203a.close();
                    }
                    return arrayList;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("_id in ").append("(");
                int i = 0;
                while (m2203a.moveToNext()) {
                    C3343a m1976b = m1976b(m2203a);
                    if (m1976b != null) {
                        arrayList.add(m1976b);
                    } else {
                        try {
                            sb.append(m2203a.getLong(m2203a.getColumnIndex("_id"))).append(",");
                            i++;
                        } catch (Throwable unused) {
                            C3401x.m2252d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb.toString().contains(",")) {
                    sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
                }
                sb.append(")");
                String sb2 = sb.toString();
                sb.setLength(0);
                if (i > 0) {
                    C3401x.m2252d("deleted %s illegal data %d", "t_cr", Integer.valueOf(C3393p.m2187a().m2201a("t_cr", sb2, (String[]) null, (InterfaceC3392o) null, true)));
                }
                if (m2203a != null) {
                    m2203a.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = m2203a;
                try {
                    if (!C3401x.m2247a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: c */
    private static void m1979c(List<C3343a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("_id in ").append("(");
        Iterator<C3343a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().f3084a).append(",");
        }
        StringBuilder sb2 = new StringBuilder(sb.substring(0, sb.lastIndexOf(",")));
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            C3401x.m2251c("deleted %s data %d", "t_cr", Integer.valueOf(C3393p.m2187a().m2201a("t_cr", sb3, (String[]) null, (InterfaceC3392o) null, true)));
        } catch (Throwable th) {
            if (C3401x.m2247a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    private static void m1980d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                Iterator<CrashDetailBean> it = list.iterator();
                while (it.hasNext()) {
                    sb.append(" or _id").append(" = ").append(it.next().f3058a);
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    sb2 = sb2.substring(4);
                }
                sb.setLength(0);
                C3401x.m2251c("deleted %s data %d", "t_cr", Integer.valueOf(C3393p.m2187a().m2201a("t_cr", sb2, (String[]) null, (InterfaceC3392o) null, true)));
            } catch (Throwable th) {
                if (C3401x.m2247a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static C3371ak m1972a(Context context, CrashDetailBean crashDetailBean, C3337a c3337a) {
        C3370aj m1971a;
        C3370aj m1971a2;
        C3370aj c3370aj;
        if (context == null || crashDetailBean == null || c3337a == null) {
            C3401x.m2252d("enExp args == null", new Object[0]);
            return null;
        }
        C3371ak c3371ak = new C3371ak();
        switch (crashDetailBean.f3059b) {
            case 0:
                c3371ak.f3264a = crashDetailBean.f3067j ? "200" : "100";
                break;
            case 1:
                c3371ak.f3264a = crashDetailBean.f3067j ? "201" : "101";
                break;
            case 2:
                c3371ak.f3264a = crashDetailBean.f3067j ? "202" : "102";
                break;
            case 3:
                c3371ak.f3264a = crashDetailBean.f3067j ? "203" : "103";
                break;
            case 4:
                c3371ak.f3264a = crashDetailBean.f3067j ? "204" : "104";
                break;
            case 5:
                c3371ak.f3264a = crashDetailBean.f3067j ? "207" : "107";
                break;
            case 6:
                c3371ak.f3264a = crashDetailBean.f3067j ? "206" : "106";
                break;
            case 7:
                c3371ak.f3264a = crashDetailBean.f3067j ? "208" : "108";
                break;
            default:
                C3401x.m2253e("crash type error! %d", Integer.valueOf(crashDetailBean.f3059b));
                break;
        }
        c3371ak.f3265b = crashDetailBean.f3075r;
        c3371ak.f3266c = crashDetailBean.f3071n;
        c3371ak.f3267d = crashDetailBean.f3072o;
        c3371ak.f3268e = crashDetailBean.f3073p;
        c3371ak.f3270g = crashDetailBean.f3074q;
        c3371ak.f3271h = crashDetailBean.f3083z;
        c3371ak.f3272i = crashDetailBean.f3060c;
        c3371ak.f3273j = null;
        c3371ak.f3275l = crashDetailBean.f3070m;
        c3371ak.f3276m = crashDetailBean.f3062e;
        c3371ak.f3269f = crashDetailBean.f3035B;
        c3371ak.f3277n = null;
        C3401x.m2251c("libInfo %s", c3371ak.f3278o);
        if (crashDetailBean.f3065h != null && crashDetailBean.f3065h.size() > 0) {
            c3371ak.f3279p = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f3065h.entrySet()) {
                C3368ah c3368ah = new C3368ah();
                c3368ah.f3244a = entry.getValue().f2923a;
                c3368ah.f3245b = entry.getValue().f2925c;
                c3368ah.f3246c = entry.getValue().f2924b;
                c3371ak.f3279p.add(c3368ah);
            }
        }
        if (crashDetailBean.f3067j) {
            c3371ak.f3274k = crashDetailBean.f3077t;
            if (crashDetailBean.f3076s != null && crashDetailBean.f3076s.length() > 0) {
                if (c3371ak.f3280q == null) {
                    c3371ak.f3280q = new ArrayList<>();
                }
                try {
                    c3371ak.f3280q.add(new C3370aj((byte) 1, "alltimes.txt", crashDetailBean.f3076s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    c3371ak.f3280q = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(c3371ak.f3274k);
            objArr[1] = Integer.valueOf(c3371ak.f3280q != null ? c3371ak.f3280q.size() : 0);
            C3401x.m2251c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.f3080w != null) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            try {
                c3371ak.f3280q.add(new C3370aj((byte) 1, "log.txt", crashDetailBean.f3080w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                c3371ak.f3280q = null;
            }
        }
        if (crashDetailBean.f3081x != null) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            try {
                c3371ak.f3280q.add(new C3370aj((byte) 1, "jniLog.txt", crashDetailBean.f3081x.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                c3371ak.f3280q = null;
            }
        }
        if (!C3403z.m2294a(crashDetailBean.f3055V)) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            try {
                c3370aj = new C3370aj((byte) 1, "crashInfos.txt", crashDetailBean.f3055V.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                c3370aj = null;
            }
            if (c3370aj != null) {
                C3401x.m2251c("attach crash infos", new Object[0]);
                c3371ak.f3280q.add(c3370aj);
            }
        }
        if (crashDetailBean.f3056W != null) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            C3370aj m1971a3 = m1971a("backupRecord.zip", context, crashDetailBean.f3056W);
            if (m1971a3 != null) {
                C3401x.m2251c("attach backup record", new Object[0]);
                c3371ak.f3280q.add(m1971a3);
            }
        }
        if (crashDetailBean.f3082y != null && crashDetailBean.f3082y.length > 0) {
            C3370aj c3370aj2 = new C3370aj((byte) 2, "buglylog.zip", crashDetailBean.f3082y);
            C3401x.m2251c("attach user log", new Object[0]);
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            c3371ak.f3280q.add(c3370aj2);
        }
        if (crashDetailBean.f3059b == 3) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            C3401x.m2251c("crashBean.anrMessages:%s", crashDetailBean.f3049P);
            if (crashDetailBean.f3049P != null && crashDetailBean.f3049P.containsKey("BUGLY_CR_01")) {
                try {
                    if (!TextUtils.isEmpty(crashDetailBean.f3049P.get("BUGLY_CR_01"))) {
                        c3371ak.f3280q.add(new C3370aj((byte) 1, "anrMessage.txt", crashDetailBean.f3049P.get("BUGLY_CR_01").getBytes("utf-8")));
                        C3401x.m2251c("attach anr message", new Object[0]);
                    }
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    c3371ak.f3280q = null;
                }
                crashDetailBean.f3049P.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.f3079v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (m1971a2 = m1971a("trace.zip", context, crashDetailBean.f3079v)) != null) {
                C3401x.m2251c("attach traces", new Object[0]);
                c3371ak.f3280q.add(m1971a2);
            }
        }
        if (crashDetailBean.f3059b == 1) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            if (crashDetailBean.f3079v != null && (m1971a = m1971a("tomb.zip", context, crashDetailBean.f3079v)) != null) {
                C3401x.m2251c("attach tombs", new Object[0]);
                c3371ak.f3280q.add(m1971a);
            }
        }
        if (c3337a.f2930D != null && !c3337a.f2930D.isEmpty()) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = c3337a.f2930D.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
            try {
                c3371ak.f3280q.add(new C3370aj((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                C3401x.m2251c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.f3054U != null && crashDetailBean.f3054U.length > 0) {
            if (c3371ak.f3280q == null) {
                c3371ak.f3280q = new ArrayList<>();
            }
            c3371ak.f3280q.add(new C3370aj((byte) 1, "userExtraByteData", crashDetailBean.f3054U));
            C3401x.m2251c("attach extraData", new Object[0]);
        }
        c3371ak.f3281r = new HashMap();
        c3371ak.f3281r.put("A9", new StringBuilder().append(crashDetailBean.f3036C).toString());
        c3371ak.f3281r.put("A11", new StringBuilder().append(crashDetailBean.f3037D).toString());
        c3371ak.f3281r.put("A10", new StringBuilder().append(crashDetailBean.f3038E).toString());
        c3371ak.f3281r.put("A23", crashDetailBean.f3063f);
        c3371ak.f3281r.put("A7", c3337a.f2973g);
        c3371ak.f3281r.put("A6", c3337a.m1886n());
        c3371ak.f3281r.put("A5", c3337a.m1885m());
        c3371ak.f3281r.put("A22", c3337a.m1880h());
        c3371ak.f3281r.put("A2", new StringBuilder().append(crashDetailBean.f3040G).toString());
        c3371ak.f3281r.put("A1", new StringBuilder().append(crashDetailBean.f3039F).toString());
        c3371ak.f3281r.put("A24", c3337a.f2975i);
        c3371ak.f3281r.put("A17", new StringBuilder().append(crashDetailBean.f3041H).toString());
        c3371ak.f3281r.put("A25", c3337a.m1880h());
        c3371ak.f3281r.put("A15", c3337a.m1889q());
        c3371ak.f3281r.put("A13", new StringBuilder().append(c3337a.m1890r()).toString());
        c3371ak.f3281r.put("A34", crashDetailBean.f3034A);
        if (c3337a.f2991y != null) {
            c3371ak.f3281r.put("productIdentify", c3337a.f2991y);
        }
        try {
            c3371ak.f3281r.put("A26", URLEncoder.encode(crashDetailBean.f3042I, "utf-8"));
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.f3059b == 1) {
            c3371ak.f3281r.put("A27", crashDetailBean.f3044K);
            c3371ak.f3281r.put("A28", crashDetailBean.f3043J);
            c3371ak.f3281r.put("A29", new StringBuilder().append(crashDetailBean.f3068k).toString());
        }
        c3371ak.f3281r.put("A30", crashDetailBean.f3045L);
        c3371ak.f3281r.put("A18", new StringBuilder().append(crashDetailBean.f3046M).toString());
        c3371ak.f3281r.put("A36", new StringBuilder().append(!crashDetailBean.f3047N).toString());
        c3371ak.f3281r.put("F02", new StringBuilder().append(c3337a.f2984r).toString());
        c3371ak.f3281r.put("F03", new StringBuilder().append(c3337a.f2985s).toString());
        c3371ak.f3281r.put("F04", c3337a.m1874e());
        c3371ak.f3281r.put("F05", new StringBuilder().append(c3337a.f2986t).toString());
        c3371ak.f3281r.put("F06", c3337a.f2983q);
        c3371ak.f3281r.put("F08", c3337a.f2989w);
        c3371ak.f3281r.put("F09", c3337a.f2990x);
        c3371ak.f3281r.put("F10", new StringBuilder().append(c3337a.f2987u).toString());
        if (crashDetailBean.f3050Q >= 0) {
            c3371ak.f3281r.put("C01", new StringBuilder().append(crashDetailBean.f3050Q).toString());
        }
        if (crashDetailBean.f3051R >= 0) {
            c3371ak.f3281r.put("C02", new StringBuilder().append(crashDetailBean.f3051R).toString());
        }
        if (crashDetailBean.f3052S != null && crashDetailBean.f3052S.size() > 0) {
            for (Map.Entry<String, String> entry2 : crashDetailBean.f3052S.entrySet()) {
                c3371ak.f3281r.put("C03_" + entry2.getKey(), entry2.getValue());
            }
        }
        if (crashDetailBean.f3053T != null && crashDetailBean.f3053T.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.f3053T.entrySet()) {
                c3371ak.f3281r.put("C04_" + entry3.getKey(), entry3.getValue());
            }
        }
        c3371ak.f3282s = null;
        if (crashDetailBean.f3048O != null && crashDetailBean.f3048O.size() > 0) {
            c3371ak.f3282s = crashDetailBean.f3048O;
            C3401x.m2246a("setted message size %d", Integer.valueOf(c3371ak.f3282s.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f3071n;
        objArr2[1] = crashDetailBean.f3060c;
        objArr2[2] = c3337a.m1874e();
        objArr2[3] = Long.valueOf((crashDetailBean.f3075r - crashDetailBean.f3046M) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f3068k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f3047N);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f3067j);
        objArr2[7] = Boolean.valueOf(crashDetailBean.f3059b == 1);
        objArr2[8] = Integer.valueOf(crashDetailBean.f3077t);
        objArr2[9] = crashDetailBean.f3076s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f3061d);
        objArr2[11] = Integer.valueOf(c3371ak.f3281r.size());
        C3401x.m2251c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return c3371ak;
    }

    /* renamed from: a */
    private static C3370aj m1971a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            C3401x.m2252d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C3401x.m2251c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!C3403z.m2292a(file, file2, 5000)) {
            C3401x.m2252d("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            C3401x.m2251c("read bytes :%d", Integer.valueOf(byteArray.length));
            C3370aj c3370aj = new C3370aj((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e) {
                if (!C3401x.m2247a(e)) {
                    e.printStackTrace();
                }
            }
            if (file2.exists()) {
                C3401x.m2251c("del tmp", new Object[0]);
                file2.delete();
            }
            return c3370aj;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        if (!C3401x.m2247a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    C3401x.m2251c("del tmp", new Object[0]);
                    file2.delete();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        if (!C3401x.m2247a(e3)) {
                            e3.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    C3401x.m2251c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    /* renamed from: a */
    public static void m1974a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        C3337a m1855b = C3337a.m1855b();
        if (m1855b == null) {
            return;
        }
        C3401x.m2253e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C3401x.m2253e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C3401x.m2253e("# PKG NAME: %s", m1855b.f2969c);
        C3401x.m2253e("# APP VER: %s", m1855b.f2977k);
        C3401x.m2253e("# SDK VER: %s", m1855b.f2972f);
        C3401x.m2253e("# LAUNCH TIME: %s", C3403z.m2283a(new Date(C3337a.m1855b().f2952a)));
        C3401x.m2253e("# CRASH TYPE: %s", str);
        C3401x.m2253e("# CRASH TIME: %s", str2);
        C3401x.m2253e("# CRASH PROCESS: %s", str3);
        C3401x.m2253e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C3401x.m2253e("# REPORT ID: %s", crashDetailBean.f3060c);
            Object[] objArr = new Object[2];
            objArr[0] = m1855b.f2974h;
            objArr[1] = m1855b.m1890r().booleanValue() ? "ROOTED" : "UNROOT";
            C3401x.m2253e("# CRASH DEVICE: %s %s", objArr);
            C3401x.m2253e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f3036C), Long.valueOf(crashDetailBean.f3037D), Long.valueOf(crashDetailBean.f3038E));
            C3401x.m2253e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f3039F), Long.valueOf(crashDetailBean.f3040G), Long.valueOf(crashDetailBean.f3041H));
            if (!C3403z.m2294a(crashDetailBean.f3044K)) {
                C3401x.m2253e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f3044K, crashDetailBean.f3043J);
            } else if (crashDetailBean.f3059b == 3) {
                Object[] objArr2 = new Object[1];
                objArr2[0] = crashDetailBean.f3049P == null ? "null" : crashDetailBean.f3049P.get("BUGLY_CR_01");
                C3401x.m2253e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!C3403z.m2294a(str5)) {
            C3401x.m2253e("# CRASH STACK: ", new Object[0]);
            C3401x.m2253e(str5, new Object[0]);
        }
        C3401x.m2253e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}