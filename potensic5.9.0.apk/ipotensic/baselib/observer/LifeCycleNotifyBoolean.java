package com.ipotensic.baselib.observer;

import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifeCycleNotifyBoolean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/ipotensic/baselib/observer/LifeCycleNotifyBoolean;", "Landroidx/databinding/ObservableBoolean;", "value", "", "(Z)V", "addNotifyListener", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "notifyListener", "Lcom/ipotensic/baselib/observer/LifeCycleNotifyBoolean$OnNotifyListener;", "OnNotifyListener", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class LifeCycleNotifyBoolean extends ObservableBoolean {

    /* compiled from: LifeCycleNotifyBoolean.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/ipotensic/baselib/observer/LifeCycleNotifyBoolean$OnNotifyListener;", "", "onNotifyChanged", "", "isSet", "", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
    public interface OnNotifyListener {
        void onNotifyChanged(boolean isSet);
    }

    public LifeCycleNotifyBoolean(boolean z) {
        super(z);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ipotensic.baselib.observer.LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1] */
    public final void addNotifyListener(final Lifecycle lifecycle, final OnNotifyListener notifyListener) {
        Intrinsics.checkParameterIsNotNull(lifecycle, "lifecycle");
        Intrinsics.checkParameterIsNotNull(notifyListener, "notifyListener");
        final ?? r0 = new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.baselib.observer.LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable sender, int propertyId) {
                notifyListener.onNotifyChanged(LifeCycleNotifyBoolean.this.get());
            }
        };
        addOnPropertyChangedCallback((Observable.OnPropertyChangedCallback) r0);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.baselib.observer.LifeCycleNotifyBoolean$addNotifyListener$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
                Intrinsics.checkParameterIsNotNull(source, "source");
                Intrinsics.checkParameterIsNotNull(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    LifeCycleNotifyBoolean.this.removeOnPropertyChangedCallback(r0);
                    lifecycle.removeObserver(this);
                }
            }
        });
    }
}