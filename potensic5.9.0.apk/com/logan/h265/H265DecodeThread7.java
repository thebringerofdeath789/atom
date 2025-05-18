package com.logan.h265;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.h264.H264Player;
import com.logan.h264.H264PreviewData;
import com.logan.h264.IDecoder;
import com.logan.nativeapp.H265Type;
import com.logan.nativeapp.I420;
import com.logan.nativeapp.OnYuvCallback;
import com.logan.nativeapp.SpsParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H265DecodeThread7 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private byte[] pps;
    private OnResultListener<Boolean> resultListener;
    private byte[] sps;
    private byte[] vps;
    private final String TAG = getClass().getSimpleName();
    private ConcurrentLinkedQueue<byte[]> frameNal = new ConcurrentLinkedQueue<>();
    private boolean isStart = false;
    private List<H264PreviewData> packages = new ArrayList();
    private int breakPkgNum = 0;
    private boolean needFlush = false;
    private SpsParser spsParser = new SpsParser();
    OnYuvCallback callback = new OnYuvCallback() { // from class: com.logan.h265.H265DecodeThread7.1
        @Override // com.logan.nativeapp.OnYuvCallback
        public void callback(I420 i420) {
            if (i420 != null) {
                H264Player.onYuvCallback(i420.width, i420.height, i420.f2550Y, i420.f2548U, i420.f2549V);
            }
        }
    };
    private boolean isInit = false;
    private List<Long> times = new ArrayList();
    private long timeStart = 0;

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        if (this.isStart) {
            try {
                if (this.frameNal.size() > 10) {
                    this.frameNal.clear();
                }
                this.frameNal.offer(bArr);
            } catch (Exception e) {
                DDLog.m1685e(this.TAG, "h264解析出错:" + e.getMessage());
            }
        }
    }

    @Override // com.logan.h264.IDecoder
    public boolean isStart() {
        return this.isStart;
    }

    @Override // com.logan.h264.IDecoder
    public void release(OnResultListener<Boolean> onResultListener) {
        this.resultListener = onResultListener;
        this.frameNal.clear();
        this.isStart = false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] bArr;
        this.isStart = true;
        DDLog.m1685e(this.TAG, "解码开始");
        H265HardDecoder h265HardDecoder = new H265HardDecoder();
        try {
            Thread.sleep(3000L);
            this.frameNal.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getLogDir(), "time.log"));
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        long currentTimeMillis = System.currentTimeMillis();
        while (this.isStart) {
            while (this.isStart && this.frameNal.size() > 0) {
                try {
                    Frame frame = new Frame(this.frameNal.poll());
                    if (frame.getFrameType() == H265Type.TYPE_VPS) {
                        this.vps = frame.getVps();
                        this.sps = frame.getSps();
                        byte[] pps = frame.getPps();
                        this.pps = pps;
                        if (this.vps != null && (bArr = this.sps) != null && pps != null) {
                            int length = bArr.length - 4;
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, 4, bArr2, 0, length);
                            int[] h265VideoWidthAndHeight = this.spsParser.getH265VideoWidthAndHeight(bArr2, length);
                            if (h265VideoWidthAndHeight != null) {
                                int i = h265VideoWidthAndHeight[0];
                                int i2 = h265VideoWidthAndHeight[1];
                                if (!this.isInit || h265HardDecoder.getWidth() != i || h265HardDecoder.getHeight() != i2) {
                                    h265HardDecoder.release();
                                    h265HardDecoder.init(i, i2, ParseUtil.concatAll(this.vps, this.sps, this.pps));
                                    this.isInit = true;
                                }
                            }
                        }
                    }
                    if (this.isInit) {
                        DDLog.m1685e(this.TAG, "解码 1");
                        long currentTimeMillis2 = System.currentTimeMillis();
                        h265HardDecoder.decode(frame.getData(), this.callback);
                        DDLog.m1685e(this.TAG, "解码 2");
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis2;
                        if (System.currentTimeMillis() - this.timeStart > 1000) {
                            long j = 0;
                            for (int i3 = 0; i3 < this.times.size(); i3++) {
                                j += this.times.get(i3).longValue();
                            }
                            if (this.times.size() != 0) {
                                DDLog.m1685e(this.TAG, "解码耗时 fps:" + this.times.size());
                                long size = j / this.times.size();
                                if (System.currentTimeMillis() - currentTimeMillis < 100000 && fileOutputStream != null) {
                                    fileOutputStream.write((size + ",").getBytes());
                                    DDLog.m1685e(this.TAG, "解码耗时 平均:" + size);
                                }
                            }
                            this.times.clear();
                            this.timeStart = System.currentTimeMillis();
                        } else {
                            this.times.add(Long.valueOf(currentTimeMillis3));
                        }
                    }
                } catch (Exception e3) {
                    DDLog.m1685e(this.TAG, "解码报错1:" + e3.getMessage());
                }
            }
            Thread.sleep(1L);
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        DDLog.m1685e(this.TAG, "解码结束");
        this.frameNal.clear();
        h265HardDecoder.release();
        OnResultListener<Boolean> onResultListener = this.resultListener;
        if (onResultListener != null) {
            onResultListener.onSuccess(true);
        }
    }
}