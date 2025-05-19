package kotlinx.coroutines.channels;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* compiled from: TickerChannels.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", RtspHeaders.Values.MODE, "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class TickerChannelsKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TickerMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            iArr[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    public static final ReceiveChannel<Unit> ticker(long j, long j2, CoroutineContext context, TickerMode mode) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(mode, "mode");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(context), 0, new TickerChannelsKt$ticker$3(mode, j, j2, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0175 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0176 -> B:15:0x017a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object fixedPeriodTicker(long r21, long r23, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r25, kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0092 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00a3 -> B:13:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object fixedDelayTicker(long r8, long r10, kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L14
            r0 = r13
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L19
        L14:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r13)
        L19:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L6f
            if (r2 == r5) goto L5c
            if (r2 == r4) goto L4a
            if (r2 != r3) goto L42
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            boolean r2 = r13 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L3d
        L38:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
            goto L82
        L3d:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r8 = r13.exception
            throw r8
        L42:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L4a:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            boolean r2 = r13 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L57
            goto L97
        L57:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r8 = r13.exception
            throw r8
        L5c:
            java.lang.Object r8 = r0.L$0
            r12 = r8
            kotlinx.coroutines.channels.SendChannel r12 = (kotlinx.coroutines.channels.SendChannel) r12
            long r10 = r0.J$1
            long r8 = r0.J$0
            boolean r2 = r13 instanceof kotlin.Result.Failure
            if (r2 != 0) goto L6a
            goto L82
        L6a:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r8 = r13.exception
            throw r8
        L6f:
            boolean r2 = r13 instanceof kotlin.Result.Failure
            if (r2 != 0) goto La6
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r13 != r1) goto L82
            return r1
        L82:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = r12.send(r13, r0)
            if (r13 != r1) goto L93
            return r1
        L93:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L97:
            r0.J$0 = r11
            r0.J$1 = r9
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r11, r0)
            if (r13 != r1) goto L38
            return r1
        La6:
            kotlin.Result$Failure r13 = (kotlin.Result.Failure) r13
            java.lang.Throwable r8 = r13.exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
