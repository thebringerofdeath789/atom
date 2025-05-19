package com.baidu.location.f;

import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.h.o;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class l {
    public List<ScanResult> a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public l(List<ScanResult> list, long j) {
        this.a = null;
        this.b = 0L;
        this.c = 0L;
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        try {
            o();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String b(String str) {
        return str != null ? (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str : str;
    }

    private int n() {
        List<ScanResult> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void o() {
        /*
            r7 = this;
            int r0 = r7.n()
            r1 = 1
            if (r0 >= r1) goto L8
            return
        L8:
            java.util.List<android.net.wifi.ScanResult> r0 = r7.a
            int r0 = r0.size()
            int r0 = r0 - r1
            r2 = r1
        L10:
            if (r0 < r1) goto L5e
            if (r2 == 0) goto L5e
            r2 = 0
            r3 = r2
        L16:
            if (r2 >= r0) goto L5a
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r4 = r4.get(r2)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            int r5 = r2 + 1
            java.lang.Object r4 = r4.get(r5)
            if (r4 == 0) goto L57
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r4 = r4.get(r2)
            android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
            int r4 = r4.level
            java.util.List<android.net.wifi.ScanResult> r6 = r7.a
            java.lang.Object r6 = r6.get(r5)
            android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
            int r6 = r6.level
            if (r4 >= r6) goto L57
            java.util.List<android.net.wifi.ScanResult> r3 = r7.a
            java.lang.Object r3 = r3.get(r5)
            android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            java.lang.Object r6 = r4.get(r2)
            r4.set(r5, r6)
            java.util.List<android.net.wifi.ScanResult> r4 = r7.a
            r4.set(r2, r3)
            r3 = r1
        L57:
            int r2 = r2 + 1
            goto L16
        L5a:
            int r0 = r0 + (-1)
            r2 = r3
            goto L10
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.l.o():void");
    }

    public int a() {
        List<ScanResult> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String a(int i) {
        return a(i, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0293 A[Catch: Exception -> 0x005e, Error -> 0x0397, TryCatch #2 {Exception -> 0x005e, blocks: (B:199:0x0055, B:25:0x0077, B:27:0x007f, B:34:0x00a1, B:36:0x00a9, B:113:0x00d5, B:40:0x00e7, B:104:0x0114, B:44:0x0119, B:45:0x0124, B:47:0x0130, B:50:0x0144, B:52:0x015d, B:54:0x0165, B:69:0x021b, B:86:0x01fa, B:91:0x0121, B:126:0x022b, B:128:0x0233, B:130:0x023d, B:136:0x024c, B:137:0x0256, B:139:0x0262, B:142:0x0276, B:143:0x0289, B:148:0x0253, B:134:0x028e, B:152:0x0293, B:154:0x02ad, B:158:0x02be, B:161:0x02da, B:163:0x02e0, B:165:0x02f1, B:166:0x0309, B:168:0x030f, B:170:0x0317, B:172:0x0345, B:173:0x0322, B:175:0x0331, B:179:0x0349, B:180:0x0352, B:182:0x0372, B:185:0x0381, B:188:0x0386, B:189:0x0390), top: B:198:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0395 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007f A[Catch: Exception -> 0x005e, Error -> 0x0397, TRY_LEAVE, TryCatch #2 {Exception -> 0x005e, blocks: (B:199:0x0055, B:25:0x0077, B:27:0x007f, B:34:0x00a1, B:36:0x00a9, B:113:0x00d5, B:40:0x00e7, B:104:0x0114, B:44:0x0119, B:45:0x0124, B:47:0x0130, B:50:0x0144, B:52:0x015d, B:54:0x0165, B:69:0x021b, B:86:0x01fa, B:91:0x0121, B:126:0x022b, B:128:0x0233, B:130:0x023d, B:136:0x024c, B:137:0x0256, B:139:0x0262, B:142:0x0276, B:143:0x0289, B:148:0x0253, B:134:0x028e, B:152:0x0293, B:154:0x02ad, B:158:0x02be, B:161:0x02da, B:163:0x02e0, B:165:0x02f1, B:166:0x0309, B:168:0x030f, B:170:0x0317, B:172:0x0345, B:173:0x0322, B:175:0x0331, B:179:0x0349, B:180:0x0352, B:182:0x0372, B:185:0x0381, B:188:0x0386, B:189:0x0390), top: B:198:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0119 A[Catch: Exception -> 0x005e, Error -> 0x0397, TryCatch #2 {Exception -> 0x005e, blocks: (B:199:0x0055, B:25:0x0077, B:27:0x007f, B:34:0x00a1, B:36:0x00a9, B:113:0x00d5, B:40:0x00e7, B:104:0x0114, B:44:0x0119, B:45:0x0124, B:47:0x0130, B:50:0x0144, B:52:0x015d, B:54:0x0165, B:69:0x021b, B:86:0x01fa, B:91:0x0121, B:126:0x022b, B:128:0x0233, B:130:0x023d, B:136:0x024c, B:137:0x0256, B:139:0x0262, B:142:0x0276, B:143:0x0289, B:148:0x0253, B:134:0x028e, B:152:0x0293, B:154:0x02ad, B:158:0x02be, B:161:0x02da, B:163:0x02e0, B:165:0x02f1, B:166:0x0309, B:168:0x030f, B:170:0x0317, B:172:0x0345, B:173:0x0322, B:175:0x0331, B:179:0x0349, B:180:0x0352, B:182:0x0372, B:185:0x0381, B:188:0x0386, B:189:0x0390), top: B:198:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0130 A[Catch: Exception -> 0x005e, Error -> 0x0397, TryCatch #2 {Exception -> 0x005e, blocks: (B:199:0x0055, B:25:0x0077, B:27:0x007f, B:34:0x00a1, B:36:0x00a9, B:113:0x00d5, B:40:0x00e7, B:104:0x0114, B:44:0x0119, B:45:0x0124, B:47:0x0130, B:50:0x0144, B:52:0x015d, B:54:0x0165, B:69:0x021b, B:86:0x01fa, B:91:0x0121, B:126:0x022b, B:128:0x0233, B:130:0x023d, B:136:0x024c, B:137:0x0256, B:139:0x0262, B:142:0x0276, B:143:0x0289, B:148:0x0253, B:134:0x028e, B:152:0x0293, B:154:0x02ad, B:158:0x02be, B:161:0x02da, B:163:0x02e0, B:165:0x02f1, B:166:0x0309, B:168:0x030f, B:170:0x0317, B:172:0x0345, B:173:0x0322, B:175:0x0331, B:179:0x0349, B:180:0x0352, B:182:0x0372, B:185:0x0381, B:188:0x0386, B:189:0x0390), top: B:198:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0121 A[Catch: Exception -> 0x005e, Error -> 0x0397, TryCatch #2 {Exception -> 0x005e, blocks: (B:199:0x0055, B:25:0x0077, B:27:0x007f, B:34:0x00a1, B:36:0x00a9, B:113:0x00d5, B:40:0x00e7, B:104:0x0114, B:44:0x0119, B:45:0x0124, B:47:0x0130, B:50:0x0144, B:52:0x015d, B:54:0x0165, B:69:0x021b, B:86:0x01fa, B:91:0x0121, B:126:0x022b, B:128:0x0233, B:130:0x023d, B:136:0x024c, B:137:0x0256, B:139:0x0262, B:142:0x0276, B:143:0x0289, B:148:0x0253, B:134:0x028e, B:152:0x0293, B:154:0x02ad, B:158:0x02be, B:161:0x02da, B:163:0x02e0, B:165:0x02f1, B:166:0x0309, B:168:0x030f, B:170:0x0317, B:172:0x0345, B:173:0x0322, B:175:0x0331, B:179:0x0349, B:180:0x0352, B:182:0x0372, B:185:0x0381, B:188:0x0386, B:189:0x0390), top: B:198:0x0055 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(int r32, boolean r33, boolean r34) {
        /*
            Method dump skipped, instructions count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.l.a(int, boolean, boolean):java.lang.String");
    }

    public boolean a(long j) {
        long j2;
        boolean z;
        List<ScanResult> list;
        long j3;
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                j2 = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error | Exception unused) {
                j2 = 0;
            }
            z = j2 > 0;
        } else {
            z = false;
            j2 = 0;
        }
        if (!z || (list = this.a) == null || list.size() == 0) {
            return false;
        }
        int size = this.a.size();
        if (size > 16) {
            size = 16;
        }
        long j4 = 0;
        long j5 = 0;
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null && this.a.get(i).level != 0 && z) {
                try {
                    j3 = (j2 - this.a.get(i).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j3 = 0;
                }
                j4 += j3;
                if (j3 > j5) {
                    j5 = j3;
                }
            }
        }
        return j5 * 1000 > j || (j4 / ((long) size)) * 1000 > j;
    }

    public boolean a(l lVar) {
        List<ScanResult> list = this.a;
        if (list == null || lVar == null || lVar.a == null) {
            return false;
        }
        int size = (list.size() < lVar.a.size() ? this.a : lVar.a).size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null) {
                String str = this.a.get(i).BSSID;
                String str2 = lVar.a.get(i).BSSID;
                if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String b() {
        try {
            return a(o.N, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(int i) {
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.a.size();
        if (size <= i) {
            i = size;
        }
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            if (this.a.get(i2) != null && this.a.get(i2).level != 0 && this.a.get(i2).BSSID != null) {
                if (z) {
                    z = false;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(this.a.get(i2).BSSID.replace(":", ""));
                int i3 = this.a.get(i2).level;
                if (i3 < 0) {
                    i3 = -i3;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i3)));
            }
        }
        if (z) {
            return null;
        }
        return stringBuffer.toString();
    }

    public boolean b(l lVar) {
        List<ScanResult> list = this.a;
        if (list == null || lVar == null || lVar.a == null) {
            return false;
        }
        int size = (list.size() < lVar.a.size() ? this.a : lVar.a).size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null) {
                String str = this.a.get(i).BSSID;
                int i2 = this.a.get(i).level;
                String str2 = lVar.a.get(i).BSSID;
                int i3 = lVar.a.get(i).level;
                if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                    return false;
                }
            }
        }
        return true;
    }

    public String c() {
        try {
            return a(o.N, true, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public String c(int i) {
        if (i == 0) {
            return null;
        }
        int i2 = 1;
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.a.size();
        if (size > o.N) {
            size = o.N;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            if (this.a.get(i4) != null) {
                if ((i2 & i) != 0 && this.a.get(i4).BSSID != null) {
                    stringBuffer.append(i3 == 0 ? "&ssid=" : "|");
                    stringBuffer.append(this.a.get(i4).BSSID.replace(":", ""));
                    stringBuffer.append(";");
                    stringBuffer.append(b(this.a.get(i4).SSID));
                    i3++;
                }
                i2 <<= 1;
            }
        }
        return stringBuffer.toString();
    }

    public boolean c(l lVar) {
        return m.a(lVar, this);
    }

    public String d() {
        try {
            return a(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean e() {
        return a(o.af);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long f() {
        /*
            r13 = this;
            java.util.List<android.net.wifi.ScanResult> r0 = r13.a
            r1 = 0
            if (r0 == 0) goto L74
            int r0 = r0.size()
            if (r0 != 0) goto Le
            goto L74
        Le:
            r3 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            r6 = 0
            if (r0 < r5) goto L27
            long r7 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L20
            r9 = 1000(0x3e8, double:4.94E-321)
            long r7 = r7 / r9
            goto L21
        L20:
            r7 = r1
        L21:
            int r0 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r0 <= 0) goto L28
            r0 = 1
            goto L29
        L27:
            r7 = r1
        L28:
            r0 = r6
        L29:
            if (r0 != 0) goto L2c
            return r1
        L2c:
            java.util.List<android.net.wifi.ScanResult> r5 = r13.a
            int r5 = r5.size()
            r9 = 16
            if (r5 <= r9) goto L37
            r5 = r9
        L37:
            if (r6 >= r5) goto L6a
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a
            java.lang.Object r9 = r9.get(r6)
            if (r9 == 0) goto L67
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a
            java.lang.Object r9 = r9.get(r6)
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9
            int r9 = r9.level
            if (r9 != 0) goto L4e
            goto L67
        L4e:
            if (r0 == 0) goto L67
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a     // Catch: java.lang.Throwable -> L61
            java.lang.Object r9 = r9.get(r6)     // Catch: java.lang.Throwable -> L61
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9     // Catch: java.lang.Throwable -> L61
            long r9 = r9.timestamp     // Catch: java.lang.Throwable -> L61
            long r9 = r7 - r9
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r9 / r11
            goto L62
        L61:
            r9 = r1
        L62:
            int r11 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r11 >= 0) goto L67
            r3 = r9
        L67:
            int r6 = r6 + 1
            goto L37
        L6a:
            if (r0 == 0) goto L6d
            goto L6e
        L6d:
            r3 = r1
        L6e:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L73
            goto L74
        L73:
            r1 = r3
        L74:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.l.f():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long g() {
        /*
            r13 = this;
            java.util.List<android.net.wifi.ScanResult> r0 = r13.a
            r1 = 0
            if (r0 == 0) goto L68
            int r0 = r0.size()
            if (r0 != 0) goto Ld
            goto L68
        Ld:
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            r4 = 0
            if (r0 < r3) goto L23
            long r5 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L1c
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 / r7
            goto L1d
        L1c:
            r5 = r1
        L1d:
            int r0 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r0 <= 0) goto L24
            r0 = 1
            goto L25
        L23:
            r5 = r1
        L24:
            r0 = r4
        L25:
            if (r0 != 0) goto L28
            return r1
        L28:
            java.util.List<android.net.wifi.ScanResult> r3 = r13.a
            int r3 = r3.size()
            r7 = 16
            if (r3 <= r7) goto L33
            r3 = r7
        L33:
            r7 = r1
        L34:
            if (r4 >= r3) goto L67
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a
            java.lang.Object r9 = r9.get(r4)
            if (r9 == 0) goto L64
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a
            java.lang.Object r9 = r9.get(r4)
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9
            int r9 = r9.level
            if (r9 != 0) goto L4b
            goto L64
        L4b:
            if (r0 == 0) goto L64
            java.util.List<android.net.wifi.ScanResult> r9 = r13.a     // Catch: java.lang.Throwable -> L5e
            java.lang.Object r9 = r9.get(r4)     // Catch: java.lang.Throwable -> L5e
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) r9     // Catch: java.lang.Throwable -> L5e
            long r9 = r9.timestamp     // Catch: java.lang.Throwable -> L5e
            long r9 = r5 - r9
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r9 / r11
            goto L5f
        L5e:
            r9 = r1
        L5f:
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 <= 0) goto L64
            r7 = r9
        L64:
            int r4 = r4 + 1
            goto L34
        L67:
            return r7
        L68:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.l.g():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long h() {
        /*
            r18 = this;
            r0 = r18
            java.util.List<android.net.wifi.ScanResult> r1 = r0.a
            r2 = 0
            if (r1 == 0) goto L7d
            int r1 = r1.size()
            if (r1 != 0) goto L10
            goto L7d
        L10:
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            r5 = 0
            if (r1 < r4) goto L26
            long r6 = android.os.SystemClock.elapsedRealtimeNanos()     // Catch: java.lang.Throwable -> L1f
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            goto L20
        L1f:
            r6 = r2
        L20:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L27
            r1 = 1
            goto L28
        L26:
            r6 = r2
        L27:
            r1 = r5
        L28:
            if (r1 != 0) goto L2b
            return r2
        L2b:
            java.util.List<android.net.wifi.ScanResult> r4 = r0.a
            int r4 = r4.size()
            r8 = 16
            if (r4 <= r8) goto L36
            r4 = r8
        L36:
            r8 = r2
            r10 = r8
            r12 = r10
        L39:
            r14 = 1
            if (r5 >= r4) goto L74
            java.util.List<android.net.wifi.ScanResult> r2 = r0.a
            java.lang.Object r2 = r2.get(r5)
            if (r2 == 0) goto L6f
            java.util.List<android.net.wifi.ScanResult> r2 = r0.a
            java.lang.Object r2 = r2.get(r5)
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2
            int r2 = r2.level
            if (r2 != 0) goto L52
            goto L6f
        L52:
            if (r1 == 0) goto L6f
            java.util.List<android.net.wifi.ScanResult> r2 = r0.a     // Catch: java.lang.Throwable -> L66
            java.lang.Object r2 = r2.get(r5)     // Catch: java.lang.Throwable -> L66
            android.net.wifi.ScanResult r2 = (android.net.wifi.ScanResult) r2     // Catch: java.lang.Throwable -> L66
            long r2 = r2.timestamp     // Catch: java.lang.Throwable -> L66
            long r2 = r6 - r2
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r2 / r16
            goto L68
        L66:
            r2 = 0
        L68:
            long r12 = r12 + r2
            long r8 = r8 + r14
            int r14 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r14 <= 0) goto L6f
            r10 = r2
        L6f:
            int r5 = r5 + 1
            r2 = 0
            goto L39
        L74:
            int r1 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r1 <= 0) goto L7c
            long r12 = r12 - r10
            long r8 = r8 - r14
            long r10 = r12 / r8
        L7c:
            return r10
        L7d:
            r1 = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.f.l.h():long");
    }

    public int i() {
        int i;
        for (int i2 = 0; i2 < a(); i2++) {
            if (this.a.get(i2) != null && (i = -this.a.get(i2).level) > 0) {
                return i;
            }
        }
        return 0;
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean l() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean m() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
