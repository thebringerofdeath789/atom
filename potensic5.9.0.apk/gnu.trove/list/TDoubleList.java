package gnu.trove.list;

import gnu.trove.TDoubleCollection;
import gnu.trove.function.TDoubleFunction;
import gnu.trove.procedure.TDoubleProcedure;
import java.util.Random;

/* loaded from: classes3.dex */
public interface TDoubleList extends TDoubleCollection {
    void add(double[] dArr);

    void add(double[] dArr, int i, int i2);

    @Override // gnu.trove.TDoubleCollection
    boolean add(double d);

    int binarySearch(double d);

    int binarySearch(double d, int i, int i2);

    @Override // gnu.trove.TDoubleCollection
    void clear();

    @Override // gnu.trove.TDoubleCollection
    boolean contains(double d);

    void fill(double d);

    void fill(int i, int i2, double d);

    @Override // gnu.trove.TDoubleCollection
    boolean forEach(TDoubleProcedure tDoubleProcedure);

    boolean forEachDescending(TDoubleProcedure tDoubleProcedure);

    double get(int i);

    @Override // gnu.trove.TDoubleCollection
    double getNoEntryValue();

    TDoubleList grep(TDoubleProcedure tDoubleProcedure);

    int indexOf(double d);

    int indexOf(int i, double d);

    void insert(int i, double d);

    void insert(int i, double[] dArr);

    void insert(int i, double[] dArr, int i2, int i3);

    TDoubleList inverseGrep(TDoubleProcedure tDoubleProcedure);

    @Override // gnu.trove.TDoubleCollection
    boolean isEmpty();

    int lastIndexOf(double d);

    int lastIndexOf(int i, double d);

    double max();

    double min();

    void remove(int i, int i2);

    @Override // gnu.trove.TDoubleCollection
    boolean remove(double d);

    double removeAt(int i);

    double replace(int i, double d);

    void reverse();

    void reverse(int i, int i2);

    double set(int i, double d);

    void set(int i, double[] dArr);

    void set(int i, double[] dArr, int i2, int i3);

    void shuffle(Random random);

    @Override // gnu.trove.TDoubleCollection
    int size();

    void sort();

    void sort(int i, int i2);

    TDoubleList subList(int i, int i2);

    double sum();

    @Override // gnu.trove.TDoubleCollection
    double[] toArray();

    double[] toArray(int i, int i2);

    @Override // gnu.trove.TDoubleCollection
    double[] toArray(double[] dArr);

    double[] toArray(double[] dArr, int i, int i2);

    double[] toArray(double[] dArr, int i, int i2, int i3);

    void transformValues(TDoubleFunction tDoubleFunction);
}