package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserFlightLogData extends BaseUserRevData {
    public static final int CODE_FLIGHT_LOG_FILE_REPEAT = 3;
    public static final int CODE_FLIGHT_LOG_FREQUENTLY = 4;
    public static final int CODE_FLIGHT_LOG_MISSING_FLIES = 5;
    public static final int CODE_FLIGHT_LOG_SOME_MD5_ERROR = 6;
    public static final int CODE_FLIGHT_LOG_SUCCESS = 0;
    public static final int CODE_FLIGHT_LOG_TOKEN_ERROR = 1;
    public static final int CODE_FLIGHT_LOG_UPLOAD_ERROR = 2;
    private int flightLogResult;
    private String msg;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FlightLogResult {
    }

    public RevUserFlightLogData init(int i) {
        this.flightLogResult = i;
        return this;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getFlightLogResult() {
        return this.flightLogResult;
    }
}
