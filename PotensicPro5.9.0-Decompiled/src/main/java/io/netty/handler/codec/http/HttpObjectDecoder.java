package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.PrematureChannelClosureException;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.AppendableCharSequence;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class HttpObjectDecoder extends ByteToMessageDecoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String EMPTY_VALUE = "";
    private long chunkSize;
    private final boolean chunkedSupported;
    private long contentLength;
    private State currentState;
    private final HeaderParser headerParser;
    private final LineParser lineParser;
    private final int maxChunkSize;
    private HttpMessage message;
    private CharSequence name;
    private volatile boolean resetRequested;
    private LastHttpContent trailer;
    protected final boolean validateHeaders;
    private CharSequence value;

    private enum State {
        SKIP_CONTROL_CHARS,
        READ_INITIAL,
        READ_HEADER,
        READ_VARIABLE_LENGTH_CONTENT,
        READ_FIXED_LENGTH_CONTENT,
        READ_CHUNK_SIZE,
        READ_CHUNKED_CONTENT,
        READ_CHUNK_DELIMITER,
        READ_CHUNK_FOOTER,
        BAD_MESSAGE,
        UPGRADED
    }

    protected abstract HttpMessage createInvalidMessage();

    protected abstract HttpMessage createMessage(String[] strArr) throws Exception;

    protected abstract boolean isDecodingRequest();

    protected HttpObjectDecoder() {
        this(4096, 8192, 8192, true);
    }

    protected HttpObjectDecoder(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, z, true);
    }

    protected HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2) {
        this(i, i2, i3, z, z2, 128);
    }

    protected HttpObjectDecoder(int i, int i2, int i3, boolean z, boolean z2, int i4) {
        this.contentLength = Long.MIN_VALUE;
        this.currentState = State.SKIP_CONTROL_CHARS;
        if (i <= 0) {
            throw new IllegalArgumentException("maxInitialLineLength must be a positive integer: " + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxHeaderSize must be a positive integer: " + i2);
        }
        if (i3 <= 0) {
            throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i3);
        }
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(i4);
        this.lineParser = new LineParser(appendableCharSequence, i);
        this.headerParser = new HeaderParser(appendableCharSequence, i2);
        this.maxChunkSize = i3;
        this.chunkedSupported = z;
        this.validateHeaders = z2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0106 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0126 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0127 A[Catch: Exception -> 0x01ad, TryCatch #1 {Exception -> 0x01ad, blocks: (B:63:0x011e, B:66:0x0127, B:68:0x012f, B:70:0x0134), top: B:62:0x011e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0144 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0145 A[Catch: Exception -> 0x01a4, TryCatch #3 {Exception -> 0x01a4, blocks: (B:87:0x013e, B:90:0x0145, B:94:0x0155, B:98:0x0163, B:101:0x016a, B:103:0x0173, B:106:0x0176, B:108:0x0184, B:110:0x0188, B:112:0x018e, B:113:0x0195, B:114:0x0196), top: B:86:0x013e }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.HttpObjectDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    /* renamed from: io.netty.handler.codec.http.HttpObjectDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_SIZE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_INITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_HEADER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_VARIABLE_LENGTH_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_FIXED_LENGTH_CONTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNKED_CONTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_DELIMITER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.READ_CHUNK_FOOTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.BAD_MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[State.UPGRADED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        super.decodeLast(channelHandlerContext, byteBuf, list);
        if (this.resetRequested) {
            resetNow();
        }
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            boolean isTransferEncodingChunked = HttpUtil.isTransferEncodingChunked(httpMessage);
            if (this.currentState == State.READ_VARIABLE_LENGTH_CONTENT && !byteBuf.isReadable() && !isTransferEncodingChunked) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
                resetNow();
                return;
            }
            if (this.currentState == State.READ_HEADER) {
                list.add(invalidMessage(Unpooled.EMPTY_BUFFER, new PrematureChannelClosureException("Connection closed before received headers")));
                resetNow();
                return;
            }
            boolean z = true;
            if (!isDecodingRequest() && !isTransferEncodingChunked && contentLength() <= 0) {
                z = false;
            }
            if (!z) {
                list.add(LastHttpContent.EMPTY_LAST_CONTENT);
            }
            resetNow();
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder, io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        int i;
        if ((obj instanceof HttpExpectationFailedEvent) && ((i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$HttpObjectDecoder$State[this.currentState.ordinal()]) == 2 || i == 5 || i == 6)) {
            reset();
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    protected boolean isContentAlwaysEmpty(HttpMessage httpMessage) {
        if (httpMessage instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpMessage;
            int code = httpResponse.status().code();
            if (code >= 100 && code < 200) {
                return (code == 101 && !httpResponse.headers().contains(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT) && httpResponse.headers().contains((CharSequence) HttpHeaderNames.UPGRADE, (CharSequence) HttpHeaderValues.WEBSOCKET, true)) ? false : true;
            }
            if (code == 204 || code == 304) {
                return true;
            }
        }
        return false;
    }

    protected boolean isSwitchingToNonHttp1Protocol(HttpResponse httpResponse) {
        if (httpResponse.status().code() != HttpResponseStatus.SWITCHING_PROTOCOLS.code()) {
            return false;
        }
        String str = httpResponse.headers().get(HttpHeaderNames.UPGRADE);
        return str == null || !(str.contains(HttpVersion.HTTP_1_0.text()) || str.contains(HttpVersion.HTTP_1_1.text()));
    }

    public void reset() {
        this.resetRequested = true;
    }

    private void resetNow() {
        HttpResponse httpResponse;
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.name = null;
        this.value = null;
        this.contentLength = Long.MIN_VALUE;
        this.lineParser.reset();
        this.headerParser.reset();
        this.trailer = null;
        if (!isDecodingRequest() && (httpResponse = (HttpResponse) httpMessage) != null && isSwitchingToNonHttp1Protocol(httpResponse)) {
            this.currentState = State.UPGRADED;
        } else {
            this.resetRequested = false;
            this.currentState = State.SKIP_CONTROL_CHARS;
        }
    }

    private HttpMessage invalidMessage(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        HttpMessage httpMessage = this.message;
        if (httpMessage != null) {
            httpMessage.setDecoderResult(DecoderResult.failure(exc));
        } else {
            HttpMessage createInvalidMessage = createInvalidMessage();
            this.message = createInvalidMessage;
            createInvalidMessage.setDecoderResult(DecoderResult.failure(exc));
        }
        HttpMessage httpMessage2 = this.message;
        this.message = null;
        return httpMessage2;
    }

    private HttpContent invalidChunk(ByteBuf byteBuf, Exception exc) {
        this.currentState = State.BAD_MESSAGE;
        byteBuf.skipBytes(byteBuf.readableBytes());
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER);
        defaultLastHttpContent.setDecoderResult(DecoderResult.failure(exc));
        this.message = null;
        this.trailer = null;
        return defaultLastHttpContent;
    }

    private static boolean skipControlCharacters(ByteBuf byteBuf) {
        boolean z;
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        while (true) {
            if (writerIndex <= readerIndex) {
                z = false;
                break;
            }
            int i = readerIndex + 1;
            short unsignedByte = byteBuf.getUnsignedByte(readerIndex);
            if (!Character.isISOControl(unsignedByte) && !Character.isWhitespace(unsignedByte)) {
                readerIndex = i - 1;
                z = true;
                break;
            }
            readerIndex = i;
        }
        byteBuf.readerIndex(readerIndex);
        return z;
    }

    private State readHeaders(ByteBuf byteBuf) {
        HttpMessage httpMessage = this.message;
        HttpHeaders headers = httpMessage.headers();
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        if (parse.length() > 0) {
            do {
                char charAt = parse.charAt(0);
                CharSequence charSequence = this.name;
                if (charSequence != null && (charAt == ' ' || charAt == '\t')) {
                    this.value = String.valueOf(this.value) + ' ' + parse.toString().trim();
                } else {
                    if (charSequence != null) {
                        headers.add(charSequence, this.value);
                    }
                    splitHeader(parse);
                }
                parse = this.headerParser.parse(byteBuf);
                if (parse == null) {
                    return null;
                }
            } while (parse.length() > 0);
        }
        CharSequence charSequence2 = this.name;
        if (charSequence2 != null) {
            headers.add(charSequence2, this.value);
        }
        this.name = null;
        this.value = null;
        if (isContentAlwaysEmpty(httpMessage)) {
            HttpUtil.setTransferEncodingChunked(httpMessage, false);
            return State.SKIP_CONTROL_CHARS;
        }
        if (HttpUtil.isTransferEncodingChunked(httpMessage)) {
            return State.READ_CHUNK_SIZE;
        }
        if (contentLength() >= 0) {
            return State.READ_FIXED_LENGTH_CONTENT;
        }
        return State.READ_VARIABLE_LENGTH_CONTENT;
    }

    private long contentLength() {
        if (this.contentLength == Long.MIN_VALUE) {
            this.contentLength = HttpUtil.getContentLength(this.message, -1L);
        }
        return this.contentLength;
    }

    private LastHttpContent readTrailingHeaders(ByteBuf byteBuf) {
        AppendableCharSequence parse = this.headerParser.parse(byteBuf);
        if (parse == null) {
            return null;
        }
        if (parse.length() > 0) {
            LastHttpContent lastHttpContent = this.trailer;
            if (lastHttpContent == null) {
                lastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
                this.trailer = lastHttpContent;
            }
            CharSequence charSequence = null;
            do {
                char charAt = parse.charAt(0);
                if (charSequence != null && (charAt == ' ' || charAt == '\t')) {
                    List<String> all = lastHttpContent.trailingHeaders().getAll(charSequence);
                    if (!all.isEmpty()) {
                        int size = all.size() - 1;
                        all.set(size, all.get(size) + parse.toString().trim());
                    }
                } else {
                    splitHeader(parse);
                    CharSequence charSequence2 = this.name;
                    if (!HttpHeaderNames.CONTENT_LENGTH.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRANSFER_ENCODING.contentEqualsIgnoreCase(charSequence2) && !HttpHeaderNames.TRAILER.contentEqualsIgnoreCase(charSequence2)) {
                        lastHttpContent.trailingHeaders().add(charSequence2, this.value);
                    }
                    charSequence = this.name;
                    this.name = null;
                    this.value = null;
                }
                parse = this.headerParser.parse(byteBuf);
                if (parse == null) {
                    return null;
                }
            } while (parse.length() > 0);
            this.trailer = null;
            return lastHttpContent;
        }
        return LastHttpContent.EMPTY_LAST_CONTENT;
    }

    private static int getChunkSize(String str) {
        String trim = str.trim();
        for (int i = 0; i < trim.length(); i++) {
            char charAt = trim.charAt(i);
            if (charAt == ';' || Character.isWhitespace(charAt) || Character.isISOControl(charAt)) {
                trim = trim.substring(0, i);
                break;
            }
        }
        return Integer.parseInt(trim, 16);
    }

    private static String[] splitInitialLine(AppendableCharSequence appendableCharSequence) {
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int findWhitespace = findWhitespace(appendableCharSequence, findNonWhitespace);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, findWhitespace);
        int findWhitespace2 = findWhitespace(appendableCharSequence, findNonWhitespace2);
        int findNonWhitespace3 = findNonWhitespace(appendableCharSequence, findWhitespace2);
        int findEndOfString = findEndOfString(appendableCharSequence);
        String[] strArr = new String[3];
        strArr[0] = appendableCharSequence.subStringUnsafe(findNonWhitespace, findWhitespace);
        strArr[1] = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findWhitespace2);
        strArr[2] = findNonWhitespace3 < findEndOfString ? appendableCharSequence.subStringUnsafe(findNonWhitespace3, findEndOfString) : "";
        return strArr;
    }

    private void splitHeader(AppendableCharSequence appendableCharSequence) {
        char charAt;
        int length = appendableCharSequence.length();
        int findNonWhitespace = findNonWhitespace(appendableCharSequence, 0);
        int i = findNonWhitespace;
        while (i < length && (charAt = appendableCharSequence.charAt(i)) != ':' && !Character.isWhitespace(charAt)) {
            i++;
        }
        int i2 = i;
        while (true) {
            if (i2 >= length) {
                break;
            }
            if (appendableCharSequence.charAt(i2) == ':') {
                i2++;
                break;
            }
            i2++;
        }
        this.name = appendableCharSequence.subStringUnsafe(findNonWhitespace, i);
        int findNonWhitespace2 = findNonWhitespace(appendableCharSequence, i2);
        if (findNonWhitespace2 == length) {
            this.value = "";
        } else {
            this.value = appendableCharSequence.subStringUnsafe(findNonWhitespace2, findEndOfString(appendableCharSequence));
        }
    }

    private static int findNonWhitespace(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(i))) {
                return i;
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int findWhitespace(AppendableCharSequence appendableCharSequence, int i) {
        while (i < appendableCharSequence.length()) {
            if (Character.isWhitespace(appendableCharSequence.charAtUnsafe(i))) {
                return i;
            }
            i++;
        }
        return appendableCharSequence.length();
    }

    private static int findEndOfString(AppendableCharSequence appendableCharSequence) {
        for (int length = appendableCharSequence.length() - 1; length > 0; length--) {
            if (!Character.isWhitespace(appendableCharSequence.charAtUnsafe(length))) {
                return length + 1;
            }
        }
        return 0;
    }

    private static class HeaderParser implements ByteProcessor {
        private final int maxLength;
        private final AppendableCharSequence seq;
        private int size;

        HeaderParser(AppendableCharSequence appendableCharSequence, int i) {
            this.seq = appendableCharSequence;
            this.maxLength = i;
        }

        public AppendableCharSequence parse(ByteBuf byteBuf) {
            int i = this.size;
            this.seq.reset();
            int forEachByte = byteBuf.forEachByte(this);
            if (forEachByte == -1) {
                this.size = i;
                return null;
            }
            byteBuf.readerIndex(forEachByte + 1);
            return this.seq;
        }

        public void reset() {
            this.size = 0;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) throws Exception {
            char c = (char) (b & 255);
            if (c == '\r') {
                return true;
            }
            if (c == '\n') {
                return false;
            }
            int i = this.size + 1;
            this.size = i;
            int i2 = this.maxLength;
            if (i > i2) {
                throw newException(i2);
            }
            this.seq.append(c);
            return true;
        }

        protected TooLongFrameException newException(int i) {
            return new TooLongFrameException("HTTP header is larger than " + i + " bytes.");
        }
    }

    private static final class LineParser extends HeaderParser {
        LineParser(AppendableCharSequence appendableCharSequence, int i) {
            super(appendableCharSequence, i);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        public AppendableCharSequence parse(ByteBuf byteBuf) {
            reset();
            return super.parse(byteBuf);
        }

        @Override // io.netty.handler.codec.http.HttpObjectDecoder.HeaderParser
        protected TooLongFrameException newException(int i) {
            return new TooLongFrameException("An HTTP line is larger than " + i + " bytes.");
        }
    }
}
