package com.logan.flight.enums;

import kotlin.Metadata;

/* compiled from: CommonMsgType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/logan/flight/enums/CommonMsgType;", "", "command", "", "param1", "(Ljava/lang/String;IBB)V", "getCommand", "()B", "getParam1", "STOP_BEEP", "START_BEEP", "START_IMU_CALIBRATION", "STOP_IMU_CALIBRATION", "GET_GIMBAL_INFO", "ENTER_SWOOP_RETURN", "EXIT_SWOOP_RETURN", "ATTITUDE_MODE_TAKE_OFF", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public enum CommonMsgType {
    STOP_BEEP((byte) 2, (byte) 0),
    START_BEEP((byte) 2, (byte) 2),
    START_IMU_CALIBRATION((byte) 6, (byte) 1),
    STOP_IMU_CALIBRATION((byte) 6, (byte) 0),
    GET_GIMBAL_INFO((byte) 8, (byte) 0),
    ENTER_SWOOP_RETURN((byte) 9, (byte) 1),
    EXIT_SWOOP_RETURN((byte) 9, (byte) 2),
    ATTITUDE_MODE_TAKE_OFF((byte) 10, (byte) 1);

    private final byte command;
    private final byte param1;

    CommonMsgType(byte b, byte b2) {
        this.command = b;
        this.param1 = b2;
    }

    public final byte getCommand() {
        return this.command;
    }

    public final byte getParam1() {
        return this.param1;
    }
}
