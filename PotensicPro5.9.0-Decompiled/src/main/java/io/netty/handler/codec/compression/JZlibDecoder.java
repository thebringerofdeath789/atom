package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;
import java.util.Objects;

/* loaded from: classes.dex */
public class JZlibDecoder extends ZlibDecoder {
    private byte[] dictionary;
    private volatile boolean finished;
    private final Inflater z;

    public JZlibDecoder() {
        this(ZlibWrapper.ZLIB);
    }

    public JZlibDecoder(ZlibWrapper zlibWrapper) {
        Inflater inflater = new Inflater();
        this.z = inflater;
        Objects.requireNonNull(zlibWrapper, "wrapper");
        int init = inflater.init(ZlibUtil.convertWrapperType(zlibWrapper));
        if (init != 0) {
            ZlibUtil.fail(inflater, "initialization failure", init);
        }
    }

    public JZlibDecoder(byte[] bArr) {
        Inflater inflater = new Inflater();
        this.z = inflater;
        Objects.requireNonNull(bArr, "dictionary");
        this.dictionary = bArr;
        int inflateInit = inflater.inflateInit(JZlib.W_ZLIB);
        if (inflateInit != 0) {
            ZlibUtil.fail(inflater, "initialization failure", inflateInit);
        }
    }

    @Override // io.netty.handler.codec.compression.ZlibDecoder
    public boolean isClosed() {
        return this.finished;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bf, code lost:
    
        r7.finished = true;
        r7.z.inflateEnd();
     */
    @Override // io.netty.handler.codec.ByteToMessageDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void decode(io.netty.channel.ChannelHandlerContext r8, io.netty.buffer.ByteBuf r9, java.util.List<java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.JZlibDecoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }
}
