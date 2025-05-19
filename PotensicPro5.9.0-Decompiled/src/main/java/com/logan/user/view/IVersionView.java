package com.logan.user.view;

import com.logan.user.model.rev.RevUserAppVersionData;

/* loaded from: classes3.dex */
public interface IVersionView {
    void getInfoError();

    void needToUpdate(RevUserAppVersionData.Version version);
}
