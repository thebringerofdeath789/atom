package io.netty.handler.codec.dns;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public class DefaultDnsPtrRecord extends AbstractDnsRecord implements DnsPtrRecord {
    private final String hostname;

    public DefaultDnsPtrRecord(String str, int i, long j, String str2) {
        super(str, DnsRecordType.PTR, i, j);
        this.hostname = (String) ObjectUtil.checkNotNull(str2, "hostname");
    }

    @Override // io.netty.handler.codec.dns.DnsPtrRecord
    public String hostname() {
        return this.hostname;
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder append = new StringBuilder(64).append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM);
        DnsRecordType type = type();
        append.append(name().isEmpty() ? "<root>" : name()).append(' ').append(timeToLive()).append(' ');
        DnsMessageUtil.appendRecordClass(append, dnsClass()).append(' ').append(type.name());
        append.append(' ').append(this.hostname);
        return append.toString();
    }
}
