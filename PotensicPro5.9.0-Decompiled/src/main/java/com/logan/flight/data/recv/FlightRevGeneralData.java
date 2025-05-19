package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.enums.GeneralCommand;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.beanutils.PropertyUtils;

/* compiled from: FlightRevGeneralData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/logan/flight/data/recv/FlightRevGeneralData;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "()V", "command", "Lcom/logan/flight/enums/GeneralCommand;", "getCommand", "()Lcom/logan/flight/enums/GeneralCommand;", "setCommand", "(Lcom/logan/flight/enums/GeneralCommand;)V", "imuCalResult", "Lcom/logan/flight/data/recv/FlightRevGeneralData$ImuCalResult;", "getImuCalResult", "()Lcom/logan/flight/data/recv/FlightRevGeneralData$ImuCalResult;", "parseData", "", "data", "", "payloadIndex", "", "toString", "", "ImuCalResult", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevGeneralData extends BaseFlightRevData {
    private GeneralCommand command;
    private final ImuCalResult imuCalResult = new ImuCalResult();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GeneralCommand.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[GeneralCommand.IMU_CAL_RESULT.ordinal()] = 1;
        }
    }

    public final GeneralCommand getCommand() {
        return this.command;
    }

    public final void setCommand(GeneralCommand generalCommand) {
        this.command = generalCommand;
    }

    public final ImuCalResult getImuCalResult() {
        return this.imuCalResult;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int payloadIndex) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        GeneralCommand findCmd = GeneralCommand.INSTANCE.findCmd(ParseUtil.getSignedShortFromByteArr(data, payloadIndex));
        this.command = findCmd;
        if (findCmd == null || findCmd == null || WhenMappings.$EnumSwitchMapping$0[findCmd.ordinal()] != 1) {
            return;
        }
        this.imuCalResult.parse(data, payloadIndex);
    }

    public String toString() {
        return "FlightRevGeneralData(command=" + this.command + ", imuCalResult=" + this.imuCalResult + PropertyUtils.MAPPED_DELIM2;
    }

    /* compiled from: FlightRevGeneralData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b(\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020HH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u001f\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010#\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001a\u0010%\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001a\"\u0004\b&\u0010\u001cR\u001a\u0010'\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010)\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u001a\u0010+\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001a\"\u0004\b,\u0010\u001cR\u001a\u0010-\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR\u001a\u0010/\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001a\u00102\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001a\u00105\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR\u001a\u00108\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR\u001a\u0010;\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0006\"\u0004\b=\u0010\bR\u001a\u0010>\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0006\"\u0004\b@\u0010\b¨\u0006I"}, d2 = {"Lcom/logan/flight/data/recv/FlightRevGeneralData$ImuCalResult;", "", "()V", "acc_raw_x", "", "getAcc_raw_x", "()F", "setAcc_raw_x", "(F)V", "acc_raw_y", "getAcc_raw_y", "setAcc_raw_y", "acc_raw_z", "getAcc_raw_z", "setAcc_raw_z", "gyro_raw_x", "getGyro_raw_x", "setGyro_raw_x", "gyro_raw_y", "getGyro_raw_y", "setGyro_raw_y", "gyro_raw_z", "getGyro_raw_z", "setGyro_raw_z", "isAboveFinish", "", "()Z", "setAboveFinish", "(Z)V", "isBackFinish", "setBackFinish", "isBelowFinish", "setBelowFinish", "isFrontFinish", "setFrontFinish", "isImuCalFailed", "setImuCalFailed", "isImuCalFinish", "setImuCalFinish", "isImuCalStart", "setImuCalStart", "isImuCalTimeout", "setImuCalTimeout", "isLeftFinish", "setLeftFinish", "isRightFinish", "setRightFinish", "offset_x", "getOffset_x", "setOffset_x", "offset_y", "getOffset_y", "setOffset_y", "offset_z", "getOffset_z", "setOffset_z", "scale_x", "getScale_x", "setScale_x", "scale_y", "getScale_y", "setScale_y", "scale_z", "getScale_z", "setScale_z", "parse", "", "data", "", "payloadIndex", "", "toString", "", "Protocols_release"}, k = 1, mv = {1, 1, 15})
    public static final class ImuCalResult {
        private float acc_raw_x;
        private float acc_raw_y;
        private float acc_raw_z;
        private float gyro_raw_x;
        private float gyro_raw_y;
        private float gyro_raw_z;
        private boolean isAboveFinish;
        private boolean isBackFinish;
        private boolean isBelowFinish;
        private boolean isFrontFinish;

        /* renamed from: isImuCalFailed, reason: from kotlin metadata and from toString */
        private boolean 校准失败;

        /* renamed from: isImuCalFinish, reason: from kotlin metadata and from toString */
        private boolean 校准完成;

        /* renamed from: isImuCalStart, reason: from kotlin metadata and from toString */
        private boolean 校准开启;

        /* renamed from: isImuCalTimeout, reason: from kotlin metadata and from toString */
        private boolean 校准超时;
        private boolean isLeftFinish;
        private boolean isRightFinish;
        private float offset_x;
        private float offset_y;
        private float offset_z;
        private float scale_x;
        private float scale_y;
        private float scale_z;

        /* renamed from: isImuCalStart, reason: from getter */
        public final boolean get校准开启() {
            return this.校准开启;
        }

        public final void setImuCalStart(boolean z) {
            this.校准开启 = z;
        }

        /* renamed from: isImuCalFinish, reason: from getter */
        public final boolean get校准完成() {
            return this.校准完成;
        }

        public final void setImuCalFinish(boolean z) {
            this.校准完成 = z;
        }

        /* renamed from: isAboveFinish, reason: from getter */
        public final boolean getIsAboveFinish() {
            return this.isAboveFinish;
        }

        public final void setAboveFinish(boolean z) {
            this.isAboveFinish = z;
        }

        /* renamed from: isBelowFinish, reason: from getter */
        public final boolean getIsBelowFinish() {
            return this.isBelowFinish;
        }

        public final void setBelowFinish(boolean z) {
            this.isBelowFinish = z;
        }

        /* renamed from: isLeftFinish, reason: from getter */
        public final boolean getIsLeftFinish() {
            return this.isLeftFinish;
        }

        public final void setLeftFinish(boolean z) {
            this.isLeftFinish = z;
        }

        /* renamed from: isRightFinish, reason: from getter */
        public final boolean getIsRightFinish() {
            return this.isRightFinish;
        }

        public final void setRightFinish(boolean z) {
            this.isRightFinish = z;
        }

        /* renamed from: isBackFinish, reason: from getter */
        public final boolean getIsBackFinish() {
            return this.isBackFinish;
        }

        public final void setBackFinish(boolean z) {
            this.isBackFinish = z;
        }

        /* renamed from: isFrontFinish, reason: from getter */
        public final boolean getIsFrontFinish() {
            return this.isFrontFinish;
        }

        public final void setFrontFinish(boolean z) {
            this.isFrontFinish = z;
        }

        /* renamed from: isImuCalFailed, reason: from getter */
        public final boolean get校准失败() {
            return this.校准失败;
        }

        public final void setImuCalFailed(boolean z) {
            this.校准失败 = z;
        }

        /* renamed from: isImuCalTimeout, reason: from getter */
        public final boolean get校准超时() {
            return this.校准超时;
        }

        public final void setImuCalTimeout(boolean z) {
            this.校准超时 = z;
        }

        public final float getAcc_raw_x() {
            return this.acc_raw_x;
        }

        public final void setAcc_raw_x(float f) {
            this.acc_raw_x = f;
        }

        public final float getAcc_raw_y() {
            return this.acc_raw_y;
        }

        public final void setAcc_raw_y(float f) {
            this.acc_raw_y = f;
        }

        public final float getAcc_raw_z() {
            return this.acc_raw_z;
        }

        public final void setAcc_raw_z(float f) {
            this.acc_raw_z = f;
        }

        public final float getGyro_raw_x() {
            return this.gyro_raw_x;
        }

        public final void setGyro_raw_x(float f) {
            this.gyro_raw_x = f;
        }

        public final float getGyro_raw_y() {
            return this.gyro_raw_y;
        }

        public final void setGyro_raw_y(float f) {
            this.gyro_raw_y = f;
        }

        public final float getGyro_raw_z() {
            return this.gyro_raw_z;
        }

        public final void setGyro_raw_z(float f) {
            this.gyro_raw_z = f;
        }

        public final float getScale_x() {
            return this.scale_x;
        }

        public final void setScale_x(float f) {
            this.scale_x = f;
        }

        public final float getScale_y() {
            return this.scale_y;
        }

        public final void setScale_y(float f) {
            this.scale_y = f;
        }

        public final float getScale_z() {
            return this.scale_z;
        }

        public final void setScale_z(float f) {
            this.scale_z = f;
        }

        public final float getOffset_x() {
            return this.offset_x;
        }

        public final void setOffset_x(float f) {
            this.offset_x = f;
        }

        public final float getOffset_y() {
            return this.offset_y;
        }

        public final void setOffset_y(float f) {
            this.offset_y = f;
        }

        public final float getOffset_z() {
            return this.offset_z;
        }

        public final void setOffset_z(float f) {
            this.offset_z = f;
        }

        public final void parse(byte[] data, int payloadIndex) {
            Intrinsics.checkParameterIsNotNull(data, "data");
            int i = payloadIndex + 2;
            boolean z = data[i] == ((byte) 8);
            this.校准完成 = z;
            boolean z2 = data[i] == ((byte) 9);
            this.校准失败 = z2;
            boolean z3 = data[i] == ((byte) 10);
            this.校准超时 = z3;
            this.校准开启 = (z || z2 || z3) ? false : true;
            int i2 = payloadIndex + 3;
            this.isAboveFinish = ParseUtil.getBit(data[i2], 0) == 1;
            this.isBelowFinish = ParseUtil.getBit(data[i2], 1) == 1;
            this.isLeftFinish = ParseUtil.getBit(data[i2], 2) == 1;
            this.isRightFinish = ParseUtil.getBit(data[i2], 3) == 1;
            this.isBackFinish = ParseUtil.getBit(data[i2], 4) == 1;
            this.isFrontFinish = ParseUtil.getBit(data[i2], 5) == 1;
            this.acc_raw_x = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 4);
            this.acc_raw_y = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 8);
            this.acc_raw_z = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 12);
            this.gyro_raw_x = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 16);
            this.gyro_raw_y = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 20);
            this.gyro_raw_z = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 24);
            this.scale_x = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 28);
            this.scale_y = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 32);
            this.scale_z = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 36);
            this.offset_x = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 40);
            this.offset_y = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 44);
            this.offset_z = ParseUtil.getFloatFromBytesBig(data, payloadIndex + 48);
        }

        public String toString() {
            return "ImuCalResult(校准开启=" + this.校准开启 + ", 校准完成=" + this.校准完成 + ", isAboveFinish=" + this.isAboveFinish + ", isBelowFinish=" + this.isBelowFinish + ", isLeftFinish=" + this.isLeftFinish + ", isRightFinish=" + this.isRightFinish + ", isBackFinish=" + this.isBackFinish + ", isFrontFinish=" + this.isFrontFinish + ", 校准失败=" + this.校准失败 + ", 校准超时=" + this.校准超时 + ", acc_raw_x=" + this.acc_raw_x + ", acc_raw_y=" + this.acc_raw_y + ", acc_raw_z=" + this.acc_raw_z + ", gyro_raw_x=" + this.gyro_raw_x + ", gyro_raw_y=" + this.gyro_raw_y + ", gyro_raw_z=" + this.gyro_raw_z + ", scale_x=" + this.scale_x + ", scale_y=" + this.scale_y + ", scale_z=" + this.scale_z + ", offset_x=" + this.offset_x + ", offset_y=" + this.offset_y + ", offset_z=" + this.offset_z + PropertyUtils.MAPPED_DELIM2;
        }
    }
}
