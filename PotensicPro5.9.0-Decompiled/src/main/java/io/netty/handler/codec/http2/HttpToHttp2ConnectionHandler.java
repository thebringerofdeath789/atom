package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http2.Http2CodecUtil;
import io.netty.handler.codec.http2.HttpConversionUtil;

/* loaded from: classes3.dex */
public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private final boolean validateHeaders;

    protected HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z;
    }

    private int getStreamId(HttpHeaders httpHeaders) throws Exception {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c1, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00af, code lost:
    
        if (r15 != false) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009f A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #2 {all -> 0x00ac, blocks: (B:30:0x008d, B:32:0x009f), top: B:29:0x008d }] */
    /* JADX WARN: Type inference failed for: r1v14, types: [io.netty.handler.codec.http.HttpHeaders] */
    /* JADX WARN: Type inference failed for: r2v7, types: [io.netty.handler.codec.http2.Http2Headers] */
    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(io.netty.channel.ChannelHandlerContext r13, java.lang.Object r14, io.netty.channel.ChannelPromise r15) {
        /*
            Method dump skipped, instructions count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http2.HttpToHttp2ConnectionHandler.write(io.netty.channel.ChannelHandlerContext, java.lang.Object, io.netty.channel.ChannelPromise):void");
    }

    private static void writeHeaders(ChannelHandlerContext channelHandlerContext, Http2ConnectionEncoder http2ConnectionEncoder, int i, HttpHeaders httpHeaders, Http2Headers http2Headers, boolean z, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        http2ConnectionEncoder.writeHeaders(channelHandlerContext, i, http2Headers, httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), httpHeaders.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16), false, 0, z, simpleChannelPromiseAggregator.newPromise());
    }
}
