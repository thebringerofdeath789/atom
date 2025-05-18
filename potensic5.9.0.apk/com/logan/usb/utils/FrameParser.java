package com.logan.usb.utils;

import com.ipotensic.baselib.DDLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class FrameParser {
    public static final int FRAME_B = 14;
    public static final int FRAME_I = 13;
    public static final int FRAME_PPS = 11;
    public static final int FRAME_SEI = 12;
    public static final int FRAME_SPS = 10;
    public static final int FRAME_UNKNOWN = -1;
    private static volatile FrameParser instance;
    private FrameParserListener listener;
    private final int BUFFER_SIZE = 102400;
    private volatile BytePool buffer = new BytePool(102400);
    private byte[] outputData = null;

    public interface FrameParserListener {
        void onReceiveFrame(int i, byte[] bArr);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FrameType {
    }

    public static FrameParser getInstance() {
        if (instance == null) {
            synchronized (FrameParser.class) {
                if (instance == null) {
                    instance = new FrameParser();
                }
            }
        }
        return instance;
    }

    private FrameParser() {
    }

    public void write(byte[] bArr, int i) {
        if (this.buffer.getLength() + i >= 102400) {
            this.buffer.clear();
            DDLog.m1684e("clear");
        }
        this.buffer.add(bArr, i);
        try {
            startParse();
        } catch (Exception e) {
            DDLog.m1684e("解析出错1111111:" + e.getMessage());
        }
    }

    private void startParse() throws Exception {
        int length;
        int i;
        if (this.buffer.getWriteIndex() <= 0 || (length = this.buffer.getLength()) <= 5) {
            return;
        }
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < length - 5; i5++) {
            if (this.buffer.data[i5] == 0 && this.buffer.data[i5 + 1] == 0 && this.buffer.data[i5 + 2] == 0 && this.buffer.data[i5 + 3] == 1) {
                if (i3 != -1) {
                    this.outputData = new byte[i5 - i3];
                    byte[] bArr = this.buffer.data;
                    byte[] bArr2 = this.outputData;
                    System.arraycopy(bArr, i3, bArr2, 0, bArr2.length);
                    FrameParserListener frameParserListener = this.listener;
                    if (frameParserListener != null && i4 != -1) {
                        frameParserListener.onReceiveFrame(i4, this.outputData);
                    }
                    i2 = i5 - 1;
                }
                byte b = this.buffer.data[i5 + 4];
                if (b == 6) {
                    i = 12;
                } else if (b == 97) {
                    i = 14;
                } else if (b == 101) {
                    i = 13;
                } else if (b == 103) {
                    i = 10;
                } else if (b != 104) {
                    i4 = -1;
                    i3 = i5;
                } else {
                    i = 11;
                }
                i4 = i;
                i3 = i5;
            }
        }
        if (i2 != -1) {
            discardReadIndex(i2);
        }
    }

    private void discardReadIndex(int i) {
        this.buffer.discardIndex(i);
    }

    public void release() {
        this.buffer.clear();
    }

    public void setListener(FrameParserListener frameParserListener) {
        this.listener = frameParserListener;
    }
}