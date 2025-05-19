package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes3.dex */
public final class n {
    public static final long a = System.currentTimeMillis();
    private static n b;
    private Context c;
    private SharedPreferences f;
    private Map<Integer, Map<String, m>> e = new HashMap();
    private String d = com.tencent.bugly.crashreport.common.info.a.b().d;

    private n(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (b == null) {
                b = new n(context);
            }
            nVar = b;
        }
        return nVar;
    }

    public static synchronized n a() {
        n nVar;
        synchronized (n.class) {
            nVar = b;
        }
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean b(int i) {
        try {
            List<m> c = c(i);
            if (c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (m mVar : c) {
                if (mVar.b != null && mVar.b.equalsIgnoreCase(this.d) && mVar.d > 0) {
                    arrayList.add(mVar);
                }
                if (mVar.c + 86400000 < currentTimeMillis) {
                    arrayList2.add(mVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((m) arrayList.get(arrayList.size() - 1)).c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                c.clear();
                a(i, (int) c);
                return false;
            }
            c.removeAll(arrayList2);
            a(i, (int) c);
            return false;
        } catch (Exception unused) {
            x.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final void a(int i, final int i2) {
        final int i3 = 1004;
        w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                m mVar;
                try {
                    if (TextUtils.isEmpty(n.this.d)) {
                        return;
                    }
                    List<m> c = n.this.c(i3);
                    if (c == null) {
                        c = new ArrayList();
                    }
                    if (n.this.e.get(Integer.valueOf(i3)) == null) {
                        n.this.e.put(Integer.valueOf(i3), new HashMap());
                    }
                    if (((Map) n.this.e.get(Integer.valueOf(i3))).get(n.this.d) != null) {
                        mVar = (m) ((Map) n.this.e.get(Integer.valueOf(i3))).get(n.this.d);
                        mVar.d = i2;
                    } else {
                        mVar = new m();
                        mVar.a = i3;
                        mVar.g = n.a;
                        mVar.b = n.this.d;
                        mVar.f = com.tencent.bugly.crashreport.common.info.a.b().k;
                        mVar.e = com.tencent.bugly.crashreport.common.info.a.b().f;
                        mVar.c = System.currentTimeMillis();
                        mVar.d = i2;
                        ((Map) n.this.e.get(Integer.valueOf(i3))).put(n.this.d, mVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (m mVar2 : c) {
                        if (mVar2.g == mVar.g && mVar2.b != null && mVar2.b.equalsIgnoreCase(mVar.b)) {
                            z = true;
                            mVar2.d = mVar.d;
                        }
                        if ((mVar2.e != null && !mVar2.e.equalsIgnoreCase(mVar.e)) || ((mVar2.f != null && !mVar2.f.equalsIgnoreCase(mVar.f)) || mVar2.d <= 0)) {
                            arrayList.add(mVar2);
                        }
                    }
                    c.removeAll(arrayList);
                    if (!z) {
                        c.add(mVar);
                    }
                    n.this.a(i3, (int) c);
                } catch (Exception unused) {
                    x.e("saveCrashRecord failed", new Object[0]);
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            android.content.Context r3 = r5.c     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
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
            com.tencent.bugly.proguard.x.a(r2, r3)     // Catch: java.lang.Throwable -> L56
            if (r6 == 0) goto L66
        L47:
            r6.close()     // Catch: java.lang.Throwable -> L5d java.lang.Exception -> L5f
            goto L66
        L4b:
            r6 = r0
        L4c:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L56
            com.tencent.bugly.proguard.x.a(r2, r3)     // Catch: java.lang.Throwable -> L56
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
            com.tencent.bugly.proguard.x.e(r6, r1)     // Catch: java.lang.Throwable -> L5d
        L66:
            monitor-exit(r5)
            return r0
        L68:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050 A[Catch: all -> 0x0054, Exception -> 0x0056, TRY_ENTER, TryCatch #4 {Exception -> 0x0056, blocks: (B:8:0x0006, B:14:0x002e, B:21:0x0047, B:27:0x0050, B:28:0x0053), top: B:7:0x0006, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> void a(int r5, T r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r6 != 0) goto L5
            monitor-exit(r4)
            return
        L5:
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
            android.content.Context r2 = r4.c     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L56
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
            com.tencent.bugly.proguard.x.a(r5, r6)     // Catch: java.lang.Throwable -> L4d
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
            com.tencent.bugly.proguard.x.e(r5, r6)     // Catch: java.lang.Throwable -> L54
        L5d:
            monitor-exit(r4)
            return
        L5f:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.n.a(int, java.util.List):void");
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f.getBoolean(i + "_" + this.d, true);
            w.a().a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    n.this.f.edit().putBoolean(i + "_" + n.this.d, !n.this.b(i)).commit();
                }
            });
        } catch (Exception unused) {
            x.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
