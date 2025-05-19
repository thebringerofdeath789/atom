package io.netty.handler.codec.http;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.util.AsciiString;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
public final class HttpHeaderValues {
    public static final AsciiString APPLICATION_JSON = AsciiString.cached(HttpHeaders.Values.APPLICATION_JSON);
    public static final AsciiString APPLICATION_X_WWW_FORM_URLENCODED = AsciiString.cached(HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
    public static final AsciiString APPLICATION_OCTET_STREAM = AsciiString.cached(HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE);
    public static final AsciiString ATTACHMENT = AsciiString.cached("attachment");
    public static final AsciiString BASE64 = AsciiString.cached(HttpHeaders.Values.BASE64);
    public static final AsciiString BINARY = AsciiString.cached(HttpHeaders.Values.BINARY);
    public static final AsciiString BOUNDARY = AsciiString.cached(HttpHeaders.Values.BOUNDARY);
    public static final AsciiString BYTES = AsciiString.cached("bytes");
    public static final AsciiString CHARSET = AsciiString.cached("charset");
    public static final AsciiString CHUNKED = AsciiString.cached(HttpHeaders.Values.CHUNKED);
    public static final AsciiString CLOSE = AsciiString.cached("close");
    public static final AsciiString COMPRESS = AsciiString.cached("compress");
    public static final AsciiString CONTINUE = AsciiString.cached("100-continue");
    public static final AsciiString DEFLATE = AsciiString.cached("deflate");
    public static final AsciiString X_DEFLATE = AsciiString.cached("x-deflate");
    public static final AsciiString FILE = AsciiString.cached(StringLookupFactory.KEY_FILE);
    public static final AsciiString FILENAME = AsciiString.cached("filename");
    public static final AsciiString FORM_DATA = AsciiString.cached("form-data");
    public static final AsciiString GZIP = AsciiString.cached("gzip");
    public static final AsciiString GZIP_DEFLATE = AsciiString.cached(HttpHeaders.Values.GZIP_DEFLATE);
    public static final AsciiString X_GZIP = AsciiString.cached("x-gzip");
    public static final AsciiString IDENTITY = AsciiString.cached("identity");
    public static final AsciiString KEEP_ALIVE = AsciiString.cached("keep-alive");
    public static final AsciiString MAX_AGE = AsciiString.cached("max-age");
    public static final AsciiString MAX_STALE = AsciiString.cached("max-stale");
    public static final AsciiString MIN_FRESH = AsciiString.cached("min-fresh");
    public static final AsciiString MULTIPART_FORM_DATA = AsciiString.cached(HttpHeaders.Values.MULTIPART_FORM_DATA);
    public static final AsciiString MULTIPART_MIXED = AsciiString.cached("multipart/mixed");
    public static final AsciiString MUST_REVALIDATE = AsciiString.cached("must-revalidate");
    public static final AsciiString NAME = AsciiString.cached("name");
    public static final AsciiString NO_CACHE = AsciiString.cached("no-cache");
    public static final AsciiString NO_STORE = AsciiString.cached(HttpHeaders.Values.NO_STORE);
    public static final AsciiString NO_TRANSFORM = AsciiString.cached("no-transform");
    public static final AsciiString NONE = AsciiString.cached("none");
    public static final AsciiString ZERO = AsciiString.cached(SessionDescription.SUPPORTED_SDP_VERSION);
    public static final AsciiString ONLY_IF_CACHED = AsciiString.cached("only-if-cached");
    public static final AsciiString PRIVATE = AsciiString.cached("private");
    public static final AsciiString PROXY_REVALIDATE = AsciiString.cached("proxy-revalidate");
    public static final AsciiString PUBLIC = AsciiString.cached("public");
    public static final AsciiString QUOTED_PRINTABLE = AsciiString.cached(HttpHeaders.Values.QUOTED_PRINTABLE);
    public static final AsciiString S_MAXAGE = AsciiString.cached(HttpHeaders.Values.S_MAXAGE);
    public static final AsciiString TEXT_PLAIN = AsciiString.cached("text/plain");
    public static final AsciiString TRAILERS = AsciiString.cached(HttpHeaders.Values.TRAILERS);
    public static final AsciiString UPGRADE = AsciiString.cached("upgrade");
    public static final AsciiString WEBSOCKET = AsciiString.cached("websocket");

    private HttpHeaderValues() {
    }
}
