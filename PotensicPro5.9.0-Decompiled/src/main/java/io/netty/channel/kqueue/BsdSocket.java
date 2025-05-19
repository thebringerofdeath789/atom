package io.netty.channel.kqueue;

import io.netty.channel.DefaultFileRegion;
import io.netty.channel.unix.Errors;
import io.netty.channel.unix.PeerCredentials;
import io.netty.channel.unix.Socket;
import io.netty.util.internal.ThrowableUtil;
import java.io.IOException;
import java.nio.channels.ClosedChannelException;

/* loaded from: classes3.dex */
final class BsdSocket extends Socket {
    private static final int APPLE_SND_LOW_AT_MAX = 131072;
    private static final int FREEBSD_SND_LOW_AT_MAX = 32768;
    private static final ClosedChannelException SENDFILE_CLOSED_CHANNEL_EXCEPTION = (ClosedChannelException) ThrowableUtil.unknownStackTrace(new ClosedChannelException(), Native.class, "sendfile(..)");
    static final int BSD_SND_LOW_AT_MAX = Math.min(131072, 32768);
    private static final Errors.NativeIoException SENDFILE_CONNECTION_RESET_EXCEPTION = Errors.newConnectionResetException("syscall:sendfile", Errors.ERRNO_EPIPE_NEGATIVE);

    private static native String[] getAcceptFilter(int i) throws IOException;

    private static native PeerCredentials getPeerCredentials(int i) throws IOException;

    private static native int getSndLowAt(int i) throws IOException;

    private static native int getTcpNoPush(int i) throws IOException;

    private static native long sendFile(int i, DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException;

    private static native void setAcceptFilter(int i, String str, String str2) throws IOException;

    private static native void setSndLowAt(int i, int i2) throws IOException;

    private static native void setTcpNoPush(int i, int i2) throws IOException;

    BsdSocket(int i) {
        super(i);
    }

    void setAcceptFilter(AcceptFilter acceptFilter) throws IOException {
        setAcceptFilter(intValue(), acceptFilter.filterName(), acceptFilter.filterArgs());
    }

    void setTcpNoPush(boolean z) throws IOException {
        setTcpNoPush(intValue(), z ? 1 : 0);
    }

    void setSndLowAt(int i) throws IOException {
        setSndLowAt(intValue(), i);
    }

    boolean isTcpNoPush() throws IOException {
        return getTcpNoPush(intValue()) != 0;
    }

    int getSndLowAt() throws IOException {
        return getSndLowAt(intValue());
    }

    AcceptFilter getAcceptFilter() throws IOException {
        String[] acceptFilter = getAcceptFilter(intValue());
        return acceptFilter == null ? AcceptFilter.PLATFORM_UNSUPPORTED : new AcceptFilter(acceptFilter[0], acceptFilter[1]);
    }

    PeerCredentials getPeerCredentials() throws IOException {
        return getPeerCredentials(intValue());
    }

    long sendFile(DefaultFileRegion defaultFileRegion, long j, long j2, long j3) throws IOException {
        defaultFileRegion.open();
        long sendFile = sendFile(intValue(), defaultFileRegion, j, j2, j3);
        return sendFile >= 0 ? sendFile : Errors.ioResult("sendfile", (int) sendFile, SENDFILE_CONNECTION_RESET_EXCEPTION, SENDFILE_CLOSED_CHANNEL_EXCEPTION);
    }

    public static BsdSocket newSocketStream() {
        return new BsdSocket(newSocketStream0());
    }

    public static BsdSocket newSocketDgram() {
        return new BsdSocket(newSocketDgram0());
    }

    public static BsdSocket newSocketDomain() {
        return new BsdSocket(newSocketDomain0());
    }
}
