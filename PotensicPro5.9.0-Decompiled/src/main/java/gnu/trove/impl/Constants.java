package gnu.trove.impl;

/* loaded from: classes3.dex */
public class Constants {
    public static final byte DEFAULT_BYTE_NO_ENTRY_VALUE;
    public static final int DEFAULT_CAPACITY = 10;
    public static final char DEFAULT_CHAR_NO_ENTRY_VALUE;
    public static final double DEFAULT_DOUBLE_NO_ENTRY_VALUE;
    public static final float DEFAULT_FLOAT_NO_ENTRY_VALUE;
    public static final int DEFAULT_INT_NO_ENTRY_VALUE;
    public static final float DEFAULT_LOAD_FACTOR = 0.5f;
    public static final long DEFAULT_LONG_NO_ENTRY_VALUE;
    public static final short DEFAULT_SHORT_NO_ENTRY_VALUE;
    private static final boolean VERBOSE;

    /* JADX WARN: Can't wrap try/catch for region: R(52:0|1|(2:2|3)|(48:5|6|7|8|9|(1:11)(2:133|(1:135)(1:136))|(1:13)(1:(1:132))|14|(1:16)|17|18|19|(1:21)(2:125|(1:127)(1:128))|(1:23)(1:(1:124))|24|(1:26)|27|28|29|30|(1:32)(2:117|(1:119)(1:120))|(1:34)(1:(1:116))|35|(1:37)|38|39|40|(1:42)(2:109|(1:111)(1:112))|43|(1:45)|46|47|48|(1:50)(2:103|(1:105)(1:106))|51|(1:53)|54|55|56|(1:58)(2:88|(1:90)(2:91|(1:93)(2:94|(1:96)(2:97|(1:99)(1:100)))))|59|(1:61)|62|63|64|(1:66)(2:73|(1:75)(2:76|(1:78)(2:79|(1:81)(2:82|(1:84)(1:85)))))|67|(2:69|70)(1:72))|139|6|7|8|9|(0)(0)|(0)(0)|14|(0)|17|18|19|(0)(0)|(0)(0)|24|(0)|27|28|29|30|(0)(0)|(0)(0)|35|(0)|38|39|40|(0)(0)|43|(0)|46|47|48|(0)(0)|51|(0)|54|55|56|(0)(0)|59|(0)|62|63|64|(0)(0)|67|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(53:0|1|2|3|(48:5|6|7|8|9|(1:11)(2:133|(1:135)(1:136))|(1:13)(1:(1:132))|14|(1:16)|17|18|19|(1:21)(2:125|(1:127)(1:128))|(1:23)(1:(1:124))|24|(1:26)|27|28|29|30|(1:32)(2:117|(1:119)(1:120))|(1:34)(1:(1:116))|35|(1:37)|38|39|40|(1:42)(2:109|(1:111)(1:112))|43|(1:45)|46|47|48|(1:50)(2:103|(1:105)(1:106))|51|(1:53)|54|55|56|(1:58)(2:88|(1:90)(2:91|(1:93)(2:94|(1:96)(2:97|(1:99)(1:100)))))|59|(1:61)|62|63|64|(1:66)(2:73|(1:75)(2:76|(1:78)(2:79|(1:81)(2:82|(1:84)(1:85)))))|67|(2:69|70)(1:72))|139|6|7|8|9|(0)(0)|(0)(0)|14|(0)|17|18|19|(0)(0)|(0)(0)|24|(0)|27|28|29|30|(0)(0)|(0)(0)|35|(0)|38|39|40|(0)(0)|43|(0)|46|47|48|(0)(0)|51|(0)|54|55|56|(0)(0)|59|(0)|62|63|64|(0)(0)|67|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x017f, code lost:
    
        r1 = com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x013c, code lost:
    
        r1 = com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00fb, code lost:
    
        r1 = com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0066, code lost:
    
        r2 = com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0018, code lost:
    
        r2 = com.google.android.exoplayer2.source.rtsp.SessionDescription.SUPPORTED_SDP_VERSION;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0190  */
    static {
        /*
            Method dump skipped, instructions count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: gnu.trove.impl.Constants.<clinit>():void");
    }
}
