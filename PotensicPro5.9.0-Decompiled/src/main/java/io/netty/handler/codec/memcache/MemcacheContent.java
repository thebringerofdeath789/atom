package io.netty.handler.codec.memcache;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;

/* loaded from: classes3.dex */
public interface MemcacheContent extends MemcacheObject, ByteBufHolder {
    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent copy();

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent duplicate();

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent replace(ByteBuf byteBuf);

    MemcacheContent retain();

    MemcacheContent retain(int i);

    @Override // io.netty.buffer.ByteBufHolder
    MemcacheContent retainedDuplicate();

    MemcacheContent touch();

    MemcacheContent touch(Object obj);
}
