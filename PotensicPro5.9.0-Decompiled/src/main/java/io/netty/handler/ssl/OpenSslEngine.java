package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;

/* loaded from: classes4.dex */
public final class OpenSslEngine extends ReferenceCountedOpenSslEngine {
    OpenSslEngine(OpenSslContext openSslContext, ByteBufAllocator byteBufAllocator, String str, int i, boolean z) {
        super(openSslContext, byteBufAllocator, str, i, z, false);
    }

    protected void finalize() throws Throwable {
        super.finalize();
        OpenSsl.releaseIfNeeded(this);
    }
}
