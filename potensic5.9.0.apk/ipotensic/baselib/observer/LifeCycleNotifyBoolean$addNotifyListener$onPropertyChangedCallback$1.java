package com.ipotensic.baselib.observer;

import androidx.databinding.Observable;
import com.ipotensic.baselib.observer.LifeCycleNotifyBoolean;
import kotlin.Metadata;

/* compiled from: LifeCycleNotifyBoolean.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"com/ipotensic/baselib/observer/LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "onPropertyChanged", "", "sender", "Landroidx/databinding/Observable;", "propertyId", "", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1 extends Observable.OnPropertyChangedCallback {
    final /* synthetic */ LifeCycleNotifyBoolean.OnNotifyListener $notifyListener;

    LifeCycleNotifyBoolean$addNotifyListener$onPropertyChangedCallback$1(LifeCycleNotifyBoolean.OnNotifyListener onNotifyListener) {
        notifyListener = onNotifyListener;
    }

    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
    public void onPropertyChanged(Observable sender, int propertyId) {
        notifyListener.onNotifyChanged(LifeCycleNotifyBoolean.this.get());
    }
}