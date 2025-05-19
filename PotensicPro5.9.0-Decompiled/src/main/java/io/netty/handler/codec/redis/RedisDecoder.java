package io.netty.handler.codec.redis;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class RedisDecoder extends ByteToMessageDecoder {
    private final int maxInlineMessageLength;
    private final RedisMessagePool messagePool;
    private int remainingBulkLength;
    private State state;
    private final ToPositiveLongProcessor toPositiveLongProcessor;
    private RedisMessageType type;

    private enum State {
        DECODE_TYPE,
        DECODE_INLINE,
        DECODE_LENGTH,
        DECODE_BULK_STRING_EOL,
        DECODE_BULK_STRING_CONTENT
    }

    public RedisDecoder() {
        this(65536, FixedRedisMessagePool.INSTANCE);
    }

    public RedisDecoder(int i, RedisMessagePool redisMessagePool) {
        this.toPositiveLongProcessor = new ToPositiveLongProcessor(null);
        this.state = State.DECODE_TYPE;
        if (i <= 0 || i > 536870912) {
            throw new RedisCodecException("maxInlineMessageLength: " + i + " (expected: <= 536870912)");
        }
        this.maxInlineMessageLength = i;
        this.messagePool = redisMessagePool;
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (true) {
            try {
                int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[this.state.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                if (i == 5) {
                                    if (!decodeBulkStringContent(byteBuf, list)) {
                                        return;
                                    }
                                } else {
                                    throw new RedisCodecException("Unknown state: " + this.state);
                                }
                            } else if (!decodeBulkStringEndOfLine(byteBuf, list)) {
                                return;
                            }
                        } else if (!decodeLength(byteBuf, list)) {
                            return;
                        }
                    } else if (!decodeInline(byteBuf, list)) {
                        return;
                    }
                } else if (!decodeType(byteBuf)) {
                    return;
                }
            } catch (RedisCodecException e) {
                resetDecoder();
                throw e;
            } catch (Exception e2) {
                resetDecoder();
                throw new RedisCodecException(e2);
            }
        }
    }

    private void resetDecoder() {
        this.state = State.DECODE_TYPE;
        this.remainingBulkLength = 0;
    }

    private boolean decodeType(ByteBuf byteBuf) throws Exception {
        if (!byteBuf.isReadable()) {
            return false;
        }
        RedisMessageType valueOf = RedisMessageType.valueOf(byteBuf.readByte());
        this.type = valueOf;
        this.state = valueOf.isInline() ? State.DECODE_INLINE : State.DECODE_LENGTH;
        return true;
    }

    private boolean decodeInline(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            if (byteBuf.readableBytes() <= this.maxInlineMessageLength) {
                return false;
            }
            throw new RedisCodecException("length: " + byteBuf.readableBytes() + " (expected: <= " + this.maxInlineMessageLength + ")");
        }
        list.add(newInlineRedisMessage(this.type, readLine));
        resetDecoder();
        return true;
    }

    private boolean decodeLength(ByteBuf byteBuf, List<Object> list) throws Exception {
        ByteBuf readLine = readLine(byteBuf);
        if (readLine == null) {
            return false;
        }
        long parseRedisNumber = parseRedisNumber(readLine);
        if (parseRedisNumber < -1) {
            throw new RedisCodecException("length: " + parseRedisNumber + " (expected: >= -1)");
        }
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[this.type.ordinal()];
        if (i == 1) {
            list.add(new ArrayHeaderRedisMessage(parseRedisNumber));
            resetDecoder();
            return true;
        }
        if (i != 2) {
            throw new RedisCodecException("bad type: " + this.type);
        }
        if (parseRedisNumber > IjkMediaMeta.AV_CH_STEREO_LEFT) {
            throw new RedisCodecException("length: " + parseRedisNumber + " (expected: <= 536870912)");
        }
        this.remainingBulkLength = (int) parseRedisNumber;
        return decodeBulkString(byteBuf, list);
    }

    /* renamed from: io.netty.handler.codec.redis.RedisDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$redis$RedisMessageType;

        static {
            int[] iArr = new int[RedisMessageType.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisMessageType = iArr;
            try {
                iArr[RedisMessageType.ARRAY_HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.BULK_STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.SIMPLE_STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisMessageType[RedisMessageType.INTEGER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State = iArr2;
            try {
                iArr2[State.DECODE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_INLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_LENGTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_EOL.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$redis$RedisDecoder$State[State.DECODE_BULK_STRING_CONTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private boolean decodeBulkString(ByteBuf byteBuf, List<Object> list) throws Exception {
        int i = this.remainingBulkLength;
        if (i == -1) {
            list.add(FullBulkStringRedisMessage.NULL_INSTANCE);
            resetDecoder();
            return true;
        }
        if (i == 0) {
            this.state = State.DECODE_BULK_STRING_EOL;
            return decodeBulkStringEndOfLine(byteBuf, list);
        }
        list.add(new BulkStringHeaderRedisMessage(this.remainingBulkLength));
        this.state = State.DECODE_BULK_STRING_CONTENT;
        return decodeBulkStringContent(byteBuf, list);
    }

    private boolean decodeBulkStringEndOfLine(ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 2) {
            return false;
        }
        readEndOfLine(byteBuf);
        list.add(FullBulkStringRedisMessage.EMPTY_INSTANCE);
        resetDecoder();
        return true;
    }

    private boolean decodeBulkStringContent(ByteBuf byteBuf, List<Object> list) throws Exception {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes == 0) {
            return false;
        }
        int i = this.remainingBulkLength;
        if (i == 0 && readableBytes < 2) {
            return false;
        }
        if (readableBytes >= i + 2) {
            ByteBuf readSlice = byteBuf.readSlice(i);
            readEndOfLine(byteBuf);
            list.add(new DefaultLastBulkStringRedisContent(readSlice.retain()));
            resetDecoder();
            return true;
        }
        int min = Math.min(i, readableBytes);
        this.remainingBulkLength -= min;
        list.add(new DefaultBulkStringRedisContent(byteBuf.readSlice(min).retain()));
        return true;
    }

    private static void readEndOfLine(ByteBuf byteBuf) {
        short readShort = byteBuf.readShort();
        if (RedisConstants.EOL_SHORT == readShort) {
            return;
        }
        byte[] shortToBytes = RedisCodecUtil.shortToBytes(readShort);
        throw new RedisCodecException("delimiter: [" + ((int) shortToBytes[0]) + "," + ((int) shortToBytes[1]) + "] (expected: \\r\\n)");
    }

    private RedisMessage newInlineRedisMessage(RedisMessageType redisMessageType, ByteBuf byteBuf) {
        int i = AnonymousClass1.$SwitchMap$io$netty$handler$codec$redis$RedisMessageType[redisMessageType.ordinal()];
        if (i == 3) {
            SimpleStringRedisMessage simpleString = this.messagePool.getSimpleString(byteBuf);
            return simpleString != null ? simpleString : new SimpleStringRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i == 4) {
            ErrorRedisMessage error = this.messagePool.getError(byteBuf);
            return error != null ? error : new ErrorRedisMessage(byteBuf.toString(CharsetUtil.UTF_8));
        }
        if (i == 5) {
            IntegerRedisMessage integer = this.messagePool.getInteger(byteBuf);
            return integer != null ? integer : new IntegerRedisMessage(parseRedisNumber(byteBuf));
        }
        throw new RedisCodecException("bad type: " + redisMessageType);
    }

    private static ByteBuf readLine(ByteBuf byteBuf) {
        int forEachByte;
        if (!byteBuf.isReadable(2) || (forEachByte = byteBuf.forEachByte(ByteProcessor.FIND_LF)) < 0) {
            return null;
        }
        ByteBuf readSlice = byteBuf.readSlice((forEachByte - byteBuf.readerIndex()) - 1);
        readEndOfLine(byteBuf);
        return readSlice;
    }

    private long parseRedisNumber(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        int i = (readableBytes <= 0 || byteBuf.getByte(byteBuf.readerIndex()) != 45) ? 0 : 1;
        if (readableBytes <= i) {
            throw new RedisCodecException("no number to parse: " + byteBuf.toString(CharsetUtil.US_ASCII));
        }
        if (readableBytes > i + 19) {
            throw new RedisCodecException("too many characters to be a valid RESP Integer: " + byteBuf.toString(CharsetUtil.US_ASCII));
        }
        if (i != 0) {
            return -parsePositiveNumber(byteBuf.skipBytes(i));
        }
        return parsePositiveNumber(byteBuf);
    }

    private long parsePositiveNumber(ByteBuf byteBuf) {
        this.toPositiveLongProcessor.reset();
        byteBuf.forEachByte(this.toPositiveLongProcessor);
        return this.toPositiveLongProcessor.content();
    }

    private static final class ToPositiveLongProcessor implements ByteProcessor {
        private long result;

        private ToPositiveLongProcessor() {
        }

        /* synthetic */ ToPositiveLongProcessor(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b) throws Exception {
            if (b < 48 || b > 57) {
                throw new RedisCodecException("bad byte in number: " + ((int) b));
            }
            this.result = (this.result * 10) + (b - 48);
            return true;
        }

        public long content() {
            return this.result;
        }

        public void reset() {
            this.result = 0L;
        }
    }
}
