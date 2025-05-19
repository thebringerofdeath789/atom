package kotlinx.coroutines;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectInstance;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.xmlbeans.XmlErrorCodes;

/* compiled from: JobSupport.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0006¥\u0001¦\u0001§\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J$\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u0002002\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0002J\u000e\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u0002J\u0015\u00105\u001a\u0004\u0018\u00010\nH\u0080@ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0013\u00108\u001a\u0004\u0018\u00010\nH\u0082@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u00109\u001a\u00020:H\u0016J\u0012\u00109\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010<\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010=\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010>\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0002J\u0010\u0010?\u001a\u00020\u00062\u0006\u0010;\u001a\u00020'H\u0016J*\u0010@\u001a\u00020:2\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0002J\"\u0010E\u001a\u00020:2\u0006\u0010#\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0002J\u0012\u0010J\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010K\u001a\u00020LH\u0002J\u0012\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010#\u001a\u00020+H\u0002J\n\u0010N\u001a\u00060Oj\u0002`PJ\b\u0010Q\u001a\u00020'H\u0016J\u000f\u0010R\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\bSJ\n\u0010T\u001a\u0004\u0018\u00010'H\u0004J\b\u0010U\u001a\u0004\u0018\u00010'J \u0010V\u001a\u0004\u0018\u00010'2\u0006\u0010#\u001a\u00020F2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\u0012\u0010Y\u001a\u0004\u0018\u0001002\u0006\u0010#\u001a\u00020+H\u0002J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0014J\u0015\u0010\\\u001a\u00020:2\u0006\u0010[\u001a\u00020'H\u0010¢\u0006\u0002\b]J\u0017\u0010^\u001a\u00020:2\b\u0010_\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0002\b`J?\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u00062\u0006\u0010d\u001a\u00020\u00062'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ/\u0010a\u001a\u00020b2'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`iJ\u0011\u0010j\u001a\u00020:H\u0086@ø\u0001\u0000¢\u0006\u0002\u00107J\b\u0010k\u001a\u00020\u0006H\u0002J\u0011\u0010l\u001a\u00020:H\u0082@ø\u0001\u0000¢\u0006\u0002\u00107J\u001f\u0010m\u001a\u00020n2\u0014\u0010o\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020:0fH\u0082\bJ\u0012\u0010p\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010\nH\u0002J\u0017\u0010q\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\brJ\u001f\u0010s\u001a\u00020\u00062\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0000¢\u0006\u0002\btJ=\u0010u\u001a\u0006\u0012\u0002\b\u0003022'\u0010e\u001a#\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\bg\u0012\b\bh\u0012\u0004\b\b(;\u0012\u0004\u0012\u00020:0fj\u0002`i2\u0006\u0010c\u001a\u00020\u0006H\u0002J\r\u0010v\u001a\u00020wH\u0010¢\u0006\u0002\bxJ\u0018\u0010y\u001a\u00020:2\u0006\u0010/\u001a\u0002002\u0006\u0010;\u001a\u00020'H\u0002J+\u0010z\u001a\u00020:\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u0003022\u0006\u0010/\u001a\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\u0082\bJ\u0012\u0010|\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010'H\u0014J'\u0010}\u001a\u00020:2\b\u0010#\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0006H\u0010¢\u0006\u0002\b~J\u000e\u0010\u007f\u001a\u00020:H\u0010¢\u0006\u0003\b\u0080\u0001J\u0010\u0010\u0081\u0001\u001a\u00020:2\u0007\u0010\u0082\u0001\u001a\u00020\u0003J\u0012\u0010\u0083\u0001\u001a\u00020:2\u0007\u0010#\u001a\u00030\u0084\u0001H\u0002J\u0015\u0010\u0085\u0001\u001a\u00020:2\n\u0010#\u001a\u0006\u0012\u0002\b\u000302H\u0002JH\u0010\u0086\u0001\u001a\u00020:\"\u0005\b\u0000\u0010\u0087\u00012\u000f\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0087\u00010\u0089\u00012\u001e\u0010o\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0087\u00010\u008a\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0fø\u0001\u0000¢\u0006\u0003\u0010\u008b\u0001JZ\u0010\u008c\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u0087\u00012\u000f\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0087\u00010\u0089\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0087\u00010\u008a\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u008d\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\u001b\u0010\u0090\u0001\u001a\u00020:2\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0000¢\u0006\u0003\b\u0091\u0001JZ\u0010\u0092\u0001\u001a\u00020:\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u0087\u00012\u000f\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0087\u00010\u0089\u00012%\u0010o\u001a!\b\u0001\u0012\u0004\u0012\u0002H{\u0012\f\u0012\n\u0012\u0005\u0012\u0003H\u0087\u00010\u008a\u0001\u0012\u0006\u0012\u0004\u0018\u00010\n0\u008d\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0093\u0001\u0010\u008f\u0001J\u0007\u0010\u0094\u0001\u001a\u00020\u0006J\u0013\u0010\u0095\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J\u0013\u0010\u0096\u0001\u001a\u00020w2\b\u0010#\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u0097\u0001\u001a\u00020\u00062\u0007\u0010\u0098\u0001\u001a\u00020'2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020'0XH\u0002J\t\u0010\u0099\u0001\u001a\u00020wH\u0007J\t\u0010\u009a\u0001\u001a\u00020wH\u0016J#\u0010\u009b\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J#\u0010\u009c\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\b\u0010A\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J\u001a\u0010\u009d\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020+2\u0007\u0010\u0098\u0001\u001a\u00020'H\u0002J%\u0010\u009e\u0001\u001a\u00020C2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010B\u001a\u00020CH\u0002J$\u0010\u009f\u0001\u001a\u00020\u00062\u0006\u0010#\u001a\u00020F2\u0006\u00104\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0082\u0010J\u0010\u0010 \u0001\u001a\u0004\u0018\u00010H*\u00030¡\u0001H\u0002J\u0017\u0010¢\u0001\u001a\u00020:*\u0002002\b\u0010;\u001a\u0004\u0018\u00010'H\u0002J\u001a\u0010£\u0001\u001a\u00060Oj\u0002`P*\u00020'2\u0007\u0010¤\u0001\u001a\u00020wH\u0002R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0014\u0010\u0014\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0015\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0011\u0010\u0017\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0015\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u0004\u0018\u00010\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'*\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010*\u001a\u00020\u0006*\u00020+8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¨\u0001"}, d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/selects/SelectClause0;", "active", "", "(Z)V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "cancelsParent", "getCancelsParent", "()Z", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "handlesException", "getHandlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parentHandle", "Lkotlinx/coroutines/ChildHandle;", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", XmlErrorCodes.LIST, "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "attachChild", "child", "awaitInternal", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "", "cause", "cancelImpl", "cancelMakeCompleting", "cancelParent", "childCancelled", "completeStateFinalization", "update", RtspHeaders.Values.MODE, "", "suppressed", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "createJobCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "firstChild", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionCause", "getCompletionExceptionOrNull", "getFinalRootCause", "exceptions", "", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJobInternal", "parent", "initParentJobInternal$kotlinx_coroutines_core", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onCancellation", "onCompletionInternal", "onCompletionInternal$kotlinx_coroutines_core", "onStartInternal", "onStartInternal$kotlinx_coroutines_core", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectClause0", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "registerSelectClause1Internal", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "removeNode", "removeNode$kotlinx_coroutines_core", "selectAwaitCompletion", "selectAwaitCompletion$kotlinx_coroutines_core", TtmlNode.START, "startInternal", "stateString", "suppressExceptions", "rootCause", "toDebugString", "toString", "tryFinalizeFinishingState", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "message", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public class JobSupport implements Job, ChildJob, ParentJob, SelectClause0 {
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(JobSupport.class, Object.class, "_state");
    private volatile Object _state;
    private volatile ChildHandle parentHandle;

    protected boolean getCancelsParent() {
        return false;
    }

    protected boolean getHandlesException() {
        return true;
    }

    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return false;
    }

    protected void handleJobException(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
    }

    protected void onCancellation(Throwable cause) {
    }

    public void onCompletionInternal$kotlinx_coroutines_core(Object state, int mode, boolean suppressed) {
    }

    public void onStartInternal$kotlinx_coroutines_core() {
    }

    public JobSupport(boolean z) {
        this._state = z ? JobSupportKt.EMPTY_ACTIVE : JobSupportKt.EMPTY_NEW;
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left here for binary compatibility")
    /* renamed from: cancel */
    public /* synthetic */ boolean mo1365cancel() {
        boolean cancel;
        cancel = cancel(null);
        return cancel;
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        return (R) Job.DefaultImpls.fold(this, r, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return (E) Job.DefaultImpls.get(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        return Job.DefaultImpls.plus(this, context);
    }

    @Override // kotlinx.coroutines.Job
    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public Job plus(Job other) {
        Intrinsics.checkParameterIsNotNull(other, "other");
        return Job.DefaultImpls.plus((Job) this, other);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public final CoroutineContext.Key<?> getKey() {
        return Job.INSTANCE;
    }

    public final void initParentJobInternal$kotlinx_coroutines_core(Job parent) {
        if (!(this.parentHandle == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (parent == null) {
            this.parentHandle = NonDisposableHandle.INSTANCE;
            return;
        }
        parent.start();
        ChildHandle attachChild = parent.attachChild(this);
        this.parentHandle = attachChild;
        if (isCompleted()) {
            attachChild.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        while (true) {
            block.invoke(getState$kotlinx_coroutines_core());
        }
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof Incomplete) && ((Incomplete) state$kotlinx_coroutines_core).getIsActive();
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return !(getState$kotlinx_coroutines_core() instanceof Incomplete);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        return (state$kotlinx_coroutines_core instanceof CompletedExceptionally) || ((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).isCancelling());
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r4 != r6.rootCause) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean tryFinalizeFinishingState(kotlinx.coroutines.JobSupport.Finishing r6, java.lang.Object r7, int r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.getState$kotlinx_coroutines_core()
            r1 = 0
            r2 = 1
            if (r0 != r6) goto La
            r0 = r2
            goto Lb
        La:
            r0 = r1
        Lb:
            if (r0 == 0) goto Lb9
            boolean r0 = r6.isSealed()
            r0 = r0 ^ r2
            if (r0 == 0) goto Lab
            boolean r0 = r6.completing
            if (r0 == 0) goto L9d
            boolean r0 = r7 instanceof kotlinx.coroutines.CompletedExceptionally
            r3 = 0
            if (r0 != 0) goto L1f
            r0 = r3
            goto L20
        L1f:
            r0 = r7
        L20:
            kotlinx.coroutines.CompletedExceptionally r0 = (kotlinx.coroutines.CompletedExceptionally) r0
            if (r0 == 0) goto L26
            java.lang.Throwable r3 = r0.cause
        L26:
            monitor-enter(r6)
            java.util.List r0 = r6.sealLocked(r3)     // Catch: java.lang.Throwable -> L9a
            java.lang.Throwable r4 = r5.getFinalRootCause(r6, r0)     // Catch: java.lang.Throwable -> L9a
            if (r4 == 0) goto L3c
            boolean r0 = r5.suppressExceptions(r4, r0)     // Catch: java.lang.Throwable -> L9a
            if (r0 != 0) goto L3b
            java.lang.Throwable r0 = r6.rootCause     // Catch: java.lang.Throwable -> L9a
            if (r4 == r0) goto L3c
        L3b:
            r1 = r2
        L3c:
            monitor-exit(r6)
            if (r4 != 0) goto L40
            goto L48
        L40:
            if (r4 != r3) goto L43
            goto L48
        L43:
            kotlinx.coroutines.CompletedExceptionally r7 = new kotlinx.coroutines.CompletedExceptionally
            r7.<init>(r4)
        L48:
            if (r4 == 0) goto L53
            boolean r0 = r5.cancelParent(r4)
            if (r0 != 0) goto L53
            r5.handleJobException(r4)
        L53:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = kotlinx.coroutines.JobSupport._state$FU
            java.lang.Object r3 = kotlinx.coroutines.JobSupportKt.access$boxIncomplete(r7)
            boolean r0 = r0.compareAndSet(r5, r6, r3)
            if (r0 == 0) goto L65
            kotlinx.coroutines.Incomplete r6 = (kotlinx.coroutines.Incomplete) r6
            r5.completeStateFinalization(r6, r7, r8, r1)
            return r2
        L65:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unexpected state: "
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.Object r0 = r5._state
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r0 = ", expected: "
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.StringBuilder r6 = r8.append(r6)
            java.lang.String r8 = ", update: "
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L9a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        L9d:
            java.lang.String r6 = "Failed requirement."
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        Lab:
            java.lang.String r6 = "Failed requirement."
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        Lb9:
            java.lang.String r6 = "Failed requirement."
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r6 = r6.toString()
            r7.<init>(r6)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.tryFinalizeFinishingState(kotlinx.coroutines.JobSupport$Finishing, java.lang.Object, int):boolean");
    }

    private final Throwable getFinalRootCause(Finishing state, List<? extends Throwable> exceptions) {
        Object obj = null;
        if (exceptions.isEmpty()) {
            if (state.isCancelling()) {
                return createJobCancellationException();
            }
            return null;
        }
        Iterator<T> it = exceptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : exceptions.get(0);
    }

    private final boolean suppressExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        boolean z = false;
        if (exceptions.size() <= 1) {
            return false;
        }
        Set identitySet = ConcurrentKt.identitySet(exceptions.size());
        Iterator<? extends Throwable> it = exceptions.iterator();
        while (it.hasNext()) {
            Throwable unwrap = StackTraceRecoveryKt.unwrap(it.next());
            if (unwrap != rootCause && !(unwrap instanceof CancellationException) && identitySet.add(unwrap)) {
                kotlin.ExceptionsKt.addSuppressed(rootCause, unwrap);
                z = true;
            }
        }
        return z;
    }

    private final boolean tryFinalizeSimpleState(Incomplete state, Object update, int mode) {
        Object boxIncomplete;
        if (!((state instanceof Empty) || (state instanceof JobNode))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(!(update instanceof CompletedExceptionally))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
        boxIncomplete = JobSupportKt.boxIncomplete(update);
        if (!atomicReferenceFieldUpdater.compareAndSet(this, state, boxIncomplete)) {
            return false;
        }
        completeStateFinalization(state, update, mode, false);
        return true;
    }

    private final void completeStateFinalization(Incomplete state, Object update, int mode, boolean suppressed) {
        ChildHandle childHandle = this.parentHandle;
        if (childHandle != null) {
            childHandle.dispose();
            this.parentHandle = NonDisposableHandle.INSTANCE;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(update instanceof CompletedExceptionally) ? null : update);
        Throwable th = completedExceptionally != null ? completedExceptionally.cause : null;
        if (!isCancelling(state)) {
            onCancellation(th);
        }
        if (state instanceof JobNode) {
            try {
                ((JobNode) state).invoke(th);
            } catch (Throwable th2) {
                handleOnCompletionException$kotlinx_coroutines_core(new CompletionHandlerException("Exception in completion handler " + state + " for " + this, th2));
            }
        } else {
            NodeList list = state.getList();
            if (list != null) {
                notifyCompletion(list, th);
            }
        }
        onCompletionInternal$kotlinx_coroutines_core(update, mode, suppressed);
    }

    private final void notifyCancelling(NodeList list, Throwable cause) {
        onCancellation(cause);
        Throwable th = (Throwable) null;
        Object next = list.getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobCancellingNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(cause);
                } catch (Throwable th2) {
                    if (th != null) {
                        kotlin.ExceptionsKt.addSuppressed(th, th2);
                        if (th != null) {
                        }
                    }
                    CompletionHandlerException completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    Unit unit = Unit.INSTANCE;
                    th = completionHandlerException;
                }
            }
        }
        if (th != null) {
            handleOnCompletionException$kotlinx_coroutines_core(th);
        }
        cancelParent(cause);
    }

    private final <T extends JobNode<?>> void notifyHandlers(NodeList list, Throwable cause) {
        Throwable th = (Throwable) null;
        Object next = list.getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, list); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(cause);
                } catch (Throwable th2) {
                    if (th != null) {
                        kotlin.ExceptionsKt.addSuppressed(th, th2);
                        if (th != null) {
                        }
                    }
                    CompletionHandlerException completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th2);
                    Unit unit = Unit.INSTANCE;
                    th = completionHandlerException;
                }
            }
        }
        if (th != null) {
            handleOnCompletionException$kotlinx_coroutines_core(th);
        }
    }

    private final int startInternal(Object state) {
        Empty empty;
        if (state instanceof Empty) {
            if (((Empty) state).getIsActive()) {
                return 0;
            }
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _state$FU;
            empty = JobSupportKt.EMPTY_ACTIVE;
            if (!atomicReferenceFieldUpdater.compareAndSet(this, state, empty)) {
                return -1;
            }
            onStartInternal$kotlinx_coroutines_core();
            return 1;
        }
        if (!(state instanceof InactiveNodeList)) {
            return 0;
        }
        if (!_state$FU.compareAndSet(this, state, ((InactiveNodeList) state).getList())) {
            return -1;
        }
        onStartInternal$kotlinx_coroutines_core();
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        CancellationException cancellationException;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(state$kotlinx_coroutines_core instanceof Finishing)) {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            return state$kotlinx_coroutines_core instanceof CompletedExceptionally ? toCancellationException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause, "Job was cancelled") : new JobCancellationException("Job has completed normally", null, this);
        }
        Throwable th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
        if (th == null || (cancellationException = toCancellationException(th, "Job is cancelling")) == null) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        return cancellationException;
    }

    private final CancellationException toCancellationException(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        return cancellationException != null ? cancellationException : new JobCancellationException(str, th, this);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        return invokeOnCompletion(false, true, handler);
    }

    @Override // kotlinx.coroutines.Job
    public final DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        JobNode<?> jobNode = (JobNode) null;
        while (true) {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof Empty) {
                Empty empty = (Empty) state$kotlinx_coroutines_core;
                if (empty.getIsActive()) {
                    if (jobNode == null) {
                        jobNode = makeNode(handler, onCancelling);
                    }
                    if (_state$FU.compareAndSet(this, state$kotlinx_coroutines_core, jobNode)) {
                        return jobNode;
                    }
                } else {
                    promoteEmptyToNodeList(empty);
                }
            } else if (state$kotlinx_coroutines_core instanceof Incomplete) {
                NodeList list = ((Incomplete) state$kotlinx_coroutines_core).getList();
                if (list != null) {
                    Throwable th = (Throwable) null;
                    JobNode<?> jobNode2 = NonDisposableHandle.INSTANCE;
                    if (onCancelling && (state$kotlinx_coroutines_core instanceof Finishing)) {
                        synchronized (state$kotlinx_coroutines_core) {
                            th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
                            if (th == null || ((handler instanceof ChildHandleNode) && !((Finishing) state$kotlinx_coroutines_core).completing)) {
                                if (jobNode == null) {
                                    jobNode = makeNode(handler, onCancelling);
                                }
                                if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                                    if (th == null) {
                                        return jobNode;
                                    }
                                    jobNode2 = jobNode;
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                    if (th != null) {
                        if (invokeImmediately) {
                            handler.invoke(th);
                        }
                        return jobNode2;
                    }
                    if (jobNode == null) {
                        jobNode = makeNode(handler, onCancelling);
                    }
                    if (addLastAtomic(state$kotlinx_coroutines_core, list, jobNode)) {
                        return jobNode;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>");
                    }
                    promoteSingleToNodeList((JobNode) state$kotlinx_coroutines_core);
                }
            } else {
                if (invokeImmediately) {
                    if (!(state$kotlinx_coroutines_core instanceof CompletedExceptionally)) {
                        state$kotlinx_coroutines_core = null;
                    }
                    CompletedExceptionally completedExceptionally = (CompletedExceptionally) state$kotlinx_coroutines_core;
                    handler.invoke(completedExceptionally != null ? completedExceptionally.cause : null);
                }
                return NonDisposableHandle.INSTANCE;
            }
        }
    }

    private final JobNode<?> makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        if (onCancelling) {
            JobCancellingNode jobCancellingNode = (JobCancellingNode) (handler instanceof JobCancellingNode ? handler : null);
            if (jobCancellingNode != null) {
                if (!(jobCancellingNode.job == this)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                if (jobCancellingNode != null) {
                    return jobCancellingNode;
                }
            }
            return new InvokeOnCancelling(this, handler);
        }
        JobNode<?> jobNode = (JobNode) (handler instanceof JobNode ? handler : null);
        if (jobNode != null) {
            if (!(jobNode.job == this && !(jobNode instanceof JobCancellingNode))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (jobNode != null) {
                return jobNode;
            }
        }
        return new InvokeOnCompletion(this, handler);
    }

    private final void promoteEmptyToNodeList(Empty state) {
        NodeList nodeList = new NodeList();
        _state$FU.compareAndSet(this, state, state.getIsActive() ? nodeList : new InactiveNodeList(nodeList));
    }

    private final void promoteSingleToNodeList(JobNode<?> state) {
        state.addOneIfEmpty(new NodeList());
        _state$FU.compareAndSet(this, state, state.getNextNode());
    }

    @Override // kotlinx.coroutines.Job
    public final Object join(Continuation<? super Unit> continuation) {
        if (!joinInternal()) {
            YieldKt.checkCompletion(continuation.getContext());
            return Unit.INSTANCE;
        }
        return joinSuspend(continuation);
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        return this;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel() {
        cancel(null);
    }

    @Override // kotlinx.coroutines.Job
    public boolean cancel(Throwable cause) {
        return cancelImpl(cause) && getHandlesException();
    }

    @Override // kotlinx.coroutines.ChildJob
    public final void parentCancelled(ParentJob parentJob) {
        Intrinsics.checkParameterIsNotNull(parentJob, "parentJob");
        cancelImpl(parentJob);
    }

    public boolean childCancelled(Throwable cause) {
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        return cancelImpl(cause) && getHandlesException();
    }

    private final boolean cancelImpl(Object cause) {
        if (getOnCancelComplete$kotlinx_coroutines_core() && cancelMakeCompleting(cause)) {
            return true;
        }
        return makeCancelling(cause);
    }

    private final JobCancellationException createJobCancellationException() {
        return new JobCancellationException("Job was cancelled", null, this);
    }

    @Override // kotlinx.coroutines.ParentJob
    public Throwable getChildJobCancellationCause() {
        Throwable th;
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
        } else {
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + state$kotlinx_coroutines_core).toString());
            }
            th = state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : null;
        }
        return (th == null || (getHandlesException() && !(th instanceof CancellationException))) ? new JobCancellationException("Parent job is " + stateString(state$kotlinx_coroutines_core), th, this) : th;
    }

    private final Throwable createCauseException(Object cause) {
        if (cause != null ? cause instanceof Throwable : true) {
            if (cause == null) {
                cause = createJobCancellationException();
            }
            return (Throwable) cause;
        }
        if (cause != null) {
            return ((ParentJob) cause).getChildJobCancellationCause();
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean makeCancelling(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
            java.lang.Throwable r1 = (java.lang.Throwable) r1
        L4:
            java.lang.Object r2 = r7.getState$kotlinx_coroutines_core()
            boolean r3 = r2 instanceof kotlinx.coroutines.JobSupport.Finishing
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L4c
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch: java.lang.Throwable -> L49
            boolean r3 = r3.isSealed()     // Catch: java.lang.Throwable -> L49
            if (r3 == 0) goto L1a
            monitor-exit(r2)
            return r4
        L1a:
            r3 = r2
            kotlinx.coroutines.JobSupport$Finishing r3 = (kotlinx.coroutines.JobSupport.Finishing) r3     // Catch: java.lang.Throwable -> L49
            boolean r3 = r3.isCancelling()     // Catch: java.lang.Throwable -> L49
            if (r8 != 0) goto L25
            if (r3 != 0) goto L32
        L25:
            if (r1 == 0) goto L28
            goto L2c
        L28:
            java.lang.Throwable r1 = r7.createCauseException(r8)     // Catch: java.lang.Throwable -> L49
        L2c:
            r8 = r2
            kotlinx.coroutines.JobSupport$Finishing r8 = (kotlinx.coroutines.JobSupport.Finishing) r8     // Catch: java.lang.Throwable -> L49
            r8.addExceptionLocked(r1)     // Catch: java.lang.Throwable -> L49
        L32:
            r8 = r2
            kotlinx.coroutines.JobSupport$Finishing r8 = (kotlinx.coroutines.JobSupport.Finishing) r8     // Catch: java.lang.Throwable -> L49
            java.lang.Throwable r8 = r8.rootCause     // Catch: java.lang.Throwable -> L49
            r1 = r3 ^ 1
            if (r1 == 0) goto L3c
            r0 = r8
        L3c:
            monitor-exit(r2)
            if (r0 == 0) goto L48
            kotlinx.coroutines.JobSupport$Finishing r2 = (kotlinx.coroutines.JobSupport.Finishing) r2
            kotlinx.coroutines.NodeList r8 = r2.getList()
            r7.notifyCancelling(r8, r0)
        L48:
            return r5
        L49:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L4c:
            boolean r3 = r2 instanceof kotlinx.coroutines.Incomplete
            if (r3 == 0) goto La9
            if (r1 == 0) goto L53
            goto L57
        L53:
            java.lang.Throwable r1 = r7.createCauseException(r8)
        L57:
            r3 = r2
            kotlinx.coroutines.Incomplete r3 = (kotlinx.coroutines.Incomplete) r3
            boolean r6 = r3.getIsActive()
            if (r6 == 0) goto L67
            boolean r2 = r7.tryMakeCancelling(r3, r1)
            if (r2 == 0) goto L4
            return r5
        L67:
            kotlinx.coroutines.CompletedExceptionally r3 = new kotlinx.coroutines.CompletedExceptionally
            r3.<init>(r1)
            int r3 = r7.tryMakeCompleting(r2, r3, r4)
            if (r3 == 0) goto L8a
            if (r3 == r5) goto L89
            r2 = 2
            if (r3 == r2) goto L89
            r2 = 3
            if (r3 != r2) goto L7b
            goto L4
        L7b:
            java.lang.String r8 = "unexpected result"
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        L89:
            return r5
        L8a:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Cannot happen in "
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.StringBuilder r8 = r8.append(r2)
            java.lang.String r8 = r8.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r8 = r8.toString()
            r0.<init>(r8)
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            throw r0
        La9:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport.makeCancelling(java.lang.Object):boolean");
    }

    private final NodeList getOrPromoteCancellingList(Incomplete state) {
        NodeList list = state.getList();
        if (list != null) {
            return list;
        }
        if (state instanceof Empty) {
            return new NodeList();
        }
        if (state instanceof JobNode) {
            promoteSingleToNodeList((JobNode) state);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + state).toString());
    }

    private final boolean tryMakeCancelling(Incomplete state, Throwable rootCause) {
        if (!(!(state instanceof Finishing))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!state.getIsActive()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return false;
        }
        if (!_state$FU.compareAndSet(this, state, new Finishing(orPromoteCancellingList, false, rootCause))) {
            return false;
        }
        notifyCancelling(orPromoteCancellingList, rootCause);
        return true;
    }

    private final int tryMakeCompleting(Object state, Object proposedUpdate, int mode) {
        if (!(state instanceof Incomplete)) {
            return 0;
        }
        if (((state instanceof Empty) || (state instanceof JobNode)) && !(state instanceof ChildHandleNode) && !(proposedUpdate instanceof CompletedExceptionally)) {
            return !tryFinalizeSimpleState((Incomplete) state, proposedUpdate, mode) ? 3 : 1;
        }
        Incomplete incomplete = (Incomplete) state;
        NodeList orPromoteCancellingList = getOrPromoteCancellingList(incomplete);
        if (orPromoteCancellingList == null) {
            return 3;
        }
        Finishing finishing = (Finishing) (!(state instanceof Finishing) ? null : state);
        if (finishing == null) {
            finishing = new Finishing(orPromoteCancellingList, false, null);
        }
        synchronized (finishing) {
            if (finishing.completing) {
                return 0;
            }
            finishing.completing = true;
            if (finishing != state && !_state$FU.compareAndSet(this, state, finishing)) {
                return 3;
            }
            if (!(!finishing.isSealed())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            boolean isCancelling = finishing.isCancelling();
            CompletedExceptionally completedExceptionally = (CompletedExceptionally) (!(proposedUpdate instanceof CompletedExceptionally) ? null : proposedUpdate);
            if (completedExceptionally != null) {
                finishing.addExceptionLocked(completedExceptionally.cause);
            }
            Throwable th = isCancelling ^ true ? finishing.rootCause : null;
            Unit unit = Unit.INSTANCE;
            if (th != null) {
                notifyCancelling(orPromoteCancellingList, th);
            }
            ChildHandleNode firstChild = firstChild(incomplete);
            if (firstChild == null || !tryWaitForChild(finishing, firstChild, proposedUpdate)) {
                return tryFinalizeFinishingState(finishing, proposedUpdate, mode) ? 1 : 3;
            }
            return 2;
        }
    }

    private final Throwable getExceptionOrNull(Object obj) {
        if (!(obj instanceof CompletedExceptionally)) {
            obj = null;
        }
        CompletedExceptionally completedExceptionally = (CompletedExceptionally) obj;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    private final ChildHandleNode firstChild(Incomplete state) {
        ChildHandleNode childHandleNode = (ChildHandleNode) (!(state instanceof ChildHandleNode) ? null : state);
        if (childHandleNode != null) {
            return childHandleNode;
        }
        NodeList list = state.getList();
        if (list != null) {
            return nextChild(list);
        }
        return null;
    }

    private final boolean tryWaitForChild(Finishing state, ChildHandleNode child, Object proposedUpdate) {
        while (Job.DefaultImpls.invokeOnCompletion$default(child.childJob, false, false, new ChildCompletion(this, state, child, proposedUpdate), 1, null) == NonDisposableHandle.INSTANCE) {
            child = nextChild(child);
            if (child == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void continueCompleting(Finishing state, ChildHandleNode lastChild, Object proposedUpdate) {
        if (!(getState$kotlinx_coroutines_core() == state)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        ChildHandleNode nextChild = nextChild(lastChild);
        if ((nextChild == null || !tryWaitForChild(state, nextChild, proposedUpdate)) && tryFinalizeFinishingState(state, proposedUpdate, 0)) {
        }
    }

    private final ChildHandleNode nextChild(LockFreeLinkedListNode lockFreeLinkedListNode) {
        while (lockFreeLinkedListNode.isRemoved()) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getPrevNode();
        }
        while (true) {
            lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode();
            if (!lockFreeLinkedListNode.isRemoved()) {
                if (lockFreeLinkedListNode instanceof ChildHandleNode) {
                    return (ChildHandleNode) lockFreeLinkedListNode;
                }
                if (lockFreeLinkedListNode instanceof NodeList) {
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final Sequence<Job> getChildren() {
        return SequencesKt.sequence(new JobSupport$children$1(this, null));
    }

    @Override // kotlinx.coroutines.Job
    public final ChildHandle attachChild(ChildJob child) {
        Intrinsics.checkParameterIsNotNull(child, "child");
        DisposableHandle invokeOnCompletion$default = Job.DefaultImpls.invokeOnCompletion$default(this, true, false, new ChildHandleNode(this, child), 2, null);
        if (invokeOnCompletion$default != null) {
            return (ChildHandle) invokeOnCompletion$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        throw exception;
    }

    private final boolean cancelParent(Throwable cause) {
        if (cause instanceof CancellationException) {
            return true;
        }
        if (!getCancelsParent()) {
            return false;
        }
        ChildHandle childHandle = this.parentHandle;
        return childHandle != null && childHandle.childCancelled(cause);
    }

    public String toString() {
        return toDebugString() + '@' + DebugKt.getHexAddress(this);
    }

    public final String toDebugString() {
        return nameString$kotlinx_coroutines_core() + '{' + stateString(getState$kotlinx_coroutines_core()) + '}';
    }

    public String nameString$kotlinx_coroutines_core() {
        return DebugKt.getClassSimpleName(this);
    }

    private final String stateString(Object state) {
        if (!(state instanceof Finishing)) {
            return state instanceof Incomplete ? ((Incomplete) state).getIsActive() ? "Active" : "New" : state instanceof CompletedExceptionally ? "Cancelled" : "Completed";
        }
        Finishing finishing = (Finishing) state;
        return finishing.isCancelling() ? "Cancelling" : finishing.completing ? "Completing" : "Active";
    }

    /* compiled from: JobSupport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tJ\u0018\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0016j\b\u0012\u0004\u0012\u00020\t`\u0017H\u0002J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\tJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\rR\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", XmlErrorCodes.LIST, "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "isActive", "()Z", "isCancelling", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class Finishing implements Incomplete {

        /* renamed from: _exceptionsHolder, reason: from kotlin metadata and from toString */
        private volatile Object exceptions;

        /* renamed from: isCompleting, reason: from kotlin metadata and from toString */
        public volatile boolean completing;
        private final NodeList list;
        public volatile Throwable rootCause;

        @Override // kotlinx.coroutines.Incomplete
        public NodeList getList() {
            return this.list;
        }

        public Finishing(NodeList list, boolean z, Throwable th) {
            Intrinsics.checkParameterIsNotNull(list, "list");
            this.list = list;
            this.completing = z;
            this.rootCause = th;
        }

        public final boolean isSealed() {
            Symbol symbol;
            Object obj = this.exceptions;
            symbol = JobSupportKt.SEALED;
            return obj == symbol;
        }

        public final boolean isCancelling() {
            return this.rootCause != null;
        }

        @Override // kotlinx.coroutines.Incomplete
        /* renamed from: isActive */
        public boolean getIsActive() {
            return this.rootCause == null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final List<Throwable> sealLocked(Throwable proposedException) {
            ArrayList<Throwable> arrayList;
            Symbol symbol;
            Object obj = this.exceptions;
            if (obj == null) {
                arrayList = allocateList();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> allocateList = allocateList();
                allocateList.add(obj);
                arrayList = allocateList;
            } else {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                }
                arrayList = (ArrayList) obj;
            }
            Throwable th = this.rootCause;
            if (th != null) {
                arrayList.add(0, th);
            }
            if (proposedException != null && (!Intrinsics.areEqual(proposedException, th))) {
                arrayList.add(proposedException);
            }
            symbol = JobSupportKt.SEALED;
            this.exceptions = symbol;
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void addExceptionLocked(Throwable exception) {
            Intrinsics.checkParameterIsNotNull(exception, "exception");
            Throwable th = this.rootCause;
            if (th == null) {
                this.rootCause = exception;
                return;
            }
            if (exception == th) {
                return;
            }
            Object obj = this.exceptions;
            if (obj == null) {
                this.exceptions = exception;
                return;
            }
            if (!(obj instanceof Throwable)) {
                if (!(obj instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Throwable> /* = java.util.ArrayList<kotlin.Throwable> */");
                }
                ((ArrayList) obj).add(exception);
                return;
            }
            if (exception == obj) {
                return;
            }
            ArrayList<Throwable> allocateList = allocateList();
            allocateList.add(obj);
            allocateList.add(exception);
            this.exceptions = allocateList;
        }

        private final ArrayList<Throwable> allocateList() {
            return new ArrayList<>(4);
        }

        public String toString() {
            return "Finishing[cancelling=" + isCancelling() + ", completing=" + this.completing + ", rootCause=" + this.rootCause + ", exceptions=" + this.exceptions + ", list=" + getList() + PropertyUtils.INDEXED_DELIM2;
        }
    }

    private final boolean isCancelling(Incomplete incomplete) {
        return (incomplete instanceof Finishing) && ((Finishing) incomplete).isCancelling();
    }

    /* compiled from: JobSupport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class ChildCompletion extends JobNode<Job> {
        private final ChildHandleNode child;
        private final JobSupport parent;
        private final Object proposedUpdate;
        private final Finishing state;

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildCompletion(JobSupport parent, Finishing state, ChildHandleNode child, Object obj) {
            super(child.childJob);
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(child, "child");
            this.parent = parent;
            this.state = state;
            this.child = child;
            this.proposedUpdate = obj;
        }

        @Override // kotlinx.coroutines.CompletionHandlerBase
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(Throwable cause) {
            this.parent.continueCompleting(this.state, this.child, this.proposedUpdate);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ChildCompletion[" + this.child + ", " + this.proposedUpdate + PropertyUtils.INDEXED_DELIM2;
        }
    }

    /* compiled from: JobSupport.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
    private static final class AwaitContinuation<T> extends CancellableContinuationImpl<T> {
        private final JobSupport job;

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AwaitContinuation(Continuation<? super T> delegate, JobSupport job) {
            super(delegate, 1);
            Intrinsics.checkParameterIsNotNull(delegate, "delegate");
            Intrinsics.checkParameterIsNotNull(job, "job");
            this.job = job;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(Job parent) {
            Throwable th;
            Intrinsics.checkParameterIsNotNull(parent, "parent");
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            return (!(state$kotlinx_coroutines_core instanceof Finishing) || (th = ((Finishing) state$kotlinx_coroutines_core).rootCause) == null) ? state$kotlinx_coroutines_core instanceof CompletedExceptionally ? ((CompletedExceptionally) state$kotlinx_coroutines_core).cause : parent.getCancellationException() : th;
        }
    }

    public final boolean isCompletedExceptionally() {
        return getState$kotlinx_coroutines_core() instanceof CompletedExceptionally;
    }

    public final Throwable getCompletionExceptionOrNull() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        return getExceptionOrNull(state$kotlinx_coroutines_core);
    }

    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!(!(state$kotlinx_coroutines_core instanceof Incomplete))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            throw ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    public final Object awaitInternal$kotlinx_coroutines_core(Continuation<Object> continuation) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                    Throwable th = ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
                    if (StackTraceRecoveryKt.recoveryDisabled(th)) {
                        throw th;
                    }
                    InlineMarker.mark(0);
                    if (continuation instanceof CoroutineStackFrame) {
                        throw StackTraceRecoveryKt.recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
                    }
                    throw th;
                }
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return awaitSuspend(continuation);
    }

    final /* synthetic */ Object awaitSuspend(Continuation<Object> continuation) {
        AwaitContinuation awaitContinuation = new AwaitContinuation(IntrinsicsKt.intercepted(continuation), this);
        CancellableContinuationKt.disposeOnCancellation(awaitContinuation, invokeOnCompletion(new ResumeAwaitOnCompletion(this, awaitContinuation)));
        Object result = awaitContinuation.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final <T, R> void selectAwaitCompletion$kotlinx_coroutines_core(SelectInstance<? super R> select, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            select.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
        } else {
            CancellableKt.startCoroutineCancellable(block, JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion());
        }
    }

    public final Object getState$kotlinx_coroutines_core() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof OpDescriptor)) {
                return obj;
            }
            ((OpDescriptor) obj).perform(this);
        }
    }

    private final void notifyCompletion(NodeList nodeList, Throwable th) {
        Throwable th2 = (Throwable) null;
        Object next = nodeList.getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, nodeList); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            if (lockFreeLinkedListNode instanceof JobNode) {
                JobNode jobNode = (JobNode) lockFreeLinkedListNode;
                try {
                    jobNode.invoke(th);
                } catch (Throwable th3) {
                    if (th2 != null) {
                        kotlin.ExceptionsKt.addSuppressed(th2, th3);
                        if (th2 != null) {
                        }
                    }
                    CompletionHandlerException completionHandlerException = new CompletionHandlerException("Exception in completion handler " + jobNode + " for " + this, th3);
                    Unit unit = Unit.INSTANCE;
                    th2 = completionHandlerException;
                }
            }
        }
        if (th2 != null) {
            handleOnCompletionException$kotlinx_coroutines_core(th2);
        }
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        int startInternal;
        do {
            startInternal = startInternal(getState$kotlinx_coroutines_core());
            if (startInternal == 0) {
                return false;
            }
        } while (startInternal != 1);
        return true;
    }

    protected final Throwable getCompletionCause() {
        Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Finishing) {
            Throwable th = ((Finishing) state$kotlinx_coroutines_core).rootCause;
            if (th != null) {
                return th;
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            return ((CompletedExceptionally) state$kotlinx_coroutines_core).cause;
        }
        return null;
    }

    private final boolean addLastAtomic(final Object expect, NodeList list, JobNode<?> node) {
        int tryCondAddNext;
        final JobNode<?> jobNode = node;
        LockFreeLinkedListNode.CondAddOp condAddOp = new LockFreeLinkedListNode.CondAddOp(jobNode) { // from class: kotlinx.coroutines.JobSupport$addLastAtomic$$inlined$addLastIf$1
            @Override // kotlinx.coroutines.internal.AtomicOp
            public Object prepare(LockFreeLinkedListNode affected) {
                Intrinsics.checkParameterIsNotNull(affected, "affected");
                if (this.getState$kotlinx_coroutines_core() == expect) {
                    return null;
                }
                return LockFreeLinkedListKt.getCONDITION_FALSE();
            }
        };
        do {
            Object prev = list.getPrev();
            if (prev == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
            tryCondAddNext = ((LockFreeLinkedListNode) prev).tryCondAddNext(jobNode, list, condAddOp);
            if (tryCondAddNext == 1) {
                return true;
            }
        } while (tryCondAddNext != 2);
        return false;
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                return false;
            }
        } while (startInternal(state$kotlinx_coroutines_core) < 0);
        return true;
    }

    final /* synthetic */ Object joinSuspend(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, invokeOnCompletion(new ResumeOnCompletion(this, cancellableContinuationImpl2)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // kotlinx.coroutines.selects.SelectClause0
    public final <R> void registerSelectClause0(SelectInstance<? super R> select, Function1<? super Continuation<? super R>, ? extends Object> block) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(select, "select");
        Intrinsics.checkParameterIsNotNull(block, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (select.trySelect(null)) {
                    YieldKt.checkCompletion(select.getCompletion().getContext());
                    UndispatchedKt.startCoroutineUnintercepted(block, select.getCompletion());
                    return;
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new SelectJoinOnCompletion(this, select, block)));
    }

    public final void removeNode$kotlinx_coroutines_core(JobNode<?> node) {
        Object state$kotlinx_coroutines_core;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Empty empty;
        Intrinsics.checkParameterIsNotNull(node, "node");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof JobNode)) {
                if (!(state$kotlinx_coroutines_core instanceof Incomplete) || ((Incomplete) state$kotlinx_coroutines_core).getList() == null) {
                    return;
                }
                node.remove();
                return;
            }
            if (state$kotlinx_coroutines_core != node) {
                return;
            }
            atomicReferenceFieldUpdater = _state$FU;
            empty = JobSupportKt.EMPTY_ACTIVE;
        } while (!atomicReferenceFieldUpdater.compareAndSet(this, state$kotlinx_coroutines_core, empty));
    }

    private final boolean cancelMakeCompleting(Object cause) {
        int tryMakeCompleting;
        do {
            Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (!(state$kotlinx_coroutines_core instanceof Incomplete) || (((state$kotlinx_coroutines_core instanceof Finishing) && ((Finishing) state$kotlinx_coroutines_core).completing) || (tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, new CompletedExceptionally(createCauseException(cause)), 0)) == 0)) {
                return false;
            }
            if (tryMakeCompleting == 1 || tryMakeCompleting == 2) {
                return true;
            }
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final boolean makeCompleting$kotlinx_coroutines_core(Object proposedUpdate) {
        int tryMakeCompleting;
        do {
            boolean z = false;
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate, 0);
            if (tryMakeCompleting != 0) {
                z = true;
                if (tryMakeCompleting != 1 && tryMakeCompleting != 2) {
                }
            }
            return z;
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final boolean makeCompletingOnce$kotlinx_coroutines_core(Object proposedUpdate, int mode) {
        int tryMakeCompleting;
        do {
            tryMakeCompleting = tryMakeCompleting(getState$kotlinx_coroutines_core(), proposedUpdate, mode);
            if (tryMakeCompleting == 0) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + proposedUpdate, getExceptionOrNull(proposedUpdate));
            }
            if (tryMakeCompleting == 1) {
                return true;
            }
            if (tryMakeCompleting == 2) {
                return false;
            }
        } while (tryMakeCompleting == 3);
        throw new IllegalStateException("unexpected result".toString());
    }

    public final <T, R> void registerSelectClause1Internal$kotlinx_coroutines_core(SelectInstance<? super R> select, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Object state$kotlinx_coroutines_core;
        Intrinsics.checkParameterIsNotNull(select, "select");
        Intrinsics.checkParameterIsNotNull(block, "block");
        do {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
            if (select.isSelected()) {
                return;
            }
            if (!(state$kotlinx_coroutines_core instanceof Incomplete)) {
                if (select.trySelect(null)) {
                    if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                        select.resumeSelectCancellableWithException(((CompletedExceptionally) state$kotlinx_coroutines_core).cause);
                        return;
                    } else {
                        UndispatchedKt.startCoroutineUnintercepted(block, JobSupportKt.unboxState(state$kotlinx_coroutines_core), select.getCompletion());
                        return;
                    }
                }
                return;
            }
        } while (startInternal(state$kotlinx_coroutines_core) != 0);
        select.disposeOnSelect(invokeOnCompletion(new SelectAwaitOnCompletion(this, select, block)));
    }
}
