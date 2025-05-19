package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.hjq.permissions.Permission;

/* loaded from: classes.dex */
final class d {
    static String a(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    static String a(Context context, String str) {
        try {
            return Settings.System.getString(context.getContentResolver(), str);
        } catch (Exception e) {
            a(e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String a(java.io.File r5) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L29 java.lang.Exception -> L2b
            r5 = 8192(0x2000, float:1.148E-41)
            char[] r5 = new char[r5]     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            java.io.CharArrayWriter r2 = new java.io.CharArrayWriter     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            r2.<init>()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
        Lf:
            int r3 = r1.read(r5)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            if (r3 <= 0) goto L1a
            r4 = 0
            r2.write(r5, r4, r3)     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            goto Lf
        L1a:
            java.lang.String r5 = r2.toString()     // Catch: java.lang.Exception -> L27 java.lang.Throwable -> L3b
            r1.close()     // Catch: java.lang.Exception -> L22
            goto L26
        L22:
            r0 = move-exception
            a(r0)
        L26:
            return r5
        L27:
            r5 = move-exception
            goto L2d
        L29:
            r5 = move-exception
            goto L3d
        L2b:
            r5 = move-exception
            r1 = r0
        L2d:
            a(r5)     // Catch: java.lang.Throwable -> L3b
            if (r1 == 0) goto L3a
            r1.close()     // Catch: java.lang.Exception -> L36
            goto L3a
        L36:
            r5 = move-exception
            a(r5)
        L3a:
            return r0
        L3b:
            r5 = move-exception
            r0 = r1
        L3d:
            if (r0 == 0) goto L47
            r0.close()     // Catch: java.lang.Exception -> L43
            goto L47
        L43:
            r0 = move-exception
            a(r0)
        L47:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.bbalbs.common.util.d.a(java.io.File):java.lang.String");
    }

    static void a(Throwable th) {
    }

    static boolean a(Context context, String str, String str2) {
        try {
            return Settings.System.putString(context.getContentResolver(), str, str2);
        } catch (Exception e) {
            a(e);
            return false;
        }
    }

    static boolean a(String str, int i) {
        if (TextUtils.isEmpty(str) || i == 0) {
            return false;
        }
        return str.matches("^[a-zA-Z0-9]{1,5}$");
    }

    static boolean b(Context context) {
        return b(context, Permission.WRITE_SETTINGS);
    }

    static boolean b(Context context, String str) {
        return context != null && context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
