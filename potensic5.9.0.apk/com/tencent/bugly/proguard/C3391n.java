package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C3337a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: classes3.dex */
public final class C3391n {

    /* renamed from: a */
    public static final long f3391a = System.currentTimeMillis();

    /* renamed from: b */
    private static C3391n f3392b;

    /* renamed from: c */
    private Context f3393c;

    /* renamed from: f */
    private SharedPreferences f3396f;

    /* renamed from: e */
    private Map<Integer, Map<String, C3390m>> f3395e = new HashMap();

    /* renamed from: d */
    private String f3394d = C3337a.m1855b().f2970d;

    private C3391n(Context context) {
        this.f3393c = context;
        this.f3396f = context.getSharedPreferences("crashrecord", 0);
    }

    /* renamed from: a */
    public static synchronized C3391n m2166a(Context context) {
        C3391n c3391n;
        synchronized (C3391n.class) {
            if (f3392b == null) {
                f3392b = new C3391n(context);
            }
            c3391n = f3392b;
        }
        return c3391n;
    }

    /* renamed from: a */
    public static synchronized C3391n m2165a() {
        C3391n c3391n;
        synchronized (C3391n.class) {
            c3391n = f3392b;
        }
        return c3391n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m2172b(int i) {
        try {
            List<C3390m> m2175c = m2175c(i);
            if (m2175c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C3390m c3390m : m2175c) {
                if (c3390m.f3385b != null && c3390m.f3385b.equalsIgnoreCase(this.f3394d) && c3390m.f3387d > 0) {
                    arrayList.add(c3390m);
                }
                if (c3390m.f3386c + 86400000 < currentTimeMillis) {
                    arrayList2.add(c3390m);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((C3390m) arrayList.get(arrayList.size() - 1)).f3386c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                m2175c.clear();
                m2169a(i, (int) m2175c);
                return false;
            }
            m2175c.removeAll(arrayList2);
            m2169a(i, (int) m2175c);
            return false;
        } catch (Exception unused) {
            C3401x.m2253e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    public final void m2176a(int i, final int i2) {
        final int i3 = 1004;
        C3400w.m2238a().m2240a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                C3390m c3390m;
                try {
                    if (TextUtils.isEmpty(C3391n.this.f3394d)) {
                        return;
                    }
                    List<C3390m> m2175c = C3391n.this.m2175c(i3);
                    if (m2175c == null) {
                        m2175c = new ArrayList();
                    }
                    if (C3391n.this.f3395e.get(Integer.valueOf(i3)) == null) {
                        C3391n.this.f3395e.put(Integer.valueOf(i3), new HashMap());
                    }
                    if (((Map) C3391n.this.f3395e.get(Integer.valueOf(i3))).get(C3391n.this.f3394d) != null) {
                        c3390m = (C3390m) ((Map) C3391n.this.f3395e.get(Integer.valueOf(i3))).get(C3391n.this.f3394d);
                        c3390m.f3387d = i2;
                    } else {
                        c3390m = new C3390m();
                        c3390m.f3384a = i3;
                        c3390m.f3390g = C3391n.f3391a;
                        c3390m.f3385b = C3391n.this.f3394d;
                        c3390m.f3389f = C3337a.m1855b().f2977k;
                        c3390m.f3388e = C3337a.m1855b().f2972f;
                        c3390m.f3386c = System.currentTimeMillis();
                        c3390m.f3387d = i2;
                        ((Map) C3391n.this.f3395e.get(Integer.valueOf(i3))).put(C3391n.this.f3394d, c3390m);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (C3390m c3390m2 : m2175c) {
                        if (c3390m2.f3390g == c3390m.f3390g && c3390m2.f3385b != null && c3390m2.f3385b.equalsIgnoreCase(c3390m.f3385b)) {
                            z = true;
                            c3390m2.f3387d = c3390m.f3387d;
                        }
                        if ((c3390m2.f3388e != null && !c3390m2.f3388e.equalsIgnoreCase(c3390m.f3388e)) || ((c3390m2.f3389f != null && !c3390m2.f3389f.equalsIgnoreCase(c3390m.f3389f)) || c3390m2.f3387d <= 0)) {
                            arrayList.add(c3390m2);
                        }
                    }
                    m2175c.removeAll(arrayList);
                    if (!z) {
                        m2175c.add(c3390m);
                    }
                    C3391n.this.m2169a(i3, (int) m2175c);
                } catch (Exception unused) {
                    C3401x.m2253e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0047, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T m2175c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            android.content.Context r3 = r5.f3393c     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r4.<init>()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.StringBuilder r6 = r4.append(r6)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            if (r6 != 0) goto L25
            monitor-exit(r5)
            return r0
        L25:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L3a java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L3a java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L3a java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L3a java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L3e java.io.IOException -> L4c java.lang.Throwable -> L56
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L3e java.io.IOException -> L4c java.lang.Throwable -> L56
            r6.close()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            monitor-exit(r5)
            return r2
        L3a:
            r2 = move-exception
            r6 = r0
            goto L57
        L3d:
            r6 = r0
        L3e:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L56
            com.tencent.bugly.proguard.C3401x.m2246a(r2, r3)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L66
        L47:
            r6.close()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            goto L66
        L4b:
            r6 = r0
        L4c:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L56
            com.tencent.bugly.proguard.C3401x.m2246a(r2, r3)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L66
            goto L47
        L56:
            r2 = move-exception
        L57:
            if (r6 == 0) goto L5c
            r6.close()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
        L5c:
            throw r2     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
        L5d:
            r6 = move-exception
            goto L68
        L5f:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5d
            com.tencent.bugly.proguard.C3401x.m2253e(r6, r1)     // Catch: java.lang.Throwable -> L5d
        L66:
            monitor-exit(r5)
            return r0
        L68:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3391n.m2175c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050 A[Catch: all -> 0x0054, Exception -> 0x0056, TRY_ENTER, TryCatch #4 {Exception -> 0x0056, blocks: (B:8:0x0006, B:14:0x002e, B:21:0x0047, B:27:0x0050, B:28:0x0053), top: B:7:0x0006, outer: #2 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void m2169a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r2 = r4.f3393c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r3 = "crashrecord"
            java.io.File r2 = r2.getDir(r3, r0)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r3.<init>()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.StringBuilder r5 = r3.append(r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r1.<init>(r2, r5)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            r5 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34 java.io.IOException -> L38
            r2.writeObject(r6)     // Catch: java.io.IOException -> L32 java.lang.Throwable -> L4d
            r2.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L32:
            r5 = move-exception
            goto L3b
        L34:
            r6 = move-exception
            r2 = r5
            r5 = r6
            goto L4e
        L38:
            r6 = move-exception
            r2 = r5
            r5 = r6
        L3b:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r5 = "open record file error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L4d
            com.tencent.bugly.proguard.C3401x.m2246a(r5, r6)     // Catch: java.lang.Throwable -> L4d
            if (r2 == 0) goto L4b
            r2.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            goto L5d
        L4b:
            monitor-exit(r4)
            return
        L4d:
            r5 = move-exception
        L4e:
            if (r2 == 0) goto L53
            r2.close()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L53:
            throw r5     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
        L54:
            r5 = move-exception
            goto L5f
        L56:
            java.lang.String r5 = "writeCrashRecord error"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L54
            com.tencent.bugly.proguard.C3401x.m2253e(r5, r6)     // Catch: java.lang.Throwable -> L54
        L5d:
            monitor-exit(r4)
            return
        L5f:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3391n.m2169a(int, java.util.List):void");
    }

    /* renamed from: a */
    public final synchronized boolean m2177a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f3396f.getBoolean(i + "_" + this.f3394d, true);
            C3400w.m2238a().m2240a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    C3391n.this.f3396f.edit().putBoolean(i + "_" + C3391n.this.f3394d, !C3391n.this.m2172b(i)).commit();
                }
            });
        } catch (Exception unused) {
            C3401x.m2253e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}