package io.netty.handler.ipfilter;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import java.net.InetSocketAddress;
import java.util.Objects;

@ChannelHandler.Sharable
/* loaded from: classes.dex */
public class RuleBasedIpFilter extends AbstractRemoteAddressFilter<InetSocketAddress> {
    private final IpFilterRule[] rules;

    public RuleBasedIpFilter(IpFilterRule... ipFilterRuleArr) {
        Objects.requireNonNull(ipFilterRuleArr, "rules");
        this.rules = ipFilterRuleArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.ipfilter.AbstractRemoteAddressFilter
    public boolean accept(ChannelHandlerContext channelHandlerContext, InetSocketAddress inetSocketAddress) throws Exception {
        IpFilterRule ipFilterRule;
        IpFilterRule[] ipFilterRuleArr = this.rules;
        int length = ipFilterRuleArr.length;
        for (int i = 0; i < length && (ipFilterRule = ipFilterRuleArr[i]) != null; i++) {
            if (ipFilterRule.matches(inetSocketAddress)) {
                return ipFilterRule.ruleType() == IpFilterRuleType.ACCEPT;
            }
        }
        return true;
    }
}
