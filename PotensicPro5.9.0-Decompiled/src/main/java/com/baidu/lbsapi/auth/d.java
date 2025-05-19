package com.baidu.lbsapi.auth;

import android.content.Context;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Locale;

/* compiled from: Cert.java */
/* loaded from: classes.dex */
class d {
    protected static String a(Context context) {
        String packageName = context.getPackageName();
        return a(context, packageName) + ";" + packageName;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00aa A[LOOP:0: B:11:0x00aa->B:21:0x00ca, LOOP_START, PHI: r1
  0x00aa: PHI (r1v1 int) = (r1v0 int), (r1v2 int) binds: [B:10:0x00a8, B:21:0x00ca] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "getFingerPrint："
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            r3 = 28
            r4 = 64
            if (r2 < r3) goto L48
            android.content.pm.PackageManager r2 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            r3 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.SigningInfo r2 = r2.signingInfo     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            if (r2 != 0) goto L24
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            goto L52
        L24:
            boolean r2 = r2.hasMultipleSigners()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            if (r2 == 0) goto L39
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.SigningInfo r5 = r5.signingInfo     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.Signature[] r5 = r5.getApkContentsSigners()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            goto L52
        L39:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r3)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.SigningInfo r5 = r5.signingInfo     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.Signature[] r5 = r5.getSigningCertificateHistory()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            goto L52
        L48:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r6, r4)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            android.content.pm.Signature[] r5 = r5.signatures     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
        L52:
            java.lang.String r6 = "X.509"
            java.security.cert.CertificateFactory r6 = java.security.cert.CertificateFactory.getInstance(r6)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            r5 = r5[r1]     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            byte[] r5 = r5.toByteArray()     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            r2.<init>(r5)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            java.security.cert.Certificate r5 = r6.generateCertificate(r2)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            java.security.cert.X509Certificate r5 = (java.security.cert.X509Certificate) r5     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            java.lang.String r5 = a(r5)     // Catch: java.security.cert.CertificateException -> L6e android.content.pm.PackageManager.NameNotFoundException -> L88
            goto La3
        L6e:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            com.baidu.lbsapi.auth.b.a(r5)
            goto La1
        L88:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r5 = r5.toString()
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r5 = r5.toString()
            com.baidu.lbsapi.auth.b.a(r5)
        La1:
            java.lang.String r5 = ""
        La3:
            java.lang.StringBuffer r6 = new java.lang.StringBuffer
            r6.<init>()
            if (r5 == 0) goto Lcd
        Laa:
            int r0 = r5.length()
            if (r1 >= r0) goto Lcd
            char r0 = r5.charAt(r1)
            r6.append(r0)
            if (r1 <= 0) goto Lca
            int r0 = r1 % 2
            r2 = 1
            if (r0 != r2) goto Lca
            int r0 = r5.length()
            int r0 = r0 - r2
            if (r1 >= r0) goto Lca
            java.lang.String r0 = ":"
            r6.append(r0)
        Lca:
            int r1 = r1 + 1
            goto Laa
        Lcd:
            java.lang.String r5 = r6.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.a(android.content.Context, java.lang.String):java.lang.String");
    }

    protected static String[] b(Context context) {
        String packageName = context.getPackageName();
        String[] b = b(context, packageName);
        if (b == null || b.length <= 0) {
            return null;
        }
        int length = b.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = b[i] + ";" + packageName;
            if (b.a) {
                b.a("mcode" + strArr[i]);
            }
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String[] b(android.content.Context r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.lbsapi.auth.d.b(android.content.Context, java.lang.String):java.lang.String[]");
    }

    static String a(X509Certificate x509Certificate) {
        try {
            return a.a(a(x509Certificate.getEncoded()));
        } catch (CertificateEncodingException e) {
            b.a("getFingerprintAs：" + e.toString());
            return null;
        }
    }

    static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA1").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            b.a("generateSHA1：" + e.toString());
            return null;
        }
    }

    /* compiled from: Cert.java */
    static class a {
        public static String a(byte[] bArr) {
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuilder sb = new StringBuilder(bArr.length * 2);
            for (int i = 0; i < bArr.length; i++) {
                sb.append(cArr[(bArr[i] & 240) >> 4]);
                sb.append(cArr[bArr[i] & 15]);
            }
            return sb.toString();
        }
    }

    static String a() {
        return Locale.getDefault().getLanguage();
    }
}
