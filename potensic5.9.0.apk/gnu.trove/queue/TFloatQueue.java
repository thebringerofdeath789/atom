package gnu.trove.queue;

import gnu.trove.TFloatCollection;

/* loaded from: classes3.dex */
public interface TFloatQueue extends TFloatCollection {
    float element();

    boolean offer(float f);

    float peek();

    float poll();
}