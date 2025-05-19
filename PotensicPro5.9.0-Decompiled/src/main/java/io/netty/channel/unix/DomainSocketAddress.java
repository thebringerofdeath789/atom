package io.netty.channel.unix;

import java.io.File;
import java.net.SocketAddress;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class DomainSocketAddress extends SocketAddress {
    private static final long serialVersionUID = -6934618000832236893L;
    private final String socketPath;

    public DomainSocketAddress(String str) {
        Objects.requireNonNull(str, "socketPath");
        this.socketPath = str;
    }

    public DomainSocketAddress(File file) {
        this(file.getPath());
    }

    public String path() {
        return this.socketPath;
    }

    public String toString() {
        return path();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DomainSocketAddress) {
            return ((DomainSocketAddress) obj).socketPath.equals(this.socketPath);
        }
        return false;
    }

    public int hashCode() {
        return this.socketPath.hashCode();
    }
}
