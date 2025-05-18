package gnu.trove.queue;

import gnu.trove.TLongCollection;

/* loaded from: classes3.dex */
public interface TLongQueue extends TLongCollection {
    long element();

    boolean offer(long j);

    long peek();

    long poll();
}