package gnu.trove.queue;

import gnu.trove.TDoubleCollection;

/* loaded from: classes3.dex */
public interface TDoubleQueue extends TDoubleCollection {
    double element();

    boolean offer(double d);

    double peek();

    double poll();
}
