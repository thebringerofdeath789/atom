package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: CoroutineContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a\b\u0010\u000f\u001a\u00020\u0010H\u0000\u001a4\u0010\u0011\u001a\u0002H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0017H\u0080\b¢\u0006\u0002\u0010\u0018\u001a\u0014\u0010\u0019\u001a\u00020\n*\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\nH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "resetCoroutineId", "", "withCoroutineContext", "T", "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public final class CoroutineContextKt {
    public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    private static final AtomicLong COROUTINE_ID = new AtomicLong();
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
    private static final boolean useCoroutinesScheduler;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x002f, code lost:
    
        if (r0.equals("on") != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0038, code lost:
    
        if (r0.equals("") != false) goto L19;
     */
    static {
        /*
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r0.<init>()
            kotlinx.coroutines.CoroutineContextKt.COROUTINE_ID = r0
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.SystemPropsKt.systemProp(r0)
            if (r0 != 0) goto L10
            goto L3a
        L10:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L32
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L29
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L3e
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
            r0 = 0
            goto L3b
        L29:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
            goto L3a
        L32:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L3e
        L3a:
            r0 = 1
        L3b:
            kotlinx.coroutines.CoroutineContextKt.useCoroutinesScheduler = r0
            return
        L3e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            r1 = 39
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.CoroutineContextKt.<clinit>():void");
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }

    public static final boolean getUseCoroutinesScheduler() {
        return useCoroutinesScheduler;
    }

    public static final CoroutineDispatcher createDefaultDispatcher() {
        return useCoroutinesScheduler ? DefaultScheduler.INSTANCE : CommonPool.INSTANCE;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope receiver$0, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        Intrinsics.checkParameterIsNotNull(context, "context");
        CoroutineContext plus = receiver$0.getCoroutineContext().plus(context);
        CoroutineContext plus2 = DebugKt.DEBUG ? plus.plus(new CoroutineId(COROUTINE_ID.incrementAndGet())) : plus;
        return (plus == Dispatchers.getDefault() || plus.get(ContinuationInterceptor.INSTANCE) != null) ? plus2 : plus2.plus(Dispatchers.getDefault());
    }

    public static final <T> T withCoroutineContext(CoroutineContext context, Object obj, Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final String getCoroutineName(CoroutineContext receiver$0) {
        CoroutineId coroutineId;
        String str;
        Intrinsics.checkParameterIsNotNull(receiver$0, "receiver$0");
        if (!DebugKt.DEBUG || (coroutineId = (CoroutineId) receiver$0.get(CoroutineId.INSTANCE)) == null) {
            return null;
        }
        CoroutineName coroutineName = (CoroutineName) receiver$0.get(CoroutineName.INSTANCE);
        if (coroutineName == null || (str = coroutineName.getName()) == null) {
            str = "coroutine";
        }
        return str + '#' + coroutineId.getId();
    }
}
