package gnu.trove.set;

import gnu.trove.TCharCollection;
import gnu.trove.iterator.TCharIterator;
import gnu.trove.procedure.TCharProcedure;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface TCharSet extends TCharCollection {
    @Override // gnu.trove.TCharCollection
    boolean add(char c);

    @Override // gnu.trove.TCharCollection
    boolean addAll(TCharCollection tCharCollection);

    @Override // gnu.trove.TCharCollection
    boolean addAll(Collection<? extends Character> collection);

    @Override // gnu.trove.TCharCollection
    boolean addAll(char[] cArr);

    @Override // gnu.trove.TCharCollection
    void clear();

    @Override // gnu.trove.TCharCollection
    boolean contains(char c);

    @Override // gnu.trove.TCharCollection
    boolean containsAll(TCharCollection tCharCollection);

    @Override // gnu.trove.TCharCollection
    boolean containsAll(Collection<?> collection);

    @Override // gnu.trove.TCharCollection
    boolean containsAll(char[] cArr);

    @Override // gnu.trove.TCharCollection
    boolean equals(Object obj);

    @Override // gnu.trove.TCharCollection
    boolean forEach(TCharProcedure tCharProcedure);

    @Override // gnu.trove.TCharCollection
    char getNoEntryValue();

    @Override // gnu.trove.TCharCollection
    int hashCode();

    @Override // gnu.trove.TCharCollection
    boolean isEmpty();

    @Override // gnu.trove.TCharCollection
    TCharIterator iterator();

    @Override // gnu.trove.TCharCollection
    boolean remove(char c);

    @Override // gnu.trove.TCharCollection
    boolean removeAll(TCharCollection tCharCollection);

    @Override // gnu.trove.TCharCollection
    boolean removeAll(Collection<?> collection);

    @Override // gnu.trove.TCharCollection
    boolean removeAll(char[] cArr);

    @Override // gnu.trove.TCharCollection
    boolean retainAll(TCharCollection tCharCollection);

    @Override // gnu.trove.TCharCollection
    boolean retainAll(Collection<?> collection);

    @Override // gnu.trove.TCharCollection
    boolean retainAll(char[] cArr);

    @Override // gnu.trove.TCharCollection
    int size();

    @Override // gnu.trove.TCharCollection
    char[] toArray();

    @Override // gnu.trove.TCharCollection
    char[] toArray(char[] cArr);
}