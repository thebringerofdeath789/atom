package me.yokeyword.indexablerv.database;

import android.database.Observable;

/* loaded from: classes4.dex */
public class IndexBarDataObservable extends Observable<IndexBarDataObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((IndexBarDataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }
}
