package io.netty.channel.embedded;

import java.net.SocketAddress;

/* loaded from: classes3.dex */
final class EmbeddedSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 1400788804624980619L;

    public String toString() {
        return "embedded";
    }

    EmbeddedSocketAddress() {
    }
}
