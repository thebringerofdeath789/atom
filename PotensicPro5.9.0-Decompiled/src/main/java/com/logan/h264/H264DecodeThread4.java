package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.h264.H264PreviewData;
import com.logan.nativeapp.SpsParser;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class H264DecodeThread4 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private byte[] pps;
    private byte[] sps;
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
                        int i3 = this.breakPkgNum + 1;
                        this.breakPkgNum = i3;
                        if (i3 >= 4) {
                            this.needFlush = true;
                        }
                    }
                    this.packages.clear();
                }
                if (this.frameNal.size() > 20) {
                    DDLog.e("clear data");
                    this.frameNal.clear();
                    DDLog.e("flush 1");
                }
            } catch (Exception e) {
                DDLog.e("h264解析出错:" + e.getMessage());
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
        DDLog.e("解码开始");
        System.currentTimeMillis();
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
                                    initPlayer();
                                    try {
                                        this.isInit = true;
                                        i3 = i4;
                                        i2 = i;
                                    } catch (Exception e2) {
                                        e = e2;
                                        i3 = i4;
                                        DDLog.e("解码报错:" + e.getMessage());
                                        i2 = i;
                                    }
                                }
                            }
                        }
                    }
                    if (this.isInit) {
                        H264Player.decode(frame.getData(), frame.getData().length);
                    }
                } catch (Exception e3) {
                    i = i2;
                    e = e3;
                }
            }
            Thread.sleep(1L);
        }
        DDLog.e("解码结束");
        this.frameNal.clear();
        H264Player.destroy();
    }

    private void initPlayer() {
        H264Player.destroy();
        byte[] hexStringToByte = ParseUtil.hexStringToByte("000000016764001fac2c6a81001269b808080810d5fab01197ca80d3d69a930d030ea3740000000168ee31b21b2c6a81001269b808080810d5fab01197");
        boolean isHardDecode = SPHelper.getInstance().isHardDecode();
        if (H264Player.init(isHardDecode, hexStringToByte, hexStringToByte.length) != 0) {
            DDLog.e("解码失败 切换解码 是否硬解码:" + (!isHardDecode));
            H264Player.init(!isHardDecode, hexStringToByte, hexStringToByte.length);
        }
        DDLog.e("开始解码");
    }
}
