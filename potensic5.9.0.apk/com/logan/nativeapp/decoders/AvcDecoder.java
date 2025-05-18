package com.logan.nativeapp.decoders;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.lingala.zip4j.util.InternalZipConstants;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;

/* loaded from: classes3.dex */
public class AvcDecoder {
    private static final int COLOR_FormatI420 = 1;
    private static final int COLOR_FormatNV21 = 2;
    private static final long DEFAULT_TIMEOUT_US = 10000;
    public static final int FILE_TypeI420 = 1;
    public static final int FILE_TypeJPEG = 3;
    public static final int FILE_TypeNV21 = 2;
    private static final String TAG = "AvcDecoder";
    private static final boolean VERBOSE = false;
    private static final int decodeColorFormat = 2135033992;
    private String INPUT_FILE_PATH;
    private String OUTPUT_FILE_PATH;
    private DecodeProgressListener decodeProgressListener;
    private FileChannel fc_out;
    private int outputImageFileType = -1;
    private MediaExtractor extractor = null;
    private MediaCodec decoder = null;
    private MediaFormat mediaFormat = null;
    private boolean isCoverFace = false;
    private int coverFaceY = 0;
    private int coverFaceHeight = 0;
    private ExecutorService executorPools = Executors.newCachedThreadPool();

    public interface DecodeProgressListener {
        void publishProgress(int i);
    }

    public void setDecoderParams(String str, String str2, int i) throws IOException {
        if (i != 1 && i != 2 && i != 3) {
            throw new IllegalArgumentException("only support FILE_TypeI420 and FILE_TypeNV21 and FILE_TypeJPEG");
        }
        File file = new File(str2);
        File file2 = new File(str);
        if (!file.exists()) {
            throw new RuntimeException("mp4 file do not exist");
        }
        if (file.isDirectory()) {
            throw new IllegalArgumentException("mp4Path is not a mp4 file , it is a directory");
        }
        if (file2.isDirectory()) {
            throw new IllegalArgumentException("yuvPath is not a yuv file , it is a directory");
        }
        this.INPUT_FILE_PATH = str2;
        this.outputImageFileType = i;
        this.OUTPUT_FILE_PATH = str;
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        this.fc_out = new RandomAccessFile(file2, InternalZipConstants.WRITE_MODE).getChannel();
        File file3 = new File(this.INPUT_FILE_PATH);
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.extractor = mediaExtractor;
        mediaExtractor.setDataSource(file3.getPath());
        int selectTrack = selectTrack(this.extractor);
        if (selectTrack < 0) {
            throw new RuntimeException("No video track found in " + this.INPUT_FILE_PATH);
        }
        this.extractor.selectTrack(selectTrack);
        MediaFormat trackFormat = this.extractor.getTrackFormat(selectTrack);
        this.mediaFormat = trackFormat;
        String string = trackFormat.getString(IMediaFormat.KEY_MIME);
        MediaCodec createDecoderByType = MediaCodec.createDecoderByType(string);
        this.decoder = createDecoderByType;
        showSupportedColorFormat(createDecoderByType.getCodecInfo().getCapabilitiesForType(string));
        if (isColorFormatSupported(decodeColorFormat, this.decoder.getCodecInfo().getCapabilitiesForType(string))) {
            this.mediaFormat.setInteger("color-format", decodeColorFormat);
            Log.i(TAG, "set decode color format to type 2135033992");
        } else {
            Log.i(TAG, "unable to set decode color format, color format type 2135033992 not supported");
        }
    }

    public void setDecodeProgressListener(DecodeProgressListener decodeProgressListener) {
        this.decodeProgressListener = decodeProgressListener;
    }

    public void setCoverFaceMode(int i, int i2) {
        this.isCoverFace = true;
        this.coverFaceY = i;
        this.coverFaceHeight = i2;
    }

    public int getFrameTotalNum() {
        return Math.round((this.mediaFormat.getLong("durationUs") / 1000000.0f) * this.mediaFormat.getInteger("frame-rate"));
    }

    /* JADX WARN: Finally extract failed */
    public void videoDecode() throws IOException {
        try {
            decodeFramesToYUV(this.decoder, this.extractor, this.mediaFormat);
            this.decoder.stop();
            MediaCodec mediaCodec = this.decoder;
            if (mediaCodec != null) {
                mediaCodec.stop();
                this.decoder.release();
                this.decoder = null;
            }
            MediaExtractor mediaExtractor = this.extractor;
            if (mediaExtractor != null) {
                mediaExtractor.release();
                this.extractor = null;
            }
        } catch (Throwable th) {
            MediaCodec mediaCodec2 = this.decoder;
            if (mediaCodec2 != null) {
                mediaCodec2.stop();
                this.decoder.release();
                this.decoder = null;
            }
            MediaExtractor mediaExtractor2 = this.extractor;
            if (mediaExtractor2 != null) {
                mediaExtractor2.release();
                this.extractor = null;
            }
            throw th;
        }
    }

