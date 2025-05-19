package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Objects;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
public abstract class AbstractMemoryHttpData extends AbstractHttpData {
    private ByteBuf byteBuf;
    private int chunkPosition;

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isInMemory() {
        return true;
    }

    protected AbstractMemoryHttpData(String str, Charset charset, long j) {
        super(str, charset, j);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(ByteBuf byteBuf) throws IOException {
        Objects.requireNonNull(byteBuf, "buffer");
        long readableBytes = byteBuf.readableBytes();
        checkSize(readableBytes);
        if (this.definedSize > 0 && this.definedSize < readableBytes) {
            throw new IOException("Out of size: " + readableBytes + " > " + this.definedSize);
        }
        ByteBuf byteBuf2 = this.byteBuf;
        if (byteBuf2 != null) {
            byteBuf2.release();
        }
        this.byteBuf = byteBuf;
        this.size = readableBytes;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(InputStream inputStream) throws IOException {
        Objects.requireNonNull(inputStream, "inputStream");
        ByteBuf buffer = Unpooled.buffer();
        byte[] bArr = new byte[16384];
        int read = inputStream.read(bArr);
        int i = 0;
        while (read > 0) {
            buffer.writeBytes(bArr, 0, read);
            i += read;
            checkSize(i);
            read = inputStream.read(bArr);
        }
        this.size = i;
        if (this.definedSize > 0 && this.definedSize < this.size) {
            throw new IOException("Out of size: " + this.size + " > " + this.definedSize);
        }
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
        }
        this.byteBuf = buffer;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void addContent(ByteBuf byteBuf, boolean z) throws IOException {
        if (byteBuf != null) {
            long readableBytes = byteBuf.readableBytes();
            checkSize(this.size + readableBytes);
            if (this.definedSize > 0 && this.definedSize < this.size + readableBytes) {
                throw new IOException("Out of size: " + (this.size + readableBytes) + " > " + this.definedSize);
            }
            this.size += readableBytes;
            ByteBuf byteBuf2 = this.byteBuf;
            if (byteBuf2 == null) {
                this.byteBuf = byteBuf;
            } else if (byteBuf2 instanceof CompositeByteBuf) {
                ((CompositeByteBuf) byteBuf2).addComponent(true, byteBuf);
            } else {
                CompositeByteBuf compositeBuffer = Unpooled.compositeBuffer(Integer.MAX_VALUE);
                compositeBuffer.addComponents(true, this.byteBuf, byteBuf);
                this.byteBuf = compositeBuffer;
            }
        }
        if (z) {
            setCompleted();
        } else {
            Objects.requireNonNull(byteBuf, "buffer");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setContent(File file) throws IOException {
        Objects.requireNonNull(file, StringLookupFactory.KEY_FILE);
        long length = file.length();
        if (length > 2147483647L) {
            throw new IllegalArgumentException("File too big to be loaded in memory");
        }
        checkSize(length);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel channel = fileInputStream.getChannel();
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(int) length]);
        for (int i = 0; i < length; i += channel.read(wrap)) {
        }
        channel.close();
        fileInputStream.close();
        wrap.flip();
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
        }
        this.byteBuf = Unpooled.wrappedBuffer(Integer.MAX_VALUE, wrap);
        this.size = length;
        setCompleted();
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void delete() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.release();
            this.byteBuf = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public byte[] get() {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            return Unpooled.EMPTY_BUFFER.array();
        }
        byte[] bArr = new byte[byteBuf.readableBytes()];
        ByteBuf byteBuf2 = this.byteBuf;
        byteBuf2.getBytes(byteBuf2.readerIndex(), bArr);
        return bArr;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString() {
        return getString(HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public String getString(Charset charset) {
        if (this.byteBuf == null) {
            return "";
        }
        if (charset == null) {
            charset = HttpConstants.DEFAULT_CHARSET;
        }
        return this.byteBuf.toString(charset);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getByteBuf() {
        return this.byteBuf;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public ByteBuf getChunk(int i) throws IOException {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null || i == 0 || byteBuf.readableBytes() == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        int readableBytes = this.byteBuf.readableBytes();
        int i2 = this.chunkPosition;
        int i3 = readableBytes - i2;
        if (i3 == 0) {
            this.chunkPosition = 0;
            return Unpooled.EMPTY_BUFFER;
        }
        if (i3 < i) {
            i = i3;
        }
        ByteBuf retainedSlice = this.byteBuf.retainedSlice(i2, i);
        this.chunkPosition += i;
        return retainedSlice;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean renameTo(File file) throws IOException {
        int i;
        Objects.requireNonNull(file, "dest");
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf == null) {
            if (file.createNewFile()) {
                return true;
            }
            throw new IOException("file exists already: " + file);
        }
        int readableBytes = byteBuf.readableBytes();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileChannel channel = fileOutputStream.getChannel();
        if (this.byteBuf.nioBufferCount() == 1) {
            ByteBuffer nioBuffer = this.byteBuf.nioBuffer();
            i = 0;
            while (i < readableBytes) {
                i += channel.write(nioBuffer);
            }
        } else {
            ByteBuffer[] nioBuffers = this.byteBuf.nioBuffers();
            i = 0;
            while (i < readableBytes) {
                i = (int) (i + channel.write(nioBuffers));
            }
        }
        channel.force(false);
        channel.close();
        fileOutputStream.close();
        return i == readableBytes;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public File getFile() throws IOException {
        throw new IOException("Not represented by a file");
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData touch() {
        return touch((Object) null);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public HttpData touch(Object obj) {
        ByteBuf byteBuf = this.byteBuf;
        if (byteBuf != null) {
            byteBuf.touch(obj);
        }
        return this;
    }
}
