package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserFeedbackData extends BaseUserRevData {
    public static final int CODE_FEEDBACK_FAILED = 1;
    public static final int CODE_FEEDBACK_SUCCESS = 0;
    public static final int CODE_FEEDBACK_TOKEN_ERROR = 2;
    public static final int CODE_NOT_BEYOND_MAXIMUM = 5;
    public static final int CODE_NOT_FREQUENTLY_COMMIT = 3;
    public static final int CODE_NOT_MISS_PARAMETER = 4;
    private int feedbackResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeedbackResult {
    }

    public RevUserFeedbackData init(int i) {
        this.feedbackResult = i;
        return this;
    }

    public int getFeedbackResult() {
        return this.feedbackResult;
    }
}