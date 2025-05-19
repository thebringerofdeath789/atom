package com.logan.user.view;

/* loaded from: classes3.dex */
public interface IFeedbackView {
    void onFeedbackBeyondMaximum();

    void onFeedbackFailed(String str);

    void onFeedbackSuccess();

    void onFeedbackTokenError();
}
