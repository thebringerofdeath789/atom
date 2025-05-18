package com.logan.nativeapp.decoders;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import net.lingala.zip4j.util.InternalZipConstants;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class AvcEncoderOnAsynchronous {
    private BufferedOutputStream bos;
    private int frameSize;
    private int m_height;
    private int m_width;
    private RandomAccessFile randomAccessFile;
    private int totalFrameNum;
    private byte[] yuv420;
    private byte[] configByte = null;
    private AtomicInteger index = new AtomicInteger(0);
    private MediaCodec mediaCodec = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);

    public AvcEncoderOnAsynchronous(String str, int i, int i2, int i3, int i4, String str2) throws IOException {
        this.m_width = i;
        this.m_height = i2;
        int i5 = ((i * i2) * 3) / 2;
        this.frameSize = i5;
        this.yuv420 = new byte[i5];
        this.bos = new BufferedOutputStream(new FileOutputStream(new File(str2), false));
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, i, i2);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i4);
        createVideoFormat.setInteger("frame-rate", i3);
        createVideoFormat.setInteger("color-format", 2135033992);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("profile", 8);
        createVideoFormat.setInteger("level", 32768);
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(str), InternalZipConstants.READ_MODE);
        this.randomAccessFile = randomAccessFile;
        this.totalFrameNum = (int) (randomAccessFile.length() / this.frameSize);
        this.mediaCodec.setCallback(new MediaCodec.Callback() { // from class: com.logan.nativeapp.decoders.AvcEncoderOnAsynchronous.1
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec mediaCodec, int i6) {
                if (AvcEncoderOnAsynchronous.this.index.get() == AvcEncoderOnAsynchronous.this.totalFrameNum) {
                    return;
                }
                ByteBuffer inputBuffer = mediaCodec.getInputBuffer(i6);
                try {
                    AvcEncoderOnAsynchronous.this.randomAccessFile.seek(AvcEncoderOnAsynchronous.this.index.get() * AvcEncoderOnAsynchronous.this.frameSize);
                    AvcEncoderOnAsynchronous.this.randomAccessFile.read(AvcEncoderOnAsynchronous.this.yuv420, 0, AvcEncoderOnAsynchronous.this.yuv420.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] bArr = new byte[AvcEncoderOnAsynchronous.this.yuv420.length];
                AvcEncoderOnAsynchronous avcEncoderOnAsynchronous = AvcEncoderOnAsynchronous.this;
                avcEncoderOnAsynchronous.yuv420pTo420sp(avcEncoderOnAsynchronous.yuv420, bArr, AvcEncoderOnAsynchronous.this.m_width, AvcEncoderOnAsynchronous.this.m_height);
                AvcEncoderOnAsynchronous.this.yuv420 = bArr;
                inputBuffer.put(AvcEncoderOnAsynchronous.this.yuv420);
                System.out.println(Thread.currentThread().getId() + ":输入" + AvcEncoderOnAsynchronous.this.index.get() + "帧");
                AvcEncoderOnAsynchronous.this.mediaCodec.queueInputBuffer(i6, 0, AvcEncoderOnAsynchronous.this.yuv420.length, AvcEncoderOnAsynchronous.this.computePresentationTime(r8.index.getAndIncrement()), 0);
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec mediaCodec, int i6, MediaCodec.BufferInfo bufferInfo) {
                ByteBuffer outputBuffer = mediaCodec.getOutputBuffer(i6);
                int i7 = bufferInfo.size;
                byte[] bArr = new byte[i7];
                outputBuffer.get(bArr);
                if (bufferInfo.flags == 2) {
                    AvcEncoderOnAsynchronous.this.configByte = new byte[bufferInfo.size];
                    AvcEncoderOnAsynchronous.this.configByte = bArr;
                } else if (bufferInfo.flags == 1) {
                    int length = bufferInfo.size + AvcEncoderOnAsynchronous.this.configByte.length;
                    byte[] bArr2 = new byte[length];
                    System.arraycopy(AvcEncoderOnAsynchronous.this.configByte, 0, bArr2, 0, AvcEncoderOnAsynchronous.this.configByte.length);
                    System.arraycopy(bArr, 0, bArr2, AvcEncoderOnAsynchronous.this.configByte.length, i7);
                    try {
                        AvcEncoderOnAsynchronous.this.bos.write(bArr2, 0, length);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        AvcEncoderOnAsynchronous.this.bos.write(bArr, 0, i7);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                AvcEncoderOnAsynchronous.this.mediaCodec.releaseOutputBuffer(i6, false);
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
                System.out.println(codecException.toString());
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                System.out.println(mediaFormat);
            }
        });
        this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
    }

    public void close() {
        try {
            this.mediaCodec.stop();
            this.mediaCodec.release();
            this.bos.flush();
            this.bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        this.mediaCodec.start();
        while (this.index.get() != this.totalFrameNum) {
            try {
                Thread.sleep(SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yuv420pTo420sp(byte[] bArr, byte[] bArr2, int i, int i2) {
        if (bArr == null || bArr2 == null) {
            return;
        }
        int i3 = i * i2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        for (int i4 = 0; i4 < i3 / 4; i4++) {
            int i5 = (i4 * 2) + i3;
            bArr2[i5] = bArr[i4 + i3];
            bArr2[i5 + 1] = bArr[(int) (i4 + (i3 * 1.25d))];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long computePresentationTime(long j) {
        return ((j * 1000000) / 30) + 132;
    }
}