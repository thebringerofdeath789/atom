package gnu.trove.queue;

import gnu.trove.TShortCollection;

/* loaded from: classes3.dex */
public interface TShortQueue extends TShortCollection {
    short element();

    boolean offer(short s);

    short peek();

    short poll();
}
