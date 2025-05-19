package me.yokeyword.indexablerv.database;

import android.database.Observable;

/* loaded from: classes4.dex */
public class DataObservable extends Observable<DataObserver> {
    public void notifyInited() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onInited();
            }
        }
    }

    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }

    public void notifySetListener(int i) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((DataObserver) this.mObservers.get(size)).onSetListener(i);
            }
        }
    }
}
