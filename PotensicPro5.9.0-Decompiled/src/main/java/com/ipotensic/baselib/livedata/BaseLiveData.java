package com.ipotensic.baselib.livedata;

import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ipotensic/baselib/livedata/BaseLiveData;", "Landroidx/databinding/Observable;", "()V", "mCallbacks", "Landroidx/databinding/PropertyChangeRegistry;", "addOnPropertyChangedCallback", "", "callback", "Landroidx/databinding/Observable$OnPropertyChangedCallback;", "notifyChange", "notifyPropertyChanged", "fieldId", "", "removeAllCallback", "removeOnPropertyChangedCallback", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class BaseLiveData implements Observable {
    private transient PropertyChangeRegistry mCallbacks;

    @Override // androidx.databinding.Observable
    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
            Unit unit = Unit.INSTANCE;
        }
        PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
        if (propertyChangeRegistry == null) {
            Intrinsics.throwNpe();
        }
        propertyChangeRegistry.add(callback);
    }

    @Override // androidx.databinding.Observable
    public void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback callback) {
        Intrinsics.checkParameterIsNotNull(callback, "callback");
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                Intrinsics.throwNpe();
            }
            propertyChangeRegistry.remove(callback);
        }
    }

    public final void notifyChange() {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                Intrinsics.throwNpe();
            }
            propertyChangeRegistry.notifyCallbacks(this, 0, null);
        }
    }

    public final void notifyPropertyChanged(int fieldId) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            Unit unit = Unit.INSTANCE;
            PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
            if (propertyChangeRegistry == null) {
                Intrinsics.throwNpe();
            }
            propertyChangeRegistry.notifyCallbacks(this, fieldId, null);
        }
    }

    public final void removeAllCallback() {
        PropertyChangeRegistry propertyChangeRegistry = this.mCallbacks;
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.clear();
        }
        this.mCallbacks = (PropertyChangeRegistry) null;
    }
}
