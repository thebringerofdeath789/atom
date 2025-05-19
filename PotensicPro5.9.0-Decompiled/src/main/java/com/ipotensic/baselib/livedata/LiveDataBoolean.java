package com.ipotensic.baselib.livedata;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.ipotensic.baselib.notchtools.helper.ThreadUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;

/* compiled from: LiveDataBoolean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/ipotensic/baselib/livedata/LiveDataBoolean;", "Lcom/ipotensic/baselib/livedata/BaseLiveData;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", XmlErrorCodes.BOOLEAN, "", "(Landroidx/lifecycle/Lifecycle;Z)V", "(Landroidx/lifecycle/Lifecycle;)V", "updateRunnable", "Ljava/lang/Runnable;", "getUpdateRunnable", "()Ljava/lang/Runnable;", "value", "Ljava/lang/Boolean;", "getValue", "setValue", "", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class LiveDataBoolean extends BaseLiveData {
    private final Runnable updateRunnable;
    private Boolean value;

    public LiveDataBoolean(final Lifecycle lifecycle) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.baselib.livedata.LiveDataBoolean.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkParameterIsNotNull(source, "source");
                Intrinsics.checkParameterIsNotNull(event, "event");
                if (event.getTargetState() == Lifecycle.State.DESTROYED) {
                    LiveDataBoolean.this.removeAllCallback();
                    lifecycle.removeObserver(this);
                }
            }
        });
        this.updateRunnable = new Runnable() { // from class: com.ipotensic.baselib.livedata.LiveDataBoolean$updateRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                LiveDataBoolean.this.notifyChange();
            }
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveDataBoolean(Lifecycle lifecycle, boolean z) {
        this(lifecycle);
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        this.value = Boolean.valueOf(z);
    }

    public final void setValue(boolean r3) {
        if (!Intrinsics.areEqual(Boolean.valueOf(r3), this.value)) {
            this.value = Boolean.valueOf(r3);
            if (ThreadUtils.isMainThread()) {
                notifyChange();
            } else {
                ArchTaskExecutor.getInstance().postToMainThread(this.updateRunnable);
            }
        }
    }

    public final boolean getValue() {
        Boolean bool = this.value;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final Runnable getUpdateRunnable() {
        return this.updateRunnable;
    }
}
