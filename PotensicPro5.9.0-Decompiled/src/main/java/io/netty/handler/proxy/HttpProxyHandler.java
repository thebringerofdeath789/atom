package io.netty.handler.proxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.NetUtil;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Objects;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes.dex */
public final class HttpProxyHandler extends ProxyHandler {
    private static final String AUTH_BASIC = "basic";
    private static final String PROTOCOL = "http";
    private final CharSequence authorization;
    private final HttpClientCodec codec;
    private HttpHeaders headers;
    private final String password;
    private HttpResponseStatus status;
    private final String username;

    @Override // io.netty.handler.proxy.ProxyHandler
    public String protocol() {
        return PROTOCOL;
    }

    public HttpProxyHandler(SocketAddress socketAddress) {
        this(socketAddress, null);
    }

    public HttpProxyHandler(SocketAddress socketAddress, HttpHeaders httpHeaders) {
        super(socketAddress);
        this.codec = new HttpClientCodec();
        this.username = null;
        this.password = null;
        this.authorization = null;
        this.headers = httpHeaders;
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2) {
        this(socketAddress, str, str2, null);
    }

    public HttpProxyHandler(SocketAddress socketAddress, String str, String str2, HttpHeaders httpHeaders) {
        super(socketAddress);
        this.codec = new HttpClientCodec();
        Objects.requireNonNull(str, "username");
        Objects.requireNonNull(str2, "password");
        this.username = str;
        this.password = str2;
        ByteBuf copiedBuffer = Unpooled.copiedBuffer(str + NameUtil.COLON + str2, CharsetUtil.UTF_8);
        ByteBuf encode = Base64.encode(copiedBuffer, false);
        this.authorization = new AsciiString("Basic " + encode.toString(CharsetUtil.US_ASCII));
        copiedBuffer.release();
        encode.release();
        this.headers = httpHeaders;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    public String authScheme() {
        return this.authorization != null ? AUTH_BASIC : "none";
    }

    public String username() {
        return this.username;
    }

    public String password() {
        return this.password;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    protected void addCodec(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelHandlerContext.pipeline().addBefore(channelHandlerContext.name(), null, this.codec);
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    protected void removeEncoder(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.codec.removeOutboundHandler();
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    protected void removeDecoder(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.codec.removeInboundHandler();
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    protected Object newInitialMessage(ChannelHandlerContext channelHandlerContext) throws Exception {
        String socketAddressString = NetUtil.toSocketAddressString((InetSocketAddress) destinationAddress());
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.CONNECT, socketAddressString, Unpooled.EMPTY_BUFFER, false);
        defaultFullHttpRequest.headers().set(HttpHeaderNames.HOST, socketAddressString);
        if (this.authorization != null) {
            defaultFullHttpRequest.headers().set(HttpHeaderNames.PROXY_AUTHORIZATION, this.authorization);
        }
        if (this.headers != null) {
            defaultFullHttpRequest.headers().add(this.headers);
        }
        return defaultFullHttpRequest;
    }

    @Override // io.netty.handler.proxy.ProxyHandler
    protected boolean handleResponse(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof HttpResponse) {
            if (this.status != null) {
                throw new ProxyConnectException(exceptionMessage("too many responses"));
            }
            this.status = ((HttpResponse) obj).status();
        }
        boolean z = obj instanceof LastHttpContent;
        if (z) {
            HttpResponseStatus httpResponseStatus = this.status;
            if (httpResponseStatus == null) {
                throw new ProxyConnectException(exceptionMessage("missing response"));
            }
            if (httpResponseStatus.code() != 200) {
                throw new ProxyConnectException(exceptionMessage("status: " + this.status));
            }
        }
        return z;
    }
}
