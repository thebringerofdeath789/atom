package io.netty.handler.codec.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class HttpServerUpgradeHandler extends HttpObjectAggregator {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean handlingUpgrade;
    private final SourceCodec sourceCodec;
    private final UpgradeCodecFactory upgradeCodecFactory;

    public interface SourceCodec {
        void upgradeFrom(ChannelHandlerContext channelHandlerContext);
    }

    public interface UpgradeCodec {
        boolean prepareUpgradeResponse(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders);

        Collection<CharSequence> requiredUpgradeHeaders();

        void upgradeTo(ChannelHandlerContext channelHandlerContext, FullHttpRequest fullHttpRequest);
    }

    public interface UpgradeCodecFactory {
        UpgradeCodec newUpgradeCodec(CharSequence charSequence);
    }

    @Override // io.netty.handler.codec.MessageAggregator, io.netty.handler.codec.MessageToMessageDecoder
    protected /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Object obj, List list) throws Exception {
        decode(channelHandlerContext, (HttpObject) obj, (List<Object>) list);
    }

    public static final class UpgradeEvent implements ReferenceCounted {
        private final CharSequence protocol;
        private final FullHttpRequest upgradeRequest;

        UpgradeEvent(CharSequence charSequence, FullHttpRequest fullHttpRequest) {
            this.protocol = charSequence;
            this.upgradeRequest = fullHttpRequest;
        }

        public CharSequence protocol() {
            return this.protocol;
        }

        public FullHttpRequest upgradeRequest() {
            return this.upgradeRequest;
        }

        @Override // io.netty.util.ReferenceCounted
        public int refCnt() {
            return this.upgradeRequest.refCnt();
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain() {
            this.upgradeRequest.retain();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent retain(int i) {
            this.upgradeRequest.retain(i);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch() {
            this.upgradeRequest.touch();
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public UpgradeEvent touch(Object obj) {
            this.upgradeRequest.touch(obj);
            return this;
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release() {
            return this.upgradeRequest.release();
        }

        @Override // io.netty.util.ReferenceCounted
        public boolean release(int i) {
            return this.upgradeRequest.release(i);
        }

        public String toString() {
            return "UpgradeEvent [protocol=" + ((Object) this.protocol) + ", upgradeRequest=" + this.upgradeRequest + PropertyUtils.INDEXED_DELIM2;
        }
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory) {
        this(sourceCodec, upgradeCodecFactory, 0);
    }

    public HttpServerUpgradeHandler(SourceCodec sourceCodec, UpgradeCodecFactory upgradeCodecFactory, int i) {
        super(i);
        this.sourceCodec = (SourceCodec) ObjectUtil.checkNotNull(sourceCodec, "sourceCodec");
        this.upgradeCodecFactory = (UpgradeCodecFactory) ObjectUtil.checkNotNull(upgradeCodecFactory, "upgradeCodecFactory");
    }

    protected void decode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        FullHttpRequest fullHttpRequest;
        boolean isUpgradeRequest = this.handlingUpgrade | isUpgradeRequest(httpObject);
        this.handlingUpgrade = isUpgradeRequest;
        if (!isUpgradeRequest) {
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
            return;
        }
        if (httpObject instanceof FullHttpRequest) {
            fullHttpRequest = (FullHttpRequest) httpObject;
            ReferenceCountUtil.retain(httpObject);
            list.add(httpObject);
        } else {
            super.decode(channelHandlerContext, (ChannelHandlerContext) httpObject, list);
            if (list.isEmpty()) {
                return;
            }
            this.handlingUpgrade = false;
            fullHttpRequest = (FullHttpRequest) list.get(0);
        }
        if (upgrade(channelHandlerContext, fullHttpRequest)) {
            list.clear();
        }
    }

    private static boolean isUpgradeRequest(HttpObject httpObject) {
        return (httpObject instanceof HttpRequest) && ((HttpRequest) httpObject).headers().get(HttpHeaderNames.UPGRADE) != null;
    }

    private boolean upgrade(final ChannelHandlerContext channelHandlerContext, final FullHttpRequest fullHttpRequest) {
        CharSequence charSequence;
        final UpgradeCodec upgradeCodec;
        String str;
        List<CharSequence> splitHeader = splitHeader(fullHttpRequest.headers().get(HttpHeaderNames.UPGRADE));
        int size = splitHeader.size();
        int i = 0;
        while (true) {
            charSequence = null;
            if (i >= size) {
                upgradeCodec = null;
                break;
            }
            charSequence = splitHeader.get(i);
            UpgradeCodec newUpgradeCodec = this.upgradeCodecFactory.newUpgradeCodec(charSequence);
            if (newUpgradeCodec != null) {
                upgradeCodec = newUpgradeCodec;
                break;
            }
            i++;
        }
        if (upgradeCodec == null || (str = fullHttpRequest.headers().get(HttpHeaderNames.CONNECTION)) == null) {
            return false;
        }
        Collection<CharSequence> requiredUpgradeHeaders = upgradeCodec.requiredUpgradeHeaders();
        List<CharSequence> splitHeader2 = splitHeader(str);
        if (!AsciiString.containsContentEqualsIgnoreCase(splitHeader2, HttpHeaderNames.UPGRADE) || !AsciiString.containsAllContentEqualsIgnoreCase(splitHeader2, requiredUpgradeHeaders)) {
            return false;
        }
        Iterator<CharSequence> it = requiredUpgradeHeaders.iterator();
        while (it.hasNext()) {
            if (!fullHttpRequest.headers().contains(it.next())) {
                return false;
            }
        }
        FullHttpResponse createUpgradeResponse = createUpgradeResponse(charSequence);
        if (!upgradeCodec.prepareUpgradeResponse(channelHandlerContext, fullHttpRequest, createUpgradeResponse.headers())) {
            return false;
        }
        final UpgradeEvent upgradeEvent = new UpgradeEvent(charSequence, fullHttpRequest);
        channelHandlerContext.writeAndFlush(createUpgradeResponse).addListener(new ChannelFutureListener() { // from class: io.netty.handler.codec.http.HttpServerUpgradeHandler.1
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                try {
                    if (channelFuture.isSuccess()) {
                        HttpServerUpgradeHandler.this.sourceCodec.upgradeFrom(channelHandlerContext);
                        upgradeCodec.upgradeTo(channelHandlerContext, fullHttpRequest);
                        channelHandlerContext.fireUserEventTriggered((Object) upgradeEvent.retain());
                        channelHandlerContext.pipeline().remove(HttpServerUpgradeHandler.this);
                    } else {
                        channelFuture.channel().close();
                    }
                } finally {
                    upgradeEvent.release();
                }
            }
        });
        return true;
    }

    private static FullHttpResponse createUpgradeResponse(CharSequence charSequence) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, Unpooled.EMPTY_BUFFER, false);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
        defaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, charSequence);
        return defaultFullHttpResponse;
    }

    private static List<CharSequence> splitHeader(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(charSequence.length());
        ArrayList arrayList = new ArrayList(4);
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (!Character.isWhitespace(charAt)) {
                if (charAt == ',') {
                    arrayList.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(charAt);
                }
            }
        }
        if (sb.length() > 0) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }
}
