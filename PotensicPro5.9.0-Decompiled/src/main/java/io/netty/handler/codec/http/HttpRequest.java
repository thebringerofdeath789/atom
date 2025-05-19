package io.netty.handler.codec.http;

/* loaded from: classes3.dex */
public interface HttpRequest extends HttpMessage {
    @Deprecated
    HttpMethod getMethod();

    @Deprecated
    String getUri();

    HttpMethod method();

    HttpRequest setMethod(HttpMethod httpMethod);

    HttpRequest setProtocolVersion(HttpVersion httpVersion);

    HttpRequest setUri(String str);

    String uri();
}
