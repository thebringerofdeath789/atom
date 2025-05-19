package com.logan.user.view;

import com.logan.user.model.rev.RevUserGetFeedbackData;
import java.util.List;

/* loaded from: classes3.dex */
public interface IFbCommitResultView {
    void getFailed();

    void getFeedbackSuccess(List<RevUserGetFeedbackData.FeedbackInfo> list);
}
