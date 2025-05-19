package io.netty.channel;

import io.netty.util.IntSupplier;

/* loaded from: classes3.dex */
public interface SelectStrategy {
    public static final int CONTINUE = -2;
    public static final int SELECT = -1;

    int calculateStrategy(IntSupplier intSupplier, boolean z) throws Exception;
}
