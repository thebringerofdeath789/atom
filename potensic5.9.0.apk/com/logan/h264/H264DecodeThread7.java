package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.fpv8030.PreviewData;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H264DecodeThread7 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private FileOutputStream outputStream;
    private FileOutputStream outputStream1;
    private final String TAG = getClass().getSimpleName();
    private ConcurrentLinkedQueue<byte[]> frameNal = new ConcurrentLinkedQueue<>();
    private boolean isStart = false;
    private final List<PreviewData> packages = new ArrayList();
    private boolean needFlush = false;
    private final int DROP_FRAME_NEED_FLUSH = 6;
    private long startTime = 0;
    private byte[] lastSPSPPS = new byte[0];
    private Runnable dropFrameRunnable = new Runnable() { // from class: com.logan.h264.H264DecodeThread7.1
        @Override // java.lang.Runnable
        public void run() {
            H264DecodeThread7.this.needFlush = true;
        }
    };
    private boolean isFirstIFrame = false;
    private int bNum = 0;

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        if (this.isStart) {
            try {
                if (this.frameNal.size() > 10) {
                    this.frameNal.clear();
                }
                this.frameNal.offer(bArr);
            } catch (Exception e) {
                DDLog.m1684e("h264解析出错:" + e.getMessage());
            }
        }
    }

    @Override // com.logan.h264.IDecoder
    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.h264.IDecoder
    public void release(OnResultListener<Boolean> onResultListener) {
        this.decodeListener = onResultListener;
        this.frameNal.clear();
        this.isStart = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        initPlayer();
        this.isStart = true;
        this.startTime = System.currentTimeMillis();
        while (this.isStart) {
            while (this.isStart && this.frameNal.size() > 0) {
                try {
                    byte[] poll = this.frameNal.poll();
                    System.currentTimeMillis();
                    if (this.needFlush && isIFrame(poll)) {
                        this.needFlush = false;
                        initPlayer();
                    }
                    if (!this.isFirstIFrame) {
                        if (isIFrame(poll)) {
                            this.isFirstIFrame = true;
                            H264Player.decode(poll, poll.length);
                            this.lastSPSPPS = getSPSPPS(poll);
                        }
                    } else {
                        if (isIFrame(poll)) {
                            byte[] spspps = getSPSPPS(poll);
                            if (!isSPSPPSChanged(spspps)) {
                                poll = getIFrame(poll);
                            }
                            this.lastSPSPPS = spspps;
                        }
                        System.currentTimeMillis();
                        H264Player.decode(poll, poll.length);
                    }
                } catch (Exception unused) {
                }
            }
            Thread.sleep(1L);
        }
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            try {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                this.outputStream = null;
            }
        }
        FileOutputStream fileOutputStream2 = this.outputStream1;
        try {
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            this.frameNal.clear();
            H264Player.destroy();
            OnResultListener<Boolean> onResultListener = this.decodeListener;
            if (onResultListener != null) {
                onResultListener.onSuccess(true);
            }
            DDLog.m1684e("退出解码");
        } finally {
            this.outputStream1 = null;
        }
    }

    private void initPlayer() {
        H264Player.destroy();
        byte[] hexStringToByte = ParseUtil.hexStringToByte("000000016764001fac2c6a81001269b808080810d5fab01197ca80d3d69a930d030ea3740000000168ee31b21b2c6a81001269b808080810d5fab01197");
        boolean isHardDecode = SPHelper.getInstance().isHardDecode();
        if (H264Player.init(isHardDecode, hexStringToByte, hexStringToByte.length) != 0) {
            DDLog.m1684e("解码失败 切换解码 是否硬解码:" + (!isHardDecode));
            H264Player.init(!isHardDecode, hexStringToByte, hexStringToByte.length);
        }
        DDLog.m1684e("开始解码");
        this.isFirstIFrame = false;
    }

    private boolean isIFrame(byte[] bArr) {
        return bArr.length > 5 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 1 && bArr[4] == 103;
    }

    private byte[] getSPSPPS(byte[] bArr) {
        int i = 0;
        while (true) {
            if (i >= 100) {
                i = -1;
                break;
            }
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1 && bArr[i + 4] == 6) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return null;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    private boolean isSPSPPSChanged(byte[] bArr) {
        if (bArr == null || this.lastSPSPPS == null) {
            return true;
        }
        return !ParseUtil.byteToHexString(bArr).equals(ParseUtil.byteToHexString(this.lastSPSPPS));
    }

    private byte[] getIFrame(byte[] bArr) {
        int i = 0;
        while (true) {
            if (i >= bArr.length - 5) {
                i = -1;
                break;
            }
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1 && bArr[i + 4] == 101) {
                break;
            }
            i++;
        }
        if (i == -1) {
            return bArr;
        }
        int length = bArr.length - i;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i, bArr2, 0, length);
        return bArr2;
    }
}