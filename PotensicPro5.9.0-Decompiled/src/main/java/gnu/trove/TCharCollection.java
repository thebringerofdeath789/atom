package gnu.trove;

import gnu.trove.iterator.TCharIterator;
import gnu.trove.procedure.TCharProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TCharCollection {
    public static final long serialVersionUID = 1;

    boolean add(char c);

    boolean addAll(TCharCollection tCharCollection);

    boolean addAll(Collection<? extends Character> collection);

    boolean addAll(char[] cArr);

    void clear();

    boolean contains(char c);

    boolean containsAll(TCharCollection tCharCollection);

    boolean containsAll(Collection<?> collection);

    boolean containsAll(char[] cArr);

    boolean equals(Object obj);

    boolean forEach(TCharProcedure tCharProcedure);

    char getNoEntryValue();

    int hashCode();

    boolean isEmpty();

    TCharIterator iterator();

    boolean remove(char c);

    boolean removeAll(TCharCollection tCharCollection);

    boolean removeAll(Collection<?> collection);

    boolean removeAll(char[] cArr);

    boolean retainAll(TCharCollection tCharCollection);

    boolean retainAll(Collection<?> collection);

    boolean retainAll(char[] cArr);

    int size();

    char[] toArray();

    char[] toArray(char[] cArr);
}
