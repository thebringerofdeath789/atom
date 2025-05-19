package io.netty.handler.codec.dns;

import io.netty.channel.AddressedEnvelope;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes.dex */
final class DnsMessageUtil {
    static StringBuilder appendQuery(StringBuilder sb, DnsQuery dnsQuery) {
        appendQueryHeader(sb, dnsQuery);
        appendAllRecords(sb, dnsQuery);
        return sb;
    }

    static StringBuilder appendResponse(StringBuilder sb, DnsResponse dnsResponse) {
        appendResponseHeader(sb, dnsResponse);
        appendAllRecords(sb, dnsResponse);
        return sb;
    }

    static StringBuilder appendRecordClass(StringBuilder sb, int i) {
        int i2 = i & 65535;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 254 ? i2 != 255 ? null : "ANY" : "NONE" : "HESIOD" : "CHAOS" : "CSNET" : "IN";
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("UNKNOWN(").append(i2).append(PropertyUtils.MAPPED_DELIM2);
        }
        return sb;
    }

    private static void appendQueryHeader(StringBuilder sb, DnsQuery dnsQuery) {
        sb.append(StringUtil.simpleClassName(dnsQuery)).append(PropertyUtils.MAPPED_DELIM);
        appendAddresses(sb, dnsQuery).append(dnsQuery.id()).append(", ").append(dnsQuery.opCode());
        if (dnsQuery.isRecursionDesired()) {
            sb.append(", RD");
        }
        if (dnsQuery.z() != 0) {
            sb.append(", Z: ").append(dnsQuery.z());
        }
        sb.append(PropertyUtils.MAPPED_DELIM2);
    }

    private static void appendResponseHeader(StringBuilder sb, DnsResponse dnsResponse) {
        boolean z;
        sb.append(StringUtil.simpleClassName(dnsResponse)).append(PropertyUtils.MAPPED_DELIM);
        appendAddresses(sb, dnsResponse).append(dnsResponse.id()).append(", ").append(dnsResponse.opCode()).append(", ").append(dnsResponse.code()).append(',');
        boolean z2 = false;
        if (dnsResponse.isRecursionDesired()) {
            sb.append(" RD");
            z = false;
        } else {
            z = true;
        }
        if (dnsResponse.isAuthoritativeAnswer()) {
            sb.append(" AA");
            z = false;
        }
        if (dnsResponse.isTruncated()) {
            sb.append(" TC");
            z = false;
        }
        if (dnsResponse.isRecursionAvailable()) {
            sb.append(" RA");
        } else {
            z2 = z;
        }
        if (dnsResponse.z() != 0) {
            if (!z2) {
                sb.append(',');
            }
            sb.append(" Z: ").append(dnsResponse.z());
        }
        if (z2) {
            sb.setCharAt(sb.length() - 1, PropertyUtils.MAPPED_DELIM2);
        } else {
            sb.append(PropertyUtils.MAPPED_DELIM2);
        }
    }

    private static StringBuilder appendAddresses(StringBuilder sb, DnsMessage dnsMessage) {
        if (!(dnsMessage instanceof AddressedEnvelope)) {
            return sb;
        }
        AddressedEnvelope addressedEnvelope = (AddressedEnvelope) dnsMessage;
        SocketAddress sender = addressedEnvelope.sender();
        if (sender != null) {
            sb.append("from: ").append(sender).append(", ");
        }
        SocketAddress recipient = addressedEnvelope.recipient();
        if (recipient != null) {
            sb.append("to: ").append(recipient).append(", ");
        }
        return sb;
    }

    private static void appendAllRecords(StringBuilder sb, DnsMessage dnsMessage) {
        appendRecords(sb, dnsMessage, DnsSection.QUESTION);
        appendRecords(sb, dnsMessage, DnsSection.ANSWER);
        appendRecords(sb, dnsMessage, DnsSection.AUTHORITY);
        appendRecords(sb, dnsMessage, DnsSection.ADDITIONAL);
    }

    private static void appendRecords(StringBuilder sb, DnsMessage dnsMessage, DnsSection dnsSection) {
        int count = dnsMessage.count(dnsSection);
        for (int i = 0; i < count; i++) {
            sb.append(StringUtil.NEWLINE).append('\t').append(dnsMessage.recordAt(dnsSection, i));
        }
    }

    private DnsMessageUtil() {
    }
}
