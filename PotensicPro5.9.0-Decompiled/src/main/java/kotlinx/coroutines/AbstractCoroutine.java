package kotlinx.coroutines;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbstractCoroutine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0015\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\r\u0010\u001d\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H\u0010¢\u0006\u0002\b!J\u0012\u0010\"\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u001bH\u0014J\u0015\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J'\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\tH\u0010¢\u0006\u0002\b-J\b\u0010.\u001a\u00020\u0019H\u0014J\r\u0010/\u001a\u00020\u0019H\u0000¢\u0006\u0002\b0J\u001c\u00101\u001a\u00020\u00192\f\u00102\u001a\b\u0012\u0004\u0012\u00028\u000003ø\u0001\u0000¢\u0006\u0002\u0010&JM\u00104\u001a\u00020\u0019\"\u0004\b\u0001\u001052\u0006\u00104\u001a\u0002062\u0006\u00107\u001a\u0002H52'\u00108\u001a#\b\u0001\u0012\u0004\u0012\u0002H5\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*09¢\u0006\u0002\b:ø\u0001\u0000¢\u0006\u0002\u0010;J4\u00104\u001a\u00020\u00192\u0006\u00104\u001a\u0002062\u001c\u00108\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010*0<ø\u0001\u0000¢\u0006\u0002\u0010=R\u0017\u0010\u000b\u001a\u00020\u0007¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00138PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0006\u001a\u00020\u00078\u0004X\u0085\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006>"}, d2 = {"Lkotlinx/coroutines/AbstractCoroutine;", "T", "Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/Continuation;", "Lkotlinx/coroutines/CoroutineScope;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "context", "context$annotations", "()V", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "getCoroutineContext", "defaultResumeMode", "", "getDefaultResumeMode$kotlinx_coroutines_core", "()I", "isActive", "()Z", "handleOnCompletionException", "", "exception", "", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "initParentJob$kotlinx_coroutines_core", "nameString", "", "nameString$kotlinx_coroutines_core", "onCancellation", "cause", "onCompleted", "value", "(Ljava/lang/Object;)V", "onCompletedExceptionally", "onCompletionInternal", "state", "", RtspHeaders.Values.MODE, "suppressed", "onCompletionInternal$kotlinx_coroutines_core", "onStart", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "resumeWith", "result", "Lkotlin/Result;", TtmlNode.START, "R", "Lkotlinx/coroutines/CoroutineStart;", "receiver", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", "(Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public abstract class AbstractCoroutine<T> extends JobSupport implements Job, Continuation<T>, CoroutineScope {
    private final CoroutineContext context;
    protected final CoroutineContext parentContext;

    public static /* synthetic */ void context$annotations() {
    }

    public int getDefaultResumeMode$kotlinx_coroutines_core() {
        return 0;
    }

    @Override // kotlinx.coroutines.JobSupport
    protected void onCancellation(Throwable cause) {
    }

    protected void onCompleted(T value) {
    }

    protected void onCompletedExceptionally(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
    }

    protected void onStart() {
    }

    public /* synthetic */ AbstractCoroutine(CoroutineContext coroutineContext, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineContext, (i & 2) != 0 ? true : z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractCoroutine(CoroutineContext parentContext, boolean z) {
        super(z);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
        this.parentContext = parentContext;
        this.context = parentContext.plus(this);
    }

    @Override // kotlin.coroutines.Continuation
    /* renamed from: getContext, reason: from getter */
    public final CoroutineContext get$context() {
        return this.context;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    public final void initParentJob$kotlinx_coroutines_core() {
        initParentJobInternal$kotlinx_coroutines_core((Job) this.parentContext.get(Job.INSTANCE));
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void onStartInternal$kotlinx_coroutines_core() {
        onStart();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public void onCompletionInternal$kotlinx_coroutines_core(Object state, int mode, boolean suppressed) {
        if (state instanceof CompletedExceptionally) {
            onCompletedExceptionally(((CompletedExceptionally) state).cause);
        } else {
            onCompleted(state);
        }
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        makeCompletingOnce$kotlinx_coroutines_core(CompletedExceptionallyKt.toState(result), getDefaultResumeMode$kotlinx_coroutines_core());
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        CoroutineExceptionHandlerKt.handleCoroutineException(this.parentContext, exception, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public String nameString$kotlinx_coroutines_core() {
        String coroutineName = CoroutineContextKt.getCoroutineName(this.context);
        if (coroutineName == null) {
            return super.nameString$kotlinx_coroutines_core();
        }
        return '\"' + coroutineName + "\":" + super.nameString$kotlinx_coroutines_core();
    }

    public final void start(CoroutineStart start, Function1<? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(start, "start");
        Intrinsics.checkParameterIsNotNull(block, "block");
        initParentJob$kotlinx_coroutines_core();
        start.invoke(block, this);
    }

    public final <R> void start(CoroutineStart start, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(start, "start");
        Intrinsics.checkParameterIsNotNull(block, "block");
        initParentJob$kotlinx_coroutines_core();
        start.invoke(block, receiver, this);
    }
}
