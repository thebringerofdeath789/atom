package com.ipotensic.kernel.test;

import androidx.databinding.BaseObservable;
import androidx.databinding.Observable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

/* loaded from: classes2.dex */
public abstract class BaseModelObservable extends BaseObservable {
    private final Observable.OnPropertyChangedCallback callback = new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.test.BaseModelObservable.2
        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (BaseModelObservable.this.propertyChangeListener != null) {
                BaseModelObservable.this.propertyChangeListener.onPropertyChanged(observable, i);
            }
        }
    };
    private OnPropertyChangeListener propertyChangeListener;

    public interface OnPropertyChangeListener {
        void onPropertyChanged(Observable observable, int i);
    }

    public abstract void onDestroy();

    public BaseModelObservable(final Lifecycle lifecycle, final OnPropertyChangeListener onPropertyChangeListener) {
        addPropertyChangeListener(onPropertyChangeListener);
        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.ipotensic.kernel.test.BaseModelObservable.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    BaseModelObservable.this.removePropertyChangeListener(onPropertyChangeListener);
                    BaseModelObservable.this.onDestroy();
                    lifecycle.removeObserver(this);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removePropertyChangeListener(OnPropertyChangeListener onPropertyChangeListener) {
        this.propertyChangeListener = null;
        removeOnPropertyChangedCallback(this.callback);
    }

    private void addPropertyChangeListener(OnPropertyChangeListener onPropertyChangeListener) {
        this.propertyChangeListener = onPropertyChangeListener;
        addOnPropertyChangedCallback(this.callback);
    }
}