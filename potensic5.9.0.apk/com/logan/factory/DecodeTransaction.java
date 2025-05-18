package com.logan.factory;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.logan.fpv8030.PreviewData;
import com.logan.fpv8030.PreviewUnpack;
import com.logan.fpv8030.StreamType;
import com.logan.h264.H264DecodeThread7;
import com.logan.h264.IDecoder;
import com.logan.h265.H265DecodeThread7;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DecodeTransaction {
    private IDecoder decoder;
    private StreamType lastStreamType;
    private final List<PreviewData> packages;
    private final PreviewUnpack previewUnpack;

    public DecodeTransaction() {
        PreviewUnpack previewUnpack = new PreviewUnpack();
        this.previewUnpack = previewUnpack;
        this.packages = new ArrayList();
        this.decoder = null;
        this.lastStreamType = null;
        previewUnpack.setOutputListener(new PreviewUnpack.OnPreviewDataOutputListener() { // from class: com.logan.factory.DecodeTransaction.1
            @Override // com.logan.fpv8030.PreviewUnpack.OnPreviewDataOutputListener
            public void output(PreviewData previewData) {
                if (DecodeTransaction.this.decoder == null || DecodeTransaction.this.lastStreamType != previewData.streamType) {
                    DecodeTransaction.this.newDecoder(previewData.streamType);
                    DecodeTransaction.this.lastStreamType = previewData.streamType;
                }
                if (previewData.isStart && previewData.isEnd) {
                    if (DecodeTransaction.this.decoder != null) {
                        DecodeTransaction.this.decoder.decode(previewData.data);
                        return;
                    }
                    return;
                }
                if (previewData.isStart) {
                    DecodeTransaction.this.packages.clear();
                    DecodeTransaction.this.packages.add(previewData);
                    return;
                }
                if (!previewData.isStart && !previewData.isEnd) {
                    DecodeTransaction.this.packages.add(previewData);
                    return;
                }
                if (previewData.isEnd) {
                    DecodeTransaction.this.packages.add(previewData);
                    byte[] bArr = new byte[0];
                    for (int i = 0; i < DecodeTransaction.this.packages.size(); i++) {
                        PreviewData previewData2 = (PreviewData) DecodeTransaction.this.packages.get(i);
                        if (previewData2.pkgOrder != i) {
                            DDLog.m1684e("丢包了1");
                            DecodeTransaction.this.packages.clear();
                            return;
                        }
                        bArr = ParseUtil.concatAll(bArr, previewData2.data);
                    }
                    DecodeTransaction.this.packages.clear();
                    if (DecodeTransaction.this.decoder != null) {
                        DecodeTransaction.this.decoder.decode(bArr);
                    }
                }
            }
        });
    }

    public void put(byte[] bArr) {
        try {
            this.previewUnpack.put(bArr);
        } catch (Exception e) {
            DDLog.m1684e("解析出错2：" + e);
        }
    }

    public void newDecoder(final StreamType streamType) {
        IDecoder iDecoder = this.decoder;
        if (iDecoder != null) {
            iDecoder.release(new OnResultListener<Boolean>() { // from class: com.logan.factory.DecodeTransaction.2
                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onFailed(Exception exc) {
                }

                @Override // com.ipotensic.baselib.okhttp.OnResultListener
                public void onSuccess(Boolean bool) {
                    if (streamType == StreamType.H264) {
                        DecodeTransaction.this.decoder = new H264DecodeThread7();
                        DecodeTransaction.this.decoder.start();
                    } else {
                        DecodeTransaction.this.decoder = new H265DecodeThread7();
                        DecodeTransaction.this.decoder.start();
                    }
                }
            });
            return;
        }
        if (streamType == StreamType.H264) {
            H264DecodeThread7 h264DecodeThread7 = new H264DecodeThread7();
            this.decoder = h264DecodeThread7;
            h264DecodeThread7.start();
        } else {
            H265DecodeThread7 h265DecodeThread7 = new H265DecodeThread7();
            this.decoder = h265DecodeThread7;
            h265DecodeThread7.start();
        }
    }
}