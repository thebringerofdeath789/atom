package com.logan.flight.data.send;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.listeners.IFlightSettingController;

/* loaded from: classes.dex */
public class SendFlightSetData extends BaseSendData implements IFlightSettingController {
    private boolean isAmericaRockerMode;
    private boolean isClockwise;
    private boolean isNewerModeOpen;
    private double lastLatitude;
    private double lastLongitude;
    private int limitDistance;
    private int limitHeight;
    private int returnHeight;
    private int surroundRadius;
    private int surroundSpeed;
    private Integer speedMode = null;
    private boolean isInit = false;

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 3;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 0;
    }

    public void init(FlightRevStateData flightRevStateData) {
    }

    public void init(FlightRevSettingData flightRevSettingData) {
        this.isInit = true;
        this.limitHeight = flightRevSettingData.getLimitHeight();
        this.limitDistance = flightRevSettingData.getLimitDistance();
        this.returnHeight = flightRevSettingData.getReturnHeight();
        this.isNewerModeOpen = flightRevSettingData.isNewerModeOpen();
        this.isAmericaRockerMode = flightRevSettingData.isAmericaRockerMode();
        this.surroundRadius = flightRevSettingData.getSurroundRadius();
        this.lastLatitude = flightRevSettingData.getLastLatitude();
        this.lastLongitude = flightRevSettingData.getLastLongitude();
        this.isClockwise = flightRevSettingData.isClockwise();
        this.surroundSpeed = flightRevSettingData.getSurroundSpeed();
    }

    public boolean isInit() {
        DDLog.e("设置是否初始化:" + this.isInit);
        return this.isInit;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setHeightLimit(int i) {
        DDLog.e("设置高度:" + i);
        this.limitHeight = i;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setDistanceLimit(int i) {
        DDLog.e("设置距离:" + i);
        this.limitDistance = i;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setReturnHeight(int i) {
        DDLog.e("设置返航高度:" + i);
        this.returnHeight = i;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setNewerMode(boolean z) {
        this.isNewerModeOpen = z;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setRockMode(boolean z) {
        this.isAmericaRockerMode = z;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setSurroundRadius(short s) {
        this.surroundRadius = s;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setClockwise(boolean z) {
        this.isClockwise = z;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setSurroundSpeed(int i) {
        this.surroundSpeed = i;
    }

    @Override // com.logan.flight.listeners.IFlightSettingController
    public void setSpeedMode(int i) {
        this.speedMode = Integer.valueOf(i);
    }

    public void finishSpeedSetting() {
        this.speedMode = null;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public byte[] getBytes() {
        int i;
        int i2;
        FlightRevSettingData flightRevSettingData = FlightRevData.get().getFlightRevSettingData();
        if (flightRevSettingData != null && this.isInit) {
            if (flightRevSettingData.isNewFC()) {
                this.payload = new byte[13];
            } else if (flightRevSettingData.getSpeedMode() != -1) {
                this.payload = new byte[11];
            } else {
                this.payload = new byte[10];
            }
            if (flightRevSettingData.isNewFC()) {
                ParseUtil.short2ByteArr((short) this.limitHeight, this.payload, 0);
                i = 2;
            } else {
                this.payload[0] = (byte) this.limitHeight;
                i = 1;
            }
            ParseUtil.short2ByteArr((short) this.limitDistance, this.payload, i);
            int i3 = i + 1 + 1;
            if (flightRevSettingData.isNewFC()) {
                ParseUtil.short2ByteArr((short) this.returnHeight, this.payload, i3);
                i2 = i3 + 1 + 1;
            } else {
                i2 = i3 + 1;
                this.payload[i3] = (byte) this.returnHeight;
            }
            int i4 = i2 + 1;
            this.payload[i2] = (byte) (this.isNewerModeOpen ? 255 : 0);
            int i5 = i4 + 1;
            this.payload[i4] = (byte) (!this.isAmericaRockerMode ? 1 : 0);
            ParseUtil.short2ByteArr((short) this.surroundRadius, this.payload, i5);
            int i6 = i5 + 1 + 1;
            int i7 = i6 + 1;
            this.payload[i6] = this.isClockwise ? (byte) 1 : (byte) 0;
            int i8 = i7 + 1;
            this.payload[i7] = (byte) this.surroundSpeed;
            if (this.payload.length >= 11) {
                if (this.speedMode == null) {
                    FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                    if (flightRevStateData != null) {
                        this.payload[i8] = (byte) flightRevStateData.getSpeedMode();
                    }
                } else {
                    this.payload[i8] = (byte) this.speedMode.intValue();
                }
            }
        }
        return super.getBytes();
    }

    public boolean isSettingChanged() {
        FlightRevSettingData flightRevSettingData;
        if (!this.isInit || (flightRevSettingData = FlightRevData.get().getFlightRevSettingData()) == null) {
            return false;
        }
        DDLog.e("设置 setting before ：" + flightRevSettingData.toString());
        DDLog.e("设置 setting new ：高度限制=" + this.limitHeight + ", 距离限制=" + this.limitDistance + ", 返航高度=" + this.returnHeight + ", 是否新手模式=" + this.isNewerModeOpen + ", 是否美国手=" + this.isAmericaRockerMode + ", 环绕半径=" + this.surroundRadius + ", 最后一次纬度=" + this.lastLatitude + ", 最后一次经度=" + this.lastLongitude + ", 是否顺时针环绕=" + this.isClockwise + ", 环绕速度=" + this.surroundSpeed + ", 速度挡=" + this.speedMode + '}');
        return (this.limitHeight == flightRevSettingData.getLimitHeight() && this.limitDistance == flightRevSettingData.getLimitDistance() && this.returnHeight == flightRevSettingData.getReturnHeight() && this.isNewerModeOpen == flightRevSettingData.isNewerModeOpen() && this.isAmericaRockerMode == flightRevSettingData.isAmericaRockerMode() && this.surroundRadius == flightRevSettingData.getSurroundRadius() && this.lastLatitude == flightRevSettingData.getLastLatitude() && this.lastLongitude == flightRevSettingData.getLastLongitude() && this.isClockwise == flightRevSettingData.isClockwise() && this.surroundSpeed == flightRevSettingData.getSurroundSpeed() && this.speedMode == null) ? false : true;
    }
}
