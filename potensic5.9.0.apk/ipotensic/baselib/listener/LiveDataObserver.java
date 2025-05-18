package com.ipotensic.baselib.listener;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/* loaded from: classes2.dex */
public class LiveDataObserver<T> extends MutableLiveData<T> {
    /* JADX WARN: Multi-variable type inference failed */
    public LiveDataObserver(T t, LifecycleOwner lifecycleOwner, Observer<T> observer) {
        super(t);
        observe(lifecycleOwner, observer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LiveDataObserver(LifecycleOwner lifecycleOwner, Observer<T> observer) {
        observe(lifecycleOwner, observer);
    }
}