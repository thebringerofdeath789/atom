package io.netty.handler.codec.serialization;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.StreamCorruptedException;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class ObjectDecoderInputStream extends InputStream implements ObjectInput {
    private final ClassResolver classResolver;
    private final DataInputStream in;
    private final int maxObjectSize;

    public ObjectDecoderInputStream(InputStream inputStream) {
        this(inputStream, (ClassLoader) null);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader) {
        this(inputStream, classLoader, 1048576);
    }

    public ObjectDecoderInputStream(InputStream inputStream, int i) {
        this(inputStream, null, i);
    }

    public ObjectDecoderInputStream(InputStream inputStream, ClassLoader classLoader, int i) {
        Objects.requireNonNull(inputStream, "in");
        if (i <= 0) {
            throw new IllegalArgumentException("maxObjectSize: " + i);
        }
        if (inputStream instanceof DataInputStream) {
            this.in = (DataInputStream) inputStream;
        } else {
            this.in = new DataInputStream(inputStream);
        }
        this.classResolver = ClassResolvers.weakCachingResolver(classLoader);
        this.maxObjectSize = i;
    }

    @Override // java.io.ObjectInput
    public Object readObject() throws ClassNotFoundException, IOException {
        int readInt = readInt();
        if (readInt <= 0) {
            throw new StreamCorruptedException("invalid data length: " + readInt);
        }
        if (readInt > this.maxObjectSize) {
            throw new StreamCorruptedException("data length too big: " + readInt + " (max: " + this.maxObjectSize + PropertyUtils.MAPPED_DELIM2);
        }
        return new CompactObjectInputStream(this.in, this.classResolver).readObject();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int available() throws IOException {
        return this.in.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectInput
    public void close() throws IOException {
        this.in.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.in.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.in.markSupported();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public int read() throws IOException {
        return this.in.read();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        return this.in.read(bArr, i, i2);
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public final int read(byte[] bArr) throws IOException {
        return this.in.read(bArr);
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() throws IOException {
        return this.in.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        return this.in.readByte();
    }

    @Override // java.io.DataInput
    public final char readChar() throws IOException {
        return this.in.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() throws IOException {
        return this.in.readDouble();
    }

    @Override // java.io.DataInput
    public final float readFloat() throws IOException {
        return this.in.readFloat();
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i2) throws IOException {
        this.in.readFully(bArr, i, i2);
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.in.readFully(bArr);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        return this.in.readInt();
    }

    @Override // java.io.DataInput
    @Deprecated
    public final String readLine() throws IOException {
        return this.in.readLine();
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        return this.in.readLong();
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        return this.in.readShort();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() throws IOException {
        return this.in.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        return this.in.readUnsignedShort();
    }

    @Override // java.io.DataInput
    public final String readUTF() throws IOException {
        return this.in.readUTF();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.in.reset();
    }

    @Override // java.io.InputStream, java.io.ObjectInput
    public long skip(long j) throws IOException {
        return this.in.skip(j);
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) throws IOException {
        return this.in.skipBytes(i);
    }
}
