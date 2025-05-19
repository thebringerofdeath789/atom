package io.netty.handler.codec.dns;

import io.netty.buffer.ByteBuf;

/* loaded from: classes.dex */
public interface DnsRecordEncoder {
    public static final DnsRecordEncoder DEFAULT = new DefaultDnsRecordEncoder();

    void encodeQuestion(DnsQuestion dnsQuestion, ByteBuf byteBuf) throws Exception;

    void encodeRecord(DnsRecord dnsRecord, ByteBuf byteBuf) throws Exception;
}