    private void showSupportedColorFormat(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        System.out.print("supported color format: ");
        for (int i : codecCapabilities.colorFormats) {
            System.out.print(i + "\t");
        }
        System.out.println();
    }

    private boolean isColorFormatSupported(int i, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        for (int i2 : codecCapabilities.colorFormats) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private void decodeFramesToYUV(MediaCodec mediaCodec, MediaExtractor mediaExtractor, MediaFormat mediaFormat) throws IOException {
        int i;
        int i2;
        int dequeueInputBuffer;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        int i3 = 0;
        mediaCodec.configure(mediaFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodec.start();
        mediaFormat.getInteger("width");
        mediaFormat.getInteger("height");
        int i4 = 0;
        boolean z = false;
        final int i5 = 0;
        while (i4 == 0) {
            if (z || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                i = 1;
            } else {
                int readSampleData = mediaExtractor.readSampleData(mediaCodec.getInputBuffer(dequeueInputBuffer), i3);
                if (readSampleData < 0) {
                    i = 1;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                    z = true;
                } else {
                    i = 1;
                    mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                    mediaExtractor.advance();
                }
            }
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000L);
            if (dequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 4) != 0) {
                    try {
                        this.fc_out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    i4 = i;
                }
                if ((bufferInfo.size != 0 ? i : 0) != 0) {
                    Image outputImage = mediaCodec.getOutputImage(dequeueOutputBuffer);
                    int i6 = this.outputImageFileType;
                    if (i6 != -1) {
                        if (i6 == i) {
                            this.fc_out.map(FileChannel.MapMode.READ_WRITE, i5 * r4.length, r4.length).put(getDataFromImage(outputImage, i));
                            this.executorPools.submit(new Runnable() { // from class: com.logan.nativeapp.decoders.AvcDecoder.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AvcDecoder.this.decodeProgressListener.publishProgress(i5);
                                }
                            });
                            i5++;
                        } else if (i6 == 3) {
                            compressToJpeg(this.OUTPUT_FILE_PATH, outputImage);
                        }
                    }
                    outputImage.close();
                    i2 = 0;
                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    i3 = i2;
                }
            }
            i2 = 0;
            i3 = i2;
        }
    }

    private int selectTrack(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString(IMediaFormat.KEY_MIME).startsWith("video/")) {
                return i;
            }
        }
        return -1;
    }

    private boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 17 || format == 35 || format == 842094169;
    }

    private byte[] getDataFromImage(Image image, int i) {
        Rect rect;
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
            int i11 = i9 == 0 ? i7 : i5;
            int i12 = width >> i11;
            int i13 = height >> i11;
            int i14 = width;
            buffer.position(((cropRect.top >> i11) * rowStride) + ((cropRect.left >> i11) * pixelStride));
            int i15 = 0;
            while (i15 < i13) {
                if (pixelStride == 1 && i8 == 1) {
                    buffer.get(bArr, i10, i12);
                    i10 += i12;
                    rect = cropRect;
                    i2 = i12;
                } else {
                    rect = cropRect;
                    i2 = ((i12 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i16 = 0; i16 < i12; i16++) {
                        bArr[i10] = bArr2[i16 * pixelStride];
                        i10 += i8;
                    }
                }
                if (i15 < i13 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
                i15++;
                cropRect = rect;
            }
            i9++;
            i3 = i;
            width = i14;
            i4 = 2;
            i5 = 1;
            i7 = 0;
        }
        return bArr;
    }

    private void dumpFile(String str, byte[] bArr) {
        try {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length);
            allocateDirect.put(bArr);
            this.fc_out.write(allocateDirect);
        } catch (IOException e) {
            throw new RuntimeException("failed writing data to file " + str, e);
        }
    }

    private void compressToJpeg(String str, Image image) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            Rect cropRect = image.getCropRect();
            new YuvImage(getDataFromImage(image, 2), 17, cropRect.width(), cropRect.height(), null).compressToJpeg(cropRect, 100, fileOutputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create output file " + str, e);
        }
    }
}