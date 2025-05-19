package com.logan.user.view;

/* loaded from: classes3.dex */
public interface ILoginView {
    void onAccountOrPasswordError();

    void onLoginFailed(String str);

    void onLoginSuccess();

    void unregistered();
}
