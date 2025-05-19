package com.logan.camera.data;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.mediadataretriever.utils.Utils;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.camera.CameraConfig;
import org.apache.commons.net.nntp.NNTPReply;

/* loaded from: classes2.dex */
public class ManualModeInfo {
    private static final String TAG = "ManualModeInfo";
    public boolean isManualMode;
    public boolean isMwbMode;
    public int isoValue;
    public int ssDown;
    public int ssUp;
    public int wbValue;

    public String toString() {
        return "手动模式 ManualModeInfo{isManualMode=" + this.isManualMode + ", ssUp=" + this.ssUp + ", ssDown=" + this.ssDown + ", isoValue=" + this.isoValue + ", isMwbMode=" + this.isMwbMode + ", wbValue=" + this.wbValue + '}';
    }

    public ManualModeInfo(byte[] bArr, int i) {
        if (bArr.length > i + 1) {
            this.isManualMode = bArr[i + 2] == 1;
        }
        int i2 = i + 3;
        if (bArr.length > i2) {
            this.ssUp = ParseUtil.getUnsignedShortFromByteArr(bArr, i2);
        }
        int i3 = i + 5;
        if (bArr.length > i3) {
            this.ssDown = ParseUtil.getUnsignedShortFromByteArr(bArr, i3);
        }
        int i4 = i + 7;
        if (bArr.length > i4) {
            this.isoValue = ParseUtil.getUnsignedShortFromByteArr(bArr, i4);
        }
        if (bArr.length > i + 8) {
            this.isMwbMode = bArr[i + 9] == 1;
        }
        int i5 = i + 10;
        if (bArr.length > i5) {
            this.wbValue = ParseUtil.getUnsignedShortFromByteArr(bArr, i5);
        }
        DDLog.i(TAG, toString());
        this.ssDown = getNearestSsDown(this.ssDown / this.ssUp);
        this.ssUp = 1;
        this.isoValue = getNearestIso(this.isoValue);
        this.wbValue = (this.wbValue / 100) * 100;
    }

    public void switchToManualMode() {
        this.isManualMode = true;
    }

    public void updateSSDown() {
        if (CameraConfig.get().supportVideoSizes.getCurrentFps() > this.ssDown) {
            this.ssDown = CameraConfig.get().supportVideoSizes.getCurrentFps();
        }
    }

    private int getNearestIso(int i) {
        return findNearestNumber(new int[]{100, 200, NNTPReply.SERVICE_DISCONTINUED, 800, 1600, 3200, 6400}, i);
    }

    private int getNearestSsDown(int i) {
        return findNearestNumber(new int[]{24, 25, 30, 40, 50, 60, 80, 100, 120, 160, 200, 240, Utils.TARGET_SIZE_MINI_THUMBNAIL, NNTPReply.SERVICE_DISCONTINUED, 500, 640, 800, 1000, 1250, 1600, 2000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 3200, 4000, 5000, 6400, 8000}, i);
    }

    private int findNearestNumber(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = distance(iArr[i2], i);
            if (iArr2[i2] == 0) {
                return iArr[i2];
            }
        }
        return iArr[search(iArr2)];
    }

    private int search(int[] iArr) {
        int i = 0;
        int i2 = iArr[0];
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (iArr[i3] < i2) {
                i2 = iArr[i3];
                i = i3;
            }
        }
        return i;
    }

    private int distance(int i, int i2) {
        return Math.abs(i - i2);
    }
}
