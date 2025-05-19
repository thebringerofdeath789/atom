package io.netty.util.internal;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
interface Cleaner {
    void freeDirectBuffer(ByteBuffer byteBuffer);
}
