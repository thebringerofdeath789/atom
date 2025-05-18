package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserChangePswData extends BaseUserRevData {
    public static final int CODE_CHANGE_PSW_SUCCESS = 1;
    public static final int CODE_CHANGE_PSW_TOKEN_ERROR = 0;
    public static final int CODE_MISS_PARAMETER = 3;
    public static final int CODE_NEW_PASSWORD_TOO_DIGITS = 5;
    public static final int CODE_OLD_PSW_ERROR = 2;
    public static final int CODE_PARAMETERS_ERROR = 4;
    private int changePswResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChangePswResult {
    }

    public RevUserChangePswData init(int i) {
        this.changePswResult = i;
        return this;
    }

    public int getChangePswResult() {
        return this.changePswResult;
    }
}