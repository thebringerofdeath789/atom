package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.FileRegion;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class HttpObjectEncoder<H extends HttpMessage> extends MessageToMessageEncoder<Object> {
    private static final ByteBuf CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(2).writeByte(13).writeByte(10));
    static final int CRLF_SHORT = 3338;
    private static final float HEADERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_WEIGHT_NEW = 0.2f;
    private static final int ST_CONTENT_ALWAYS_EMPTY = 3;
    private static final int ST_CONTENT_CHUNK = 2;
    private static final int ST_CONTENT_NON_CHUNK = 1;
    private static final int ST_INIT = 0;
    private static final float TRAILERS_WEIGHT_HISTORICAL = 0.8f;
    private static final float TRAILERS_WEIGHT_NEW = 0.2f;
    private static final byte[] ZERO_CRLF_CRLF;
    private static final ByteBuf ZERO_CRLF_CRLF_BUF;
    private static final int ZERO_CRLF_MEDIUM = 3149066;
    private int state = 0;
    private float headersEncodedSizeAccumulator = 256.0f;
    private float trailersEncodedSizeAccumulator = 256.0f;

    protected abstract void encodeInitialLine(ByteBuf byteBuf, H h) throws Exception;

    protected boolean isContentAlwaysEmpty(H h) {
        return false;
    }

    protected void sanitizeHeadersBeforeEncode(H h, boolean z) {
    }

    static {
        byte[] bArr = {48, 13, 10, 13, 10};
        ZERO_CRLF_CRLF = bArr;
        ZERO_CRLF_CRLF_BUF = Unpooled.unreleasableBuffer(Unpooled.directBuffer(bArr.length).writeBytes(bArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0100  */
    @Override // io.netty.handler.codec.MessageToMessageEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void encode(io.netty.channel.ChannelHandlerContext r11, java.lang.Object r12, java.util.List<java.lang.Object> r13) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectEncoder.encode(io.netty.channel.ChannelHandlerContext, java.lang.Object, java.util.List):void");
    }

    protected void encodeHeaders(HttpHeaders httpHeaders, ByteBuf byteBuf) {
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            HttpHeadersEncoder.encoderHeader(next.getKey(), next.getValue(), byteBuf);
        }
    }

    private void encodeChunkedContent(ChannelHandlerContext channelHandlerContext, Object obj, long j, List<Object> list) {
        if (j > 0) {
            String hexString = Long.toHexString(j);
            ByteBuf buffer = channelHandlerContext.alloc().buffer(hexString.length() + 2);
            buffer.writeCharSequence(hexString, CharsetUtil.US_ASCII);
            ByteBufUtil.writeShortBE(buffer, CRLF_SHORT);
            list.add(buffer);
            list.add(encodeAndRetain(obj));
            list.add(CRLF_BUF.duplicate());
        }
        if (!(obj instanceof LastHttpContent)) {
            if (j == 0) {
                list.add(encodeAndRetain(obj));
                return;
            }
            return;
        }
        HttpHeaders trailingHeaders = ((LastHttpContent) obj).trailingHeaders();
        if (trailingHeaders.isEmpty()) {
            list.add(ZERO_CRLF_CRLF_BUF.duplicate());
            return;
        }
        ByteBuf buffer2 = channelHandlerContext.alloc().buffer((int) this.trailersEncodedSizeAccumulator);
        ByteBufUtil.writeMediumBE(buffer2, ZERO_CRLF_MEDIUM);
        encodeHeaders(trailingHeaders, buffer2);
        ByteBufUtil.writeShortBE(buffer2, CRLF_SHORT);
        this.trailersEncodedSizeAccumulator = (padSizeForAccumulation(buffer2.readableBytes()) * 0.2f) + (this.trailersEncodedSizeAccumulator * 0.8f);
        list.add(buffer2);
    }

    @Override // io.netty.handler.codec.MessageToMessageEncoder
    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return (obj instanceof HttpObject) || (obj instanceof ByteBuf) || (obj instanceof FileRegion);
    }

    private static Object encodeAndRetain(Object obj) {
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).retain();
        }
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().retain();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).retain();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private static long contentLength(Object obj) {
        if (obj instanceof HttpContent) {
            return ((HttpContent) obj).content().readableBytes();
        }
        if (obj instanceof ByteBuf) {
            return ((ByteBuf) obj).readableBytes();
        }
        if (obj instanceof FileRegion) {
            return ((FileRegion) obj).count();
        }
        throw new IllegalStateException("unexpected message type: " + StringUtil.simpleClassName(obj));
    }

    private static int padSizeForAccumulation(int i) {
        return (i << 2) / 3;
    }

    @Deprecated
    protected static void encodeAscii(String str, ByteBuf byteBuf) {
        byteBuf.writeCharSequence(str, CharsetUtil.US_ASCII);
    }
}
