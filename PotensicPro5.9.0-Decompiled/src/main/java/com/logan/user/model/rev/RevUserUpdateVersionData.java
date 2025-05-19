package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserUpdateVersionData extends BaseUserRevData {
    public static final int CODE_COMMIT_FAIL = 4;
    public static final int CODE_MISS_PARAMETERS = 1;
    public static final int CODE_NO_PRODUCT = 3;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_TOKEN_ERROR = 2;
    private int code;

    @Retention(RetentionPolicy.SOURCE)
    private @interface CodeResult {
    }

    public RevUserUpdateVersionData parse(int i) {
        this.code = i;
        return this;
    }

    public int getCode() {
        return this.code;
    }
}
