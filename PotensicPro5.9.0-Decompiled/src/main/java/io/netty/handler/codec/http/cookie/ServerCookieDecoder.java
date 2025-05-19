package io.netty.handler.codec.http.cookie;

/* loaded from: classes3.dex */
public final class ServerCookieDecoder extends CookieDecoder {
    private static final String RFC2965_DOMAIN = "$Domain";
    private static final String RFC2965_PATH = "$Path";
    private static final String RFC2965_PORT = "$Port";
    private static final String RFC2965_VERSION = "$Version";
    public static final ServerCookieDecoder STRICT = new ServerCookieDecoder(true);
    public static final ServerCookieDecoder LAX = new ServerCookieDecoder(false);

    private ServerCookieDecoder(boolean z) {
        super(z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0063, code lost:
    
        r10 = -1;
        r11 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x006a, code lost:
    
        r6 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x006c, code lost:
    
        if (r6 != r0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x006e, code lost:
    
        r9 = r2;
        r10 = 0;
        r11 = 0;
        r2 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0073, code lost:
    
        r7 = r14.indexOf(59, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0077, code lost:
    
        if (r7 <= 0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007a, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x007b, code lost:
    
        r9 = r2;
        r10 = r6;
        r2 = r7;
        r11 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008f -> B:9:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0098 -> B:9:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00a0 -> B:9:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a9 -> B:9:0x002f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00ab -> B:9:0x002f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<io.netty.handler.codec.http.cookie.Cookie> decode(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "header"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r14, r0)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.length()
            if (r0 != 0) goto L13
            java.util.Set r14 = java.util.Collections.emptySet()
            return r14
        L13:
            java.util.TreeSet r1 = new java.util.TreeSet
            r1.<init>()
            r3 = 1
            r4 = 0
            r6 = 0
            r7 = 8
            java.lang.String r5 = "$Version"
            r2 = r14
            boolean r2 = r2.regionMatches(r3, r4, r5, r6, r7)
            r3 = 59
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L31
            int r2 = r14.indexOf(r3)
            int r2 = r2 + r4
        L2f:
            r8 = r2
            goto L33
        L31:
            r4 = r5
            r8 = r4
        L33:
            if (r8 != r0) goto L36
            return r1
        L36:
            char r2 = r14.charAt(r8)
            r6 = 9
            if (r2 == r6) goto Laf
            r6 = 10
            if (r2 == r6) goto Laf
            r6 = 11
            if (r2 == r6) goto Laf
            r6 = 12
            if (r2 == r6) goto Laf
            r6 = 13
            if (r2 == r6) goto Laf
            r6 = 32
            if (r2 == r6) goto Laf
            r6 = 44
            if (r2 == r6) goto Laf
            if (r2 != r3) goto L5a
            goto Laf
        L5a:
            r2 = r8
        L5b:
            char r6 = r14.charAt(r2)
            r7 = -1
            if (r6 != r3) goto L66
            r9 = r2
        L63:
            r10 = r7
            r11 = r10
            goto L86
        L66:
            r9 = 61
            if (r6 != r9) goto L80
            int r6 = r2 + 1
            if (r6 != r0) goto L73
            r9 = r2
            r10 = r5
            r11 = r10
            r2 = r6
            goto L86
        L73:
            int r7 = r14.indexOf(r3, r6)
            if (r7 <= 0) goto L7a
            goto L7b
        L7a:
            r7 = r0
        L7b:
            r9 = r2
            r10 = r6
            r2 = r7
            r11 = r2
            goto L86
        L80:
            int r2 = r2 + 1
            if (r2 != r0) goto L5b
            r9 = r0
            goto L63
        L86:
            if (r4 == 0) goto La3
            java.lang.String r6 = "$Path"
            r7 = 5
            boolean r6 = r14.regionMatches(r8, r6, r5, r7)
            if (r6 != 0) goto L2f
            r6 = 7
            java.lang.String r12 = "$Domain"
            boolean r6 = r14.regionMatches(r8, r12, r5, r6)
            if (r6 != 0) goto L2f
            java.lang.String r6 = "$Port"
            boolean r6 = r14.regionMatches(r8, r6, r5, r7)
            if (r6 == 0) goto La3
            goto L2f
        La3:
            r6 = r13
            r7 = r14
            io.netty.handler.codec.http.cookie.DefaultCookie r6 = r6.initCookie(r7, r8, r9, r10, r11)
            if (r6 == 0) goto L2f
            r1.add(r6)
            goto L2f
        Laf:
            int r8 = r8 + 1
            goto L33
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.cookie.ServerCookieDecoder.decode(java.lang.String):java.util.Set");
    }
}
