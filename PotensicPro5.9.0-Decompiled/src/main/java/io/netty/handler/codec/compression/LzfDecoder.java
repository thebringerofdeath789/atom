package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.handler.codec.ByteToMessageDecoder;

/* loaded from: classes.dex */
public class LzfDecoder extends ByteToMessageDecoder {
    private static final short MAGIC_NUMBER = 23126;
    private int chunkLength;
    private State currentState;
    private ChunkDecoder decoder;
    private boolean isCompressed;
    private int originalLength;
    private BufferRecycler recycler;

    private enum State {
        INIT_BLOCK,
        INIT_ORIGINAL_LENGTH,
        DECOMPRESS_DATA,
        CORRUPTED
    }

    public LzfDecoder() {
        this(false);
    }

    public LzfDecoder(boolean z) {
        ChunkDecoder optimalInstance;
        this.currentState = State.INIT_BLOCK;
        if (z) {
            optimalInstance = ChunkDecoderFactory.safeInstance();
        } else {
            optimalInstance = ChunkDecoderFactory.optimalInstance();
        }
        this.decoder = optimalInstance;
        this.recycler = BufferRecycler.instance();
    }

    /* renamed from: io.netty.handler.codec.compression.LzfDecoder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State = iArr;
            try {
                iArr[State.INIT_BLOCK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.INIT_ORIGINAL_LENGTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.DECOMPRESS_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[State.CORRUPTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0093 A[Catch: Exception -> 0x010d, TryCatch #1 {Exception -> 0x010d, blocks: (B:2:0x0000, B:8:0x0017, B:11:0x0020, B:12:0x0025, B:13:0x0089, B:17:0x0093, B:19:0x0099, B:21:0x00a3, B:22:0x00b9, B:26:0x00e5, B:28:0x00eb, B:29:0x00ff, B:33:0x00f2, B:34:0x00f5, B:35:0x00ae, B:37:0x00f8, B:38:0x0077, B:42:0x007f, B:43:0x0026, B:47:0x002f, B:49:0x0037, B:52:0x003f, B:53:0x006d, B:57:0x0046, B:58:0x0066, B:59:0x0067, B:60:0x0104, B:61:0x010c, B:25:0x00cf), top: B:1:0x0000, inners: #0 }] */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r12, io.netty.buffer.ByteBuf r13, java.util.List<java.lang.Object> r14) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.LzfDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
