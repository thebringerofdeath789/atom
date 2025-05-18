package com.ipotensic.baselib.observer;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.mapbox.mapboxsdk.style.layers.Property;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifeCycleNotifyBoolean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/ipotensic/baselib/observer/LifeCycleNotifyBoolean$addNotifyListener$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", Property.SYMBOL_Z_ORDER_SOURCE, "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class LifeCycleNotifyBoolean$addNotifyListener$1 implements LifecycleEventObserver {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1 $onPropertyChangedCallback;

    LifeCycleNotifyBoolean$addNotifyListener$1(LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1 lifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1, Lifecycle lifecycle) {
        r0 = lifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1;
        lifecycle = lifecycle;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner r2, Lifecycle.Event r3) {
        Intrinsics.checkParameterIsNotNull(r2, "source");
        Intrinsics.checkParameterIsNotNull(r3, "event");
        if (r3 == Lifecycle.Event.ON_DESTROY) {
            LifeCycleNotifyBoolean.this.removeOnPropertyChangedCallback(r0);
            lifecycle.removeObserver(this);
        }
    }
}