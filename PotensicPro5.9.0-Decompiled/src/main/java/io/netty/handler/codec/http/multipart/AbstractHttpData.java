package io.netty.handler.codec.http.multipart;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.util.AbstractReferenceCounted;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public abstract class AbstractHttpData extends AbstractReferenceCounted implements HttpData {
    private boolean completed;
    protected long definedSize;
    private final String name;
    protected long size;
    private static final Pattern STRIP_PATTERN = Pattern.compile("(?:^\\s+|\\s+$|\\n)");
    private static final Pattern REPLACE_PATTERN = Pattern.compile("[\\r\\t]");
    private Charset charset = HttpConstants.DEFAULT_CHARSET;
    private long maxSize = -1;

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public abstract HttpData touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract HttpData touch(Object obj);

    protected AbstractHttpData(String str, Charset charset, long j) {
        Objects.requireNonNull(str, "name");
        String replaceAll = STRIP_PATTERN.matcher(REPLACE_PATTERN.matcher(str).replaceAll(StringUtils.SPACE)).replaceAll("");
        if (replaceAll.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        this.name = replaceAll;
        if (charset != null) {
            setCharset(charset);
        }
        this.definedSize = j;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setMaxSize(long j) {
        this.maxSize = j;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void checkSize(long j) throws IOException {
        long j2 = this.maxSize;
        if (j2 >= 0 && j > j2) {
            throw new IOException("Size exceed allowed maximum capacity");
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public String getName() {
        return this.name;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public boolean isCompleted() {
        return this.completed;
    }

    protected void setCompleted() {
        this.completed = true;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public Charset getCharset() {
        return this.charset;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public void setCharset(Charset charset) {
        Objects.requireNonNull(charset, "charset");
        this.charset = charset;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long length() {
        return this.size;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData
    public long definedLength() {
        return this.definedSize;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        try {
            return getByteBuf();
        } catch (IOException e) {
            throw new ChannelException(e);
        }
    }

    @Override // io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        delete();
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public HttpData retain(int i) {
        super.retain(i);
        return this;
    }
}
