package io.netty.handler.codec.compression;

import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

/* loaded from: classes.dex */
public class FastLzFrameDecoder extends ByteToMessageDecoder {
    private final Checksum checksum;
    private int chunkLength;
    private int currentChecksum;
    private State currentState;
    private boolean hasChecksum;
    private boolean isCompressed;
    private int originalLength;

    private enum State {
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public FastLzFrameDecoder() {
        this(false);
    }

    public FastLzFrameDecoder(boolean z) {
        this(z ? new Adler32() : null);
    }

    public FastLzFrameDecoder(Checksum checksum) {
        this.currentState = State.INIT_BLOCK;
        this.checksum = checksum;
    }

    /* renamed from: io.netty.handler.codec.compression.FastLzFrameDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.INIT_BLOCK_PARAMS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0095 A[Catch: Exception -> 0x015e, TryCatch #0 {Exception -> 0x015e, blocks: (B:3:0x0004, B:9:0x001b, B:12:0x0024, B:13:0x0029, B:14:0x008b, B:18:0x0095, B:20:0x009d, B:48:0x0151, B:49:0x0154, B:50:0x00b6, B:52:0x0056, B:55:0x0061, B:58:0x0068, B:63:0x006f, B:64:0x0075, B:66:0x0081, B:67:0x0085, B:71:0x002a, B:75:0x0032, B:77:0x003b, B:80:0x0046, B:83:0x0050, B:86:0x0155, B:87:0x015d, B:22:0x00bc, B:24:0x00c0, B:26:0x00c6, B:27:0x00d6, B:30:0x0102, B:33:0x010a, B:36:0x011a, B:37:0x0136, B:39:0x0139, B:40:0x0146, B:42:0x00e3, B:43:0x00fd, B:44:0x00d0, B:45:0x00fe), top: B:2:0x0004, inners: #1 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r17, io.netty.buffer.ByteBuf r18, java.util.List<java.lang.Object> r19) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.FastLzFrameDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
