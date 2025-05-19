package com.ipotensic.potensicpro.utils;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.ipotensic.baselib.DDLog;
import com.logan.flight.FlightConfig;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import org.apache.poi.hssf.record.PaletteRecord;
import org.apache.poi.ss.formula.ptg.MemFuncPtg;

/* loaded from: classes2.dex */
public class RtspDecoder {
    private ByteBuffer[] inputBuffers;
    private ByteBuffer[] outputBuffers;
    private int state;
    private Surface surface;
    private MediaCodec video_decoder;
    private BlockingQueue<byte[]> video_data_Queue = new ArrayBlockingQueue(10000);
    private BlockingQueue<byte[]> audio_data_Queue = new ArrayBlockingQueue(10000);
    private boolean isReady = false;
    private int fps = 0;
    private MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
    private int frameCount = 0;
    private long deltaTime = 0;
    private long counterTime = System.currentTimeMillis();
    private boolean isRuning = false;

    static /* synthetic */ int access$808(RtspDecoder rtspDecoder) {
        int i = rtspDecoder.frameCount;
        rtspDecoder.frameCount = i + 1;
        return i;
    }

    public RtspDecoder(Surface surface, int i) {
        this.state = 0;
        this.surface = surface;
        this.state = i;
    }

    public void stopRunning() {
        this.video_data_Queue.clear();
        this.audio_data_Queue.clear();
    }

    public void setVideoData(byte[] bArr) {
        try {
            this.video_data_Queue.put(bArr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setAudioData(byte[] bArr) {
        try {
            this.audio_data_Queue.put(bArr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getFPS() {
        return this.fps;
    }

    public void initial(byte[] bArr) throws IOException {
        byte[] bArr2 = {0, 0, 0, 1, 103, 100, 64, MemFuncPtg.sid, -84, 44, FlightConfig.P1_SELF_B, 10, 2, -1, -107};
        for (int i = 0; i < bArr.length && bArr2[i] == bArr[i]; i++) {
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, 1920, 1088);
        byte[] bArr3 = {0, 0, 0, 1, 103, 100, 64, MemFuncPtg.sid, -84, 44, FlightConfig.P1_SELF_B, 5, 0, 91, -112};
        byte[] bArr4 = {0, 0, 0, 1, 104, -18, PaletteRecord.STANDARD_PALETTE_SIZE, Byte.MIN_VALUE};
        createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr3));
        createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr4));
        MediaCodec mediaCodec = this.video_decoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.video_decoder.release();
            this.video_decoder = null;
        }
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(MimeTypes.VIDEO_H264);
        this.video_decoder = createDecoderByType;
        if (createDecoderByType == null) {
            return;
        }
        createDecoderByType.configure(createVideoFormat, this.surface, (MediaCrypto) null, 0);
        this.video_decoder.start();
        this.inputBuffers = this.video_decoder.getInputBuffers();
        this.outputBuffers = this.video_decoder.getOutputBuffers();
        this.frameCount = 0;
        this.deltaTime = 0L;
        this.isRuning = true;
        runDecodeVideoThread();
    }

    private void runDecodeVideoThread() {
        new Thread() { // from class: com.ipotensic.potensicpro.utils.RtspDecoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (RtspDecoder.this.isRuning) {
                    try {
                        int dequeueInputBuffer = RtspDecoder.this.video_decoder.dequeueInputBuffer(-1L);
                        if (dequeueInputBuffer >= 0) {
                            try {
                                ByteBuffer byteBuffer = RtspDecoder.this.inputBuffers[dequeueInputBuffer];
                                byteBuffer.clear();
                                if (!RtspDecoder.this.video_data_Queue.isEmpty()) {
                                    byte[] bArr = (byte[]) RtspDecoder.this.video_data_Queue.take();
                                    byteBuffer.put(bArr);
                                    if (RtspDecoder.this.state == 0) {
                                        RtspDecoder.this.video_decoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 66L, 0);
                                    } else {
                                        RtspDecoder.this.video_decoder.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, 33L, 0);
                                    }
                                } else if (RtspDecoder.this.state == 0) {
                                    RtspDecoder.this.video_decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 66L, 0);
                                } else {
                                    RtspDecoder.this.video_decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 33L, 0);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            RtspDecoder.this.video_decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        }
                        int dequeueOutputBuffer = RtspDecoder.this.video_decoder.dequeueOutputBuffer(RtspDecoder.this.info, 0L);
                        if (dequeueOutputBuffer == -3) {
                            RtspDecoder rtspDecoder = RtspDecoder.this;
                            rtspDecoder.outputBuffers = rtspDecoder.video_decoder.getOutputBuffers();
                        } else if (dequeueOutputBuffer == -2) {
                            RtspDecoder.this.isReady = true;
                        } else if (dequeueOutputBuffer != -1) {
                            RtspDecoder.this.video_decoder.releaseOutputBuffer(dequeueOutputBuffer, true);
                            RtspDecoder.access$808(RtspDecoder.this);
                            if (RtspDecoder.this.counterTime > System.currentTimeMillis()) {
                                RtspDecoder.this.counterTime = 0L;
                            }
                            RtspDecoder.this.deltaTime = System.currentTimeMillis() - RtspDecoder.this.counterTime;
                            if (RtspDecoder.this.deltaTime > 1000) {
                                RtspDecoder.this.fps = (int) ((r0.frameCount / RtspDecoder.this.deltaTime) * 1000.0f);
                                RtspDecoder.this.counterTime = System.currentTimeMillis();
                                RtspDecoder.this.frameCount = 0;
                            }
                        }
                        if ((RtspDecoder.this.info.flags & 4) != 0) {
                            DDLog.e("BUFFER_FLAG_END_OF_STREAM");
                        }
                    } catch (Exception unused) {
                        return;
                    }
                }
            }
        }.start();
    }
}
