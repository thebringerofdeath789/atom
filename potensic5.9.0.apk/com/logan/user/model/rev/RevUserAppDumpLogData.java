package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserAppDumpLogData extends BaseUserRevData {
    public static final int CODE_FILE_ALREADY_EXISTS = 3;
    public static final int CODE_LOADED_FREQUENTLY = 4;
    public static final int CODE_MISS_FILES = 5;
    public static final int CODE_TOKEN_ERROR = 1;
    public static final int CODE_UPLOADED_FAIL = 2;
    public static final int CODE_UPLOADED_SUCCESS = 0;
    public int uploadedResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface uploadedResult {
    }

    public RevUserAppDumpLogData init(int i) {
        this.uploadedResult = i;
        return this;
    }

    public int getUploadedResult() {
        return this.uploadedResult;
    }
}