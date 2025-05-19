package io.netty.util;

@Deprecated
/* loaded from: classes4.dex */
public interface ResourceLeak {
    boolean close();

    void record();

    void record(Object obj);
}
