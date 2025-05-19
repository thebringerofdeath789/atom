package org.apache.commons.text.lookup;

/* loaded from: classes4.dex */
final class LocalHostStringLookup extends AbstractStringLookup {
    static final LocalHostStringLookup INSTANCE = new LocalHostStringLookup();

    private LocalHostStringLookup() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r1 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003c, code lost:
    
        if (r1 != 2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
    
        return java.net.InetAddress.getLocalHost().getHostAddress();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        throw new java.lang.IllegalArgumentException(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0055, code lost:
    
        return java.net.InetAddress.getLocalHost().getCanonicalHostName();
     */
    @Override // org.apache.commons.text.lookup.StringLookup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String lookup(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L4
            return r0
        L4:
            r1 = -1
            int r2 = r7.hashCode()     // Catch: java.net.UnknownHostException -> L5f
            r3 = -1147692044(0xffffffffbb979bf4, float:-0.0046267454)
            r4 = 2
            r5 = 1
            if (r2 == r3) goto L2f
            r3 = 3373707(0x337a8b, float:4.72757E-39)
            if (r2 == r3) goto L25
            r3 = 1339224004(0x4fd2efc4, float:7.0778573E9)
            if (r2 == r3) goto L1b
            goto L38
        L1b:
            java.lang.String r2 = "canonical-name"
            boolean r2 = r7.equals(r2)     // Catch: java.net.UnknownHostException -> L5f
            if (r2 == 0) goto L38
            r1 = r5
            goto L38
        L25:
            java.lang.String r2 = "name"
            boolean r2 = r7.equals(r2)     // Catch: java.net.UnknownHostException -> L5f
            if (r2 == 0) goto L38
            r1 = 0
            goto L38
        L2f:
            java.lang.String r2 = "address"
            boolean r2 = r7.equals(r2)     // Catch: java.net.UnknownHostException -> L5f
            if (r2 == 0) goto L38
            r1 = r4
        L38:
            if (r1 == 0) goto L56
            if (r1 == r5) goto L4d
            if (r1 != r4) goto L47
            java.net.InetAddress r7 = java.net.InetAddress.getLocalHost()     // Catch: java.net.UnknownHostException -> L5f
            java.lang.String r7 = r7.getHostAddress()     // Catch: java.net.UnknownHostException -> L5f
            return r7
        L47:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch: java.net.UnknownHostException -> L5f
            r1.<init>(r7)     // Catch: java.net.UnknownHostException -> L5f
            throw r1     // Catch: java.net.UnknownHostException -> L5f
        L4d:
            java.net.InetAddress r7 = java.net.InetAddress.getLocalHost()     // Catch: java.net.UnknownHostException -> L5f
            java.lang.String r7 = r7.getCanonicalHostName()     // Catch: java.net.UnknownHostException -> L5f
            return r7
        L56:
            java.net.InetAddress r7 = java.net.InetAddress.getLocalHost()     // Catch: java.net.UnknownHostException -> L5f
            java.lang.String r7 = r7.getHostName()     // Catch: java.net.UnknownHostException -> L5f
            return r7
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.text.lookup.LocalHostStringLookup.lookup(java.lang.String):java.lang.String");
    }
}
