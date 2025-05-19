package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public class DefaultDnsRawRecord extends AbstractDnsRecord implements DnsRawRecord {
    private final ByteBuf content;

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, long j, ByteBuf byteBuf) {
        this(str, dnsRecordType, 1, j, byteBuf);
    }

    public DefaultDnsRawRecord(String str, DnsRecordType dnsRecordType, int i, long j, ByteBuf byteBuf) {
        super(str, dnsRecordType, i, j);
        this.content = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "content");
    }

    @Override // io.netty.buffer.ByteBufHolder
    public ByteBuf content() {
        return this.content;
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord copy() {
        return replace(content().copy());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord duplicate() {
        return replace(content().duplicate());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord retainedDuplicate() {
        return replace(content().retainedDuplicate());
    }

    @Override // io.netty.buffer.ByteBufHolder
    public DnsRawRecord replace(ByteBuf byteBuf) {
        return new DefaultDnsRawRecord(name(), type(), dnsClass(), timeToLive(), byteBuf);
    }

    @Override // io.netty.util.ReferenceCounted
    public int refCnt() {
        return content().refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain() {
        content().retain();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord retain(int i) {
        content().retain(i);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return content().release();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i) {
        return content().release(i);
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch() {
        content().touch();
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public DnsRawRecord touch(Object obj) {
        content().touch(obj);
        return this;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder append = new StringBuilder(64).append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM);
        DnsRecordType type = type();
        if (type != DnsRecordType.OPT) {
            append.append(name().isEmpty() ? "<root>" : name()).append(' ').append(timeToLive()).append(' ');
            DnsMessageUtil.appendRecordClass(append, dnsClass()).append(' ').append(type.name());
        } else {
            append.append("OPT flags:").append(timeToLive()).append(" udp:").append(dnsClass());
        }
        append.append(' ').append(content().readableBytes()).append("B)");
        return append.toString();
    }
}
