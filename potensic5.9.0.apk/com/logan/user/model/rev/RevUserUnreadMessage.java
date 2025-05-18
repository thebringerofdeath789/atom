package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserUnreadMessage extends BaseUserRevData {
    public static final int CODE_RESULT_INFO_ERROR = 2;
    public static final int CODE_RESULT_MISS_PARAMETERS = 1;
    public static final int CODE_RESULT_SUCCESS = 0;
    private int num;
    private int unreadMsgResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnreadMsgResult {
    }

    public RevUserUnreadMessage parse(int i, int i2) {
        this.unreadMsgResult = i;
        this.num = i2;
        return this;
    }

    public int getUnreadMsgResult() {
        return this.unreadMsgResult;
    }

    public int getUnreadNum() {
        return this.num;
    }
}