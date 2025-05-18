package com.logan.flight.data.recv;

import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.usb.AOAEngine;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class FlightRevConnectData extends BaseFlightRevData implements Cloneable {
    private int channel;
    private boolean isCameraCtrlConnected;
    private boolean isFlightCtrlConnected;
    private boolean isFpvConnected;
    private boolean isHighDbm;
    private boolean isMiniPairing;
    private boolean isRemoterConnected;
    private boolean isSupportFreqHopping;
    private boolean isWirelessConnected;
    private int rssi;
    private int rssiRange;
    private byte[] data = null;
    private boolean isRemoterOrFpvUpgrade = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.data = bArr;
        byte b = bArr[i];
        this.rssi = b;
        if (b <= 0) {
            this.rssiRange = 0;
        } else if (b <= 10) {
            this.rssiRange = 1;
        } else if (b <= 20) {
            this.rssiRange = 2;
        } else if (b <= 30) {
            this.rssiRange = 3;
        } else if (b <= 100) {
            this.rssiRange = 4;
        }
        this.channel = ParseUtil.getUnsignedByte(bArr[i + 1]);
        byte b2 = bArr[i + 2];
        if (!this.isRemoterOrFpvUpgrade) {
            this.isWirelessConnected = ParseUtil.getBit(b2, 0) == 1;
            this.isFlightCtrlConnected = ParseUtil.getBit(b2, 1) == 1;
        }
        this.isRemoterConnected = ParseUtil.getBit(b2, 2) == 1;
        this.isCameraCtrlConnected = ParseUtil.getBit(b2, 3) == 1;
        this.isFpvConnected = ParseUtil.getBit(b2, 4) == 1;
        this.isHighDbm = ParseUtil.getBit(b2, 5) == 1;
        this.isMiniPairing = ParseUtil.getBit(b2, 6) == 1;
        this.isSupportFreqHopping = ParseUtil.getBit(b2, 7) == 0;
    }

    public int getRssi() {
        return this.rssi;
    }

    public int getRssiRange() {
        return this.rssiRange;
    }

    public int getChannel() {
        return this.channel;
    }

    public boolean isWirelessConnected() {
        return this.isWirelessConnected;
    }

    public boolean isRemoterConnected() {
        return AOAEngine.getInstance().isRunning();
    }

    public boolean isCameraCtrlConnected() {
        return this.isCameraCtrlConnected;
    }

    public boolean isFpvConnected() {
        return this.isFpvConnected;
    }

    public boolean isHighDbm() {
        return this.isHighDbm;
    }

    public boolean isMiniPairing() {
        return this.isMiniPairing;
    }

    public boolean isFlightCtrlConnected() {
        return this.isFlightCtrlConnected;
    }

    public boolean isRemoterOrFpvUpgrade() {
        return this.isRemoterOrFpvUpgrade;
    }

    public void setRemoterOrFpvUpgrade(boolean z) {
        this.isRemoterOrFpvUpgrade = z;
    }

    public boolean isSupportFreqHopping() {
        return this.isSupportFreqHopping;
    }

    public String getLogString() {
        String curTime = FormatUtil.getCurTime();
        if (UsbConfig.isNewFC) {
            int unsignedShortFromByteArr = ParseUtil.getUnsignedShortFromByteArr(this.data, 2) - 3;
            byte[] bArr = this.data;
            return curTime + StringUtils.SPACE + (bArr != null ? ParseUtil.byteToHexString(bArr, UsbConfig.getPayloadIndex(0), unsignedShortFromByteArr) : "data is null") + "\n";
        }
        int unsignedShortFromByteArr2 = ParseUtil.getUnsignedShortFromByteArr(this.data, 2) - 2;
        byte[] bArr2 = this.data;
        return curTime + StringUtils.SPACE + (bArr2 != null ? ParseUtil.byteToHexString(bArr2, UsbConfig.getPayloadIndex(0), unsignedShortFromByteArr2) : "data is null") + "\n";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String toString() {
        return "FlightRevConnectData{信号强度=" + this.rssi + ", 信道=" + this.channel + ", 无线连接状态=" + this.isWirelessConnected + ", 飞控连接状态=" + this.isFlightCtrlConnected + ", 遥控器连接状态=" + this.isRemoterConnected + ", 相机连接状态=" + this.isCameraCtrlConnected + ", 图传连接状态=" + this.isFpvConnected + ", 是否高发射率=" + this.isHighDbm + ", 对码中=" + this.isMiniPairing + '}';
    }
}