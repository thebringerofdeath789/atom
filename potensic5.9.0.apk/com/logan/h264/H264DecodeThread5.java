package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.h264.H264PreviewData;
import com.logan.nativeapp.H264HardDecoder;
import com.logan.nativeapp.I420;
import com.logan.nativeapp.OnYuvCallback;
import com.logan.nativeapp.SpsParser;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H264DecodeThread5 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private FileOutputStream outputStream;
    private byte[] pps;
    private byte[] sps;
    private final String TAG = getClass().getSimpleName();
    private ConcurrentLinkedQueue<H264PreviewData.H264Frame> frameNal = new ConcurrentLinkedQueue<>();
    private boolean isStart = false;
    private List<H264PreviewData> packages = new ArrayList();
    private int breakPkgNum = 0;
    private boolean needFlush = false;
    private SpsParser spsParser = new SpsParser();
    private boolean isInit = false;

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
        int i;
        Exception e;
        this.isStart = true;
        DDLog.m1685e(this.TAG, "解码开始");
        H264HardDecoder.setOnYuvCallback(new OnYuvCallback() { // from class: com.logan.h264.H264DecodeThread5.1
            @Override // com.logan.nativeapp.OnYuvCallback
            public void callback(I420 i420) {
                if (i420 != null) {
                    H264Player.onYuvCallback(i420.width, i420.height, i420.f2550Y, i420.f2548U, i420.f2549V);
                }
            }
        });
        try {
            Thread.sleep(3000L);
            this.frameNal.clear();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        int i2 = 0;
        int i3 = 0;
        while (this.isStart) {
            while (this.isStart && this.frameNal.size() > 0) {
                try {
                    com.logan.nativeapp.Frame frame = new com.logan.nativeapp.Frame(this.frameNal.poll().getData());
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
                                i = videoWidthAndHeight[0];
                                int i4 = videoWidthAndHeight[1];
                                if (!this.isInit || i2 != i || i3 != i4) {
                                    H264HardDecoder.release();
                                    byte[] bArr3 = this.sps;
                                    int length2 = bArr3.length;
                                    byte[] bArr4 = this.pps;
                                    H264HardDecoder.init(bArr3, length2, bArr4, bArr4.length);
                                    try {
                                        this.isInit = true;
                                        i3 = i4;
                                        i2 = i;
                                    } catch (Exception e3) {
                                        e = e3;
                                        i3 = i4;
                                        DDLog.m1685e(this.TAG, "解码报错:" + e.getMessage());
                                        i2 = i;
                                    }
                                }
                            }
                        }
                    }
                    if (this.isInit) {
                        long currentTimeMillis = System.currentTimeMillis();
                        H264HardDecoder.decode(frame.getData(), frame.getLength());
                        if (frame.getFrameType() == 10) {
                            DDLog.m1685e(this.TAG, "解码耗时:" + (System.currentTimeMillis() - currentTimeMillis));
                        }
                    }
                } catch (Exception e4) {
                    i = i2;
                    e = e4;
                }
            }
            Thread.sleep(1L);
        }
        DDLog.m1685e(this.TAG, "解码结束");
        this.frameNal.clear();
        H264HardDecoder.setOnYuvCallback(null);
        H264HardDecoder.release();
    }
}