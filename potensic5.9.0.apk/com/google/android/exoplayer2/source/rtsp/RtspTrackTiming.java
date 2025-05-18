package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;

/* loaded from: classes.dex */
final class RtspTrackTiming {
    public final long rtpTimestamp;
    public final int sequenceNumber;
    public final Uri uri;

    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0082 A[Catch: Exception -> 0x008f, TRY_LEAVE, TryCatch #0 {Exception -> 0x008f, blocks: (B:7:0x0027, B:19:0x0072, B:23:0x0077, B:24:0x007c, B:27:0x007d, B:29:0x0082, B:32:0x004b, B:35:0x0055, B:38:0x0060), top: B:6:0x0027 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.common.collect.ImmutableList<com.google.android.exoplayer2.source.rtsp.RtspTrackTiming> parseTrackTiming(java.lang.String r18) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.common.collect.ImmutableList$Builder r0 = new com.google.common.collect.ImmutableList$Builder
            r0.<init>()
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = com.google.android.exoplayer2.util.Util.split(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L10:
            if (r4 >= r2) goto Lc5
            r5 = r1[r4]
            r6 = 0
            java.lang.String r7 = ";"
            java.lang.String[] r7 = com.google.android.exoplayer2.util.Util.split(r5, r7)
            int r8 = r7.length
            r12 = r3
            r13 = -1
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L23:
            if (r12 >= r8) goto L96
            r9 = r7[r12]
            java.lang.String r10 = "="
            java.lang.String[] r10 = com.google.android.exoplayer2.util.Util.splitAtFirst(r9, r10)     // Catch: java.lang.Exception -> L8f
            r11 = r10[r3]     // Catch: java.lang.Exception -> L8f
            r3 = 1
            r10 = r10[r3]     // Catch: java.lang.Exception -> L8f
            int r3 = r11.hashCode()     // Catch: java.lang.Exception -> L8f
            r16 = r1
            r1 = 113759(0x1bc5f, float:1.5941E-40)
            r17 = r2
            r2 = 2
            if (r3 == r1) goto L60
            r1 = 116079(0x1c56f, float:1.62661E-40)
            if (r3 == r1) goto L55
            r1 = 1524180539(0x5ad9263b, float:3.0561052E16)
            if (r3 == r1) goto L4b
            goto L6a
        L4b:
            java.lang.String r1 = "rtptime"
            boolean r1 = r11.equals(r1)     // Catch: java.lang.Exception -> L8f
            if (r1 == 0) goto L6a
            r1 = r2
            goto L6b
        L55:
            java.lang.String r1 = "url"
            boolean r1 = r11.equals(r1)     // Catch: java.lang.Exception -> L8f
            if (r1 == 0) goto L6a
            r1 = 0
            goto L6b
        L60:
            java.lang.String r1 = "seq"
            boolean r1 = r11.equals(r1)     // Catch: java.lang.Exception -> L8f
            if (r1 == 0) goto L6a
            r1 = 1
            goto L6b
        L6a:
            r1 = -1
        L6b:
            if (r1 == 0) goto L82
            r3 = 1
            if (r1 == r3) goto L7d
            if (r1 != r2) goto L77
            long r14 = java.lang.Long.parseLong(r10)     // Catch: java.lang.Exception -> L8f
            goto L87
        L77:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException     // Catch: java.lang.Exception -> L8f
            r0.<init>()     // Catch: java.lang.Exception -> L8f
            throw r0     // Catch: java.lang.Exception -> L8f
        L7d:
            int r13 = java.lang.Integer.parseInt(r10)     // Catch: java.lang.Exception -> L8f
            goto L87
        L82:
            android.net.Uri r1 = android.net.Uri.parse(r10)     // Catch: java.lang.Exception -> L8f
            r6 = r1
        L87:
            int r12 = r12 + 1
            r1 = r16
            r2 = r17
            r3 = 0
            goto L23
        L8f:
            r0 = move-exception
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            r1.<init>(r9, r0)
            throw r1
        L96:
            r16 = r1
            r17 = r2
            if (r6 == 0) goto Lbf
            java.lang.String r1 = r6.getScheme()
            if (r1 == 0) goto Lbf
            r1 = -1
            if (r13 != r1) goto Lae
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 == 0) goto Lbf
        Lae:
            com.google.android.exoplayer2.source.rtsp.RtspTrackTiming r1 = new com.google.android.exoplayer2.source.rtsp.RtspTrackTiming
            r1.<init>(r14, r13, r6)
            r0.add(r1)
            int r4 = r4 + 1
            r1 = r16
            r2 = r17
            r3 = 0
            goto L10
        Lbf:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            r0.<init>(r5)
            throw r0
        Lc5:
            com.google.common.collect.ImmutableList r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspTrackTiming.parseTrackTiming(java.lang.String):com.google.common.collect.ImmutableList");
    }

    private RtspTrackTiming(long j, int i, Uri uri) {
        this.rtpTimestamp = j;
        this.sequenceNumber = i;
        this.uri = uri;
    }
}