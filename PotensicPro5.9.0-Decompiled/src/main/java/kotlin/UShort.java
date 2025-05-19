package kotlin;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: UShort.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0016\u0010%\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0005J\u0016\u0010'\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\u0087\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\u0087\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\u0087\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0016\u0010\\\u001a\u00020\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b]\u0010FJ\u0016\u0010^\u001a\u00020\u0011H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b_\u0010QJ\u0016\u0010`\u001a\u00020\u0014H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010UJ\u0016\u0010b\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006g"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", TtmlNode.TAG_DIV, "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m299boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m303compareToxj2QHRw(short s) {
        return m304compareToxj2QHRw(this.data, s);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static short m305constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m311equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m312equalsimpl0(short s, short s2) {
        return s == s2;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m313hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m334toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m335toDoubleimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m336toFloatimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m337toIntimpl(short s) {
        return s & 65535;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m338toLongimpl(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m339toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m344toUShortMh2AYeg(short s) {
        return s;
    }

    public boolean equals(Object other) {
        return m311equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m313hashCodeimpl(this.data);
    }

    public String toString() {
        return m340toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return m303compareToxj2QHRw(uShort.getData());
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m300compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare(s & 65535, b & 255);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m304compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & 65535, s2 & 65535);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m302compareToWZ4Q5Ns(short s, int i) {
        return UnsignedKt.uintCompare(UInt.m137constructorimpl(s & 65535), i);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m301compareToVKZWuLQ(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m321plus7apg3OU(short s, byte b) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) + UInt.m137constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m324plusxj2QHRw(short s, short s2) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) + UInt.m137constructorimpl(s2 & 65535));
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m323plusWZ4Q5Ns(short s, int i) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) + i);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m322plusVKZWuLQ(short s, long j) {
        return ULong.m207constructorimpl(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m316minus7apg3OU(short s, byte b) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) - UInt.m137constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m319minusxj2QHRw(short s, short s2) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) - UInt.m137constructorimpl(s2 & 65535));
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m318minusWZ4Q5Ns(short s, int i) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) - i);
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m317minusVKZWuLQ(short s, long j) {
        return ULong.m207constructorimpl(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m330times7apg3OU(short s, byte b) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) * UInt.m137constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m333timesxj2QHRw(short s, short s2) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) * UInt.m137constructorimpl(s2 & 65535));
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m332timesWZ4Q5Ns(short s, int i) {
        return UInt.m137constructorimpl(UInt.m137constructorimpl(s & 65535) * i);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m331timesVKZWuLQ(short s, long j) {
        return ULong.m207constructorimpl(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m307div7apg3OU(short s, byte b) {
        return UnsignedKt.m366uintDivideJ1ME1BU(UInt.m137constructorimpl(s & 65535), UInt.m137constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m310divxj2QHRw(short s, short s2) {
        return UnsignedKt.m366uintDivideJ1ME1BU(UInt.m137constructorimpl(s & 65535), UInt.m137constructorimpl(s2 & 65535));
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m309divWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m366uintDivideJ1ME1BU(UInt.m137constructorimpl(s & 65535), i);
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m308divVKZWuLQ(short s, long j) {
        return UnsignedKt.m368ulongDivideeb3DHEI(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m326rem7apg3OU(short s, byte b) {
        return UnsignedKt.m367uintRemainderJ1ME1BU(UInt.m137constructorimpl(s & 65535), UInt.m137constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m329remxj2QHRw(short s, short s2) {
        return UnsignedKt.m367uintRemainderJ1ME1BU(UInt.m137constructorimpl(s & 65535), UInt.m137constructorimpl(s2 & 65535));
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m328remWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m367uintRemainderJ1ME1BU(UInt.m137constructorimpl(s & 65535), i);
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m327remVKZWuLQ(short s, long j) {
        return UnsignedKt.m369ulongRemaindereb3DHEI(ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m314incMh2AYeg(short s) {
        return m305constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m306decMh2AYeg(short s) {
        return m305constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m325rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m137constructorimpl(s & 65535), UInt.m137constructorimpl(s2 & 65535), null);
    }

    /* renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m298andxj2QHRw(short s, short s2) {
        return m305constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m320orxj2QHRw(short s, short s2) {
        return m305constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m345xorxj2QHRw(short s, short s2) {
        return m305constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m315invMh2AYeg(short s) {
        return m305constructorimpl((short) (~s));
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m341toUBytew2LRezQ(short s) {
        return UByte.m69constructorimpl((byte) s);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m342toUIntpVg5ArA(short s) {
        return UInt.m137constructorimpl(s & 65535);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m343toULongsVKNKU(short s) {
        return ULong.m207constructorimpl(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m340toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }
}
