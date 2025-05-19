package io.netty.handler.codec.serialization;

/* loaded from: classes3.dex */
public interface ClassResolver {
    Class<?> resolve(String str) throws ClassNotFoundException;
}
