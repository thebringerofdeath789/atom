package com.logan.user.model.rev;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public class RevUserFbMarkData extends BaseUserRevData {
    public static final int CODE_FB_INFO_ERROR = 2;
    public static final int CODE_FB_MISS_PARAMETERS = 1;
    public static final int CODE_FB_SUCCESS = 0;
    public int feedbackResult;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeedbackResult {
    }

    public RevUserFbMarkData init(int i) {
        this.feedbackResult = i;
        return this;
    }

    public int getFeedbackResult() {
        return this.feedbackResult;
    }
}