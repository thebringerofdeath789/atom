package io.netty.handler.codec.memcache;

import io.netty.util.ReferenceCounted;

/* loaded from: classes3.dex */
public interface MemcacheMessage extends MemcacheObject, ReferenceCounted {
    MemcacheMessage retain();

    MemcacheMessage retain(int i);

    MemcacheMessage touch();

    MemcacheMessage touch(Object obj);
}
