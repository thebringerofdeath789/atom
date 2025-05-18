package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.AbstractC3328a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: classes3.dex */
public final class C3393p {

    /* renamed from: a */
    private static C3393p f3402a = null;

    /* renamed from: b */
    private static C3394q f3403b = null;

    /* renamed from: c */
    private static boolean f3404c = false;

    private C3393p(Context context, List<AbstractC3328a> list) {
        f3403b = new C3394q(context, list);
    }

    /* renamed from: a */
    public static synchronized C3393p m2188a(Context context, List<AbstractC3328a> list) {
        C3393p c3393p;
        synchronized (C3393p.class) {
            if (f3402a == null) {
                f3402a = new C3393p(context, list);
            }
            c3393p = f3402a;
        }
        return c3393p;
    }

    /* renamed from: a */
    public static synchronized C3393p m2187a() {
        C3393p c3393p;
        synchronized (C3393p.class) {
            c3393p = f3402a;
        }
        return c3393p;
    }

    /* renamed from: a */
    public final long m2202a(String str, ContentValues contentValues, InterfaceC3392o interfaceC3392o, boolean z) {
        return m2184a(str, contentValues, (InterfaceC3392o) null);
    }

    /* renamed from: a */
    public final Cursor m2203a(String str, String[] strArr, String str2, String[] strArr2, InterfaceC3392o interfaceC3392o, boolean z) {
        return m2186a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* renamed from: a */
    public final int m2201a(String str, String str2, String[] strArr, InterfaceC3392o interfaceC3392o, boolean z) {
        return m2182a(str, str2, (String[]) null, (InterfaceC3392o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003f, code lost:
    
        if (r9 != null) goto L13;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized long m2184a(java.lang.String r7, android.content.ContentValues r8, com.tencent.bugly.proguard.InterfaceC3392o r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            r0 = 0
            com.tencent.bugly.proguard.q r2 = com.tencent.bugly.proguard.C3393p.f3403b     // Catch: java.lang.Throwable -> L35
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L35
            if (r2 == 0) goto L2d
            if (r8 == 0) goto L2d
            java.lang.String r3 = "_id"
            long r2 = r2.replace(r7, r3, r8)     // Catch: java.lang.Throwable -> L35
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            r4 = 0
            r5 = 1
            if (r8 < 0) goto L23
            java.lang.String r8 = "[Database] insert %s success."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L35
            r5[r4] = r7     // Catch: java.lang.Throwable -> L35
            com.tencent.bugly.proguard.C3401x.m2251c(r8, r5)     // Catch: java.lang.Throwable -> L35
            goto L2c
        L23:
            java.lang.String r8 = "[Database] replace %s error."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L35
            r5[r4] = r7     // Catch: java.lang.Throwable -> L35
            com.tencent.bugly.proguard.C3401x.m2252d(r8, r5)     // Catch: java.lang.Throwable -> L35
        L2c:
            r0 = r2
        L2d:
            if (r9 == 0) goto L42
        L2f:
            java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L33
            goto L42
        L33:
            r7 = move-exception
            goto L4b
        L35:
            r7 = move-exception
            boolean r8 = com.tencent.bugly.proguard.C3401x.m2247a(r7)     // Catch: java.lang.Throwable -> L44
            if (r8 != 0) goto L3f
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L44
        L3f:
            if (r9 == 0) goto L42
            goto L2f
        L42:
            monitor-exit(r6)
            return r0
        L44:
            r7 = move-exception
            if (r9 == 0) goto L4a
            java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L33
        L4a:
            throw r7     // Catch: java.lang.Throwable -> L33
        L4b:
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3393p.m2184a(java.lang.String, android.content.ContentValues, com.tencent.bugly.proguard.o):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Cursor m2186a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, InterfaceC3392o interfaceC3392o) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } finally {
            try {
                return cursor;
            } finally {
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0020, code lost:
    
        if (r6 != null) goto L8;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized int m2182a(java.lang.String r3, java.lang.String r4, java.lang.String[] r5, com.tencent.bugly.proguard.InterfaceC3392o r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            com.tencent.bugly.proguard.q r1 = com.tencent.bugly.proguard.C3393p.f3403b     // Catch: java.lang.Throwable -> L16
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L16
            if (r1 == 0) goto Le
            int r0 = r1.delete(r3, r4, r5)     // Catch: java.lang.Throwable -> L16
        Le:
            if (r6 == 0) goto L23
        L10:
            java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L14
            goto L23
        L14:
            r3 = move-exception
            goto L2c
        L16:
            r3 = move-exception
            boolean r4 = com.tencent.bugly.proguard.C3401x.m2247a(r3)     // Catch: java.lang.Throwable -> L25
            if (r4 != 0) goto L20
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L25
        L20:
            if (r6 == 0) goto L23
            goto L10
        L23:
            monitor-exit(r2)
            return r0
        L25:
            r3 = move-exception
            if (r6 == 0) goto L2b
            java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L14
        L2b:
            throw r3     // Catch: java.lang.Throwable -> L14
        L2c:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3393p.m2182a(java.lang.String, java.lang.String, java.lang.String[], com.tencent.bugly.proguard.o):int");
    }

    /* renamed from: a */
    public final boolean m2207a(int i, String str, byte[] bArr, InterfaceC3392o interfaceC3392o, boolean z) {
        if (!z) {
            a aVar = new a(4, null);
            aVar.m2210a(i, str, bArr);
            C3400w.m2238a().m2240a(aVar);
            return true;
        }
        return m2193a(i, str, bArr, (InterfaceC3392o) null);
    }

    /* renamed from: a */
    public final Map<String, byte[]> m2205a(int i, InterfaceC3392o interfaceC3392o, boolean z) {
        return m2190a(i, (InterfaceC3392o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
    
        if (r8 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
    
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2193a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.InterfaceC3392o r8) {
        /*
            r4 = this;
            r0 = 0
            com.tencent.bugly.proguard.r r1 = new com.tencent.bugly.proguard.r     // Catch: java.lang.Throwable -> L1d
            r1.<init>()     // Catch: java.lang.Throwable -> L1d
            long r2 = (long) r5     // Catch: java.lang.Throwable -> L1d
            r1.f3427a = r2     // Catch: java.lang.Throwable -> L1d
            r1.f3432f = r6     // Catch: java.lang.Throwable -> L1d
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1d
            r1.f3431e = r5     // Catch: java.lang.Throwable -> L1d
            r1.f3433g = r7     // Catch: java.lang.Throwable -> L1d
            boolean r0 = r4.m2197b(r1)     // Catch: java.lang.Throwable -> L1d
            if (r8 == 0) goto L2a
        L19:
            java.lang.Boolean.valueOf(r0)
            goto L2a
        L1d:
            r5 = move-exception
            boolean r6 = com.tencent.bugly.proguard.C3401x.m2247a(r5)     // Catch: java.lang.Throwable -> L2b
            if (r6 != 0) goto L27
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L2b
        L27:
            if (r8 == 0) goto L2a
            goto L19
        L2a:
            return r0
        L2b:
            r5 = move-exception
            if (r8 == 0) goto L31
            java.lang.Boolean.valueOf(r0)
        L31:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3393p.m2193a(int, java.lang.String, byte[], com.tencent.bugly.proguard.o):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, byte[]> m2190a(int i, InterfaceC3392o interfaceC3392o) {
        HashMap hashMap = null;
        try {
            List<C3395r> m2199c = m2199c(i);
            if (m2199c == null) {
                return null;
            }
            HashMap hashMap2 = new HashMap();
            try {
                for (C3395r c3395r : m2199c) {
                    byte[] bArr = c3395r.f3433g;
                    if (bArr != null) {
                        hashMap2.put(c3395r.f3432f, bArr);
                    }
                }
                return hashMap2;
            } catch (Throwable th) {
                th = th;
                hashMap = hashMap2;
                if (C3401x.m2247a(th)) {
                    return hashMap;
                }
                th.printStackTrace();
                return hashMap;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m2208a(C3395r c3395r) {
        ContentValues m2198c;
        if (c3395r == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
            if (writableDatabase == null || (m2198c = m2198c(c3395r)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", m2198c);
            if (replace < 0) {
                return false;
            }
            C3401x.m2251c("[Database] insert %s success.", "t_lr");
            c3395r.f3427a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* renamed from: b */
    private synchronized boolean m2197b(C3395r c3395r) {
        ContentValues m2200d;
        if (c3395r == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
            if (writableDatabase == null || (m2200d = m2200d(c3395r)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", m2200d);
            if (replace < 0) {
                return false;
            }
            C3401x.m2251c("[Database] insert %s success.", "t_pf");
            c3395r.f3427a = replace;
            return true;
        } catch (Throwable th) {
            try {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
                return false;
            } finally {
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ad A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #1 {all -> 0x00b6, blocks: (B:43:0x00a7, B:45:0x00ad), top: B:42:0x00a7, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:11:0x0032, B:37:0x009e, B:48:0x00b2, B:51:0x00b9, B:52:0x00bc, B:43:0x00a7, B:45:0x00ad), top: B:2:0x0001, inners: #1 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.C3395r> m2204a(int r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.C3393p.f3403b     // Catch: java.lang.Throwable -> Lbf
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lbf
            r9 = 0
            if (r0 == 0) goto Lbd
            if (r12 < 0) goto L21
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1d
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L1d
            java.lang.StringBuilder r12 = r1.append(r12)     // Catch: java.lang.Throwable -> L1d
            java.lang.String r12 = r12.toString()     // Catch: java.lang.Throwable -> L1d
            r4 = r12
            goto L22
        L1d:
            r12 = move-exception
            r0 = r9
            goto La7
        L21:
            r4 = r9
        L22:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r12 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L1d
            if (r12 != 0) goto L37
            if (r12 == 0) goto L35
            r12.close()     // Catch: java.lang.Throwable -> Lbf
        L35:
            monitor-exit(r11)
            return r9
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r1.<init>()     // Catch: java.lang.Throwable -> La3
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La3
            r2.<init>()     // Catch: java.lang.Throwable -> La3
        L41:
            boolean r3 = r12.moveToNext()     // Catch: java.lang.Throwable -> La3
            r4 = 0
            if (r3 == 0) goto L74
            com.tencent.bugly.proguard.r r3 = m2189a(r12)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L52
            r2.add(r3)     // Catch: java.lang.Throwable -> La3
            goto L41
        L52:
            java.lang.String r3 = "_id"
            int r3 = r12.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L6c
            long r5 = r12.getLong(r3)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r3 = " or _id"
            java.lang.StringBuilder r3 = r1.append(r3)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r7 = " = "
            java.lang.StringBuilder r3 = r3.append(r7)     // Catch: java.lang.Throwable -> L6c
            r3.append(r5)     // Catch: java.lang.Throwable -> L6c
            goto L41
        L6c:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La3
            com.tencent.bugly.proguard.C3401x.m2252d(r3, r4)     // Catch: java.lang.Throwable -> La3
            goto L41
        L74:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La3
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La3
            if (r3 <= 0) goto L9c
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> La3
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> La3
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La3
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La3
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La3
            r3[r4] = r0     // Catch: java.lang.Throwable -> La3
            com.tencent.bugly.proguard.C3401x.m2252d(r1, r3)     // Catch: java.lang.Throwable -> La3
        L9c:
            if (r12 == 0) goto La1
            r12.close()     // Catch: java.lang.Throwable -> Lbf
        La1:
            monitor-exit(r11)
            return r2
        La3:
            r0 = move-exception
            r10 = r0
            r0 = r12
            r12 = r10
        La7:
            boolean r1 = com.tencent.bugly.proguard.C3401x.m2247a(r12)     // Catch: java.lang.Throwable -> Lb6
            if (r1 != 0) goto Lb0
            r12.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
        Lb0:
            if (r0 == 0) goto Lbd
            r0.close()     // Catch: java.lang.Throwable -> Lbf
            goto Lbd
        Lb6:
            r12 = move-exception
            if (r0 == 0) goto Lbc
            r0.close()     // Catch: java.lang.Throwable -> Lbf
        Lbc:
            throw r12     // Catch: java.lang.Throwable -> Lbf
        Lbd:
            monitor-exit(r11)
            return r9
        Lbf:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3393p.m2204a(int):java.util.List");
    }

    /* renamed from: a */
    public final synchronized void m2206a(List<C3395r> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<C3395r> it = list.iterator();
                    while (it.hasNext()) {
                        sb.append(" or _id").append(" = ").append(it.next().f3427a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    try {
                        C3401x.m2251c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                    } catch (Throwable th) {
                        if (C3401x.m2247a(th)) {
                            return;
                        }
                        th.printStackTrace();
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m2209b(int i) {
        String str;
        SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                try {
                    str = "_tp = " + i;
                } catch (Throwable th) {
                    if (C3401x.m2247a(th)) {
                        return;
                    }
                    th.printStackTrace();
                    return;
                }
            } else {
                str = null;
            }
            C3401x.m2251c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* renamed from: c */
    private static ContentValues m2198c(C3395r c3395r) {
        if (c3395r == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c3395r.f3427a > 0) {
                contentValues.put("_id", Long.valueOf(c3395r.f3427a));
            }
            contentValues.put("_tp", Integer.valueOf(c3395r.f3428b));
            contentValues.put("_pc", c3395r.f3429c);
            contentValues.put("_th", c3395r.f3430d);
            contentValues.put("_tm", Long.valueOf(c3395r.f3431e));
            if (c3395r.f3433g != null) {
                contentValues.put("_dt", c3395r.f3433g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static C3395r m2189a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3395r c3395r = new C3395r();
            c3395r.f3427a = cursor.getLong(cursor.getColumnIndex("_id"));
            c3395r.f3428b = cursor.getInt(cursor.getColumnIndex("_tp"));
            c3395r.f3429c = cursor.getString(cursor.getColumnIndex("_pc"));
            c3395r.f3430d = cursor.getString(cursor.getColumnIndex("_th"));
            c3395r.f3431e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3395r.f3433g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c3395r;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    private synchronized List<C3395r> m2199c(int i) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f3403b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        C3395r m2196b = m2196b(cursor);
                        if (m2196b != null) {
                            arrayList.add(m2196b);
                        } else {
                            try {
                                sb.append(" or _tp").append(" = ").append(cursor.getString(cursor.getColumnIndex("_tp")));
                            } catch (Throwable unused) {
                                C3401x.m2252d("[Database] unknown id.", new Object[0]);
                            }
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id").append(" = ").append(i);
                        C3401x.m2252d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
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
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0074, code lost:
    
        if (r7 != null) goto L14;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m2192a(int r5, java.lang.String r6, com.tencent.bugly.proguard.InterfaceC3392o r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            com.tencent.bugly.proguard.q r1 = com.tencent.bugly.proguard.C3393p.f3403b     // Catch: java.lang.Throwable -> L6a
            android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto L62
            boolean r2 = com.tencent.bugly.proguard.C3403z.m2294a(r6)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L20
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "_id = "
            r6.<init>(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r5 = r6.append(r5)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6a
            goto L45
        L20:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6a
            java.lang.String r3 = "_id = "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r5 = r2.append(r5)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = " and _tp"
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = " = \""
            java.lang.StringBuilder r5 = r5.append(r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = "\""
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L6a
        L45:
            java.lang.String r6 = "t_pf"
            r2 = 0
            int r5 = r1.delete(r6, r5, r2)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r6 = "[Database] deleted %s data %d"
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = "t_pf"
            r1[r0] = r2     // Catch: java.lang.Throwable -> L6a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L6a
            r3 = 1
            r1[r3] = r2     // Catch: java.lang.Throwable -> L6a
            com.tencent.bugly.proguard.C3401x.m2251c(r6, r1)     // Catch: java.lang.Throwable -> L6a
            if (r5 <= 0) goto L62
            r0 = r3
        L62:
            if (r7 == 0) goto L77
        L64:
            java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L68
            goto L77
        L68:
            r5 = move-exception
            goto L80
        L6a:
            r5 = move-exception
            boolean r6 = com.tencent.bugly.proguard.C3401x.m2247a(r5)     // Catch: java.lang.Throwable -> L79
            if (r6 != 0) goto L74
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L79
        L74:
            if (r7 == 0) goto L77
            goto L64
        L77:
            monitor-exit(r4)
            return r0
        L79:
            r5 = move-exception
            if (r7 == 0) goto L7f
            java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L68
        L7f:
            throw r5     // Catch: java.lang.Throwable -> L68
        L80:
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C3393p.m2192a(int, java.lang.String, com.tencent.bugly.proguard.o):boolean");
    }

    /* renamed from: d */
    private static ContentValues m2200d(C3395r c3395r) {
        if (c3395r != null && !C3403z.m2294a(c3395r.f3432f)) {
            try {
                ContentValues contentValues = new ContentValues();
                if (c3395r.f3427a > 0) {
                    contentValues.put("_id", Long.valueOf(c3395r.f3427a));
                }
                contentValues.put("_tp", c3395r.f3432f);
                contentValues.put("_tm", Long.valueOf(c3395r.f3431e));
                if (c3395r.f3433g != null) {
                    contentValues.put("_dt", c3395r.f3433g);
                }
                return contentValues;
            } catch (Throwable th) {
                if (!C3401x.m2247a(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private static C3395r m2196b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C3395r c3395r = new C3395r();
            c3395r.f3427a = cursor.getLong(cursor.getColumnIndex("_id"));
            c3395r.f3431e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c3395r.f3432f = cursor.getString(cursor.getColumnIndex("_tp"));
            c3395r.f3433g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c3395r;
        } catch (Throwable th) {
            if (!C3401x.m2247a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.p$a */
    class a extends Thread {

        /* renamed from: a */
        private int f3405a;

        /* renamed from: b */
        private InterfaceC3392o f3406b;

        /* renamed from: c */
        private String f3407c;

        /* renamed from: d */
        private ContentValues f3408d;

        /* renamed from: e */
        private boolean f3409e;

        /* renamed from: f */
        private String[] f3410f;

        /* renamed from: g */
        private String f3411g;

        /* renamed from: h */
        private String[] f3412h;

        /* renamed from: i */
        private String f3413i;

        /* renamed from: j */
        private String f3414j;

        /* renamed from: k */
        private String f3415k;

        /* renamed from: l */
        private String f3416l;

        /* renamed from: m */
        private String f3417m;

        /* renamed from: n */
        private String[] f3418n;

        /* renamed from: o */
        private int f3419o;

        /* renamed from: p */
        private String f3420p;

        /* renamed from: q */
        private byte[] f3421q;

        public a(int i, InterfaceC3392o interfaceC3392o) {
            this.f3405a = i;
            this.f3406b = interfaceC3392o;
        }

        /* renamed from: a */
        public final void m2211a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f3409e = z;
            this.f3407c = str;
            this.f3410f = strArr;
            this.f3411g = str2;
            this.f3412h = strArr2;
            this.f3413i = str3;
            this.f3414j = str4;
            this.f3415k = str5;
            this.f3416l = str6;
        }

        /* renamed from: a */
        public final void m2210a(int i, String str, byte[] bArr) {
            this.f3419o = i;
            this.f3420p = str;
            this.f3421q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f3405a) {
                case 1:
                    C3393p.this.m2184a(this.f3407c, this.f3408d, this.f3406b);
                    break;
                case 2:
                    C3393p.this.m2182a(this.f3407c, this.f3417m, this.f3418n, this.f3406b);
                    break;
                case 3:
                    Cursor m2186a = C3393p.this.m2186a(this.f3409e, this.f3407c, this.f3410f, this.f3411g, this.f3412h, this.f3413i, this.f3414j, this.f3415k, this.f3416l, this.f3406b);
                    if (m2186a != null) {
                        m2186a.close();
                        break;
                    }
                    break;
                case 4:
                    C3393p.this.m2193a(this.f3419o, this.f3420p, this.f3421q, this.f3406b);
                    break;
                case 5:
                    C3393p.this.m2190a(this.f3419o, this.f3406b);
                    break;
                case 6:
                    C3393p.this.m2192a(this.f3419o, this.f3420p, this.f3406b);
                    break;
            }
        }
    }
}