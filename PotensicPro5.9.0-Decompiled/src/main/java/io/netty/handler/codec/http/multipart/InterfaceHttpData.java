package io.netty.handler.codec.http.multipart;

import io.netty.util.ReferenceCounted;

/* loaded from: classes3.dex */
public interface InterfaceHttpData extends Comparable<InterfaceHttpData>, ReferenceCounted {

    public enum HttpDataType {
        Attribute,
        FileUpload,
        InternalAttribute
    }

    HttpDataType getHttpDataType();

    String getName();

    InterfaceHttpData retain();

    InterfaceHttpData retain(int i);

    InterfaceHttpData touch();

    InterfaceHttpData touch(Object obj);
}
