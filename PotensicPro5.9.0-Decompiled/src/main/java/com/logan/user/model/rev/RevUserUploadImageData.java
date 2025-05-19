package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserUploadImageData extends BaseUserRevData {
    public static final int CODE_NOT_FREQUENTLY_COMMIT = 3;
    public static final int CODE_UPLOAD_FAILED = 0;
    public static final int CODE_UPLOAD_SUCCESS = 1;
    public static final int CODE_UPLOAD_TOKEN_ERROR = 2;
    private int result;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UploadResult {
    }

    public RevUserUploadImageData init(int i) {
        this.result = i;
        return this;
    }

    public int getResultCode() {
        return this.result;
    }
}
