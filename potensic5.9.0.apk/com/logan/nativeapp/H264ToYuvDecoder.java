package com.logan.nativeapp;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Environment;
import android.util.Log;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import com.ipotensic.baselib.netty.ParseUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class H264ToYuvDecoder {
    private static final int COLOR_FormatI420 = 1;
    private static final int COLOR_FormatNV21 = 2;
    private static volatile H264ToYuvDecoder instance;
    private MediaCodec decoder;
    private final String TAG = getClass().getSimpleName();
    private String format = MimeTypes.VIDEO_H264;
    private int width = 1280;
    private int height = 720;
    private final SpsParser spsParser = new SpsParser();

    public interface OnDecodeCallback {
        void onYuvCallback(I420 i420);
    }

    private H264ToYuvDecoder() {
    }

    public static H264ToYuvDecoder getInstance() {
        if (instance == null) {
            synchronized (H264ToYuvDecoder.class) {
                if (instance == null) {
                    H264ToYuvDecoder h264ToYuvDecoder = new H264ToYuvDecoder();
                    instance = h264ToYuvDecoder;
                    return h264ToYuvDecoder;
                }
            }
        }
        return instance;
    }

    private void init() {
        try {
            this.decoder = MediaCodec.createDecoderByType(this.format);
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.format, this.width, this.height);
            createVideoFormat.setInteger("profile", 65536);
            createVideoFormat.setInteger("low-latency", 1);
            this.decoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 0);
            this.decoder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized void decode(Frame frame, OnDecodeCallback onDecodeCallback) {
        int dequeueInputBuffer;
        DDLog.m1724e("frames555:");
        if (frame.getFrameType() == 10) {
            int length = frame.getSps().length - 4;
            byte[] bArr = new byte[length];
            System.arraycopy(frame.getData(), 4, bArr, 0, length);
            int[] videoWidthAndHeight = this.spsParser.getVideoWidthAndHeight(bArr, length);
            if (videoWidthAndHeight == null) {
                return;
            }
            if (this.decoder == null) {
                this.width = videoWidthAndHeight[0];
                this.height = videoWidthAndHeight[1];
                init();
            } else if (this.width != videoWidthAndHeight[0] || this.height != videoWidthAndHeight[1]) {
                this.width = videoWidthAndHeight[0];
                this.height = videoWidthAndHeight[1];
                release();
                init();
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        MediaCodec mediaCodec = this.decoder;
        if (mediaCodec != null) {
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            this.decoder.getOutputBuffers();
            if (!Thread.interrupted()) {
                int i = 0;
                boolean z = false;
                while (true) {
                    dequeueInputBuffer = this.decoder.dequeueInputBuffer(1L);
                    if (dequeueInputBuffer >= 0) {
                        break;
                    }
                    i++;
                    if (i % 10 == 0 && !z) {
                        this.decoder.flush();
                        DDLog.m1724e("out index flush.......");
                        z = true;
                    }
                }
                if (dequeueInputBuffer >= 0) {
                    byte[] data = frame.getData();
                    Log.e(this.TAG, "decode: " + ParseUtil.byteToHexString(data, 10));
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    int length2 = data.length;
                    if (length2 < 0) {
                        Log.d(this.TAG, "InputBuffer BUFFER_FLAG_END_OF_STREAM");
                        this.decoder.queueInputBuffer(dequeueInputBuffer, 0, 0, -1L, 1);
                        return;
                    }
                    Log.d(this.TAG, "sample size: " + length2);
                    byteBuffer.clear();
                    byteBuffer.put(data);
                    this.decoder.queueInputBuffer(dequeueInputBuffer, 0, length2, -1L, 0);
                    int dequeueOutputBuffer = this.decoder.dequeueOutputBuffer(new MediaCodec.BufferInfo(), 0L);
                    DDLog.m1724e("out index:" + dequeueOutputBuffer);
                    if (dequeueOutputBuffer == -3) {
                        Log.d(this.TAG, "INFO_OUTPUT_BUFFERS_CHANGED");
                        this.decoder.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        Log.d(this.TAG, "New format " + this.decoder.getOutputFormat());
                    } else if (dequeueOutputBuffer == -1) {
                        Log.d(this.TAG, "dequeueOutputBuffer timed out!");
                        try {
                            Thread.sleep(1L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        I420 i420FromImage = getI420FromImage(this.decoder.getOutputImage(dequeueOutputBuffer));
                        if (i420FromImage != null && onDecodeCallback != null) {
                            onDecodeCallback.onYuvCallback(i420FromImage);
                        }
                        Log.e(this.TAG, "decode3: " + (System.currentTimeMillis() - currentTimeMillis));
                        this.decoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    }
                }
            }
        }
        DDLog.m1724e("frames777:");
    }

    private boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    private byte[] getDataFromImage(Image image, int i) {
        int i2;
        int i3 = i;
        int i4 = 2;
        int i5 = 1;
        if (i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("only support COLOR_FormatI420 and COLOR_FormatNV21");
        }
        if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i6 = width * height;
        byte[] bArr = new byte[(ImageFormat.getBitsPerPixel(format) * i6) / 8];
        int i7 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        Log.v(this.TAG, "get data from " + planes.length + " planes");
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        while (i9 < planes.length) {
            if (i9 == 0) {
                i8 = i5;
                i10 = i7;
            } else if (i9 != i5) {
                if (i9 == i4) {
                    if (i3 == i5) {
                        i10 = (int) (i6 * 1.25d);
                        i8 = i5;
                    } else if (i3 == i4) {
                        i8 = i4;
                        i10 = i6;
                    }
                }
            } else if (i3 == i5) {
                i8 = i5;
                i10 = i6;
            } else if (i3 == i4) {
                i10 = i6 + 1;
                i8 = i4;
            }
            ByteBuffer buffer = planes[i9].getBuffer();
            int rowStride = planes[i9].getRowStride();
            int pixelStride = planes[i9].getPixelStride();
            Image.Plane[] planeArr = planes;
            Log.v(this.TAG, "pixelStride " + pixelStride);
            Log.v(this.TAG, "rowStride " + rowStride);
            Log.v(this.TAG, "width " + width);
            Log.v(this.TAG, "height " + height);
            Log.v(this.TAG, "buffer size " + buffer.remaining());
            int i11 = i9 == 0 ? 0 : 1;
            int i12 = width >> i11;
            int i13 = height >> i11;
            int i14 = width;
            int i15 = height;
            buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
            for (int i16 = 0; i16 < i13; i16++) {
                if (pixelStride == 1 && i8 == 1) {
                    buffer.get(bArr, i10, i12);
                    i10 += i12;
                    i2 = i12;
                } else {
                    i2 = ((i12 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i17 = 0; i17 < i12; i17++) {
                        bArr[i10] = bArr2[i17 * pixelStride];
                        i10 += i8;
                    }
                }
                if (i16 < i13 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
            }
            Log.v(this.TAG, "Finished reading data from plane " + i9);
            i9++;
            i3 = i;
            planes = planeArr;
            width = i14;
            height = i15;
            i4 = 2;
            i5 = 1;
            i7 = 0;
        }
        return bArr;
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

    public boolean saveYuv(byte[] bArr) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "1280x720.yuv");
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean saveYuv(I420 i420) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "1280x720 i420.yuv");
            fileOutputStream.write(i420.f2550Y);
            fileOutputStream.write(i420.f2548U);
            fileOutputStream.write(i420.f2549V);
            fileOutputStream.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}