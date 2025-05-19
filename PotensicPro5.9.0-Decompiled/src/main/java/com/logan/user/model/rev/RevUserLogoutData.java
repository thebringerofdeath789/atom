package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserLogoutData extends BaseUserRevData {
    public static final int CODE_LOGOUT_SUCCESS = 1;
    public static final int CODE_LOGOUT_TOKEN_ERROR = 0;
    private int logoutResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LogoutResult {
    }

    public RevUserLogoutData init(int i) {
        this.logoutResult = i;
        return this;
    }

    public int getLogoutResultCode() {
        return this.logoutResult;
    }
}
