package gnu.trove.stack;

/* loaded from: classes3.dex */
public interface TDoubleStack {
    void clear();

    double getNoEntryValue();

    double peek();

    double pop();

    void push(double d);

    int size();

    void toArray(double[] dArr);

    double[] toArray();
}