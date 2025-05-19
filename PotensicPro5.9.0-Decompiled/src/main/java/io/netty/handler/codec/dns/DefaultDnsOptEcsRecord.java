package io.netty.handler.codec.dns;

import io.netty.channel.socket.InternetProtocolFamily;
import java.util.Arrays;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public final class DefaultDnsOptEcsRecord extends AbstractDnsOptPseudoRrRecord implements DnsOptEcsRecord {
    private final byte[] address;
    private final int srcPrefixLength;

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public int scopePrefixLength() {
        return 0;
    }

    public DefaultDnsOptEcsRecord(int i, int i2, int i3, int i4, byte[] bArr) {
        super(i, i2, i3);
        this.srcPrefixLength = i4;
        this.address = (byte[]) verifyAddress(bArr).clone();
    }

    public DefaultDnsOptEcsRecord(int i, int i2, byte[] bArr) {
        this(i, 0, 0, i2, bArr);
    }

    public DefaultDnsOptEcsRecord(int i, InternetProtocolFamily internetProtocolFamily) {
        this(i, 0, 0, 0, internetProtocolFamily.localhost().getAddress());
    }

    private static byte[] verifyAddress(byte[] bArr) {
        if (bArr.length == 4 || bArr.length == 16) {
            return bArr;
        }
        throw new IllegalArgumentException("bytes.length must either 4 or 16");
    }

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public int sourcePrefixLength() {
        return this.srcPrefixLength;
    }

    @Override // io.netty.handler.codec.dns.DnsOptEcsRecord
    public byte[] address() {
        return (byte[]) this.address.clone();
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsOptPseudoRrRecord, io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder stringBuilder = toStringBuilder();
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.append(" address:").append(Arrays.toString(this.address)).append(" sourcePrefixLength:").append(sourcePrefixLength()).append(" scopePrefixLength:").append(scopePrefixLength()).append(PropertyUtils.MAPPED_DELIM2).toString();
    }
}
