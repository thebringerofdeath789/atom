package io.netty.channel.unix;

import io.netty.util.internal.EmptyArrays;
import org.apache.commons.beanutils.PropertyUtils;

/* loaded from: classes3.dex */
public final class PeerCredentials {
    private final int[] gids;
    private final int pid;
    private final int uid;

    PeerCredentials(int i, int i2, int... iArr) {
        this.pid = i;
        this.uid = i2;
        this.gids = iArr == null ? EmptyArrays.EMPTY_INTS : iArr;
    }

    public int pid() {
        return this.pid;
    }

    public int uid() {
        return this.uid;
    }

    public int[] gids() {
        return (int[]) this.gids.clone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("UserCredentials[pid=").append(this.pid).append("; uid=").append(this.uid).append("; gids=[");
        int[] iArr = this.gids;
        if (iArr.length > 0) {
            sb.append(iArr[0]);
            for (int i = 1; i < this.gids.length; i++) {
                sb.append(", ").append(this.gids[i]);
            }
        }
        sb.append(PropertyUtils.INDEXED_DELIM2);
        return sb.toString();
    }
}
