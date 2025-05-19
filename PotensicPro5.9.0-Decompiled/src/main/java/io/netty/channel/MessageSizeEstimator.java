package io.netty.channel;

/* loaded from: classes3.dex */
public interface MessageSizeEstimator {

    public interface Handle {
        int size(Object obj);
    }

    Handle newHandle();
}
