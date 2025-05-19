package io.netty.handler.codec.rtsp;

import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.AsciiString;

/* loaded from: classes3.dex */
public final class RtspHeaderValues {
    public static final AsciiString APPEND = AsciiString.cached(RtspHeaders.Values.APPEND);
    public static final AsciiString AVP = AsciiString.cached(RtspHeaders.Values.AVP);
    public static final AsciiString BYTES = HttpHeaderValues.BYTES;
    public static final AsciiString CHARSET = HttpHeaderValues.CHARSET;
    public static final AsciiString CLIENT_PORT = AsciiString.cached(RtspHeaders.Values.CLIENT_PORT);
    public static final AsciiString CLOCK = AsciiString.cached(RtspHeaders.Values.CLOCK);
    public static final AsciiString CLOSE = HttpHeaderValues.CLOSE;
    public static final AsciiString COMPRESS = HttpHeaderValues.COMPRESS;
    public static final AsciiString CONTINUE = HttpHeaderValues.CONTINUE;
    public static final AsciiString DEFLATE = HttpHeaderValues.DEFLATE;
    public static final AsciiString DESTINATION = AsciiString.cached(RtspHeaders.Values.DESTINATION);
    public static final AsciiString GZIP = HttpHeaderValues.GZIP;
    public static final AsciiString IDENTITY = HttpHeaderValues.IDENTITY;
    public static final AsciiString INTERLEAVED = AsciiString.cached(RtspHeaders.Values.INTERLEAVED);
    public static final AsciiString KEEP_ALIVE = HttpHeaderValues.KEEP_ALIVE;
    public static final AsciiString LAYERS = AsciiString.cached(RtspHeaders.Values.LAYERS);
    public static final AsciiString MAX_AGE = HttpHeaderValues.MAX_AGE;
    public static final AsciiString MAX_STALE = HttpHeaderValues.MAX_STALE;
    public static final AsciiString MIN_FRESH = HttpHeaderValues.MIN_FRESH;
    public static final AsciiString MODE = AsciiString.cached(RtspHeaders.Values.MODE);
    public static final AsciiString MULTICAST = AsciiString.cached(RtspHeaders.Values.MULTICAST);
    public static final AsciiString MUST_REVALIDATE = HttpHeaderValues.MUST_REVALIDATE;
    public static final AsciiString NONE = HttpHeaderValues.NONE;
    public static final AsciiString NO_CACHE = HttpHeaderValues.NO_CACHE;
    public static final AsciiString NO_TRANSFORM = HttpHeaderValues.NO_TRANSFORM;
    public static final AsciiString ONLY_IF_CACHED = HttpHeaderValues.ONLY_IF_CACHED;
    public static final AsciiString PORT = AsciiString.cached("port");
    public static final AsciiString PRIVATE = HttpHeaderValues.PRIVATE;
    public static final AsciiString PROXY_REVALIDATE = HttpHeaderValues.PROXY_REVALIDATE;
    public static final AsciiString PUBLIC = HttpHeaderValues.PUBLIC;
    public static final AsciiString RTP = AsciiString.cached(RtspHeaders.Values.RTP);
    public static final AsciiString RTPTIME = AsciiString.cached(RtspHeaders.Values.RTPTIME);
    public static final AsciiString SEQ = AsciiString.cached(RtspHeaders.Values.SEQ);
    public static final AsciiString SERVER_PORT = AsciiString.cached(RtspHeaders.Values.SERVER_PORT);
    public static final AsciiString SSRC = AsciiString.cached(RtspHeaders.Values.SSRC);
    public static final AsciiString TCP = AsciiString.cached(RtspHeaders.Values.TCP);
    public static final AsciiString TIME = AsciiString.cached(RtspHeaders.Values.TIME);
    public static final AsciiString TIMEOUT = AsciiString.cached(RtspHeaders.Values.TIMEOUT);
    public static final AsciiString TTL = AsciiString.cached(RtspHeaders.Values.TTL);
    public static final AsciiString UDP = AsciiString.cached(RtspHeaders.Values.UDP);
    public static final AsciiString UNICAST = AsciiString.cached(RtspHeaders.Values.UNICAST);
    public static final AsciiString URL = AsciiString.cached("url");

    private RtspHeaderValues() {
    }
}
