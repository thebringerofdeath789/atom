package gnu.trove.queue;

import gnu.trove.TCharCollection;

/* loaded from: classes3.dex */
public interface TCharQueue extends TCharCollection {
    char element();

    boolean offer(char c);

    char peek();

    char poll();
}