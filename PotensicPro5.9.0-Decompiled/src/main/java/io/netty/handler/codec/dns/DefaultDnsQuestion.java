package io.netty.handler.codec.dns;

import io.netty.util.internal.StringUtil;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
public class DefaultDnsQuestion extends AbstractDnsRecord implements DnsQuestion {
    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType) {
        super(str, dnsRecordType, 0L);
    }

    public DefaultDnsQuestion(String str, DnsRecordType dnsRecordType, int i) {
        super(str, dnsRecordType, i, 0L);
    }

    @Override // io.netty.handler.codec.dns.AbstractDnsRecord
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(StringUtil.simpleClassName(this)).append(PropertyUtils.MAPPED_DELIM).append(name()).append(' ');
        DnsMessageUtil.appendRecordClass(sb, dnsClass()).append(' ').append(type().name()).append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
