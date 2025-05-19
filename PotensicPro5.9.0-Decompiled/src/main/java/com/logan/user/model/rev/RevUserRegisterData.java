package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserRegisterData extends BaseUserRevData {
    public static final int CODE_MISS_PARAMETER = 3;
    public static final int CODE_PARAMETERS_ERROR = 5;
    public static final int CODE_REGISTER_EMAIL_ALREADY_USED = 2;
    public static final int CODE_REGISTER_EMAIL_ERROR = 0;
    public static final int CODE_REGISTER_FREQUENTLY = 6;
    public static final int CODE_REGISTER_SUCCESS = 1;
    public static final int CODE_TOO_FEW_PASSWORD_DIGITS = 4;
    private int result;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterResult {
    }

    public RevUserRegisterData init(int i) {
        this.result = i;
        return this;
    }

    public int getResultCode() {
        return this.result;
    }
}
