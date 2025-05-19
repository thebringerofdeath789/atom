package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserProductStatisticsData extends BaseUserRevData {
    public static final int CODE_COMMIT_SUCCESSFULLY = 0;
    public static final int CODE_MISSING_PARAMETERS = 1;
    public static final int CODE_NO_THIS_PRODUCT_CLASS = 3;
    public static final int CODE_SQL_COMMIT_FAIL = 4;
    public static final int CODE_TOKEN_AUTHENTICATION_FAILS = 2;
    public int commitResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface commitResult {
    }

    public RevUserProductStatisticsData init(int i) {
        this.commitResult = i;
        return this;
    }

    public int getCommitResult() {
        return this.commitResult;
    }
}
