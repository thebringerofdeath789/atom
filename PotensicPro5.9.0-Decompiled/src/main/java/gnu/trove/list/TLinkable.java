package gnu.trove.list;

import gnu.trove.list.TLinkable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public interface TLinkable<T extends TLinkable> extends Serializable {
    public static final long serialVersionUID = 997545054865482562L;

    T getNext();

    T getPrevious();

    void setNext(T t);

    void setPrevious(T t);
}
