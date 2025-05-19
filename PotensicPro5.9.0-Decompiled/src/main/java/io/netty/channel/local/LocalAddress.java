package io.netty.channel.local;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.netty.channel.Channel;
import java.net.SocketAddress;
import java.util.Objects;
import org.apache.xmlbeans.impl.common.NameUtil;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public final class LocalAddress extends SocketAddress implements Comparable<LocalAddress> {
    public static final LocalAddress ANY = new LocalAddress("ANY");
    private static final long serialVersionUID = 4644331421130916435L;
    private final String id;
    private final String strVal;

    LocalAddress(Channel channel) {
        StringBuilder sb = new StringBuilder(16);
        sb.append("local:E");
        sb.append(Long.toHexString((channel.hashCode() & 4294967295L) | IjkMediaMeta.AV_CH_WIDE_RIGHT));
        sb.setCharAt(7, NameUtil.COLON);
        this.id = sb.substring(6);
        this.strVal = sb.toString();
    }

    public LocalAddress(String str) {
        Objects.requireNonNull(str, TtmlNode.ATTR_ID);
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.isEmpty()) {
            throw new IllegalArgumentException("empty id");
        }
        this.id = lowerCase;
        this.strVal = "local:" + lowerCase;
    }

    public String id() {
        return this.id;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof LocalAddress) {
            return this.id.equals(((LocalAddress) obj).id);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        return this.id.compareTo(localAddress.id);
    }

    public String toString() {
        return this.strVal;
    }
}
