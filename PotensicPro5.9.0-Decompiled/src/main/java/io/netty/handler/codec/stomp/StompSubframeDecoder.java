package io.netty.handler.codec.stomp;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.ReplayingDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.internal.AppendableCharSequence;
import java.util.Locale;

/* loaded from: classes3.dex */
public class StompSubframeDecoder extends ReplayingDecoder<State> {
    private static final int DEFAULT_CHUNK_SIZE = 8132;
    private static final int DEFAULT_MAX_LINE_LENGTH = 1024;
    private int alreadyReadChunkSize;
    private long contentLength;
    private LastStompContentSubframe lastContent;
    private final int maxChunkSize;
    private final int maxLineLength;
    private final boolean validateHeaders;

    enum State {
        SKIP_CONTROL_CHARACTERS,
        READ_HEADERS,
        READ_CONTENT,
        FINALIZE_FRAME_READ,
        BAD_FRAME,
        INVALID_CHUNK
    }

    public StompSubframeDecoder() {
        this(1024, DEFAULT_CHUNK_SIZE);
    }

    public StompSubframeDecoder(boolean z) {
        this(1024, DEFAULT_CHUNK_SIZE, z);
    }

    public StompSubframeDecoder(int i, int i2) {
        this(i, i2, false);
    }

    public StompSubframeDecoder(int i, int i2, boolean z) {
        super(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        if (i <= 0) {
            throw new IllegalArgumentException("maxLineLength must be a positive integer: " + i);
        }
        if (i2 <= 0) {
            throw new IllegalArgumentException("maxChunkSize must be a positive integer: " + i2);
        }
        this.maxChunkSize = i2;
        this.maxLineLength = i;
        this.validateHeaders = z;
    }

    /* renamed from: io.netty.handler.codec.stomp.StompSubframeDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State = iArr;
            try {
                iArr[State.SKIP_CONTROL_CHARACTERS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_HEADERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.BAD_FRAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.READ_CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$stomp$StompSubframeDecoder$State[State.FINALIZE_FRAME_READ.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00eb A[Catch: Exception -> 0x0101, TryCatch #2 {Exception -> 0x0101, blocks: (B:11:0x0042, B:17:0x00e4, B:19:0x00eb, B:20:0x00ef, B:22:0x0058, B:25:0x005f, B:28:0x0064, B:30:0x006c, B:33:0x0074, B:35:0x0088, B:36:0x0095, B:38:0x009e, B:40:0x00b1, B:42:0x00b9, B:43:0x00c9, B:45:0x00d8, B:46:0x00f8, B:48:0x00c0), top: B:10:0x0042 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058 A[Catch: Exception -> 0x0101, TryCatch #2 {Exception -> 0x0101, blocks: (B:11:0x0042, B:17:0x00e4, B:19:0x00eb, B:20:0x00ef, B:22:0x0058, B:25:0x005f, B:28:0x0064, B:30:0x006c, B:33:0x0074, B:35:0x0088, B:36:0x0095, B:38:0x009e, B:40:0x00b1, B:42:0x00b9, B:43:0x00c9, B:45:0x00d8, B:46:0x00f8, B:48:0x00c0), top: B:10:0x0042 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r6, io.netty.buffer.ByteBuf r7, java.util.List<java.lang.Object> r8) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.stomp.StompSubframeDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    private StompCommand readCommand(ByteBuf byteBuf) {
        StompCommand stompCommand;
        String readLine = readLine(byteBuf, this.maxLineLength);
        try {
            stompCommand = StompCommand.valueOf(readLine);
        } catch (IllegalArgumentException unused) {
            stompCommand = null;
        }
        if (stompCommand == null) {
            try {
                stompCommand = StompCommand.valueOf(readLine.toUpperCase(Locale.US));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (stompCommand != null) {
            return stompCommand;
        }
        throw new DecoderException("failed to read command from channel");
    }

    private State readHeaders(ByteBuf byteBuf, StompHeaders stompHeaders) {
        while (true) {
            String readLine = readLine(byteBuf, this.maxLineLength);
            if (!readLine.isEmpty()) {
                String[] split = readLine.split(":");
                if (split.length == 2) {
                    stompHeaders.add((StompHeaders) split[0], split[1]);
                } else if (this.validateHeaders) {
                    throw new IllegalArgumentException("a header value or name contains a prohibited character ':', " + readLine);
                }
            } else {
                if (stompHeaders.contains(StompHeaders.CONTENT_LENGTH)) {
                    long contentLength = getContentLength(stompHeaders, 0L);
                    this.contentLength = contentLength;
                    if (contentLength == 0) {
                        return State.FINALIZE_FRAME_READ;
                    }
                }
                return State.READ_CONTENT;
            }
        }
    }

    private static long getContentLength(StompHeaders stompHeaders, long j) {
        long j2 = stompHeaders.getLong(StompHeaders.CONTENT_LENGTH, j);
        if (j2 >= 0) {
            return j2;
        }
        throw new DecoderException(((Object) StompHeaders.CONTENT_LENGTH) + " must be non-negative");
    }

    private static void skipNullCharacter(ByteBuf byteBuf) {
        byte readByte = byteBuf.readByte();
        if (readByte != 0) {
            throw new IllegalStateException("unexpected byte in buffer " + ((int) readByte) + " while expecting NULL byte");
        }
    }

    private static void skipControlCharacters(ByteBuf byteBuf) {
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte != 13 && readByte != 10) {
                byteBuf.readerIndex(byteBuf.readerIndex() - 1);
                return;
            }
        }
    }

    private static String readLine(ByteBuf byteBuf, int i) {
        AppendableCharSequence appendableCharSequence = new AppendableCharSequence(128);
        int i2 = 0;
        while (true) {
            byte readByte = byteBuf.readByte();
            if (readByte == 13) {
                if (byteBuf.readByte() == 10) {
                    return appendableCharSequence.toString();
                }
            } else {
                if (readByte == 10) {
                    return appendableCharSequence.toString();
                }
                if (i2 >= i) {
                    throw new TooLongFrameException("An STOMP line is larger than " + i + " bytes.");
                }
                i2++;
                appendableCharSequence.append((char) readByte);
            }
        }
    }

    private void resetDecoder() {
        checkpoint(State.SKIP_CONTROL_CHARACTERS);
        this.contentLength = -1L;
        this.alreadyReadChunkSize = 0;
        this.lastContent = null;
    }
}
