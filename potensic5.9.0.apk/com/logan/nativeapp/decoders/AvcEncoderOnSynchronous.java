package com.logan.nativeapp.decoders;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public class AvcEncoderOnSynchronous {
    private BufferedOutputStream bos;
    private int m_height;
    private int m_width;
    private byte[] configByte = null;
    private long generateIndex = 0;
    private MediaCodec mediaCodec = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);

    public AvcEncoderOnSynchronous(int i, int i2, int i3, int i4, String str) throws IOException {
        this.m_width = i;
        this.m_height = i2;
        this.bos = new BufferedOutputStream(new FileOutputStream(new File(str), false));
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, i, i2);
        createVideoFormat.setInteger(IjkMediaMeta.IJKM_KEY_BITRATE, i4);
        createVideoFormat.setInteger("frame-rate", i3);
        createVideoFormat.setInteger("color-format", 2135033992);
        createVideoFormat.setInteger("i-frame-interval", 1);
        createVideoFormat.setInteger("profile", 8);
        createVideoFormat.setInteger("level", 32768);
        this.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.mediaCodec.start();
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

    public void offerEncoder(byte[] bArr) {
        try {
            int dequeueInputBuffer = this.mediaCodec.dequeueInputBuffer(-1L);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer inputBuffer = this.mediaCodec.getInputBuffer(dequeueInputBuffer);
                if (inputBuffer != null) {
                    inputBuffer.clear();
                    byte[] bArr2 = new byte[bArr.length];
                    yuv420pTo420sp(bArr, bArr2, this.m_width, this.m_height);
                    inputBuffer.put(bArr2);
                    System.out.println("输入" + this.generateIndex + "帧");
                    bArr = bArr2;
                }
                MediaCodec mediaCodec = this.mediaCodec;
                int length = bArr.length;
                long j = this.generateIndex;
                this.generateIndex = 1 + j;
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, length, computePresentationTime(j), 0);
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 12000L);
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = this.mediaCodec.getOutputBuffer(dequeueOutputBuffer);
                int i = bufferInfo.size;
                byte[] bArr3 = new byte[i];
                outputBuffer.get(bArr3);
                if (bufferInfo.flags == 2) {
                    this.configByte = new byte[bufferInfo.size];
                    this.configByte = bArr3;
                } else if (bufferInfo.flags == 1) {
                    int i2 = bufferInfo.size;
                    byte[] bArr4 = this.configByte;
                    int length2 = i2 + bArr4.length;
                    byte[] bArr5 = new byte[length2];
                    System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
                    System.arraycopy(bArr3, 0, bArr5, this.configByte.length, i);
                    this.bos.write(bArr5, 0, length2);
                } else {
                    this.bos.write(bArr3, 0, i);
                }
                this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 12000L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void yuv420pTo420sp(byte[] bArr, byte[] bArr2, int i, int i2) {
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

    private long computePresentationTime(long j) {
        return ((j * 1000000) / 30) + 132;
    }
}