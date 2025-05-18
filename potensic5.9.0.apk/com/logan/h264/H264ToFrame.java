package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.logan.h264.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* loaded from: classes.dex */
public class H264ToFrame {
    public static int bNum = 0;
    private static boolean isPpsSave = false;
    private static boolean isSpsSave = false;
    private OnFrameCallback frameCallback;

    public interface OnFrameCallback {
        void onFrame(Frame frame);
    }

    public static void main(String[] strArr) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream("D:\\360MoveData\\Users\\Administrator\\Desktop\\temp1.h264");
            new H264ToFrame(new OnFrameCallback() { // from class: com.logan.h264.H264ToFrame.1
                @Override // com.logan.h264.H264ToFrame.OnFrameCallback
                public void onFrame(Frame frame) {
                    try {
                        if (frame.getFrameType() == Frame.FrameType.SPS && H264ToFrame.isSpsSave) {
                            return;
                        }
                        if ((frame.getFrameType() == Frame.FrameType.PPS && H264ToFrame.isPpsSave) || frame.getFrameType() == Frame.FrameType.SEI) {
                            return;
                        }
                        if (frame.getFrameType() == Frame.FrameType.SPS) {
                            boolean unused = H264ToFrame.isSpsSave = true;
                        }
                        if (frame.getFrameType() == Frame.FrameType.PPS) {
                            boolean unused2 = H264ToFrame.isPpsSave = true;
                        }
                        fileOutputStream.write(frame.getData());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).parse("D:\\360MoveData\\Users\\Administrator\\Desktop\\20221116_1539_short2.h264");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public H264ToFrame(OnFrameCallback onFrameCallback) {
        this.frameCallback = onFrameCallback;
    }

    public void parse(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            fileInputStream.close();
            parse(bArr);
        } catch (Exception e) {
            DDLog.m1684e("报错:" + e.getMessage());
        }
    }

    public void parse(byte[] bArr) throws Exception {
        int i = -1;
        for (int i2 = 0; i2 < bArr.length - 4; i2++) {
            if (isHead(bArr, i2)) {
                if (i != -1) {
                    int i3 = i2 - i;
                    byte[] bArr2 = new byte[i3];
                    System.arraycopy(bArr, i, bArr2, 0, i3);
                    Frame frame = new Frame(bArr2);
                    this.frameCallback.onFrame(frame);
                    if (frame.getFrameType() != Frame.FrameType.SPS && frame.getFrameType() != Frame.FrameType.PPS && frame.getFrameType() != Frame.FrameType.SEI) {
                        Thread.sleep(33L);
                    }
                }
                i = i2;
            }
            if (i2 == bArr.length - 5 && i != -1) {
                int length = bArr.length - i;
                byte[] bArr3 = new byte[length];
                System.arraycopy(bArr, i, bArr3, 0, length);
                Frame frame2 = new Frame(bArr3);
                this.frameCallback.onFrame(frame2);
                if (frame2.getFrameType() != Frame.FrameType.SPS && frame2.getFrameType() != Frame.FrameType.PPS && frame2.getFrameType() != Frame.FrameType.SEI) {
                    Thread.sleep(33L);
                }
            }
        }
    }

    private boolean isHead(byte[] bArr, int i) {
        return bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1;
    }
}