package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;

/* loaded from: classes.dex */
public abstract class ZlibDecoder extends ByteToMessageDecoder {
    public abstract boolean isClosed();
}
