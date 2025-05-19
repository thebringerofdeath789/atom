package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: Job.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'¨\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/ParentJob;", "Lkotlinx/coroutines/Job;", "getChildJobCancellationCause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 13})
/* loaded from: classes4.dex */
public interface ParentJob extends Job {

    /* compiled from: Job.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left here for binary compatibility")
        public static /* synthetic */ boolean cancel(ParentJob parentJob) {
            boolean cancel;
            cancel = parentJob.cancel(null);
            return cancel;
        }

        public static <R> R fold(ParentJob parentJob, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
            Intrinsics.checkParameterIsNotNull(operation, "operation");
            return (R) Job.DefaultImpls.fold(parentJob, r, operation);
        }

        public static <E extends CoroutineContext.Element> E get(ParentJob parentJob, CoroutineContext.Key<E> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return (E) Job.DefaultImpls.get(parentJob, key);
        }

        public static CoroutineContext minusKey(ParentJob parentJob, CoroutineContext.Key<?> key) {
            Intrinsics.checkParameterIsNotNull(key, "key");
            return Job.DefaultImpls.minusKey(parentJob, key);
        }

        public static CoroutineContext plus(ParentJob parentJob, CoroutineContext context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            return Job.DefaultImpls.plus(parentJob, context);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(ParentJob parentJob, Job other) {
            Intrinsics.checkParameterIsNotNull(other, "other");
            return Job.DefaultImpls.plus((Job) parentJob, other);
        }
    }

    Throwable getChildJobCancellationCause();
}
