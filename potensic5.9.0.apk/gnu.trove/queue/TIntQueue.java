package gnu.trove.queue;

import gnu.trove.TIntCollection;

/* loaded from: classes3.dex */
public interface TIntQueue extends TIntCollection {
    int element();

    boolean offer(int i);

    int peek();

    int poll();
}