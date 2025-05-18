package gnu.trove.list;

import gnu.trove.list.TLinkable;

/* loaded from: classes3.dex */
public abstract class TLinkableAdapter<T extends TLinkable> implements TLinkable<T> {
    private volatile T next;
    private volatile T prev;

    @Override // gnu.trove.list.TLinkable
    public T getNext() {
        return this.next;
    }

    @Override // gnu.trove.list.TLinkable
    public void setNext(T t) {
        this.next = t;
    }

    @Override // gnu.trove.list.TLinkable
    public T getPrevious() {
        return this.prev;
    }

    @Override // gnu.trove.list.TLinkable
    public void setPrevious(T t) {
        this.prev = t;
    }
}