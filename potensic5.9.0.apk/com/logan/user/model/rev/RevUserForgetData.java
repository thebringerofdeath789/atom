package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserForgetData extends BaseUserRevData {
    public static final int CODE_FORGET_EMAIL_ERROR = 0;
    public static final int CODE_FORGET_REQUEST_TIMEOUT = 2;
    public static final int CODE_FORGET_SUCCESS = 1;
    private int forgetResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ForgetResult {
    }

    public RevUserForgetData init(int i) {
        this.forgetResult = i;
        return this;
    }

    public int getForgetResultCode() {
        return this.forgetResult;
    }
}