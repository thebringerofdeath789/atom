package io.netty.handler.codec.http;

import androidx.core.app.FrameMetricsAggregator;
import com.baidu.location.BDLocation;
import com.logan.user.model.UserConstants;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.Objects;
import okhttp3.internal.http.StatusLine;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes3.dex */
public class HttpResponseStatus implements Comparable<HttpResponseStatus> {
    private final byte[] bytes;
    private final int code;
    private final AsciiString codeAsText;
    private HttpStatusClass codeClass;
    private final String reasonPhrase;
    public static final HttpResponseStatus CONTINUE = newStatus(100, "Continue");
    public static final HttpResponseStatus SWITCHING_PROTOCOLS = newStatus(101, "Switching Protocols");
    public static final HttpResponseStatus PROCESSING = newStatus(102, "Processing");
    public static final HttpResponseStatus OK = newStatus(200, "OK");
    public static final HttpResponseStatus CREATED = newStatus(201, "Created");
    public static final HttpResponseStatus ACCEPTED = newStatus(202, "Accepted");
    public static final HttpResponseStatus NON_AUTHORITATIVE_INFORMATION = newStatus(203, "Non-Authoritative Information");
    public static final HttpResponseStatus NO_CONTENT = newStatus(204, "No Content");
    public static final HttpResponseStatus RESET_CONTENT = newStatus(NNTPReply.CLOSING_CONNECTION, "Reset Content");
    public static final HttpResponseStatus PARTIAL_CONTENT = newStatus(206, "Partial Content");
    public static final HttpResponseStatus MULTI_STATUS = newStatus(207, "Multi-Status");
    public static final HttpResponseStatus MULTIPLE_CHOICES = newStatus(300, "Multiple Choices");
    public static final HttpResponseStatus MOVED_PERMANENTLY = newStatus(UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER, "Moved Permanently");
    public static final HttpResponseStatus FOUND = newStatus(UserConstants.REQUEST_CODE_DOWNLOAD_PDF_FILE, "Found");
    public static final HttpResponseStatus SEE_OTHER = newStatus(UserConstants.REQUEST_CODE_DOWNLOAD_FEEDBACK_VIDEO_FILE, "See Other");
    public static final HttpResponseStatus NOT_MODIFIED = newStatus(304, "Not Modified");
    public static final HttpResponseStatus USE_PROXY = newStatus(305, "Use Proxy");
    public static final HttpResponseStatus TEMPORARY_REDIRECT = newStatus(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect");
    public static final HttpResponseStatus PERMANENT_REDIRECT = newStatus(StatusLine.HTTP_PERM_REDIRECT, "Permanent Redirect");
    public static final HttpResponseStatus BAD_REQUEST = newStatus(NNTPReply.SERVICE_DISCONTINUED, "Bad Request");
    public static final HttpResponseStatus UNAUTHORIZED = newStatus(401, "Unauthorized");
    public static final HttpResponseStatus PAYMENT_REQUIRED = newStatus(402, "Payment Required");
    public static final HttpResponseStatus FORBIDDEN = newStatus(403, "Forbidden");
    public static final HttpResponseStatus NOT_FOUND = newStatus(404, "Not Found");
    public static final HttpResponseStatus METHOD_NOT_ALLOWED = newStatus(405, "Method Not Allowed");
    public static final HttpResponseStatus NOT_ACCEPTABLE = newStatus(406, "Not Acceptable");
    public static final HttpResponseStatus PROXY_AUTHENTICATION_REQUIRED = newStatus(407, "Proxy Authentication Required");
    public static final HttpResponseStatus REQUEST_TIMEOUT = newStatus(408, "Request Timeout");
    public static final HttpResponseStatus CONFLICT = newStatus(409, "Conflict");
    public static final HttpResponseStatus GONE = newStatus(410, "Gone");
    public static final HttpResponseStatus LENGTH_REQUIRED = newStatus(NNTPReply.NO_SUCH_NEWSGROUP, "Length Required");
    public static final HttpResponseStatus PRECONDITION_FAILED = newStatus(NNTPReply.NO_NEWSGROUP_SELECTED, "Precondition Failed");
    public static final HttpResponseStatus REQUEST_ENTITY_TOO_LARGE = newStatus(413, "Request Entity Too Large");
    public static final HttpResponseStatus REQUEST_URI_TOO_LONG = newStatus(414, "Request-URI Too Long");
    public static final HttpResponseStatus UNSUPPORTED_MEDIA_TYPE = newStatus(415, "Unsupported Media Type");
    public static final HttpResponseStatus REQUESTED_RANGE_NOT_SATISFIABLE = newStatus(416, "Requested Range Not Satisfiable");
    public static final HttpResponseStatus EXPECTATION_FAILED = newStatus(417, "Expectation Failed");
    public static final HttpResponseStatus MISDIRECTED_REQUEST = newStatus(421, "Misdirected Request");
    public static final HttpResponseStatus UNPROCESSABLE_ENTITY = newStatus(NNTPReply.NO_PREVIOUS_ARTICLE, "Unprocessable Entity");
    public static final HttpResponseStatus LOCKED = newStatus(NNTPReply.NO_SUCH_ARTICLE_NUMBER, "Locked");
    public static final HttpResponseStatus FAILED_DEPENDENCY = newStatus(424, "Failed Dependency");
    public static final HttpResponseStatus UNORDERED_COLLECTION = newStatus(FTPReply.CANNOT_OPEN_DATA_CONNECTION, "Unordered Collection");
    public static final HttpResponseStatus UPGRADE_REQUIRED = newStatus(FTPReply.TRANSFER_ABORTED, "Upgrade Required");
    public static final HttpResponseStatus PRECONDITION_REQUIRED = newStatus(428, "Precondition Required");
    public static final HttpResponseStatus TOO_MANY_REQUESTS = newStatus(429, "Too Many Requests");
    public static final HttpResponseStatus REQUEST_HEADER_FIELDS_TOO_LARGE = newStatus(FTPReply.UNAVAILABLE_RESOURCE, "Request Header Fields Too Large");
    public static final HttpResponseStatus INTERNAL_SERVER_ERROR = newStatus(500, "Internal Server Error");
    public static final HttpResponseStatus NOT_IMPLEMENTED = newStatus(501, "Not Implemented");
    public static final HttpResponseStatus BAD_GATEWAY = newStatus(502, "Bad Gateway");
    public static final HttpResponseStatus SERVICE_UNAVAILABLE = newStatus(503, "Service Unavailable");
    public static final HttpResponseStatus GATEWAY_TIMEOUT = newStatus(504, "Gateway Timeout");
    public static final HttpResponseStatus HTTP_VERSION_NOT_SUPPORTED = newStatus(BDLocation.TypeServerCheckKeyError, "HTTP Version Not Supported");
    public static final HttpResponseStatus VARIANT_ALSO_NEGOTIATES = newStatus(506, "Variant Also Negotiates");
    public static final HttpResponseStatus INSUFFICIENT_STORAGE = newStatus(507, "Insufficient Storage");
    public static final HttpResponseStatus NOT_EXTENDED = newStatus(510, "Not Extended");
    public static final HttpResponseStatus NETWORK_AUTHENTICATION_REQUIRED = newStatus(FrameMetricsAggregator.EVERY_DURATION, "Network Authentication Required");

    private static HttpResponseStatus newStatus(int i, String str) {
        return new HttpResponseStatus(i, str, true);
    }

    public static HttpResponseStatus valueOf(int i) {
        if (i == 307) {
            return TEMPORARY_REDIRECT;
        }
        if (i == 308) {
            return PERMANENT_REDIRECT;
        }
        if (i == 428) {
            return PRECONDITION_REQUIRED;
        }
        if (i == 429) {
            return TOO_MANY_REQUESTS;
        }
        if (i == 431) {
            return REQUEST_HEADER_FIELDS_TOO_LARGE;
        }
        if (i == 510) {
            return NOT_EXTENDED;
        }
        if (i != 511) {
            switch (i) {
                case 100:
                    return CONTINUE;
                case 101:
                    return SWITCHING_PROTOCOLS;
                case 102:
                    return PROCESSING;
                default:
                    switch (i) {
                        case 200:
                            return OK;
                        case 201:
                            return CREATED;
                        case 202:
                            return ACCEPTED;
                        case 203:
                            return NON_AUTHORITATIVE_INFORMATION;
                        case 204:
                            return NO_CONTENT;
                        case NNTPReply.CLOSING_CONNECTION /* 205 */:
                            return RESET_CONTENT;
                        case 206:
                            return PARTIAL_CONTENT;
                        case 207:
                            return MULTI_STATUS;
                        default:
                            switch (i) {
                                case 300:
                                    return MULTIPLE_CHOICES;
                                case UserConstants.REQUEST_CODE_DOWNLOAD_FW_FROM_SERVER /* 301 */:
                                    return MOVED_PERMANENTLY;
                                case UserConstants.REQUEST_CODE_DOWNLOAD_PDF_FILE /* 302 */:
                                    return FOUND;
                                case UserConstants.REQUEST_CODE_DOWNLOAD_FEEDBACK_VIDEO_FILE /* 303 */:
                                    return SEE_OTHER;
                                case 304:
                                    return NOT_MODIFIED;
                                case 305:
                                    return USE_PROXY;
                                default:
                                    switch (i) {
                                        case NNTPReply.SERVICE_DISCONTINUED /* 400 */:
                                            return BAD_REQUEST;
                                        case 401:
                                            return UNAUTHORIZED;
                                        case 402:
                                            return PAYMENT_REQUIRED;
                                        case 403:
                                            return FORBIDDEN;
                                        case 404:
                                            return NOT_FOUND;
                                        case 405:
                                            return METHOD_NOT_ALLOWED;
                                        case 406:
                                            return NOT_ACCEPTABLE;
                                        case 407:
                                            return PROXY_AUTHENTICATION_REQUIRED;
                                        case 408:
                                            return REQUEST_TIMEOUT;
                                        case 409:
                                            return CONFLICT;
                                        case 410:
                                            return GONE;
                                        case NNTPReply.NO_SUCH_NEWSGROUP /* 411 */:
                                            return LENGTH_REQUIRED;
                                        case NNTPReply.NO_NEWSGROUP_SELECTED /* 412 */:
                                            return PRECONDITION_FAILED;
                                        case 413:
                                            return REQUEST_ENTITY_TOO_LARGE;
                                        case 414:
                                            return REQUEST_URI_TOO_LONG;
                                        case 415:
                                            return UNSUPPORTED_MEDIA_TYPE;
                                        case 416:
                                            return REQUESTED_RANGE_NOT_SATISFIABLE;
                                        case 417:
                                            return EXPECTATION_FAILED;
                                        default:
                                            switch (i) {
                                                case 421:
                                                    return MISDIRECTED_REQUEST;
                                                case NNTPReply.NO_PREVIOUS_ARTICLE /* 422 */:
                                                    return UNPROCESSABLE_ENTITY;
                                                case NNTPReply.NO_SUCH_ARTICLE_NUMBER /* 423 */:
                                                    return LOCKED;
                                                case 424:
                                                    return FAILED_DEPENDENCY;
                                                case FTPReply.CANNOT_OPEN_DATA_CONNECTION /* 425 */:
                                                    return UNORDERED_COLLECTION;
                                                case FTPReply.TRANSFER_ABORTED /* 426 */:
                                                    return UPGRADE_REQUIRED;
                                                default:
                                                    switch (i) {
                                                        case 500:
                                                            return INTERNAL_SERVER_ERROR;
                                                        case 501:
                                                            return NOT_IMPLEMENTED;
                                                        case 502:
                                                            return BAD_GATEWAY;
                                                        case 503:
                                                            return SERVICE_UNAVAILABLE;
                                                        case 504:
                                                            return GATEWAY_TIMEOUT;
                                                        case BDLocation.TypeServerCheckKeyError /* 505 */:
                                                            return HTTP_VERSION_NOT_SUPPORTED;
                                                        case 506:
                                                            return VARIANT_ALSO_NEGOTIATES;
                                                        case 507:
                                                            return INSUFFICIENT_STORAGE;
                                                        default:
                                                            return new HttpResponseStatus(i);
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return NETWORK_AUTHENTICATION_REQUIRED;
    }

    public static HttpResponseStatus parseLine(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        try {
            int indexOf = charSequence2.indexOf(32);
            if (indexOf == -1) {
                return valueOf(Integer.parseInt(charSequence2));
            }
            int parseInt = Integer.parseInt(charSequence2.substring(0, indexOf));
            String substring = charSequence2.substring(indexOf + 1);
            HttpResponseStatus valueOf = valueOf(parseInt);
            return valueOf.reasonPhrase().contentEquals(substring) ? valueOf : new HttpResponseStatus(parseInt, substring);
        } catch (Exception e) {
            throw new IllegalArgumentException("malformed status line: " + charSequence2, e);
        }
    }

    private static final class HttpStatusLineProcessor implements ByteProcessor {
        private static final byte ASCII_SPACE = 32;
        private int i;
        private int state;
        private HttpResponseStatus status;
        private final AsciiString string;

        public HttpStatusLineProcessor(AsciiString asciiString) {
            this.string = asciiString;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) {
            int i = this.state;
            if (i != 0) {
                if (i == 1) {
                    parseStatus(this.i);
                    this.state = 2;
                    return false;
                }
            } else if (b == 32) {
                this.state = 1;
            }
            this.i++;
            return true;
        }

        private void parseStatus(int i) {
            int parseInt = this.string.parseInt(0, i);
            this.status = HttpResponseStatus.valueOf(parseInt);
            if (i < this.string.length()) {
                AsciiString asciiString = this.string;
                String asciiString2 = asciiString.toString(i + 1, asciiString.length());
                if (this.status.reasonPhrase().contentEquals(asciiString2)) {
                    return;
                }
                this.status = new HttpResponseStatus(parseInt, asciiString2);
            }
        }

        public HttpResponseStatus status() {
            if (this.state <= 1) {
                parseStatus(this.string.length());
                this.state = 3;
            }
            return this.status;
        }
    }

    public static HttpResponseStatus parseLine(AsciiString asciiString) {
        try {
            HttpStatusLineProcessor httpStatusLineProcessor = new HttpStatusLineProcessor(asciiString);
            asciiString.forEachByte(httpStatusLineProcessor);
            HttpResponseStatus status = httpStatusLineProcessor.status();
            if (status != null) {
                return status;
            }
            throw new IllegalArgumentException("unable to get status after parsing input");
        } catch (Exception e) {
            throw new IllegalArgumentException("malformed status line: " + ((Object) asciiString), e);
        }
    }

    private HttpResponseStatus(int i) {
        this(i, ((Object) HttpStatusClass.valueOf(i).defaultReasonPhrase()) + " (" + i + PropertyUtils.MAPPED_DELIM2, false);
    }

    public HttpResponseStatus(int i, String str) {
        this(i, str, false);
    }

    private HttpResponseStatus(int i, String str, boolean z) {
        if (i < 0) {
            throw new IllegalArgumentException("code: " + i + " (expected: 0+)");
        }
        Objects.requireNonNull(str, "reasonPhrase");
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\n' || charAt == '\r') {
                throw new IllegalArgumentException("reasonPhrase contains one of the following prohibited characters: \\r\\n: " + str);
            }
        }
        this.code = i;
        this.codeAsText = new AsciiString(Integer.toString(i));
        this.reasonPhrase = str;
        if (z) {
            this.bytes = (i + StringUtils.SPACE + str).getBytes(CharsetUtil.US_ASCII);
        } else {
            this.bytes = null;
        }
    }

    public int code() {
        return this.code;
    }

    public AsciiString codeAsText() {
        return this.codeAsText;
    }

    public String reasonPhrase() {
        return this.reasonPhrase;
    }

    public HttpStatusClass codeClass() {
        HttpStatusClass httpStatusClass = this.codeClass;
        if (httpStatusClass != null) {
            return httpStatusClass;
        }
        HttpStatusClass valueOf = HttpStatusClass.valueOf(this.code);
        this.codeClass = valueOf;
        return valueOf;
    }

    public int hashCode() {
        return code();
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpResponseStatus) && code() == ((HttpResponseStatus) obj).code();
    }

    @Override // java.lang.Comparable
    public int compareTo(HttpResponseStatus httpResponseStatus) {
        return code() - httpResponseStatus.code();
    }

    public String toString() {
        return new StringBuilder(this.reasonPhrase.length() + 4).append((CharSequence) this.codeAsText).append(' ').append(this.reasonPhrase).toString();
    }

    void encode(ByteBuf byteBuf) {
        byte[] bArr = this.bytes;
        if (bArr == null) {
            ByteBufUtil.copy(this.codeAsText, byteBuf);
            byteBuf.writeByte(32);
            byteBuf.writeCharSequence(this.reasonPhrase, CharsetUtil.US_ASCII);
            return;
        }
        byteBuf.writeBytes(bArr);
    }
}
