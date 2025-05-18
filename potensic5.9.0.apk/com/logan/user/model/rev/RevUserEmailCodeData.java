package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserEmailCodeData extends BaseUserRevData {
    public static final int CODE_MAILBOX_REGISTERED = 2;
    public static final int CODE_MISS_PARAM = 1;
    public static final int CODE_SUCCESS = 0;
    public int emailCodeResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EmailCodeResult {
    }

    public RevUserEmailCodeData parse(int i) {
        this.emailCodeResult = i;
        return this;
    }

    public int getEmailCodeResult() {
        return this.emailCodeResult;
    }
}