package com.logan.user.model;

import com.logan.user.model.rev.BaseUserRevData;

/* loaded from: classes3.dex */
public interface RequestResponseListener {
    void onRequestFailed(int i, Exception exc);

    void onRequestSuccess(int i, BaseUserRevData baseUserRevData);
}