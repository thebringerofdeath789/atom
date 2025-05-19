package kotlin;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.ranges.ULongRange;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: ULong.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 m2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001mB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\"J\u0013\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\rHÖ\u0001J\u0016\u0010'\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0005J\u0016\u0010)\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u0005J\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001dJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u001fJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b.\u0010\u000bJ\u001b\u0010+\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\"J\u001b\u00100\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b1\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001dJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u001fJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u0010\u000bJ\u001b\u00102\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b6\u0010\"J\u001b\u00107\u001a\u0002082\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001dJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u001fJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b>\u0010\u000bJ\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\"J\u001e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010\u001fJ\u001e\u0010C\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\rH\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\bF\u0010\u001dJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\bG\u0010\u001fJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bH\u0010\u000bJ\u001b\u0010E\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\nø\u0001\u0000¢\u0006\u0004\bI\u0010\"J\u0010\u0010J\u001a\u00020KH\u0087\b¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\rH\u0087\b¢\u0006\u0004\bW\u0010XJ\u0010\u0010Y\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bZ\u0010\u0005J\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u000f\u0010_\u001a\u00020`H\u0016¢\u0006\u0004\ba\u0010bJ\u0016\u0010c\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bd\u0010MJ\u0016\u0010e\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bf\u0010XJ\u0016\u0010g\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u0010\u0005J\u0016\u0010i\u001a\u00020\u0016H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bj\u0010^J\u001b\u0010k\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\bl\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006n"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", TtmlNode.TAG_DIV, "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "hashCode", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ULong implements Comparable<ULong> {
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m201boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m203compareToVKZWuLQ(long j) {
        return m204compareToVKZWuLQ(this.data, j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m207constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m213equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m214equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m215hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m238toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m241toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m242toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m243toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m247toULongsVKNKU(long j) {
        return j;
    }

    public boolean equals(Object other) {
        return m213equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m215hashCodeimpl(this.data);
    }

    public String toString() {
        return m244toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m203compareToVKZWuLQ(uLong.getData());
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m202compareTo7apg3OU(long j, byte b) {
        return UnsignedKt.ulongCompare(j, m207constructorimpl(b & 255));
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m206compareToxj2QHRw(long j, short s) {
        return UnsignedKt.ulongCompare(j, m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m205compareToWZ4Q5Ns(long j, int i) {
        return UnsignedKt.ulongCompare(j, m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m204compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m223plus7apg3OU(long j, byte b) {
        return m207constructorimpl(j + m207constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m226plusxj2QHRw(long j, short s) {
        return m207constructorimpl(j + m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m225plusWZ4Q5Ns(long j, int i) {
        return m207constructorimpl(j + m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m224plusVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j + j2);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m218minus7apg3OU(long j, byte b) {
        return m207constructorimpl(j - m207constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m221minusxj2QHRw(long j, short s) {
        return m207constructorimpl(j - m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m220minusWZ4Q5Ns(long j, int i) {
        return m207constructorimpl(j - m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m219minusVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j - j2);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m234times7apg3OU(long j, byte b) {
        return m207constructorimpl(j * m207constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m237timesxj2QHRw(long j, short s) {
        return m207constructorimpl(j * m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m236timesWZ4Q5Ns(long j, int i) {
        return m207constructorimpl(j * m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m235timesVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j * j2);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m209div7apg3OU(long j, byte b) {
        return UnsignedKt.m368ulongDivideeb3DHEI(j, m207constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m212divxj2QHRw(long j, short s) {
        return UnsignedKt.m368ulongDivideeb3DHEI(j, m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m211divWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m368ulongDivideeb3DHEI(j, m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m210divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m368ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m228rem7apg3OU(long j, byte b) {
        return UnsignedKt.m369ulongRemaindereb3DHEI(j, m207constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m231remxj2QHRw(long j, short s) {
        return UnsignedKt.m369ulongRemaindereb3DHEI(j, m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m230remWZ4Q5Ns(long j, int i) {
        return UnsignedKt.m369ulongRemaindereb3DHEI(j, m207constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m229remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m369ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m216incsVKNKU(long j) {
        return m207constructorimpl(j + 1);
    }

    /* renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m208decsVKNKU(long j) {
        return m207constructorimpl(j - 1);
    }

    /* renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m227rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m232shlsVKNKU(long j, int i) {
        return m207constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m233shrsVKNKU(long j, int i) {
        return m207constructorimpl(j >>> i);
    }

    /* renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m200andVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j & j2);
    }

    /* renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m222orVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j | j2);
    }

    /* renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m249xorVKZWuLQ(long j, long j2) {
        return m207constructorimpl(j ^ j2);
    }

    /* renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m217invsVKNKU(long j) {
        return m207constructorimpl(~j);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m245toUBytew2LRezQ(long j) {
        return UByte.m69constructorimpl((byte) j);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m248toUShortMh2AYeg(long j) {
        return UShort.m305constructorimpl((short) j);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m246toUIntpVg5ArA(long j) {
        return UInt.m137constructorimpl((int) j);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m240toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m239toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m244toStringimpl(long j) {
        return UnsignedKt.ulongToString(j);
    }
}
