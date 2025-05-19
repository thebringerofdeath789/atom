package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public abstract class AbstractDnsOptPseudoRrRecord extends AbstractDnsRecord implements DnsOptPseudoRecord {
    private static long packIntoLong(int i, int i2) {
        return (((i & 255) << 24) | ((i2 & 255) << 16) | 0 | 0) & 4294967295L;
    }

    protected AbstractDnsOptPseudoRrRecord(int i, int i2, int i3) {
        super("", DnsRecordType.OPT, i, packIntoLong(i2, i3));
    }

    protected AbstractDnsOptPseudoRrRecord(int i) {
        super("", DnsRecordType.OPT, i, 0L);
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int extendedRcode() {
        return (short) ((((int) timeToLive()) >> 24) & 255);
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int version() {
        return (short) ((((int) timeToLive()) >> 16) & 255);
    }

    @Override // io.netty.handler.codec.dns.DnsOptPseudoRecord
    public int flags() {
        return (short) (((short) timeToLive()) & 255);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        return toStringBuilder().toString();
    }

    final StringBuilder toStringBuilder() {
        return new StringBuilder(64).append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM).append("OPT flags:").append(flags()).append(" version:").append(version()).append(" extendedRecode:").append(extendedRcode()).append(" udp:").append(dnsClass()).append(PropertyUtils.MAPPED_DELIM2);
    }
}
