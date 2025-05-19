package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestEncoder;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.util.NetUtil;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ThrowableUtil;
import java.net.URI;
import java.nio.channels.ClosedChannelException;
import java.util.Locale;
import java.util.Objects;
import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes3.dex */
public abstract class WebSocketClientHandshaker {
    private volatile String actualSubprotocol;
    protected final HttpHeaders customHeaders;
    private final String expectedSubprotocol;
    private volatile boolean handshakeComplete;
    private final int maxFramePayloadLength;
    private final URI uri;
    private final WebSocketVersion version;
    private static final ClosedChannelException CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), WebSocketClientHandshaker.class, "processHandshake(...)");
    private static final String HTTP_SCHEME_PREFIX = HttpScheme.HTTP + "://";
    private static final String HTTPS_SCHEME_PREFIX = HttpScheme.HTTPS + "://";

    protected abstract FullHttpRequest newHandshakeRequest();

    protected abstract WebSocketFrameEncoder newWebSocketEncoder();

    protected abstract WebSocketFrameDecoder newWebsocketDecoder();

    protected abstract void verify(FullHttpResponse fullHttpResponse);

    protected WebSocketClientHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, HttpHeaders httpHeaders, int i) {
        this.uri = uri;
        this.version = webSocketVersion;
        this.expectedSubprotocol = str;
        this.customHeaders = httpHeaders;
        this.maxFramePayloadLength = i;
    }

    public URI uri() {
        return this.uri;
    }

    public WebSocketVersion version() {
        return this.version;
    }

    public int maxFramePayloadLength() {
        return this.maxFramePayloadLength;
    }

    public boolean isHandshakeComplete() {
        return this.handshakeComplete;
    }

    private void setHandshakeComplete() {
        this.handshakeComplete = true;
    }

    public String expectedSubprotocol() {
        return this.expectedSubprotocol;
    }

    public String actualSubprotocol() {
        return this.actualSubprotocol;
    }

    private void setActualSubprotocol(String str) {
        this.actualSubprotocol = str;
    }

    public ChannelFuture handshake(Channel channel) {
        Objects.requireNonNull(channel, "channel");
        return handshake(channel, channel.newPromise());
    }

    public final ChannelFuture handshake(Channel channel, final ChannelPromise channelPromise) {
        FullHttpRequest newHandshakeRequest = newHandshakeRequest();
        if (((HttpResponseDecoder) channel.pipeline().get(HttpResponseDecoder.class)) == null && ((HttpClientCodec) channel.pipeline().get(HttpClientCodec.class)) == null) {
            channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpResponseDecoder or HttpClientCodec"));
            return channelPromise;
        }
        channel.writeAndFlush(newHandshakeRequest).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) {
                if (channelFuture.isSuccess()) {
                    ChannelPipeline pipeline = channelFuture.channel().pipeline();
                    ChannelHandlerContext context = pipeline.context(HttpRequestEncoder.class);
                    if (context == null) {
                        context = pipeline.context(HttpClientCodec.class);
                    }
                    if (context == null) {
                        channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpRequestEncoder or HttpClientCodec"));
                        return;
                    } else {
                        pipeline.addAfter(context.name(), "ws-encoder", WebSocketClientHandshaker.this.newWebSocketEncoder());
                        channelPromise.setSuccess();
                        return;
                    }
                }
                channelPromise.setFailure(channelFuture.cause());
            }
        });
        return channelPromise;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void finishHandshake(io.netty.channel.Channel r7, io.netty.handler.codec.http.FullHttpResponse r8) {
        /*
            r6 = this;
            r6.verify(r8)
            io.netty.handler.codec.http.HttpHeaders r8 = r8.headers()
            io.netty.util.AsciiString r0 = io.netty.handler.codec.http.HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL
            java.lang.String r8 = r8.get(r0)
            if (r8 == 0) goto L14
            java.lang.String r8 = r8.trim()
            goto L15
        L14:
            r8 = 0
        L15:
            java.lang.String r0 = r6.expectedSubprotocol
            if (r0 == 0) goto L1a
            goto L1c
        L1a:
            java.lang.String r0 = ""
        L1c:
            boolean r1 = r0.isEmpty()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2d
            if (r8 != 0) goto L2d
            java.lang.String r0 = r6.expectedSubprotocol
            r6.setActualSubprotocol(r0)
        L2b:
            r0 = r3
            goto L59
        L2d:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L58
            if (r8 == 0) goto L58
            boolean r1 = r8.isEmpty()
            if (r1 != 0) goto L58
            java.lang.String r1 = ","
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r4 = r2
        L43:
            if (r4 >= r1) goto L58
            r5 = r0[r4]
            java.lang.String r5 = r5.trim()
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L55
            r6.setActualSubprotocol(r8)
            goto L2b
        L55:
            int r4 = r4 + 1
            goto L43
        L58:
            r0 = r2
        L59:
            if (r0 == 0) goto Ldc
            r6.setHandshakeComplete()
            io.netty.channel.ChannelPipeline r8 = r7.pipeline()
            java.lang.Class<io.netty.handler.codec.http.HttpContentDecompressor> r0 = io.netty.handler.codec.http.HttpContentDecompressor.class
            io.netty.channel.ChannelHandler r0 = r8.get(r0)
            io.netty.handler.codec.http.HttpContentDecompressor r0 = (io.netty.handler.codec.http.HttpContentDecompressor) r0
            if (r0 == 0) goto L6f
            r8.remove(r0)
        L6f:
            java.lang.Class<io.netty.handler.codec.http.HttpObjectAggregator> r0 = io.netty.handler.codec.http.HttpObjectAggregator.class
            io.netty.channel.ChannelHandler r0 = r8.get(r0)
            io.netty.handler.codec.http.HttpObjectAggregator r0 = (io.netty.handler.codec.http.HttpObjectAggregator) r0
            if (r0 == 0) goto L7c
            r8.remove(r0)
        L7c:
            java.lang.Class<io.netty.handler.codec.http.HttpResponseDecoder> r0 = io.netty.handler.codec.http.HttpResponseDecoder.class
            io.netty.channel.ChannelHandlerContext r0 = r8.context(r0)
            java.lang.String r1 = "ws-decoder"
            if (r0 != 0) goto Lb7
            java.lang.Class<io.netty.handler.codec.http.HttpClientCodec> r0 = io.netty.handler.codec.http.HttpClientCodec.class
            io.netty.channel.ChannelHandlerContext r0 = r8.context(r0)
            if (r0 == 0) goto Laf
            io.netty.channel.ChannelHandler r2 = r0.handler()
            io.netty.handler.codec.http.HttpClientCodec r2 = (io.netty.handler.codec.http.HttpClientCodec) r2
            r2.removeOutboundHandler()
            java.lang.String r0 = r0.name()
            io.netty.handler.codec.http.websocketx.WebSocketFrameDecoder r3 = r6.newWebsocketDecoder()
            r8.addAfter(r0, r1, r3)
            io.netty.channel.EventLoop r7 = r7.eventLoop()
            io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker$2 r0 = new io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker$2
            r0.<init>()
            r7.execute(r0)
            goto Ldb
        Laf:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "ChannelPipeline does not contain a HttpRequestEncoder or HttpClientCodec"
            r7.<init>(r8)
            throw r7
        Lb7:
            java.lang.Class<io.netty.handler.codec.http.HttpRequestEncoder> r2 = io.netty.handler.codec.http.HttpRequestEncoder.class
            io.netty.channel.ChannelHandler r2 = r8.get(r2)
            if (r2 == 0) goto Lc4
            java.lang.Class<io.netty.handler.codec.http.HttpRequestEncoder> r2 = io.netty.handler.codec.http.HttpRequestEncoder.class
            r8.remove(r2)
        Lc4:
            java.lang.String r2 = r0.name()
            io.netty.handler.codec.http.websocketx.WebSocketFrameDecoder r3 = r6.newWebsocketDecoder()
            r8.addAfter(r2, r1, r3)
            io.netty.channel.EventLoop r7 = r7.eventLoop()
            io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker$3 r1 = new io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker$3
            r1.<init>()
            r7.execute(r1)
        Ldb:
            return
        Ldc:
            io.netty.handler.codec.http.websocketx.WebSocketHandshakeException r7 = new io.netty.handler.codec.http.websocketx.WebSocketHandshakeException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r8
            java.lang.String r8 = r6.expectedSubprotocol
            r0[r3] = r8
            java.lang.String r8 = "Invalid subprotocol. Actual: %s. Expected one of: %s"
            java.lang.String r8 = java.lang.String.format(r8, r0)
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.finishHandshake(io.netty.channel.Channel, io.netty.handler.codec.http.FullHttpResponse):void");
    }

    public final ChannelFuture processHandshake(Channel channel, HttpResponse httpResponse) {
        return processHandshake(channel, httpResponse, channel.newPromise());
    }

    public final ChannelFuture processHandshake(final Channel channel, HttpResponse httpResponse, final ChannelPromise channelPromise) {
        if (httpResponse instanceof FullHttpResponse) {
            try {
                finishHandshake(channel, (FullHttpResponse) httpResponse);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            ChannelPipeline pipeline = channel.pipeline();
            ChannelHandlerContext context = pipeline.context(HttpResponseDecoder.class);
            if (context == null && (context = pipeline.context(HttpClientCodec.class)) == null) {
                return channelPromise.setFailure((Throwable) new IllegalStateException("ChannelPipeline does not contain a HttpResponseDecoder or HttpClientCodec"));
            }
            pipeline.addAfter(context.name(), "httpAggregator", new HttpObjectAggregator(8192));
            pipeline.addAfter("httpAggregator", "handshaker", new SimpleChannelInboundHandler<FullHttpResponse>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker.4
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // io.netty.channel.SimpleChannelInboundHandler
                public void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpResponse fullHttpResponse) throws Exception {
                    channelHandlerContext.pipeline().remove(this);
                    try {
                        WebSocketClientHandshaker.this.finishHandshake(channel, fullHttpResponse);
                        channelPromise.setSuccess();
                    } catch (Throwable th2) {
                        channelPromise.setFailure(th2);
                    }
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
                public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
                    channelHandlerContext.pipeline().remove(this);
                    channelPromise.setFailure(th2);
                }

                @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
                public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
                    channelPromise.tryFailure(WebSocketClientHandshaker.CLOSED_CHANNEL_EXCEPTION);
                    channelHandlerContext.fireChannelInactive();
                }
            });
            try {
                context.fireChannelRead(ReferenceCountUtil.retain(httpResponse));
            } catch (Throwable th2) {
                channelPromise.setFailure(th2);
            }
        }
        return channelPromise;
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame) {
        Objects.requireNonNull(channel, "channel");
        return close(channel, closeWebSocketFrame, channel.newPromise());
    }

    public ChannelFuture close(Channel channel, CloseWebSocketFrame closeWebSocketFrame, ChannelPromise channelPromise) {
        Objects.requireNonNull(channel, "channel");
        return channel.writeAndFlush(closeWebSocketFrame, channelPromise);
    }

    static String rawPath(URI uri) {
        String rawPath = uri.getRawPath();
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null && !rawQuery.isEmpty()) {
            rawPath = rawPath + '?' + rawQuery;
        }
        return (rawPath == null || rawPath.isEmpty()) ? InternalZipConstants.ZIP_FILE_SEPARATOR : rawPath;
    }

    static CharSequence websocketHostValue(URI uri) {
        int port = uri.getPort();
        if (port == -1) {
            return uri.getHost();
        }
        String host = uri.getHost();
        if (port == HttpScheme.HTTP.port()) {
            return (HttpScheme.HTTP.name().contentEquals(uri.getScheme()) || WebSocketScheme.WS.name().contentEquals(uri.getScheme())) ? host : NetUtil.toSocketAddressString(host, port);
        }
        if (port == HttpScheme.HTTPS.port()) {
            return (HttpScheme.HTTPS.name().contentEquals(uri.getScheme()) || WebSocketScheme.WSS.name().contentEquals(uri.getScheme())) ? host : NetUtil.toSocketAddressString(host, port);
        }
        return NetUtil.toSocketAddressString(host, port);
    }

    static CharSequence websocketOriginValue(URI uri) {
        String str;
        int port;
        String scheme = uri.getScheme();
        int port2 = uri.getPort();
        if (WebSocketScheme.WSS.name().contentEquals(scheme) || HttpScheme.HTTPS.name().contentEquals(scheme) || (scheme == null && port2 == WebSocketScheme.WSS.port())) {
            str = HTTPS_SCHEME_PREFIX;
            port = WebSocketScheme.WSS.port();
        } else {
            str = HTTP_SCHEME_PREFIX;
            port = WebSocketScheme.WS.port();
        }
        String lowerCase = uri.getHost().toLowerCase(Locale.US);
        if (port2 != port && port2 != -1) {
            return str + NetUtil.toSocketAddressString(lowerCase, port2);
        }
        return str + lowerCase;
    }
}
