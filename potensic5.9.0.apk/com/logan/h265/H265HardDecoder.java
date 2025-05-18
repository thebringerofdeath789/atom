package com.logan.h265;

import android.graphics.Rect;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.logan.nativeapp.I420;
import com.logan.nativeapp.OnYuvCallback;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class H265HardDecoder {
    private MediaCodec decoder;
    private int height;
    private ByteBuffer[] inputBuffers;
    private ByteBuffer[] outputBuffers;
    private int width;
    private final String TAG = getClass().getSimpleName();
    private final String HEVC_FORMAT = MimeTypes.VIDEO_H265;
    private boolean isInit = false;

    public void init(int i, int i2, byte[] bArr) {
        try {
            this.width = i;
            this.height = i2;
            this.decoder = MediaCodec.createDecoderByType(MimeTypes.VIDEO_H265);
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
        int dequeueInputBuffer;
        do {
            try {
                dequeueInputBuffer = this.decoder.dequeueInputBuffer(1L);
            } catch (Exception e) {
                Log.e(this.TAG, "解码失败 : " + e.getMessage());
                return;
            }
        } while (dequeueInputBuffer < 0);
        ByteBuffer byteBuffer = this.inputBuffers[dequeueInputBuffer];
        byteBuffer.clear();
        int length = bArr.length;
        if (length < 0) {
            Log.d(this.TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
            this.decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        } else {
            Log.d(this.TAG, "sample size: " + length);
            byteBuffer.clear();
            byteBuffer.put(bArr);
            this.decoder.queueInputBuffer(dequeueInputBuffer, 0, length, 0L, 0);
        }
        int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(new MediaCodec.BufferInfo(), 100000L);
        if (dequeueOutputBuffer == -3) {
            Log.d(this.TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
            this.outputBuffers = this.decoder.getOutputBuffers();
            return;
        }
        if (dequeueOutputBuffer == -2) {
            Log.d(this.TAG, "New format " + this.decoder.getOutputFormat());
            return;
        }
        if (dequeueOutputBuffer == -1) {
            Log.d(this.TAG, "dequeueOutputBuffer timed out!");
            try {
                Thread.sleep(10L);
                return;
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                return;
            }
        }
        ByteBuffer byteBuffer2 = this.outputBuffers[dequeueOutputBuffer];
        I420 i420FromImage = getI420FromImage(this.decoder.getOutputImage(dequeueOutputBuffer));
        if (i420FromImage != null && onYuvCallback != null) {
            onYuvCallback.callback(i420FromImage);
        }
        Log.e(this.TAG, "decode: color format :" + this.decoder.getOutputFormat().getInteger("color-format"));
        this.decoder.releaseOutputBuffer(dequeueOutputBuffer, true);
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