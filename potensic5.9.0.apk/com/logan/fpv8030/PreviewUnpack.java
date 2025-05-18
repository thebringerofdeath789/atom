package com.logan.fpv8030;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class PreviewUnpack {
    private final Buffer liveViewBuffer = new Buffer(204800);
    private OnPreviewDataOutputListener outputListener = null;

    public interface OnPreviewDataOutputListener {
        void output(PreviewData previewData);
    }

    public void setOutputListener(OnPreviewDataOutputListener onPreviewDataOutputListener) {
        this.outputListener = onPreviewDataOutputListener;
    }

    public void put(byte[] bArr) {
        this.liveViewBuffer.write(bArr, bArr.length);
        byte[] data = this.liveViewBuffer.getData();
        int i = -1;
        int i2 = 0;
        while (i2 < this.liveViewBuffer.getWriteIndex() - 14) {
            if (isPkgHead(data, i2)) {
                PreviewData previewData = new PreviewData();
                previewData.dataLen = ParseUtil.getUnsignedShortFromByteArr(data, i2 + 5) - 7;
                previewData.pkgOrder = data[i2 + 7];
                byte b = data[i2 + 8];
                previewData.streamType = ParseUtil.getBit(b, 4) == 0 ? StreamType.H264 : StreamType.H265;
                previewData.isStart = ParseUtil.getBit(b, 3) == 1;
                previewData.isEnd = ParseUtil.getBit(b, 2) == 1;
                previewData.videoWidth = ParseUtil.getUnsignedShortFromByteArr(data, i2 + 10);
                previewData.videoHeight = ParseUtil.getUnsignedShortFromByteArr(data, i2 + 12);
                int i3 = i2 + 14;
                if ((previewData.dataLen + i3) - 1 <= this.liveViewBuffer.getWriteIndex()) {
                    previewData.data = new byte[previewData.dataLen];
                    System.arraycopy(data, i3, previewData.data, 0, previewData.dataLen);
                    i2 = (i3 + previewData.dataLen) - 1;
                    OnPreviewDataOutputListener onPreviewDataOutputListener = this.outputListener;
                    if (onPreviewDataOutputListener != null) {
                        onPreviewDataOutputListener.output(previewData);
                    }
                    i = i2;
                }
            }
            i2++;
        }
        if (i != -1) {
            this.liveViewBuffer.discard(i);
        }
    }

    public boolean isPkgHead(byte[] bArr, int i) {
        return bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 0 && bArr[i + 3] == 1 && bArr[i + 4] == -1;
    }
}