package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.enums.NormalCmdType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: FlightRevFlightCtrlToAppNormalData.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\r¨\u0006\u0019"}, m2338d2 = {"Lcom/logan/flight/data/recv/FlightRevFlightCtrlToAppNormalData;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "()V", "command", "Lcom/logan/flight/enums/NormalCmdType;", "getCommand", "()Lcom/logan/flight/enums/NormalCmdType;", "setCommand", "(Lcom/logan/flight/enums/NormalCmdType;)V", "isEnterCalibration", "", "()Z", "setEnterCalibration", "(Z)V", "isQuitCalibration", "setQuitCalibration", "parseData", "", "data", "", "payloadIndex", "", "toString", "", "Companion", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* renamed from: com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormalData, reason: from toString */
/* loaded from: classes.dex */
public final class FlightRevFlightCtrlToAppNormal extends BaseFlightRevData {
    public static final byte ENTER = 1;
    public static final byte QUIT = 2;
    private NormalCmdType command;
    private boolean isEnterCalibration;
    private boolean isQuitCalibration;

    public final NormalCmdType getCommand() {
        return this.command;
    }

    public final void setCommand(NormalCmdType normalCmdType) {
        this.command = normalCmdType;
    }

    /* renamed from: isEnterCalibration, reason: from getter */
    public final boolean getIsEnterCalibration() {
        return this.isEnterCalibration;
    }

    public final void setEnterCalibration(boolean z) {
        this.isEnterCalibration = z;
    }

    /* renamed from: isQuitCalibration, reason: from getter */
    public final boolean getIsQuitCalibration() {
        return this.isQuitCalibration;
    }

    public final void setQuitCalibration(boolean z) {
        this.isQuitCalibration = z;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int payloadIndex) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        NormalCmdType findValue = NormalCmdType.INSTANCE.findValue(ParseUtil.getSignedShortFromByteArr(data, payloadIndex));
        this.command = findValue;
        if (findValue == NormalCmdType.ENTER_QUIT_MAG_CALIBRATION) {
            int i = payloadIndex + 2;
            this.isEnterCalibration = data[i] == 1;
            this.isQuitCalibration = data[i] == 2;
        } else if (this.command == NormalCmdType.MAG_CALIBRATION_TIMEOUT) {
            boolean z = data[payloadIndex + 2] == ((byte) 1);
            this.isEnterCalibration = !z;
            this.isQuitCalibration = z;
        }
    }

    public String toString() {
        return "FlightRevFlightCtrlToAppNormal(command=" + this.command + ", isEnterCalibration=" + this.isEnterCalibration + ", isQuitCalibration=" + this.isQuitCalibration + PropertyUtils.MAPPED_DELIM2;
    }
}