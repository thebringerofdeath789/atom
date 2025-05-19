package com.logan.usb.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

/* compiled from: CoroutineForJava.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/logan/usb/utils/CoroutineForJava;", "", "()V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "setScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "cancel", "", "launch", "jobRunner", "Lcom/logan/usb/utils/CoroutineForJava$JobRunner;", "JobRunner", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class CoroutineForJava {
    private final Job job;
    private CoroutineScope scope;

    /* compiled from: CoroutineForJava.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/logan/usb/utils/CoroutineForJava$JobRunner;", "", "onRun", "", "Protocols_release"}, k = 1, mv = {1, 1, 15})
    public interface JobRunner {
        void onRun();
    }

    public CoroutineForJava() {
        Job Job$default;
        Job$default = JobKt__JobKt.Job$default(null, 1, null);
        this.job = Job$default;
        this.scope = CoroutineScopeKt.CoroutineScope(Job$default);
    }

    public final Job getJob() {
        return this.job;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setScope(CoroutineScope coroutineScope) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "<set-?>");
        this.scope = coroutineScope;
    }

    public final Job launch(JobRunner jobRunner) {
        Job launch$default;
        Intrinsics.checkParameterIsNotNull(jobRunner, "jobRunner");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new CoroutineForJava$launch$job1$1(jobRunner, null), 3, null);
        return launch$default;
    }

    public final void cancel() {
        this.job.cancel();
    }
}
