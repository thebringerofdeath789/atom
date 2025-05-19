package com.logan.nativeapp;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class MediaCodecDecoder {
    private static final String MIME_TYPE = "video/avc";
    private static final int TIME_INTERNAL = 5;
    private int height;
    private MediaCodec mCodec;
    private Surface surface;
    private int width;
    private String TAG = "MediaCodecDecoder";
    private boolean isFirst = true;
    int mCount = 0;
    private volatile Queue<byte[]> dataQueue = new LinkedBlockingQueue();
    private byte[] lock = new byte[1];
    private boolean isRunning = false;

    public MediaCodecDecoder(Surface surface, int i, int i2) {
        this.surface = surface;
        this.width = i;
        this.height = i2;
    }

    public void startCodec() {
        if (this.isFirst) {
            initDecoder();
        }
    }

    private void initDecoder() {
        try {
            this.mCodec = MediaCodec.createDecoderByType("video/avc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.width, this.height);
        DDLog.i("width:" + createVideoFormat.getInteger("width"));
        DDLog.i("height:" + createVideoFormat.getInteger("height"));
        this.mCodec.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
        this.mCodec.start();
        this.isRunning = true;
        this.isFirst = false;
    }

    private boolean onFrame(byte[] bArr, int i, int i2) {
        ByteBuffer[] inputBuffers = this.mCodec.getInputBuffers();
        int dequeueInputBuffer = this.mCodec.dequeueInputBuffer(-1L);
        if (dequeueInputBuffer < 0) {
            return false;
        }
        ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
        byteBuffer.clear();
        byteBuffer.put(bArr, i, i2);
        this.mCodec.queueInputBuffer(dequeueInputBuffer, 0, i2, 0L, 1);
        this.mCount++;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(bufferInfo, 100L);
        while (dequeueOutputBuffer >= 0) {
            this.mCodec.releaseOutputBuffer(dequeueOutputBuffer, true);
            dequeueOutputBuffer = this.mCodec.dequeueOutputBuffer(bufferInfo, 0L);
        }
        if (dequeueOutputBuffer < 0) {
            DDLog.w("outputBufferIndex:" + dequeueOutputBuffer);
        }
        return true;
    }

    public void stopCodec() {
        try {
            this.mCodec.stop();
            this.mCodec.release();
            this.mCodec = null;
            this.isFirst = true;
            this.dataQueue.clear();
            this.isRunning = false;
        } catch (Exception e) {
            e.printStackTrace();
            this.mCodec = null;
        }
    }

    public synchronized void feedFrame(byte[] bArr) {
        onFrame(bArr, 0, bArr.length);
    }

    public boolean isRunning() {
        return this.isRunning;
    }
}
