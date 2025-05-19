package io.netty.handler.codec.http2;

/* loaded from: classes3.dex */
public interface StreamByteDistributor {

    public interface StreamState {
        boolean hasFrame();

        int pendingBytes();

        Http2Stream stream();

        int windowSize();
    }

    public interface Writer {
        void write(Http2Stream http2Stream, int i);
    }

    boolean distribute(int i, Writer writer) throws Http2Exception;

    void updateDependencyTree(int i, int i2, short s, boolean z);

    void updateStreamableBytes(StreamState streamState);
}
