package gnu.trove.queue;

import gnu.trove.TByteCollection;

/* loaded from: classes3.dex */
public interface TByteQueue extends TByteCollection {
    byte element();

    boolean offer(byte b);

    byte peek();

    byte poll();
}
