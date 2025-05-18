package com.ipotensic.baselib.livedata;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataChangedLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/ipotensic/baselib/livedata/DataChangedLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "value", "(Ljava/lang/Object;)V", "postValue", "", "setValue", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DataChangedLiveData<T> extends MutableLiveData<T> {
    public DataChangedLiveData() {
    }

    public DataChangedLiveData(T t) {
        this();
        setValue(t);
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void postValue(T value) {
        if (!Intrinsics.areEqual(value, getValue())) {
            super.postValue(value);
        }
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T value) {
        if (!Intrinsics.areEqual(value, getValue())) {
            super.setValue(value);
        }
    }
}