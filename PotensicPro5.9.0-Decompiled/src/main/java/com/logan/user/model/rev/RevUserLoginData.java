package com.logan.user.model.rev;

import com.ipotensic.baselib.Token;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserLoginData extends BaseUserRevData {
    public static final int CODE_LOGIN_EMAIL_OR_PW_ERROR = 0;
    public static final int CODE_LOGIN_FREQUENTLY = 4;
    public static final int CODE_LOGIN_SUCCESS = 1;
    public static final int CODE_MISS_PARAMETER = 3;
    public static final int CODE_PARAMETERS_ERROR = 2;
    private int resultCode;
    private Token token;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LoginResult {
    }

    public RevUserLoginData init(int i, Token token) {
        this.resultCode = i;
        this.token = token;
        return this;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public Token getToken() {
        return this.token;
    }
}
