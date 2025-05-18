package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.h264.H264PreviewData;
import com.logan.nativeapp.H264ToYuvDecoder2;
import com.logan.nativeapp.I420;
import com.logan.nativeapp.OnYuvCallback;
import com.logan.nativeapp.SpsParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H264DecodeThread2 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private byte[] pps;
    private byte[] sps;
    private final String TAG = getClass().getSimpleName();
    private ConcurrentLinkedQueue<H264PreviewData.H264Frame> frameNal = new ConcurrentLinkedQueue<>();
    private boolean isStart = false;
    private List<H264PreviewData> packages = new ArrayList();
    private int breakPkgNum = 0;
    private boolean needFlush = false;
    private SpsParser spsParser = new SpsParser();
    OnYuvCallback callback = new OnYuvCallback() { // from class: com.logan.h264.H264DecodeThread2.1
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
    private FileOutputStream outputStream = null;

    @Override // com.logan.h264.IDecoder
    public void release(OnResultListener onResultListener) {
    }

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        if (this.isStart) {
            try {
                System.currentTimeMillis();
                H264PreviewData h264PreviewData = new H264PreviewData(bArr);
                H264PreviewData.PkgType pkgType = h264PreviewData.getPkgType();
                if (pkgType == H264PreviewData.PkgType.PKG_FULL) {
                    this.frameNal.offer(new H264PreviewData.H264Frame(h264PreviewData.getFrameType(), h264PreviewData.getPayload()));
                } else if (pkgType == H264PreviewData.PkgType.PKG_START) {
                    this.packages.clear();
                    this.packages.add(h264PreviewData);
                } else if (pkgType == H264PreviewData.PkgType.PKG_CENTER) {
                    if (this.packages.size() > 0 && this.packages.get(0).getPkgType() == H264PreviewData.PkgType.PKG_START) {
                        this.packages.add(h264PreviewData);
                    } else {
                        DDLog.m1685e(this.TAG, "丢包了1");
                        int i = this.breakPkgNum + 1;
                        this.breakPkgNum = i;
                        if (i >= 4) {
                            this.needFlush = true;
                        }
                    }
                } else if (pkgType == H264PreviewData.PkgType.PKG_END) {
                    if (this.packages.size() > 0 && this.packages.get(0).getPkgType() == H264PreviewData.PkgType.PKG_START) {
                        this.packages.add(h264PreviewData);
                        byte[] bArr2 = new byte[0];
                        for (int i2 = 0; i2 < this.packages.size(); i2++) {
                            bArr2 = ParseUtil.concatAll(bArr2, this.packages.get(i2).getPayload());
                        }
                        this.frameNal.offer(new H264PreviewData.H264Frame(H264PreviewData.FrameType.FRAME_B, bArr2));
                    } else {
                        DDLog.m1685e(this.TAG, "丢包了2");
                        int i3 = this.breakPkgNum + 1;
                        this.breakPkgNum = i3;
                        if (i3 >= 4) {
                            this.needFlush = true;
                        }
                    }
                    this.packages.clear();
                }
                if (this.frameNal.size() > 20) {
                    DDLog.m1685e(this.TAG, "clear frameNal");
                    this.frameNal.clear();
                }
            } catch (Exception e) {
                DDLog.m1685e(this.TAG, "h264解析出错:" + e.getMessage());
            }
        }
    }

    @Override // com.logan.h264.IDecoder
    public boolean isStart() {
        return this.isStart;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.isStart = true;
        DDLog.m1685e(this.TAG, "解码开始");
        H264ToYuvDecoder2 h264ToYuvDecoder2 = new H264ToYuvDecoder2();
        try {
            Thread.sleep(3000L);
            this.frameNal.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (this.isStart) {
            while (this.isStart && this.frameNal.size() > 0) {
                try {
                    byte[] data = this.frameNal.poll().getData();
                    DDLog.m1684e("frame:" + ParseUtil.byteToHexString(data, 50));
                    if (this.outputStream == null) {
                        this.outputStream = new FileOutputStream(new File(LocalFileManager.getInstance().getLogDir(), "h265.h265"));
                    }
                    this.outputStream.write(data);
                    com.logan.nativeapp.Frame frame = new com.logan.nativeapp.Frame(data);
                    if (frame.getFrameType() == 10) {
                        this.sps = frame.getSps();
                        byte[] pps = frame.getPps();
                        this.pps = pps;
                        byte[] bArr = this.sps;
                        if (bArr != null && pps != null) {
                            int length = bArr.length - 4;
                            byte[] bArr2 = new byte[length];
                            System.arraycopy(bArr, 4, bArr2, 0, length);
                            int[] videoWidthAndHeight = this.spsParser.getVideoWidthAndHeight(bArr2, length);
                            if (videoWidthAndHeight != null) {
                                int i = videoWidthAndHeight[0];
                                int i2 = videoWidthAndHeight[1];
                                if (!this.isInit || h264ToYuvDecoder2.getWidth() != i || h264ToYuvDecoder2.getHeight() != i2) {
                                    h264ToYuvDecoder2.release();
                                    h264ToYuvDecoder2.init(i, i2, this.sps, this.pps);
                                    this.isInit = true;
                                }
                            }
                        }
                    }
                    if (this.isInit) {
                        long currentTimeMillis = System.currentTimeMillis();
                        h264ToYuvDecoder2.decode(frame, this.callback);
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (System.currentTimeMillis() - this.timeStart > 1000) {
                            long j = 0;
                            for (int i3 = 0; i3 < this.times.size(); i3++) {
                                j += this.times.get(i3).longValue();
                            }
                            if (this.times.size() != 0) {
                                DDLog.m1685e(this.TAG, "解码耗时 fps:" + this.times.size());
                                DDLog.m1685e(this.TAG, "解码耗时:" + (j / this.times.size()));
                            }
                            this.times.clear();
                            this.timeStart = System.currentTimeMillis();
                        } else {
                            this.times.add(Long.valueOf(currentTimeMillis2));
                        }
                    }
                } catch (Exception e2) {
                    DDLog.m1685e(this.TAG, "解码报错:" + e2.getMessage());
                }
            }
            Thread.sleep(1L);
        }
        DDLog.m1685e(this.TAG, "解码结束");
        this.frameNal.clear();
        h264ToYuvDecoder2.release();
        FileOutputStream fileOutputStream = this.outputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.outputStream = null;
        }
    }
}