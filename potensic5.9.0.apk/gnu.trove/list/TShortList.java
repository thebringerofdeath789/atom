package gnu.trove.list;

import gnu.trove.TShortCollection;
import gnu.trove.function.TShortFunction;
import gnu.trove.procedure.TShortProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TShortList extends TShortCollection {
    void add(short[] sArr);

    void add(short[] sArr, int i, int i2);

    @Override // gnu.trove.TShortCollection
    boolean add(short s);

    int binarySearch(short s);

    int binarySearch(short s, int i, int i2);

    @Override // gnu.trove.TShortCollection
    void clear();

    @Override // gnu.trove.TShortCollection
    boolean contains(short s);

    void fill(int i, int i2, short s);

    void fill(short s);

    @Override // gnu.trove.TShortCollection
    boolean forEach(TShortProcedure tShortProcedure);

    boolean forEachDescending(TShortProcedure tShortProcedure);

    short get(int i);

    @Override // gnu.trove.TShortCollection
    short getNoEntryValue();

    TShortList grep(TShortProcedure tShortProcedure);

    int indexOf(int i, short s);

    int indexOf(short s);

    void insert(int i, short s);

    void insert(int i, short[] sArr);

    void insert(int i, short[] sArr, int i2, int i3);

    TShortList inverseGrep(TShortProcedure tShortProcedure);

    @Override // gnu.trove.TShortCollection
    boolean isEmpty();

    int lastIndexOf(int i, short s);

    int lastIndexOf(short s);

    short max();

    short min();

    void remove(int i, int i2);

    @Override // gnu.trove.TShortCollection
    boolean remove(short s);

    short removeAt(int i);

    short replace(int i, short s);

    void reverse();

    void reverse(int i, int i2);

    short set(int i, short s);

    void set(int i, short[] sArr);

    void set(int i, short[] sArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TShortCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TShortList subList(int i, int i2);

    short sum();

    @Override // gnu.trove.TShortCollection
    short[] toArray();

    short[] toArray(int i, int i2);

    @Override // gnu.trove.TShortCollection
    short[] toArray(short[] sArr);

    short[] toArray(short[] sArr, int i, int i2);

    short[] toArray(short[] sArr, int i, int i2, int i3);

    void transformValues(TShortFunction tShortFunction);
}