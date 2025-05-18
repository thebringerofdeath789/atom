package com.logan.flight.enums;

import kotlin.Metadata;

/* compiled from: GimbalErrorType.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m2338d2 = {"Lcom/logan/flight/enums/GimbalErrorType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "IMU_ERROR", "MOTOR_ERROR", "CALIBRATION_DATA_ERROR", "BOOT_SELF_TEST_STALL", "OPERATION_STALL", "TEMP_HIGH", "Protocols_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes.dex */
public enum GimbalErrorType {
    IMU_ERROR(1),
    MOTOR_ERROR(2),
    CALIBRATION_DATA_ERROR(3),
    BOOT_SELF_TEST_STALL(4),
    OPERATION_STALL(5),
    TEMP_HIGH(16);

    private final int value;

    GimbalErrorType(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}