package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserEvaluatingData extends BaseUserRevData {
    public static final int CODE_EVALUATING_SUCCESS = 1;
    public static final int CODE_EVALUATING_TOKEN_ERROR = 0;
    private int evaluatingResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EvaluatingResult {
    }

    public RevUserEvaluatingData init(int i) {
        this.evaluatingResult = i;
        return this;
    }

    public int getEvaluatingResult() {
        return this.evaluatingResult;
    }
}