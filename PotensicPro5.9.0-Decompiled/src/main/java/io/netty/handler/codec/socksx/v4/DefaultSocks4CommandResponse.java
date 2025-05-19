package io.netty.handler.codec.socksx.v4;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.NetUtil;
import io.netty.util.internal.StringUtil;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public class DefaultSocks4CommandResponse extends AbstractSocks4Message implements Socks4CommandResponse {
    private final String dstAddr;
    private final int dstPort;
    private final Socks4CommandStatus status;

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus) {
        this(socks4CommandStatus, null, 0);
    }

    public DefaultSocks4CommandResponse(Socks4CommandStatus socks4CommandStatus, String str, int i) {
        Objects.requireNonNull(socks4CommandStatus, "cmdStatus");
        if (str != null && !NetUtil.isValidIpV4Address(str)) {
            throw new IllegalArgumentException("dstAddr: " + str + " (expected: a valid IPv4 address)");
        }
        if (i < 0 || i > 65535) {
            throw new IllegalArgumentException("dstPort: " + i + " (expected: 0~65535)");
        }
        this.status = socks4CommandStatus;
        this.dstAddr = str;
        this.dstPort = i;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public Socks4CommandStatus status() {
        return this.status;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public String dstAddr() {
        return this.dstAddr;
    }

    @Override // io.netty.handler.codec.socksx.v4.Socks4CommandResponse
    public int dstPort() {
        return this.dstPort;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(96);
        sb.append(StringUtil.simpleClassName(this));
        DecoderResult decoderResult = decoderResult();
        if (!decoderResult.isSuccess()) {
            sb.append("(decoderResult: ");
            sb.append(decoderResult);
            sb.append(", dstAddr: ");
        } else {
            sb.append("(dstAddr: ");
        }
        sb.append(dstAddr());
        sb.append(", dstPort: ");
        sb.append(dstPort());
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
