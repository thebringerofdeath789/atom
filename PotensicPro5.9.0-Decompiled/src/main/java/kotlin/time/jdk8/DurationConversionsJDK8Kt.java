package kotlin.time.jdk8;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.DurationKt;

/* compiled from: DurationConversions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u0001H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"toJavaDuration", "Ljava/time/Duration;", "Lkotlin/time/Duration;", "toJavaDuration-LRDsOJo", "(D)Ljava/time/Duration;", "toKotlinDuration", "(Ljava/time/Duration;)D", "kotlin-stdlib-jdk8"}, k = 2, mv = {1, 4, 0}, pn = "kotlin.time")
/* loaded from: classes4.dex */
public final class DurationConversionsJDK8Kt {
    private static final double toKotlinDuration(Duration duration) {
        return kotlin.time.Duration.m1333plusLRDsOJo(DurationKt.getSeconds(duration.getSeconds()), DurationKt.getNanoseconds(duration.getNano()));
    }

    /* renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m1364toJavaDurationLRDsOJo(double d) {
        Duration ofSeconds = Duration.ofSeconds((long) kotlin.time.Duration.m1323getInSecondsimpl(d), kotlin.time.Duration.m1325getNanosecondsComponentimpl(d));
        Intrinsics.checkNotNullExpressionValue(ofSeconds, "toComponents { seconds, …, nanoseconds.toLong()) }");
        return ofSeconds;
    }
}
