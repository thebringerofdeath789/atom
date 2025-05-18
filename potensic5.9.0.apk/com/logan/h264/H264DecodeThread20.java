package com.logan.h264;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.ReleasableLinkedBlockingDeque;
import com.logan.h264.H264PreviewData;
import com.logan.nativeapp.H264ToYuvDecoder;
import com.logan.nativeapp.I420;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class H264DecodeThread20 extends IDecoder {
    private OnResultListener<Boolean> decodeListener;
    private FileOutputStream outputStream;
    private final ReleasableLinkedBlockingDeque<H264PreviewData.H264Frame> frameNal = new ReleasableLinkedBlockingDeque<>();
    private boolean isStart = false;
    private List<H264PreviewData> packages = new ArrayList();
    private int breakPkgNum = 0;
    private boolean needFlush = false;
    H264ToYuvDecoder.OnDecodeCallback callback = new H264ToYuvDecoder.OnDecodeCallback() { // from class: com.logan.h264.H264DecodeThread20.1
        @Override // com.logan.nativeapp.H264ToYuvDecoder.OnDecodeCallback
        public void onYuvCallback(I420 i420) {
            if (i420 != null) {
                H264Player.onYuvCallback(i420.width, i420.height, i420.f2550Y, i420.f2548U, i420.f2549V);
            }
        }
    };

    @Override // com.logan.h264.IDecoder
    public void decode(byte[] bArr) {
        if (this.isStart) {
            try {
                System.currentTimeMillis();
                H264PreviewData h264PreviewData = new H264PreviewData(bArr);
                H264PreviewData.PkgType pkgType = h264PreviewData.getPkgType();
                if (pkgType == H264PreviewData.PkgType.PKG_FULL) {
                    this.frameNal.put(new H264PreviewData.H264Frame(h264PreviewData.getFrameType(), h264PreviewData.getPayload()));
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
                        this.frameNal.put(new H264PreviewData.H264Frame(H264PreviewData.FrameType.FRAME_B, bArr2));
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
                    DDLog.m1684e("clear data");
                    this.frameNal.clear();
                    DDLog.m1684e("flush 1");
                }
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
    public void release(OnResultListener onResultListener) {
        this.decodeListener = onResultListener;
        this.isStart = false;
        this.frameNal.release();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.isStart = true;
        DDLog.m1684e("解码开始");
        while (this.isStart && !this.frameNal.isRelease.get()) {
            while (this.isStart && !this.frameNal.isRelease.get() && this.frameNal.size() > 0) {
                try {
                    H264PreviewData.H264Frame take = this.frameNal.take();
                    if (take != null) {
                        H264ToYuvDecoder.getInstance().decode(new com.logan.nativeapp.Frame(take.getData()), this.callback);
                    }
                } catch (Exception e) {
                    DDLog.m1684e("解码报错:" + e.getMessage());
                }
            }
        }
        DDLog.m1684e("解码结束");
        this.frameNal.clear();
        H264ToYuvDecoder.getInstance().release();
        OnResultListener<Boolean> onResultListener = this.decodeListener;
        if (onResultListener != null) {
            onResultListener.onSuccess(true);
        }
    }
}