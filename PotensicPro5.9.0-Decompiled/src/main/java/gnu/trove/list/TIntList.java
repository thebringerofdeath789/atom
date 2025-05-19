package gnu.trove.list;

import gnu.trove.TIntCollection;
import gnu.trove.function.TIntFunction;
import gnu.trove.procedure.TIntProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TIntList extends TIntCollection {
    void add(int[] iArr);

    void add(int[] iArr, int i, int i2);

    @Override // gnu.trove.TIntCollection
    boolean add(int i);

    int binarySearch(int i);

    int binarySearch(int i, int i2, int i3);

    @Override // gnu.trove.TIntCollection
    void clear();

    @Override // gnu.trove.TIntCollection
    boolean contains(int i);

    void fill(int i);

    void fill(int i, int i2, int i3);

    @Override // gnu.trove.TIntCollection
    boolean forEach(TIntProcedure tIntProcedure);

    boolean forEachDescending(TIntProcedure tIntProcedure);

    int get(int i);

    @Override // gnu.trove.TIntCollection
    int getNoEntryValue();

    TIntList grep(TIntProcedure tIntProcedure);

    int indexOf(int i);

    int indexOf(int i, int i2);

    void insert(int i, int i2);

    void insert(int i, int[] iArr);

    void insert(int i, int[] iArr, int i2, int i3);

    TIntList inverseGrep(TIntProcedure tIntProcedure);

    @Override // gnu.trove.TIntCollection
    boolean isEmpty();

    int lastIndexOf(int i);

    int lastIndexOf(int i, int i2);

    int max();

    int min();

    void remove(int i, int i2);

    @Override // gnu.trove.TIntCollection
    boolean remove(int i);

    int removeAt(int i);

    int replace(int i, int i2);

    void reverse();

    void reverse(int i, int i2);

    int set(int i, int i2);

    void set(int i, int[] iArr);

    void set(int i, int[] iArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TIntCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TIntList subList(int i, int i2);

    int sum();

    @Override // gnu.trove.TIntCollection
    int[] toArray();

    int[] toArray(int i, int i2);

    @Override // gnu.trove.TIntCollection
    int[] toArray(int[] iArr);

    int[] toArray(int[] iArr, int i, int i2);

    int[] toArray(int[] iArr, int i, int i2, int i3);

    void transformValues(TIntFunction tIntFunction);
}
