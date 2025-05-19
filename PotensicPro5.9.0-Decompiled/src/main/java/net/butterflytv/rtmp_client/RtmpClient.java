package net.butterflytv.rtmp_client;

import java.io.IOException;

/* loaded from: classes4.dex */
public class RtmpClient {
    public static final int RTMP_READ_DONE = -1;
    private static final int RTMP_SUCCESS = 0;
    private static final int TIMEOUT_IN_MS = 10000;
    private long rtmpPointer = 0;
    private int sendTimeoutInMs = 10000;
    private int receiveTimeoutInMs = 10000;

    private native long nativeAlloc();

    private native void nativeClose(long j);

    private native boolean nativeIsConnected(long j);

    private native int nativeOpen(String str, boolean z, long j, int i, int i2);

    private native int nativePause(boolean z, long j) throws IllegalStateException;

    private native int nativeRead(byte[] bArr, int i, int i2, long j) throws IllegalStateException;

    private native int nativeWrite(byte[] bArr, int i, int i2, long j) throws IllegalStateException;

    static {
        System.loadLibrary("rtmp-jni");
    }

    public static class RtmpIOException extends IOException {
        public static final int CONNECTION_LOST = -14;
        public static final int DNS_NOT_REACHABLE = -6;
        public static final int HANDSHAKE_CONNECT_FAIL = -11;
        public static final int HANDSHAKE_FAIL = -12;
        public static final int NO_SSL_TLS_SUPP = -10;
        public static final int OPEN_ALLOC = -2;
        public static final int OPEN_CONNECT_STREAM = -3;
        public static final int RTMP_AMF_ENCODE_FAIL = -21;
        public static final int RTMP_CONNECT_FAIL = -13;
        public static final int RTMP_GENERIC_ERROR = -26;
        public static final int RTMP_IGNORED = -25;
        public static final int RTMP_KEYFRAME_TS_MISMATCH = -15;
        public static final int RTMP_MEM_ALLOC_FAIL = -17;
        public static final int RTMP_PACKET_TOO_SMALL = -19;
        public static final int RTMP_READ_CORRUPT_STREAM = -16;
        public static final int RTMP_SANITY_FAIL = -27;
        public static final int RTMP_SEND_PACKET_FAIL = -20;
        public static final int RTMP_STREAM_BAD_DATASIZE = -18;
        public static final int SOCKET_CONNECT_FAIL = -7;
        public static final int SOCKET_CREATE_FAIL = -9;
        public static final int SOCKS_NEGOTIATION_FAIL = -8;
        public static final int UNKNOWN_RTMP_AMF_TYPE = -5;
        public static final int UNKNOWN_RTMP_OPTION = -4;
        public static final int URL_INCORRECT_PORT = -24;
        public static final int URL_MISSING_HOSTNAME = -23;
        public static final int URL_MISSING_PROTOCOL = -22;
        public final int errorCode;

        public RtmpIOException(int i) {
            super("RTMP error: " + i);
            this.errorCode = i;
        }
    }

    public void setSendTimeout(int i) {
        if (i > 0) {
            this.sendTimeoutInMs = i;
        } else {
            this.sendTimeoutInMs = 10000;
        }
    }

    public void setReceiveTimeout(int i) {
        if (i > 0) {
            this.receiveTimeoutInMs = i;
        } else {
            this.receiveTimeoutInMs = 10000;
        }
    }

    public void open(String str, boolean z) throws RtmpIOException {
        long nativeAlloc = nativeAlloc();
        this.rtmpPointer = nativeAlloc;
        if (nativeAlloc == 0) {
            throw new RtmpIOException(-2);
        }
        int nativeOpen = nativeOpen(str, z, nativeAlloc, this.sendTimeoutInMs, this.receiveTimeoutInMs);
        if (nativeOpen == 0) {
            return;
        }
        this.rtmpPointer = 0L;
        throw new RtmpIOException(nativeOpen);
    }

    public int read(byte[] bArr, int i, int i2) throws RtmpIOException, IllegalStateException {
        int nativeRead = nativeRead(bArr, i, i2, this.rtmpPointer);
        if (nativeRead >= 0 || nativeRead == -1) {
            return nativeRead;
        }
        throw new RtmpIOException(nativeRead);
    }

    public int write(byte[] bArr) throws RtmpIOException, IllegalStateException {
        return write(bArr, 0, bArr.length);
    }

    public int write(byte[] bArr, int i, int i2) throws RtmpIOException, IllegalStateException {
        int nativeWrite = nativeWrite(bArr, i, i2, this.rtmpPointer);
        if (nativeWrite >= 0) {
            return nativeWrite;
        }
        throw new RtmpIOException(nativeWrite);
    }

    public boolean pause(boolean z) throws RtmpIOException, IllegalStateException {
        int nativePause = nativePause(z, this.rtmpPointer);
        if (nativePause == 0) {
            return true;
        }
        throw new RtmpIOException(nativePause);
    }

    public boolean isConnected() {
        return nativeIsConnected(this.rtmpPointer);
    }

    public void close() {
        nativeClose(this.rtmpPointer);
        this.rtmpPointer = 0L;
    }
}
