package io.netty.handler.codec.dns;

/* loaded from: classes.dex */
public interface DnsOptEcsRecord extends DnsOptPseudoRecord {
    byte[] address();

    int scopePrefixLength();

    int sourcePrefixLength();
}
