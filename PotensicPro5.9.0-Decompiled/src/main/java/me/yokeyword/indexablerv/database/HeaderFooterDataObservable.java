package me.yokeyword.indexablerv.database;

import android.database.Observable;

/* loaded from: classes4.dex */
public class HeaderFooterDataObservable extends Observable<HeaderFooterDataObserver> {
    public void notifyChanged() {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onChanged();
            }
        }
    }

    public void notifyAdd(boolean z, Object obj, Object obj2) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onAdd(z, obj, obj2);
            }
        }
    }

    public void notifyRemove(boolean z, Object obj) {
        synchronized (this.mObservers) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((HeaderFooterDataObserver) this.mObservers.get(size)).onRemove(z, obj);
            }
        }
    }
}
