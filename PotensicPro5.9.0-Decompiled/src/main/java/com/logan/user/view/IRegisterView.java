package com.logan.user.view;

/* loaded from: classes3.dex */
public interface IRegisterView {
    void onEmailAlreadyUsed();

    void onEmailCodeError();

    void onEmailCodeInvalid();

    void onEmailNotExist();

    void onRegisterError(String str);

    void onRegisterSuccess();
}
