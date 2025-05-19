package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes.dex */
public class SendCalFeedbackData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 23;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 1;
    }

    public void update(MagCalibrationResult magCalibrationResult) {
        if (magCalibrationResult.isCalibrationFinish()) {
            this.payload[0] = ParseUtil.setBit(this.payload[0], 0, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 1, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 2, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 3, 1);
        }
        if (magCalibrationResult.isCalibrationTimeout() || magCalibrationResult.isCalibrationFailed()) {
            this.payload[0] = ParseUtil.setBit(this.payload[0], 0, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 1, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 2, 1);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 3, 0);
        }
        if (magCalibrationResult.isHorizontalCalibration()) {
            this.payload[0] = ParseUtil.setBit(this.payload[0], 0, 1);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 1, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 2, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 3, 0);
        }
        if (magCalibrationResult.isVerticalCalibration()) {
            this.payload[0] = ParseUtil.setBit(this.payload[0], 0, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 1, 1);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 2, 0);
            this.payload[0] = ParseUtil.setBit(this.payload[0], 3, 0);
        }
    }
}
