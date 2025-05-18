package com.logan.h265;

import android.graphics.Rect;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.logan.nativeapp.DDLog;
import com.logan.nativeapp.I420;
import com.logan.nativeapp.OnYuvCallback;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H265SyncHardDecoder {
    private MediaCodec decoder;
    private int height;
    private ByteBuffer[] inputBuffers;
    private OnYuvCallback onYuvCallback;
    private ByteBuffer[] outputBuffers;
    private int width;
    private final String TAG = getClass().getSimpleName();
    private final String HEVC_FORMAT = MimeTypes.VIDEO_H265;
    private boolean isInit = false;
    private ConcurrentLinkedQueue<byte[]> framesData = new ConcurrentLinkedQueue<>();

    public void init(final int i, final int i2, byte[] bArr, OnYuvCallback onYuvCallback) {
        try {
            this.onYuvCallback = onYuvCallback;
            this.width = i;
            this.height = i2;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(MimeTypes.VIDEO_H265);
            this.decoder = createDecoderByType;
            createDecoderByType.setCallback(new MediaCodec.Callback() { // from class: com.logan.h265.H265SyncHardDecoder.1
                @Override // android.media.MediaCodec.Callback
                public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                }

                @Override // android.media.MediaCodec.Callback
                public void onInputBufferAvailable(MediaCodec mediaCodec, int i3) {
                    ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i3);
                    DDLog.m1725e(H265SyncHardDecoder.this.TAG, "input buffer");
                    if (H265SyncHardDecoder.this.framesData.size() > 0) {
                        byte[] bArr2 = (byte[]) H265SyncHardDecoder.this.framesData.poll();
                        inputBuffer.clear();
                        inputBuffer.put(bArr2);
                        mediaCodec.queueInputBuffer(i3, 0, bArr2.length, 0L, 0);
                    }
                }

                @Override // android.media.MediaCodec.Callback
                public void onOutputBufferAvailable(MediaCodec mediaCodec, int i3, MediaCodec.BufferInfo bufferInfo) {
                    ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i3);
                    mediaCodec.getOutputFormat(i3);
                    byte[] bArr2 = new byte[bufferInfo.size];
                    outputBuffer.get(bArr2);
                    I420 i420 = new I420(bArr2, i, i2);
                    if (H265SyncHardDecoder.this.onYuvCallback != null) {
                        H265SyncHardDecoder.this.onYuvCallback.callback(i420);
                    }
                    mediaCodec.releaseOutputBuffer(i3, true);
                }
            });
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H265, i, i2);
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
            this.decoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 0);
            this.decoder.start();
            this.inputBuffers = this.decoder.getInputBuffers();
            this.outputBuffers = this.decoder.getOutputBuffers();
            this.isInit = true;
        } catch (Exception e) {
            Log.e(this.TAG, "初始化失败 :" + e.getMessage());
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void decode(byte[] bArr, OnYuvCallback onYuvCallback) {
        this.framesData.offer(bArr);
    }

    public void release() {
        try {
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.decoder.release();
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.decoder = null;
            throw th;
        }
        this.decoder = null;
    }

    private I420 getI420FromImage(Image image) {
        Rect rect;
        int i;
        int i2;
        if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        I420 i420 = new I420(width, height);
        int i3 = 0;
        byte[] bArr = new byte[planes[0].getRowStride()];
        Log.v(this.TAG, "get data from " + planes.length + " planes");
        int i4 = 0;
        while (i4 < planes.length) {
            ByteBuffer buffer = planes[i4].getBuffer();
            int rowStride = planes[i4].getRowStride();
            int pixelStride = planes[i4].getPixelStride();
            Log.v(this.TAG, "pixelStride " + pixelStride);
            Log.v(this.TAG, "rowStride " + rowStride);
            Log.v(this.TAG, "width " + width);
            Log.v(this.TAG, "height " + height);
            Log.v(this.TAG, "buffer size " + buffer.remaining());
            int i5 = i4 == 0 ? i3 : 1;
            int i6 = width >> i5;
            int i7 = height >> i5;
            buffer.position(((cropRect.top >> i5) * rowStride) + ((cropRect.left >> i5) * pixelStride));
            int i8 = 0;
            int i9 = 0;
            while (i8 < i7) {
                if (pixelStride == 1) {
                    buffer.get(i420.f2550Y, i9, i6);
                    i9 += i6;
                    rect = cropRect;
                    i2 = width;
                    i = i6;
                } else {
                    rect = cropRect;
                    i = ((i6 - 1) * pixelStride) + 1;
                    int i10 = 0;
                    buffer.get(bArr, 0, i);
                    while (true) {
                        i2 = width;
                        if (i10 >= i6) {
                            break;
                        }
                        if (i4 == 1) {
                            i420.f2548U[i9] = bArr[i10 * pixelStride];
                        } else {
                            i420.f2549V[i9] = bArr[i10 * pixelStride];
                        }
                        i9++;
                        i10++;
                        width = i2;
                    }
                }
                if (i8 < i7 - 1) {
                    buffer.position((buffer.position() + rowStride) - i);
                }
                i8++;
                cropRect = rect;
                width = i2;
            }
            Log.v(this.TAG, "Finished reading data from plane " + i4);
            i4++;
            cropRect = cropRect;
            width = width;
            i3 = 0;
        }
        return i420;
    }

    private boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }
}