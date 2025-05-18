package com.logan.h264;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class H264PreviewData {

    @Deprecated
    private int dataType;
    private FrameType frameType;
    private int height;
    private boolean isFirstPkg;
    private boolean isKeyFrame;
    private boolean isLastPkg;
    private boolean isVideoSizeChange;
    private byte[] payload;
    private PkgType pkgType;

    @Deprecated
    private int protocol;
    private int width;

    public enum PkgType {
        PKG_FULL,
        PKG_START,
        PKG_CENTER,
        PKG_END
    }

    public H264PreviewData(byte[] bArr) throws Exception {
        this.pkgType = PkgType.PKG_FULL;
        this.frameType = FrameType.FRAME_B;
        int i = 3;
        this.isFirstPkg = ParseUtil.getBit(bArr[1], 3) == 1;
        boolean z = ParseUtil.getBit(bArr[1], 2) == 1;
        this.isLastPkg = z;
        boolean z2 = this.isFirstPkg;
        if (z2 && z) {
            this.pkgType = PkgType.PKG_FULL;
        } else if (z2 && !z) {
            this.pkgType = PkgType.PKG_START;
        } else if (!z2 && !z) {
            this.pkgType = PkgType.PKG_CENTER;
        } else if (!z2 && z) {
            this.pkgType = PkgType.PKG_END;
        }
        this.isVideoSizeChange = ParseUtil.getBit(bArr[1], 1) == 1;
        this.isKeyFrame = ParseUtil.getBit(bArr[1], 0) == 1;
        FrameType[] values = FrameType.values();
        int i2 = 0;
        while (true) {
            if (i2 >= values.length) {
                break;
            }
            if (values[i2].value == bArr[2]) {
                this.frameType = values[i2];
                break;
            }
            i2++;
        }
        if (this.isVideoSizeChange) {
            this.width = ParseUtil.getUnsignedShortFromByteArr(bArr, 3);
            this.height = ParseUtil.getUnsignedShortFromByteArr(bArr, 5);
            i = 7;
        }
        byte[] bArr2 = new byte[bArr.length - i];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
    }

    public PkgType getPkgType() {
        return this.pkgType;
    }

    public boolean isVideoSizeChange() {
        return this.isVideoSizeChange;
    }

    public FrameType getFrameType() {
        return this.frameType;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public enum FrameType {
        FRAME_B(0),
        FRAME_P(1),
        FRAME_I(2),
        FRAME_IDR_H264(5),
        FRAME_SEI_H264(6),
        FRAME_SPS_H264(7),
        FRAME_PPS_H264(8),
        FRAME_IDR_H265(19),
        FRAME_VPS_H265(32),
        FRAME_SPS_H265(33),
        FRAME_PPS_H265(34),
        FRAME_SEI_H265(39);

        public int value;

        FrameType(int i) {
            this.value = i;
        }
    }

    public static class H264Frame {
        private byte[] data;
        private FrameType frameType;

        public H264Frame(FrameType frameType, byte[] bArr) {
            this.frameType = frameType;
            this.data = bArr;
        }

        public FrameType getFrameType() {
            return this.frameType;
        }

        public byte[] getData() {
            return this.data;
        }
    }

    public String toString() {
        return "H264PreviewData{isFirstPkg=" + this.isFirstPkg + ", isLastPkg=" + this.isLastPkg + ", isVideoSizeChange=" + this.isVideoSizeChange + ", isKeyFrame=" + this.isKeyFrame + ", frameType=" + this.frameType + ", width=" + this.width + ", height=" + this.height + ", payload=" + ParseUtil.byteToHexString(this.payload, 100) + '}';
    }
}